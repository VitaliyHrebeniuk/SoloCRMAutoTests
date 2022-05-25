package com.ui.pages.ManagerCreateDealCPM;

import com.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class DealPageCPM extends BasePage {
    private final By siteOverviewBlock = By.xpath("//div[contains(text(),'Site Overview')]");
    private final By linkInput = By.xpath("//input[@id='cpi-link_search']");
    private final By addLinkButton = By.xpath("//button//i[contains(text(), 'add')]");
    private final By addFormatButton = By.xpath("//div[contains(text(), 'Ad format')]");
    private final By cpmUsdInput = By.xpath("//input[@aria-label='CPM USD']");
    private final By cpcUsdInput = By.xpath("//input[@aria-label='CPC USD']");
    private final By dealPlacesBlock = By.xpath("//div[contains(text(),'Deal places')]");
    private final By searchSiteButton = By.xpath("//button//div[contains(text(), 'Search site')]");
    private final By searchByIdInput = By.xpath("//input[@aria-label='Search by id']");
    private final By addSiteCheckbox = By.xpath("//div[@class='flex md2']//button//i[contains(text(), 'add')]");
    private final By addSiteButton = By.xpath("//button//i[contains(text(), 'add')];");
    private final By addNewDealPlaceButton = By.xpath("//div[@class='flex btn-container md2']//button//i[contains(text(), 'add')]");
    private final By placeNameInput = By.xpath("//input[@aria-label='Place name']");
    private final By selectPlaceInput = By.xpath("//input[@aria-label='Select place']");
    private final By labelInput = By.xpath("//input[@aria-label='Label']");
    private final By geoInput = By.xpath("//input[@aria-label='GEO']");
    private final By cpmCpcInput = By.xpath("//input[@aria-label='CPM/CPC']");
    private final By trafficChannelInput = By.xpath("//input[@aria-label='Traffic channel']");
    private final By trafficTypeInput = By.xpath("//input[@aria-label='Traffic type']");
    private final By networkMacrosInput = By.xpath("//input[@aria-label='Network makros']");
    private final By redirectorInput = By.xpath("//input[@aria-label='Redirector']");
    private final By linkPpInput = By.xpath("//input[@aria-label='Link PP']");
    private final By saveButton = By.xpath("//div[contains(text(), 'Save')]");
    private final By saveDealButton = By.xpath("//button//i[contains(., 'save')]");
    private final By sendOnReviewButton = By.xpath("//span[contains(text(),'send on review')]");
    private final By profileButton = By.xpath("//button[@id='profile_btn']");
    private final By exitButton = By.xpath("//a[@id='exit_btn']");

    public DealPageCPM(WebDriver webDriver) {
        super(webDriver);
    }

    public DealPageCPM clickOnSiteOverviewBlock() {
        waitForElementClickable(webDriver, siteOverviewBlock).click();
        return this;
    }

    public DealPageCPM inputLink(String link) {
        findElement(webDriver, linkInput).sendKeys("http://football.ua");
        return this;
    }

    public DealPageCPM clickOnAddLinkButton() {
        findElement(webDriver, addLinkButton).click();
        return this;
    }

    public DealPageCPM clickOnAddFormatButton() {
        waitForElementClickable(webDriver, addFormatButton).click();
        return this;
    }

    public DealPageCPM inputSelectPlaceInAdFormat(String place) {
        findElement(webDriver, selectPlaceInput).sendKeys("article" + Keys.ENTER);
        return this;
    }

    public DealPageCPM inputGeoInAdFormat(String geo) {
        findElement(webDriver, geoInput).sendKeys("Austria" + Keys.ENTER);
        return this;
    }

    public DealPageCPM inputCpmUsd(String usd) {
        findElement(webDriver, cpmUsdInput).sendKeys("10");
        return this;
    }

    public DealPageCPM inputCpcUsd(String usd) {
        findElement(webDriver, cpcUsdInput).sendKeys("10");
        return this;
    }

    public DealPageCPM inputTrafficTypeInAdFormat(String type) {
        findElement(webDriver, trafficTypeInput).sendKeys("MS" + Keys.ENTER);
        return this;
    }

    public DealPageCPM inputTrafficChannelInAdFormat(String channel) {
        findElement(webDriver, trafficChannelInput).sendKeys("desk" + Keys.ENTER);
        return this;
    }

    public DealPageCPM clickOnSaveFormatButton() {
        findElement(webDriver, saveButton).click();
        return this;
    }

    public DealPageCPM clickOnDealPlaceBlock() {
        waitForElementClickable(webDriver, dealPlacesBlock).click();
        return this;
    }

    public DealPageCPM clickOnSearchSiteButton() {
        findElement(webDriver, searchSiteButton).click();
        return this;
    }

    public DealPageCPM inputSearchById(String id) {
        waitForElementClickable(webDriver, searchByIdInput).sendKeys("281325");
        return this;
    }

    public DealPageCPM clickOnAddSiteCheckbox() {
        waitForElementClickable(webDriver, addSiteCheckbox).click();
        return this;
    }

    public DealPageCPM clickOnAddSiteButton() {
        waitForElementClickable(webDriver, addSiteButton).click();
        return this;
    }

    public DealPageCPM clickOnAddNewDealPlaceButton() {
        waitForElementClickable(webDriver, addNewDealPlaceButton).click();
        return this;
    }

    public DealPageCPM inputPlaceName(String name) {
        waitForElementClickable(webDriver, placeNameInput).sendKeys("Place name");
        return this;
    }

    public DealPageCPM inputSelectPlaceInNewPlace(String place) {
        findElement(webDriver, selectPlaceInput).sendKeys("article" + Keys.ENTER);
        return this;
    }

    public DealPageCPM inputLabel(String label) {
        findElement(webDriver, labelInput).sendKeys("cyber" + Keys.ENTER);
        return this;
    }

    public DealPageCPM inputGeoInNewPlace(String geo) {
        findElement(webDriver, geoInput).sendKeys("Austria" + Keys.ENTER);
        return this;
    }

    public DealPageCPM inputCpmCpc(String cpm) {
        findElement(webDriver, cpmCpcInput).sendKeys("cpm" + Keys.ENTER);
        return this;
    }

    public DealPageCPM inputTrafficChannelInNewPlace(String channel) {
        findElement(webDriver, trafficChannelInput).sendKeys("desk" + Keys.ENTER);
        return this;
    }

    public DealPageCPM inputTrafficTypeInNewPlace(String type) {
        findElement(webDriver, trafficTypeInput).sendKeys("MS" + Keys.ENTER);
        return this;
    }

//    public DealPageCPM inputNetworkMacros(String macros) {
//        findElement(webDriver, networkMacrosInput).sendKeys("1" + Keys.ENTER);
//        return this;
//    }

//    public DealPageCPM inputRedirector(String macros) {
//        findElement(webDriver, redirectorInput).sendKeys("");
//        return this;
//    }

    public DealPageCPM inputLinkPP(String link) {
        findElement(webDriver, linkPpInput)
                .sendKeys("https://affpa.top/L?tag=d_1370971m_97c_&site=1370971&ad=97&r=registration/");
        return this;
    }

    public DealPageCPM clickOnSaveNewPlace() {
        findElement(webDriver, saveButton).click();
        return this;
    }

    public DealPageCPM clickOnSaveDealButton() {
        findElement(webDriver, saveDealButton).click();
        return this;
    }

    public DealPageCPM clickOnSendOnReviewButton() {
        waitForElementClickable(webDriver, sendOnReviewButton).click();
        return this;
    }

    public DealPageCPM clickOnProfileButton() {
        waitForElementClickable(webDriver, profileButton).click();
        return this;
    }

    public DealPageCPM clickOnExitButton() {
        findElement(webDriver, exitButton).click();
        return this;
    }
}
