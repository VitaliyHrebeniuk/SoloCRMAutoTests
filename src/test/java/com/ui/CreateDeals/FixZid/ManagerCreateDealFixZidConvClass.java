package com.ui.CreateDeals.FixZid;

import com.ui.BaseTest;
import com.ui.pages.Manager.DealPageFixZid;
import com.ui.pages.Manager.LoginPageManager;
import com.ui.pages.Manager.MainPageManager;
import com.ui.pages.Manager.PartnersListPageManager;
import com.ui.token2Fa.GenerateUserTokenWith2FaForManagerUI;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.*;

public class ManagerCreateDealFixZidConvClass extends BaseTest {
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
    public void createDealFixZidConv() throws InterruptedException {
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
         * Main page
         * Нажимаем на Partners, нажимаем на Partners list.
         */
        new MainPageManager(webDriver)
                .clickOnPartnersButton()
                .clickOnPartnersListButton();
        /**
         * Partners page
         * Вводим Partners ID, нажимаем на добавление сделки, нажимаем на Fix Zid сделку.
         */
        new PartnersListPageManager(webDriver)
                .inputPartnersId("")
                .clickOnAddDealButton()
                .clickOnZidCidButton();
        new DealPageFixZid(webDriver)
                /**
                 * Deal page B2B
                 * Deal info
                 * Проверка на правильность создания сделки B2B
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
                .addFileToComment("")
                .inputCommentInCommunication("")
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
                 * вводим линку в инпут, нажимаем на кнопку добавления линки
                 * вводим Total cost
                 * выбираем Start date и end date
                 * выбираем аналитику, заполняем Mobile/ Desktop, Comment
                 * Добавляем файлы в TraficScreenshot, DevicesScreenshot, TotalTraffic, OtherScreenshot
                 */
                .clickOnSiteOverviewBlock()
                .inputSite("")
                .clickOnAddSiteButton()
                .inputTotalCost("")
                .inputSelectAnalytics("")
                .inputMobileDesktop("")
                .inputCommentInAnalytics("")
                .addFileToTrafficScreenshot("")
                .addFileToDevicesScreenshot("")
                .addFileToTotalScreenshot("")
                .addFileToOtherScreenshot("")
                /**
                 * Site places
                 * Вводим site id
                 * Нажимаем на Add link
                 * Вводим Place, Cost, Traffic Volume, CPM, Traffic channel, Label, Geo, Link PP
                 * Вводим Desktop Screenshot, Mobile Screenshot
                 * Сохраняем Deal place
                 * Проверяем создание Deal place по GEO
                 */
                .inputSearchSiteById("")
                .clickOnAddLinkButton()
                .inputSelectPlace("")
                .inputCost("")
                .inputTrafficVolume("")
                .inputCPM("")
                .inputTrafficChannel("")
                .inputLabel("")
                .inputGEO("")
                .inputLinkPP("")
                .inputDesktopScreenshotInDealPlace("")
                .inputMobileScreenshotInDealPlace("")
                .clickOnSaveDealPlaceButton()
                .assertDealPlace()
                /**
                 * Zid/Cid
                 * Нажимаем на Add zid/cid
                 * Вводим zid/cid value, Place, Label, Traffic channel, CPM
                 * Сохраняем Zid/Cid
                 */
                .clickOnAddZidCidButton()
                .inputZidCidValue("")
                .inputSelectPlaceInZidCid("")
                .inputLabelInZidCid("")
                .inputTrafficChannelInZidCid("")
                .inputCPMInZidCid("")
                .inputDesktopScreenInZidCid("")
                .inputMobileScreenInZidCid("")
                .inputCommentInZidCid("")
                .inputCodeInZidCid("")
                .clickOnSaveZidCidButton()
                .assertZidCid()
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
