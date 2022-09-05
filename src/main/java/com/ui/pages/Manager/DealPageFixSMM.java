package com.ui.pages.Manager;

import com.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class DealPageFixSMM extends BasePage {
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
    private final By adFormatButton = By.xpath("//div[contains(text(),'Ad format')]");
    private final By titleInput = By.xpath("//input[@aria-label='Title']");
    private final By searchLinkButton = By.xpath
            ("//div[@class='v-input__icon v-input__icon--append']/i[contains(text(),'search')]");
    private final By linkInput = By.xpath("//input[@aria-label='Search by link/id']");
    private final By addLinkButton = By.xpath("//button[@class='ma-0 v-btn v-btn--flat v-btn--icon theme--light']" +
            "//i[contains(text(), 'add')]");
    private final By costInFormatInput = By.xpath("//input[@aria-label='Cost']");
    private final By numberOfPositionInput = By.xpath("//input[@aria-label='Number of position']");
    private final By reachPerPostInput = By.xpath("//input[@aria-label='Reach per post']");
    private final By statsScreenshotInput = By.xpath("//textarea[@aria-label='Stats screenshots']");
    private final By commentInFormatInput = By.xpath
            ("//div[@class='v-dialog v-dialog--active v-dialog--persistent']//textarea[@aria-label='Comment']");
    private final By saveFormatButton = By.xpath
            ("//div[@class='v-dialog v-dialog--active v-dialog--persistent']//div[contains(text(),'Save')]");
    private final By infoTitle = By.xpath("//td[contains(text(),'Title')]");

    private final By dealPlacesBlock = By.xpath("//div[contains(text(),'Deal places')]");
    private final By searchSiteByIdInput = By.xpath("//input[@aria-label='Search site']");
    private final By addNewDealPlaceButton = By.xpath
            ("//button[@class='v-btn v-btn--floating v-btn--outline v-btn--depressed v-btn--small theme--light primary--text']");
    private final By selectPlaceInNewDealPlaceInput = By.xpath("//div[@class='v-dialog v-dialog--active v-dialog--persistent']" +
            "//input[@aria-label='Select place']");
    private final By platformInput = By.xpath("//input[@aria-label='Platform']");
    private final By labelInDealPlaceInput = By.xpath("//div[@class='v-dialog v-dialog--active v-dialog--persistent']" +
            "//input[@aria-label='Label']");
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
    private final By firstDate = By.xpath("//div[contains(text(),'1')]");
    private final By endDate = By.xpath("//div[contains(text(),'28')]");
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

    public DealPageFixSMM(WebDriver webDriver) {
        super(webDriver);
    }

    public DealPageFixSMM assertDealType() {
        Assert.assertEquals(findElement(webDriver, infoDealType).getAttribute("value"),"fix_smm");
        return this;
    }
    public DealPageFixSMM assertExtention() {
        Assert.assertEquals(findElement(webDriver, infoExtension).getAttribute("value"),"Test");
        return this;
    }
    public DealPageFixSMM assertClassification() {
        Assert.assertEquals(findElement(webDriver, infoClassification).getAttribute("value"),"conv");
        return this;
    }
    public DealPageFixSMM chooseVolClassification() {
        findElement(webDriver, infoClassification).click();
        findElement(webDriver, volClassification).click();
        return this;
    }
    public DealPageFixSMM assertPartnerId() {
        Assert.assertEquals(findElement(webDriver, infoPartnerId).getText(),"Partner id");
        return this;
    }
    public DealPageFixSMM assertProduct() {
        Assert.assertEquals(findElement(webDriver, infoProduct).getText(),"Product");
        return this;
    }
    public DealPageFixSMM assertDealCost() {
        Assert.assertEquals(findElement(webDriver, infoDealCost).getText(),"Deal cost");
        return this;
    }
    public DealPageFixSMM assertInProgress() {
        Assert.assertEquals(findElement(webDriver, infoInProgress).getText(),"In progress");
        return this;
    }
    public DealPageFixSMM assertManager() {
        Assert.assertEquals(findElement(webDriver, infoManager).getText(),"Manager");
        return this;
    }
    public DealPageFixSMM assertROI() {
        Assert.assertEquals(findElement(webDriver, infoROI).getText(),"ROI");
        return this;
    }

    public DealPageFixSMM clickOnCommunicationButton() {
        findElement(webDriver, communicationButton).click();
        return this;
    }
    public DealPageFixSMM inputCommentInCommunication(String comment) {
        findElement(webDriver, commentInput).sendKeys("1234");
        return this;
    }
    public DealPageFixSMM addFileToComment(String comment) throws InterruptedException {
        Thread.sleep(3000);
        WebElement inputFileInComment = webDriver.findElement(By.xpath("//input[@type='file'][@id='files'][@accept='image/*']"));
        unhide(webDriver, inputFileInComment);
        inputFileInComment.sendKeys("C:\\Users\\aberz\\Downloads\\picture.jpg");
        return this;
    }
    public DealPageFixSMM clickOnAddCommentButton() throws InterruptedException {
        Thread.sleep(3000);
        waitForElementClickable(webDriver, addCommentButton).click();
        return this;
    }
    public DealPageFixSMM findAddedComment() {
        findElement(webDriver, addedComment);
        return this;
    }
    public DealPageFixSMM closeDealChat() {
        waitForElementClickable(webDriver, closeDealChat).click();
        return this;
    }

    public DealPageFixSMM clickOnDealLogButton() {
        findElement(webDriver, dealLogButton).click();
        return this;
    }
    public DealPageFixSMM findDealLog() {
        findElement(webDriver, assertLog);
        webDriver.navigate().back();
        return this;
    }

    public DealPageFixSMM clickOnSiteOverviewBlock() {
        waitForElementClickable(webDriver, siteOverviewBlock).click();
        return this;
    }
    public DealPageFixSMM clickOnAddFormatButton() {
        waitForElementClickable(webDriver, adFormatButton).click();
        return this;
    }
    public DealPageFixSMM inputTitle(String title) {
        waitForElementClickable(webDriver, titleInput).sendKeys("Title");
        return this;
    }
    public DealPageFixSMM clickOnSearchLinkButton() {
        findElement(webDriver, searchLinkButton).click();
        return this;
    }
    public DealPageFixSMM inputLink(String link) {
        waitForElementClickable(webDriver, linkInput).sendKeys("https://football.ua");
        return this;
    }
    public DealPageFixSMM clickOnAddLinkButton() {
        findElement(webDriver, addLinkButton).click();
        return this;
    }
    public DealPageFixSMM inputCostInFormat(String cost) {
        findElement(webDriver, costInFormatInput).sendKeys("100");
        return this;
    }
    public DealPageFixSMM inputNumberOfPosition(String number) {
        findElement(webDriver, numberOfPositionInput).sendKeys("10");
        return this;
    }
    public DealPageFixSMM inputReachPerPost(String reach) {
        findElement(webDriver, reachPerPostInput).sendKeys("2");
        return this;
    }
    public DealPageFixSMM inputStatsScreenshot(String screen) {
        findElement(webDriver, statsScreenshotInput).sendKeys("screenshot");
        return this;
    }
    public DealPageFixSMM inputCommentInFormat(String comment) {
        findElement(webDriver, commentInFormatInput).sendKeys("comment");
        return this;
    }
    public DealPageFixSMM clickOnSaveFormatButton() {
        findElement(webDriver, saveFormatButton).click();
        return this;
    }
    public DealPageFixSMM assertFormat() {
        Assert.assertEquals(waitForElementClickable(webDriver, infoTitle).getText(),"Title");
        return this;
    }

    public DealPageFixSMM clickOnDealPlacesBlock() {
        findElement(webDriver, dealPlacesBlock).click();
        return this;
    }
    public DealPageFixSMM inputSearchSiteById(String site) {
        findElement(webDriver, searchSiteByIdInput).sendKeys("" + Keys.DOWN + "" + Keys.ENTER);
        return this;
    }
    public DealPageFixSMM clickOnAddNewDealPlaceButton() throws InterruptedException {
        Thread.sleep(3000);
        waitForElementClickable(webDriver, addNewDealPlaceButton).click();
        return this;
    }
    public DealPageFixSMM inputSelectPlaceNewDealPlace(String place) {
        findElement(webDriver, selectPlaceInNewDealPlaceInput).sendKeys("article" + Keys.ENTER);
        return this;
    }
    public DealPageFixSMM inputPlatform(String platform) {
        findElement(webDriver, platformInput).sendKeys("Facebook" + Keys.ENTER);
        return this;
    }
    public DealPageFixSMM inputLabelNewDealPlace(String label) {
        findElement(webDriver, labelInDealPlaceInput).sendKeys("cyber" + Keys.ENTER);
        return this;
    }
    public DealPageFixSMM inputGEO(String geo) {
        findElement(webDriver, geoInput).sendKeys("Austria" + Keys.ENTER);
        return this;
    }
    public DealPageFixSMM inputLinkPp(String link) {
        findElement(webDriver, linkPpInput)
                .sendKeys("https://affpa.top/L?tag=d_1370971m_97c_&site=1370971&ad=97&r=registration/");
        return this;
    }
    public DealPageFixSMM inputCommentInDealPlace(String comment) {
        findElement(webDriver, commentInDealPlaceInput).sendKeys("comment");
        return this;
    }
    public DealPageFixSMM clickOnSaveDealPlaceButton() {
        findElement(webDriver, saveDealPlaceButton).click();
        return this;
    }
    public DealPageFixSMM assertDealPlace() {
        Assert.assertEquals(waitForElementClickable(webDriver, infoGEO).getText(),"Austria");
        return this;
    }

    public DealPageFixSMM clickOnSaveDealButton() throws InterruptedException {
        waitForInvisibility(webDriver, greenOverlay, 20L);
        waitForElementClickable(webDriver, saveDealButton).click();
        Thread.sleep(3000);
        return this;
    }
    public DealPageFixSMM clickOnSendOnReviewButton() {
        findElement(webDriver, sendOnReviewButton, 1000L).click();
        return this;
    }
    public DealPageFixSMM clickOnProfileButton() throws InterruptedException {
        Thread.sleep(3000);
        waitForElementClickable(webDriver, profileButton).click();
        return this;
    }
    public DealPageFixSMM clickOnExitButton() {
        findElement(webDriver, exitButton).click();
        findElement(webDriver, confirmExit).click();
        return this;
    }

    public DealPageFixSMM clickOnDealPaymentsBlockButton() {
        waitForElementClickable(webDriver, dealPaymentsBlockButton).click();
        return this;
    }
    public DealPageFixSMM clickOnNewContractButton() {
        waitForElementClickable(webDriver, newContractButton).click();
        return this;
    }
    public DealPageFixSMM inputContractName(String name) throws InterruptedException {
        findElement(webDriver, contractNameInput).sendKeys("Contract name");
        Thread.sleep(1000);
        return this;
    }
    public DealPageFixSMM inputStartDateInContract(String date) {
        findElement(webDriver, startDateInContractInput).click();
        findElement(webDriver, firstDate).click();
        return this;
    }
    public DealPageFixSMM inputEndDateInContract(String date) {
        findElement(webDriver, endDateInContractInput).click();
        findElement(webDriver, endDate).click();
        return this;
    }
    public DealPageFixSMM inputAttachFile(String contract) {
        WebElement inputFileInContract = webDriver.findElement(By.xpath("//div[@class='flex md12']//input[@type='file']"));
        unhide(webDriver, inputFileInContract);
        inputFileInContract.sendKeys("C:\\Users\\aberz\\Downloads\\contract.txt");
        return this;
    }
    public DealPageFixSMM clickOnSaveContractButton() {
        findElement(webDriver, saveContractButton).click();
        return this;
    }
    public DealPageFixSMM assertContractName() {
        Assert.assertEquals(waitForElementClickable(webDriver, infoContractName).getText(),"Contract name");
        return this;
    }

    public DealPageFixSMM clickOnNewPaymentButton() throws InterruptedException {
        waitForElementClickable(webDriver, newPaymentButton).click();
        Thread.sleep(1000);
        return this;
    }
    public DealPageFixSMM inputStartDateInPayment(String date) {
        findElement(webDriver, head).click();
        waitForElementClickable(webDriver, startDateInPaymentInput).click();
        findElement(webDriver, firstDate).click();
        return this;
    }
    public DealPageFixSMM inputEndDateInPayment(String date) {
        findElement(webDriver,endDateInPaymentInput).click();
        findElement(webDriver, endDate).click();
        return this;
    }
    public DealPageFixSMM inputPaymentTarget(String target) {
        findElement(webDriver, paymentTargetInput).sendKeys("1x" + Keys.ARROW_DOWN + Keys.ENTER);
        return this;
    }
    public DealPageFixSMM inputType(String type) {
        findElement(webDriver, typeInput).sendKeys("prepaid" + Keys.ENTER);
        return this;
    }
    public DealPageFixSMM inputWallet(String wallet) {
        findElement(webDriver, walletInput).sendKeys("WMZ" + Keys.ARROW_DOWN + Keys.ENTER);
        return this;
    }
    public DealPageFixSMM inputCostInPayment(String cost) {
        findElement(webDriver, costInput).sendKeys("100");
        return this;
    }
    public DealPageFixSMM clickOnAutocheck() {
        findElement(webDriver, autocheckCheckbox).click();
        return this;
    }
    public DealPageFixSMM inputCommentInPayment(String comment) {
        findElement(webDriver, commentInPaymentInput).sendKeys("comment");
        return this;
    }
    public DealPageFixSMM clickOnContinueButton() {
        findElement(webDriver, continueButton).click();
        return this;
    }
    public DealPageFixSMM inputRemainingCost(String cost) throws InterruptedException {
        waitForElementClickable(webDriver, remainingCostInput).sendKeys("50");
        Thread.sleep(1000);
        return this;
    }
    public DealPageFixSMM inputRemainingZidCost(String cost) throws InterruptedException {
        findElement(webDriver, remainingZidCostInput).sendKeys("50");
        Thread.sleep(1500);
        return this;
    }
    public DealPageFixSMM clickOnSavePaymentButton() {
        waitForElementClickable(webDriver, savePaymentButton).click();
        return this;
    }
    public DealPageFixSMM clickOnApprovePaymentButton() throws InterruptedException {
        waitForElementClickable(webDriver, approvePaymentButton).click();
        Thread.sleep(3000);
        return this;
    }
    public DealPageFixSMM assertPayment() throws InterruptedException {
        Assert.assertEquals(waitForElementClickable(webDriver, infoWallet).
                getText(),"1x\n" + "WMZ Z146407012030\n" + "100 USD");
        Thread.sleep(5000);
        return this;
    }
}
