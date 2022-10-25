package com.testRail.logsAction;

import com.TestRails;
import com.testRail.APIClient;
import com.testRail.APIException;
import com.ui.BaseTest;
import com.ui.pages.Admin.LoginPageAdmin;
import com.ui.token2Fa.GenerateUserTokenWith2FaForAdminUI;
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

public class InvalidLoginSuite_id_2 extends BaseTest {
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
     * Инфа для ТестРейл
     */
    String PROJECT_ID = "1";
    APIClient client = null;

    @BeforeSuite
    public void createSuite(ITestContext ctx) throws IOException, APIException {
        client = new APIClient("https://solocrmtest.testrail.io");
        client.setUser("aberzeniyaqa@gmail.com");
        client.setPassword("X@1VYnbH");
        Map data = new HashMap();
        data.put("include_all",true);
        data.put("name","Login Valid Suite "+System.currentTimeMillis());
        data.put("suite_id",16);
        JSONObject c;
        c = (JSONObject)client.sendPost("add_run/"+PROJECT_ID,data);
        Long suite_id = (Long)c.get("id");
        ctx.setAttribute("suiteId",suite_id);
    }

    @BeforeMethod
    public void beforeTest(ITestContext ctx, Method method) throws NoSuchMethodException {
        Method m = InvalidLoginSuite_id_2.class.getMethod(method.getName());

        if (m.isAnnotationPresent(TestRails.class)) {
            TestRails ta = m.getAnnotation(TestRails.class);
            System.out.println(ta.id());
            ctx.setAttribute("caseId",ta.id());
        }
    }
    @TestRails(id="165")
    @Test(priority=1)
    public void enterIncorrectLogin() {
        /**
         * Подключаем 2ФА и запоминаем код
         */
        GenerateUserTokenWith2FaForAdminUI generateUserTokenWith2FAForAdminUI = new GenerateUserTokenWith2FaForAdminUI();
        this.userTokenWith2FA = generateUserTokenWith2FAForAdminUI.set2faForAccount();
        this.user2FaCode = generateUserTokenWith2FAForAdminUI.admin2FaCode;

        /**
         * Вводим несуществующий логин, вводим пароль, нажимаем на Sign In,
         * Проверяем что пришло сообщение об ошибке
         */
        new LoginPageAdmin(webDriver, baseURL)
                .inputIncorrectLogin("")
                .inputPassword("")
                .clickOnSignInButton()
                .assertLoginError();
        /**
         * Отключаем 2ФА юзеру.
         */
        request
                .headers("token", userTokenWith2FA)
                .post(apiURL+"security/status/disable/" + user2FaCode)
                .then()
                .assertThat()
                .statusCode(200);
    }
    @TestRails(id="166")
    @Test(priority = 2)
    public void enterIncorrectPassword() {
        /**
         * Подключаем 2ФА и запоминаем код
         */
        GenerateUserTokenWith2FaForAdminUI generateUserTokenWith2FAForAdminUI = new GenerateUserTokenWith2FaForAdminUI();
        this.userTokenWith2FA = generateUserTokenWith2FAForAdminUI.set2faForAccount();
        this.user2FaCode = generateUserTokenWith2FAForAdminUI.admin2FaCode;

        /**
         * Вводим логин, вводим неправильный пароль, нажимаем на Sign In,
         * Проверяем что пришло сообщение об ошибке
         */
        new LoginPageAdmin(webDriver, baseURL)
                .inputLogin("")
                .inputIncorrectPassword("")
                .clickOnSignInButton()
                .assertPasswordError();
        /**
         * Отключаем 2ФА юзеру.
         */
        request
                .headers("token", userTokenWith2FA)
                .post(apiURL+"security/status/disable/" + user2FaCode)
                .then()
                .assertThat()
                .statusCode(200);
    }
    @TestRails(id="167")
    @Test(priority = 3)
    public void enterIncorrect2FaCode() {
        /**
         * Подключаем 2ФА и запоминаем код
         */
        GenerateUserTokenWith2FaForAdminUI generateUserTokenWith2FAForAdminUI = new GenerateUserTokenWith2FaForAdminUI();
        this.userTokenWith2FA = generateUserTokenWith2FAForAdminUI.set2faForAccount();
        this.user2FaCode = generateUserTokenWith2FAForAdminUI.admin2FaCode;

        /**
         * Вводим логин, вводим пароль, нажимаем на Sign In,
         * вводим неправильный код аутентификации, нажимаем на Send Code.
         * Проверяем что пришло сообщение об ошибке.
         * Закрываем окно ввода кода аутентификации.
         */
        new LoginPageAdmin(webDriver, baseURL)
                .inputLogin("")
                .inputPassword("")
                .clickOnSignInButton()
                .inputIncorrectAuthCode("")
                .clickOnSendCodeButton1()
                .assertAuthCodeError()
                .closeAuthCodeWindow();
        /**
         * Отключаем 2ФА юзеру.
         */
        request
                .headers("token", userTokenWith2FA)
                .post(apiURL+"security/status/disable/" + user2FaCode)
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
