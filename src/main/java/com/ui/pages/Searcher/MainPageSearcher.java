package com.ui.pages.Searcher;

import com.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPageSearcher extends BasePage {
    private final By paymentsListButton = By.xpath("//a[@id='buying-payments_list']");
    private final By profileButton = By.id("profile_btn");
    private final By exitButton = By.id("exit_btn");
    private final By yesWarningButton = By.xpath("//div[contains(text(),'Yes')]");

    public MainPageSearcher(WebDriver webDriver) {
        super(webDriver);
    }

    public MainPageSearcher clickOnProfileButton() {
        findElement(webDriver, profileButton).click();
        return this;
    }

    public MainPageSearcher clickOnExitButton() {
        findElement(webDriver, exitButton).click();
        return this;
    }

    public MainPageSearcher clickOnYesWarningButton() {
        findElement(webDriver, yesWarningButton).click();
        return this;
    }


}
