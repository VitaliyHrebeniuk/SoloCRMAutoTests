package com.ui.pages.HeadControl;

import com.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPageHeadControl extends BasePage{
    private final By loginField = By.xpath("//input[@aria-label='Login']");
    private final By passwordField = By.xpath("//input[@aria-label='Password']");
    private final By signInButton = By.xpath("//button[contains(., 'Sign in')]");
    private final By authCodeInput = By.xpath("//input[@aria-label='Authentication code']");
    private final By sendCodeButton = By.xpath("//button[contains(., 'Send')]");


    public LoginPageHeadControl(WebDriver webDriver, String url) {
        super(webDriver, url);
    }

    public LoginPageHeadControl inputLogin(String login) {
        findElement(webDriver, loginField).sendKeys("head_control_TEST_UI");
        return this;
    }

    public LoginPageHeadControl inputPassword(String password) {
        findElement(webDriver, passwordField).sendKeys("132465798");
        return this;
    }

    public LoginPageHeadControl clickOnSignInButton() {
        findElement(webDriver, signInButton).click();
        return this;
    }

    public LoginPageHeadControl inputAuthCode(String headControl2FaCode) {
        findElement(webDriver, authCodeInput).sendKeys(headControl2FaCode);
        return this;
    }

    public MainPageHeadControl clickOnSendCodeButton() {
        findElement(webDriver, sendCodeButton).click();
        return new MainPageHeadControl(webDriver);
    }



}
