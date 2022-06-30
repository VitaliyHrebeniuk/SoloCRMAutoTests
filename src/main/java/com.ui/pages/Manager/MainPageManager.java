package com.ui.pages.Manager;

import com.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPageManager extends BasePage {
    private final By partnersButton = By.xpath("//button[contains(., 'Partners')]");
    private final By partnersListButton = By.xpath("//a[@id='buying-partners_list']");

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
}
