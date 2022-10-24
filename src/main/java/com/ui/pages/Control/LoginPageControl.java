package com.ui.pages.Control;

import com.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPageControl extends BasePage{
    private final By loginField = By.xpath("//input[@aria-label='Login']");
    private final By passwordField = By.xpath("//input[@aria-label='Password']");
    private final By signInButton = By.xpath("//button[contains(., 'Sign in')]");
    private final By authCodeInput = By.xpath("//input[@aria-label='Authentication code']");
    private final By sendCodeButton = By.xpath("//button[contains(., 'Send')]");


    public LoginPageControl(WebDriver webDriver, String url) {
        super(webDriver, url);
    }

    public LoginPageControl inputLogin(String login) {
        findElement(webDriver, loginField).sendKeys("control_TEST_UI");
        return this;
    }

    public LoginPageControl inputPassword(String password) {
        findElement(webDriver, passwordField).sendKeys("132465798");
        return this;
    }

    public LoginPageControl clickOnSignInButton() {
        findElement(webDriver, signInButton).click();
        return this;
    }

    public LoginPageControl inputAuthCode(String admin2FaCode) {
        findElement(webDriver, authCodeInput).sendKeys(admin2FaCode);
        return this;
    }

    public MainPageControl clickOnSendCodeButton() {
        findElement(webDriver, sendCodeButton).click();
        return new MainPageControl(webDriver);
    }



}
