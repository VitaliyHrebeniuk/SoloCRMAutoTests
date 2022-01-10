package com.api.users;

import com.api.token2FA.GenerateUserTokenWith2FaForTeamLead;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.*;

public class TeamLeadGetUsersProfile {
    public String teamLeadTokenWith2FA;
    public String teamLead2FaCode;
    RequestSpecification request = RestAssured.given();
    final String URL = "https://test-api.solo-crm.com/";

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
                .get(URL +"users")
                .then()
                .assertThat()
                .statusCode(200);
    }
    @AfterClass
    public void afterGetProfile(){
        request
                .headers("token", teamLeadTokenWith2FA)
                .post(URL + "security/status/disable/" + teamLead2FaCode)
                .then()
                .assertThat()
                .statusCode(200);
    }
}
