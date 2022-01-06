package com.ui;

import com.ui.token2Fa.GenerateUserTokenWith2FaForAdmin;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class ManagerCreateDealFixSMM {
    WebDriver driver;
    private String user2FaCode;

    @BeforeClass
    public void setDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        GenerateUserTokenWith2FaForAdmin generateUserTokenWith2FaForAdmin = new GenerateUserTokenWith2FaForAdmin();
        this.user2FaCode = generateUserTokenWith2FaForAdmin.get2FaCode();
    }
    @Test
    public void createFixSMM(){
        // Login
        driver.get("https://test.solo-crm.com/#/login");
        WebElement login = driver.findElement(By.cssSelector("[aria-label=Login"));
        login.sendKeys("aleksandr_qa");
        WebElement password = driver.findElement(By.cssSelector("[aria-label=Password]"));
        password.sendKeys("13581358");
        WebElement signIn = driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/main/div/div/div/div/div/div/div[2]/div/div/form/div[3]/button/div"));
        signIn.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebElement autCode = driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div[2]/form/div/div[2]/div[1]/div/input"));
        autCode.sendKeys(user2FaCode);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

}