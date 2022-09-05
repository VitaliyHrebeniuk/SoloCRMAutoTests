package com.ui.pages;

import org.openqa.selenium.WebDriver;

public abstract class BasePage extends WebHelpers {
    public WebDriver webDriver;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public BasePage(WebDriver webDriver, String url) {
        webDriver.get(url);
        this.webDriver = webDriver;
    }
}
