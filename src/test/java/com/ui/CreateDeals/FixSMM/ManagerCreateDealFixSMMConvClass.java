package com.ui.CreateDeals.FixSMM;

import com.ui.BaseTest;
import com.ui.pages.Manager.DealPageFixSMM;
import com.ui.pages.Manager.LoginPageManager;
import com.ui.pages.Manager.MainPageManager;
import com.ui.pages.Manager.PartnersListPageManager;
import com.ui.token2Fa.GenerateUserTokenWith2FaForManagerUI;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ManagerCreateDealFixSMMConvClass extends BaseTest {
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
    public void createDealFixSmmConv() throws InterruptedException {
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
         * Вводим Partners ID, нажимаем на добавление сделки, нажимаем на FixSMM сделку.
         */
        new PartnersListPageManager(webDriver)
                .inputPartnersId("")
                .clickOnAddDealButton()
                .clickOnFixSMMButton();
        new DealPageFixSMM(webDriver)
                /**
                 * Deal page FixSMM
                 * Deal info
                 * Проверка на правильность создания сделки FixSMM
                 * Проверка на выбор классификации conv
                 * Проверка что сделка создается с полем Extension Test
                 * Проверка наличия инфополя Partner id
                 * Проверка наличия инфополя Product
                 * Проверка наличия инфополя Deal cost
                 * Проверка наличия инфополя In progress
                 * Проверка наличия инфополя Manager
                 * Проверка наличия инфополя ROI
                 */
                .assertDealType()
                .assertExtention()
                .assertClassification()
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
                 * Нажимаем на блок Site Overview
                 * Нажимаем на Add Format
                 * Вводим Title
                 * нажимаем на поиск добавления лида,
                 * вводим линку в модальном окне Search lead,
                 * нажимаем на добавление линки
                 * вводим Cost, Number of positions, Reach per post, Stats screenshot, comment
                 * Нажимаем на сохранения формата
                 * Проверяем созданный формат по Title
                 */
                .clickOnSiteOverviewBlock()
                .clickOnAddFormatButton()
                .inputTitle("")
                .clickOnSearchLinkButton()
                .inputLink("")
                .clickOnAddLinkButton()
                .inputCostInFormat("")
                .inputNumberOfPosition("")
                .inputReachPerPost("")
                .inputStatsScreenshot("")
                .inputCommentInFormat("")
                .clickOnSaveFormatButton()
                .assertFormat()
                /**
                 * Нажимаем на блок Deal places,
                 * вводим site id,
                 * нажимаем на Add New Deal Place,
                 * вводим Platform
                 * вводим Place,
                 * вводим label,
                 * вводим GEO,
                 * вводим link PP,
                 * пишем коммент
                 * сохраняем Deal place.
                 * Проверяем создание Deal place по GEO
                 */
                .clickOnDealPlacesBlock()
                .inputSearchSiteById("")
                .clickOnAddNewDealPlaceButton()
                .inputSelectPlaceNewDealPlace("")
                .inputPlatform("")
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
