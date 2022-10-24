package com.ui.pages.Chief;

import com.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPageChief extends BasePage{
    private final By loginField = By.xpath("//input[@aria-label='Login']");
    private final By passwordField = By.xpath("//input[@aria-label='Password']");
    private final By signInButton = By.xpath("//button[contains(., 'Sign in')]");
    private final By authCodeInput = By.xpath("//input[@aria-label='Authentication code']");
    private final By sendCodeButton = By.xpath("//button[contains(., 'Send')]");


    public LoginPageChief(WebDriver webDriver, String url) {
        super(webDriver, url);
    }

    public LoginPageChief inputLogin(String login) {
        findElement(webDriver, loginField).sendKeys("chief_TEST_UI");
        return this;
    }

    public LoginPageChief inputPassword(String password) {
        findElement(webDriver, passwordField).sendKeys("132465798");
        return this;
    }

    public LoginPageChief clickOnSignInButton() {
        findElement(webDriver, signInButton).click();
        return this;
    }

    public LoginPageChief inputAuthCode(String chief2FaCode) {
        findElement(webDriver, authCodeInput).sendKeys(chief2FaCode);
        return this;
    }

    public MainPageChief clickOnSendCodeButton() {
        findElement(webDriver, sendCodeButton).click();
        return new MainPageChief(webDriver);
    }



}
