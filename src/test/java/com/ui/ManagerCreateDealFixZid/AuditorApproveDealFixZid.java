package com.ui.ManagerCreateDealFixZid;

import com.ui.BaseTest;
import com.ui.pages.ManagerCreateDealFixZid.AuditorApproveDeal.LoginPageAuditor;
import com.ui.pages.ManagerCreateDealFixZid.AuditorApproveDeal.MainPageAuditor;
import com.ui.pages.ManagerCreateDealFixZid.AuditorApproveDeal.PaymentsListPageAuditor;
import com.ui.token2Fa.GenerateUserTokenWith2FaForAuditorUI;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AuditorApproveDealFixZid extends BaseTest {
    String auditorTokenWith2FA;
    RequestSpecification request = RestAssured.given();
    final String URL = "https://beta-api.solo-crm.com/";
    private String auditor2FaCode;

    @BeforeTest
    public void setDriver() {
        GenerateUserTokenWith2FaForAuditorUI generateUserTokenWith2FaForAuditor = new GenerateUserTokenWith2FaForAuditorUI();
        this.auditorTokenWith2FA = generateUserTokenWith2FaForAuditor.set2faForAccount();
        this.auditor2FaCode = generateUserTokenWith2FaForAuditor.auditor2FaCode;
    }
    @Test
    public void auditorApprove() {
        /**
         * Вводим логин, вводим пароль, нажимаем на Sign In,
         * вводим код аутентификации, нажимаем на Send Code.
         */
        new LoginPageAuditor(webDriver, "https://beta.solo-crm.com/#/login")
                .inputLogin("")
                .inputPassword("")
                .clickOnSignInButton()
                .inputAuthCode(auditor2FaCode)
                .clickOnSendCodeButton();
        /**
         * Нажимаем на Partners, нажимаем на Partners list.
         */
        new MainPageAuditor(webDriver)
                .clickOnPartnersButton()
                .clickOnPaymentsListButton();
        /**
         * Нажимаем на чекбокс, нажимаем на approve payment,
         * нажимаем на профиль, выходим с профиля.
         */
        new PaymentsListPageAuditor(webDriver)
                .clickOnCheckboxButton()
                .clickOnApprovePaymentButton()
                .clickOnProfileButton()
                .clickOnExitButton();
    }
    @AfterTest
    public void QuitDriver(){
        request
                .headers("token", auditorTokenWith2FA)
                .post(URL + "/security/status/disable/" + auditor2FaCode)
                .then()
                .assertThat()
                .statusCode(200);
    }
}
