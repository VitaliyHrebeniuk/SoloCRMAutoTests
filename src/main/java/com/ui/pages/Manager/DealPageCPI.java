package com.ui.pages.Manager;

import com.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class DealPageCPI extends BasePage {
    private final By infoDealType = By.xpath("//input[@id='cpi-type']");
    private final By infoExtension = By.xpath("//input[@aria-label='Extension']");
    private final By infoClassification = By.xpath("//input[@id='cpi-classification']");
    private final By volClassification = By.xpath("//div[contains(text(),'vol')]");
    private final By infoPartnerId = By.xpath("//h5[contains(text(),'Partner id')]");
    private final By infoProduct = By.xpath("//h5[contains(text(),'Product')]");
    private final By infoDealCost = By.xpath("//h5[contains(text(),'Deal cost')]");
    private final By infoInProgress = By.xpath("//h5[contains(text(),'In progress')]");
    private final By infoManager = By.xpath("//h5[contains(text(),'Manager')]");
    private final By infoROI = By.xpath("//h5[contains(text(),'ROI')]");
    private final By infoTotalSpend = By.xpath("//h5[contains(text(),'Total spend')]");
    private final By infoBalance = By.xpath("//h5[contains(text(),'Balance')]");

    private final By communicationButton = By.xpath("//div[contains(text(),'communication')]");
    private final By commentInput = By.xpath("//div[@id='comment']//textarea[@aria-label='Comment']");
    private final By addCommentButton = By.xpath("//div[contains(text(),' Add comment ')]");
    private final By addedComment = By.xpath("//div[@class='comment-author']");
    private final By closeDealChat = By.xpath("//div[@class='v-dialog__content v-dialog__content--active']" +
            "//div[contains(text(),'Close')]");

    private final By dealLogButton = By.xpath("//button[@id='deal-log']");
    private final By assertLog = By.xpath("//strong[contains(text(),'Create deal')]");

    private final By spendsButton = By.xpath("//div[contains(text(),'Spends')]");
    private final By historySpendsButton = By.xpath("//div[contains(text(),'history spends')]");
    private final By closeHistorySpendsButton = By.xpath
            ("(//div[@class='v-dialog v-dialog--active v-dialog--persistent']//div[contains(text(),'Close')])[2]");
    private final By closeSpendsButton = By.xpath
            ("(//div[@class='v-dialog v-dialog--active v-dialog--persistent']//div[contains(text(),'Close')])[1]");

    private final By siteOverviewBlock = By.xpath("//div[contains(text(),'Site Overview')]");
    private final By linkInput = By.xpath("//input[@aria-label='Search by link/id']");
    private final By addLinkButton = By.xpath
            ("//button[@class='ma-0 btn-select_lead v-btn v-btn--flat v-btn--icon theme--light']");
    private final By addAnalyticsButton = By.xpath("//div[contains(text(),'Add analytics')]");

    private final By costPerInstallBlock = By.xpath("//div[contains(text(),'Cost per install')]");
    private final By setCostButton = By.xpath("//button//div[contains(., 'Set cost')]");
    private final By selectCountryInput = By.xpath
            ("//div[@class='v-dialog v-dialog--active v-dialog--persistent']//input[@aria-label='Country']");
    private final By startDateInput = By.xpath("//div[@class='layout']//input[@aria-label='Start date']");
    private final By firstDate = By.xpath("//div[contains(text(),'1')]");
    private final By endDate = By.xpath("//div[contains(text(),'28')]");
    private final By endDateInput = By.xpath("//div[@class='layout']//input[@aria-label='End date']");
    private final By costInput = By.xpath("//tr[contains(.,'Albania')]//input[@type='number']");
    private final By saveCostButton = By.xpath
            ("//div[@class='v-dialog v-dialog--active v-dialog--persistent']//button[contains(.,'Save')]");
    private final By infoCost = By.xpath("//td[contains(text(),'10')]");

    private final By dealPlacesBlock = By.xpath("//div[@class='subheading'][contains(.,'Deal places')]");
    private final By searchSiteInput = By.xpath("//input[@id='cpi-deal_place-search']");
    private final By addDealPlaceButton = By.xpath
            ("//button[@class='v-btn v-btn--floating v-btn--outline v-btn--depressed v-btn--small theme--light primary--text']");
    private final By selectPlaceInput = By.xpath("//input[@id='cpi-deal_place_type_id']");
    private final By platformInput = By.xpath("//input[@id='cpi-source_type_id']");
    private final By labelInput = By.xpath("//input[@id='cpi-label']");
    private final By geoInput = By.xpath("//input[@id='cpi-country_id']");
    private final By linkPpInput = By.xpath("//input[@id='cpi-link']");
    private final By commentInDealPlaceInput = By.xpath("//textarea[@id='cpi-comment']");
    private final By saveDealPlaceButton = By.xpath("//button[@id='cpi-save_place']");
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
    private final By costInPaymentInput = By.xpath("//input[@id='payment-summary']");
    private final By autocheckCheckbox = By.xpath
            ("//div[@class='v-dialog v-dialog--active v-dialog--persistent']//div[@class='v-input--selection-controls__ripple']");
    private final By commentInPaymentInput = By.xpath("//textarea[@id='payment-comment']");
    private final By continueButton = By.xpath("//div[contains(text(),'Continue')]");
    private final By remainingCostInput = By.xpath
            ("//div[@class='v-input payment-analytic-cost v-text-field v-input--hide-details theme--light']" +
                    "//input[@aria-label='Cost']");
    private final By remainingZidCostInput = By.xpath("//input[@id='payment-analytic-zid-cost']");
    private final By savePaymentButton = By.xpath("//button[@id='payment-continue']");
    private final By approvePaymentButton = By.xpath("//button[@id='payment-positive_status']");
    private final By infoWallet = By.xpath("//div[contains(text(),' 1x ')]");

    public DealPageCPI(WebDriver webDriver) {
        super(webDriver);
    }

    public DealPageCPI assertDealType() {
        Assert.assertEquals(findElement(webDriver, infoDealType).getAttribute("value"),"cpi");
        return this;
    }
    public DealPageCPI assertExtention() {
        Assert.assertEquals(findElement(webDriver, infoExtension).getAttribute("value"),"Test");
        return this;
    }
    public DealPageCPI assertClassification() {
        Assert.assertEquals(findElement(webDriver, infoClassification).getAttribute("value"),"conv");
        return this;
    }
    public DealPageCPI chooseVolClassification() {
        findElement(webDriver, infoClassification).click();
        findElement(webDriver, volClassification).click();
        return this;
    }
    public DealPageCPI assertPartnerId() {
        Assert.assertEquals(findElement(webDriver, infoPartnerId).getText(),"Partner id");
        return this;
    }
    public DealPageCPI assertProduct() {
        Assert.assertEquals(findElement(webDriver, infoProduct).getText(),"Product");
        return this;
    }
    public DealPageCPI assertDealCost() {
        Assert.assertEquals(findElement(webDriver, infoDealCost).getText(),"Deal cost");
        return this;
    }
    public DealPageCPI assertInProgress() {
        Assert.assertEquals(findElement(webDriver, infoInProgress).getText(),"In progress");
        return this;
    }
    public DealPageCPI assertManager() {
        Assert.assertEquals(findElement(webDriver, infoManager).getText(),"Manager");
        return this;
    }
    public DealPageCPI assertROI() {
        Assert.assertEquals(findElement(webDriver, infoROI).getText(),"ROI");
        return this;
    }
    public DealPageCPI assertTotalSpend() {
        Assert.assertEquals(findElement(webDriver, infoTotalSpend).getText(),"Total spend");
        return this;
    }
    public DealPageCPI assertBalance() {
        Assert.assertEquals(findElement(webDriver, infoBalance).getText(),"Balance");
        return this;
    }

    public DealPageCPI clickOnCommunicationButton() {
        findElement(webDriver, communicationButton).click();
        return this;
    }
    public DealPageCPI inputCommentInCommunication(String comment) {
        findElement(webDriver, commentInput).sendKeys("1234");
        return this;
    }
    public DealPageCPI addFileToComment(String comment) throws InterruptedException {
        Thread.sleep(3000);
        WebElement inputFileInComment = webDriver.findElement(By.xpath("//input[@type='file'][@id='files'][@accept='image/*']"));
        unhide(webDriver, inputFileInComment);
        inputFileInComment.sendKeys("C:\\Users\\aberz\\Downloads\\picture.jpg");
        return this;
    }
    public DealPageCPI clickOnAddCommentButton() {
        waitForElementClickable(webDriver, addCommentButton).click();
        return this;
    }
    public DealPageCPI findAddedComment() {
        findElement(webDriver, addedComment);
        return this;
    }
    public DealPageCPI closeDealChat() {
        waitForElementClickable(webDriver, closeDealChat).click();
        return this;
    }

    public DealPageCPI clickOnDealLogButton() {
        findElement(webDriver, dealLogButton).click();
        return this;
    }
    public DealPageCPI findDealLog() {
        findElement(webDriver, assertLog);
        webDriver.navigate().back();
        return this;
    }

    public DealPageCPI clickOnSpendsButton() {
        findElement(webDriver, spendsButton).click();
        return this;
    }
    public DealPageCPI clickOnHistorySpendsButton() {
        waitForElementClickable(webDriver, historySpendsButton).click();
        return this;
    }
    public DealPageCPI clickOnCloseHistorySpendsButton() {
        waitForElementClickable(webDriver, closeHistorySpendsButton).click();
        return this;
    }
    public DealPageCPI clickOnCloseSpendsButton() {
        waitForElementClickable(webDriver, closeSpendsButton).click();
        return this;
    }

    public DealPageCPI clickOnSiteOverviewBlock() {
        waitForElementClickable(webDriver, siteOverviewBlock).click();
        return this;
    }
    public DealPageCPI inputLink(String link) {
        findElement(webDriver, linkInput).sendKeys("https://mmgp.ru/");
        return this;
    }
    public DealPageCPI clickOnAddLinkButton() {
        waitForElementClickable(webDriver, addLinkButton).click();
        return this;
    }
    public DealPageCPI clickOnAddAnalyticsButton() {
        findElement(webDriver, addAnalyticsButton).click();
        return this;
    }
    public DealPageCPI clickOnFirstAnalyticsButton() {
        WebElement firstAnalButton = webDriver.findElement(By.xpath("//a[@class='v-tabs__item']"));
        Actions act = new Actions(webDriver);
        act.moveToElement(firstAnalButton).click().perform();
        return this;
    }

    public DealPageCPI clickOnCostPerInstallBlock() throws InterruptedException {
        Thread.sleep(3000);
        waitForElementClickable(webDriver, costPerInstallBlock).click();
        return this;
    }
    public DealPageCPI clickOnSetCostButton() {
        findElement(webDriver, setCostButton).click();
        return this;
    }
    public DealPageCPI inputSelectCountry(String country) {
        findElement(webDriver, selectCountryInput).sendKeys("Albania" + Keys.ENTER);
        return this;
    }
    public DealPageCPI selectStartDateForCost() {
        findElement(webDriver, startDateInput).click();
        findElement(webDriver, firstDate).click();
        return this;
    }
    public DealPageCPI selectEndDateForCost() {
        findElement(webDriver, endDateInput).click();
        findElement(webDriver, endDate).click();
        return this;
    }
    public DealPageCPI inputCost(String cost) throws InterruptedException {
        Thread.sleep(3000);
        findElement(webDriver, costInput).sendKeys("10");
        return this;
    }
    public DealPageCPI clickOnSaveCostButton() {
        findElement(webDriver, saveCostButton).click();
        return this;
    }
    public DealPageCPI assertCost() {
        Assert.assertEquals(waitForElementClickable(webDriver, infoCost).getText(),"10");
        return this;
    }

    public DealPageCPI clickOnDealPlacesBlock() {
        findElement(webDriver, dealPlacesBlock).click();
        return this;
    }
    public DealPageCPI inputSearchSite(String site) {
        waitForElementClickable(webDriver, searchSiteInput).sendKeys("20578" + Keys.ENTER);
        return this;
    }
    public DealPageCPI clickOnAddDealPlaceButton() {
        findElement(webDriver, addDealPlaceButton).click();
        return this;
    }
    public DealPageCPI inputSelectPlace(String place) {
        waitForElementClickable(webDriver, selectPlaceInput).sendKeys("adaptive_banner" + Keys.ENTER);
        return this;
    }
    public DealPageCPI inputPlatform(String platform) {
        findElement(webDriver, platformInput).sendKeys("AppStore" + Keys.ENTER);
        return this;
    }
    public DealPageCPI inputLabel(String label) {
        findElement(webDriver, labelInput).sendKeys("live" + Keys.ENTER);
        return this;
    }
    public DealPageCPI inputGEO(String geo) {
        findElement(webDriver, geoInput).sendKeys("Austria" + Keys.ENTER);
        return this;
    }
    public DealPageCPI inputLinkPP(String link) {
        findElement(webDriver, linkPpInput).sendKeys
                ("https://affpa.top/L?tag=d_1370971m_97c_&site=1370971&ad=97&r=registration/");
        return this;
    }
    public DealPageCPI inputCommentInDealPlace(String comment) {
        findElement(webDriver, commentInDealPlaceInput).sendKeys("comment");
        return this;
    }
    public DealPageCPI clickOnSaveDealPlaceButton() {
        findElement(webDriver, saveDealPlaceButton).click();
        return this;
    }
    public DealPageCPI assertDealPlace() {
        Assert.assertEquals(waitForElementClickable(webDriver, infoGEO).getText(),"Austria");
        return this;
    }

    public DealPageCPI clickOnSaveDealButton() throws InterruptedException {
        waitForInvisibility(webDriver, greenOverlay, 20L);
        waitForElementClickable(webDriver, saveDealButton).click();
        Thread.sleep(3000);
        return this;
    }
    public DealPageCPI clickOnSendOnReviewButton() {
        findElement(webDriver, sendOnReviewButton, 1000L).click();
        return this;
    }
    public DealPageCPI clickOnProfileButton() throws InterruptedException {
        Thread.sleep(3000);
        waitForElementClickable(webDriver, profileButton).click();
        return this;
    }
    public DealPageCPI clickOnExitButton() {
        findElement(webDriver, exitButton).click();
        findElement(webDriver, confirmExit).click();
        return this;
    }

    public DealPageCPI clickOnDealPaymentsBlockButton() {
        waitForElementClickable(webDriver, dealPaymentsBlockButton).click();
        return this;
    }
    public DealPageCPI clickOnNewContractButton() {
        waitForElementClickable(webDriver, newContractButton).click();
        return this;
    }
    public DealPageCPI inputContractName(String name) throws InterruptedException {
        findElement(webDriver, contractNameInput).sendKeys("Contract name");
        Thread.sleep(1000);
        return this;
    }
    public DealPageCPI inputStartDateInContract(String date) {
        findElement(webDriver, startDateInContractInput).click();
        findElement(webDriver, firstDate).click();
        return this;
    }
    public DealPageCPI inputEndDateInContract(String date) {
        findElement(webDriver, endDateInContractInput).click();
        findElement(webDriver, endDate).click();
        return this;
    }
    public DealPageCPI inputAttachFile(String contract) {
        WebElement inputFileInContract = webDriver.findElement(By.xpath("//div[@class='flex md12']//input[@type='file']"));
        unhide(webDriver, inputFileInContract);
        inputFileInContract.sendKeys("C:\\Users\\aberz\\Downloads\\contract.txt");
        return this;
    }
    public DealPageCPI clickOnSaveContractButton() {
        findElement(webDriver, saveContractButton).click();
        return this;
    }
    public DealPageCPI assertContractName() {
        Assert.assertEquals(waitForElementClickable(webDriver, infoContractName).getText(),"Contract name");
        return this;
    }

    public DealPageCPI clickOnNewPaymentButton() throws InterruptedException {
        waitForElementClickable(webDriver, newPaymentButton).click();
        Thread.sleep(1000);
        return this;
    }
    public DealPageCPI inputStartDateInPayment(String date) {
        findElement(webDriver, head).click();
        waitForElementClickable(webDriver, startDateInPaymentInput).click();
        findElement(webDriver, firstDate).click();
        return this;
    }
    public DealPageCPI inputEndDateInPayment(String date) {
        findElement(webDriver,endDateInPaymentInput).click();
        findElement(webDriver, endDate).click();
        return this;
    }
    public DealPageCPI inputPaymentTarget(String target) {
        findElement(webDriver, paymentTargetInput).sendKeys("1x" + Keys.ARROW_DOWN + Keys.ENTER);
        return this;
    }
    public DealPageCPI inputType(String type) {
        findElement(webDriver, typeInput).sendKeys("prepaid" + Keys.ENTER);
        return this;
    }
    public DealPageCPI inputWallet(String wallet) {
        findElement(webDriver, walletInput).sendKeys("WMZ" + Keys.ARROW_DOWN + Keys.ENTER);
        return this;
    }
    public DealPageCPI inputCostInPayment(String cost) {
        findElement(webDriver, costInPaymentInput).sendKeys("100");
        return this;
    }
    public DealPageCPI clickOnAutocheck() {
        findElement(webDriver, autocheckCheckbox).click();
        return this;
    }
    public DealPageCPI inputCommentInPayment(String comment) {
        findElement(webDriver, commentInPaymentInput).sendKeys("comment");
        return this;
    }
    public DealPageCPI clickOnSavePaymentButton() {
        waitForElementClickable(webDriver, savePaymentButton).click();
        return this;
    }
    public DealPageCPI clickOnApprovePaymentButton() throws InterruptedException {
        waitForElementClickable(webDriver, approvePaymentButton).click();
        Thread.sleep(3000);
        return this;
    }
    public DealPageCPI assertPayment() throws InterruptedException {
        Assert.assertEquals(waitForElementClickable(webDriver, infoWallet).
                getText(),"1x\n" + "WMZ Z146407012030\n" + "100 USD");
        Thread.sleep(5000);
        return this;
    }
}
