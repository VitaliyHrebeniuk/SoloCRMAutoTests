package com.api.users;

import com.api.token2FA.GenerateUserTokenWith2FaForFinControl;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.*;

public class FinControlGetUsersList {
    public String finControlTokenWith2FA;
    public String finControl2FaCode;
    RequestSpecification request = RestAssured.given();
    final String URL = "https://test-api.solo-crm.com/";

    @BeforeClass
    private void beforeGetProfile() {
        GenerateUserTokenWith2FaForFinControl generateUserTokenWith2FaForFinControl = new GenerateUserTokenWith2FaForFinControl();
        this.finControlTokenWith2FA = generateUserTokenWith2FaForFinControl.set2faForAccount();
        this.finControl2FaCode = generateUserTokenWith2FaForFinControl.finControl2FaCode;
    }

    @Test
    private void getUserProfile(){
        request
                .headers("token", finControlTokenWith2FA)
                .get(URL +"users")
                .then()
                .assertThat()
                .statusCode(200);
    }
    @AfterClass
    public void afterGetProfile(){
        request
                .headers("token", finControlTokenWith2FA)
                .post(URL + "security/status/disable/" + finControl2FaCode)
                .then()
                .assertThat()
                .statusCode(200);
    }
}
