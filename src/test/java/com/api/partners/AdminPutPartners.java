package com.api.partners;

import com.api.token2FA.GenerateUserTokenWith2FaForAdmin;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AdminPutPartners {
    public String userTokenWith2FA;
    public String user2FaCode;
    RequestSpecification request = RestAssured.given();
    final String URL = "https://test-api.solo-crm.com/";

    @BeforeClass
    private void beforeUpdateProfileAdmin() {
        GenerateUserTokenWith2FaForAdmin generateUserTokenWith2FAForAdmin = new GenerateUserTokenWith2FaForAdmin();
        this.userTokenWith2FA = generateUserTokenWith2FAForAdmin.set2faForAccount();
        this.user2FaCode = generateUserTokenWith2FAForAdmin.admin2FaCode;
    }

    @Test
    private void test(){
        request
                .headers("token", userTokenWith2FA)
                .param("name","1")
                .param("product id",1)
                .put(URL+"partners")
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
