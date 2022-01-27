package com.api.payments;

import com.api.token2FA.GenerateUserTokenWith2FaForCm;
import com.api.token2FA.GenerateUserTokenWith2FaForFs;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CmGetPayments {
    public String userTokenWith2FA;
    public String user2FaCode;
    RequestSpecification request = RestAssured.given();
    final String URL = "https://test-api.solo-crm.com/";

    @BeforeClass
    private void beforeUpdateProfileAdmin() {
        GenerateUserTokenWith2FaForCm generateUserTokenWith2FaForCm = new GenerateUserTokenWith2FaForCm();
        this.userTokenWith2FA = generateUserTokenWith2FaForCm.set2faForAccount();
        this.user2FaCode = generateUserTokenWith2FaForCm.cm2FaCode;
    }

    @Test
    private void test(){
        request
                .headers("token", userTokenWith2FA)
                .get(URL+"payments")
                .then()
                .assertThat()
                .statusCode(200);
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
