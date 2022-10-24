package com.ui.pages.CM;

import com.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPageCM extends BasePage{
    private final By loginField = By.xpath("//input[@aria-label='Login']");
    private final By passwordField = By.xpath("//input[@aria-label='Password']");
    private final By signInButton = By.xpath("//button[contains(., 'Sign in')]");
    private final By authCodeInput = By.xpath("//input[@aria-label='Authentication code']");
    private final By sendCodeButton = By.xpath("//button[contains(., 'Send')]");


    public LoginPageCM(WebDriver webDriver, String url) {
        super(webDriver, url);
    }

    public LoginPageCM inputLogin(String login) {
        findElement(webDriver, loginField).sendKeys("cm_TEST_UI");
        return this;
    }

    public LoginPageCM inputPassword(String password) {
        findElement(webDriver, passwordField).sendKeys("132465798");
        return this;
    }

    public LoginPageCM clickOnSignInButton() {
        findElement(webDriver, signInButton).click();
        return this;
    }

    public LoginPageCM inputAuthCode(String CM2FaCode) {
        findElement(webDriver, authCodeInput).sendKeys(CM2FaCode);
        return this;
    }

    public MainPageCM clickOnSendCodeButton() {
        findElement(webDriver, sendCodeButton).click();
        return new MainPageCM(webDriver);
    }



}
