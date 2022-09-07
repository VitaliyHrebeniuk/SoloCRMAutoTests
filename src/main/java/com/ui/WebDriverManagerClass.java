package com.ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Collections;

public class WebDriverManagerClass {
    private static WebDriver webDriver;

    private WebDriverManagerClass(String browser) {
        setWebDriver(browser);
    }

    private void setWebDriver(String browserName) {
        switch (browserName) {
            case "google-chrome":
                /**
                 Перед тем как тестить локально разкоментируй строку!
                 **/
                WebDriverManager.chromedriver().setup();
                /**
                 Перед тем как запушить на сервер разкоментируй строку!тут настройки для серевера
                 **/
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
                chromeOptions.addArguments("--disable-extensions" ,
                         "--start-maximized", "--ignore-certificate-errors", "--silent",
                        "--disable-dev-shm-usage", "--remote-debugging-port=9222", "--window-size=1920,1080");
//                "--headless","--no-sandbox""--disable-gpu"
                webDriver = new ChromeDriver(chromeOptions);
                webDriver.manage().window().maximize();

                break;
            case "ff":
                webDriver = WebDriverManager.firefoxdriver().create();
                break;
            default:
                throw new RuntimeException("Incorrect browser name");
        }
    }

    public static WebDriver getWebDriver() {
//        String browser = System.getProperty("browser");
        String browser = "google-chrome";
        if (webDriver == null) {
            new WebDriverManagerClass(browser);
        }
        return webDriver;
    }
}
