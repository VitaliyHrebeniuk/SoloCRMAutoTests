package com.ui.pages.Admin;

import com.ui.pages.Auditor.PaymentsListPageAuditor;
import com.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPageAdmin extends BasePage {
    private final By paymentsListButton = By.xpath("//a[@id='buying-payments_list']");
    private final By profileButton = By.id("profile_btn");
    private final By exitButton = By.id("exit_btn");
    private final By yesWarningButton = By.xpath("//div[contains(text(),'Yes')]");

    public MainPageAdmin(WebDriver webDriver) {
        super(webDriver);
    }

    public MainPageAdmin clickOnProfileButton() {
        findElement(webDriver, profileButton).click();
        return this;
    }

    public MainPageAdmin clickOnExitButton() {
        findElement(webDriver, exitButton).click();
        return this;
    }

    public MainPageAdmin clickOnYesWarningButton() {
        findElement(webDriver, yesWarningButton).click();
        return this;
    }


}
