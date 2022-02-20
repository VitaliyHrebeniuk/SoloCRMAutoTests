package com.ui.pages.ManagerCreateDealFixZid.ManagerApproveDeal;

import com.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class DealPageM extends BasePage {
    private final By dealPaymentsBlockButton = By.xpath("//div[contains(text(),'Deal payments & contracts')]");
    private final By newPaymentButton = By.xpath("//button[@id='add-payment']");
    private final By startDateInput = By.xpath("//input[@id='payment-start_date']");
    private final By endDateInput = By.xpath("//input[@id='payment-end_date']");
    private final By paymentTargetInput = By.xpath("//input[@id='payment-payment_target_id']");
    private final By typeInput = By.xpath("//input[@id='payment-type']");
    private final By walletInput = By.xpath("//input[@id='payment-wallet_id']");
    private final By costInput = By.xpath("//input[@id='payment-summary']");
    private final By continueButton = By.xpath("//div[contains(text(),'Continue')]");
    private final By remainingCostInput = By.xpath("//input[@aria-label='Cost']");
    private final By remainingZidCostInput = By.xpath("//input[@id='payment-analytic-zid-cost']");
    private final By savePaymentButton = By.xpath("//div[contains(text(),'Save payment')]");
    private final By approvePaymentButton = By.xpath("//i[contains(., 'thumb_up')]");
    private final By profileButton = By.xpath("//button[@id='profile_btn']");
    private final By exitButton = By.xpath("//a[@id='exit_btn']");

    public DealPageM(WebDriver webDriver) {
        super(webDriver);
    }

    public DealPageM clickOnDealPaymentsBlockButton() {
        waitForElementClickable(webDriver, dealPaymentsBlockButton).click();
        return this;
    }

    public DealPageM clickOnNewPaymentButton() {
        waitForElementClickable(webDriver, newPaymentButton).click();
        return this;
    }

    public DealPageM inputStartDate(String date) {
        findElement(webDriver, startDateInput).sendKeys("2022-01-01" + Keys.ENTER);
        return this;
    }

    public DealPageM inputEndDate(String date) {
        findElement(webDriver,endDateInput).sendKeys("2022-02-01" + Keys.ENTER);
        return this;
    }

    public DealPageM inputPaymentTarget(String target) {
        findElement(webDriver, paymentTargetInput).sendKeys("1x" + Keys.ARROW_DOWN + Keys.ENTER);
        return this;
    }

    public DealPageM inputType(String type) {
        findElement(webDriver, typeInput).sendKeys("prepaid" + Keys.ENTER);
        return this;
    }

    public DealPageM inputWallet(String wallet) {
        findElement(webDriver, walletInput).sendKeys("WMZ" + Keys.ARROW_DOWN + Keys.ENTER);
        return this;
    }

    public DealPageM inputCost(String cost) {
        findElement(webDriver, costInput).sendKeys("100");
        return this;
    }

    public DealPageM clickOnContinueButton() {
        findElement(webDriver, continueButton).click();
        return this;
    }

    public DealPageM inputRemainingCost(String cost) {
        waitForElementClickable(webDriver, remainingCostInput).sendKeys("50");
        return this;
    }

    public DealPageM inputRemainingZidCost(String cost) {
        findElement(webDriver, remainingZidCostInput).sendKeys("50");
        return this;
    }

    public DealPageM clickOnSavePaymentButton() {
        findElement(webDriver, savePaymentButton).click();
        return this;
    }

    public DealPageM clickOnApprovePaymentButton() {
        waitForElementClickable(webDriver, approvePaymentButton).click();
        return this;
    }

    public DealPageM clickOnProfileButton() {
        findElement(webDriver, profileButton).click();
        return this;
    }

    public DealPageM clickOnExitButton() {
        findElement(webDriver, exitButton).click();
        return this;
    }
}
