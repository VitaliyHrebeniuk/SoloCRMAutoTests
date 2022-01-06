package com.api.users;

import com.api.users.token2FA.GenerateUserTokenWith2FaForAuditor;
import com.api.users.token2FA.GenerateUserTokenWith2FaForTeamLead;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AuditorGetUsersList {
    public String auditorTokenWith2FA;
    public String auditor2FaCode;
    RequestSpecification request = RestAssured.given();
    final String URL = "https://test-api.solo-crm.com";

    @BeforeMethod
    private void beforeGetProfile() {
        GenerateUserTokenWith2FaForAuditor generateUserTokenWith2FaForAuditor = new GenerateUserTokenWith2FaForAuditor();
        this.auditorTokenWith2FA = generateUserTokenWith2FaForAuditor.set2faForAccount();
        this.auditor2FaCode = generateUserTokenWith2FaForAuditor.auditor2FaCode;
    }

    @Test
    private void getUserProfile(){
        request
                .headers("token", auditorTokenWith2FA)
                .get(URL +"/users")
                .then()
                .assertThat()
                .statusCode(200);
    }
    @AfterMethod
    public void afterGetProfile(){
        request
                .headers("token", auditorTokenWith2FA)
                .post(URL + "/security/status/disable/" + auditor2FaCode)
                .then()
                .assertThat()
                .statusCode(200);
    }
}
