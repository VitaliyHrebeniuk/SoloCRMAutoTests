package com.ui.CreateDeals.CPI;

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

public class ManagerCreateDealCPIVolClass extends BaseTest {
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
    public void createDealCPIVol() throws InterruptedException {
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
                .inputPartnersId("")
                .clickOnAddDealButton()
                .clickOnCPIButton();
        new DealPageCPI(webDriver)
                /**
                 * Deal page CPI
                 * Deal info
                 * Проверка на правильность создания сделки CPI
                 * Проверка на выбор классификации conv
                 * Выбираем классификацию Vol
                 * Проверка что сделка создается с полем Extension Test
                 * Проверка наличия инфополя Partner id
                 * Проверка наличия инфополя Product
                 * Проверка наличия инфополя Deal cost
                 * Проверка наличия инфополя In progress
                 * Проверка наличия инфополя Manager
                 * Проверка наличия инфополя ROI
                 * Проверка наличия инфополя Total spend
                 * Проверка наличия инфополя Balance
                 */
                .assertDealType()
                .assertExtention()
                .assertClassification()
                .chooseVolClassification()
                .assertPartnerId()
                .assertProduct()
                .assertDealCost()
                .assertInProgress()
                .assertManager()
                .assertROI()
                .assertTotalSpend()
                .assertBalance()
                /**
                 * Communication
                 * Проверка на открытие модального окна
                 * Написать коммент
                 * Прикрепить файл
                 * нажать Add comment
                 * Проверить что коммент появился в дилчате
                 */
                .clickOnCommunicationButton()
                .inputCommentInCommunication("")
                .addFileToComment("")
                .clickOnAddCommentButton()
                .findAddedComment()
                .closeDealChat()
                /**
                 * Deal log
                 * Открытие страницы логов
                 * Проверка действия Create deal
                 */
                .clickOnDealLogButton()
                .findDealLog()
                /**
                 * Spends
                 * Открываем спенды, открываем историю спендов
                 * закрываем историю, закрываем спенды
                 */
                .clickOnSpendsButton()
                .clickOnHistorySpendsButton()
                .clickOnCloseHistorySpendsButton()
                .clickOnCloseSpendsButton()
                /**
                 * Site Overview
                 * Открываем блок Site overview
                 * Вводим линку, нажимаем на добавление линки
                 * Создаем новую аналитику, переходим на первую аналитику
                 */
                .clickOnSiteOverviewBlock()
                .inputLink("")
                .clickOnAddLinkButton()
                .clickOnAddAnalyticsButton()
                .clickOnFirstAnalyticsButton()
                /**
                 * Cost per install
                 * Открываем Cost per install block, нажимаем на Set cost
                 * Выбираем страну, вводим первую дату, последнюю дату, кост
                 * Сохраняем кост, проверяем что кост сохранился
                 */
                .clickOnCostPerInstallBlock()
                .clickOnSetCostButton()
                .inputSelectCountry("")
                .inputCost("")
                .clickOnSaveCostButton()
                .assertCost()
                /**
                 * Deal places
                 * Открываем блок Deal places
                 * Вводим линку, нажимаем на добавление Deal place
                 * Вводим Place, Platform, Label, GEO, Link PP, Comment
                 * Сохраняем Deal place, проверяем что Deal place сохранился
                 */
                .clickOnDealPlacesBlock()
                .inputSearchSite("")
                .clickOnAddDealPlaceButton()
                .inputSelectPlace("")
                .inputPlatform("")
                .inputLabel("")
                .inputGEO("")
                .inputLinkPP("")
                .inputCommentInDealPlace("")
                .clickOnSaveDealPlaceButton()
                .assertDealPlace()
                /**
                 * Сохраняем сделку,
                 * отправляем на review,
                 * нажимаем на профиль,
                 * выходим с профиля.
                 */
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
