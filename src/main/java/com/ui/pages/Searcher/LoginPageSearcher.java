package com.ui.pages.Searcher;

import com.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPageSearcher extends BasePage{
    private final By loginField = By.xpath("//input[@aria-label='Login']");
    private final By passwordField = By.xpath("//input[@aria-label='Password']");
    private final By signInButton = By.xpath("//button[contains(., 'Sign in')]");
    private final By authCodeInput = By.xpath("//input[@aria-label='Authentication code']");
    private final By sendCodeButton = By.xpath("//button[contains(., 'Send')]");


    public LoginPageSearcher(WebDriver webDriver, String url) {
        super(webDriver, url);
    }

    public LoginPageSearcher inputLogin(String login) {
        findElement(webDriver, loginField).sendKeys("searcher_TEST_UI");
        return this;
    }

    public LoginPageSearcher inputPassword(String password) {
        findElement(webDriver, passwordField).sendKeys("132465798");
        return this;
    }

    public LoginPageSearcher clickOnSignInButton() {
        findElement(webDriver, signInButton).click();
        return this;
    }

    public LoginPageSearcher inputAuthCode(String searcher2FaCode) {
        findElement(webDriver, authCodeInput).sendKeys(searcher2FaCode);
        return this;
    }

    public MainPageSearcher clickOnSendCodeButton() {
        findElement(webDriver, sendCodeButton).click();
        return new MainPageSearcher(webDriver);
    }



}
