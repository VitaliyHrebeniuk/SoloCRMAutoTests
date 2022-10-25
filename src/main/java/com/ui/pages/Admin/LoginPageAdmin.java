package com.ui.pages.Admin;

import com.ui.pages.BasePage;
import com.ui.pages.Manager.DealPageB2B;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class LoginPageAdmin extends BasePage{
    private final By loginField = By.xpath("//input[@aria-label='Login']");
    private final By passwordField = By.xpath("//input[@aria-label='Password']");
    private final By signInButton = By.xpath("//button[contains(., 'Sign in')]");
    private final By authCodeInput = By.xpath("//input[@aria-label='Authentication code']");
    private final By sendCodeButton = By.xpath("//button[contains(., 'Send')]");
    private final By errorLoginWindow = By.xpath
            ("//div[@class='vue-notification-template vue-notification error'][contains(., 'Login does not exist')]");
    private final By errorPasswordWindow = By.xpath
            ("//div[@class='vue-notification-template vue-notification error'][contains(., 'Password is wrong')]");
    private final By errorAuthCodeWindow = By.xpath
            ("//div[@class='vue-notification-template vue-notification error'][contains(., 'Wrong code')]");


    public LoginPageAdmin(WebDriver webDriver, String url) {
        super(webDriver, url);
    }

    public LoginPageAdmin inputLogin(String login) {
        findElement(webDriver, loginField).sendKeys("admin_TEST_UI");
        return this;
    }

    public LoginPageAdmin inputPassword(String password) {
        findElement(webDriver, passwordField).sendKeys("132465798");
        return this;
    }

    public LoginPageAdmin clickOnSignInButton() {
        findElement(webDriver, signInButton).click();
        return this;
    }

    public LoginPageAdmin inputAuthCode(String admin2FaCode) {
        findElement(webDriver, authCodeInput).sendKeys(admin2FaCode);
        return this;
    }

    public MainPageAdmin clickOnSendCodeButton() {
        findElement(webDriver, sendCodeButton).click();
        return new MainPageAdmin(webDriver);
    }

    public LoginPageAdmin inputIncorrectLogin(String login) {
        findElement(webDriver, loginField).sendKeys("dadadid");
        return this;
    }
    public LoginPageAdmin assertLoginError() {
        Assert.assertEquals(waitForElementClickable(webDriver, errorLoginWindow).getText(),"Error\nLogin does not exists");
        return this;
    }

    public LoginPageAdmin inputIncorrectPassword(String password) {
        findElement(webDriver, passwordField).sendKeys("132465798");
        return this;
    }
    public LoginPageAdmin assertPasswordError() {
        Assert.assertEquals(waitForElementClickable(webDriver, errorPasswordWindow).getText(),"Error\nPassword is wrong");
        return this;
    }

    public LoginPageAdmin inputIncorrectAuthCode(String admin2FaCode) {
        findElement(webDriver, authCodeInput).sendKeys("12345");
        return this;
    }
    public LoginPageAdmin assertAuthCodeError() {
        Assert.assertEquals(waitForElementClickable(webDriver, errorLoginWindow).getText(),"Error\nWrong code");
        return this;
    }
}
