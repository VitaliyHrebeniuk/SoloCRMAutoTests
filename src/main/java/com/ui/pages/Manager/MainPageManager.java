package com.ui.pages.Manager;

import com.ui.pages.Admin.MainPageAdmin;
import com.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPageManager extends BasePage {
    private final By partnersButton = By.xpath("//button[contains(., 'Partners')]");
    private final By partnersListButton = By.xpath("//a[@id='buying-partners_list']");
    private final By dealsListButton = By.xpath("//a[@id='buying-deals_list']");
    private final By profileButton = By.id("profile_btn");
    private final By exitButton = By.id("exit_btn");
    private final By yesWarningButton = By.xpath("//body/div[@id='app']/div[2]/div[1]/div[1]/div[2]/button[2]");

    public MainPageManager(WebDriver webDriver) {
        super(webDriver);
    }

    public MainPageManager clickOnPartnersButton() {
        findElement(webDriver, partnersButton).click();
        return this;
    }

    public PartnersListPageManager clickOnPartnersListButton() {
        findElement(webDriver, partnersListButton).click();
        return new PartnersListPageManager(webDriver);
    }

    public DealsListPageManager clickOnDealsListButton() {
        findElement(webDriver, dealsListButton).click();
        return new DealsListPageManager(webDriver);
    }
    public MainPageManager clickOnProfileButton() {
        findElement(webDriver, profileButton).click();
        return this;
    }

    public MainPageManager clickOnExitButton() {
        findElement(webDriver, exitButton).click();
        return this;
    }

    public MainPageManager clickOnYesWarningButton() {
        findElement(webDriver, yesWarningButton).click();
        return this;
    }
}
