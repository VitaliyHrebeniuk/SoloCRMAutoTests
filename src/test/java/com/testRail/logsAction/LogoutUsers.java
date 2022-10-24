package com.testRail.logsAction;

import com.TestRails;
import com.api.BaseURL;
import com.testRail.APIClient;
import com.testRail.APIException;
import com.ui.BaseTest;
import com.ui.pages.Admin.LoginPageAdmin;
import com.ui.pages.Auditor.LoginPageAuditor;
import com.ui.pages.BuyingControl.LoginPageBControl;
import com.ui.pages.CM.LoginPageCM;
import com.ui.pages.Chief.LoginPageChief;
import com.ui.pages.Control.LoginPageControl;
import com.ui.pages.FS.LoginPageFS;
import com.ui.pages.FinControl.LoginPageFinControl;
import com.ui.pages.HeadControl.LoginPageHeadControl;
import com.ui.pages.Manager.LoginPageManager;
import com.ui.pages.RetentionManager.LoginPageRetentionManager;
import com.ui.pages.RetentionTeamLead.LoginPageRetentionTeamLead;
import com.ui.pages.Searcher.LoginPageSearcher;
import com.ui.pages.Spamer.LoginPageSpamer;
import com.ui.pages.Teamlead.LoginPageTLead;
import com.ui.token2Fa.*;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class LogoutUsers  extends BaseTest {
    /**
     * Чтобы можно было отправлять запросы Апишки
     */
    RequestSpecification request = RestAssured.given();
    /**
     * Admin
     */
    public String userTokenWith2FA;
    public String user2FaCode;
    /**
     * TL
     */
    public String teamLeadTokenWith2FA;
    public String teamLead2FaCode;
    /**
     * Chief
     */
    public String chiefTokenWith2FA;
    public String chief2FaCode;
    /**
     * Manager
     */
    public String managerTokenWith2FA;
    public String manager2FaCode;
    /**
     * Auditor
     */
    public String auditorTokenWith2FA;
    public String auditor2FaCode;
    /**
     * Buying Control
     */
    public String buyingControlTokenWith2FA;
    public String buyingControl2FaCode;
    /**
     * CM
     */
    public String cmWith2FA;
    public String cm2FaCode;
    /**
     * Control
     */
    public String controlWith2FA;
    public String control2FaCode;
    /**
     * Fin Control
     */
    public String finControlWith2FA;
    public String finControl2FaCode;
    /**
     * FS
     */
    public String fsWith2FA;
    public String fs2FaCode;
    /**
     * Head Control
     */
    public String headControlTokenWith2FA;
    public String headControl2FaCode;
    /**
     * Retention Manager
     */
    public String retentionManagerTokenWith2FA;
    public String retentionManager2FaCode;
    /**
     * Retention Team Lead
     */
    public String retentionTeamLeadTokenWith2FA;
    public String retentionTeamLead2FaCode;
    /**
     * Searcher
     */
    public String searcherTokenWith2FA;
    public String searcher2FaCode;
    /**
     * Spamer
     */
    public String spamerTokenWith2FA;
    public String spamer2FaCode;

    /**
     * Base URL
     */
    BaseURL apiURL = new BaseURL();
    final String URL = apiURL.baseURL;
    /**
     * Инфа для ТестРейл
     */
    String PROJECT_ID = "1";
    APIClient client = null;

    @BeforeSuite
    public void createSuite(ITestContext ctx) throws IOException, APIException {
        client = new APIClient("https://solocrmtest.testrail.io");
        client.setUser("vitaliy.hrebeniuk.qa@gmail.com");
        client.setPassword("3513355dD!");
        Map data = new HashMap();
        data.put("include_all",true);
        data.put("name","Logout Users "+System.currentTimeMillis());
        data.put("suite_id",15);
        JSONObject c;
        c = (JSONObject)client.sendPost("add_run/"+PROJECT_ID,data);
        Long suite_id = (Long)c.get("id");
        ctx.setAttribute("suiteId",suite_id);
    }

    @BeforeMethod
    public void beforeTest(ITestContext ctx, Method method) throws NoSuchMethodException {
        Method m = LogoutUsers.class.getMethod(method.getName());
        if (m.isAnnotationPresent(TestRails.class)) {
            TestRails ta = m.getAnnotation(TestRails.class);
            System.out.println(ta.id());
            ctx.setAttribute("caseId",ta.id());
        }
    }
    @TestRails(id="119")
    @Test
    public void logoutAdmin() {
        /**
         * Подключаем 2ФА и запоминаем код
         */
        GenerateUserTokenWith2FaForAdminUI generateUserTokenWith2FAForAdminUI = new GenerateUserTokenWith2FaForAdminUI();
        this.userTokenWith2FA = generateUserTokenWith2FAForAdminUI.set2faForAccount();
        this.user2FaCode = generateUserTokenWith2FAForAdminUI.admin2FaCode;

        /**
         * Вводим логин, вводим пароль, нажимаем на Sign In,
         * вводим код аутентификации, нажимаем на Send Code.
         * После чего выходим из аккаунта
         */
        new LoginPageAdmin(webDriver, baseURL)
                .inputLogin("")
                .inputPassword("")
                .clickOnSignInButton()
                .inputAuthCode(user2FaCode)
                .clickOnSendCodeButton()
                .clickOnProfileButton()
                .clickOnExitButton()
                .clickOnYesWarningButton();

        /**
         * Отключаем 2ФА юзеру.
         */
        request
                .headers("token", userTokenWith2FA)
                .post(URL+"security/status/disable/" + user2FaCode)
                .then()
                .assertThat()
                .statusCode(200);
    }
    @TestRails(id="120")
    @Test
    public void logoutTeamLead(){
        /**
         * Подключаем 2ФА и запоминаем код
         */
        GenerateUserTokenWith2FaForTeamLeadUI generateUserTokenWith2FaForTeamLead = new GenerateUserTokenWith2FaForTeamLeadUI();
        this.teamLeadTokenWith2FA = generateUserTokenWith2FaForTeamLead.set2faForAccount();
        this.teamLead2FaCode = generateUserTokenWith2FaForTeamLead.teamLead2FaCode;

        /**
         * Вводим логин, вводим пароль, нажимаем на Sign In,
         * вводим код аутентификации, нажимаем на Send Code.
         * После чего выходим из аккаунта
         */
        new LoginPageTLead(webDriver, baseURL)
                .inputLogin("")
                .inputPassword("")
                .clickOnSignInButton()
                .inputAuthCode(teamLead2FaCode)
                .clickOnSendCodeButton()
                .clickOnProfileButton()
                .clickOnExitButton()
                .clickOnYesWarningButton();
        /**
         * Отключаем 2ФА юзеру.
         */
        request
                .headers("token", teamLeadTokenWith2FA)
                .post(URL+"security/status/disable/" + teamLead2FaCode)
                .then()
                .assertThat()
                .statusCode(200);
    }
    @TestRails(id="121")
    @Test
    public void logoutChief(){
        /**
         * Подключаем 2ФА и запоминаем код
         */
        GenerateUserTokenWith2FaForChiefUI generateUserTokenWith2FaForChiefUI = new GenerateUserTokenWith2FaForChiefUI();
        this.chiefTokenWith2FA = generateUserTokenWith2FaForChiefUI.set2faForAccount();
        this.chief2FaCode = generateUserTokenWith2FaForChiefUI.chief2FaCode;

        /**
         * Вводим логин, вводим пароль, нажимаем на Sign In,
         * вводим код аутентификации, нажимаем на Send Code.
         * После чего выходим из аккаунта
         */
        new LoginPageChief(webDriver, baseURL)
                .inputLogin("")
                .inputPassword("")
                .clickOnSignInButton()
                .inputAuthCode(chief2FaCode)
                .clickOnSendCodeButton()
                .clickOnProfileButton()
                .clickOnExitButton()
                .clickOnYesWarningButton();
        /**
         * Отключаем 2ФА юзеру.
         */
        request
                .headers("token", chiefTokenWith2FA)
                .post(URL+"security/status/disable/" + chief2FaCode)
                .then()
                .assertThat()
                .statusCode(200);
    }
    @TestRails(id="122")
    @Test
    public void logoutManager(){
        /**
         * Подключаем 2ФА и запоминаем код
         */
        GenerateUserTokenWith2FaForManagerUI generateUserTokenWith2FaForManager = new GenerateUserTokenWith2FaForManagerUI();
        this.managerTokenWith2FA = generateUserTokenWith2FaForManager.set2faForAccount();
        this.manager2FaCode = generateUserTokenWith2FaForManager.manager2FaCode;

        /**
         * Вводим логин, вводим пароль, нажимаем на Sign In,
         * вводим код аутентификации, нажимаем на Send Code.
         * После чего выходим из аккаунта
         */
        new LoginPageManager(webDriver, baseURL)
                .inputLogin("")
                .inputPassword("")
                .clickOnSignInButton()
                .inputAuthCode(manager2FaCode)
                .clickOnSendCodeButton()
                .clickOnProfileButton()
                .clickOnExitButton()
                .clickOnYesWarningButton();
        /**
         * Отключаем 2ФА юзеру.
         */
        request
                .headers("token", managerTokenWith2FA)
                .post(URL+"security/status/disable/" + manager2FaCode)
                .then()
                .assertThat()
                .statusCode(200);
    }
    @TestRails(id="123")
    @Test
    public void logoutAuditor(){
        /**
         * Подключаем 2ФА и запоминаем код
         */
        GenerateUserTokenWith2FaForAuditorUI generateUserTokenWith2FaForAuditor = new GenerateUserTokenWith2FaForAuditorUI();
        this.auditorTokenWith2FA = generateUserTokenWith2FaForAuditor.set2faForAccount();
        this.auditor2FaCode = generateUserTokenWith2FaForAuditor.auditor2FaCode;

        /**
         * Вводим логин, вводим пароль, нажимаем на Sign In,
         * вводим код аутентификации, нажимаем на Send Code.
         * После чего выходим из аккаунта
         */
        new LoginPageAuditor(webDriver, baseURL)
                .inputLogin("")
                .inputPassword("")
                .clickOnSignInButton()
                .inputAuthCode(auditor2FaCode)
                .clickOnSendCodeButton()
                .clickOnProfileButton()
                .clickOnExitButton()
                .clickOnYesWarningButton();
        /**
         * Отключаем 2ФА юзеру.
         */
        request
                .headers("token", auditorTokenWith2FA)
                .post(URL+"security/status/disable/" + auditor2FaCode)
                .then()
                .assertThat()
                .statusCode(200);
    }
    @TestRails(id="124")
    @Test
    public void logoutBuyingControl(){
        /**
         * Подключаем 2ФА и запоминаем код
         */
        GenerateUserTokenWith2FaForBuyingControlUI generateUserTokenWith2FaForBuyingControlUI = new GenerateUserTokenWith2FaForBuyingControlUI();
        this.buyingControlTokenWith2FA = generateUserTokenWith2FaForBuyingControlUI.set2faForAccount();
        this.buyingControl2FaCode = generateUserTokenWith2FaForBuyingControlUI.buyingControl2FaCode;

        /**
         * Вводим логин, вводим пароль, нажимаем на Sign In,
         * вводим код аутентификации, нажимаем на Send Code.
         * После чего выходим из аккаунта
         */
        new LoginPageBControl(webDriver, baseURL)
                .inputLogin("")
                .inputPassword("")
                .clickOnSignInButton()
                .inputAuthCode(buyingControl2FaCode)
                .clickOnSendCodeButton()
                .clickOnProfileButton()
                .clickOnExitButton()
                .clickOnYesWarningButton();
        /**
         * Отключаем 2ФА юзеру.
         */
        request
                .headers("token", buyingControlTokenWith2FA)
                .post(URL+"security/status/disable/" + buyingControl2FaCode)
                .then()
                .assertThat()
                .statusCode(200);
    }
    @TestRails(id="125")
    @Test
    public void logoutCM(){
        /**
         * Подключаем 2ФА и запоминаем код
         */
        GenerateUserTokenWith2FaForCmUI generateUserTokenWith2FaForCMUI = new GenerateUserTokenWith2FaForCmUI();
        this.cmWith2FA = generateUserTokenWith2FaForCMUI.set2faForAccount();
        this.cm2FaCode = generateUserTokenWith2FaForCMUI.cm2FaCode;

        /**
         * Вводим логин, вводим пароль, нажимаем на Sign In,
         * вводим код аутентификации, нажимаем на Send Code.
         * После чего выходим из аккаунта
         */
        new LoginPageCM(webDriver, baseURL)
                .inputLogin("")
                .inputPassword("")
                .clickOnSignInButton()
                .inputAuthCode(cm2FaCode)
                .clickOnSendCodeButton()
                .clickOnProfileButton()
                .clickOnExitButton()
                .clickOnYesWarningButton();
        /**
         * Отключаем 2ФА юзеру.
         */
        request
                .headers("token", cmWith2FA)
                .post(URL+"security/status/disable/" + cm2FaCode)
                .then()
                .assertThat()
                .statusCode(200);
    }
    @TestRails(id="126")
    @Test
    public void logoutControl(){
        /**
         * Подключаем 2ФА и запоминаем код
         */
        GenerateUserTokenWith2FaForControlUI generateUserTokenWith2FaForControlUI = new GenerateUserTokenWith2FaForControlUI();
        this.controlWith2FA = generateUserTokenWith2FaForControlUI.set2faForAccount();
        this.control2FaCode = generateUserTokenWith2FaForControlUI.control2FaCode;

        /**
         * Вводим логин, вводим пароль, нажимаем на Sign In,
         * вводим код аутентификации, нажимаем на Send Code.
         * После чего выходим из аккаунта
         */
        new LoginPageControl(webDriver, baseURL)
                .inputLogin("")
                .inputPassword("")
                .clickOnSignInButton()
                .inputAuthCode(control2FaCode)
                .clickOnSendCodeButton()
                .clickOnProfileButton()
                .clickOnExitButton()
                .clickOnYesWarningButton();
        /**
         * Отключаем 2ФА юзеру.
         */
        request
                .headers("token", controlWith2FA)
                .post(URL+"security/status/disable/" + control2FaCode)
                .then()
                .assertThat()
                .statusCode(200);
    }
    @TestRails(id="127")
    @Test
    public void logoutFinControl(){
        /**
         * Подключаем 2ФА и запоминаем код
         */
        GenerateUserTokenWith2FaForFinControlUI generateUserTokenWith2FaForFinControlUI = new GenerateUserTokenWith2FaForFinControlUI();
        this.finControlWith2FA = generateUserTokenWith2FaForFinControlUI.set2faForAccount();
        this.finControl2FaCode = generateUserTokenWith2FaForFinControlUI.finControl2FaCode;

        /**
         * Вводим логин, вводим пароль, нажимаем на Sign In,
         * вводим код аутентификации, нажимаем на Send Code.
         * После чего выходим из аккаунта
         */
        new LoginPageFinControl(webDriver, baseURL)
                .inputLogin("")
                .inputPassword("")
                .clickOnSignInButton()
                .inputAuthCode(finControl2FaCode)
                .clickOnSendCodeButton()
                .clickOnProfileButton()
                .clickOnExitButton()
                .clickOnYesWarningButton();
        /**
         * Отключаем 2ФА юзеру.
         */
        request
                .headers("token", finControlWith2FA)
                .post(URL+"security/status/disable/" + finControl2FaCode)
                .then()
                .assertThat()
                .statusCode(200);
    }
    @TestRails(id="128")
    @Test
    public void logoutFS(){
        /**
         * Подключаем 2ФА и запоминаем код
         */
        GenerateUserTokenWith2FaForFsUI generateUserTokenWith2FaForFsUI = new GenerateUserTokenWith2FaForFsUI();
        this.fsWith2FA = generateUserTokenWith2FaForFsUI.set2faForAccount();
        this.fs2FaCode = generateUserTokenWith2FaForFsUI.fs2FaCode;

        /**
         * Вводим логин, вводим пароль, нажимаем на Sign In,
         * вводим код аутентификации, нажимаем на Send Code.
         * После чего выходим из аккаунта
         */
        new LoginPageFS(webDriver, baseURL)
                .inputLogin("")
                .inputPassword("")
                .clickOnSignInButton()
                .inputAuthCode(fs2FaCode)
                .clickOnSendCodeButton()
                .clickOnProfileButton()
                .clickOnExitButton()
                .clickOnYesWarningButton();
        /**
         * Отключаем 2ФА юзеру.
         */
        request
                .headers("token", fsWith2FA)
                .post(URL+"security/status/disable/" + fs2FaCode)
                .then()
                .assertThat()
                .statusCode(200);
    }
    @TestRails(id="129")
    @Test
    public void logoutHeadControl(){
        /**
         * Подключаем 2ФА и запоминаем код
         */
        GenerateUserTokenWith2FaForHeadControlUI generateUserTokenWith2FaForHeadControlUI = new GenerateUserTokenWith2FaForHeadControlUI();
        this.headControlTokenWith2FA = generateUserTokenWith2FaForHeadControlUI.set2faForAccount();
        this.headControl2FaCode = generateUserTokenWith2FaForHeadControlUI.headControl2FaCode;

        /**
         * Вводим логин, вводим пароль, нажимаем на Sign In,
         * вводим код аутентификации, нажимаем на Send Code.
         * После чего выходим из аккаунта
         */
        new LoginPageHeadControl(webDriver, baseURL)
                .inputLogin("")
                .inputPassword("")
                .clickOnSignInButton()
                .inputAuthCode(headControl2FaCode)
                .clickOnSendCodeButton()
                .clickOnProfileButton()
                .clickOnExitButton()
                .clickOnYesWarningButton();
        /**
         * Отключаем 2ФА юзеру.
         */
        request
                .headers("token", headControlTokenWith2FA)
                .post(URL+"security/status/disable/" + headControl2FaCode)
                .then()
                .assertThat()
                .statusCode(200);
    }
    @TestRails(id="130")
    @Test
    public void logoutRetentionManager(){
        /**
         * Подключаем 2ФА и запоминаем код
         */
        GenerateUserTokenWith2FaForRetentionManagerUI generateUserTokenWith2FaForRetentionManagerUI = new GenerateUserTokenWith2FaForRetentionManagerUI();
        this.retentionManagerTokenWith2FA = generateUserTokenWith2FaForRetentionManagerUI.set2faForAccount();
        this.retentionManager2FaCode = generateUserTokenWith2FaForRetentionManagerUI.retentionManager2FaCode;

        /**
         * Вводим логин, вводим пароль, нажимаем на Sign In,
         * вводим код аутентификации, нажимаем на Send Code.
         * После чего выходим из аккаунта
         */
        new LoginPageRetentionManager(webDriver, baseURL)
                .inputLogin("")
                .inputPassword("")
                .clickOnSignInButton()
                .inputAuthCode(retentionManager2FaCode)
                .clickOnSendCodeButton()
                .clickOnProfileButton()
                .clickOnExitButton()
                .clickOnYesWarningButton();
        /**
         * Отключаем 2ФА юзеру.
         */
        request
                .headers("token", retentionManagerTokenWith2FA)
                .post(URL+"security/status/disable/" + retentionManager2FaCode)
                .then()
                .assertThat()
                .statusCode(200);
    }
    @TestRails(id="131")
    @Test
    public void logoutRetentionTeamLead(){
        /**
         * Подключаем 2ФА и запоминаем код
         */
        GenerateUserTokenWith2FaForRetentionTeamLeadUI generateUserTokenWith2FaForRetentionTeamLeadTokenUI = new GenerateUserTokenWith2FaForRetentionTeamLeadUI();
        this.retentionTeamLeadTokenWith2FA = generateUserTokenWith2FaForRetentionTeamLeadTokenUI.set2faForAccount();
        this.retentionTeamLead2FaCode = generateUserTokenWith2FaForRetentionTeamLeadTokenUI.retentionTeamLead2FaCode;

        /**
         * Вводим логин, вводим пароль, нажимаем на Sign In,
         * вводим код аутентификации, нажимаем на Send Code.
         * После чего выходим из аккаунта
         */
        new LoginPageRetentionTeamLead(webDriver, baseURL)
                .inputLogin("")
                .inputPassword("")
                .clickOnSignInButton()
                .inputAuthCode(retentionTeamLead2FaCode)
                .clickOnSendCodeButton()
                .clickOnProfileButton()
                .clickOnExitButton()
                .clickOnYesWarningButton();
        /**
         * Отключаем 2ФА юзеру.
         */
        request
                .headers("token", retentionTeamLeadTokenWith2FA)
                .post(URL+"security/status/disable/" + retentionTeamLead2FaCode)
                .then()
                .assertThat()
                .statusCode(200);
    }
    @TestRails(id="132")
    @Test
    public void logoutRetentionSearcher(){
        /**
         * Подключаем 2ФА и запоминаем код
         */
        GenerateUserTokenWith2FaForSearcherUI generateUserTokenWith2FaForSearcherUI = new GenerateUserTokenWith2FaForSearcherUI();
        this.searcherTokenWith2FA = generateUserTokenWith2FaForSearcherUI.set2faForAccount();
        this.searcher2FaCode = generateUserTokenWith2FaForSearcherUI.searcher2FaCode;

        /**
         * Вводим логин, вводим пароль, нажимаем на Sign In,
         * вводим код аутентификации, нажимаем на Send Code.
         * После чего выходим из аккаунта
         */
        new LoginPageSearcher(webDriver, baseURL)
                .inputLogin("")
                .inputPassword("")
                .clickOnSignInButton()
                .inputAuthCode(searcher2FaCode)
                .clickOnSendCodeButton()
                .clickOnProfileButton()
                .clickOnExitButton()
                .clickOnYesWarningButton();
        /**
         * Отключаем 2ФА юзеру.
         */
        request
                .headers("token", searcherTokenWith2FA)
                .post(URL+"security/status/disable/" + searcher2FaCode)
                .then()
                .assertThat()
                .statusCode(200);
    }
    @TestRails(id="133")
    @Test
    public void logoutRetentionSpamer(){
        /**
         * Подключаем 2ФА и запоминаем код
         */
        GenerateUserTokenWith2FaForSpamerUI generateUserTokenWith2FaForSpamerUI = new GenerateUserTokenWith2FaForSpamerUI();
        this.spamerTokenWith2FA = generateUserTokenWith2FaForSpamerUI.set2faForAccount();
        this.spamer2FaCode = generateUserTokenWith2FaForSpamerUI.spamer2FaCode;

        /**
         * Вводим логин, вводим пароль, нажимаем на Sign In,
         * вводим код аутентификации, нажимаем на Send Code.
         * После чего выходим из аккаунта
         */
        new LoginPageSpamer(webDriver, baseURL)
                .inputLogin("")
                .inputPassword("")
                .clickOnSignInButton()
                .inputAuthCode(spamer2FaCode)
                .clickOnSendCodeButton()
                .clickOnProfileButton()
                .clickOnExitButton()
                .clickOnYesWarningButton();
        /**
         * Отключаем 2ФА юзеру.
         */
        request
                .headers("token", spamerTokenWith2FA)
                .post(URL+"security/status/disable/" + spamer2FaCode)
                .then()
                .assertThat()
                .statusCode(200);
    }

    @AfterMethod
    public void afterTest(ITestResult result, ITestContext ctx) throws IOException, APIException {
        Map data = new HashMap();
        if(result.isSuccess()) {
            data.put("status_id",1);
        }
        else {
            data.put("status_id", 5);
            data.put("comment", result.getThrowable().toString());
        }

        String caseId = (String)ctx.getAttribute("caseId");
        Long suiteId = (Long)ctx.getAttribute("suiteId");
        client.sendPost("add_result_for_case/"+suiteId+"/"+caseId,data);

    }
}
