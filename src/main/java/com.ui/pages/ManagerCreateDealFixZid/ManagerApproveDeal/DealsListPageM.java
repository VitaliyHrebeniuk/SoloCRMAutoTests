package com.ui.pages.ManagerCreateDealFixZid.ManagerApproveDeal;

import com.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DealsListPageM extends BasePage {
    private final By startDateSort = By.xpath("//th[contains(., 'Start date')]");
    private final By openDealButton = By.xpath("//i[contains(., 'open_in_new')]");

    public DealsListPageM(WebDriver webDriver) {
        super(webDriver);
    }

    public DealsListPageM clickOnStartDateSort() {
        waitForElementClickable(webDriver, startDateSort).click();
        waitForElementClickable(webDriver, startDateSort).click();
        return this;
    }

    public DealPageM clickOnOpenDealButton() {
        findElement(webDriver, openDealButton).click();
        return new DealPageM(webDriver);
    }
}
