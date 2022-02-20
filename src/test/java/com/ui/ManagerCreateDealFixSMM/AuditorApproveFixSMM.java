package com.ui.ManagerCreateDealFixSMM;

import com.ui.token2Fa.GenerateUserTokenWith2FaForAuditorUI;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;

public class AuditorApproveFixSMM {
    WebDriver driver;
    String auditorTokenWith2FA;
    RequestSpecification request = RestAssured.given();
    final String URL = "https://test-api.solo-crm.com/";
    private String auditor2FaCode;

    @BeforeClass
    public void setDriver() {
        GenerateUserTokenWith2FaForAuditorUI generateUserTokenWith2FaForAuditor = new GenerateUserTokenWith2FaForAuditorUI();
        this.auditorTokenWith2FA = generateUserTokenWith2FaForAuditor.set2faForAccount();
        this.auditor2FaCode = generateUserTokenWith2FaForAuditor.auditor2FaCode;

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test(priority = 4)
    public void auditorApprove(){
        // Login
        WebElement login = driver.findElement(By.cssSelector("[aria-label=Login]"));
        login.sendKeys("auditor_TEST_UI");
        WebElement password = driver.findElement(By.cssSelector("[aria-label=Password]"));
        password.sendKeys("132465798");
        WebElement signIn = driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/main/div/div/div/div/div/div/div[2]/div/div/form/div[3]/button/div"));
        signIn.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //Ввожу 6-ти значный код
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div[2]/form/div/div[2]/div[1]/div/input")).sendKeys(auditor2FaCode);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div[3]/button[2]")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        // Переход к платежам
        driver.findElement(By.xpath("//*[@id=\"menu-buying\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"buying-payments_list\"]/div[2]/div")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        // Аппрув платежа
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[39]/main/div/div[2]/div/div/div/div[1]/div[2]/div[2]/div/div[1]/div/div[2]/div/table/thead/tr[1]/th[1]/div/div/div/div/div")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[39]/main/div/div[2]/div/div/div/div[1]/div[2]/div[2]/div/div[1]/div/button/div/i")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        // Log out
        driver.findElement(By.xpath("//*[@id=\"profile_btn\"]/div")).click();
        driver.findElement(By.xpath("//*[@id=\"exit_btn\"]/div[2]"));
    }
    @AfterClass
    public void QuitDriver(){
        request
                .headers("token", auditorTokenWith2FA)
                .post(URL + "/security/status/disable/" + auditor2FaCode)
                .then()
                .assertThat()
                .statusCode(200);
        driver.quit();
    }
}
