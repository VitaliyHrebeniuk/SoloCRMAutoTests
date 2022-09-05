package com.ui.pages.Teamlead;

import com.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DealPageTLead extends BasePage {
    private final By dealPaymentsBlockButton = By.xpath("//div[contains(text(),'Deal payments')]");
    private final By infoOverlay = By.xpath("//div[contains(text(), 'Info')]");
    private final By approvePaymentButton = By.xpath("//button[@id='payment-positive_status']");
    private final By profileButton = By.xpath("//button[@id='profile_btn']");
    private final By exitButton = By.xpath("//a[@id='exit_btn']");
    private final By confirmExit = By.xpath("//div[contains(text(),'Yes')]");

    public DealPageTLead(WebDriver webDriver) {
        super(webDriver);
    }

    public DealPageTLead clickOnDealPaymentsBlockButton() {
        switchToNewFrame(webDriver);
        waitForElementClickable(webDriver, dealPaymentsBlockButton).click();
        return this;
    }

    public DealPageTLead clickOnApprovePaymentButton() {
        waitForInvisibility(webDriver, infoOverlay, 15L);
        waitForElementClickable(webDriver, approvePaymentButton).click();
        return this;
    }

    public DealPageTLead clickOnProfileButton() throws InterruptedException {
        Thread.sleep(3000);
        findElement(webDriver, profileButton).click();
        return this;
    }

    public DealPageTLead clickOnExitButton() {
        findElement(webDriver, exitButton).click();
        findElement(webDriver, confirmExit).click();
        return this;
    }
}
