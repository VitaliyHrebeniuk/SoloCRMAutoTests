package com.ui.pages.ManagerCreateDealFixZid.TeamLeadApproveDeal;

import com.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPageTLead extends BasePage {
    private final By partnersButton = By.xpath("//button[@id='menu-buying']");
    private final By dealsListButton = By.xpath("//a[@id='buying-deals_list']");

    public MainPageTLead(WebDriver webDriver) {
        super(webDriver);
    }

    public MainPageTLead clickOnPartnersButton() {
        findElement(webDriver, partnersButton).click();
        return this;
    }

    public DealsListPageTLead clickOnDealsListButton() {
        findElement(webDriver, dealsListButton).click();
        return new DealsListPageTLead(webDriver);
    }
}
