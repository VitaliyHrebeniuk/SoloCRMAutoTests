package com.ui.ManagerCreateDealFixZid;

import com.ui.BaseTest;
import com.ui.pages.ManagerCreateDealFixZid.BuyingControlApproveDeal.DealPageBControl;
import com.ui.pages.ManagerCreateDealFixZid.BuyingControlApproveDeal.DealsListPageBControl;
import com.ui.pages.ManagerCreateDealFixZid.BuyingControlApproveDeal.LoginPageBControl;
import com.ui.pages.ManagerCreateDealFixZid.BuyingControlApproveDeal.MainPageBControl;
import com.ui.token2Fa.GenerateUserTokenWith2FaForBuyingControlUI;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BuyingControlApproveDealFixZid extends BaseTest {
    String buyingControlTokenWith2FA;
    RequestSpecification request = RestAssured.given();
    final String URL = "https://beta-api.solo-crm.com/";
    private String buyingControl2FaCode;

    @BeforeTest
    public void setDriver() {
        GenerateUserTokenWith2FaForBuyingControlUI generateUserTokenWith2FaForBuyingControlUI = new GenerateUserTokenWith2FaForBuyingControlUI();
        this.buyingControlTokenWith2FA = generateUserTokenWith2FaForBuyingControlUI.set2faForAccount();
        this.buyingControl2FaCode = generateUserTokenWith2FaForBuyingControlUI.buyingControl2FaCode;
    }
    @Test
    public void bControlApprove() {
        /**
         * Вводим логин, вводим пароль, нажимаем на Sign In,
         * вводим код аутентификации, нажимаем на Send Code.
         */
        new LoginPageBControl(webDriver, "https://beta.solo-crm.com/#/login")
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
    @AfterTest
    public void QuitDriver() {
        request
                .headers("token", buyingControlTokenWith2FA)
                .post(URL + "security/status/disable/" + buyingControl2FaCode)
                .then()
                .assertThat()
                .statusCode(200);
    }
}
