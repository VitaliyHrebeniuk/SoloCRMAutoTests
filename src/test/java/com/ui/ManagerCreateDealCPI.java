package com.ui;

import com.ui.pages.ManagerCreateDealCPI.DealPageCPI;
import com.ui.pages.ManagerCreateDealFixZid.ManagerCreateDeal.LoginManagerPage;
import com.ui.pages.ManagerCreateDealFixZid.ManagerCreateDeal.MainPage;
import com.ui.pages.ManagerCreateDealFixZid.ManagerCreateDeal.PartnersListPage;
import com.ui.token2Fa.GenerateUserTokenWith2FaForManagerUI;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ManagerCreateDealCPI extends BaseTest{
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
    public void createDealCPI() {
        new LoginManagerPage(webDriver, "https://test.solo-crm.com/#/login")
                .inputLogin("")
                .inputPassword("")
                .clickOnSignInButton()
                .inputAuthCode(manager2FaCode)
                .clickOnSendCodeButton();
        new MainPage(webDriver)
                .clickOnPartnersButton()
                .clickOnPartnersListButton();
        new PartnersListPage(webDriver)
                .inputPartnersId("")
                .clickOnAddDealButton()
                .clickOnCPIButton();
        new DealPageCPI(webDriver)
                .clickOnSiteOverviewBlock()
                .inputLink("")
                .clickOnAddLinkButton()
                .clickOnCostPerInstallBlock()
                .clickOnSetCostButton()
                .inputSelectCountry("")
                .inputCost("")
                .clickOnSaveCostButton()
                .clickOnDealPlacesBlock()
                .inputSearchSite("")
                .clickOnAddDealPlaceButton()
                .inputSelectPlace("")
                .inputPlatform("")
                .inputLabel("")
                .inputGEO("")
                .clickOnSaveDealPlaceButton()
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
