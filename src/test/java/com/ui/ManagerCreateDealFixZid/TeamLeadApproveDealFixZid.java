package com.ui.ManagerCreateDealFixZid;

import com.ui.BaseTest;
import com.ui.pages.ManagerCreateDealFixZid.TeamLeadApproveDeal.DealPageTLead;
import com.ui.pages.ManagerCreateDealFixZid.TeamLeadApproveDeal.DealsListPageTLead;
import com.ui.pages.ManagerCreateDealFixZid.TeamLeadApproveDeal.LoginPageTLead;
import com.ui.pages.ManagerCreateDealFixZid.TeamLeadApproveDeal.MainPageTLead;
import com.ui.token2Fa.GenerateUserTokenWith2FaForTeamLeadUI;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TeamLeadApproveDealFixZid extends BaseTest {
    String teamLeadTokenWith2FA;
    RequestSpecification request = RestAssured.given();
    final String URL = "https://test-api.solo-crm.com/";
    private String teamLead2FaCode;

    @BeforeTest
    public void setDriver() {
        GenerateUserTokenWith2FaForTeamLeadUI generateUserTokenWith2FaForTeamLead = new GenerateUserTokenWith2FaForTeamLeadUI();
        this.teamLeadTokenWith2FA = generateUserTokenWith2FaForTeamLead.set2faForAccount();
        this.teamLead2FaCode = generateUserTokenWith2FaForTeamLead.teamLead2FaCode;
    }
    @Test
    public void teamLeadApprove() {
        new LoginPageTLead(webDriver, "https://test.solo-crm.com/#/login")
                .inputLogin("")
                .inputPassword("")
                .clickOnSignInButton()
                .inputAuthCode(teamLead2FaCode)
                .clickOnSendCodeButton();
        new MainPageTLead(webDriver)
                .clickOnPartnersButton()
                .clickOnDealsListButton();
        new DealsListPageTLead(webDriver)
                .clickOnStartDateSort()
                .clickOnOpenDealButton();
        new DealPageTLead(webDriver)
                .clickOnApprovePaymentButton()
                .clickOnProfileButton()
                .clickOnExitButton();
    }
    @AfterTest
    public void QuitDriver(){
        request
                .headers("token", teamLeadTokenWith2FA)
                .post(URL + "security/status/disable/" + teamLead2FaCode)
                .then()
                .assertThat()
                .statusCode(200);
    }
}
