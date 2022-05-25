package com.ui.pages.ManagerCreateDealFixZid.ManagerApproveDeal;

import com.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class DealsListPageManager extends BasePage {
    private final By dealTypeInput = By.xpath("//input[@aria-label='Deal type']");
    private final By startDateSort = By.xpath("//th[contains(., 'Start date')]");
    private final By openDealButton = By.xpath("//i[contains(., 'open_in_new')]");

    public DealsListPageManager(WebDriver webDriver) {
        super(webDriver);
    }

    public DealsListPageManager inputDealType (String type) {
        findElement(webDriver, dealTypeInput).sendKeys("fix_b2b" + Keys.ENTER);
        return this;
    }

    public DealsListPageManager clickOnStartDateSort() {
        waitForElementClickable(webDriver, startDateSort).click();
        waitForElementClickable(webDriver, startDateSort).click();
        return this;
    }

    public DealPageM clickOnOpenDealButton() {
        findElement(webDriver, openDealButton).click();
        return new DealPageM(webDriver);
    }
}
