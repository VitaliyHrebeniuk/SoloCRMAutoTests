package com.ui.CreateDeals.CPI;

import com.ui.BaseTest;
import com.ui.pages.Manager.*;
import com.ui.token2Fa.GenerateUserTokenWith2FaForManagerUI;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ManagerApproveDealCPI extends BaseTest {
    String managerTokenWith2FA;
    RequestSpecification request = RestAssured.given();
    private String manager2FaCode;

    @BeforeMethod
    public void setToken() {
        GenerateUserTokenWith2FaForManagerUI generateUserTokenWith2FaForManager = new GenerateUserTokenWith2FaForManagerUI();
        this.managerTokenWith2FA = generateUserTokenWith2FaForManager.set2faForAccount();
        this.manager2FaCode = generateUserTokenWith2FaForManager.manager2FaCode;
    }
    @Test
    public void addPaymentInCPI() throws InterruptedException {
        /**
         * Вводим логин, вводим пароль, нажимаем на Sign In,
         * вводим код аутентификации, нажимаем на Send Code.
         */
        new LoginPageManager(webDriver, baseURL)
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
         * Вводим тип сделки CPI, вводим статус сделки
         * Нажимаем на сортировку по Start Date, нажимаем на открытие сделки.
         */
        new DealsListPageManager(webDriver)
                .inputDealTypeCPI("")
                .inputDealStatus("")
                .clickOnStartDateSort()
                .clickOnOpenDealCPIButton();
        new DealPageCPI(webDriver)
                /**
                 * Deal payments
                 * Нажимаем на блок Deal Payments
                 * Deal contract
                 * Нажимаем на New contract
                 * Вводим contract name
                 * вводим Start date
                 * вводим End date
                 * прикрепляем файл
                 * сохраняем контракт
                 * проверить добавление контракта по Name
                 */
                .clickOnDealPaymentsBlockButton()
                .clickOnNewContractButton()
                .inputContractName("")
                .inputStartDateInContract("")
                .inputEndDateInContract("")
                .inputAttachFile("")
                .clickOnSaveContractButton()
                .assertContractName()
                /**
                 * нажимаем на New Payment,
                 * вводим Start date,
                 * вводим End date,
                 * вводим Payment target,
                 * вводим Type,
                 * вводим Wallet,
                 * вводим Cost,
                 * добавить коммент
                 * сохраняем Payment,
                 * проверяем что создался платеж по Wallet
                 * нажимаем на аппрув Payment.
                 * нажимаем на профиль,
                 * выходим с профиля.
                 */
                .clickOnNewPaymentButton()
                .inputStartDateInPayment("")
                .inputEndDateInPayment("")
                .inputPaymentTarget("")
                .inputType("")
                .inputWallet("")
                .inputCostInPayment("")
                .inputCommentInPayment("")
                .clickOnSavePaymentButton()
                .assertPayment()
                .clickOnApprovePaymentButton()
                .clickOnProfileButton()
                .clickOnExitButton();
    }
    @AfterMethod
    public void QuitDriver() {
        request
                .headers("token", managerTokenWith2FA)
                .post(apiURL + "security/status/disable/" + manager2FaCode)
                .then()
                .assertThat()
                .statusCode(200);
    }
}
