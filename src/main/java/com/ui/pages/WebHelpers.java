package com.ui.pages;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.Augmenter;
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

//    public String captureScreen() {
//        String path;
//        WebDriver driver = new ChromeDriver();
//        try {
//            WebDriver webDriver = new Augmenter().augment(driver);
//            File source = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
//            path = "/files/screen.png" + source.getName();
//            FileUtils.copyFile(source, new File(path));
//        }
//        catch(IOException e) {
//            path = "Failed to capture screenshot: " + e.getMessage();
//        }
//        return path;
//    }
    public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws IOException {
    //Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    //Call getScreenshotAs method to create image file
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
    //Move image file to new destination
        File DestFile=new File(fileWithPath);
    //Copy file at destination
        FileUtils.copyFile(SrcFile, DestFile);
    }

    public void switchToNewFrame(WebDriver webDriver) {
        for(String winHandle : webDriver.getWindowHandles()){
            webDriver.switchTo().window(winHandle);
        }
    }
}
