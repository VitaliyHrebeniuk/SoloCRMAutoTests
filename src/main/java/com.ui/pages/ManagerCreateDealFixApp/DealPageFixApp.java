package com.ui.pages.ManagerCreateDealFixApp;

import com.ui.pages.BasePage;
import com.ui.pages.ManagerCreateDealB2B.DealPageB2B;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class DealPageFixApp extends BasePage {
    private final By siteOverviewBlock = By.xpath("//div[contains(text(),'Site Overview')]");
    private final By searchLinkButton = By.xpath("//i[contains(.,'search')]");
    private final By linkInput = By.xpath("//input[@aria-label='Search by link']");
    private final By addLinkButton = By.xpath("//button//i[contains(text(), 'add')]");
    private final By addFormatButton = By.xpath("//div[contains(text(),'Ad format')]");
    private final By selectPlaceInput = By.xpath("//input[@aria-label='Select place']");
    private final By costInput = By.xpath("//input[@aria-label='Cost']");
    private final By cpmInput = By.xpath("//input[@aria-label='CPM']");
    private final By trafficVolumeInput = By.xpath("//input[@aria-label='Traffic volume']");
    private final By saveFormatButton = By.xpath("//button//div[contains(.,'Save')]");
    private final By dealPlacesBlock = By.xpath("//div[contains(text(),'Deal places')]");
    private final By searchSiteByIdInput = By.xpath("//input[@id='cpi-deal_place-search']");
    private final By addNewDealPlaceButton = By.xpath("//i[contains(.,'add')]");
    private final By platformInput = By.xpath("//input[@aria-label='Platform']");
    private final By labelInput = By.xpath("//input[@aria-label='Label']");
    private final By geoInput = By.xpath("//input[@aria-label='GEO']");
    private final By linkPpInput = By.xpath("//input[@aria-label='Link PP']");
    private final By saveDealPlaceButton = By.xpath("//button//div[contains(.,'Save')]");
    private final By saveDealButton = By.xpath("//button//i[contains(., 'save')]");
    private final By sendOnReviewButton = By.xpath("//span[contains(text(),'send on review')]");
    private final By profileButton = By.xpath("//button[@id='profile_btn']");
    private final By exitButton = By.xpath("//a[@id='exit_btn']");



    public DealPageFixApp(WebDriver webDriver) {
        super(webDriver);
    }

    public DealPageFixApp clickOnSiteOverviewBlock() {
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

    public DealPageFixApp clickOnAddFormatButton() {
        waitForElementClickable(webDriver, addFormatButton).click();
        return this;
    }

    public DealPageFixApp inputSelectPlace(String place) {
        findElement(webDriver, selectPlaceInput).sendKeys("article" + Keys.ENTER);
        return this;
    }

    public DealPageFixApp inputCost(String cost) {
        findElement(webDriver, costInput).sendKeys("10");
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

    public DealPageFixApp clickOnSaveFormatButton() {
        findElement(webDriver, saveFormatButton).click();
        return this;
    }

    public DealPageFixApp clickOnDealPlacesBlock() {
        findElement(webDriver, dealPlacesBlock).click();
        return this;
    }

    public DealPageFixApp inputSearchSiteById(String site) {
        findElement(webDriver, searchSiteByIdInput).sendKeys("20578" + Keys.ENTER);
        return this;
    }

    public DealPageFixApp clickOnAddNewDealPlaceButton() {
        findElement(webDriver, addNewDealPlaceButton).click();
        return this;
    }

    public DealPageFixApp inputSelectPlaceNewDealPlace(String place) {
        findElement(webDriver, selectPlaceInput).sendKeys("article" + Keys.ENTER);
        return this;
    }

    public DealPageFixApp inputPlatform(String platform) {
        findElement(webDriver, platformInput).sendKeys("All" + Keys.ENTER);
        return this;
    }

    public DealPageFixApp inputLabel(String label) {
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

    public DealPageFixApp clickOnSaveDealPlaceButton() {
        findElement(webDriver, saveDealPlaceButton).click();
        return this;
    }

    public DealPageFixApp clickOnSaveDealButton() {
        findElement(webDriver, saveDealButton).click();
        return this;
    }

    public DealPageFixApp clickOnSendOnReviewButton() {
        waitForElementClickable(webDriver, sendOnReviewButton).click();
        return this;
    }

    public DealPageFixApp clickOnProfileButton() {
        waitForElementClickable(webDriver, profileButton).click();
        return this;
    }

    public DealPageFixApp clickOnExitButton() {
        findElement(webDriver, exitButton).click();
        return this;
    }
}
