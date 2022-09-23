package com.api.leads;

import com.api.BaseURL;
import com.api.token2FA.GenerateUserTokenWith2FaForManager;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ManagerPostLeadMassAction {
    public String managerTokenWith2FA;
    public String manager2FaCode;
    RequestSpecification request = RestAssured.given();
    BaseURL baseURL = new BaseURL();
    final String URL = baseURL.baseURL;

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
                .param("group_by","country")
                .param("country_ids",1)
                .param("xls",1)
                .get(URL+"leads/report")
                .then()
                .assertThat()
                .statusCode(200);
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
