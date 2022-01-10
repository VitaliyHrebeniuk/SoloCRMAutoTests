package com.api.users;

import com.api.token2FA.GenerateUserTokenWith2FaForAdmin;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.*;

public class AdminGetUserInfoById {
    public String adminTokenWith2FA;
    public String admin2FaCode;
    RequestSpecification request = RestAssured.given();
    final String URL = "https://test-api.solo-crm.com";

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
                .param("userId",884)
                .get(URL +"/users/userInfoById")
                .then()
                .assertThat()
                .statusCode(200);
    }

    @AfterClass
    public void afterGetProfile(){
        request
                .headers("token", adminTokenWith2FA)
                .post(URL + "/security/status/disable/" + admin2FaCode)
                .then()
                .assertThat()
                .statusCode(200);
    }
}
