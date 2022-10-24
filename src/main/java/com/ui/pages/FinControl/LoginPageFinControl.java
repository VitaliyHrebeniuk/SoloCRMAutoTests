package com.ui.pages.FinControl;

import com.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPageFinControl extends BasePage{
    private final By loginField = By.xpath("//input[@aria-label='Login']");
    private final By passwordField = By.xpath("//input[@aria-label='Password']");
    private final By signInButton = By.xpath("//button[contains(., 'Sign in')]");
    private final By authCodeInput = By.xpath("//input[@aria-label='Authentication code']");
    private final By sendCodeButton = By.xpath("//button[contains(., 'Send')]");


    public LoginPageFinControl(WebDriver webDriver, String url) {
        super(webDriver, url);
    }

    public LoginPageFinControl inputLogin(String login) {
        findElement(webDriver, loginField).sendKeys("finControl_TEST_UI");
        return this;
    }

    public LoginPageFinControl inputPassword(String password) {
        findElement(webDriver, passwordField).sendKeys("132465798");
        return this;
    }

    public LoginPageFinControl clickOnSignInButton() {
        findElement(webDriver, signInButton).click();
        return this;
    }

    public LoginPageFinControl inputAuthCode(String finControl2FaCode) {
        findElement(webDriver, authCodeInput).sendKeys(finControl2FaCode);
        return this;
    }

    public MainPageFinControl clickOnSendCodeButton() {
        findElement(webDriver, sendCodeButton).click();
        return new MainPageFinControl(webDriver);
    }



}
