package com.ui.CreateDeals.CPM;

import com.ui.BaseTest;
import com.ui.pages.Manager.DealPageCPM;
import com.ui.pages.Manager.LoginPageManager;
import com.ui.pages.Manager.MainPageManager;
import com.ui.pages.Manager.PartnersListPageManager;
import com.ui.token2Fa.GenerateUserTokenWith2FaForManagerUI;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ManagerCreateDealCPM extends BaseTest {
    String managerTokenWith2FA;
    RequestSpecification request = RestAssured.given();
    private String manager2FaCode;

    @BeforeMethod
    public void setToken() {
        GenerateUserTokenWith2FaForManagerUI generateUserTokenWith2FaForManager = new GenerateUserTokenWith2FaForManagerUI();
        this.managerTokenWith2FA = generateUserTokenWith2FaForManager.set2faForAccount();
        this.manager2FaCode = generateUserTokenWith2FaForManager.manager2FaCode;
    }
    @Test
    public void createDealCPM() throws InterruptedException {
        /**
         * Login page
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
         * Main page
         * Нажимаем на Partners, нажимаем на Partners list.
         */
        new MainPageManager(webDriver)
                .clickOnPartnersButton()
                .clickOnPartnersListButton();
        /**
         * Partners page
         * Вводим Partners ID, нажимаем на добавление сделки, нажимаем на B2B сделку.
         */
        new PartnersListPageManager(webDriver)
                .inputPartnersId("")
                .clickOnAddDealButton()
                .clickOnCPMButton();
        new DealPageCPM(webDriver)
                /**
                 * Deal page CPM
                 * Deal info
                 * Проверка на правильность создания сделки CPM
                 * Проверка поля Start date
                 * Проверка поля Network
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
                .assertStartDate()
                .inputNetwork("")
                .assertExtention()
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
                 * Site overview
                 * Нажимаем на блок Site overview
                 * вводим линку, нажимаем на кнопку добавления линки
                 * Нажимаем на кнопку Add analytics
                 * Переходим на первую аналитику
                 */
                .clickOnSiteOverviewBlock()
                .inputLink("")
                .clickOnAddLinkButton()
                .clickOnAddAnalyticsButton()
                .clickOnFirstAnalyticsButton()
                /**
                 * Нажимаем на Add format
                 * Вводим Select place, Geo, CpmUsd, CpcUsd, Traffic Type, Traffic channel
                 * Сохраняем формат
                 * Проверяем сохраненный формат
                 */
                .clickOnSiteOverviewBlock()
                .clickOnAddFormatButton()
                .inputSelectPlaceInFormat("")
                .inputGeoInFormat("")
                .inputCpmUsd("")
                .inputCpcUsd("")
                .inputTrafficTypeInFormat("")
                .inputTrafficChannelInFormat("")
                .clickOnSaveFormatButton()
                .assertFormat()
                /**
                 * Deal place
                 * Открываем блок Deal place
                 * Нажимаем на кнопку Search site
                 * Вводим сайт, выбираем чекбокс, нажимаем на кнопку добавления deal place
                 * Открываем Deal place
                 * Вводим place name, Select place, Geo, CpmCpc, Traffic channel, Traffic type, Ad size, Creative,
                 * Network Makros, Redirector, LinkPP, Comment,
                 * Сохраняем Deal place
                 * Проверяем сохраненный Deal place
                 */
                .clickOnDealPlacesBlock()
                .clickOnSearchSiteButton()
                .inputSearchSite("")
                .clickOnCheckboxSite()
                .clickOnAddDealPlaceButton()
                .clickOnOpenDealPlaceButton()
                .inputPlaceName("")
                .inputSelectPlaceInDealPlace("")
                .inputGeoInDealPlace("")
                .inputCpmCpc("")
                .inputTrafficChannelInDealPlace("")
                .inputTrafficTypeInDealPlace("")
                .inputAdSize("")
                .inputCreative("")
                .inputNetworkMakros("")
                .inputRedirector("")
                .inputLinkPP("")
                .inputCommentInDealPlace("")
                .saveDealPlace()
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
    @AfterMethod
    public void ResetCode() {
        request
                .headers("token", managerTokenWith2FA)
                .post(apiURL + "security/status/disable/" + manager2FaCode)
                .then()
                .assertThat()
                .statusCode(200);
    }
}
