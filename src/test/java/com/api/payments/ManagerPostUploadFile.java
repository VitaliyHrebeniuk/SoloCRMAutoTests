package com.api.payments;

import com.api.token2FA.GenerateUserTokenWith2FaForAdmin;
import com.api.token2FA.GenerateUserTokenWith2FaForManager;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ManagerPostUploadFile {
    public String managerTokenWith2FA;
    public String manager2FaCode;
    RequestSpecification request = RestAssured.given();
    final String URL = "https://test-api.solo-crm.com/";

    @BeforeClass
    private void beforeUpdateProfileAdmin() {
        GenerateUserTokenWith2FaForManager generateUserTokenWith2FaForManager = new GenerateUserTokenWith2FaForManager();
        this.managerTokenWith2FA = generateUserTokenWith2FaForManager.set2faForAccount();
        this.manager2FaCode = generateUserTokenWith2FaForManager.manager2FaCode;
    }

    @Test
    private void test(){
        request
                .headers("token", managerTokenWith2FA)
                .post(URL+"payments/uploadFile/1065102")
                .then()
                .assertThat()
                .statusCode(422);
    }

    @AfterClass
    public void afterUpdateUserProfile(){
        request
                .headers("token", managerTokenWith2FA)
                .post(URL+"security/status/disable/" + manager2FaCode)
                .then()
                .assertThat()
                .statusCode(200);
    }
}
