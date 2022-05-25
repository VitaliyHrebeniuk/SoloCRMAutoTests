package com.api.payments;

import com.api.BaseURL;
import com.api.token2FA.GenerateUserTokenWith2FaForAdmin;
import com.api.token2FA.GenerateUserTokenWith2FaForTeamLead;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TeamLeadPostUploadFile {
    public String teamLeadTokenWith2FA;
    public String teamLead2FaCode;
    RequestSpecification request = RestAssured.given();
    BaseURL baseURL = new BaseURL();
    final String URL = baseURL.baseURL;

    @BeforeClass
    private void beforeUpdateProfileAdmin() {
        GenerateUserTokenWith2FaForTeamLead generateUserTokenWith2FaForTeamLead = new GenerateUserTokenWith2FaForTeamLead();
        this.teamLeadTokenWith2FA = generateUserTokenWith2FaForTeamLead.set2faForAccount();
        this.teamLead2FaCode = generateUserTokenWith2FaForTeamLead.teamLead2FaCode;
    }

    @Test
    private void test(){
        request
                .headers("token", teamLeadTokenWith2FA)
                .post(URL+"payments/uploadFile/1065102")
                .then()
                .assertThat()
                .statusCode(422);
    }

    @AfterClass
    public void afterUpdateUserProfile(){
        request
                .headers("token", teamLeadTokenWith2FA)
                .post(URL+"security/status/disable/" + teamLead2FaCode)
                .then()
                .assertThat()
                .statusCode(200);
    }
}
