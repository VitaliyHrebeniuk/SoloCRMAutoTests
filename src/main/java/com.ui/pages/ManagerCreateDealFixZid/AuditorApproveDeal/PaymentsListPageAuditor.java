package com.ui.pages.ManagerCreateDealFixZid.AuditorApproveDeal;

import com.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentsListPageAuditor extends BasePage {
    private final By checkboxButton = By.xpath("//i[contains(text(), 'check_box_outline_blank')]");
    private final By approvePaymentButton = By.xpath("//i[contains(text(),'thumb_up')]");
    private final By profileButton = By.xpath("//button[@id='profile_btn']");
    private final By exitButton = By.xpath("//a[@id='exit_btn']");

    public PaymentsListPageAuditor(WebDriver webDriver) {
        super(webDriver);
    }

    public PaymentsListPageAuditor clickOnCheckboxButton() {
        waitForElementClickable(webDriver, checkboxButton).click();
        return this;
    }

    public PaymentsListPageAuditor clickOnApprovePaymentButton() {
        findElement(webDriver, approvePaymentButton).click();
        return this;
    }

    public PaymentsListPageAuditor clickOnProfileButton() {
        findElement(webDriver, profileButton).click();
        return this;
    }

    public PaymentsListPageAuditor clickOnExitButton() {
        findElement(webDriver, exitButton).click();
        return this;
    }
}
