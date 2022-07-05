package com.ui.CreateDeals;

import com.ui.BaseTest;
import com.ui.pages.Manager.DealPageCPI;
import com.ui.pages.Manager.LoginPageManager;
import com.ui.pages.Manager.MainPageManager;
import com.ui.pages.Manager.PartnersListPageManager;
import com.ui.token2Fa.GenerateUserTokenWith2FaForManagerUI;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ManagerCreateDealCPI extends BaseTest {
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
    public void createDealCPI() {
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
         * Вводим Partners ID, нажимаем на добавление сделки, нажимаем на CPI сделку.
         */
        new PartnersListPageManager(webDriver)
//                .inputPartnersId("")
                .clickOnAddDealButton()
                .clickOnCPIButton();
        /**
         * Нажимаем на блок Site Overview, вводим линку, нажимаем на добавление линки, нажимаем на блок Cost per install,
         * нажимаем на Set Cost, вводим страну, вводим Cost, сохраняем Cost, нажимаем на блок Deal Places,
         * вводим site id, нажимаем на Add Deal Place, вводим Place, вводим Platform, вводим Label,
         * вводим GEO, сохраняем Deal Place, сохраняем сделку, отправляем на Review,
         * нажимаем на профиль, выходим с профиля.
         */
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
                .post(apiURL + "security/status/disable/" + manager2FaCode)
                .then()
                .assertThat()
                .statusCode(200);
    }
}
