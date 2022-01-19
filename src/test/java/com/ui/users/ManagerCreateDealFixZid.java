package com.ui.users;

import com.ui.token2Fa.GenerateUserTokenWith2FaForAuditorUI;
import com.ui.token2Fa.GenerateUserTokenWith2FaForBuyingControlUI;
import com.ui.token2Fa.GenerateUserTokenWith2FaForManagerUI;
import com.ui.token2Fa.GenerateUserTokenWith2FaForTeamLeadUI;
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

public class ManagerCreateDealFixZid {
    WebDriver driver;
    String managerTokenWith2FA;
    String teamLeadTokenWith2FA;
    String buyingControlTokenWith2FA;
    String auditorTokenWith2FA;
    RequestSpecification request = RestAssured.given();
    final String URL = "https://test-api.solo-crm.com/";
    private String dealID;
    private String manager2FaCode;
    private String buyingControl2FaCode;
    private String teamLead2FaCode;
    private String auditor2FaCode;
    int a = (int) (Math.random() * 10000);

    @BeforeClass
    public void setDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod()
    public void managerToken(){
        GenerateUserTokenWith2FaForManagerUI generateUserTokenWith2FaForManager = new GenerateUserTokenWith2FaForManagerUI();
        this.managerTokenWith2FA = generateUserTokenWith2FaForManager.set2faForAccount();
        this.manager2FaCode = generateUserTokenWith2FaForManager.manager2FaCode;
    }
    @Test
    public void createFixZid() {
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
        // Переход к партнерам
        WebElement partnersMenu = driver.findElement(By.xpath("//*[@id=\"menu-buying\"]/div"));
        partnersMenu.click();
        WebElement partnersList = driver.findElement(By.xpath("//*[@id=\"buying-partners_list\"]/div[2]/div"));
        partnersList.click();
        WebElement partnersID = driver.findElement(By.xpath("//*[@id=\"app\"]/div[82]/main/div/div[2]/div/div/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div[1]/div/div[2]/div[1]/div[1]/input"));
        partnersID.sendKeys("5445");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        // Создание сделки
        WebElement plusDeal = driver.findElement(By.xpath("//*[@id=\"partner-id_5445\"]/div/i"));
        plusDeal.click();
        WebElement fixZid = driver.findElement(By.xpath("//*[@id=\"fix_zid_partner-id_5445\"]/div"));
        fixZid.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        // Добавление сайта
        driver.findElement(By.xpath("//*[@id=\"zid_fix-panel-overview\"]/div/ul/li/div[1]")).click();
        driver.findElement(By.id("cpi-link_search")).sendKeys("https://football.ua");
        driver.findElement(By.xpath("//*[@id=\"fix_zid-attach_lead\"]/div/i"));
        // Добавление Site Places
        driver.findElement(By.id("fix_zid-search_site")).sendKeys("20578" + Keys.ENTER);
        // Add link
        driver.findElement(By.xpath("//*[@id=\"fix_zid-add_place\"]/div")).click();
        driver.findElement(By.id("fix-zid-deal_place_type_id")).sendKeys("adaptive_banner" + Keys.ENTER);
        driver.findElement(By.id("fix-zid-cost")).sendKeys("10");
        driver.findElement(By.id("fix-zid-traffic_volume")).sendKeys("10");
        driver.findElement(By.id("fix-zid-cpm")).sendKeys("10");
        driver.findElement(By.id("fix-zid-traffic_channel")).sendKeys("desk" + Keys.ENTER);
        driver.findElement(By.id("fix-zid-label")).sendKeys("casino" + Keys.ENTER);
        driver.findElement(By.id("fix-zid-country_id")).sendKeys("Afghanistan" + Keys.ENTER);
        driver.findElement(By.id("fix-zid-link")).sendKeys("http://refpa.top/L?tag=d_687199m_97c__[]general[]_d38098_l32830_post&site=687199&ad=97");
        driver.findElement(By.xpath("//*[@id=\"fix-zid-save_place\"]/div")).click();
        // Add Zid/Cid
        driver.findElement(By.xpath("//*[@id=\"fix_zid-add_zid\"]/div")).click();
        driver.findElement(By.id("fix_zid-zid_solo")).sendKeys();
    }
}
