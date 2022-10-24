package com.ui.pages.Spamer;

import com.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPageSpamer extends BasePage{
    private final By loginField = By.xpath("//input[@aria-label='Login']");
    private final By passwordField = By.xpath("//input[@aria-label='Password']");
    private final By signInButton = By.xpath("//button[contains(., 'Sign in')]");
    private final By authCodeInput = By.xpath("//input[@aria-label='Authentication code']");
    private final By sendCodeButton = By.xpath("//button[contains(., 'Send')]");


    public LoginPageSpamer(WebDriver webDriver, String url) {
        super(webDriver, url);
    }

    public LoginPageSpamer inputLogin(String login) {
        findElement(webDriver, loginField).sendKeys("spamer_TEST_UI");
        return this;
    }

    public LoginPageSpamer inputPassword(String password) {
        findElement(webDriver, passwordField).sendKeys("132465798");
        return this;
    }

    public LoginPageSpamer clickOnSignInButton() {
        findElement(webDriver, signInButton).click();
        return this;
    }

    public LoginPageSpamer inputAuthCode(String spamer2FaCode) {
        findElement(webDriver, authCodeInput).sendKeys(spamer2FaCode);
        return this;
    }

    public MainPageSpamer clickOnSendCodeButton() {
        findElement(webDriver, sendCodeButton).click();
        return new MainPageSpamer(webDriver);
    }



}
