package com.ui.ManagerCreateDealFixZid;

import com.ui.BaseTest;
import com.ui.pages.ManagerCreateDealFixZid.ManagerApproveDeal.DealPageM;
import com.ui.pages.ManagerCreateDealFixZid.ManagerApproveDeal.DealsListPageManager;
import com.ui.pages.ManagerCreateDealFixZid.ManagerApproveDeal.MainPageManager;
import com.ui.pages.ManagerCreateDealFixZid.ManagerCreateDeal.LoginManagerPage;
import com.ui.token2Fa.GenerateUserTokenWith2FaForManagerUI;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ManagerApproveDeal extends BaseTest {
    String managerTokenWith2FA;
    RequestSpecification request = RestAssured.given();
    final String URL = "https://beta-api.solo-crm.com/";
    private String manager2FaCode;

    @BeforeTest
    public void setToken() {
        GenerateUserTokenWith2FaForManagerUI generateUserTokenWith2FaForManager = new GenerateUserTokenWith2FaForManagerUI();
        this.managerTokenWith2FA = generateUserTokenWith2FaForManager.set2faForAccount();
        this.manager2FaCode = generateUserTokenWith2FaForManager.manager2FaCode;
    }
    @Test
    public void addPayment() throws InterruptedException {
        /**
         * Вводим логин, вводим пароль, нажимаем на Sign In,
         * вводим код аутентификации, нажимаем на Send Code.
         */
        new LoginManagerPage(webDriver, "https://beta.solo-crm.com/#/login")
                .inputLogin("")
                .inputPassword("")
                .clickOnSignInButton()
                .inputAuthCode(manager2FaCode)
                .clickOnSendCodeButton();
        /**
         * Нажимаем на Partners, нажимаем на Deals list.
         */
        new MainPageManager(webDriver)
                .clickOnPartnersButton()
                .clickOnDealsListButton();
        /**
         * Нажимаем на сортировку по Start Date, нажимаем на открытие сделки.
         */
        new DealsListPageManager(webDriver)
                .clickOnStartDateSort()
                .clickOnOpenDealButton();
        /**
         * Deal contract
         * Добавить контракт!!
         * проверить добавление контракта по Name!!
         * Deal payments
         * Нажимаем на блок Deal Payments,
         * нажимаем на New Payment,
         * вводим Start date,
         * вводим End date,
         * вводим Payment target,
         * вводим Type,
         * вводим Wallet,
         * вводим Cost,
         * добавить коммент!!
         * нажимаем на Continue,
         * вводим remaining cost,
         * вводим Remaining zid cost,
         * сохраняем Payment,
         * проверяем что создался платеж по комменту!!
         * нажимаем на аппрув Payment.
         * нажимаем на профиль,
         * выходим с профиля.
         */
        new DealPageM(webDriver)
                .clickOnDealPaymentsBlockButton()
                .clickOnNewPaymentButton()
                .inputStartDate("")
                .inputEndDate("")
                .inputPaymentTarget("")
                .inputType("")
                .inputWallet("")
                .inputCost("")
                .clickOnContinueButton()
                .inputRemainingCost("")
                .inputRemainingZidCost("")
                .clickOnSavePaymentButton()
                .clickOnApprovePaymentButton()
                .clickOnProfileButton()
                .clickOnExitButton();
    }
    @AfterTest
    public void QuitDriver() {
        request
                .headers("token", managerTokenWith2FA)
                .post(URL + "security/status/disable/" + manager2FaCode)
                .then()
                .assertThat()
                .statusCode(200);
    }
}
