package com.ui;

import com.ui.pages.ManagerCreateDealB2B.DealPageB2B;
import com.ui.pages.ManagerCreateDealFixZid.ManagerCreateDeal.LoginManagerPage;
import com.ui.pages.ManagerCreateDealFixZid.ManagerCreateDeal.MainPage;
import com.ui.pages.ManagerCreateDealFixZid.ManagerCreateDeal.PartnersListPage;
import com.ui.token2Fa.GenerateUserTokenWith2FaForManagerUI;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ManagerCreateDealB2B extends BaseTest{
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
    public void createDealB2B() {
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
                .clickOnB2bButton();
        new DealPageB2B(webDriver)
                .clickOnSiteOverviewBlock()
                .clickOnSearchLinkButton()
                .inputLink("")
                .clickOnAddLinkButton()
                .clickOnAddFormatButton()
                .inputSelectPlace("")
                .inputCost("")
                .inputCPM("")
                .inputTrafficVolume("")
                .clickOnSaveFormatButton()
                .clickOnDealZidsBlock()
                .clickOnAddZidCidButton()
                .inputSite("")
                .inputZidCidValue("")
                .inputSelectPlaceZidCid("")
                .inputLabel("")
                .inputTrafficChannel("")
                .clickOnSaveZidCidButton()
                .clickOnDealPlacesBlock()
                .inputSearchSiteById("")
                .clickOnAddNewDealPlaceButton()
                .inputSelectPlaceNewDealPlace("")
                .inputLabelNewDealPlace("")
                .inputGEO("")
                .inputLinkPp("")
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
