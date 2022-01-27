package com.api.tags;

import com.api.token2FA.GenerateUserTokenWith2FaForChief;
import com.api.token2FA.GenerateUserTokenWith2FaForFinControl;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FinControlPutTags {
    public String userTokenWith2FA;
    public String user2FaCode;
    RequestSpecification request = RestAssured.given();
    final String URL = "https://test-api.solo-crm.com/";

    @BeforeClass
    private void beforeUpdateProfileAdmin() {
        GenerateUserTokenWith2FaForFinControl generateUserTokenWith2FaForFinControl = new GenerateUserTokenWith2FaForFinControl();
        this.userTokenWith2FA = generateUserTokenWith2FaForFinControl.set2faForAccount();
        this.user2FaCode = generateUserTokenWith2FaForFinControl.finControl2FaCode;
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
