package com.ui.pages.RetentionTeamLead;

import com.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPageRetentionTeamLead extends BasePage {
    private final By paymentsListButton = By.xpath("//a[@id='buying-payments_list']");
    private final By profileButton = By.id("profile_btn");
    private final By exitButton = By.id("exit_btn");
    private final By yesWarningButton = By.xpath("//body/div[@id='app']/div[2]/div[1]/div[1]/div[2]/button[2]");

    public MainPageRetentionTeamLead(WebDriver webDriver) {
        super(webDriver);
    }

    public MainPageRetentionTeamLead clickOnProfileButton() {
        findElement(webDriver, profileButton).click();
        return this;
    }

    public MainPageRetentionTeamLead clickOnExitButton() {
        findElement(webDriver, exitButton).click();
        return this;
    }

    public MainPageRetentionTeamLead clickOnYesWarningButton() {
        findElement(webDriver, yesWarningButton).click();
        return this;
    }


}
