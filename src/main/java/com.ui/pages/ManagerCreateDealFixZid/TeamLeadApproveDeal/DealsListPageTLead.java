package com.ui.pages.ManagerCreateDealFixZid.TeamLeadApproveDeal;

import com.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DealsListPageTLead extends BasePage {
    private final By startDateSort = By.xpath("//th[contains(., 'Start date')]");
    private final By openDealButton = By.xpath("//i[contains(., 'open_in_new')]");

    public DealsListPageTLead(WebDriver webDriver) {
        super(webDriver);
    }

    public DealsListPageTLead clickOnStartDateSort() {
        waitForElementClickable(webDriver, startDateSort).click();
        waitForElementClickable(webDriver, startDateSort).click();
        return this;
    }

    public DealPageTLead clickOnOpenDealButton() {
        findElement(webDriver, openDealButton).click();
        return new DealPageTLead(webDriver);
    }
}
