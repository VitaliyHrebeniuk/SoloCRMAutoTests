package com.ui.pages.FinControl;

import com.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPageFinControl extends BasePage {
    private final By paymentsListButton = By.xpath("//a[@id='buying-payments_list']");
    private final By profileButton = By.id("profile_btn");
    private final By exitButton = By.id("exit_btn");
    private final By yesWarningButton = By.xpath("//body/div[@id='app']/div[2]/div[1]/div[1]/div[2]/button[2]");

    public MainPageFinControl(WebDriver webDriver) {
        super(webDriver);
    }

    public MainPageFinControl clickOnProfileButton() {
        findElement(webDriver, profileButton).click();
        return this;
    }

    public MainPageFinControl clickOnExitButton() {
        findElement(webDriver, exitButton).click();
        return this;
    }

    public MainPageFinControl clickOnYesWarningButton() {
        findElement(webDriver, yesWarningButton).click();
        return this;
    }


}
