package com.api.partners.users;

import com.api.BaseURL;
import com.api.token2FA.GenerateUserTokenWith2FaForTeamLead;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.*;

public class TeamLeadGetUserProfile {
    public String teamLeadTokenWith2FA;
    public String teamLead2FaCode;
    RequestSpecification request = RestAssured.given();
    BaseURL baseURL = new BaseURL();
    final String URL = baseURL.baseURL;

    @BeforeClass
    private void beforeGetProfile() {
        GenerateUserTokenWith2FaForTeamLead generateUserTokenWith2FaForTeamLead = new GenerateUserTokenWith2FaForTeamLead();
        this.teamLeadTokenWith2FA = generateUserTokenWith2FaForTeamLead.set2faForAccount();
        this.teamLead2FaCode = generateUserTokenWith2FaForTeamLead.teamLead2FaCode;
    }

    @Test
    private void getUserProfile(){
        request
                .headers("token", teamLeadTokenWith2FA)
                .get(URL+"users/887")
                .then()
                .assertThat()
                .statusCode(200);
    }

    @AfterClass
    public void afterGetProfile(){
        request
                .headers("token", teamLeadTokenWith2FA)
                .post(URL+"security/status/disable/" + teamLead2FaCode)
                .then()
                .assertThat()
                .statusCode(200);
    }
}
