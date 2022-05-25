package com.ui.pages.ManagerCreateDealB2B;

import com.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DealPageB2B extends BasePage {
    private final By infoDealType = By.xpath("//input[@aria-label='Deal type']");
    private final By infoExtension = By.xpath("//input[@aria-label='Extension']");
    private final By infoPartnerId = By.xpath("//h5[contains(text(),'Partner id')]");
    private final By infoProduct = By.xpath("//h5[contains(text(),'Product')]");
    private final By infoDealCost = By.xpath("//h5[contains(text(),'Deal cost')]");
    private final By infoInProgress = By.xpath("//h5[contains(text(),'In progress')]");
    private final By infoManager = By.xpath("//h5[contains(text(),'Manager')]");
    private final By infoROI = By.xpath("//h5[contains(text(),'ROI')]");

    private final By communicationButton = By.xpath("//div[contains(text(),'Communication')]");
    private final By commentInput = By.xpath("//textarea[@aria-label='Write a comment']");
    private final By addFileInComment = By.xpath("//div[@class='flex image-wrap md5']//input[@type='file']");
    private final By addCommentButton = By.xpath("//i[contains(text(),'send')]");
    private final By addedComment = By.xpath("//div[@class='comment-author']");
    private final By exitDealChat = By.xpath("//div[@class='v-dialog__content v-dialog__content--active']");

    private final By dealLogButton = By.xpath("//div[contains(text(),'Deal log')]");
    private final By assertLog = By.xpath("//strong[contains(text(),'Create deal')]");

    private final By siteOverviewBlock = By.xpath("//div[contains(text(),'Site Overview')]");
    private final By searchLinkButton = By.xpath("//i[contains(.,'search')]");
    private final By linkInput = By.xpath("//input[@aria-label='Search by link']");
    private final By addLinkButton = By.xpath("//button//i[contains(text(), 'add')]");
    private final By costInputInAnalytics = By.xpath("//input[@aria-label='Cost']");
    private final By selectAnalyticsInput = By.xpath("//input[@placeholder='Select analytics']");
    private final By addScreenshotInput = By.xpath("//input[@placeholder='Add screenshot']");
    private final By startDateInput = By.xpath("//input[@aria-label='Start date']");
    private final By endDateInput = By.xpath("//input[@aria-label='End date']");
    private final By trafficOverviewInput = By.xpath("//input[@aria-label='Traffic Overview']");
    private final By geoTrafficInput = By.xpath("//input[@aria-label='GEO Traffic']");
    private final By deviceCategoryInput = By.xpath("//input[@aria-label='Device - Category']");
    private final By trafficSourcesInput = By.xpath("//input[@aria-label='Traffic Sources']");
    private final By mobileDesktopInput = By.xpath("//input[@aria-label='Mobile / Desktop %']");
    private final By commentInAnalyticsInput = By.xpath("//textarea[@aria-label='Comment']");
    private final By newAnalyticsButton = By.xpath("//div[contains(text(),'New analytics')]");
    private final By firstAnalyticsButton = By.xpath("//a[@class='v-tabs__item']");

    private final By addFormatButton = By.xpath("//div[contains(text(),'Ad format')]");
    private final By selectPlaceInput = By.xpath("//input[@aria-label='Select place']");
    private final By costInputInFormat = By.xpath("//input[@aria-label='Cost']");
    private final By cpmInput = By.xpath("//input[@aria-label='CPM']");
    private final By trafficVolumeInput = By.xpath("//input[@aria-label='Traffic volume']");
    private final By desktopScreenshotInput = By.xpath("//input[@aria-label='Desktop screenshot']");
    private final By mobileScreenshotInput = By.xpath("//input[@aria-label='Mobile screenshot']");
    private final By saveFormatButton = By.xpath("//button//div[contains(.,'Save')]");

    private final By dealZidsBlock = By.xpath("//div[contains(text(),'Deal zids')]");
    private final By addZidCidButton = By.xpath("//button//div[contains(text(),' Add Zid / Cid ')]");
    private final By siteInput = By.xpath("//input[@aria-label='Select site']");
    private final By zidCidValueInput = By.xpath("//input[@aria-label='Zid/Cid value']");
    int a = (int) (Math.random() * 100000);
    String b = String.valueOf(a);
    private final By labelInput = By.xpath("//input[@aria-label='Label']");
    private final By trafficChannelInput = By.xpath("//input[@aria-label='Traffic channel']");
    private final By commentInZidInput = By.xpath("//div[contains(.,'New zid/cid')]//textarea[@aria-label='Comment']");
    private final By codeInput = By.xpath("//textarea[@aria-label='Сode']");
    private final By saveZidCidButton = By.xpath("//button//div[contains(.,'Save')]");
    private final By infoZidCid = By.xpath("//th[contains(.,'Zid/Cid value')]");

    private final By dealPlacesBlock = By.xpath("//div[contains(text(),'Deal places')]");
    private final By searchSiteByIdInput = By.xpath("//input[@aria-label='Search site by id']");
    private final By addNewDealPlaceButton = By.xpath("//i[contains(.,'add')]");
    private final By geoInput = By.xpath("//input[@aria-label='GEO']");
    private final By linkPpInput = By.xpath("//input[@aria-label='Link PP']");
    private final By commentInDealPlaceInput = By.xpath("//div[contains(.,' New deal place ')]//textarea[@aria-label='Comment']");
    private final By saveDealPlaceButton = By.xpath("//button//div[contains(.,'Save')]");
    private final By saveDealButton = By.xpath("//button//i[contains(., 'save')]");
    private final By infoGEO = By.xpath("//td[contains(.,'Austria')]");
    private final By sendOnReviewButton = By.xpath("//span[contains(text(),'send on review')]");
    private final By profileButton = By.xpath("//button[@id='profile_btn']");
    private final By exitButton = By.xpath("//a[@id='exit_btn']");

    private final By dealPaymentsBlockButton = By.xpath("//div[contains(text(),'Deal payments & contracts')]");
    private final By newContractButton = By.xpath("//div[contains(text(),' New contract ')]");
    private final By contractNameInput = By.xpath("//input[@aria-label='Contract name']");
    private final By startDateInContractInput = By.xpath("//div[@class='flex md6']//input[@aria-label='Start date']");
    private final By endDateInContractInput = By.xpath("//div[@class='flex md6']//input[@aria-label='End date']");
    private final By attachFileInput = By.xpath("//div[@class='flex md12']//input[@type='file']");
    private final By saveContractButton =
            By.xpath("//div[@class='v-dialog__content v-dialog__content--active']//div[contains(text(),'Save')]");
    private final By infoContractName = By.xpath("//td[contains(text(),'Contract name')]");

    private final By newPaymentButton = By.xpath("//button[@id='add-payment']");
    private final By startDateInPaymentInput = By.xpath("//input[@id='payment-start_date']");
    private final By endDateInPaymentInput = By.xpath("//input[@id='payment-end_date']");
    private final By paymentTargetInput = By.xpath("//input[@id='payment-payment_target_id']");
    private final By typeInput = By.xpath("//input[@id='payment-type']");
    private final By walletInput = By.xpath("//input[@id='payment-wallet_id']");
    private final By costInput = By.xpath("//input[@id='payment-summary']");
    private final By commentInPaymentInput = By.xpath("//textarea[@id='payment-comment']");
    private final By continueButton = By.xpath("//div[contains(text(),'Continue')]");
    private final By remainingCostInput = By.xpath("//input[@aria-label='Cost']");
    private final By remainingZidCostInput = By.xpath("//input[@id='payment-analytic-zid-cost']");
    private final By savePaymentButton = By.xpath("//div[contains(text(),'Save payment')]");
    private final By approvePaymentButton = By.xpath("//i[contains(., 'thumb_up')]");
    private final By infoWallet = By.xpath("//div[contains(text(),' 1x ')]");

    public DealPageB2B(WebDriver webDriver) {
        super(webDriver);
    }

    public DealPageB2B assertPartnerId() {
        Assert.assertEquals(waitForElementClickable(webDriver, infoPartnerId).getText(),"Partner id");
        return this;
    }
    public DealPageB2B assertProduct() {
        Assert.assertEquals(waitForElementClickable(webDriver, infoProduct).getText(),"Product");
        return this;
    }
    public DealPageB2B assertDealCost() {
        Assert.assertEquals(waitForElementClickable(webDriver, infoDealCost).getText(),"Deal cost");
        return this;
    }
    public DealPageB2B assertInProgress() {
        Assert.assertEquals(waitForElementClickable(webDriver, infoInProgress).getText(),"In progress");
        return this;
    }
    public DealPageB2B assertManager() {
        Assert.assertEquals(waitForElementClickable(webDriver, infoManager).getText(),"Manager");
        return this;
    }
    public DealPageB2B assertROI() {
        Assert.assertEquals(waitForElementClickable(webDriver, infoROI).getText(),"ROI");
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
    public DealPageB2B addFileToComment(String comment) {
        findElement(webDriver, addFileInComment).sendKeys("C:\\Users\\aberz\\Downloads\\picture.jpg");
        return this;
    }
    public DealPageB2B clickOnAddCommentButton() {
        waitForElementClickable(webDriver, addCommentButton).click();
        return this;
    }
    public DealPageB2B findAddedComment() {
        findElements(webDriver, addedComment);
        return this;
    }

    public DealPageB2B closeDealChat() {
        waitForElementClickable(webDriver, exitDealChat).click();
        return this;
    }

    public DealPageB2B clickOnDealLogButton() {
        findElement(webDriver, dealLogButton).click();
        return this;
    }
    public DealPageB2B findDealLog() {
        findElements(webDriver, assertLog);
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
    public DealPageB2B inputLink(String link) {
        waitForElementClickable(webDriver, linkInput).sendKeys("https://football.ua");
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
    public DealPageB2B inputSelectAnalytics(String analytics) {
        findElement(webDriver, selectAnalyticsInput).sendKeys("google" + Keys.ENTER);
        return this;
    }
    public DealPageB2B inputAddScreenshot(String screen) {
        findElement(webDriver, addScreenshotInput).sendKeys("screen");
        return this;
    }
    public DealPageB2B inputStartDateFor1Month(String start) {
        findElement(webDriver, startDateInput).sendKeys("2022-05-01" + Keys.ENTER);
        return this;
    }
    public DealPageB2B inputEndDateFor1Month(String end) {
        findElement(webDriver, endDateInput).sendKeys("2022-05-31" + Keys.ENTER);
        return this;
    }
    public DealPageB2B inputTrafficOverview(String traffic) {
        findElement(webDriver, trafficOverviewInput).sendKeys("Traffic overview");
        return this;
    }
    public DealPageB2B inputGeoTraffic(String traffic) {
        findElement(webDriver, geoTrafficInput).sendKeys("GEO traffic" + Keys.ENTER);
        return this;
    }
    public DealPageB2B inputDeviceCategory(String category) {
        findElement(webDriver, deviceCategoryInput).sendKeys("Device category" + Keys.ENTER);
        return this;
    }
    public DealPageB2B inputTrafficSource(String source) {
        findElement(webDriver, trafficSourcesInput).sendKeys("Traffic sources" + Keys.ENTER);
        return this;
    }
    public DealPageB2B inputMobileDesktop(String mobile) {
        findElement(webDriver, mobileDesktopInput).sendKeys("mobile" + Keys.ENTER);
        return this;
    }
    public DealPageB2B inputCommentInAnalytics(String comment) {
        findElement(webDriver, commentInAnalyticsInput).sendKeys("comment" + Keys.ENTER);
        return this;
    }
    public DealPageB2B clickOnNewAnalyticsButton() {
        findElement(webDriver, newAnalyticsButton).click();
        return this;
    }
    public DealPageB2B clickOnFirstAnalyticsButton() {
        findElement(webDriver, firstAnalyticsButton).click();
        return this;
    }

    public DealPageB2B clickOnAddFormatButton() {
        waitForElementClickable(webDriver, addFormatButton).click();
        return this;
    }
    public DealPageB2B inputSelectPlace(String place) {
        findElement(webDriver, selectPlaceInput).sendKeys("article" + Keys.ENTER);
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

    public DealPageB2B clickOnDealZidsBlock(){
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
        findElement(webDriver, selectPlaceInput).sendKeys("article" + Keys.ENTER);
        return this;
    }
    public DealPageB2B inputLabel(String label) {
        findElement(webDriver, labelInput).sendKeys("cyber" + Keys.ENTER);
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
        Assert.assertEquals(waitForElementClickable(webDriver, infoZidCid).getText(),"Zid/Cid value");
        return this;
    }

    public DealPageB2B clickOnDealPlacesBlock() {
        findElement(webDriver, dealPlacesBlock).click();
        return this;
    }
    public DealPageB2B inputSearchSiteById(String site) {
        findElement(webDriver, searchSiteByIdInput).sendKeys("20578" + Keys.ENTER);
        return this;
    }
    public DealPageB2B clickOnAddNewDealPlaceButton() {
        findElement(webDriver, addNewDealPlaceButton).click();
        return this;
    }
    public DealPageB2B inputSelectPlaceNewDealPlace(String place) {
        findElement(webDriver, selectPlaceInput).sendKeys("article" + Keys.ENTER);
        return this;
    }
    public DealPageB2B inputLabelNewDealPlace(String label) {
        findElement(webDriver, labelInput).sendKeys("cyber" + Keys.ENTER);
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

    public DealPageB2B clickOnSaveDealButton() {
        findElement(webDriver, saveDealButton).click();
        return this;
    }
    public DealPageB2B clickOnSendOnReviewButton() {
        waitForElementClickable(webDriver, sendOnReviewButton).click();
        return this;
    }
    public DealPageB2B clickOnProfileButton() {
        waitForElementClickable(webDriver, profileButton).click();
        return this;
    }
    public DealPageB2B clickOnExitButton() {
        findElement(webDriver, exitButton).click();
        return this;
    }

    public DealPageB2B clickOnDealPaymentsBlockButton() {
        waitForElementClickable(webDriver, dealPaymentsBlockButton).click();
        return this;
    }
    public DealPageB2B clickOnNewContractButton() {
        findElement(webDriver, newContractButton).click();
        return this;
    }
    public DealPageB2B inputContractName(String name) {
        findElement(webDriver, contractNameInput).sendKeys("Contract name");
        return this;
    }
    public DealPageB2B inputStartDateInContract(String date) {
        findElement(webDriver, startDateInContractInput).sendKeys("2022-01-01" + Keys.ENTER);
        return this;
    }
    public DealPageB2B inputEndDateInContract(String date) {
        findElement(webDriver, endDateInContractInput).sendKeys("2022-02-01" + Keys.ENTER);
        return this;
    }
    public DealPageB2B inputAttachFile(String contract) {
        findElement(webDriver, attachFileInput).sendKeys("C:\\Users\\aberz\\Downloads\\contract.txt");
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

    public DealPageB2B clickOnNewPaymentButton() {
        waitForElementClickable(webDriver, newPaymentButton).click();
        return this;
    }
    public DealPageB2B inputStartDateInPayment(String date) {
        findElement(webDriver, startDateInPaymentInput).sendKeys("2022-01-01" + Keys.ENTER);
        return this;
    }
    public DealPageB2B inputEndDateInPayment(String date) {
        findElement(webDriver,endDateInPaymentInput).sendKeys("2022-02-01" + Keys.ENTER);
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
    public DealPageB2B inputCommentInPayment(String comment) {
        findElement(webDriver, commentInPaymentInput).sendKeys("comment");
        return this;
    }
    public DealPageB2B clickOnContinueButton() {
        findElement(webDriver, continueButton).click();
        return this;
    }
    public DealPageB2B inputRemainingCost(String cost) {
        waitForElementClickable(webDriver, remainingCostInput).sendKeys("50");
        return this;
    }
    public DealPageB2B inputRemainingZidCost(String cost) {
        findElement(webDriver, remainingZidCostInput).sendKeys("50");
        return this;
    }
    public DealPageB2B clickOnSavePaymentButton() {
        findElement(webDriver, savePaymentButton).click();
        return this;
    }
    public DealPageB2B clickOnApprovePaymentButton() {
        waitForElementClickable(webDriver, approvePaymentButton).click();
        return this;
    }
    public DealPageB2B assertPayment() {
        Assert.assertEquals(waitForElementClickable(webDriver, infoWallet).getText()," 1x ");
        return this;
    }
}
