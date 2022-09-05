package com.ui.pages.Manager;

import com.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class DealPageFixApp extends BasePage {
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
    private final By addCommentButton = By.xpath("//div[contains(text(),' Add comment ')]");
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
    private final By newAnalyticsButton = By.xpath("//div[contains(text(),'Add analytics')]");

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

    private final By dealPlacesBlock = By.xpath("//div[contains(text(),'Deal places')]");
    private final By searchSiteByIdInput = By.xpath("//input[@id='cpi-deal_place-search']");
    private final By addNewDealPlaceButton = By.xpath
            ("//button[@class='v-btn v-btn--floating v-btn--outline v-btn--depressed v-btn--small theme--light primary--text']");
    private final By selectPlaceInNewDealPlaceInput = By.xpath("//div[@class='v-dialog v-dialog--active v-dialog--persistent']" +
            "//input[@aria-label='Select place']");
    private final By platformInput = By.xpath("//input[@aria-label='Platform']");
    private final By labelInput = By.xpath("//input[@aria-label='Label']");
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



    public DealPageFixApp(WebDriver webDriver) {
        super(webDriver);
    }

    public DealPageFixApp assertDealType() {
        Assert.assertEquals(findElement(webDriver, infoDealType).getAttribute("value"),"fix_app");
        return this;
    }
    public DealPageFixApp assertExtention() {
        Assert.assertEquals(findElement(webDriver, infoExtension).getAttribute("value"),"Test");
        return this;
    }
    public DealPageFixApp assertClassification() {
        Assert.assertEquals(findElement(webDriver, infoClassification).getAttribute("value"),"conv");
        return this;
    }
    public DealPageFixApp chooseVolClassification() {
        findElement(webDriver, infoClassification).click();
        findElement(webDriver, volClassification).click();
        return this;
    }
    public DealPageFixApp assertPartnerId() {
        Assert.assertEquals(findElement(webDriver, infoPartnerId).getText(),"Partner id");
        return this;
    }
    public DealPageFixApp assertProduct() {
        Assert.assertEquals(findElement(webDriver, infoProduct).getText(),"Product");
        return this;
    }
    public DealPageFixApp assertDealCost() {
        Assert.assertEquals(findElement(webDriver, infoDealCost).getText(),"Deal cost");
        return this;
    }
    public DealPageFixApp assertInProgress() {
        Assert.assertEquals(findElement(webDriver, infoInProgress).getText(),"In progress");
        return this;
    }
    public DealPageFixApp assertManager() {
        Assert.assertEquals(findElement(webDriver, infoManager).getText(),"Manager");
        return this;
    }
    public DealPageFixApp assertROI() {
        Assert.assertEquals(findElement(webDriver, infoROI).getText(),"ROI");
        return this;
    }

    public DealPageFixApp clickOnCommunicationButton() {
        findElement(webDriver, communicationButton).click();
        return this;
    }
    public DealPageFixApp inputCommentInCommunication(String comment) {
        findElement(webDriver, commentInput).sendKeys("1234");
        return this;
    }
    public DealPageFixApp addFileToComment(String comment) throws InterruptedException {
        Thread.sleep(3000);
        WebElement inputFileInComment = webDriver.findElement(By.xpath("//input[@type='file'][@id='files'][@accept='image/*']"));
        unhide(webDriver, inputFileInComment);
        inputFileInComment.sendKeys("C:\\Users\\aberz\\Downloads\\picture.jpg");
        return this;
    }
    public DealPageFixApp clickOnAddCommentButton() {
        waitForElementClickable(webDriver, addCommentButton).click();
        return this;
    }
    public DealPageFixApp findAddedComment() {
        findElement(webDriver, addedComment);
        return this;
    }
    public DealPageFixApp closeDealChat() {
        waitForElementClickable(webDriver, closeDealChat).click();
        return this;
    }

    public DealPageFixApp clickOnDealLogButton() {
        findElement(webDriver, dealLogButton).click();
        return this;
    }
    public DealPageFixApp findDealLog() {
        findElement(webDriver, assertLog);
        webDriver.navigate().back();
        return this;
    }

    public DealPageFixApp clickOnSiteOverviewBlock() throws InterruptedException {
        Thread.sleep(3000);
        waitForElementClickable(webDriver, siteOverviewBlock).click();
        return this;
    }
    public DealPageFixApp clickOnSearchLinkButton() {
        findElement(webDriver, searchLinkButton).click();
        return this;
    }
    public DealPageFixApp inputLink(String link) {
        waitForElementClickable(webDriver, linkInput).sendKeys("https://football.ua");
        return this;
    }
    public DealPageFixApp clickOnAddLinkButton() {
        findElement(webDriver, addLinkButton).click();
        return this;
    }
    public DealPageFixApp inputCostInAnalytics(String cost) {
        findElement(webDriver, costInputInAnalytics).sendKeys("100");
        return this;
    }
    public DealPageFixApp inputSelectAnalyticsFor1Month(String analytics) {
        waitForElementClickable(webDriver, selectAnalyticsInput).sendKeys("google" + Keys.ENTER);
        return this;
    }
    public DealPageFixApp inputAddScreenshotFor1Month(String screen) {
        findElement(webDriver, addScreenshotInput).sendKeys("screen");
        return this;
    }
    public DealPageFixApp selectStartDateFor1Month() {
        findElement(webDriver, startDateInput).click();
        findElement(webDriver, firstDate).click();
        return this;
    }
    public DealPageFixApp selectEndDateFor1Month() {
        findElement(webDriver, endDateInput).click();
        findElement(webDriver, endDate).click();
        return this;
    }
    public DealPageFixApp inputSelectAnalyticsFor3Month(String analytics) {
        findElement(webDriver, selectAnalyticsFor3MonthInput).sendKeys("google" + Keys.ENTER);
        return this;
    }
    public DealPageFixApp inputAddScreenshotFor3Month(String screen) {
        findElement(webDriver, addScreenshotFor3MonthInput).sendKeys("screen");
        return this;
    }
    public DealPageFixApp selectStartDateFor3Month() {
        findElement(webDriver, startDateFor3MonthInput).click();
        findElement(webDriver, firstDate).click();
        return this;
    }
    public DealPageFixApp selectEndDateFor3Month() {
        findElement(webDriver, endDateFor3MonthInput).click();
        findElement(webDriver, endDate).click();
        return this;
    }
    public DealPageFixApp inputTrafficOverview(String traffic) {
        findElement(webDriver, trafficOverviewInput).sendKeys("Traffic overview");
        return this;
    }
    public DealPageFixApp inputGeoTraffic(String traffic) {
        findElement(webDriver, geoTrafficInput).sendKeys("GEO traffic");
        return this;
    }
    public DealPageFixApp inputDeviceCategory(String category) {
        findElement(webDriver, deviceCategoryInput).sendKeys("Device category");
        return this;
    }
    public DealPageFixApp inputTrafficSource(String source) {
        findElement(webDriver, trafficSourcesInput).sendKeys("Traffic sources");
        return this;
    }
    public DealPageFixApp inputMobileDesktop(String mobile) {
        findElement(webDriver, mobileDesktopInput).sendKeys("5050");
        return this;
    }
    public DealPageFixApp inputCommentInAnalytics(String comment) {
        findElement(webDriver, commentInAnalyticsInput).sendKeys("comment");
        return this;
    }
    public DealPageFixApp clickOnNewAnalyticsButton() {
        findElement(webDriver, newAnalyticsButton).click();
        return this;
    }
    public DealPageFixApp clickOnFirstAnalyticsButton() {
        WebElement firstAnalButton = webDriver.findElement(By.xpath("//a[@class='v-tabs__item']"));
        Actions act = new Actions(webDriver);
        act.moveToElement(firstAnalButton).click().perform();
        return this;
    }

    public DealPageFixApp clickOnAddFormatButton() {
        waitForElementClickable(webDriver, addFormatButton).click();
        return this;
    }
    public DealPageFixApp inputSelectPlace(String place) {
        findElement(webDriver, selectPlaceInFormatInput).sendKeys("article" + Keys.ENTER);
        return this;
    }
    public DealPageFixApp inputCostInFormat(String cost) {
        findElement(webDriver, costInputInFormat).sendKeys("10");
        return this;
    }
    public DealPageFixApp inputCPM(String cpm) {
        findElement(webDriver, cpmInput).sendKeys("2");
        return this;
    }
    public DealPageFixApp inputTrafficVolume(String traffic) {
        findElement(webDriver, trafficVolumeInput).sendKeys("12200");
        return this;
    }
    public DealPageFixApp inputDesktopScreenshot(String screen) {
        findElement(webDriver, desktopScreenshotInput).sendKeys("desktop screenshot");
        return this;
    }
    public DealPageFixApp inputMobileScreenshot(String screen) {
        findElement(webDriver, mobileScreenshotInput).sendKeys("mobile screenshot");
        return this;
    }
    public DealPageFixApp clickOnSaveFormatButton() {
        findElement(webDriver, saveFormatButton).click();
        return this;
    }

    public DealPageFixApp clickOnDealPlacesBlock() {
        findElement(webDriver, dealPlacesBlock).click();
        return this;
    }
    public DealPageFixApp inputSearchSiteById(String site) {
        findElement(webDriver, searchSiteByIdInput).sendKeys("" + Keys.DOWN + "" + Keys.ENTER);
        return this;
    }
    public DealPageFixApp clickOnAddNewDealPlaceButton() {
        waitForElementClickable(webDriver, addNewDealPlaceButton).click();
        return this;
    }
    public DealPageFixApp inputSelectPlaceNewDealPlace(String place) {
        findElement(webDriver, selectPlaceInNewDealPlaceInput).sendKeys("article" + Keys.ENTER);
        return this;
    }
    public DealPageFixApp inputPlatformNewDealPlace(String platform) {
        findElement(webDriver, platformInput).sendKeys("All" + Keys.ENTER);
        return this;
    }
    public DealPageFixApp inputLabelNewDealPlace(String label) {
        findElement(webDriver, labelInput).sendKeys("cyber" + Keys.ENTER);
        return this;
    }
    public DealPageFixApp inputGEO(String geo) {
        findElement(webDriver, geoInput).sendKeys("Austria" + Keys.ENTER);
        return this;
    }
    public DealPageFixApp inputLinkPp(String link) {
        findElement(webDriver, linkPpInput)
                .sendKeys("https://affpa.top/L?tag=d_1370971m_97c_&site=1370971&ad=97&r=registration/");
        return this;
    }
    public DealPageFixApp inputCommentInDealPlace(String comment) {
        findElement(webDriver, commentInDealPlaceInput).sendKeys("comment");
        return this;
    }
    public DealPageFixApp clickOnSaveDealPlaceButton() {
        findElement(webDriver, saveDealPlaceButton).click();
        return this;
    }
    public DealPageFixApp assertDealPlace() {
        Assert.assertEquals(waitForElementClickable(webDriver, infoGEO).getText(),"Austria");
        return this;
    }

    public DealPageFixApp clickOnSaveDealButton() throws InterruptedException {
        waitForInvisibility(webDriver, greenOverlay, 20L);
        waitForElementClickable(webDriver, saveDealButton).click();
        Thread.sleep(3000);
        return this;
    }
    public DealPageFixApp clickOnSendOnReviewButton() {
        findElement(webDriver, sendOnReviewButton, 1000L).click();
        return this;
    }
    public DealPageFixApp clickOnProfileButton() throws InterruptedException {
        Thread.sleep(3000);
        waitForElementClickable(webDriver, profileButton).click();
        return this;
    }
    public DealPageFixApp clickOnExitButton() {
        findElement(webDriver, exitButton).click();
        findElement(webDriver, confirmExit).click();
        return this;
    }

    public DealPageFixApp clickOnDealPaymentsBlockButton() {
        waitForElementClickable(webDriver, dealPaymentsBlockButton).click();
        return this;
    }
    public DealPageFixApp clickOnNewContractButton() {
        waitForElementClickable(webDriver, newContractButton).click();
        return this;
    }
    public DealPageFixApp inputContractName(String name) throws InterruptedException {
        findElement(webDriver, contractNameInput).sendKeys("Contract name");
        Thread.sleep(1000);
        return this;
    }
    public DealPageFixApp inputStartDateInContract(String date) {
        findElement(webDriver, startDateInContractInput).click();
        findElement(webDriver, firstDate).click();
        return this;
    }
    public DealPageFixApp inputEndDateInContract(String date) {
        findElement(webDriver, endDateInContractInput).click();
        findElement(webDriver, endDate).click();
        return this;
    }
    public DealPageFixApp inputAttachFile(String contract) {
        WebElement inputFileInContract = webDriver.findElement(By.xpath("//div[@class='flex md12']//input[@type='file']"));
        unhide(webDriver, inputFileInContract);
        inputFileInContract.sendKeys("C:\\Users\\aberz\\Downloads\\contract.txt");
        return this;
    }
    public DealPageFixApp clickOnSaveContractButton() {
        findElement(webDriver, saveContractButton).click();
        return this;
    }
    public DealPageFixApp assertContractName() {
        Assert.assertEquals(waitForElementClickable(webDriver, infoContractName).getText(),"Contract name");
        return this;
    }

    public DealPageFixApp clickOnNewPaymentButton() throws InterruptedException {
        waitForElementClickable(webDriver, newPaymentButton).click();
        Thread.sleep(1000);
        return this;
    }
    public DealPageFixApp inputStartDateInPayment(String date) {
        findElement(webDriver, head).click();
        waitForElementClickable(webDriver, startDateInPaymentInput).click();
        findElement(webDriver, firstDate).click();
        return this;
    }
    public DealPageFixApp inputEndDateInPayment(String date) {
        findElement(webDriver,endDateInPaymentInput).click();
        findElement(webDriver, endDate).click();
        return this;
    }
    public DealPageFixApp inputPaymentTarget(String target) {
        findElement(webDriver, paymentTargetInput).sendKeys("1x" + Keys.ARROW_DOWN + Keys.ENTER);
        return this;
    }
    public DealPageFixApp inputType(String type) {
        findElement(webDriver, typeInput).sendKeys("prepaid" + Keys.ENTER);
        return this;
    }
    public DealPageFixApp inputWallet(String wallet) {
        findElement(webDriver, walletInput).sendKeys("WMZ" + Keys.ARROW_DOWN + Keys.ENTER);
        return this;
    }
    public DealPageFixApp inputCostInPayment(String cost) {
        findElement(webDriver, costInput).sendKeys("100");
        return this;
    }
    public DealPageFixApp clickOnAutocheck() {
        findElement(webDriver, autocheckCheckbox).click();
        return this;
    }
    public DealPageFixApp inputCommentInPayment(String comment) {
        findElement(webDriver, commentInPaymentInput).sendKeys("comment");
        return this;
    }
    public DealPageFixApp clickOnContinueButton() {
        findElement(webDriver, continueButton).click();
        return this;
    }
    public DealPageFixApp inputRemainingCost(String cost) throws InterruptedException {
        waitForElementClickable(webDriver, remainingCostInput).sendKeys("50");
        Thread.sleep(1000);
        return this;
    }
    public DealPageFixApp inputRemainingZidCost(String cost) throws InterruptedException {
        findElement(webDriver, remainingZidCostInput).sendKeys("50");
        Thread.sleep(1500);
        return this;
    }
    public DealPageFixApp clickOnSavePaymentButton() {
        waitForElementClickable(webDriver, savePaymentButton).click();
        return this;
    }
    public DealPageFixApp clickOnApprovePaymentButton() throws InterruptedException {
        waitForElementClickable(webDriver, approvePaymentButton).click();
        Thread.sleep(3000);
        return this;
    }
    public DealPageFixApp assertPayment() throws InterruptedException {
        Assert.assertEquals(waitForElementClickable(webDriver, infoWallet).
                getText(),"1x\n" + "WMZ Z146407012030\n" + "100 USD");
        Thread.sleep(5000);
        return this;
    }
}
