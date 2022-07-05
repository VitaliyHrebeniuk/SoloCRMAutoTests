package com.ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.groovy.json.internal.Chr;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverManagerClass {
    private static WebDriver webDriver;

    private WebDriverManagerClass(String browser) {
        setWebDriver(browser);
    }

    private void setWebDriver(String browserName) {
        switch (browserName) {
            case "chrome":
                webDriver = WebDriverManager.chromedriver().create();
                webDriver.manage().window().maximize();
//                WebDriverManager.chromedriver().setup();
//                ChromeOptions options = new ChromeOptions();
                /**
                 Перед тем как запушить на сервер разкоментируй строку!тут настройки для серевера
                 **/
//                options.addArguments("--headless", "--window-size=1920,1200","--ignore-certificate-errors", "--silent");
//                webDriver = new ChromeDriver(options);

                break;
            case "ff":
                webDriver = WebDriverManager.firefoxdriver().create();
                webDriver.manage().window().maximize();
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
