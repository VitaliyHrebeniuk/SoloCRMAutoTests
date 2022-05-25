package com.api.users;

import com.api.BaseURL;
import com.api.token2FA.GenerateUserTokenWith2FaForAdmin;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.*;

public class AdminAutoAuth {
    public String userTokenWith2FA;
    public String user2FaCode;
    RequestSpecification request = RestAssured.given();
    BaseURL baseURL = new BaseURL();
    final String URL = baseURL.baseURL;

    @BeforeClass
    private void beforeUpdateProfileAdmin() {
        GenerateUserTokenWith2FaForAdmin generateUserTokenWith2FAForAdmin = new GenerateUserTokenWith2FaForAdmin();
        this.userTokenWith2FA = generateUserTokenWith2FAForAdmin.set2faForAccount();
        this.user2FaCode = generateUserTokenWith2FAForAdmin.admin2FaCode;
    }

    @Test(priority = 1)
    private void getAdminLogout(){
        request
                .headers("token", userTokenWith2FA)
                .post(URL + "users/auto_auth/manager_TEST_API")
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test(priority = 2)
    private void deleteAdminUsersAutiAuth(){
        request
                .headers("token", userTokenWith2FA)
                .delete(URL + "users/auto_auth/manager_TEST_API")
                .then()
                .assertThat()
                .statusCode(200);
    }

    @AfterClass
    public void afterUpdateUserProfile(){
        request
                .headers("token", userTokenWith2FA)
                .post(URL + "security/status/disable/" + user2FaCode)
                .then()
                .assertThat()
                .statusCode(200);
    }
}
