package com.ui.pages.Manager;

import com.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class DealsListPageManager extends BasePage {
    private final By dealTypeInput = By.xpath("//input[@aria-label='Deal type']");
    private final By dealStatusInput = By.xpath("//input[@aria-label='Deal status']");
    private final By startDateSort = By.xpath("//th[contains(., 'Start date')]");
    private final By openDealButton = By.xpath("//i[contains(., 'open_in_new')]");

    public DealsListPageManager(WebDriver webDriver) {
        super(webDriver);
    }

    public DealsListPageManager inputDealTypeB2B (String type) throws InterruptedException {
        Thread.sleep(3000);
        findElement(webDriver, dealTypeInput).sendKeys("fix_b2b" + Keys.ENTER);
        return this;
    }
    public DealsListPageManager inputDealTypeFixZid (String type) throws InterruptedException {
        Thread.sleep(3000);
        findElement(webDriver, dealTypeInput).sendKeys("fix_zid" + Keys.ENTER);
        return this;
    }
    public DealsListPageManager inputDealTypeFixSmm (String type) throws InterruptedException {
        Thread.sleep(3000);
        findElement(webDriver, dealTypeInput).sendKeys("fix_smm" + Keys.ENTER);
        return this;
    }
    public DealsListPageManager inputDealTypeFixApp (String type) throws InterruptedException {
        Thread.sleep(3000);
        findElement(webDriver, dealTypeInput).sendKeys("fix_app" + Keys.ENTER);
        return this;
    }
    public DealsListPageManager inputDealTypeCPI (String type) throws InterruptedException {
        Thread.sleep(3000);
        findElement(webDriver, dealTypeInput).sendKeys("cpi" + Keys.ENTER);
        return this;
    }
    public DealsListPageManager inputDealStatus (String type) throws InterruptedException {
        Thread.sleep(3000);
        findElement(webDriver, dealStatusInput).sendKeys("approval" + Keys.ENTER);
        return this;
    }
    public DealsListPageManager clickOnStartDateSort() throws InterruptedException {
        Thread.sleep(3000);
        waitForElementClickable(webDriver, startDateSort).click();
        waitForElementClickable(webDriver, startDateSort).click();
        return this;
    }
    public DealPageFixZid clickOnOpenDealFixZidButton() throws InterruptedException {
        Thread.sleep(3000);
        findElement(webDriver, openDealButton).click();
        switchToNewFrame(webDriver);
        return new DealPageFixZid(webDriver);
    }
    public DealPageB2B clickOnOpenDealB2BButton() throws InterruptedException {
        Thread.sleep(3000);
        findElement(webDriver, openDealButton).click();
        switchToNewFrame(webDriver);
        return new DealPageB2B(webDriver);
    }
    public DealPageFixSMM clickOnOpenDealFixSmmButton() throws InterruptedException {
        Thread.sleep(3000);
        findElement(webDriver, openDealButton).click();
        switchToNewFrame(webDriver);
        return new DealPageFixSMM(webDriver);
    }
    public DealPageFixApp clickOnOpenDealFixAppButton() throws InterruptedException {
        Thread.sleep(3000);
        findElement(webDriver, openDealButton).click();
        switchToNewFrame(webDriver);
        return new DealPageFixApp(webDriver);
    }
    public DealPageCPI clickOnOpenDealCPIButton() throws InterruptedException {
        Thread.sleep(3000);
        findElement(webDriver, openDealButton).click();
        switchToNewFrame(webDriver);
        return new DealPageCPI(webDriver);
    }
}
