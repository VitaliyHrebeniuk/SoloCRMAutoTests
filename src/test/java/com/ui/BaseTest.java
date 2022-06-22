package com.ui;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BaseTest{
    protected static WebDriver webDriver;
    public static final String baseURL = "https://beta.solo-crm.com/";
    public static final String apiURL = "https://beta-api.solo-crm.com/";

    @BeforeTest
    public void setUp() {
        webDriver = WebDriverManagerClass.getWebDriver();
    }


    @AfterTest
    public void shutDown() {
        webDriver.quit();
    }
}
