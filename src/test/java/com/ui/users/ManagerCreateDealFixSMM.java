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


public class ManagerCreateDealFixSMM {
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
    @Test(priority = 0)
    public void createFixSMM(){
        // Login
        driver.get("https://test.solo-crm.com/#/login");
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        WebElement login = driver.findElement(By.cssSelector("[aria-label=Login]"));
        login.sendKeys("manager_TEST_UI");
        WebElement password = driver.findElement(By.cssSelector("[aria-label=Password]"));
        password.sendKeys("132465798");
        WebElement signIn = driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/main/div/div/div/div/div/div/div[2]/div/div/form/div[3]/button/div"));
        signIn.click();
        //Ввожу 6-ти значный код
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div[2]/form/div/div[2]/div[1]/div/input")).sendKeys(manager2FaCode);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div[3]/button[2]")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
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
//    @AfterMethod
//    public void afterGetProfileManager(){
//        request
//                .headers("token", managerTokenWith2FA)
//                .post(URL + "security/status/disable/" + manager2FaCode)
//                .then()
//                .assertThat()
//                .statusCode(200);
//    }

    @BeforeMethod
    public void buyingControlToken(){
        GenerateUserTokenWith2FaForBuyingControlUI generateUserTokenWith2FaForBuyingControlUI = new GenerateUserTokenWith2FaForBuyingControlUI();
        this.buyingControlTokenWith2FA = generateUserTokenWith2FaForBuyingControlUI.set2faForAccount();
        this.buyingControl2FaCode = generateUserTokenWith2FaForBuyingControlUI.buyingControl2FaCode;
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
        driver.findElement(By.xpath("//*[@id=\"menu-buying\"]/div")).click();
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
    @AfterMethod
    public void afterGetProfileBuyingControl(){
        request
                .headers("token", buyingControlTokenWith2FA)
                .post(URL + "security/status/disable/" + buyingControl2FaCode)
                .then()
                .assertThat()
                .statusCode(200);
    }

//    @BeforeMethod
//    public void managerToken1(){
//        GenerateUserTokenWith2FaForManagerUI generateUserTokenWith2FaForManager = new GenerateUserTokenWith2FaForManagerUI();
//        this.managerTokenWith2FA = generateUserTokenWith2FaForManager.set2faForAccount();
//        this.manager2FaCode = generateUserTokenWith2FaForManager.manager2FaCode;
//    }
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
        driver.findElement(By.xpath("//*[@id=\"menu-buying\"]/div")).click();
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
    @AfterMethod
    public void afterGetProfileManager2(){
        request
                .headers("token", managerTokenWith2FA)
                .post(URL + "security/status/disable/" + manager2FaCode)
                .then()
                .assertThat()
                .statusCode(200);
    }

    @BeforeMethod
    public void teamLeadToken(){
        GenerateUserTokenWith2FaForTeamLeadUI generateUserTokenWith2FaForTeamLead = new GenerateUserTokenWith2FaForTeamLeadUI();
        this.teamLeadTokenWith2FA = generateUserTokenWith2FaForTeamLead.set2faForAccount();
        this.teamLead2FaCode = generateUserTokenWith2FaForTeamLead.teamLead2FaCode;
    }
    @Test(priority = 3)
    public void teamLeadApprove(){
        // Login
        WebElement login = driver.findElement(By.cssSelector("[aria-label=Login]"));
        login.sendKeys("teamlead_TEST_UI");
        WebElement password = driver.findElement(By.cssSelector("[aria-label=Password]"));
        password.sendKeys("132465798");
        WebElement signIn = driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/main/div/div/div/div/div/div/div[2]/div/div/form/div[3]/button/div"));
        signIn.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //Ввожу 6-ти значный код
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div[2]/form/div/div[2]/div[1]/div/input")).sendKeys(teamLead2FaCode);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div[3]/button[2]")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        // Переход к сделкам
        driver.findElement(By.xpath("//*[@id=\"menu-buying\"]/div")).click();
        driver.findElement(By.xpath("//*[@id=\"buying-deals_list\"]/div[2]/div")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        // Переход к сделке и аппрув
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[27]/main/div/div[2]/div/div/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/table/tbody/tr[1]/td[13]/a/div/i")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"64069\"]/div/div/div/div[1]/div[2]/div[1]/div[2]/div[1]/button[1]/div")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        // Log out
        driver.findElement(By.xpath("//*[@id=\"profile_btn\"]/div")).click();
        driver.findElement(By.xpath("//*[@id=\"exit_btn\"]/div[2]"));
    }
    @AfterMethod
    public void afterGetProfileTeamLead(){
        request
                .headers("token", teamLeadTokenWith2FA)
                .post(URL + "security/status/disable/" + teamLead2FaCode)
                .then()
                .assertThat()
                .statusCode(200);
    }

    @BeforeMethod
    private void beforeGetProfileAuditor() {
        GenerateUserTokenWith2FaForAuditorUI generateUserTokenWith2FaForAuditor = new GenerateUserTokenWith2FaForAuditorUI();
        this.auditorTokenWith2FA = generateUserTokenWith2FaForAuditor.set2faForAccount();
        this.auditor2FaCode = generateUserTokenWith2FaForAuditor.auditor2FaCode;
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
        driver.findElement(By.xpath("//*[@id=\"menu-buying\"]/div")).click();
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
    @AfterMethod
    public void afterGetProfileAuditor(){
        request
                .headers("token", auditorTokenWith2FA)
                .post(URL + "/security/status/disable/" + auditor2FaCode)
                .then()
                .assertThat()
                .statusCode(200);
    }

    @AfterClass
    public void QuitDriver(){
        driver.quit();
    }
}