package com.ui.pages.ManagerCreateDealFixZid.ManagerApproveDeal;

import com.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPageM extends BasePage {
    private final By partnersButton = By.xpath("//button[@id='menu-buying']");
    private final By dealsListButton = By.xpath("//a[@id='buying-deals_list']");

    public MainPageM(WebDriver webDriver) {
        super(webDriver);
    }
    
    public MainPageM clickOnPartnersButton() {
        findElement(webDriver, partnersButton).click();
        return this;
    }

    public DealsListPageM clickOnDealsListButton() {
        findElement(webDriver, dealsListButton).click();
        return new DealsListPageM(webDriver);
    }
}
