package com.ui.pages.ManagerCreateDealFixZid.ManagerCreateDeal;

import com.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginManagerPage extends BasePage {
    private final By loginField = By.xpath("//input[@aria-label='Login']");
    private final By passwordField = By.xpath("//input[@aria-label='Password']");
    private final By signInButton = By.xpath("//button[contains(., 'Sign in')]");
    private final By authCodeInput = By.xpath("//input[@aria-label='Authentication code']");
    private final By sendCodeButton = By.xpath("//button[contains(., 'Send')]");

    public LoginManagerPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }

    public LoginManagerPage inputLogin(String login) {
        findElement(webDriver, loginField).sendKeys("manager_TEST_UI");
        return this;
    }

    public LoginManagerPage inputPassword(String password) {
        findElement(webDriver, passwordField).sendKeys("132465798");
        return this;
    }

    public LoginManagerPage clickOnSignInButton() {
        findElement(webDriver, signInButton).click();
        return this;
    }

    public LoginManagerPage inputAuthCode(String manager2FaCode) {
        findElement(webDriver, authCodeInput).sendKeys(manager2FaCode);
        return this;
    }

    public MainPage clickOnSendCodeButton() {
        findElement(webDriver, sendCodeButton).click();
        return new MainPage(webDriver);
    }
}
