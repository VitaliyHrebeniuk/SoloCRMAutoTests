package com.ui.pages.Manager;

import com.ui.pages.BasePage;
import com.ui.pages.ManagerCreateDealFixZid.ManagerApproveDeal.DealPageM;
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
        Thread.sleep(5000);
        findElement(webDriver, dealTypeInput).sendKeys("fix_b2b" + Keys.ENTER);
        return this;
    }
    public DealsListPageManager inputDealStatus (String type) throws InterruptedException {
        Thread.sleep(5000);
        findElement(webDriver, dealStatusInput).sendKeys("revision" + Keys.ENTER);
        return this;
    }
    public DealsListPageManager clickOnStartDateSort() throws InterruptedException {
        Thread.sleep(5000);
        waitForElementClickable(webDriver, startDateSort).click();
        waitForElementClickable(webDriver, startDateSort).click();
        return this;
    }
    public DealPageM clickOnOpenDealButton() throws InterruptedException {
        Thread.sleep(5000);
        findElement(webDriver, openDealButton).click();
        return new DealPageM(webDriver);
    }
}
