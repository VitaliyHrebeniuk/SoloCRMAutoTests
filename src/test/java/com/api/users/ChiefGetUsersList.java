package com.api.users;

import com.api.users.token2FA.GenerateUserTokenWith2FaForChief;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ChiefGetUsersList {
    public String chiefTokenWith2FA;
    public String chief2FaCode;
    RequestSpecification request = RestAssured.given();
    final String URL = "https://beta-api.solo-crm.com";

    @BeforeMethod
    private void beforeGetProfile() {
        GenerateUserTokenWith2FaForChief generateUserTokenWith2FaForChief = new GenerateUserTokenWith2FaForChief();
        this.chiefTokenWith2FA = generateUserTokenWith2FaForChief.set2faForAccount();
        this.chief2FaCode = generateUserTokenWith2FaForChief.chief2FaCode;
    }

    @Test
    private void getUserProfile(){
        request
                .headers("token", chiefTokenWith2FA)
                .get(URL +"/users")
                .then()
                .assertThat()
                .statusCode(200);
    }

    @AfterMethod
    public void afterGetProfile(){
        request
                .headers("token", chiefTokenWith2FA)
                .post(URL + "/security/status/disable/" + chief2FaCode)
                .then()
                .assertThat()
                .statusCode(200);
    }
}
