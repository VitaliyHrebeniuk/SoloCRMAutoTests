package com.ui.pages.ManagerCreateDealFixZid.ManagerCreateDeal;

import com.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoutPage extends BasePage {
    private final By saveDealButton = By.xpath("//button//i[contains(., 'save')]");
    private final By sendOnReviewButton = By.xpath("//button//span[contains(., 'send on review')]");
    private final By profileButton = By.xpath("//button[@id='profile_btn']");
    private final By exitButton = By.xpath("//a[@id='exit_btn']");

    public LogoutPage(WebDriver webDriver) {
        super(webDriver);
    }

    public LogoutPage clickOnSaveDealButton() {
        findElement(webDriver, saveDealButton).click();
        return this;
    }

    public LogoutPage clickOnReviewButton() {
        findElement(webDriver, sendOnReviewButton).click();
        return this;
    }

    public LogoutPage clickOnProfileButton() {
        findElement(webDriver, profileButton).click();
        return this;
    }

    public LogoutPage clickOnExitButton() {
        findElement(webDriver, exitButton).click();
        return this;
    }
}
