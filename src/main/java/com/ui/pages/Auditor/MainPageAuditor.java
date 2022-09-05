package com.ui.pages.Auditor;

import com.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPageAuditor extends BasePage {
    private final By paymentsListButton = By.xpath("//a[@id='buying-payments_list']");

    public MainPageAuditor(WebDriver webDriver) {
        super(webDriver);
    }

    public PaymentsListPageAuditor clickOnPaymentsListButton() {
        findElement(webDriver, paymentsListButton).click();
        return new PaymentsListPageAuditor(webDriver);
    }

}
