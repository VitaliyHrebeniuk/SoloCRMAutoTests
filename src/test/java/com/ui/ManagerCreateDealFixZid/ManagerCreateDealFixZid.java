package com.ui.ManagerCreateDealFixZid;

import com.ui.BaseTest;
import com.ui.pages.ManagerCreateDealFixZid.ManagerCreateDeal.*;
import com.ui.token2Fa.GenerateUserTokenWith2FaForManagerUI;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ManagerCreateDealFixZid extends BaseTest {
    String managerTokenWith2FA;
    RequestSpecification request = RestAssured.given();
    private String manager2FaCode;
//    BaseURL baseURL = new BaseURL();
//    final String URL = baseURL.apiURL;
//    final String bURL = baseURL.baseURL;

    @BeforeTest
    public void setToken() {
        GenerateUserTokenWith2FaForManagerUI generateUserTokenWith2FaForManager = new GenerateUserTokenWith2FaForManagerUI();
        this.managerTokenWith2FA = generateUserTokenWith2FaForManager.set2faForAccount();
        this.manager2FaCode = generateUserTokenWith2FaForManager.manager2FaCode;
    }

    @Test
    public void createDealFixZid() {
        /**
         * Вводим логин, вводим пароль, нажимаем на Sign In,
         * вводим код аутентификации, нажимаем на Send Code.
         */
        new LoginManagerPage(webDriver, baseURL)
                .inputLogin("")
                .inputPassword("")
                .clickOnSignInButton()
                .inputAuthCode(manager2FaCode)
                .clickOnSendCodeButton();
        /**
         * Нажимаем на Partners, нажимаем на Partners list.
         */
        new MainPage(webDriver)
                .clickOnPartnersButton()
                .clickOnPartnersListButton();
        /**
         * Вводим Partners ID, нажимаем на добавление сделки, нажимаем на Fix Zid сделку.
         */
        new PartnersListPage(webDriver)
                .inputPartnersId("")
                .clickOnAddDealButton()
                .clickOnZidCidButton();
        new DealPage(webDriver)
                .clickOnSiteOverviewBlock()
                .inputLink("")
                .clickOnAddSiteLinkButton()
                .clickOnSitePlaceField()
                .clickOnAddLinkButton();
        new AddLinkPage(webDriver)
                .inputSelectPlace("")
                .inputCost("")
                .inputTrafficVolume("")
                .inputCPM("")
                .inputTrafficChannel("")
                .inputLabel("")
                .inputGEO("")
                .inputLinkPP("")
                .clickOnSaveButton();
        new AddZidCidPage(webDriver)
                .clickOnAddZidCidButton()
                .inputZidCidValue("")
                .inputSelectPlace("")
                .inputLabel("")
                .inputTrafficChannel("")
                .inputCPM("")
                .clickOnSaveButton();
        new LogoutPage(webDriver)
                .clickOnSaveDealButton()
                .clickOnReviewButton()
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
