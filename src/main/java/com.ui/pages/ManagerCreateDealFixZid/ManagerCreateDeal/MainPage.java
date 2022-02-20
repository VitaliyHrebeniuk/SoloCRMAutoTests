package com.ui.pages.ManagerCreateDealFixZid.ManagerCreateDeal;

import com.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {
    private final By partnersButton = By.xpath("//button[contains(., 'Partners')]");
    private final By partnersListButton = By.xpath("//a[@id='buying-partners_list']");

    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    public MainPage clickOnPartnersButton() {
        findElement(webDriver, partnersButton).click();
        return this;
    }

    public PartnersListPage clickOnPartnersListButton() {
        findElement(webDriver, partnersListButton).click();
        return new PartnersListPage(webDriver);
    }
}
