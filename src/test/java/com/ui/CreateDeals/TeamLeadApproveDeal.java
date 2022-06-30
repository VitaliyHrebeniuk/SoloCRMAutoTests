package com.ui.CreateDeals;

import com.ui.BaseTest;
import com.ui.pages.Teamlead.DealPageTLead;
import com.ui.pages.Teamlead.DealsListPageTLead;
import com.ui.pages.Teamlead.LoginPageTLead;
import com.ui.pages.Teamlead.MainPageTLead;
import com.ui.token2Fa.GenerateUserTokenWith2FaForTeamLeadUI;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.*;

public class TeamLeadApproveDeal extends BaseTest {
    String teamLeadTokenWith2FA;
    RequestSpecification request = RestAssured.given();
    private String teamLead2FaCode;

    @BeforeClass
    public void setDriver() {
        GenerateUserTokenWith2FaForTeamLeadUI generateUserTokenWith2FaForTeamLead = new GenerateUserTokenWith2FaForTeamLeadUI();
        this.teamLeadTokenWith2FA = generateUserTokenWith2FaForTeamLead.set2faForAccount();
        this.teamLead2FaCode = generateUserTokenWith2FaForTeamLead.teamLead2FaCode;
    }
    @Test
    public void teamLeadApprove() throws InterruptedException {
        /**
         * Вводим логин, вводим пароль, нажимаем на Sign In,
         * вводим код аутентификации, нажимаем на Send Code.
         */
        new LoginPageTLead(webDriver, baseURL)
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
         * Нажимаем на блок Deal payments
         * Нажимаем на аппрув платежа, нажимаем на профиль, выходим с профиля.
         */
        new DealPageTLead(webDriver)
                .clickOnDealPaymentsBlockButton()
                .clickOnApprovePaymentButton()
                .clickOnProfileButton()
                .clickOnExitButton();
    }
    @AfterClass
    public void QuitDriver(){
        request
                .headers("token", teamLeadTokenWith2FA)
                .post(apiURL + "security/status/disable/" + teamLead2FaCode)
                .then()
                .assertThat()
                .statusCode(200);
    }
}
