package com.ui.Jira;

import com.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Jira extends BasePage {
    private final By emailField = By.xpath("//input[@id='username']");

    private final By continueButton = By.id("login-submit");

    private final By passwordFild = By.id("password");

    private final By loginSubmit = By.id("login-submit");

    private final By commentFieldInTaskInput = By.xpath("//body/div[@id='jira-frontend']/div[1]/div[2]/div[3]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/span[1]/span[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/input[1]");
    private final By commentField = By.xpath("//body/div[@id='jira-frontend']/div[1]/div[2]/div[3]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/span[1]/span[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]");
    private final By sendCommentButton = By.xpath("//body/div[@id='jira-frontend']/div[1]/div[2]/div[3]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/span[1]/span[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/button[1]");

    public Jira(WebDriver webDriver, String url) {
        super(webDriver, url);
    }

    public Jira inputEmailField(String login) {
        findElement(webDriver, emailField).sendKeys("vitaliy.hrebeniuk.qa@gmail.com");
        return this;
    }

    public Jira clickOnContinueButton(){
        findElement(webDriver, continueButton).click();
        return this;
    }

    public Jira inputPassword(String password){
        findElement(webDriver, passwordFild).sendKeys("jackshwager3513355dD");
        return this;
    }

    public Jira clickOnEnterButton(){
        findElement(webDriver, loginSubmit).click();
        return this;
    }

    public Jira clickComment() throws InterruptedException {
        findElement(webDriver, commentFieldInTaskInput).click();
        Thread.sleep(5000);
        return this;
    }

    public Jira inputComment(){
        findElement(webDriver,commentField).sendKeys("Check Resluts on this page: http://5.45.127.254:8080/job/RegressionTests/");
        return this;
    }

    public Jira clickOnSendCommentButton(){
        findElement(webDriver, sendCommentButton).click();
        return this;
    }

    public Jira sleep() throws InterruptedException {
        Thread.sleep(5000);
        return this;
    }


}
