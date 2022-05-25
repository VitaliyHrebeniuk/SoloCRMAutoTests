package com.ui.ManagerCreateDealFixSMM;

import com.ui.pages.BaseURL;
import com.ui.token2Fa.GenerateUserTokenWith2FaForManagerUI;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;

public class ManagerCreateDealFixSMM {
    WebDriver driver;
    WebDriverWait wait;
    String managerTokenWith2FA;
    RequestSpecification request = RestAssured.given();
    final String URL = "https://test-api.solo-crm.com/";
    private String manager2FaCode;
    BaseURL baseURL = new BaseURL();
    final String bURL = baseURL.baseURL;

    @BeforeClass
    public void setDriver() {
        GenerateUserTokenWith2FaForManagerUI generateUserTokenWith2FaForManager = new GenerateUserTokenWith2FaForManagerUI();
        this.managerTokenWith2FA = generateUserTokenWith2FaForManager.set2faForAccount();
        this.manager2FaCode = generateUserTokenWith2FaForManager.manager2FaCode;

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
    }
    @Test(priority = 0)
    public void createFixSMM(){
        // Login
        driver.get(bURL);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebElement login = driver.findElement(By.cssSelector("[aria-label=Login]"));
        login.sendKeys("manager_TEST_UI");
        WebElement password = driver.findElement(By.cssSelector("[aria-label=Password]"));
        password.sendKeys("132465798");
        WebElement signIn = driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/main/div/div/div/div/div/div/div[2]/div/div/form/div[3]/button/div"));
        signIn.click();
        //Ввожу 6-ти значный код
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div[2]/form/div/div[2]/div[1]/div/input")).sendKeys(manager2FaCode);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div[3]/button[2]")).click();
        // Переход к партнерам
        WebElement partnersMenu = driver.findElement(By.xpath("//*[@id=\"menu-buying\"]"));
        wait.until(ExpectedConditions.invisibilityOfElementLocated((By) partnersMenu));
        partnersMenu.click();
        WebElement partnersList = driver.findElement(By.xpath("//*[@id=\"buying-partners_list\"]/div[2]/div"));
        partnersList.click();
        WebElement partnerID = driver.findElement(By.className("[aria-label=\"Partner id\"]"));
        wait.until(ExpectedConditions.invisibilityOfElementLocated((By) partnerID));
        partnerID.sendKeys("5445");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        // Создание сделки
        WebElement plusDeal = driver.findElement(By.xpath("//*[@id=\"partner-id_5445\"]/div/i"));
        plusDeal.click();
        WebElement fixSMM = driver.findElement(By.xpath("//*[@id=\"fix_smm_partner-id_5445\"]"));
        fixSMM.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        // Добавление сайта
        WebElement siteOverview = driver.findElement(By.id("fix_smm_partner-id_5445"));
        siteOverview.click();
        WebElement adFormat = driver.findElement(By.xpath("//*[@id=\"64050\"]/div/div/div/div[2]/div/ul/li/div[2]/div/div/button/div"));
        adFormat.click();
        WebElement title = driver.findElement(By.cssSelector("[aria-label=Title]"));
        title.sendKeys("title");
        WebElement link = driver.findElement(By.xpath("//*[@id=\"app\"]/div[48]/div/div/div[2]/form/div/div[2]/div/div[2]/div[1]/div[2]/div/i"));
        link.click();
        WebElement linkSearch = driver.findElement(By.xpath("//*[@id=\"app\"]/div[47]/div/div/div[2]/div[1]/div/form/div/div/div/div[1]/input"));
        linkSearch.sendKeys("https://football.ua");
        WebElement linkAdd = driver.findElement(By.xpath("//*[@id=\"app\"]/div[47]/div/div/div[2]/div[2]/div/table/tbody/tr/td[5]/button/div/i"));
        linkAdd.click();
        WebElement cost = driver.findElement(By.cssSelector("[aria-label=Cost]"));
        cost.sendKeys("10");
        WebElement numOfPosition = driver.findElement(By.xpath("//*[@id=\"app\"]/div[48]/div/div/div[2]/form/div/div[5]/div/div[2]/div[1]/div/input"));
        numOfPosition.sendKeys("10");
        WebElement reachPerPost = driver.findElement(By.xpath("//*[@id=\"app\"]/div[48]/div/div/div[2]/form/div/div[6]/div/div[2]/div[1]/div/input"));
        reachPerPost.sendKeys("2");
        WebElement saveFormat = driver.findElement(By.xpath("//*[@id=\"app\"]/div[48]/div/div/div[3]/button[2]/div"));
        saveFormat.click();
        // Открытие блока Deal places
        WebElement openDealPlaces = driver.findElement(By.xpath("//*[@id=\"64050\"]/div/div/div/div[3]/div/ul/li/div[1]/div[1]"));
        openDealPlaces.click();
        WebElement selectDealPlace = driver.findElement(By.xpath("//*[@id=\"64050\"]/div/div/div/div[3]/div/ul/li/div[2]/div/div/div[1]/div/div[2]/div[1]/div[1]/div[1]/input"));
        selectDealPlace.sendKeys("20548" + Keys.ENTER);
        WebElement openDealPlace = driver.findElement(By.xpath("//*[@id=\"64050\"]/div/div/div/div[3]/div/ul/li/div[2]/div/div/div[2]/div[1]/div/div[3]/button[1]/div/i"));
        openDealPlace.click();
        // Заполнение Deal place
        WebElement selectPlace = driver.findElement(By.xpath("//*[@id=\"app\"]/div[47]/div/div/div[2]/form/div[1]/div[1]/div/div[2]/div[1]/div[1]/input"));
        selectPlace.sendKeys("adaptive_banner" + Keys.ENTER);
        WebElement platform = driver.findElement(By.cssSelector("[aria-label=Platform]"));
        platform.sendKeys("Facebook" + Keys.ENTER);
        WebElement label = driver.findElement(By.cssSelector("[aria-label=Label]"));
        label.sendKeys("casino" + Keys.ENTER);
        WebElement geo = driver.findElement(By.cssSelector("[aria-label=GEO"));
        geo.sendKeys("Algeria" + Keys.ENTER);
        WebElement linkPP = driver.findElement(By.xpath("//*[@id=\"app\"]/div[47]/div/div/div[2]/form/div[3]/div/div[2]/div[1]/div[1]/input"));
        linkPP.sendKeys("http://refpaimqyjwo.top/L?tag=s_152689m_355c_&site=152689&ad=355");
        WebElement saveDealPlace = driver.findElement(By.xpath("//*[@id=\"app\"]/div[43]/div/div/div[3]/button[2]/div"));
        saveDealPlace.click();
        //        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"app\"]/div[18]/div/div/div[2]/form/div/div[2]/div[1]/div[2]/div[1]/div/input")));
        //        setDate(driver, "#datepicker", "02/20/2002");
        // Log Out
        WebElement profile = driver.findElement(By.xpath("//*[@id=\"profile_btn\"]/div"));
        profile.click();
        WebElement profileExit = driver.findElement(By.xpath("//*[@id=\"exit_btn\"]/div[2]"));
        profileExit.click();
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