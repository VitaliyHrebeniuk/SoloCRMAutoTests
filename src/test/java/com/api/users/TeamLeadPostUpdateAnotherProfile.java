package com.api.users;

import com.api.users.pojo.ProfileUser.*;
import com.api.token2FA.GenerateUserTokenWith2FaForTeamLead;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TeamLeadPostUpdateAnotherProfile {
    public String teamLeadTokenWith2FA;
    public String teamLead2FaCode;
    RequestSpecification request = RestAssured.given();
    private final String URL = "https://test-api.solo-crm.com/";

    @BeforeClass()
    private void beforeUpdateUserProfile(){
        GenerateUserTokenWith2FaForTeamLead generateUserTokenWith2FaForTeamLead = new GenerateUserTokenWith2FaForTeamLead();
        this.teamLeadTokenWith2FA = generateUserTokenWith2FaForTeamLead.set2faForAccount();
        this.teamLead2FaCode = generateUserTokenWith2FaForTeamLead.teamLead2FaCode;

    }
    @Test(priority = -1)
    public void postUpdateProfileTeamLead(){
        TeamLeadProfilePojo teamLeadProfilePojo = new TeamLeadProfilePojo();
        request
                .headers("token", teamLeadTokenWith2FA)
                .param("login",teamLeadProfilePojo.getLogin())
                .param("email", teamLeadProfilePojo.getEmail())
                .param("password",teamLeadProfilePojo.getPassword())
                .param("status", teamLeadProfilePojo.getStatus())
                .param("bid_id", teamLeadProfilePojo.getBid())
                .post(URL+"users/" + teamLeadProfilePojo.getUser_id())
                .then()
                .assertThat()
                .statusCode(200);
    }
    @Test(priority = -1)
    public void postUpdateProfileManager(){
        ManagerProfilePojo managerProfilePojo = new ManagerProfilePojo();
        request
                .headers("token", teamLeadTokenWith2FA)
                .param("login",managerProfilePojo.getLogin())
                .param("email", managerProfilePojo.getEmail())
                .param("password",managerProfilePojo.getPassword())
                .param("status", managerProfilePojo.getStatus())
                .param("bid_id", managerProfilePojo.getBid())
                .param("telegram_notification", 0)
                .post(URL + "users/" +  managerProfilePojo.getUser_id())
                .then()
                .assertThat()
                .statusCode(200);
    }
    @Test
    public void backToInitalPostUpdateProfileTeamLead(){
        TeamLeadProfilePojo teamLeadProfilePojo = new TeamLeadProfilePojo();
        request
                .headers("token", teamLeadTokenWith2FA)
                .param("login","teamLead_TEST_API" )
                .param("login",teamLeadProfilePojo.getLogin())
                .param("email", teamLeadProfilePojo.getEmail())
                .param("password",teamLeadProfilePojo.getPassword())
                .param("status", teamLeadProfilePojo.getStatus())
                .param("bid_id", teamLeadProfilePojo.getBid())
                .param("telegram_notification", 0)
                .post(URL + "users/" +   teamLeadProfilePojo.getUser_id())
                .then()
                .assertThat()
                .statusCode(200);
    }
    @Test
    public void backToInitalPostUpdateProfileManager(){
        ManagerProfilePojo managerProfilePojo = new ManagerProfilePojo();
        request
                .headers("token", teamLeadTokenWith2FA)
                .param("login","manager_TEST_API")
                .param("email", managerProfilePojo.getEmail())
                .param("password",managerProfilePojo.getPassword())
                .param("status", managerProfilePojo.getStatus())
                .param("bid_id", managerProfilePojo.getBid())
                .param("telegram_notification", 0)
                .post(URL + "users/" + managerProfilePojo.getUser_id())
                .then()
                .assertThat()
                .statusCode(200);
    }

    @AfterClass
    public void afterUpdateUserProfile(){
        request
                .headers("token", teamLeadTokenWith2FA)
                .post(URL + "security/status/disable/" + teamLead2FaCode)
                .then()
                .assertThat()
                .statusCode(200);
    }
}
