package com.ui.CreateDeals;

import com.ui.BaseTest;
import com.ui.pages.Manager.DealPageFixApp;
import com.ui.pages.Manager.LoginPageManager;
import com.ui.pages.Manager.MainPageManager;
import com.ui.pages.Manager.PartnersListPageManager;
import com.ui.token2Fa.GenerateUserTokenWith2FaForManagerUI;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ManagerCreateDealFixApp extends BaseTest {
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
         * Нажимаем на Partners, нажимаем на Partners list.
         */
        new MainPageManager(webDriver)
                .clickOnPartnersButton()
                .clickOnPartnersListButton();
        /**
         * Вводим Partners ID, нажимаем на добавление сделки, нажимаем на Fix App сделку.
         */
        new PartnersListPageManager(webDriver)
//                .inputPartnersId("")
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
