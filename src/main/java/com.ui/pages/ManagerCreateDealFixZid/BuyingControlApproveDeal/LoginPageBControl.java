package com.ui.pages.ManagerCreateDealFixZid.BuyingControlApproveDeal;

import com.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageBControl extends BasePage {
    private final By loginField = By.xpath("//input[@aria-label='Login']");
    private final By passwordField = By.xpath("//input[@aria-label='Password']");
    private final By signInButton = By.xpath("//button[contains(., 'Sign in')]");
    private final By authCodeInput = By.xpath("//input[@aria-label='Authentication code']");
    private final By sendCodeButton = By.xpath("//button[contains(., 'Send')]");

    public LoginPageBControl(WebDriver webDriver, String url) {
        super(webDriver, url);
    }


    public LoginPageBControl inputLogin(String login) {
        findElement(webDriver, loginField).sendKeys("buying_control_TEST_UI");
        return this;
    }

    public LoginPageBControl inputPassword(String password) {
        findElement(webDriver, passwordField).sendKeys("132465798");
        return this;
    }

    public LoginPageBControl clickOnSignInButton() {
        findElement(webDriver, signInButton).click();
        return this;
    }

    public LoginPageBControl inputAuthCode(String buyingControl2FaCode) {
        findElement(webDriver, authCodeInput).sendKeys(buyingControl2FaCode);
        return this;
    }

    public MainPageBControl clickOnSendCodeButton() {
        findElement(webDriver, sendCodeButton).click();
        return new MainPageBControl(webDriver);
    }
}

