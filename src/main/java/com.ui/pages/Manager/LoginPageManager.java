package com.ui.pages.Manager;

import com.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageManager extends BasePage {
    private final By loginField = By.xpath("//input[@aria-label='Login']");
    private final By passwordField = By.xpath("//input[@aria-label='Password']");
    private final By signInButton = By.xpath("//button[contains(., 'Sign in')]");
    private final By authCodeInput = By.xpath("//input[@aria-label='Authentication code']");
    private final By sendCodeButton = By.xpath("//button[contains(., 'Send')]");

    public LoginPageManager(WebDriver webDriver, String url) {
        super(webDriver, url);
    }

    public LoginPageManager inputLogin(String login) {
        findElement(webDriver, loginField).sendKeys("manager_TEST_UI");
        return this;
    }

    public LoginPageManager inputPassword(String password) {
        findElement(webDriver, passwordField).sendKeys("132465798");
        return this;
    }

    public LoginPageManager clickOnSignInButton() {
        findElement(webDriver, signInButton).click();
        return this;
    }

    public LoginPageManager inputAuthCode(String manager2FaCode) {
        findElement(webDriver, authCodeInput).sendKeys(manager2FaCode);
        return this;
    }

    public MainPageManager clickOnSendCodeButton() {
        findElement(webDriver, sendCodeButton).click();
        return new MainPageManager(webDriver);
    }
}