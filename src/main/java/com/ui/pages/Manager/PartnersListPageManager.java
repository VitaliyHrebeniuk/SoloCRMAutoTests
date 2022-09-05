package com.ui.pages.Manager;

import com.ui.pages.ManagerCreateDealOffline.AddOfflineDealPage;
import com.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PartnersListPageManager extends BasePage {
    private final By partnerIdInput = By.xpath("//input[@aria-label='Partner id']");
    private final By addNewDealButton = By.xpath("//button[@id='partner-id_5445']");
    private final By zidCidButton = By.xpath("//a[@id='fix_zid_partner-id_5445']");
    private final By cpmButton = By.xpath("//div[contains(text(),'Deal CPM')]");
    private final By cpiButton = By.xpath("//div[contains(text(),'Deal CPI')]");
    private final By b2bButton = By.xpath("//div[contains(text(),'Deal FIX B2B')]");
    private final By fixAppButton = By.xpath("//div[contains(text(),'Deal FIX APP')]");
    private final By fixSmmButton = By.xpath("//div[contains(text(),'Deal FIX SMM')]");
    private final By offlineButton = By.xpath("//a[contains(text(),'Offline')]");
    private final By addNewOfflineDealButton = By.xpath("//a[@href='#/deals/add/offline/92567']");
    private final By editPartner = By.xpath("//i[contains(text(),'open_in_new')]");

    public PartnersListPageManager(WebDriver webDriver) {
        super(webDriver);
    }

    public PartnersListPageManager inputPartnersId(String id) throws InterruptedException {
        Thread.sleep(3000);
        waitForElementClickable(webDriver, editPartner);
        findElement(webDriver, partnerIdInput).sendKeys("5445");
        return this;
    }
    public PartnersListPageManager inputOfflinePartnersId(String id) {
        findElement(webDriver, partnerIdInput).sendKeys("92567");
        return this;
    }
    public PartnersListPageManager clickOnAddDealButton() {
        findElement(webDriver, addNewDealButton).click();
        return this;
    }
    public AddOfflineDealPage clickOnAddOfflineDealButton() {
        findElement(webDriver, addNewOfflineDealButton).click();
        return new AddOfflineDealPage(webDriver);
    }
    public PartnersListPageManager clickOnOfflineButton() {
        findElement(webDriver, offlineButton).click();
        return this;
    }
    public DealPageFixZid clickOnZidCidButton() {
        findElement(webDriver, zidCidButton).click();
        return new DealPageFixZid(webDriver);
    }
    public DealPageCPM clickOnCPMButton() {
        findElement(webDriver, cpmButton).click();
        return new DealPageCPM(webDriver);
    }
    public DealPageCPI clickOnCPIButton() {
        findElement(webDriver, cpiButton).click();
        return new DealPageCPI(webDriver);
    }
    public DealPageB2B clickOnB2bButton() {
        findElement(webDriver, b2bButton).click();
        return new DealPageB2B(webDriver);
    }
    public DealPageFixApp clickOnFixAppButton() {
        findElement(webDriver, fixAppButton).click();
        return new DealPageFixApp(webDriver);
    }
    public DealPageFixSMM clickOnFixSMMButton() {
        findElement(webDriver, fixSmmButton).click();
        return new DealPageFixSMM(webDriver);
    }
}
