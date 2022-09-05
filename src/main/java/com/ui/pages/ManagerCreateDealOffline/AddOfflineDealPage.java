package com.ui.pages.ManagerCreateDealOffline;

import com.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class AddOfflineDealPage extends BasePage {
    private final By countryInput = By.xpath("//input[@aria-label='Country*']");
    private final By typesInput = By.xpath("//input[@aria-label='Types*']");
    private final By saveButton = By.xpath("//i[contains(text(),'save')]");

    public AddOfflineDealPage(WebDriver webDriver) {
        super(webDriver);
    }

    public AddOfflineDealPage inputCountry(String country) {
        waitForElementClickable(webDriver, countryInput).sendKeys("Uganda" + Keys.ENTER);
        return this;
    }

    public AddOfflineDealPage inputTypes(String types) {
        findElement(webDriver, typesInput).sendKeys("Print" + Keys.ENTER);
        return this;
    }

    public DealPageOffline clickOnSaveButton() {
        findElement(webDriver, saveButton).click();
        return new DealPageOffline(webDriver);
    }

}
