package com.ui.pages.ManagerCreateDealFixZid.ManagerCreateDeal;

import com.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class DealPage extends BasePage {
    private final By siteOverviewBlock = By.xpath("//div[contains(., 'Site Overview')][@class='subheading']");
    private final By linkInput = By.xpath("//input[@id='cpi-link_search']");
    private final By addSiteLinkButton = By.xpath("//button[@id='fix_zid-attach_lead']");
    private final By sitePlacesField = By.xpath("//input[@id='fix_zid-search_site']");
    private final By addLinkButton = By.xpath("//button[@id='fix_zid-add_place']");
    private final By adad = By.xpath("//a/span[contains(text(),'http://www.nababet.com/')]");
//    private final By dealID = By.xpath("//h2[contains(., 'Deal ID')]");

    public DealPage(WebDriver webDriver) {
        super(webDriver);
    }

//    public DealPage dealID() {
//        findElement(webDriver, dealID).getText();
//        return dealID();
//    }

    public DealPage clickOnSiteOverviewBlock() {
        findElement(webDriver, siteOverviewBlock).click();
        return this;
    }

    public DealPage inputLink(String url) {
        findElement(webDriver, linkInput).sendKeys("http://football.ua");
        return this;
    }

    public DealPage clickOnAddSiteLinkButton() {
        findElement(webDriver, addSiteLinkButton).click();
        return this;
    }

    public DealPage clickOnSitePlaceField() {
        findElement(webDriver, sitePlacesField).click();
        findElement(webDriver, sitePlacesField).sendKeys("20578" + Keys.ENTER);
        return this;
    }

    public AddLinkPage clickOnAddLinkButton() {
        waitForElementClickable(webDriver, addLinkButton).click();
        return new AddLinkPage(webDriver);
    }
}
