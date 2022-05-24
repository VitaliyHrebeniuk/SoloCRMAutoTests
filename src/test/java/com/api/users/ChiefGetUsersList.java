package com.api.users;

import com.api.BaseURL;
import com.api.token2FA.GenerateUserTokenWith2FaForChief;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.*;

public class ChiefGetUsersList {
    public String chiefTokenWith2FA;
    public String chief2FaCode;
    RequestSpecification request = RestAssured.given();
    BaseURL baseURL = new BaseURL();
    final String URL = baseURL.baseURL;

    @BeforeClass
    private void beforeGetProfile() {
        GenerateUserTokenWith2FaForChief generateUserTokenWith2FaForChief = new GenerateUserTokenWith2FaForChief();
        this.chiefTokenWith2FA = generateUserTokenWith2FaForChief.set2faForAccount();
        this.chief2FaCode = generateUserTokenWith2FaForChief.chief2FaCode;
    }

    @Test
    private void getUserProfile(){
        request
                .headers("token", chiefTokenWith2FA)
                .get(URL +"users")
                .then()
                .assertThat()
                .statusCode(200);
    }

    @AfterClass
    public void afterGetProfile(){
        request
                .headers("token", chiefTokenWith2FA)
                .post(URL + "security/status/disable/" + chief2FaCode)
                .then()
                .assertThat()
                .statusCode(200);
    }
}
