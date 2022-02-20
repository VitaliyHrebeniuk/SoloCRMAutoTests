package com.ui.pages.ManagerCreateDealCPI;

import com.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class DealPageCPI extends BasePage {
    private final By siteOverviewBlock = By.xpath("//div[contains(text(),'Site Overview')]");
    private final By linkInput = By.xpath("//input[@id='cpi-link_search']");
    private final By addLinkButton = By.xpath("//button//i[contains(text(), 'add')]");
    private final By costPerInstallBlock = By.xpath("//div[contains(text(),'Cost per install')]");
    private final By setCostButton = By.xpath("//button//div[contains(., 'Set cost')]");
    private final By selectCountryInput = By.xpath("//input[@aria-label='Select country']");
    private final By costInput = By.xpath("//tr[contains(.,'Austria')]//input[@type='number']");
    private final By saveCostButton = By.xpath("//button[contains(.,'Save')]");
    private final By dealPlacesBlock = By.xpath("//div[@class='subheading'][contains(.,'Deal places')]");
    private final By searchSiteInput = By.xpath("//input[@id='cpi-deal_place-search']");
    private final By addDealPlaceButton = By.xpath("//button[@id='cpi-add_place_20578']");
    private final By selectPlaceInput = By.xpath("//input[@id='cpi-deal_place_type_id']");
    private final By platformInput = By.xpath("//input[@id='cpi-source_type_id']");
    private final By labelInput = By.xpath("//input[@id='cpi-label']");
    private final By geoInput = By.xpath("//input[@id='cpi-country_id']");
    private final By saveDealPlaceButton = By.xpath("//button[@id='cpi-save_place']");
    private final By saveDealButton = By.xpath("//button//i[contains(., 'save')]");
    private final By sendOnReviewButton = By.xpath("//span[contains(text(),'send on review')]");
    private final By profileButton = By.xpath("//button[@id='profile_btn']");
    private final By exitButton = By.xpath("//a[@id='exit_btn']");


    public DealPageCPI(WebDriver webDriver) {
        super(webDriver);
    }

    public DealPageCPI clickOnSiteOverviewBlock() {
        waitForElementClickable(webDriver, siteOverviewBlock).click();
        return this;
    }

    public DealPageCPI inputLink(String link) {
        findElement(webDriver, linkInput).sendKeys("https://football.ua");
        return this;
    }

    public DealPageCPI clickOnAddLinkButton() {
        waitForElementClickable(webDriver, addLinkButton).click();
        return this;
    }

    public DealPageCPI clickOnCostPerInstallBlock() {
        waitForElementClickable(webDriver, costPerInstallBlock).click();
        return this;
    }

    public DealPageCPI clickOnSetCostButton() {
        findElement(webDriver, setCostButton).click();
        return this;
    }

    public DealPageCPI inputSelectCountry(String country) {
        findElement(webDriver, selectCountryInput).sendKeys("Austria" + Keys.ENTER);
        return this;
    }

    public DealPageCPI inputCost(String cost) {
        findElement(webDriver, costInput).sendKeys("10");
        return this;
    }

    public DealPageCPI clickOnSaveCostButton() {
        findElement(webDriver, saveCostButton).click();
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
        waitForElementClickable(webDriver, selectPlaceInput).sendKeys("banner" + Keys.ENTER);
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

    public DealPageCPI clickOnSaveDealPlaceButton() {
        findElement(webDriver, saveDealPlaceButton).click();
        return this;
    }

    public DealPageCPI clickOnSaveDealButton() {
        findElement(webDriver, saveDealButton).click();
        return this;
    }

    public DealPageCPI clickOnSendOnReviewButton() {
        waitForElementClickable(webDriver, sendOnReviewButton).click();
        return this;
    }

    public DealPageCPI clickOnProfileButton() {
        waitForElementClickable(webDriver, profileButton).click();
        return this;
    }

    public DealPageCPI clickOnExitButton() {
        findElement(webDriver, exitButton).click();
        return this;
    }
}
