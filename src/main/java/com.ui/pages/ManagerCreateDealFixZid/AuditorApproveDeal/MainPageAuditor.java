package com.ui.pages.ManagerCreateDealFixZid.AuditorApproveDeal;

import com.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPageAuditor extends BasePage {
    private final By partnersButton = By.xpath("//button[@id='menu-buying']");
    private final By paymentsListButton = By.xpath("//div[contains(text(), 'Payments list')]");

    public MainPageAuditor(WebDriver webDriver) {
        super(webDriver);
    }

    public MainPageAuditor clickOnPartnersButton() {
        waitForElementClickable(webDriver, partnersButton).click();
        return this;
    }

    public PaymentsListPageAuditor clickOnPaymentsListButton() {
        findElement(webDriver, paymentsListButton).click();
        return new PaymentsListPageAuditor(webDriver);
    }

}
