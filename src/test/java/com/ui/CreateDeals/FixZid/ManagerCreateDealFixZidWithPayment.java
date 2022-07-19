package com.ui.CreateDeals.FixZid;

import com.ui.BaseTest;
import com.ui.pages.Manager.DealPageFixZid;
import com.ui.pages.Manager.LoginPageManager;
import com.ui.pages.Manager.MainPageManager;
import com.ui.pages.Manager.PartnersListPageManager;
import com.ui.token2Fa.GenerateUserTokenWith2FaForManagerUI;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ManagerCreateDealFixZidWithPayment extends BaseTest {
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
    public void createDealFixZidWithPayment() throws InterruptedException {
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
                 * Deal page FixZid
                 * Deal info
                 * Проверка на правильность создания сделки FixZid
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
                 * Deal payments
                 * Нажимаем на блок Deal Payments
                 * Deal contract
                 * Нажимаем на New contract
                 * Вводим contract name
                 * вводим Start date
                 * вводим End date
                 * прикрепляем файл
                 * сохраняем контракт
                 * проверить добавление контракта по Name
                 */
                .clickOnDealPaymentsBlockButton()
                .clickOnNewContractButton()
                .inputContractName("")
                .inputStartDateInContract("")
                .inputEndDateInContract("")
                .inputAttachFile("")
                .clickOnSaveContractButton()
                .assertContractName()
                /**
                 * нажимаем на New Payment,
                 * вводим Start date,
                 * вводим End date,
                 * вводим Payment target,
                 * вводим Type,
                 * вводим Wallet,
                 * вводим Cost,
                 * нажимаем на Autocheck
                 * добавить коммент
                 * нажимаем на Continue,
                 * вводим remaining cost,
                 * вводим Remaining zid cost,
                 * сохраняем Payment,
                 * проверяем что создался платеж по Wallet
                 */
                .clickOnNewPaymentButton()
                .inputStartDateInPayment("")
                .inputEndDateInPayment("")
                .inputPaymentTarget("")
                .inputType("")
                .inputWallet("")
                .inputCostInPayment("")
                .clickOnAutocheck()
                .inputCommentInPayment("")
                .clickOnContinueButton()
                .inputRemainingCost("")
                .inputRemainingZidCost("")
                .clickOnSavePaymentButton()
                .assertPayment()
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
