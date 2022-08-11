package com.api.users;

import com.api.BaseURL;
import com.api.token2FA.GenerateUserTokenWith2FaForAdmin;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.*;

public class AdminPutCreateUser {
    public String userTokenWith2FA;
    public String user2FaCode;
    final String ROLE_ADMIN = "admin", LOGIN_ADMIN = "admin_API_TEST_";
    final String ROLE_AUDITOR = "auditor", LOGIN_AUDITOR = "auditor_API_TEST_";
    final String ROLE_BUYING_CONTROL = "buying_control", LOGIN_BUYING_CONTROL = "buying_control_API_TEST_";
    final String ROLE_CHIEF = "chief", LOGIN_CHIEF = "chief_API_TEST_";
    final String ROLE_BUYING_CM = "cm", LOGIN_CM = "cm_API_TEST_";
    final String ROLE_CONTROL = "control", LOGIN_CONTROL = "control_API_TEST_";
    final String ROLE_FIN_CONTROL = "fincontrol", LOGIN_FIN_CONTROL = "fin_control_API_TEST_";
    final String ROLE_FS = "fs", LOGIN_FS = "fs_API_TEST_";
    final String ROLE_HEAD_CONTROL = "head_control", LOGIN_HEAD_CONTROL = "head_control_API_TEST_";
    final String ROLE_MANAGER = "manager", LOGIN_MANAGER = "manager_API_TEST_";
    final String ROLE_SEARCHER = "searcher", LOGIN_SEARCHER = "searcher_API_TEST_";
    final String ROLE_SPAMER = "spamer", LOGIN_SPAMER = "spamer_API_TEST_";
    final String ROLE_TEAMLEAD = "teamlead", LOGIN_TEAMLEAD = "teamlead_API_TEST_";
    final String EMAIL_PREFIX = "@g.com";
    final String STATUS = "active";
    final String NAME = "API_TEST_USER";
    final String TELEGRAM = "API_TEST";
    final String PASSWORD = "132465798";
    BaseURL baseURL = new BaseURL();
    final String URL = baseURL.baseURL;

    RequestSpecification request = RestAssured.given();

    private String generateRandomNumber(){
        double a = 20 + Math.random()*40;
        return String.valueOf(a);
    }

    @BeforeClass
    private void beforeUpdateProfileAdmin() {
        GenerateUserTokenWith2FaForAdmin generateUserTokenWith2FAForAdmin = new GenerateUserTokenWith2FaForAdmin();
        this.userTokenWith2FA = generateUserTokenWith2FAForAdmin.set2faForAccount();
        this.user2FaCode = generateUserTokenWith2FAForAdmin.admin2FaCode;

    }

    @Test
    private void putCreateAdmin(){
        request
                .headers("token", userTokenWith2FA)
                .param("status",STATUS)
                .param("role", ROLE_ADMIN)
                .param("name", NAME+generateRandomNumber())
                .param("login", LOGIN_ADMIN+generateRandomNumber())
                .param("email", LOGIN_ADMIN+generateRandomNumber()+EMAIL_PREFIX)
                .param("telegram", TELEGRAM)
                .param("password", PASSWORD)
                .put(URL+"users")
                .then()
                .assertThat()
                .statusCode(201);
    }
    @Test
    private void putCreateAuditor(){
        request
                .headers("token", userTokenWith2FA)
                .param("status",STATUS)
                .param("role", ROLE_AUDITOR)
                .param("name", NAME+generateRandomNumber())
                .param("login", LOGIN_AUDITOR+generateRandomNumber())
                .param("email", LOGIN_AUDITOR+generateRandomNumber()+EMAIL_PREFIX)
                .param("telegram", TELEGRAM)
                .param("password", PASSWORD)
                .put(URL+"users")
                .then()
                .assertThat()
                .statusCode(201);
    }
    @Test
    private void putCreateControl(){
        request
                .headers("token", userTokenWith2FA)
                .param("status",STATUS)
                .param("role", ROLE_CONTROL)
                .param("name", NAME+generateRandomNumber())
                .param("login", LOGIN_CONTROL+generateRandomNumber())
                .param("email", LOGIN_CONTROL+generateRandomNumber()+EMAIL_PREFIX)
                .param("telegram", TELEGRAM)
                .param("password", PASSWORD)
                .put(URL+"users")
                .then()
                .assertThat()
                .statusCode(201);
    }
    @Test
    private void putCreateChief(){
        request
                .headers("token", userTokenWith2FA)
                .param("status",STATUS)
                .param("role", ROLE_CHIEF)
                .param("name", NAME+generateRandomNumber())
                .param("login", LOGIN_CHIEF+generateRandomNumber())
                .param("email", LOGIN_CHIEF+generateRandomNumber()+EMAIL_PREFIX)
                .param("telegram", TELEGRAM)
                .param("password", PASSWORD)
                .put(URL+"users")
                .then()
                .assertThat()
                .statusCode(201);
    }
    @Test
    private void putCreateBuyingControl(){
        request
                .headers("token", userTokenWith2FA)
                .param("status",STATUS)
                .param("role", ROLE_BUYING_CONTROL)
                .param("name", NAME+generateRandomNumber())
                .param("login", LOGIN_BUYING_CONTROL+generateRandomNumber())
                .param("email", LOGIN_BUYING_CONTROL+generateRandomNumber()+EMAIL_PREFIX)
                .param("telegram", TELEGRAM)
                .param("password", PASSWORD)
                .put(URL+"users")
                .then()
                .assertThat()
                .statusCode(201);
    }
    @Test
    private void putCreateFinControl(){
        request
                .headers("token", userTokenWith2FA)
                .param("status",STATUS)
                .param("role", ROLE_FIN_CONTROL)
                .param("name", NAME+generateRandomNumber())
                .param("login", LOGIN_FIN_CONTROL+generateRandomNumber())
                .param("email", LOGIN_FIN_CONTROL+generateRandomNumber()+EMAIL_PREFIX)
                .param("telegram", TELEGRAM)
                .param("password", PASSWORD)
                .put(URL+"users")
                .then()
                .assertThat()
                .statusCode(201);
    }
    @Test
    private void putCreateCm(){
        request
                .headers("token", userTokenWith2FA)
                .param("status",STATUS)
                .param("role", ROLE_BUYING_CM)
                .param("name", NAME+generateRandomNumber())
                .param("login", LOGIN_CM+generateRandomNumber())
                .param("email", LOGIN_CM+generateRandomNumber()+EMAIL_PREFIX)
                .param("telegram", TELEGRAM)
                .param("password", PASSWORD)
                .put(URL+"users")
                .then()
                .assertThat()
                .statusCode(201);
    }
    @Test
    private void putCreateFs(){
        request
                .headers("token", userTokenWith2FA)
                .param("status",STATUS)
                .param("role", ROLE_FS)
                .param("name", NAME+generateRandomNumber())
                .param("login", LOGIN_FS+generateRandomNumber())
                .param("email", LOGIN_FS+generateRandomNumber()+EMAIL_PREFIX)
                .param("telegram", TELEGRAM)
                .param("password", PASSWORD)
                .put(URL+"users")
                .then()
                .assertThat()
                .statusCode(201);
    }
    @Test
    private void putCreateHeadControl(){
        request
                .headers("token", userTokenWith2FA)
                .param("status",STATUS)
                .param("role", ROLE_HEAD_CONTROL)
                .param("name", NAME+generateRandomNumber())
                .param("login", LOGIN_HEAD_CONTROL+generateRandomNumber())
                .param("email", LOGIN_HEAD_CONTROL+generateRandomNumber()+EMAIL_PREFIX)
                .param("telegram", TELEGRAM)
                .param("password", PASSWORD)
                .put(URL+"users")
                .then()
                .assertThat()
                .statusCode(201);
    }
    @Test
    private void putManager(){
        request
                .headers("token", userTokenWith2FA)
                .param("status",STATUS)
                .param("role", ROLE_MANAGER)
                .param("name", NAME+generateRandomNumber())
                .param("login", LOGIN_MANAGER+generateRandomNumber())
                .param("email", LOGIN_MANAGER+generateRandomNumber()+EMAIL_PREFIX)
                .param("telegram", TELEGRAM)
                .param("password", PASSWORD)
                .put(URL+"users")
                .then()
                .assertThat()
                .statusCode(201);
    }
    @Test
    private void putCreateSearcher(){
        request
                .headers("token", userTokenWith2FA)
                .param("status",STATUS)
                .param("role", ROLE_SEARCHER)
                .param("name", NAME+generateRandomNumber())
                .param("login", LOGIN_SEARCHER+generateRandomNumber())
                .param("email", LOGIN_SEARCHER+generateRandomNumber()+EMAIL_PREFIX)
                .param("telegram", TELEGRAM)
                .param("password", PASSWORD)
                .put(URL+"users")
                .then()
                .assertThat()
                .statusCode(201);
    }
    @Test
    private void putCreateSpamer(){
        request
                .headers("token", userTokenWith2FA)
                .param("status",STATUS)
                .param("role", ROLE_SPAMER)
                .param("name", NAME+generateRandomNumber())
                .param("login", LOGIN_SPAMER+generateRandomNumber())
                .param("email", LOGIN_SPAMER+generateRandomNumber()+EMAIL_PREFIX)
                .param("telegram", TELEGRAM)
                .param("password", PASSWORD)
                .put(URL+"users")
                .then()
                .assertThat()
                .statusCode(201);
    }
    @Test
    private void putCreateTeamLead(){
        request
                .headers("token", userTokenWith2FA)
                .param("status",STATUS)
                .param("role", ROLE_TEAMLEAD)
                .param("name", NAME+generateRandomNumber())
                .param("login", LOGIN_TEAMLEAD+generateRandomNumber())
                .param("email", LOGIN_TEAMLEAD+generateRandomNumber()+EMAIL_PREFIX)
                .param("telegram", TELEGRAM)
                .param("password", PASSWORD)
                .put(URL+"users")
                .then()
                .assertThat()
                .statusCode(201);
    }
    @AfterClass
    public void afterUpdateUserProfile(){
        request
                .headers("token", userTokenWith2FA)
                .post(URL+"security/status/disable/" + user2FaCode)
                .then()
                .assertThat()
                .statusCode(200);
    }
}
