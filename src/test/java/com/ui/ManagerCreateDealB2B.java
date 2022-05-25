package com.ui;

import com.ui.pages.BaseURL;
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
    private String manager2FaCode;
    BaseURL baseURL = new BaseURL();
    final String bURL = baseURL.baseURL;
    final String apiURL = baseURL.apiURL;

    @BeforeTest
    public void setToken() {
        GenerateUserTokenWith2FaForManagerUI generateUserTokenWith2FaForManager = new GenerateUserTokenWith2FaForManagerUI();
        this.managerTokenWith2FA = generateUserTokenWith2FaForManager.set2faForAccount();
        this.manager2FaCode = generateUserTokenWith2FaForManager.manager2FaCode;
    }
    @Test
    public void createDealB2B() {
        /**
         * Login page
         * Вводим логин, вводим пароль, нажимаем на Sign In,
         * вводим код аутентификации, нажимаем на Send Code.
         */
        new LoginManagerPage(webDriver, bURL)
                .inputLogin("")
                .inputPassword("")
                .clickOnSignInButton()
                .inputAuthCode(manager2FaCode)
                .clickOnSendCodeButton();
        /**
         * Main page
         * Нажимаем на Partners, нажимаем на Partners list.
         */
        new MainPage(webDriver)
                .clickOnPartnersButton()
                .clickOnPartnersListButton();
        /**
         * Partners page
         * Вводим Partners ID, нажимаем на добавление сделки, нажимаем на B2B сделку.
         */
        new PartnersListPage(webDriver)
                .inputPartnersId("")
                .clickOnAddDealButton()
                .clickOnB2bButton();
        new DealPageB2B(webDriver)
                /**
                 * Deal page B2B
                 * Deal info
                 * Проверка на правильность создания сделки B2B!!
                 * Проверка на выбор классификации conv!!
                 * Проверка что сделка создается с полем Extension Test!!
                 * Проверка наличия инфополя Partner id
                 * Проверка наличия инфополя Product
                 * Проверка наличия инфополя Deal cost
                 * Проверка наличия инфополя In progress
                 * Проверка наличия инфополя Manager
                 * Проверка наличия инфополя ROI
                 */
                .assertPartnerId()
                .assertProduct()
                .assertDealCost()
                .assertInProgress()
                .assertManager()
                .assertROI()
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
//                .addFileToComment("")
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
                 * Site overview
                 * Нажимаем на блок Site Overview,
                 * нажимаем на поиск добавления лида,
                 * вводим линку в модальном окне Search lead,
                 * нажимаем на добавление линки
                 * записываем кост
                 * Выбираем аналитику за 1 месяц
                 * Добавляем ссылку на скриншот в аналитику за 1 месяц
                 * Выбрать Start date и End date в период за месяц
                 * Выбираем аналитику за 3 месяца !!
                 * Добавляем ссылку на скриншот в аналитику за 3 месяца!!
                 * Выбрать Start date и End date в период за 3 месяца!!
                 * Добавить ссылку в поле Traffic overview
                 * Добавить ссылку в поле GEO traffic
                 * Добавить ссылку в поле Device category
                 * Добавить ссылку в поле Traffic resources
                 * Добавить ссылку в поле Mobile/Desktop
                 * Добавить коммент
                 * Нажать на кнопку New Analytics
                 * Переход на первую аналитику
                 */
                .clickOnSiteOverviewBlock()
                .clickOnSearchLinkButton()
                .inputLink("")
                .clickOnAddLinkButton()
                .inputCostInAnalytics("")
                .inputSelectAnalytics("")
                .inputAddScreenshot("")
                .inputStartDateFor1Month("")
                .inputEndDateFor1Month("")
                .inputTrafficOverview("")
                .inputGeoTraffic("")
                .inputDeviceCategory("")
                .inputTrafficSource("")
                .inputMobileDesktop("")
                .inputCommentInAnalytics("")
                .clickOnNewAnalyticsButton()
                .clickOnFirstAnalyticsButton()
                /**
                 * Нажимаем на Add format,
                 * вводим Place, вводим Cost,
                 * вводим CPM,
                 * вводим Traffic Volume,
                 * добавить ссылку в поле Desktop screenshot
                 * добавить ссылку в поле
                 * сохраняем Format
                 */
                .clickOnAddFormatButton()
                .inputSelectPlace("")
                .inputCostInFormat("")
                .inputCPM("")
                .inputTrafficVolume("")
                .inputDesktopScreenshot("")
                .inputMobileScreenshot("")
                .clickOnSaveFormatButton()
                /**
                 * нажимаем на блок Deal zids,
                 * нажимаем на Add Zid/Cid,
                 * вводим сайт, вводим Zid/Cid value,
                 * вводим Place Zid/cid,
                 * вводим Label,
                 * вводим Traffic channel,
                 * написал коммент
                 * написал код
                 * сохраняем Zid/Cid
                 * проверил создание зида в сделку по ZidCid value
                 */
                .clickOnDealZidsBlock()
                .clickOnAddZidCidButton()
                .inputSite("")
                .inputZidCidValue("")
                .inputSelectPlaceZidCid("")
                .inputLabel("")
                .inputTrafficChannel("")
                .inputCommentInZidCid("")
                .inputCodeInZidCid("")
                .clickOnSaveZidCidButton()
                .assertZidCid()
                /**
                 * Нажимаем на блок Deal places,
                 * вводим site id,
                 * нажимаем на Add New Deal Place,
                 * вводим Place,
                 * вводим label,
                 * вводим GEO,
                 * вводим link PP,
                 * пишем коммент
                 * сохраняем Deal place.
                 * Проверить создание Deal place по Ad place!!
                 */
                .clickOnDealPlacesBlock()
                .inputSearchSiteById("")
                .clickOnAddNewDealPlaceButton()
                .inputSelectPlaceNewDealPlace("")
                .inputLabelNewDealPlace("")
                .inputGEO("")
                .inputLinkPp("")
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
