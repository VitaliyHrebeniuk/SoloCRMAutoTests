package com.ui.pages.ManagerCreateDealB2B;

import com.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class DealPageB2B extends BasePage {
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
    private final By dealZidsBlock = By.xpath("//div[contains(text(),'Deal zids')]");
    private final By addZidCidButton = By.xpath("//button//div[contains(text(),' Add Zid / Cid ')]");
    private final By siteInput = By.xpath("//input[@aria-label='Select site']");
    private final By zidCidValueInput = By.xpath("//input[@aria-label='Zid/Cid value']");
    int a = (int) (Math.random() * 100000);
    String b = String.valueOf(a);
    private final By labelInput = By.xpath("//input[@aria-label='Label']");
    private final By trafficChannelInput = By.xpath("//input[@aria-label='Traffic channel']");
    private final By saveZidCidButton = By.xpath("//button//div[contains(.,'Save')]");
    private final By dealPlacesBlock = By.xpath("//div[contains(text(),'Deal places')]");
    private final By searchSiteByIdInput = By.xpath("//input[@aria-label='Search site by id']");
    private final By addNewDealPlaceButton = By.xpath("//i[contains(.,'add')]");
    private final By geoInput = By.xpath("//input[@aria-label='GEO']");
    private final By linkPpInput = By.xpath("//input[@aria-label='Link PP']");
    private final By saveDealPlaceButton = By.xpath("//button//div[contains(.,'Save')]");
    private final By saveDealButton = By.xpath("//button//i[contains(., 'save')]");
    private final By sendOnReviewButton = By.xpath("//span[contains(text(),'send on review')]");
    private final By profileButton = By.xpath("//button[@id='profile_btn']");
    private final By exitButton = By.xpath("//a[@id='exit_btn']");

    public DealPageB2B(WebDriver webDriver) {
        super(webDriver);
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

    public DealPageB2B clickOnAddFormatButton() {
        waitForElementClickable(webDriver, addFormatButton).click();
        return this;
    }

    public DealPageB2B inputSelectPlace(String place) {
        findElement(webDriver, selectPlaceInput).sendKeys("article" + Keys.ENTER);
        return this;
    }

    public DealPageB2B inputCost(String cost) {
        findElement(webDriver, costInput).sendKeys("10");
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

    public DealPageB2B clickOnSaveZidCidButton() {
        findElement(webDriver, saveZidCidButton).click();
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

    public DealPageB2B clickOnSaveDealPlaceButton() {
        findElement(webDriver, saveDealPlaceButton).click();
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
}
