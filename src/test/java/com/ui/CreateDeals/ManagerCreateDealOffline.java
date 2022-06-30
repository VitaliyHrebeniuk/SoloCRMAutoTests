package com.ui.CreateDeals;

import com.ui.BaseTest;
import com.ui.pages.Manager.LoginPageManager;
import com.ui.pages.Manager.MainPageManager;
import com.ui.pages.Manager.PartnersListPageManager;
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

    @BeforeTest
    public void setToken() {
        GenerateUserTokenWith2FaForManagerUI generateUserTokenWith2FaForManager = new GenerateUserTokenWith2FaForManagerUI();
        this.managerTokenWith2FA = generateUserTokenWith2FaForManager.set2faForAccount();
        this.manager2FaCode = generateUserTokenWith2FaForManager.manager2FaCode;
    }
    @Test
    public void createDealFixApp() {
        new LoginPageManager(webDriver, baseURL)
                .inputLogin("")
                .inputPassword("")
                .clickOnSignInButton()
                .inputAuthCode(manager2FaCode)
                .clickOnSendCodeButton();
        new MainPageManager(webDriver)
                .clickOnPartnersButton()
                .clickOnPartnersListButton();
        new PartnersListPageManager(webDriver)
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
                .post(apiURL + "security/status/disable/" + manager2FaCode)
                .then()
                .assertThat()
                .statusCode(200);
    }
}
