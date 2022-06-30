package com.ui.ManagerCreateDealCPM;

import com.ui.BaseTest;
import com.ui.pages.ManagerCreateDealCPM.DealPageCPM;
import com.ui.pages.ManagerCreateDealFixZid.ManagerCreateDeal.LoginManagerPage;
import com.ui.pages.ManagerCreateDealFixZid.ManagerCreateDeal.MainPage;
import com.ui.pages.ManagerCreateDealFixZid.ManagerCreateDeal.PartnersListPage;
import com.ui.token2Fa.GenerateUserTokenWith2FaForManagerUI;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ManagerCreateDealCPM extends BaseTest {
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
    public void createDealCPM() {
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
         * Вводим Partners ID, нажимаем на добавление сделки, нажимаем на CPM сделку.
         */
        new PartnersListPage(webDriver)
                .inputPartnersId("")
                .clickOnAddDealButton()
                .clickOnCPMButton();
        /**
         * Нажимаем на блок Site overview, вводим линку, нажимаем на добавление линки, нажимаем на Add Format,
         * вводим Place, вводим GEO, вводим CPM usd, вводим CPC usd, вводим Traffic Type,
         * вводим Traffic Channel, сохраняем Format. Нажимаем на блок Deal Places,
         * нажимаем на Search site, вводим site id, выбираем чекбокс, нажимаем на add site.
         * Нажимаем на Add new deal place, вводим Place Name, вводим Place, вводим Label,вводим GEO,
         * вводим CpmCpc, вводим Traffic channel, вводим Traffic type, вводим Link PP, сохраняем Deal Place.
         * Сохраняем сделку, отправляем на review, нажимаем на профиль, выходим с профиля.
         */
        new DealPageCPM(webDriver)
                .clickOnSiteOverviewBlock()
                .inputLink("")
                .clickOnAddLinkButton()
                .clickOnAddFormatButton()
                .inputSelectPlaceInAdFormat("")
                .inputGeoInAdFormat("")
                .inputCpmUsd("")
                .inputCpcUsd("")
                .inputTrafficTypeInAdFormat("")
                .inputTrafficChannelInAdFormat("")
                .clickOnSaveFormatButton()
                .clickOnDealPlaceBlock()
                .clickOnSearchSiteButton()
                .inputSearchById("")
                .clickOnAddSiteCheckbox()
                .clickOnAddSiteButton()
                .clickOnAddNewDealPlaceButton()
                .inputPlaceName("")
                .inputSelectPlaceInNewPlace("")
                .inputLabel("")
                .inputGeoInNewPlace("")
                .inputCpmCpc("")
                .inputTrafficChannelInNewPlace("")
                .inputTrafficTypeInNewPlace("")
                .inputLinkPP("")
                .clickOnSaveNewPlace()
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
