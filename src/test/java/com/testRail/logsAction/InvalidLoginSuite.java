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
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class InvalidLoginSuite extends BaseTest {
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

//    @BeforeSuite
//    public void createSuite(ITestContext ctx) throws IOException, APIException {
//        client = new APIClient("https://solocrmtest.testrail.io");
//        client.setUser("aberzeniyaqa@gmail.com");
//        client.setPassword("X@1VYnbH");
//        Map data = new HashMap();
//        data.put("include_all",true);
//        data.put("name","Invalid Login Suite "+System.currentTimeMillis());
//        data.put("suite_id",16);
//        JSONObject c;
//        c = (JSONObject)client.sendPost("add_run/"+PROJECT_ID,data);
//        Long suite_id = (Long)c.get("id");
//        ctx.setAttribute("suiteId",suite_id);
//    }
    @TestRails(id="165")
    @Test
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
    @Test
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
    @Test
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
}
