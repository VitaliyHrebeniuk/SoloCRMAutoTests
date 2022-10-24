package com.ui.pages.FS;

import com.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPageFS extends BasePage{
    private final By loginField = By.xpath("//input[@aria-label='Login']");
    private final By passwordField = By.xpath("//input[@aria-label='Password']");
    private final By signInButton = By.xpath("//button[contains(., 'Sign in')]");
    private final By authCodeInput = By.xpath("//input[@aria-label='Authentication code']");
    private final By sendCodeButton = By.xpath("//button[contains(., 'Send')]");


    public LoginPageFS(WebDriver webDriver, String url) {
        super(webDriver, url);
    }

    public LoginPageFS inputLogin(String login) {
        findElement(webDriver, loginField).sendKeys("fs_TEST_UI");
        return this;
    }

    public LoginPageFS inputPassword(String password) {
        findElement(webDriver, passwordField).sendKeys("132465798");
        return this;
    }

    public LoginPageFS clickOnSignInButton() {
        findElement(webDriver, signInButton).click();
        return this;
    }

    public LoginPageFS inputAuthCode(String fs2FaCode) {
        findElement(webDriver, authCodeInput).sendKeys(fs2FaCode);
        return this;
    }

    public MainPageFS clickOnSendCodeButton() {
        findElement(webDriver, sendCodeButton).click();
        return new MainPageFS(webDriver);
    }



}
