package com.ui.pages.Manager;

import com.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class DealPageFixZid extends BasePage {
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
    private final By searchLinkInput = By.xpath("//input[@id='cpi-link_search']");
    private final By addSiteButton = By.xpath("//button[@class='ma-0 v-btn v-btn--flat v-btn--icon theme--light']" +
            "//i[contains(text(), 'add')]");
    private final By totalCostInput = By.xpath("//input[@aria-label='Total cost']");
    private final By selectAnalyticsInput = By.xpath("//input[@id='fix_zid-analytic_type']");
    private final By mobileDesktopInput = By.xpath("//input[@id='fix_zid-ratio_devices']");
    private final By commentInAnalyticsInput = By.xpath("//textarea[@id='fix_zid-comment']");

    private final By searchSiteByIdInput = By.xpath("//input[@id='fix_zid-search_site']");
    private final By addLinkButton = By.xpath("//button[@id='fix_zid-add_place']");
    private final By selectPlaceInput = By.xpath("//input[@id='fix-zid-deal_place_type_id']");
    private final By costInput = By.xpath("//input[@id='fix-zid-cost']");
    private final By trafficVolumeInput = By.xpath("//input[@id='fix-zid-traffic_volume']");
    private final By cpmInput = By.xpath
            ("//div[@class='v-dialog v-dialog--active v-dialog--persistent']//input[@id='fix-zid-cpm']");
    private final By trafficChannelInput = By.xpath("//input[@id='fix-zid-traffic_channel']");
    private final By labelInput = By.xpath("//input[@id='fix-zid-label']");
    private final By geoInput = By.xpath("//input[@id='fix-zid-country_id']");
    private final By linkPpInput = By.xpath("//input[@id='fix-zid-link']");
    private final By desktopScreenshotInDealPlace = By.xpath
            ("//div[@class='v-dialog v-dialog--active v-dialog--persistent']//input[@id='fix-zid-screenshot_desktop']");
    private final By mobileScreenshotInDealPlace = By.xpath
            ("//div[@class='v-dialog v-dialog--active v-dialog--persistent']//input[@id='fix-zid-screenshot_mobile']");
    private final By saveDealPlaceButton = By.xpath("//button[@id='fix-zid-save_place']");
    private final By infoGEO = By.xpath("//td[contains(.,'Austria')]");

    private final By addZidCidButton = By.xpath("//button[@id='fix_zid-add_zid']");
    int a = (int) (Math.random() * 100000000);
    String b = String.valueOf(a);
    private final By zidCidValueInput = By.xpath("//input[@id='fix_zid-zid_solo']");
    private final By selectPlaceInZidCidInput = By.xpath("//input[@id='fix_zid-zid_deal_place_type_id']");
    private final By labelInZidCidInput = By.xpath("//input[@id='fix_zid-zid_label']");
    private final By trafficChannelInZidCidInput = By.xpath("//input[@id='fix_zid-zid_traffic_channel']");
    private final By cpmInZidCidInput = By.xpath("//input[@id='fix-zid-cpm']");
    private final By desktopScreenInZidCidInput = By.xpath
            ("//div[@class='v-dialog v-dialog--active v-dialog--persistent']//input[@id='fix-zid-screenshot_desktop']");
    private final By mobileScreenInZidCidInput = By.xpath
            ("//div[@class='v-dialog v-dialog--active v-dialog--persistent']//input[@id='fix-zid-screenshot_mobile']");
    private final By commentInZidCidInput = By.xpath("//textarea[@id='fix_zid-zid_comment']");
    private final By codeInZidCidInput = By.xpath("//textarea[@aria-label='Сode']");
    private final By saveZidCidButton = By.xpath("//button[@id='fix_zid-zid_save']");
    private final By infoLabel = By.xpath("//td[contains(.,'allgamesentrance')]");

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
    private final By firstDate = By.xpath("//div[contains(text(),'1')]");
    private final By endDate = By.xpath("//div[contains(text(),'28')]");
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
    private final By costInPaymentInput = By.xpath("//input[@id='payment-summary']");
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

    public DealPageFixZid(WebDriver webDriver) {
        super(webDriver);
    }

    public DealPageFixZid assertDealType() {
        Assert.assertEquals(findElement(webDriver, infoDealType).getAttribute("value"),"fix_zid");
        return this;
    }
    public DealPageFixZid assertExtention() {
        Assert.assertEquals(findElement(webDriver, infoExtension).getAttribute("value"),"Test");
        return this;
    }
    public DealPageFixZid assertClassification() {
        Assert.assertEquals(findElement(webDriver, infoClassification).getAttribute("value"),"conv");
        return this;
    }
    public DealPageFixZid chooseVolClassification() {
        findElement(webDriver, infoClassification).click();
        findElement(webDriver, volClassification).click();
        return this;
    }
    public DealPageFixZid assertPartnerId() {
        Assert.assertEquals(findElement(webDriver, infoPartnerId).getText(),"Partner id");
        return this;
    }
    public DealPageFixZid assertProduct() {
        Assert.assertEquals(findElement(webDriver, infoProduct).getText(),"Product");
        return this;
    }
    public DealPageFixZid assertDealCost() {
        Assert.assertEquals(findElement(webDriver, infoDealCost).getText(),"Deal cost");
        return this;
    }
    public DealPageFixZid assertInProgress() {
        Assert.assertEquals(findElement(webDriver, infoInProgress).getText(),"In progress");
        return this;
    }
    public DealPageFixZid assertManager() {
        Assert.assertEquals(findElement(webDriver, infoManager).getText(),"Manager");
        return this;
    }
    public DealPageFixZid assertROI() {
        Assert.assertEquals(findElement(webDriver, infoROI).getText(),"ROI");
        return this;
    }

    public DealPageFixZid clickOnCommunicationButton() {
        findElement(webDriver, communicationButton).click();
        return this;
    }
    public DealPageFixZid inputCommentInCommunication(String comment) {
        findElement(webDriver, commentInput).sendKeys("1234");
        return this;
    }
    public DealPageFixZid addFileToComment(String comment) throws InterruptedException {
        Thread.sleep(3000);
        WebElement inputFileInComment = webDriver.findElement(By.xpath("//input[@type='file'][@id='files'][@accept='image/*']"));
        unhide(webDriver, inputFileInComment);
        inputFileInComment.sendKeys("C:\\Users\\aberz\\Downloads\\picture.jpg");
        return this;
    }
    public DealPageFixZid clickOnAddCommentButton() {
        waitForElementClickable(webDriver, addCommentButton).click();
        return this;
    }
    public DealPageFixZid findAddedComment() {
        findElement(webDriver, addedComment);
        return this;
    }
    public DealPageFixZid closeDealChat() {
        waitForElementClickable(webDriver, closeDealChat).click();
        return this;
    }

    public DealPageFixZid clickOnDealLogButton() {
        findElement(webDriver, dealLogButton).click();
        return this;
    }
    public DealPageFixZid findDealLog() {
        findElement(webDriver, assertLog);
        webDriver.navigate().back();
        return this;
    }

    public DealPageFixZid clickOnSiteOverviewBlock() {
        waitForElementClickable(webDriver, siteOverviewBlock).click();
        return this;
    }
    public DealPageFixZid inputSite(String link) {
        waitForElementClickable(webDriver, searchLinkInput).sendKeys("https://football.ua");
        return this;
    }
    public DealPageFixZid clickOnAddSiteButton() {
        findElement(webDriver, addSiteButton).click();
        return this;
    }
    public DealPageFixZid inputTotalCost(String cost) {
        findElement(webDriver, totalCostInput).sendKeys("100" + Keys.ENTER);
        return this;
    }
    public DealPageFixZid inputSelectAnalytics(String analytics) throws InterruptedException {
        Thread.sleep(3000);
        findElement(webDriver, selectAnalyticsInput).sendKeys("" + Keys.ARROW_DOWN + Keys.ENTER);
        return this;
    }
    public DealPageFixZid inputMobileDesktop(String mobile) {
        findElement(webDriver, mobileDesktopInput).sendKeys("5050");
        return this;
    }
    public DealPageFixZid inputCommentInAnalytics(String comment) {
        findElement(webDriver, commentInAnalyticsInput).sendKeys("comment");
        return this;
    }
    public DealPageFixZid addFileToTrafficScreenshot(String comment) {
        WebElement inputFileInComment = webDriver.findElement(By.xpath("(//input[@type='file'][@class='filepond--browser'])[1]"));
        unhide(webDriver, inputFileInComment);
        inputFileInComment.sendKeys("C:\\Users\\aberz\\Downloads\\picture.jpg");
        return this;
    }
    public DealPageFixZid addFileToDevicesScreenshot(String comment) {
        WebElement inputFileInComment = webDriver.findElement(By.xpath("(//input[@type='file'][@class='filepond--browser'])[2]"));
        unhide(webDriver, inputFileInComment);
        inputFileInComment.sendKeys("C:\\Users\\aberz\\Downloads\\picture.jpg");
        return this;
    }
    public DealPageFixZid addFileToTotalScreenshot(String comment) {
        WebElement inputFileInComment = webDriver.findElement(By.xpath("(//input[@type='file'][@class='filepond--browser'])[3]"));
        unhide(webDriver, inputFileInComment);
        inputFileInComment.sendKeys("C:\\Users\\aberz\\Downloads\\picture.jpg");
        return this;
    }
    public DealPageFixZid addFileToOtherScreenshot(String comment) {
        WebElement inputFileInComment = webDriver.findElement(By.xpath("(//input[@type='file'][@class='filepond--browser'])[4]"));
        unhide(webDriver, inputFileInComment);
        inputFileInComment.sendKeys("C:\\Users\\aberz\\Downloads\\picture.jpg");
        return this;
    }

    public DealPageFixZid inputSearchSiteById(String site) throws InterruptedException {
        findElement(webDriver, searchSiteByIdInput).sendKeys("");
        Thread.sleep(15000);
        findElement(webDriver, searchSiteByIdInput).sendKeys("" + Keys.DOWN + "" + Keys.ENTER);
        return this;
    }
    public DealPageFixZid clickOnAddLinkButton() {
        waitForElementClickable(webDriver, addLinkButton).click();
        return this;
    }
    public DealPageFixZid inputSelectPlace(String place) {
        findElement(webDriver, selectPlaceInput).sendKeys("adaptive_banner" + Keys.ENTER);
        return this;
    }
    public DealPageFixZid inputCost(String cost) {
        findElement(webDriver, costInput).sendKeys("2");
        return this;
    }
    public DealPageFixZid inputTrafficVolume(String trVolume) {
        findElement(webDriver, trafficVolumeInput).sendKeys("2");
        return this;
    }
    public DealPageFixZid inputCPM(String cpm) {
        findElement(webDriver, cpmInput).sendKeys("2");
        return this;
    }
    public DealPageFixZid inputTrafficChannel(String trChannel) {
        findElement(webDriver, trafficChannelInput).sendKeys("all" + Keys.ENTER);
        return this;
    }
    public DealPageFixZid inputLabel(String label) {
        findElement(webDriver, labelInput).sendKeys("cyber" + Keys.ENTER);
        return this;
    }
    public DealPageFixZid inputGEO(String geo) {
        findElement(webDriver, geoInput).sendKeys("Austria" + Keys.ENTER);
        return this;
    }
    public DealPageFixZid inputLinkPP(String linkPP) {
        findElement(webDriver, linkPpInput)
                .sendKeys("http://refpa.top/L?tag=d_468749m_97c_&site=468749&ad=97&r=registration/");
        return this;
    }
    public DealPageFixZid inputDesktopScreenshotInDealPlace(String screenshot) {
        findElement(webDriver, desktopScreenshotInDealPlace).sendKeys("screenshot");
        return this;
    }
    public DealPageFixZid inputMobileScreenshotInDealPlace(String screenshot) {
        findElement(webDriver, mobileScreenshotInDealPlace).sendKeys("screenshot");
        return this;
    }
    public DealPageFixZid clickOnSaveDealPlaceButton() {
        findElement(webDriver, saveDealPlaceButton).click();
        return this;
    }
    public DealPageFixZid assertDealPlace() {
        Assert.assertEquals(waitForElementClickable(webDriver, infoGEO).getText(),"Austria");
        return this;
    }

    public DealPageFixZid clickOnAddZidCidButton() {
        findElement(webDriver, addZidCidButton).click();
        return this;
    }
    public DealPageFixZid inputZidCidValue(String value) {
        findElement(webDriver, zidCidValueInput).sendKeys(b);
        return this;
    }
    public DealPageFixZid inputSelectPlaceInZidCid(String place) {
        findElement(webDriver, selectPlaceInZidCidInput).sendKeys("adaptive_banner" + Keys.ENTER);
        return this;
    }
    public DealPageFixZid inputLabelInZidCid(String label) {
        findElement(webDriver, labelInZidCidInput).sendKeys("allgamesentrance" + Keys.ENTER);
        return this;
    }
    public DealPageFixZid inputTrafficChannelInZidCid(String trChannel) {
        findElement(webDriver, trafficChannelInZidCidInput).sendKeys("all" + Keys.ENTER);
        return this;
    }
    public DealPageFixZid inputCPMInZidCid(String cpm) {
        findElement(webDriver, cpmInZidCidInput).sendKeys("2");
        return this;
    }
    public DealPageFixZid inputDesktopScreenInZidCid(String screen) {
        findElement(webDriver, desktopScreenInZidCidInput).sendKeys("screenshot");
        return this;
    }
    public DealPageFixZid inputMobileScreenInZidCid(String screen) {
        findElement(webDriver, mobileScreenInZidCidInput).sendKeys("screenshot");
        return this;
    }
    public DealPageFixZid inputCommentInZidCid(String comment) {
        findElement(webDriver, commentInZidCidInput).sendKeys("comment");
        return this;
    }
    public DealPageFixZid inputCodeInZidCid(String screen) {
        findElement(webDriver, codeInZidCidInput).sendKeys("code");
        return this;
    }
    public DealPageFixZid clickOnSaveZidCidButton() {
        findElement(webDriver, saveZidCidButton).click();
        return this;
    }
    public DealPageFixZid assertZidCid() {
        Assert.assertEquals(waitForElementClickable(webDriver, infoLabel).getText(),"allgamesentrance");
        return this;
    }

    public DealPageFixZid clickOnSaveDealButton() throws InterruptedException {
        waitForInvisibility(webDriver, greenOverlay, 20L);
        waitForElementClickable(webDriver, saveDealButton).click();
        Thread.sleep(1000);
        return this;
    }
    public DealPageFixZid clickOnSendOnReviewButton() {
        findElement(webDriver, sendOnReviewButton, 1000L).click();
        return this;
    }
    public DealPageFixZid clickOnProfileButton() throws InterruptedException {
        Thread.sleep(3000);
        waitForElementClickable(webDriver, profileButton).click();
        return this;
    }
    public DealPageFixZid clickOnExitButton() {
        findElement(webDriver, exitButton).click();
        findElement(webDriver, confirmExit).click();
        return this;
    }

    public DealPageFixZid clickOnDealPaymentsBlockButton() {
        waitForElementClickable(webDriver, dealPaymentsBlockButton).click();
        return this;
    }
    public DealPageFixZid clickOnNewContractButton() {
        waitForElementClickable(webDriver, newContractButton).click();
        return this;
    }
    public DealPageFixZid inputContractName(String name) throws InterruptedException {
        findElement(webDriver, contractNameInput).sendKeys("Contract name");
        Thread.sleep(1000);
        return this;
    }
    public DealPageFixZid inputStartDateInContract(String date) {
        findElement(webDriver, startDateInContractInput).click();
        findElement(webDriver, firstDate).click();
        return this;
    }
    public DealPageFixZid inputEndDateInContract(String date) {
        findElement(webDriver, endDateInContractInput).click();
        findElement(webDriver, endDate).click();
        return this;
    }
    public DealPageFixZid inputAttachFile(String contract) {
        WebElement inputFileInContract = webDriver.findElement(By.xpath("//div[@class='flex md12']//input[@type='file']"));
        unhide(webDriver, inputFileInContract);
        inputFileInContract.sendKeys("C:\\Users\\aberz\\Downloads\\contract.txt");
        return this;
    }
    public DealPageFixZid clickOnSaveContractButton() {
        findElement(webDriver, saveContractButton).click();
        return this;
    }
    public DealPageFixZid assertContractName() {
        Assert.assertEquals(waitForElementClickable(webDriver, infoContractName).getText(),"Contract name");
        return this;
    }

    public DealPageFixZid clickOnNewPaymentButton() throws InterruptedException {
        waitForElementClickable(webDriver, newPaymentButton).click();
        Thread.sleep(1000);
        return this;
    }
    public DealPageFixZid inputStartDateInPayment(String date) {
        findElement(webDriver, head).click();
        waitForElementClickable(webDriver, startDateInPaymentInput).click();
        findElement(webDriver, firstDate).click();
        return this;
    }
    public DealPageFixZid inputEndDateInPayment(String date) {
        findElement(webDriver,endDateInPaymentInput).click();
        findElement(webDriver, endDate).click();
        return this;
    }
    public DealPageFixZid inputPaymentTarget(String target) {
        findElement(webDriver, paymentTargetInput).sendKeys("1x" + Keys.ARROW_DOWN + Keys.ENTER);
        return this;
    }
    public DealPageFixZid inputType(String type) {
        findElement(webDriver, typeInput).sendKeys("prepaid" + Keys.ENTER);
        return this;
    }
    public DealPageFixZid inputWallet(String wallet) {
        findElement(webDriver, walletInput).sendKeys("WMZ" + Keys.ARROW_DOWN + Keys.ENTER);
        return this;
    }
    public DealPageFixZid inputCostInPayment(String cost) {
        findElement(webDriver, costInPaymentInput).sendKeys("100");
        return this;
    }
    public DealPageFixZid clickOnAutocheck() {
        findElement(webDriver, autocheckCheckbox).click();
        return this;
    }
    public DealPageFixZid inputCommentInPayment(String comment) {
        findElement(webDriver, commentInPaymentInput).sendKeys("comment");
        return this;
    }
    public DealPageFixZid clickOnContinueButton() {
        findElement(webDriver, continueButton).click();
        return this;
    }
    public DealPageFixZid inputRemainingCost(String cost) throws InterruptedException {
        waitForElementClickable(webDriver, remainingCostInput).sendKeys("50");
        Thread.sleep(1000);
        return this;
    }
    public DealPageFixZid inputRemainingZidCost(String cost) throws InterruptedException {
        findElement(webDriver, remainingZidCostInput).sendKeys("50");
        Thread.sleep(1500);
        return this;
    }
    public DealPageFixZid clickOnSavePaymentButton() {
        waitForElementClickable(webDriver, savePaymentButton).click();
        return this;
    }
    public DealPageFixZid clickOnApprovePaymentButton() throws InterruptedException {
        waitForElementClickable(webDriver, approvePaymentButton).click();
        Thread.sleep(3000);
        return this;
    }
    public DealPageFixZid assertPayment() throws InterruptedException {
        Assert.assertEquals(waitForElementClickable(webDriver, infoWallet).
                getText(),"1x\n" + "WMZ Z146407012030\n" + "100 USD");
        Thread.sleep(5000);
        return this;
    }
}
