package com.ui.pages.Manager;

import com.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class DealPageCPM extends BasePage {
    private final By infoDealType = By.xpath("//input[@aria-label='Deal type']");
    private final By infoStartDate = By.xpath("//div[@class='flex md4']//input[@aria-label='Start date']");
    private final By endDate = By.xpath("//div[contains(text(),'28')]");
    private final By networkInput = By.xpath("//div[@class='flex md5']//input[@aria-label='Network']");
    private final By infoExtension = By.xpath("//input[@aria-label='Extension']");
    private final By infoPartnerId = By.xpath("//h5[contains(text(),'Partner id')]");
    private final By infoProduct = By.xpath("//h5[contains(text(),'Product')]");
    private final By infoDealCost = By.xpath("//h5[contains(text(),'Deal cost')]");
    private final By infoInProgress = By.xpath("//h5[contains(text(),'In progress')]");
    private final By infoManager = By.xpath("//h5[contains(text(),'Manager')]");
    private final By infoROI = By.xpath("//h5[contains(text(),'ROI')]");
    private final By infoTotalSpend = By.xpath("//h5[contains(text(),'Total spend')]");
    private final By infoBalance = By.xpath("//h5[contains(text(),'Balance')]");

    private final By communicationButton = By.xpath("//div[contains(text(),'Communication')]");
    private final By commentInput = By.xpath("//div[@id='comment']//textarea[@aria-label='Comment']");
    private final By addCommentButton = By.xpath("//div[contains(text(),' Add comment ')]");
    private final By addedComment = By.xpath("//div[@class='comment-author']");
    private final By closeDealChat = By.xpath("//div[@class='v-dialog__content v-dialog__content--active']" +
            "//div[contains(text(),'Close')]");

    private final By dealLogButton = By.xpath("//button[@class='ml-0 btn-info v-btn theme--light'][contains(.,'Log')]");
    private final By assertLog = By.xpath("//strong[contains(text(),'Create deal')]");

    private final By siteOverviewBlock = By.xpath("//div[contains(text(),'Site Overview')]");
    private final By linkInput = By.xpath("//input[@id='cpi-link_search']");
    private final By addLinkButton = By.xpath
            ("//button[@class='ma-0 btn-select_lead v-btn v-btn--flat v-btn--icon theme--light']");
    private final By addAnalyticsButton = By.xpath("//div[contains(text(),'Add analytics')]");

    private final By addFormatButton = By.xpath("//div[contains(text(),'Ad format')]");
    private final By selectPlaceInFormatInput = By.xpath("//div[@class='v-dialog v-dialog--active v-dialog--persistent']" +
            "//input[@aria-label='Select place']");
    private final By geoInFormatInput = By.xpath
            ("//div[@class='v-dialog v-dialog--active v-dialog--persistent']//input[@aria-label='GEO']");
    private final By cpmUsdInput = By.xpath("//input[@aria-label='CPM USD']");
    private final By cpcUsdInput = By.xpath("//input[@aria-label='CPC USD']");
    private final By trafficTypeInFormatInput = By.xpath
            ("//div[@class='v-dialog v-dialog--active v-dialog--persistent']//input[@aria-label='Traffic type']");
    private final By trafficChannelInFormatInput = By.xpath
            ("//div[@class='v-dialog v-dialog--active v-dialog--persistent']//input[@aria-label='Traffic channel']");
    private final By saveFormatButton = By.xpath
            ("//div[@class='v-dialog v-dialog--active v-dialog--persistent']//div[contains(text(),'Save')]");
    private final By infoFormat = By.xpath("//td[contains(text(),'100')]");

    private final By dealPlacesBlock = By.xpath("//div[@class='subheading'][contains(.,'Deal places')]");
    private final By searchSiteButton = By.xpath("//button[@class='white--text ml-0 mt-2 btn-actions v-btn theme--light']");
    private final By searchSiteInput = By.xpath("//input[@aria-label='Search by id']");
    private final By checkboxSite = By.xpath("//div[@class='v-dialog v-dialog--active v-dialog--persistent']" +
            "//div[@class='v-input--selection-controls__ripple']");
    private final By addDealPlaceButton = By.xpath
            ("//button[@class='modal_fixed_btn v-btn v-btn--floating theme--dark primary']");
    private final By openDealPlaceButton = By.xpath
            ("//button[@class='v-btn v-btn--floating v-btn--outline v-btn--depressed v-btn--small theme--light primary--text']");
    private final By placeNameInput = By.xpath("//input[@aria-label='Place name']");
    private final By selectPlaceInput = By.xpath
            ("//div[@class='v-dialog v-dialog--active v-dialog--persistent']//input[@aria-label='Select place']");
    private final By geoInDealPlaceInput = By.xpath
            ("//div[@class='v-dialog v-dialog--active v-dialog--persistent']//input[@aria-label='GEO']");
    private final By cpmCpcInput = By.xpath("//input[@aria-label='CPM/CPC']");
    private final By trafficTypeInDealPlaceInput = By.xpath
            ("//div[@class='v-dialog v-dialog--active v-dialog--persistent']//input[@aria-label='Traffic type']");
    private final By trafficChannelInDealPlaceInput = By.xpath
            ("//div[@class='v-dialog v-dialog--active v-dialog--persistent']//input[@aria-label='Traffic channel']");
    private final By adSizeInput = By.xpath("//input[@aria-label='Ad size']");
    private final By creativeInput = By.xpath("//input[@aria-label='Creative']");
    private final By networkMakrosInput = By.xpath("//input[@aria-label='Network makros']");
    private final By redirectorInput = By.xpath("//input[@aria-label='Redirector']");
    private final By linkPpInput = By.xpath("//input[@aria-label='Link PP']");
    private final By commentInDealPlaceInput = By.xpath
            ("//div[@class='v-dialog v-dialog--active v-dialog--persistent']//textarea[@aria-label='Comment']");
    private final By saveDealPlaceButton = By.xpath
            ("//div[@class='v-dialog v-dialog--active v-dialog--persistent']//div[contains(text(),'Save')]");
    private final By infoDealPlace = By.xpath("//td[contains(text(),'cpm')]");

    private final By greenOverlay = By.xpath("//div[@class='vue-notification-template vue-notification success']");
    private final By saveDealButton = By.xpath
            ("//button[@class='ml-0 pulse-button v-btn v-btn--bottom v-btn--floating v-btn--fixed v-btn--right theme--dark green darken-1']");
    private final By sendOnReviewButton = By.xpath("//button[@class='v-btn v-btn--small theme--light btn-item_send on review']");
    private final By profileButton = By.xpath("//button[@id='profile_btn']");
    private final By exitButton = By.xpath("//a[@id='exit_btn']");
    private final By confirmExit = By.xpath("//div[contains(text(),'Yes')]");

    public DealPageCPM(WebDriver webDriver) {
        super(webDriver);
    }

    public DealPageCPM assertDealType() {
        Assert.assertEquals(findElement(webDriver, infoDealType).getAttribute("value"),"cpm");
        return this;
    }
    public DealPageCPM assertStartDate() {
        findElement(webDriver, infoStartDate).click();
        findElement(webDriver, endDate).click();
        return this;
    }
    public DealPageCPM inputNetwork(String network) {
        findElement(webDriver, networkInput).sendKeys("Network");
        return this;
    }
    public DealPageCPM assertExtention() {
        Assert.assertEquals(findElement(webDriver, infoExtension).getAttribute("value"),"Test");
        return this;
    }
    public DealPageCPM assertPartnerId() {
        Assert.assertEquals(findElement(webDriver, infoPartnerId).getText(),"Partner id");
        return this;
    }
    public DealPageCPM assertProduct() {
        Assert.assertEquals(findElement(webDriver, infoProduct).getText(),"Product");
        return this;
    }
    public DealPageCPM assertDealCost() {
        Assert.assertEquals(findElement(webDriver, infoDealCost).getText(),"Deal cost");
        return this;
    }
    public DealPageCPM assertInProgress() {
        Assert.assertEquals(findElement(webDriver, infoInProgress).getText(),"In progress");
        return this;
    }
    public DealPageCPM assertManager() {
        Assert.assertEquals(findElement(webDriver, infoManager).getText(),"Manager");
        return this;
    }
    public DealPageCPM assertROI() {
        Assert.assertEquals(findElement(webDriver, infoROI).getText(),"ROI");
        return this;
    }
    public DealPageCPM assertTotalSpend() {
        Assert.assertEquals(findElement(webDriver, infoTotalSpend).getText(),"Total spend");
        return this;
    }
    public DealPageCPM assertBalance() {
        Assert.assertEquals(findElement(webDriver, infoBalance).getText(),"Balance");
        return this;
    }

    public DealPageCPM clickOnCommunicationButton() {
        findElement(webDriver, communicationButton).click();
        return this;
    }
    public DealPageCPM inputCommentInCommunication(String comment) {
        findElement(webDriver, commentInput).sendKeys("1234");
        return this;
    }
    public DealPageCPM addFileToComment(String comment) throws InterruptedException {
        Thread.sleep(3000);
        WebElement inputFileInComment = webDriver.findElement(By.xpath("//input[@type='file'][@id='files'][@accept='image/*']"));
        unhide(webDriver, inputFileInComment);
        inputFileInComment.sendKeys("/files/picture.jpg");
//        inputFileInComment.sendKeys("C:\\Users\\aberz\\Downloads\\picture.jpg");
        return this;
    }
    public DealPageCPM clickOnAddCommentButton() {
        waitForElementClickable(webDriver, addCommentButton).click();
        return this;
    }
    public DealPageCPM findAddedComment() {
        findElement(webDriver, addedComment);
        return this;
    }
    public DealPageCPM closeDealChat() {
        waitForElementClickable(webDriver, closeDealChat).click();
        return this;
    }

    public DealPageCPM clickOnDealLogButton() {
        findElement(webDriver, dealLogButton).click();
        return this;
    }
    public DealPageCPM findDealLog() {
        findElement(webDriver, assertLog);
        webDriver.navigate().back();
        return this;
    }

    public DealPageCPM clickOnSiteOverviewBlock() {
        waitForElementClickable(webDriver, siteOverviewBlock).click();
        return this;
    }
    public DealPageCPM inputLink(String link) {
        findElement(webDriver, linkInput).sendKeys("https://mmgp.ru/");
        return this;
    }
    public DealPageCPM clickOnAddLinkButton() {
        waitForElementClickable(webDriver, addLinkButton).click();
        return this;
    }
    public DealPageCPM clickOnAddAnalyticsButton() {
        waitForElementClickable(webDriver, addAnalyticsButton).click();
        return this;
    }
    public DealPageCPM clickOnFirstAnalyticsButton() throws InterruptedException {
        WebElement firstAnalButton = webDriver.findElement(By.xpath("//a[@class='v-tabs__item']"));
        Actions act = new Actions(webDriver);
        act.moveToElement(firstAnalButton).click().perform();
        Thread.sleep(3000);
        return this;
    }

    public DealPageCPM clickOnAddFormatButton() {
        waitForElementClickable(webDriver, addFormatButton).click();
        return this;
    }
    public DealPageCPM inputSelectPlaceInFormat(String place) {
        findElement(webDriver, selectPlaceInFormatInput).sendKeys("article" + Keys.ENTER);
        return this;
    }
    public DealPageCPM inputGeoInFormat(String geo) {
        findElement(webDriver, geoInFormatInput).sendKeys("Austria" + Keys.ENTER);
        return this;
    }
    public DealPageCPM inputCpmUsd(String usd) {
        findElement(webDriver, cpmUsdInput).sendKeys("100");
        return this;
    }
    public DealPageCPM inputCpcUsd(String usd) {
        findElement(webDriver, cpcUsdInput).sendKeys("150");
        return this;
    }
    public DealPageCPM inputTrafficTypeInFormat(String type) {
        findElement(webDriver, trafficTypeInFormatInput).sendKeys("ALL" + Keys.ENTER);
        return this;
    }
    public DealPageCPM inputTrafficChannelInFormat(String type) {
        findElement(webDriver, trafficChannelInFormatInput).sendKeys("desk" + Keys.ENTER);
        return this;
    }
    public DealPageCPM clickOnSaveFormatButton() {
        findElement(webDriver, saveFormatButton).click();
        return this;
    }
    public DealPageCPM assertFormat() {
        Assert.assertEquals(waitForElementClickable(webDriver, infoFormat).getText(),"100");
        return this;
    }

    public DealPageCPM clickOnDealPlacesBlock() {
        findElement(webDriver, dealPlacesBlock).click();
        return this;
    }
    public DealPageCPM clickOnSearchSiteButton() {
        findElement(webDriver, searchSiteButton).click();
        return this;
    }
    public DealPageCPM inputSearchSite(String site) {
        findElement(webDriver, searchSiteInput).sendKeys("ceroacero");
        return this;
    }
    public DealPageCPM clickOnCheckboxSite() {
        findElement(webDriver, checkboxSite).click();
        return this;
    }
    public DealPageCPM clickOnAddDealPlaceButton() {
        findElement(webDriver, addDealPlaceButton).click();
        return this;
    }
    public DealPageCPM clickOnOpenDealPlaceButton() {
        findElement(webDriver, openDealPlaceButton).click();
        return this;
    }
    public DealPageCPM inputPlaceName(String name) {
        findElement(webDriver, placeNameInput).sendKeys("Place");
        return this;
    }
    public DealPageCPM inputSelectPlaceInDealPlace(String place) {
        findElement(webDriver, selectPlaceInput).sendKeys("article" + Keys.ENTER);
        return this;
    }
    public DealPageCPM inputGeoInDealPlace(String geo) {
        findElement(webDriver, geoInDealPlaceInput).sendKeys("Austria" + Keys.ENTER);
        return this;
    }
    public DealPageCPM inputCpmCpc(String cpm) {
        findElement(webDriver, cpmCpcInput).sendKeys("cpm" + Keys.ENTER);
        return this;
    }
    public DealPageCPM inputTrafficChannelInDealPlace(String channel) {
        findElement(webDriver, trafficChannelInDealPlaceInput).sendKeys("desk" + Keys.ENTER);
        return this;
    }
    public DealPageCPM inputTrafficTypeInDealPlace(String type) {
        findElement(webDriver, trafficTypeInDealPlaceInput).sendKeys("ALL" + Keys.ENTER);
        return this;
    }
    public DealPageCPM inputAdSize(String size) {
        findElement(webDriver, adSizeInput).sendKeys("100");
        return this;
    }
    public DealPageCPM inputCreative(String creative) {
        findElement(webDriver, creativeInput).sendKeys("action");
        return this;
    }
    public DealPageCPM inputNetworkMakros(String makros) {
        findElement(webDriver, networkMakrosInput).sendKeys("[site]" + Keys.ENTER);
        return this;
    }
    public DealPageCPM inputRedirector(String redirector) {
        findElement(webDriver, redirectorInput).sendKeys("refparjhob.top");
        return this;
    }
    public DealPageCPM inputLinkPP(String link) {
        findElement(webDriver, linkPpInput).sendKeys
                ("http://refpa.top/L?tag=d_687199m_97c__[]general[]_d38098_l32830_post&site=687199&ad=97");
        return this;
    }
    public DealPageCPM inputCommentInDealPlace(String comment) {
        findElement(webDriver, commentInDealPlaceInput).sendKeys("comment");
        return this;
    }
    public DealPageCPM saveDealPlace() {
        findElement(webDriver, saveDealPlaceButton).click();
        return this;
    }
    public DealPageCPM assertDealPlace() throws InterruptedException {
        scrollToElement(webDriver, searchSiteButton);
        Thread.sleep(3000);
        Assert.assertEquals(waitForElementClickable(webDriver, infoDealPlace).getText(),"cpm");
        return this;
    }

    public DealPageCPM clickOnSaveDealButton() throws InterruptedException {
        waitForInvisibility(webDriver, greenOverlay, 20L);
        waitForElementClickable(webDriver, saveDealButton).click();
        Thread.sleep(3000);
        return this;
    }
    public DealPageCPM clickOnSendOnReviewButton() {
        findElement(webDriver, sendOnReviewButton, 1000L).click();
        return this;
    }
    public DealPageCPM clickOnProfileButton() throws InterruptedException {
        Thread.sleep(3000);
        waitForElementClickable(webDriver, profileButton).click();
        return this;
    }
    public DealPageCPM clickOnExitButton() {
        findElement(webDriver, exitButton).click();
        findElement(webDriver, confirmExit).click();
        return this;
    }
}
