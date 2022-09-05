package com.ui.pages.BuyingControl;

import com.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPageBControl extends BasePage {
    private final By partnersButton = By.xpath("//button[@id='menu-buying']");
    private final By dealsListButton = By.xpath("//a[@id='buying-deals_list']");

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
}
