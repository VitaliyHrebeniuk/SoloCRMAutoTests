package com.api.payments;

import com.api.BaseURL;
import com.api.token2FA.GenerateUserTokenWith2FaForAdmin;
import com.api.token2FA.GenerateUserTokenWith2FaForChief;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ChiefDeleteFile {
    public String userTokenWith2FA;
    public String user2FaCode;
    RequestSpecification request = RestAssured.given();
    BaseURL baseURL = new BaseURL();
    final String URL = baseURL.baseURL;

    @BeforeClass
    private void beforeUpdateProfileAdmin() {
        GenerateUserTokenWith2FaForChief generateUserTokenWith2FaForChief = new GenerateUserTokenWith2FaForChief();
        this.userTokenWith2FA = generateUserTokenWith2FaForChief.set2faForAccount();
        this.user2FaCode = generateUserTokenWith2FaForChief.chief2FaCode;
    }

    @Test
    private void test(){
        request
                .headers("token", userTokenWith2FA)
                .delete(URL+"payments/deleteFile/1065102")
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
