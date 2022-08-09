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
            case "chrome":
                /**
                 Перед тем как тестить локально разкоментируй строку!
                 **/
                WebDriverManager.chromedriver().setup();
                /**
                 Перед тем как запушить на сервер разкоментируй строку!тут настройки для серевера
                 **/
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setCapability("network.proxy.http", "http://5.45.127.254/");
                chromeOptions.setCapability("network.proxy.http_port", "9515");
                chromeOptions.setBinary("/usr/local/bin/chromedriver");
                chromeOptions.addArguments("--headless", "--disable-gpu", "--window-size=1024,768x24","--ignore-certificate-errors");
                chromeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
//                System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
                chromeOptions.addArguments("--no-sandbox", "--disable-gpu" ,"--disable-extensions" ,"--headless", "--window-size=1920,1200","--ignore-certificate-errors", "--silent", "--disable-dev-shm-usage", "--remote-debugging-port=9222");
                webDriver = new ChromeDriver(chromeOptions);

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
        String browser = "chrome";
        if (webDriver == null) {
            new WebDriverManagerClass(browser);
        }
        return webDriver;
    }
}
