package com.ui.CreateDeals;

import com.ui.BaseTest;
import com.ui.pages.BuyingControl.DealPageBControl;
import com.ui.pages.BuyingControl.DealsListPageBControl;
import com.ui.pages.BuyingControl.LoginPageBControl;
import com.ui.pages.BuyingControl.MainPageBControl;
import com.ui.token2Fa.GenerateUserTokenWith2FaForBuyingControlUI;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.*;

public class BuyingControlApproveDeal extends BaseTest {
    String buyingControlTokenWith2FA;
    RequestSpecification request = RestAssured.given();
    private String buyingControl2FaCode;

    @BeforeClass
    public void setDriver() {
        GenerateUserTokenWith2FaForBuyingControlUI generateUserTokenWith2FaForBuyingControlUI = new GenerateUserTokenWith2FaForBuyingControlUI();
        this.buyingControlTokenWith2FA = generateUserTokenWith2FaForBuyingControlUI.set2faForAccount();
        this.buyingControl2FaCode = generateUserTokenWith2FaForBuyingControlUI.buyingControl2FaCode;
    }
    @Test
    public void bControlApprove() throws InterruptedException {
        /**
         * Вводим логин, вводим пароль, нажимаем на Sign In,
         * вводим код аутентификации, нажимаем на Send Code.
         */
        new LoginPageBControl(webDriver, baseURL)
                .inputLogin("")
                .inputPassword("")
                .clickOnSignInButton()
                .inputAuthCode(buyingControl2FaCode)
                .clickOnSendCodeButton();
        /**
         * Нажимаем на Partners, нажимаем на Deals list.
         */
        new MainPageBControl(webDriver)
                .clickOnPartnersButton()
                .clickOnDealsListButton();
        /**
         * Нажимаем на сортировку по Start Date, нажимаем на открытие сделки.
         */
        new DealsListPageBControl(webDriver)
                .clickOnStartDateSort()
                .clickOnOpenDealButton();
        /**
         * Нажимаем на Revision, нажимаем на профиль, выходим с профиля.
         */
        new DealPageBControl(webDriver)
                .clickOnRevisionButton()
                .clickOnProfileButton()
                .clickOnExitButton();
    }
    @AfterClass
    public void QuitDriver() {
        request
                .headers("token", buyingControlTokenWith2FA)
                .post(apiURL + "security/status/disable/" + buyingControl2FaCode)
                .then()
                .assertThat()
                .statusCode(200);
    }
}
