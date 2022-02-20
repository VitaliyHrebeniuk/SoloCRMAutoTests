package com.ui.ManagerCreateDealFixSMM;

import com.ui.token2Fa.GenerateUserTokenWith2FaForManagerUI;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;

public class ManagerApproveFixSMM {
    WebDriver driver;
    String managerTokenWith2FA;
    RequestSpecification request = RestAssured.given();
    final String URL = "https://test-api.solo-crm.com/";
    private String manager2FaCode;

    @BeforeClass
    public void setDriver() {
        GenerateUserTokenWith2FaForManagerUI generateUserTokenWith2FaForManager = new GenerateUserTokenWith2FaForManagerUI();
        this.managerTokenWith2FA = generateUserTokenWith2FaForManager.set2faForAccount();
        this.manager2FaCode = generateUserTokenWith2FaForManager.manager2FaCode;

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(priority = 2)
    public void addPaymentManager(){
        // Login
        driver.get("https://test.solo-crm.com/#/login");
        WebElement login = driver.findElement(By.cssSelector("[aria-label=Login]"));
        login.sendKeys("manager_TEST_UI");
        WebElement password = driver.findElement(By.cssSelector("[aria-label=Password]"));
        password.sendKeys("132465798");
        WebElement signIn = driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/main/div/div/div/div/div/div/div[2]/div/div/form/div[3]/button/div"));
        signIn.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //Ввожу 6-ти значный код
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div[2]/form/div/div[2]/div[1]/div/input")).sendKeys(manager2FaCode);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div[3]/button[2]")).click();
        // Переход к сделке
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"menu-buying\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"buying-deals_list\"]/div[2]/div")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[25]/main/div/div[2]/div/div/div/div/div/div[2]/div/div[1]/div/div[2]/div/table/thead/tr[1]/th[5]")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[25]/main/div/div[2]/div/div/div/div/div/div[2]/div/div[1]/div/div[2]/div/table/thead/tr[1]/th[5]")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[25]/main/div/div[2]/div/div/div/div/div/div[2]/div/div[1]/div/div[2]/div/table/tbody/tr[1]/td[13]/a/div/i"));
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        // Deal Payments
        // New Contract
        driver.findElement(By.xpath("//*[@id=\"64050\"]/div/div/div/div[4]/div/ul/li/div[1]/div[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"64050\"]/div/div/div/div[4]/div/ul/li/div[2]/div/div/div/div[1]/div[1]/button/div")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[18]/div/div/div[2]/form/div/div[1]/div/div[2]/div[1]/div/input")).sendKeys("Contract name");
        driver.findElement(By.xpath("//*[@id=\\\"app\\\"]/div[18]/div/div/div[2]/form/div/div[2]/div[1]/div[2]/div[1]/div/input")).sendKeys("2022-01-01" + Keys.ENTER);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[20]/div/div/div[2]/form/div/div[3]/div[1]/div[2]/div[1]/div/input")).sendKeys("2022-01-31" + Keys.ENTER);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[20]/div/div/div[2]/div[2]/button/div")).sendKeys("C:\\Users\\aberz\\Downloads\\contract");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[20]/div/div/div[3]/button[2]/div")).click();
        // New Payment
        WebElement newPayment = driver.findElement(By.xpath("//*[@id=\"add-payment\"]/div"));
        newPayment.click();
        WebElement paymentStartDate = driver.findElement(By.id("payment-start_date"));
        paymentStartDate.sendKeys("2022-01-01" + Keys.ENTER);
        WebElement paymentEndDate = driver.findElement(By.id("payment-end_date"));
        paymentEndDate.sendKeys("2022-01-31");
        WebElement paymentTarget = driver.findElement(By.id("payment-payment_target_id"));
        paymentTarget.sendKeys("1x" + Keys.ENTER);
        WebElement paymentType = driver.findElement(By.id("payment-type"));
        paymentType.sendKeys("prepaid" + Keys.ENTER);
        WebElement paymentWallet = driver.findElement(By.id("payment-wallet_id"));
        paymentWallet.sendKeys("WMZ" + Keys.ENTER);
        WebElement paymentCost = driver.findElement(By.id("payment-summary"));
        paymentCost.sendKeys("100");
        WebElement paymentContinue = driver.findElement(By.id("payment-continue"));
        paymentContinue.click();
        WebElement cost = driver.findElement(By.cssSelector("[aria-label=Cost]"));
        cost.sendKeys("100");
        WebElement savePayment = driver.findElement(By.xpath("//*[@id=\"payment-save\"]/div"));
        savePayment.click();
        WebElement approvePayment = driver.findElement(By.xpath("//*[@id=\"payment-positive_status\"]/div/i"));
        approvePayment.click();
        // Log Out
        driver.findElement(By.xpath("//*[@id=\"profile_btn\"]/div")).click();
        driver.findElement(By.xpath("//*[@id=\"exit_btn\"]/div[2]")).click();
    }
    @AfterClass
    public void QuitDriver(){
        request
                .headers("token", managerTokenWith2FA)
                .post(URL + "security/status/disable/" + manager2FaCode)
                .then()
                .assertThat()
                .statusCode(200);
        driver.quit();
    }

}
