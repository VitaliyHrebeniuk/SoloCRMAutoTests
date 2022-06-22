package com.ui;

import com.ui.pages.ManagerCreateDealFixApp.DealPageFixApp;
import com.ui.pages.ManagerCreateDealFixZid.ManagerCreateDeal.LoginManagerPage;
import com.ui.pages.ManagerCreateDealFixZid.ManagerCreateDeal.MainPage;
import com.ui.pages.ManagerCreateDealFixZid.ManagerCreateDeal.PartnersListPage;
import com.ui.token2Fa.GenerateUserTokenWith2FaForManagerUI;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ManagerCreateDealFixApp extends BaseTest{
    String managerTokenWith2FA;
    RequestSpecification request = RestAssured.given();
    final String URL = "https://beta-api.solo-crm.com/";
    private String manager2FaCode;
//    BaseURL baseURL = new BaseURL();
//    final String bURL = baseURL.baseURL;

    @BeforeTest
    public void setToken() {
        GenerateUserTokenWith2FaForManagerUI generateUserTokenWith2FaForManager = new GenerateUserTokenWith2FaForManagerUI();
        this.managerTokenWith2FA = generateUserTokenWith2FaForManager.set2faForAccount();
        this.manager2FaCode = generateUserTokenWith2FaForManager.manager2FaCode;
    }
    @Test
    public void createDealFixApp() {
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
         * Вводим Partners ID, нажимаем на добавление сделки, нажимаем на Fix App сделку.
         */
        new PartnersListPage(webDriver)
                .inputPartnersId("")
                .clickOnAddDealButton()
                .clickOnFixAppButton();
        /**
         * Нажимаем на блок Site Overview, нажимаем на поиск линки, вводим линку, нажимаем на добавление линки,
         * нажимаем на блок Site Overview, нажимаем на Add Format, вводим Place, вводим Cost, вводим CPM,
         * вводим Traffic Volume, сохраняем Format.
         * Нажимаем на блок Deal places, вводим site id, нажимаем на Add New Deal Place,вводим Place,
         * вводим Platform, вводим label, вводим GEO, вводим link PP, сохраняем Deal place.
         * Сохраняем сделку, отправляем на review, нажимаем на профиль, выходим с профиля.
         */
        new DealPageFixApp(webDriver)
                .clickOnSiteOverviewBlock()
                .clickOnSearchLinkButton()
                .inputLink("")
                .clickOnAddLinkButton()
                .clickOnSiteOverviewBlock()
                .clickOnAddFormatButton()
                .inputSelectPlace("")
                .inputCost("")
                .inputCPM("")
                .inputTrafficVolume("")
                .clickOnSaveFormatButton()
                .clickOnDealPlacesBlock()
                .inputSearchSiteById("")
                .clickOnAddNewDealPlaceButton()
                .inputSelectPlaceNewDealPlace("")
                .inputPlatform("")
                .inputLabel("")
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
                .post(apiURL + "security/status/disable/" + manager2FaCode)
                .then()
                .assertThat()
                .statusCode(200);
    }
}
