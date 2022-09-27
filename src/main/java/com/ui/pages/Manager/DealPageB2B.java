package com.ui.pages.Manager;

import com.ui.pages.BasePage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.openqa.selenium.By;

import java.io.File;
import java.io.IOException;

public class DealPageB2B extends BasePage {
    private final By infoDealType = By.xpath("//input[@aria-label='Deal type']");
    private final By infoExtension = By.xpath("//input[@aria-label='Extension']");
    private final By infoClassification = By.xpath("//input[@aria-label='Classification']");
    private final By volClassification = By.xpath("//div[contains(text(),'vol')]");
    private final By infoPartnerId = By.xpath("//h5[contains(text(),'Partner id')]");
    private final By infoProduct = By.xpath("//h5[contains(text(),'Product')]");
    private final By infoDealCost = By.xpath("//h5[contains(text(),'Deal cost')]");
    private final By infoInProgress = By.xpath("//h5[contains(text(),'In progress')]");
    private final By infoManager = By.xpath("//h5[contains(text(),'Manager')]");
    private final By infoROI = By.xpath("//h5[contains(text(),'ROI')]");

    private final By communicationButton = By.xpath("//div[contains(text(),'Communication')]");
    private final By commentInput = By.xpath("//div[@id='comment']//textarea[@aria-label='Comment']");
    private final By addCommentButton = By.xpath
            ("//button[@class='white--text btn-success v-btn v-btn--small theme--light']");
    private final By addedComment = By.xpath("//div[@class='comment-author']");
    private final By closeDealChat = By.xpath("//div[@class='v-dialog__content v-dialog__content--active']" +
            "//div[contains(text(),'Close')]");

    private final By dealLogButton = By.xpath("//div[contains(text(),'Deal log')]");
    private final By assertLog = By.xpath("//strong[contains(text(),'Create deal')]");

    private final By siteOverviewBlock = By.xpath("//div[contains(text(),'Site Overview')]");
    private final By searchLinkButton = By.xpath
            ("//div[@class='v-input__icon v-input__icon--append']/i[contains(text(),'search')]");
    private final By linkInput = By.xpath("//input[@aria-label='Search by link/id']");
    private final By addLinkButton = By.xpath("//button[@class='ma-0 v-btn v-btn--flat v-btn--icon theme--light']" +
            "//i[contains(text(), 'add')]");
    private final By costInputInAnalytics = By.xpath("//div[@class='v-input ml-2 v-text-field theme--light']" +
            "//input[@aria-label='Cost']");
    private final By selectAnalyticsInput = By.xpath("//input[@aria-label='Select analytics']");
    private final By addScreenshotInput = By.xpath("//input[@aria-label='Add screenshot']");
    private final By startDateInput = By.xpath("//div[@class='layout']//input[@aria-label='Start date']");
    private final By firstDate = By.xpath("//div[contains(text(),'1')]");
    private final By endDate = By.xpath("//div[contains(text(),'28')]");
    private final By endDateInput = By.xpath("//div[@class='layout']//input[@aria-label='End date']");
    private final By selectAnalyticsFor3MonthInput = By.xpath
            ("(//input[@aria-label='Select analytics'])[2]");
    private final By addScreenshotFor3MonthInput = By.xpath
            ("(//input[@aria-label='Add screenshot'])[2]");
    private final By startDateFor3MonthInput = By.xpath("//div[@class='layout']" +
            "//div[@class='v-input v-text-field v-input--is-readonly theme--light']//input[@aria-label='Start date']");
    private final By endDateFor3MonthInput = By.xpath("//div[@class='layout']" +
            "//div[@class='v-input v-text-field v-input--is-readonly theme--light']//input[@aria-label='End date']");
    private final By trafficOverviewInput = By.xpath("//input[@aria-label='Traffic overview']");
    private final By geoTrafficInput = By.xpath("//input[@aria-label='GEO traffic']");
    private final By deviceCategoryInput = By.xpath("//input[@aria-label='Device - Category']");
    private final By trafficSourcesInput = By.xpath("//input[@aria-label='Traffic Sources']");
    private final By mobileDesktopInput = By.xpath("//input[@aria-label='Mobile / Desktop %']");
    private final By commentInAnalyticsInput = By.xpath("//div[@class='flex md6 pa-1']//textarea[@aria-label='Comment']");
    private final By newAnalyticsButton = By.xpath("//div[contains(text(),'New analytics')]");

    private final By addFormatButton = By.xpath("//div[contains(text(),'Ad format')]");
    private final By selectPlaceInFormatInput = By.xpath("//div[@class='v-dialog v-dialog--active v-dialog--persistent']" +
            "//input[@aria-label='Select place']");
    private final By costInputInFormat = By.xpath
            ("//div[@class='v-dialog v-dialog--active v-dialog--persistent']//input[@aria-label='Cost']");
    private final By cpmInput = By.xpath
            ("//div[@class='v-dialog v-dialog--active v-dialog--persistent']//input[@aria-label='CPM']");
    private final By trafficVolumeInput = By.xpath
            ("//div[@class='v-dialog v-dialog--active v-dialog--persistent']//input[@aria-label='Traffic volume']");
    private final By desktopScreenshotInput = By.xpath
            ("//div[@class='v-dialog v-dialog--active v-dialog--persistent']//input[@aria-label='Desktop screenshot']");
    private final By mobileScreenshotInput = By.xpath
            ("//div[@class='v-dialog v-dialog--active v-dialog--persistent']//input[@aria-label='Mobile screenshot']");
    private final By saveFormatButton = By.xpath
            ("//div[@class='v-dialog v-dialog--active v-dialog--persistent']//div[contains(text(),'Save')]");

    private final By dealZidsBlock = By.xpath("//div[contains(text(),'Deal zids')]");
    private final By addZidCidButton = By.xpath("//button//div[contains(text(),' Add Zid / Cid ')]");
    private final By siteInput = By.xpath("//input[@aria-label='Select site']");
    private final By zidCidValueInput = By.xpath("//input[@aria-label='Zid/Cid value']");
    int a = (int) (Math.random() * 10000000);
    String b = String.valueOf(a);
    private final By labelInZidCidInput = By.xpath("//div[@class='v-dialog v-dialog--active v-dialog--persistent']" +
            "//input[@aria-label='Label']");
    private final By selectPlaceInZidCidInput = By.xpath
            ("//div[@class='v-input deal-country v-text-field v-select v-autocomplete theme--light']" +
                    "//input[@aria-label='Select place']");
    private final By trafficChannelInput = By.xpath("//input[@aria-label='Traffic channel']");
    private final By commentInZidInput = By.xpath("//div[@class='v-dialog v-dialog--active v-dialog--persistent']" +
            "//textarea[@aria-label='Comment']");
    private final By codeInput = By.xpath("//textarea[@aria-label='Сode']");
    private final By saveZidCidButton = By.xpath("//div[@class='v-dialog v-dialog--active v-dialog--persistent']" +
            "//div[contains(text(),'Save')]");
    private final By infoZidCid = By.xpath("//td[contains(text(),'cyber')]");

    private final By dealPlacesBlock = By.xpath("//div[contains(text(),'Deal places')]");
    private final By searchSiteByIdInput = By.xpath("//input[@aria-label='Search site']");
    private final By addNewDealPlaceButton = By.xpath
            ("//button[@class='v-btn v-btn--floating v-btn--outline v-btn--depressed v-btn--small theme--light primary--text']");
    private final By selectPlaceInNewDealPlaceInput = By.xpath("//div[@class='v-dialog v-dialog--active v-dialog--persistent']" +
                    "//input[@aria-label='Select place']");
    private final By geoInput = By.xpath("//input[@aria-label='GEO']");
    private final By linkPpInput = By.xpath("//input[@aria-label='Link PP']");
    private final By commentInDealPlaceInput = By.xpath("//div[@class='v-dialog v-dialog--active v-dialog--persistent']" +
            "//textarea[@aria-label='Comment']");
    private final By saveDealPlaceButton = By.xpath("//div[@class='v-dialog v-dialog--active v-dialog--persistent']" +
            "//button//div[contains(text(),'Save')]");
    private final By infoGEO = By.xpath("//td[contains(.,'Austria')]");

    private final By greenOverlay = By.xpath("//div[@class='vue-notification-template vue-notification success']");
    private final By saveDealButton = By.xpath
            ("//button[@class='ml-0 pulse-button v-btn v-btn--bottom v-btn--floating v-btn--fixed v-btn--right theme--dark green darken-1']");
    private final By sendOnReviewButton = By.xpath("//button[@class='v-btn v-btn--small theme--light btn-item_send on review']");
    private final By profileButton = By.xpath("//button[@id='profile_btn']");
    private final By exitButton = By.xpath("//a[@id='exit_btn']");
    private final By confirmExit = By.xpath("//div[contains(text(),'Yes')]");

    private final By dealPaymentsBlockButton = By.xpath("//div[contains(text(),'Deal payments')]");
    private final By newContractButton = By.xpath("//div[contains(text(),'Add contract')]");
    private final By contractNameInput = By.xpath("//input[@aria-label='Contract name']");
    private final By startDateInContractInput = By.xpath("//div[@class='flex md6']//input[@aria-label='Start date']");
    private final By endDateInContractInput = By.xpath("//div[@class='flex md6']//input[@aria-label='End date']");
    private final By saveContractButton =
            By.xpath("//div[@class='v-dialog__content v-dialog__content--active']//div[contains(text(),'Save')]");
    private final By infoContractName = By.xpath("//td[contains(text(),'Contract name')]");

    private final By newPaymentButton = By.xpath("//button[@id='add-payment']");
    private final By head = By.xpath("(//div[@class='v-stepper__label'])[1]");
    private final By startDateInPaymentInput = By.xpath("//div[@class='v-text-field__slot']/input[@id='payment-start_date']");
    private final By endDateInPaymentInput = By.xpath("//input[@id='payment-end_date']");
    private final By paymentTargetInput = By.xpath("//input[@id='payment-payment_target_id']");
    private final By typeInput = By.xpath("//input[@id='payment-type']");
    private final By walletInput = By.xpath("//input[@id='payment-wallet_id']");
    private final By costInput = By.xpath("//input[@id='payment-summary']");
    private final By autocheckCheckbox = By.xpath
            ("//div[@class='v-dialog v-dialog--active v-dialog--persistent']//div[@class='v-input--selection-controls__ripple']");
    private final By commentInPaymentInput = By.xpath("//textarea[@id='payment-comment']");
    private final By continueButton = By.xpath("//div[contains(text(),'Continue')]");
    private final By remainingCostInput = By.xpath
            ("//div[@class='v-input payment-analytic-cost v-text-field v-input--hide-details theme--light']" +
                    "//input[@aria-label='Cost']");
    private final By remainingZidCostInput = By.xpath("//input[@id='payment-analytic-zid-cost']");
    private final By savePaymentButton = By.xpath("//div[contains(text(),'Save payment')]");
    private final By approvePaymentButton = By.xpath("//button[@id='payment-positive_status']");
    private final By infoWallet = By.xpath("//div[contains(text(),' 1x ')]");

    public DealPageB2B(WebDriver webDriver) {
        super(webDriver);
    }

    public DealPageB2B assertDealType() {
        Assert.assertEquals(findElement(webDriver, infoDealType).getAttribute("value"),"fix_b2b");
        return this;
    }
    public DealPageB2B assertExtention() {
        Assert.assertEquals(findElement(webDriver, infoExtension).getAttribute("value"),"Test");
        return this;
    }
    public DealPageB2B assertClassification() {
        Assert.assertEquals(findElement(webDriver, infoClassification).getAttribute("value"),"conv");
        return this;
    }
    public DealPageB2B chooseVolClassification() {
        findElement(webDriver, infoClassification).click();
        findElement(webDriver, volClassification).click();
        return this;
    }
    public DealPageB2B assertPartnerId() {
        Assert.assertEquals(findElement(webDriver, infoPartnerId).getText(),"Partner id");
        return this;
    }
    public DealPageB2B assertProduct() {
        Assert.assertEquals(findElement(webDriver, infoProduct).getText(),"Product");
        return this;
    }
    public DealPageB2B assertDealCost() {
        Assert.assertEquals(findElement(webDriver, infoDealCost).getText(),"Deal cost");
        return this;
    }
    public DealPageB2B assertInProgress() {
        Assert.assertEquals(findElement(webDriver, infoInProgress).getText(),"In progress");
        return this;
    }
    public DealPageB2B assertManager() {
        Assert.assertEquals(findElement(webDriver, infoManager).getText(),"Manager");
        return this;
    }
    public DealPageB2B assertROI() {
        Assert.assertEquals(findElement(webDriver, infoROI).getText(),"ROI");
        return this;
    }

    public DealPageB2B clickOnCommunicationButton() {
        findElement(webDriver, communicationButton).click();
        return this;
    }
    public DealPageB2B inputCommentInCommunication(String comment) {
        findElement(webDriver, commentInput).sendKeys("1234");
        return this;
    }
    public DealPageB2B addFileToComment(String comment) throws InterruptedException {
        Thread.sleep(3000);
        WebElement inputFileInComment = webDriver.findElement(By.xpath("//input[@type='file'][@id='files'][@accept='image/*']"));
        unhide(webDriver, inputFileInComment);
        inputFileInComment.sendKeys("/files/picture.jpg");
//        inputFileInComment.sendKeys("C:\\Users\\aberz\\Downloads\\picture.jpg");
        return this;
    }
    public DealPageB2B clickOnAddCommentButton() throws InterruptedException {
        Thread.sleep(3000);
        waitForElementClickable(webDriver, addCommentButton).click();
        findElement(webDriver, addCommentButton).click();
        return this;
    }
    public DealPageB2B takeScreenshot() {
        takeSnapShot(webDriver, "/files/screen.png");
//        takeSnapShot(webDriver, "C:\\Users\\aberz\\Downloads\\screen.png");
        return this;
    }
    public DealPageB2B findAddedComment() throws InterruptedException{
        Thread.sleep(3000);
        waitForElementClickable(webDriver, addedComment);
        return this;
    }
    public DealPageB2B closeDealChat() {
        waitForElementClickable(webDriver, closeDealChat).click();
        return this;
    }

    public DealPageB2B clickOnDealLogButton() {
        findElement(webDriver, dealLogButton).click();
        return this;
    }
    public DealPageB2B findDealLog() {
        findElement(webDriver, assertLog);
        webDriver.navigate().back();
        return this;
    }

    public DealPageB2B clickOnSiteOverviewBlock() {
        waitForElementClickable(webDriver, siteOverviewBlock).click();
        return this;
    }
    public DealPageB2B clickOnSearchLinkButton() {
        findElement(webDriver, searchLinkButton).click();
        return this;
    }
    public DealPageB2B inputLink(String link) throws InterruptedException {
        waitForElementClickable(webDriver, linkInput).sendKeys("https://football.ua");
        Thread.sleep(3000);
        return this;
    }
    public DealPageB2B clickOnAddLinkButton() {
        findElement(webDriver, addLinkButton).click();
        return this;
    }
    public DealPageB2B inputCostInAnalytics(String cost) {
        findElement(webDriver, costInputInAnalytics).sendKeys("100");
        return this;
    }
    public DealPageB2B inputSelectAnalyticsFor1Month(String analytics) {
        findElement(webDriver, selectAnalyticsInput).sendKeys("google" + Keys.ENTER);
        return this;
    }
    public DealPageB2B inputAddScreenshotFor1Month(String screen) {
        findElement(webDriver, addScreenshotInput).sendKeys("screen");
        return this;
    }
    public DealPageB2B selectStartDateFor1Month() {
        findElement(webDriver, startDateInput).click();
        findElement(webDriver, firstDate).click();
        return this;
    }
    public DealPageB2B selectEndDateFor1Month() {
        findElement(webDriver, endDateInput).click();
        findElement(webDriver, endDate).click();
        return this;
    }
    public DealPageB2B inputSelectAnalyticsFor3Month(String analytics) {
        findElement(webDriver, selectAnalyticsFor3MonthInput).sendKeys("google" + Keys.ENTER);
        return this;
    }
    public DealPageB2B inputAddScreenshotFor3Month(String screen) {
        findElement(webDriver, addScreenshotFor3MonthInput).sendKeys("screen");
        return this;
    }
    public DealPageB2B selectStartDateFor3Month() {
        findElement(webDriver, startDateFor3MonthInput).click();
        findElement(webDriver, firstDate).click();
        return this;
    }
    public DealPageB2B selectEndDateFor3Month() {
        findElement(webDriver, endDateFor3MonthInput).click();
        findElement(webDriver, endDate).click();
        return this;
    }
    public DealPageB2B inputTrafficOverview(String traffic) {
        findElement(webDriver, trafficOverviewInput).sendKeys("Traffic overview");
        return this;
    }
    public DealPageB2B inputGeoTraffic(String traffic) {
        findElement(webDriver, geoTrafficInput).sendKeys("GEO traffic");
        return this;
    }
    public DealPageB2B inputDeviceCategory(String category) {
        findElement(webDriver, deviceCategoryInput).sendKeys("Device category");
        return this;
    }
    public DealPageB2B inputTrafficSource(String source) {
        findElement(webDriver, trafficSourcesInput).sendKeys("Traffic sources");
        return this;
    }
    public DealPageB2B inputMobileDesktop(String mobile) {
        findElement(webDriver, mobileDesktopInput).sendKeys("5050");
        return this;
    }
    public DealPageB2B inputCommentInAnalytics(String comment) {
        findElement(webDriver, commentInAnalyticsInput).sendKeys("comment");
        return this;
    }
    public DealPageB2B clickOnNewAnalyticsButton() {
        findElement(webDriver, newAnalyticsButton).click();
        return this;
    }
    public DealPageB2B clickOnFirstAnalyticsButton() {
        WebElement firstAnalButton = webDriver.findElement(By.xpath("//a[@class='v-tabs__item']"));
        Actions act = new Actions(webDriver);
        act.moveToElement(firstAnalButton).click().perform();
        return this;
    }

    public DealPageB2B clickOnAddFormatButton() {
        waitForElementClickable(webDriver, addFormatButton).click();
        return this;
    }
    public DealPageB2B inputSelectPlace(String place) {
        findElement(webDriver, selectPlaceInFormatInput).sendKeys("article" + Keys.ENTER);
        return this;
    }
    public DealPageB2B inputCostInFormat(String cost) {
        findElement(webDriver, costInputInFormat).sendKeys("10");
        return this;
    }
    public DealPageB2B inputCPM(String cpm) {
        findElement(webDriver, cpmInput).sendKeys("2");
        return this;
    }
    public DealPageB2B inputTrafficVolume(String traffic) {
        findElement(webDriver, trafficVolumeInput).sendKeys("12200");
        return this;
    }
    public DealPageB2B inputDesktopScreenshot(String screen) {
        findElement(webDriver, desktopScreenshotInput).sendKeys("desktop screenshot");
        return this;
    }
    public DealPageB2B inputMobileScreenshot(String screen) {
        findElement(webDriver, mobileScreenshotInput).sendKeys("mobile screenshot");
        return this;
    }
    public DealPageB2B clickOnSaveFormatButton() {
        findElement(webDriver, saveFormatButton).click();
        return this;
    }

    public DealPageB2B clickOnDealZidsBlock() {
        findElement(webDriver, dealZidsBlock).click();
        return this;
    }
    public DealPageB2B clickOnAddZidCidButton() {
        findElement(webDriver, addZidCidButton).click();
        return this;
    }
    public DealPageB2B inputSite(String site) {
        findElement(webDriver, siteInput).sendKeys("20578" + Keys.ENTER);
        return this;
    }
    public DealPageB2B inputZidCidValue(String value) {
        findElement(webDriver, zidCidValueInput).sendKeys(b);
        return this;
    }
    public DealPageB2B inputSelectPlaceZidCid(String place) {
        findElement(webDriver, selectPlaceInZidCidInput).sendKeys("article" + Keys.ENTER);
        return this;
    }
    public DealPageB2B inputLabel(String label) {
        findElement(webDriver, labelInZidCidInput).sendKeys("cyber" + Keys.ENTER);
        return this;
    }
    public DealPageB2B inputTrafficChannel(String channel) {
        findElement(webDriver, trafficChannelInput).sendKeys("desk" + Keys.ENTER);
        return this;
    }
    public DealPageB2B inputCommentInZidCid(String comment) {
        findElement(webDriver, commentInZidInput).sendKeys("comment");
        return this;
    }
    public DealPageB2B inputCodeInZidCid(String code) {
        findElement(webDriver, codeInput).sendKeys("some code");
        return this;
    }
    public DealPageB2B clickOnSaveZidCidButton() {
        findElement(webDriver, saveZidCidButton).click();
        return this;
    }
    public DealPageB2B assertZidCid() {
        Assert.assertEquals(waitForElementClickable(webDriver, infoZidCid).getText(),"cyber");
        return this;
    }

    public DealPageB2B clickOnDealPlacesBlock() {
        findElement(webDriver, dealPlacesBlock).click();
        return this;
    }
    public DealPageB2B inputSearchSiteById(String site) {
        findElement(webDriver, searchSiteByIdInput).sendKeys("" + Keys.DOWN + "" + Keys.ENTER);
        return this;
    }
    public DealPageB2B clickOnAddNewDealPlaceButton() {
        waitForElementClickable(webDriver, addNewDealPlaceButton).click();
        return this;
    }
    public DealPageB2B inputSelectPlaceNewDealPlace(String place) {
        findElement(webDriver, selectPlaceInNewDealPlaceInput).sendKeys("article" + Keys.ENTER);
        return this;
    }
    public DealPageB2B inputLabelNewDealPlace(String label) {
        findElement(webDriver, labelInZidCidInput).sendKeys("cyber" + Keys.ENTER);
        return this;
    }
    public DealPageB2B inputGEO(String geo) {
        findElement(webDriver, geoInput).sendKeys("Austria" + Keys.ENTER);
        return this;
    }
    public DealPageB2B inputLinkPp(String link) {
        findElement(webDriver, linkPpInput)
                .sendKeys("https://affpa.top/L?tag=d_1370971m_97c_&site=1370971&ad=97&r=registration/");
        return this;
    }
    public DealPageB2B inputCommentInDealPlace(String comment) {
        findElement(webDriver, commentInDealPlaceInput).sendKeys("comment");
        return this;
    }
    public DealPageB2B clickOnSaveDealPlaceButton() {
        findElement(webDriver, saveDealPlaceButton).click();
        return this;
    }
    public DealPageB2B assertDealPlace() {
        Assert.assertEquals(waitForElementClickable(webDriver, infoGEO).getText(),"Austria");
        return this;
    }

    public DealPageB2B clickOnSaveDealButton() throws InterruptedException {
        waitForInvisibility(webDriver, greenOverlay, 20L);
        waitForElementClickable(webDriver, saveDealButton).click();
        Thread.sleep(3000);
        return this;
    }
    public DealPageB2B clickOnSendOnReviewButton() {
        findElement(webDriver, sendOnReviewButton, 1000L).click();
        return this;
    }
    public DealPageB2B clickOnProfileButton() throws InterruptedException {
        Thread.sleep(3000);
        waitForElementClickable(webDriver, profileButton).click();
        return this;
    }
    public DealPageB2B clickOnExitButton() {
        findElement(webDriver, exitButton).click();
        findElement(webDriver, confirmExit).click();
        return this;
    }

    public DealPageB2B clickOnDealPaymentsBlockButton() {
        waitForElementClickable(webDriver, dealPaymentsBlockButton).click();
        return this;
    }
    public DealPageB2B clickOnNewContractButton() {
        waitForElementClickable(webDriver, newContractButton).click();
        return this;
    }
    public DealPageB2B inputContractName(String name) throws InterruptedException {
        findElement(webDriver, contractNameInput).sendKeys("Contract name");
        Thread.sleep(1000);
        return this;
    }
    public DealPageB2B inputStartDateInContract(String date) {
        findElement(webDriver, startDateInContractInput).click();
        findElement(webDriver, firstDate).click();
        return this;
    }
    public DealPageB2B inputEndDateInContract(String date) {
        findElement(webDriver, endDateInContractInput).click();
        findElement(webDriver, endDate).click();
        return this;
    }
    public DealPageB2B inputAttachFile(String contract) {
        WebElement inputFileInContract = webDriver.findElement(By.xpath("//div[@class='flex md12']//input[@type='file']"));
        unhide(webDriver, inputFileInContract);
        inputFileInContract.sendKeys("/files/contract.txt");
//        inputFileInContract.sendKeys("C:\\Users\\aberz\\Downloads\\picture.jpg");
        return this;
    }
    public DealPageB2B clickOnSaveContractButton() {
        findElement(webDriver, saveContractButton).click();
        return this;
    }
    public DealPageB2B assertContractName() {
        Assert.assertEquals(waitForElementClickable(webDriver, infoContractName).getText(),"Contract name");
        return this;
    }

    public DealPageB2B clickOnNewPaymentButton() throws InterruptedException {
        waitForElementClickable(webDriver, newPaymentButton).click();
        Thread.sleep(1000);
        return this;
    }
    public DealPageB2B inputStartDateInPayment(String date) {
        findElement(webDriver, head).click();
        waitForElementClickable(webDriver, startDateInPaymentInput).click();
        findElement(webDriver, firstDate).click();
        return this;
    }
    public DealPageB2B inputEndDateInPayment(String date) {
        findElement(webDriver,endDateInPaymentInput).click();
        findElement(webDriver, endDate).click();
        return this;
    }
    public DealPageB2B inputPaymentTarget(String target) {
        findElement(webDriver, paymentTargetInput).sendKeys("1x" + Keys.ARROW_DOWN + Keys.ENTER);
        return this;
    }
    public DealPageB2B inputType(String type) {
        findElement(webDriver, typeInput).sendKeys("prepaid" + Keys.ENTER);
        return this;
    }
    public DealPageB2B inputWallet(String wallet) {
        findElement(webDriver, walletInput).sendKeys("WMZ" + Keys.ARROW_DOWN + Keys.ENTER);
        return this;
    }
    public DealPageB2B inputCostInPayment(String cost) {
        findElement(webDriver, costInput).sendKeys("100");
        return this;
    }
    public DealPageB2B clickOnAutocheck() {
        findElement(webDriver, autocheckCheckbox).click();
        return this;
    }
    public DealPageB2B inputCommentInPayment(String comment) {
        findElement(webDriver, commentInPaymentInput).sendKeys("comment");
        return this;
    }
    public DealPageB2B clickOnContinueButton() {
        findElement(webDriver, continueButton).click();
        return this;
    }
    public DealPageB2B inputRemainingCost(String cost) throws InterruptedException {
        waitForElementClickable(webDriver, remainingCostInput).sendKeys("50");
        Thread.sleep(1000);
        return this;
    }
    public DealPageB2B inputRemainingZidCost(String cost) throws InterruptedException {
        findElement(webDriver, remainingZidCostInput).sendKeys("50");
        Thread.sleep(1500);
        return this;
    }
    public DealPageB2B clickOnSavePaymentButton() {
        waitForElementClickable(webDriver, savePaymentButton).click();
        return this;
    }
    public DealPageB2B clickOnApprovePaymentButton() throws InterruptedException {
        waitForElementClickable(webDriver, approvePaymentButton).click();
        Thread.sleep(3000);
        return this;
    }
    public DealPageB2B assertPayment() throws InterruptedException {
        Assert.assertEquals(waitForElementClickable(webDriver, infoWallet).
                getText(),"1x\n" + "WMZ Z146407012030\n" + "100 USD");
        Thread.sleep(5000);
        return this;
    }
}
