package com.ui.pages.ManagerCreateDealFixZid.BuyingControlApproveDeal;

import com.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DealPageBControl extends BasePage {
    private final By revisionButton = By.xpath("//span[contains(text(),'revision')]");
    private final By profileButton = By.xpath("//button[@id='profile_btn']");
    private final By exitButton = By.xpath("//a[@id='exit_btn']");

    public DealPageBControl(WebDriver webDriver) {
        super(webDriver);
    }

    public DealPageBControl clickOnRevisionButton() {
        waitForElementClickable(webDriver,revisionButton).click();
        return this;
    }

    public DealPageBControl clickOnProfileButton() {
        waitForElementClickable(webDriver, profileButton).click();
        return this;
    }

    public DealPageBControl clickOnExitButton() {
        findElement(webDriver, exitButton).click();
        return this;
    }
}
