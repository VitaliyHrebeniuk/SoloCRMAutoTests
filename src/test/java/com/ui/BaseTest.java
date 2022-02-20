package com.ui;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest{
    protected static WebDriver webDriver;

    @BeforeClass
    public void setUp() {
        webDriver = WebDriverManagerClass.getWebDriver();
    }


    @AfterClass
    public void shutDown() {
        webDriver.quit();
    }
}
