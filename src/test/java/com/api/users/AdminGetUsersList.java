package com.api.users;

import com.api.BaseURL;
import com.api.token2FA.GenerateUserTokenWith2FaForAdmin;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.*;

public class AdminGetUsersList {
    public String adminTokenWith2FA;
    public String admin2FaCode;
    RequestSpecification request = RestAssured.given();
    BaseURL baseURL = new BaseURL();
    final String URL = baseURL.baseURL;

    @BeforeClass
    private void beforeGetProfile() {
        GenerateUserTokenWith2FaForAdmin generateUserTokenWith2FaForAdmin = new GenerateUserTokenWith2FaForAdmin();
        this.adminTokenWith2FA = generateUserTokenWith2FaForAdmin.set2faForAccount();
        this.admin2FaCode = generateUserTokenWith2FaForAdmin.admin2FaCode;
    }

    @Test
    private void getUserProfile(){
        request
                .headers("token", adminTokenWith2FA)
                .get(URL +"users")
                .then()
                .assertThat()
                .statusCode(200);
    }

    @AfterClass
    public void afterGetProfile(){
        request
                .headers("token", adminTokenWith2FA)
                .post(URL + "security/status/disable/" + admin2FaCode)
                .then()
                .assertThat()
                .statusCode(200);
    }
}
