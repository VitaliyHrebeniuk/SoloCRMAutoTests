package com.ui.ManagerCreateDealFixZid;

import com.ui.BaseTest;
import com.ui.pages.ManagerCreateDealFixZid.ManagerApproveDeal.DealPageM;
import com.ui.pages.ManagerCreateDealFixZid.ManagerApproveDeal.DealsListPageM;
import com.ui.pages.ManagerCreateDealFixZid.ManagerApproveDeal.MainPageM;
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
    final String URL = "https://test-api.solo-crm.com/";
    private String manager2FaCode;

    @BeforeTest
    public void setToken() {
        GenerateUserTokenWith2FaForManagerUI generateUserTokenWith2FaForManager = new GenerateUserTokenWith2FaForManagerUI();
        this.managerTokenWith2FA = generateUserTokenWith2FaForManager.set2faForAccount();
        this.manager2FaCode = generateUserTokenWith2FaForManager.manager2FaCode;
    }
    @Test
    public void addPayment() {
        new LoginManagerPage(webDriver, "https://test.solo-crm.com/#/login")
                .inputLogin("")
                .inputPassword("")
                .clickOnSignInButton()
                .inputAuthCode(manager2FaCode)
                .clickOnSendCodeButton();
        new MainPageM(webDriver)
                .clickOnPartnersButton()
                .clickOnDealsListButton();
        new DealsListPageM(webDriver)
                .clickOnStartDateSort()
                .clickOnOpenDealButton();
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
