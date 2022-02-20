package com.ui.pages.ManagerCreateDealFixZid.ManagerCreateDeal;

import com.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class AddLinkPage extends BasePage {
    private final By selectPlaceInput = By.xpath("//input[@id='fix-zid-deal_place_type_id']");
    private final By costInput = By.xpath("//input[@id='fix-zid-cost']");
    private final By trafficVolumeInput = By.xpath("//input[@id='fix-zid-traffic_volume']");
    private final By cpmInput = By.xpath("//input[@id='fix-zid-cpm']");
    private final By trafficChannelInput = By.xpath("//input[@id='fix-zid-traffic_channel']");
    private final By labelInput = By.xpath("//input[@id='fix-zid-label']");
    private final By geoInput = By.xpath("//input[@id='fix-zid-country_id']");
    private final By linkPpInput = By.xpath("//input[@id='fix-zid-link']");
    private final By saveButton = By.xpath("//button[@id='fix-zid-save_place']");

    public AddLinkPage(WebDriver webDriver) {
        super(webDriver);
    }

    public AddLinkPage inputSelectPlace(String place) {
        findElement(webDriver, selectPlaceInput).sendKeys("adaptive_banner" + Keys.ENTER);
        return this;
    }

    public AddLinkPage inputCost(String cost) {
        findElement(webDriver, costInput).sendKeys("2");
        return this;
    }

    public AddLinkPage inputTrafficVolume(String trVolume) {
        findElement(webDriver, trafficVolumeInput).sendKeys("2");
        return this;
    }

    public AddLinkPage inputCPM(String cpm) {
        findElement(webDriver, cpmInput).sendKeys("2");
        return this;
    }

    public AddLinkPage inputTrafficChannel(String trChannel) {
        findElement(webDriver, trafficChannelInput).sendKeys("all" + Keys.ENTER);
        return this;
    }

    public AddLinkPage inputLabel(String label) {
        findElement(webDriver, labelInput).sendKeys("cyber" + Keys.ENTER);
        return this;
    }

    public AddLinkPage inputGEO(String geo) {
        findElement(webDriver, geoInput).sendKeys("Austria" + Keys.ENTER);
        return this;
    }

    public AddLinkPage inputLinkPP(String linkPP) {
        findElement(webDriver, linkPpInput)
                .sendKeys("http://refpa.top/L?tag=d_468749m_97c_&site=468749&ad=97&r=registration/");
        return this;
    }

    public AddZidCidPage clickOnSaveButton() {
        findElement(webDriver, saveButton).click();
        return new AddZidCidPage(webDriver);
    }
}
