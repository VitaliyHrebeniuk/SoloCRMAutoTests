package com.ui.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebHelpers {
    long timeOut = 15L;

    public WebElement findElement(WebDriver webDriver, By locator){
        return findElement(webDriver, locator, timeOut);
    }

    public WebElement findElement(WebDriver webDriver, By locator, Long timeOut) {
        return new WebDriverWait(webDriver, Duration.ofSeconds(timeOut))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public Boolean waitForInvisibility(WebDriver webDriver, By locator, Long timeOut) {
        return new WebDriverWait(webDriver, Duration.ofSeconds(timeOut))
                .until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public WebElement waitForElementClickable(WebDriver webDriver, By locator){
        return new WebDriverWait(webDriver, Duration.ofSeconds(timeOut))
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void scrollToElement(WebDriver webDriver, By locator){
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true)", locator);
    }

    public void unhide(WebDriver webDriver, WebElement locator) {
        String script = "arguments[0].style.opacity=1;"
                + "arguments[0].style['transform']='translate(0px, 0px) scale(1)';"
                + "arguments[0].style['MozTransform']='translate(0px, 0px) scale(1)';"
                + "arguments[0].style['WebkitTransform']='translate(0px, 0px) scale(1)';"
                + "arguments[0].style['msTransform']='translate(0px, 0px) scale(1)';"
                + "arguments[0].style['OTransform']='translate(0px, 0px) scale(1)';"
                + "return true;";
        ((JavascriptExecutor) webDriver).executeScript(script, locator);
    }

    public void switchToNewFrame(WebDriver webDriver) {
        for(String winHandle : webDriver.getWindowHandles()){
            webDriver.switchTo().window(winHandle);
        }
    }
}
