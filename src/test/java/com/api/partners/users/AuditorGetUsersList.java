package com.api.partners.users;

import com.api.BaseURL;
import com.api.token2FA.GenerateUserTokenWith2FaForAuditor;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.*;

public class AuditorGetUsersList {
    public String auditorTokenWith2FA;
    public String auditor2FaCode;
    RequestSpecification request = RestAssured.given();
    BaseURL baseURL = new BaseURL();
    final String URL = baseURL.baseURL;

    @BeforeClass
    private void beforeGetProfile() {
        GenerateUserTokenWith2FaForAuditor generateUserTokenWith2FaForAuditor = new GenerateUserTokenWith2FaForAuditor();
        this.auditorTokenWith2FA = generateUserTokenWith2FaForAuditor.set2faForAccount();
        this.auditor2FaCode = generateUserTokenWith2FaForAuditor.auditor2FaCode;
    }

    @Test
    private void getUserProfile(){
        request
                .headers("token", auditorTokenWith2FA)
                .get(URL +"users")
                .then()
                .assertThat()
                .statusCode(200);
    }
    @AfterClass
    public void afterGetProfile(){
        request
                .headers("token", auditorTokenWith2FA)
                .post(URL + "security/status/disable/" + auditor2FaCode)
                .then()
                .assertThat()
                .statusCode(200);
    }
}
