package com.api.tags;

import com.api.BaseURL;
import com.api.token2FA.GenerateUserTokenWith2FaForChief;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ChiefPutTags {
    public String userTokenWith2FA;
    public String user2FaCode;
    RequestSpecification request = RestAssured.given();
    BaseURL baseURL = new BaseURL();
    final String URL = baseURL.baseURL;

    @BeforeClass
    private void beforeUpdateProfileChief() {
        GenerateUserTokenWith2FaForChief generateUserTokenWith2FaForChief = new GenerateUserTokenWith2FaForChief();
        this.userTokenWith2FA = generateUserTokenWith2FaForChief.set2faForAccount();
        this.user2FaCode = generateUserTokenWith2FaForChief.chief2FaCode;
    }

    private String generateRandomNumber(){
        double a = 20 + Math.random()*40;
        return String.valueOf(a);
    }

    @Test
    private void test(){
        request
                .headers("token", userTokenWith2FA)
                .param("name","testAPI" + generateRandomNumber())
                .param("color", "red")
                .put(URL+"tags")
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
