package com.ui;

import com.ui.token2Fa.GenerateUserTokenWith2FaForManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;


public class ManagerCreateDealFixSMM {
    WebDriver driver;
    private String user2FaCode;
    RequestSpecification request = RestAssured.given();
    private String managerTokenWith2FA;
    private String dealID;

    @BeforeClass
    public void setDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        GenerateUserTokenWith2FaForManager generateUserTokenWith2FaForManager = new GenerateUserTokenWith2FaForManager();
        //generateUserTokenWith2FaForManager.set2faForAccount();
        this.user2FaCode = generateUserTokenWith2FaForManager.get2FaCode();
    }
    @Test
    public void createFixSMM(){
        // Login
        driver.get("https://test.solo-crm.com/#/login");
        WebElement login = driver.findElement(By.cssSelector("[aria-label=Login"));
        login.sendKeys("manager_TEST_API");
        WebElement password = driver.findElement(By.cssSelector("[aria-label=Password]"));
        password.sendKeys("132465798");
        WebElement signIn = driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/main/div/div/div/div/div/div/div[2]/div/div/form/div[3]/button/div"));
        signIn.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebElement autCode = driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div[2]/form/div/div[2]/div[1]/div/input"));
        autCode.sendKeys(user2FaCode);
        WebElement send2FA = driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div[3]/button[2]/div"));
        send2FA.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        // Закрываю окно напоминания 2FA (убрать когда починят)
        WebElement closeNotification2FA = driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div[3]/button/div"));
        closeNotification2FA.click();
        // Переход к партнерам
        WebElement partnersMenu = driver.findElement(By.xpath("//*[@id=\"menu-buying\"]/div"));
        partnersMenu.click();
        WebElement partnersList = driver.findElement(By.xpath("//*[@id=\"buying-partners_list\"]/div[2]/div"));
        partnersList.click();
        WebElement partnersID = driver.findElement(By.xpath("//*[@id=\"app\"]/div[82]/main/div/div[2]/div/div/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div[1]/div/div[2]/div[1]/div[1]/input"));
        partnersID.sendKeys("5445");
        // Создание сделки
        WebElement plusDeal = driver.findElement(By.xpath("//*[@id=\"partner-id_5445\"]/div/i"));
        plusDeal.click();
        WebElement fixSMM = driver.findElement(By.xpath("//*[@id=\"fix_zid_partner-id_5445\"]/div"));
        fixSMM.click();
    }
//    @AfterTest
//    public void afterGetProfile(){
//        request
//                .headers("token", managerTokenWith2FA)
//                .post(URL + "/security/status/disable/" + manager2FaCode)
//                .then()
//                .assertThat()
//                .statusCode(200);
//    }
}