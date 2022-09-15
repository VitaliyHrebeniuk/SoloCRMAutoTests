package com.ui.CreateDeals;

import com.ui.BaseTest;
import com.ui.pages.Auditor.LoginPageAuditor;
import com.ui.pages.Auditor.MainPageAuditor;
import com.ui.pages.Auditor.PaymentsListPageAuditor;
import com.ui.token2Fa.GenerateUserTokenWith2FaForAuditorUI;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.*;

public class AuditorApproveDeal extends BaseTest {
    String auditorTokenWith2FA;
    RequestSpecification request = RestAssured.given();
    private String auditor2FaCode;

    @BeforeMethod
    public void setDriver() {
        GenerateUserTokenWith2FaForAuditorUI generateUserTokenWith2FaForAuditor = new GenerateUserTokenWith2FaForAuditorUI();
        this.auditorTokenWith2FA = generateUserTokenWith2FaForAuditor.set2faForAccount();
        this.auditor2FaCode = generateUserTokenWith2FaForAuditor.auditor2FaCode;
    }
    @Test
    public void auditorApprove() throws InterruptedException {
        /**
         * Вводим логин, вводим пароль, нажимаем на Sign In,
         * вводим код аутентификации, нажимаем на Send Code.
         */
        new LoginPageAuditor(webDriver, baseURL)
                .inputLogin("")
                .inputPassword("")
                .clickOnSignInButton()
                .inputAuthCode(auditor2FaCode)
                .clickOnSendCodeButton();
        /**
         * Нажимаем на Payments
         */
        new MainPageAuditor(webDriver)
                .clickOnPaymentsListButton();
        /**
         * Вводим кошелек, Нажимаем на чекбокс, нажимаем на approve payment,
         * нажимаем на профиль, выходим с профиля.
         */
        new PaymentsListPageAuditor(webDriver)
                .inputWallet("")
                .clickOnCheckboxButton()
                .clickOnApprovePaymentButton()
                .clickOnProfileButton()
                .clickOnExitButton();
    }
    @AfterMethod
    public void QuitDriver(){
        request
                .headers("token", auditorTokenWith2FA)
                .post(apiURL + "security/status/disable/" + auditor2FaCode)
                .then()
                .assertThat()
                .statusCode(200);
    }
}
