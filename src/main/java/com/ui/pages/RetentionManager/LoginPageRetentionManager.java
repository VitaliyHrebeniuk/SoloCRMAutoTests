package com.ui.pages.RetentionManager;

import com.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPageRetentionManager extends BasePage{
    private final By loginField = By.xpath("//input[@aria-label='Login']");
    private final By passwordField = By.xpath("//input[@aria-label='Password']");
    private final By signInButton = By.xpath("//button[contains(., 'Sign in')]");
    private final By authCodeInput = By.xpath("//input[@aria-label='Authentication code']");
    private final By sendCodeButton = By.xpath("//button[contains(., 'Send')]");


    public LoginPageRetentionManager(WebDriver webDriver, String url) {
        super(webDriver, url);
    }

    public LoginPageRetentionManager inputLogin(String login) {
        findElement(webDriver, loginField).sendKeys("retention_manager_TEST_UI");
        return this;
    }

    public LoginPageRetentionManager inputPassword(String password) {
        findElement(webDriver, passwordField).sendKeys("132465798");
        return this;
    }

    public LoginPageRetentionManager clickOnSignInButton() {
        findElement(webDriver, signInButton).click();
        return this;
    }

    public LoginPageRetentionManager inputAuthCode(String retentionManager2FaCode) {
        findElement(webDriver, authCodeInput).sendKeys(retentionManager2FaCode);
        return this;
    }

    public MainPageRetentionManager clickOnSendCodeButton() {
        findElement(webDriver, sendCodeButton).click();
        return new MainPageRetentionManager(webDriver);
    }



}
