package com.ui.pages.BuyingControl;

import com.ui.pages.Admin.MainPageAdmin;
import com.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPageBControl extends BasePage {
    private final By partnersButton = By.xpath("//button[@id='menu-buying']");
    private final By dealsListButton = By.xpath("//a[@id='buying-deals_list']");
    private final By profileButton = By.id("profile_btn");
    private final By exitButton = By.id("exit_btn");
    private final By yesWarningButton = By.xpath("//body/div[@id='app']/div[2]/div[1]/div[1]/div[2]/button[2]");

    public MainPageBControl(WebDriver webDriver) {
        super(webDriver);
    }

    public MainPageBControl clickOnPartnersButton() {
        findElement(webDriver, partnersButton).click();
        return this;
    }

    public DealsListPageBControl clickOnDealsListButton() {
        findElement(webDriver, dealsListButton).click();
        return new DealsListPageBControl(webDriver);
    }
    public MainPageBControl clickOnProfileButton() {
        findElement(webDriver, profileButton).click();
        return this;
    }

    public MainPageBControl clickOnExitButton() {
        findElement(webDriver, exitButton).click();
        return this;
    }

    public MainPageBControl clickOnYesWarningButton() {
        findElement(webDriver, yesWarningButton).click();
        return this;
    }
}
