package com.ui;

import com.ui.pages.BaseURL;
import com.ui.pages.ManagerCreateDealFixZid.ManagerCreateDeal.LoginManagerPage;
import com.ui.pages.ManagerCreateDealFixZid.ManagerCreateDeal.MainPage;
import com.ui.pages.ManagerCreateDealFixZid.ManagerCreateDeal.PartnersListPage;
import com.ui.pages.ManagerCreateDealOffline.AddOfflineDealPage;
import com.ui.pages.ManagerCreateDealOffline.DealPageOffline;
import com.ui.token2Fa.GenerateUserTokenWith2FaForManagerUI;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class ManagerCreateDealOffline extends BaseTest {
    String managerTokenWith2FA;
    RequestSpecification request = RestAssured.given();
    private String manager2FaCode;
    BaseURL baseURL = new BaseURL();
    final String bURL = baseURL.baseURL;
    final String URL = baseURL.apiURL;

    @BeforeTest
    public void setToken() {
        GenerateUserTokenWith2FaForManagerUI generateUserTokenWith2FaForManager = new GenerateUserTokenWith2FaForManagerUI();
        this.managerTokenWith2FA = generateUserTokenWith2FaForManager.set2faForAccount();
        this.manager2FaCode = generateUserTokenWith2FaForManager.manager2FaCode;
    }
    @Test
    public void createDealFixApp() {
        new LoginManagerPage(webDriver, bURL)
                .inputLogin("")
                .inputPassword("")
                .clickOnSignInButton()
                .inputAuthCode(manager2FaCode)
                .clickOnSendCodeButton();
        new MainPage(webDriver)
                .clickOnPartnersButton()
                .clickOnPartnersListButton();
        new PartnersListPage(webDriver)
                .clickOnOfflineButton()
                //.inputOfflinePartnersId("")
                .clickOnAddOfflineDealButton();
        new AddOfflineDealPage(webDriver)
                .inputCountry("")
                .inputTypes("")
                .clickOnSaveButton();
        new DealPageOffline(webDriver)
                .inputAttachContract("")
                .inputPartnerLink("")
                .inputContractName("")
                .clickOnAddFormatButton()
                .inputStartDate("")
                .inputEndDate("")
                .inputSelectPlace("")
                .inputVolumePerMonth("")
                .inputNumbers("")
                .inputTotalVolume("")
                .inputCost("")
                .clickOnSaveFormatButton()
                .inputContractResults("")
                .clickOnSaveResultsButton()
                .clickOnNewPaymentButton()
                .inputContractId("")
                .inputBookkeepingType("")
                .inputStartDatePayment("")
                .inputEndDatePayment("")
                .inputWalletName("")
                .inputCostPayment("")
                .clickOnSavePaymentButton()
                .clickOnSaveDealButton()
                .clickOnSendOnReviewButton()
                .clickOnProfileButton()
                .clickOnExitButton();
    }
    @AfterTest
    public void ResetCode() {
        request
                .headers("token", managerTokenWith2FA)
                .post(URL + "security/status/disable/" + manager2FaCode)
                .then()
                .assertThat()
                .statusCode(200);
    }
}
