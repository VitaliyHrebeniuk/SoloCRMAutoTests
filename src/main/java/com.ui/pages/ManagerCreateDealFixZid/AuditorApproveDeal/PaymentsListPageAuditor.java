package com.ui.pages.ManagerCreateDealFixZid.AuditorApproveDeal;

import com.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentsListPageAuditor extends BasePage {
    private final By walletInput = By.xpath("//input[@aria-label='Wallet']");
    private final By checkboxButton = By.xpath("(//div[@class='v-input--selection-controls__ripple'])[4]");
    private final By infoOverlay = By.xpath("//div[contains(text(), 'CRM updated')]");
    private final By approvePaymentButton = By.xpath("//i[contains(text(),'thumb_up')]");
    private final By profileButton = By.xpath("//button[@id='profile_btn']");
    private final By exitButton = By.xpath("//a[@id='exit_btn']");
    private final By confirmExit = By.xpath("//div[contains(text(),'Yes')]");

    public PaymentsListPageAuditor(WebDriver webDriver) {
        super(webDriver);
    }

    public PaymentsListPageAuditor inputWallet(String wallet) {
        waitForElementClickable(webDriver, walletInput).sendKeys("Z146407012030");
        return this;
    }

    public PaymentsListPageAuditor clickOnCheckboxButton() {
        waitForElementClickable(webDriver, checkboxButton).click();
        return this;
    }

    public PaymentsListPageAuditor clickOnApprovePaymentButton() throws InterruptedException {
        Thread.sleep(15000);
        waitForInvisibility(webDriver, infoOverlay, 20L);
        findElement(webDriver, approvePaymentButton).click();
        return this;
    }

    public PaymentsListPageAuditor clickOnProfileButton() {
        findElement(webDriver, profileButton).click();
        return this;
    }

    public PaymentsListPageAuditor clickOnExitButton() {
        findElement(webDriver, exitButton).click();
        findElement(webDriver, confirmExit).click();
        return this;
    }
}
