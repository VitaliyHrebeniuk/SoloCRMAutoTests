package com.ui.pages.ManagerCreateDealFixZid.TeamLeadApproveDeal;

import com.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DealPageTLead extends BasePage {
    private final By approvePaymentButton = By.xpath("//i[contains(., 'thumb_up')]");
    private final By profileButton = By.xpath("//button[@id='profile_btn']");
    private final By exitButton = By.xpath("//a[@id='exit_btn']");

    public DealPageTLead(WebDriver webDriver) {
        super(webDriver);
    }

    public DealPageTLead clickOnApprovePaymentButton() {
        waitForElementClickable(webDriver, approvePaymentButton).click();
        return this;
    }

    public DealPageTLead clickOnProfileButton() {
        findElement(webDriver, profileButton).click();
        return this;
    }

    public DealPageTLead clickOnExitButton() {
        findElement(webDriver, exitButton).click();
        return this;
    }
}
