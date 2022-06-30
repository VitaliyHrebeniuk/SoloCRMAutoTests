package com.ui.pages.ManagerCreateDealFixZid.BuyingControlApproveDeal;

import com.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DealPageBControl extends BasePage {
    private final By revisionButton = By.xpath("//button[@class='v-btn v-btn--small theme--light blue darken-2 btn-item_revision']");
    private final By profileButton = By.xpath("//button[@id='profile_btn']");
    private final By exitButton = By.xpath("//a[@id='exit_btn']");
    private final By confirmExit = By.xpath("//div[contains(text(),'Yes')]");

    public DealPageBControl(WebDriver webDriver) {
        super(webDriver);
    }

    public DealPageBControl clickOnRevisionButton() {
        switchToNewFrame(webDriver);
        findElement(webDriver,revisionButton,1000L).click();
        return this;
    }

    public DealPageBControl clickOnProfileButton() {
        waitForElementClickable(webDriver, profileButton).click();
        return this;
    }

    public DealPageBControl clickOnExitButton() {
        findElement(webDriver, exitButton).click();
        findElement(webDriver, confirmExit).click();
        return this;
    }
}
