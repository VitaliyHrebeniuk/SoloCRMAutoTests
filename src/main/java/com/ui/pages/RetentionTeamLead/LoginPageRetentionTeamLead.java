package com.ui.pages.RetentionTeamLead;

import com.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPageRetentionTeamLead extends BasePage{
    private final By loginField = By.xpath("//input[@aria-label='Login']");
    private final By passwordField = By.xpath("//input[@aria-label='Password']");
    private final By signInButton = By.xpath("//button[contains(., 'Sign in')]");
    private final By authCodeInput = By.xpath("//input[@aria-label='Authentication code']");
    private final By sendCodeButton = By.xpath("//button[contains(., 'Send')]");


    public LoginPageRetentionTeamLead(WebDriver webDriver, String url) {
        super(webDriver, url);
    }

    public LoginPageRetentionTeamLead inputLogin(String login) {
        findElement(webDriver, loginField).sendKeys("retention_team_lead_TEST_UI");
        return this;
    }

    public LoginPageRetentionTeamLead inputPassword(String password) {
        findElement(webDriver, passwordField).sendKeys("132465798");
        return this;
    }

    public LoginPageRetentionTeamLead clickOnSignInButton() {
        findElement(webDriver, signInButton).click();
        return this;
    }

    public LoginPageRetentionTeamLead inputAuthCode(String retentionTeamLead2FaCode) {
        findElement(webDriver, authCodeInput).sendKeys(retentionTeamLead2FaCode);
        return this;
    }

    public MainPageRetentionTeamLead clickOnSendCodeButton() {
        findElement(webDriver, sendCodeButton).click();
        return new MainPageRetentionTeamLead(webDriver);
    }



}
