package com.api.payments;

import com.api.BaseURL;
import com.api.token2FA.GenerateUserTokenWith2FaForAuditor;
import com.api.token2FA.GenerateUserTokenWith2FaForFinControl;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FinControlGetPayments {
    public String userTokenWith2FA;
    public String user2FaCode;
    RequestSpecification request = RestAssured.given();
    BaseURL baseURL = new BaseURL();
    final String URL = baseURL.baseURL;

    @BeforeClass
    private void beforeUpdateProfileAdmin() {
        GenerateUserTokenWith2FaForFinControl generateUserTokenWith2FaForFinControl = new GenerateUserTokenWith2FaForFinControl();
        this.userTokenWith2FA = generateUserTokenWith2FaForFinControl.set2faForAccount();
        this.user2FaCode = generateUserTokenWith2FaForFinControl.finControl2FaCode;
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
