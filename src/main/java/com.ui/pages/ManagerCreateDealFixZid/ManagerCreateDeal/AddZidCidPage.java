package com.ui.pages.ManagerCreateDealFixZid.ManagerCreateDeal;

import com.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class AddZidCidPage extends BasePage {
    int a = (int) (Math.random() * 100000);
    String b = String.valueOf(a);
    private final By addZidCidButton = By.xpath("//input[@id='fix-zid-cpm']");
    private final By zidCidValueInput = By.xpath("//input[@id='fix_zid-zid_solo']");
    private final By selectPlaceInput = By.xpath("//input[@id='fix_zid-zid_deal_place_type_id']");
    private final By labelInput = By.xpath("//input[@id='fix_zid-zid_label']");
    private final By trafficChannelInput = By.xpath("//input[@id='fix_zid-zid_traffic_channel']");
    private final By cpmInput = By.xpath("//input[@id='fix-zid-cpm']");
    private final By saveButton = By.xpath("//button[@id='fix_zid-zid_save']");

    public AddZidCidPage(WebDriver webDriver) {
        super(webDriver);
    }

    public AddZidCidPage clickOnAddZidCidButton() {
        findElement(webDriver, addZidCidButton).click();
        return this;
    }

    public AddZidCidPage inputZidCidValue(String value) {
        findElement(webDriver, zidCidValueInput).sendKeys(b);
        return this;
    }

    public AddZidCidPage inputSelectPlace(String place) {
        findElement(webDriver, selectPlaceInput).sendKeys("adaptive_banner" + Keys.ENTER);
        return this;
    }

    public AddZidCidPage inputLabel(String label) {
        findElement(webDriver, labelInput).sendKeys("cyber" + Keys.ENTER);
        return this;
    }

    public AddZidCidPage inputTrafficChannel(String trChannel) {
        findElement(webDriver, trafficChannelInput).sendKeys("all" + Keys.ENTER);
        return this;
    }

    public AddZidCidPage inputCPM(String cpm) {
        findElement(webDriver, cpmInput).sendKeys("2");
        return this;
    }

    public LogoutPage clickOnSaveButton() {
        findElement(webDriver, saveButton).click();
        return new LogoutPage(webDriver);
    }
}
