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
    final String URL = "https://beta-api.solo-crm.com/";
    private String teamLead2FaCode;

    @BeforeTest
    public void setDriver() {
        GenerateUserTokenWith2FaForTeamLeadUI generateUserTokenWith2FaForTeamLead = new GenerateUserTokenWith2FaForTeamLeadUI();
        this.teamLeadTokenWith2FA = generateUserTokenWith2FaForTeamLead.set2faForAccount();
        this.teamLead2FaCode = generateUserTokenWith2FaForTeamLead.teamLead2FaCode;
    }
    @Test
    public void teamLeadApprove() {
        /**
         * Вводим логин, вводим пароль, нажимаем на Sign In,
         * вводим код аутентификации, нажимаем на Send Code.
         */
        new LoginPageTLead(webDriver, "https://beta.solo-crm.com/#/login")
                .inputLogin("")
                .inputPassword("")
                .clickOnSignInButton()
                .inputAuthCode(teamLead2FaCode)
                .clickOnSendCodeButton();
        /**
         * Нажимаем на Partners, нажимаем на Deals list.
         */
        new MainPageTLead(webDriver)
                .clickOnPartnersButton()
                .clickOnDealsListButton();
        /**
         * Нажимаем на сортировку по Start Date, нажимаем на открытие сделки.
         */
        new DealsListPageTLead(webDriver)
                .clickOnStartDateSort()
                .clickOnOpenDealButton();
        /**
         * Нажимаем на аппрув платежа, нажимаем на профиль, выходим с профиля.
         */
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
