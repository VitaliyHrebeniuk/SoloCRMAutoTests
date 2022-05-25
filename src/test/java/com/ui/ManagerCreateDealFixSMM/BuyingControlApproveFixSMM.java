package com.ui.ManagerCreateDealFixSMM;

import com.ui.token2Fa.GenerateUserTokenWith2FaForBuyingControlUI;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;

public class BuyingControlApproveFixSMM {
    WebDriver driver;
    String buyingControlTokenWith2FA;
    RequestSpecification request = RestAssured.given();
    final String URL = "https://beta-api.solo-crm.com/";
    private String buyingControl2FaCode;

    @BeforeClass
    public void setDriver() {
        GenerateUserTokenWith2FaForBuyingControlUI generateUserTokenWith2FaForBuyingControlUI = new GenerateUserTokenWith2FaForBuyingControlUI();
        this.buyingControlTokenWith2FA = generateUserTokenWith2FaForBuyingControlUI.set2faForAccount();
        this.buyingControl2FaCode = generateUserTokenWith2FaForBuyingControlUI.buyingControl2FaCode;

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test(priority = 1)
    public void buyingControlApprove(){
        // Login
        WebElement login = driver.findElement(By.cssSelector("[aria-label=Login]"));
        login.sendKeys("buying_control_TEST_UI");
        WebElement password = driver.findElement(By.cssSelector("[aria-label=Password]"));
        password.sendKeys("132465798");
        WebElement signIn = driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/main/div/div/div/div/div/div/div[2]/div/div/form/div[3]/button/div"));
        signIn.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //Ввожу 6-ти значный код
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div[2]/form/div/div[2]/div[1]/div/input")).sendKeys(buyingControl2FaCode);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div[3]/button[2]")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        // Переход к сделкам
        driver.findElement(By.xpath("//*[@id=\"menu-buying\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"buying-deals_list\"]/div[2]/div")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        // Переход к сделке и аппрув
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[12]/main/div/div[2]/div/div/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/table/tbody/tr[1]/td[12]/a/div/i")).click();
        driver.findElement(By.xpath("//*[@id=\"64069\"]/div/div/div/div[1]/div[2]/div[1]/div[2]/div[1]/button[1]/div")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        // Logout
        driver.findElement(By.xpath("//*[@id=\"profile_btn\"]/div")).click();
        driver.findElement(By.xpath("//*[@id=\"exit_btn\"]/div[2]"));
    }
    @AfterClass
    public void QuitDriver(){
        request
                .headers("token", buyingControlTokenWith2FA)
                .post(URL + "security/status/disable/" + buyingControl2FaCode)
                .then()
                .assertThat()
                .statusCode(200);
        driver.quit();
    }
}
