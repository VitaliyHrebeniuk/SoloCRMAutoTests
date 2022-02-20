package com.ui.pages.ManagerCreateDealFixZid.BuyingControlApproveDeal;

import com.ui.pages.BasePage;
import com.ui.pages.ManagerCreateDealFixZid.ManagerApproveDeal.DealsListPageM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DealsListPageBControl extends BasePage {
    private final By startDateSort = By.xpath("//th[contains(., 'Start date')]");
    private final By openDealButton = By.xpath("//i[contains(., 'open_in_new')]");

    public DealsListPageBControl(WebDriver webDriver) {
        super(webDriver);
    }

    public DealsListPageBControl clickOnStartDateSort() {
        waitForElementClickable(webDriver, startDateSort).click();
        waitForElementClickable(webDriver, startDateSort).click();
        return this;
    }

    public DealPageBControl clickOnOpenDealButton() {
        findElement(webDriver, openDealButton).click();
        return new DealPageBControl(webDriver);
    }
}
