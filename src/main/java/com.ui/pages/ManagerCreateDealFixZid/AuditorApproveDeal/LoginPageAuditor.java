package com.ui.pages.ManagerCreateDealFixZid.AuditorApproveDeal;

import com.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageAuditor extends BasePage {
    private final By loginField = By.xpath("//input[@aria-label='Login']");
    private final By passwordField = By.xpath("//input[@aria-label='Password']");
    private final By signInButton = By.xpath("//button[contains(., 'Sign in')]");
    private final By authCodeInput = By.xpath("//input[@aria-label='Authentication code']");
    private final By sendCodeButton = By.xpath("//button[contains(., 'Send')]");

    public LoginPageAuditor(WebDriver webDriver, String url) {
        super(webDriver, url);
    }

    public LoginPageAuditor inputLogin(String login) {
        findElement(webDriver, loginField).sendKeys("auditor_TEST_UI");
        return this;
    }

    public LoginPageAuditor inputPassword(String password) {
        findElement(webDriver, passwordField).sendKeys("132465798");
        return this;
    }

    public LoginPageAuditor clickOnSignInButton() {
        findElement(webDriver, signInButton).click();
        return this;
    }

    public LoginPageAuditor inputAuthCode(String auditor2FaCode) {
        findElement(webDriver, authCodeInput).sendKeys(auditor2FaCode);
        return this;
    }

    public MainPageAuditor clickOnSendCodeButton() {
        findElement(webDriver, sendCodeButton).click();
        return new MainPageAuditor(webDriver);
    }
}
