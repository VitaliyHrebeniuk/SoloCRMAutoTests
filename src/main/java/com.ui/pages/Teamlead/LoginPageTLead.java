package com.ui.pages.Teamlead;

import com.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageTLead extends BasePage {
    private final By loginField = By.xpath("//input[@aria-label='Login']");
    private final By passwordField = By.xpath("//input[@aria-label='Password']");
    private final By signInButton = By.xpath("//button[contains(., 'Sign in')]");
    private final By authCodeInput = By.xpath("//input[@aria-label='Authentication code']");
    private final By sendCodeButton = By.xpath("//button[contains(., 'Send')]");

    public LoginPageTLead(WebDriver webDriver, String url) {
        super(webDriver, url);
    }


    public LoginPageTLead inputLogin(String login) {
        findElement(webDriver, loginField).sendKeys("teamlead_TEST_UI");
        return this;
    }

    public LoginPageTLead inputPassword(String password) {
        findElement(webDriver, passwordField).sendKeys("132465798");
        return this;
    }

    public LoginPageTLead clickOnSignInButton() {
        findElement(webDriver, signInButton).click();
        return this;
    }

    public LoginPageTLead inputAuthCode(String teamLead2FaCode) {
        findElement(webDriver, authCodeInput).sendKeys(teamLead2FaCode);
        return this;
    }

    public MainPageTLead clickOnSendCodeButton() {
        findElement(webDriver, sendCodeButton).click();
        return new MainPageTLead(webDriver);
    }
}

