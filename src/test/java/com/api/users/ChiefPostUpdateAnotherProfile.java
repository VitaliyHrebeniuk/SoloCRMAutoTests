package com.api.users;

import com.api.users.pojo.ProfileUser.*;
import com.api.users.token2FA.GenerateUserTokenWith2FaForChief;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ChiefPostUpdateAnotherProfile {
    public String chiefTokenWith2FA;
    public String chief2FaCode;
    RequestSpecification request = RestAssured.given();
    private final String URL = "https://beta-api.solo-crm.com/";

    @BeforeClass()
    private void beforeUpdateUserProfile(){
        GenerateUserTokenWith2FaForChief generateUserTokenWith2FaForChief = new GenerateUserTokenWith2FaForChief();
        this.chiefTokenWith2FA = generateUserTokenWith2FaForChief.set2faForAccount();
        this.chief2FaCode = generateUserTokenWith2FaForChief.chief2FaCode;

    }
    @Test(priority = -1)
    public void postUpdateProfileAuditor(){
        AuditorProfilePojo auditorProfilePojo = new AuditorProfilePojo();
        request
                .headers("token", chiefTokenWith2FA)
                .headers("Contet-Type","application/json;charset=utf-8")
                .param("user_id", auditorProfilePojo.getUser_id())
                .param("login", auditorProfilePojo.getLogin())
                .param("email", auditorProfilePojo.getEmail())
                .param("password",auditorProfilePojo.getPassword())
                .param("status", auditorProfilePojo.getStatus())
                .param("bid_id", auditorProfilePojo.getBid())
                .post("https://beta-api.solo-crm.com/users/" + auditorProfilePojo.getUser_id())
                .then()
                .assertThat()
                .statusCode(200);
    }
    @Test(priority = -1)
    public void postUpdateProfileBuyingControl(){
        BuyingControlProfilePojo buyingControlProfilePojo = new BuyingControlProfilePojo();
        request
                .headers("token", chiefTokenWith2FA)
                .param("login", buyingControlProfilePojo.getLogin())
                .param("email", buyingControlProfilePojo.getEmail())
                .param("password",buyingControlProfilePojo.getPassword())
                .param("status", buyingControlProfilePojo.getStatus())
                .param("bid_id", buyingControlProfilePojo.getBid())
                .post("https://beta-api.solo-crm.com/users/" + buyingControlProfilePojo.getUser_id())
                .then()
                .assertThat()
                .statusCode(200);
    }
    @Test(priority = -1)
    public void postUpdateProfileChief(){
        ChiefProfilePojo chiefProfilePojo = new ChiefProfilePojo();
        request
                .headers("token", chiefTokenWith2FA)
                .param("login",chiefProfilePojo.getLogin() )
                .param("email", chiefProfilePojo.getEmail())
                .param("password",chiefProfilePojo.getPassword())
                .param("status", chiefProfilePojo.getStatus())
                .param("bid_id", chiefProfilePojo.getBid())
                .param("telegram_notification", 0)
                .post("https://beta-api.solo-crm.com/users/" + chiefProfilePojo.getUser_id())
                .then()
                .assertThat()
                .statusCode(200);
    }
    @Test(priority = -1)
    public void postUpdateProfileСm(){
        CmProfilePojo cmProfilePojo = new CmProfilePojo();
        request
                .headers("token", chiefTokenWith2FA)
                .param("login",cmProfilePojo.getLogin() )
                .param("role", cmProfilePojo.getRole())
                .param("email", cmProfilePojo.getEmail())
                .param("password",cmProfilePojo.getPassword())
                .param("status", cmProfilePojo.getStatus())
                .param("bid_id", cmProfilePojo.getBid())
                .param("telegram_notification", 0)
                .post("https://beta-api.solo-crm.com/users/" + cmProfilePojo.getUser_id())
                .then()
                .assertThat()
                .statusCode(200);
    }
    @Test(priority = -1)
    public void postUpdateProfileСontrol(){
        ControlProfilePojo controlProfilePojo = new ControlProfilePojo();
        request
                .headers("token", chiefTokenWith2FA)
                .param("login",controlProfilePojo.getLogin() )
                .param("email", controlProfilePojo.getEmail())
                .param("password",controlProfilePojo.getPassword())
                .param("status", controlProfilePojo.getStatus())
                .param("bid_id", controlProfilePojo.getBid())
                .param("telegram_notification", 0)
                .post("https://beta-api.solo-crm.com/users/" + controlProfilePojo.getUser_id())
                .then()
                .assertThat()
                .statusCode(200);
    }
    @Test(priority = -1)
    public void postUpdateProfileFinControl(){
        FinControlProfilePojo finControlProfilePojo = new FinControlProfilePojo();
        request
                .headers("token", chiefTokenWith2FA)
                .param("login",finControlProfilePojo.getLogin())
                .param("email", finControlProfilePojo.getEmail())
                .param("password",finControlProfilePojo.getPassword())
                .param("status", finControlProfilePojo.getStatus())
                .param("bid_id", finControlProfilePojo.getBid())
                .param("telegram_notification", 0)
                .post("https://beta-api.solo-crm.com/users/" + finControlProfilePojo.getUser_id())
                .then()
                .assertThat()
                .statusCode(200);
    }
    @Test(priority = -1)
    public void postUpdateProfileFs(){
        FsProfilePojo fsProfilePojo = new FsProfilePojo();
        request
                .headers("token", chiefTokenWith2FA)
                .param("login",fsProfilePojo.getLogin())
                .param("email", fsProfilePojo.getEmail())
                .param("password",fsProfilePojo.getPassword())
                .param("status", fsProfilePojo.getStatus())
                .param("bid_id", fsProfilePojo.getBid())
                .param("telegram_notification", 0)
                .post("https://beta-api.solo-crm.com/users/" + fsProfilePojo.getUser_id())
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test(priority = -1)
    public void postUpdateProfileHeadControl(){
        HeadControlProfilePojo headControlProfilePojo = new HeadControlProfilePojo();
        request
                .headers("token", chiefTokenWith2FA)
                .param("login",headControlProfilePojo.getLogin())
                .param("email", headControlProfilePojo.getEmail())
                .param("password",headControlProfilePojo.getPassword())
                .param("status", headControlProfilePojo.getStatus())
                .param("bid_id", headControlProfilePojo.getBid())
                .param("telegram_notification", 0)
                .post("https://beta-api.solo-crm.com/users/" + headControlProfilePojo.getUser_id())
                .then()
                .assertThat()
                .statusCode(200);
    }
    @Test(priority = -1)
    public void postUpdateProfileSearcher(){
        SearcherProfilePojo searcherProfilePojo = new SearcherProfilePojo();
        request
                .headers("token", chiefTokenWith2FA)
                .param("login",searcherProfilePojo.getLogin())
                .param("email", searcherProfilePojo.getEmail())
                .param("password",searcherProfilePojo.getPassword())
                .param("status", searcherProfilePojo.getStatus())
                .param("bid_id", searcherProfilePojo.getBid())
                .param("telegram_notification", 0)
                .post("https://beta-api.solo-crm.com/users/" + searcherProfilePojo.getUser_id())
                .then()
                .assertThat()
                .statusCode(200);
    }
    @Test(priority = -1)
    public void postUpdateProfileSpamer(){
        SpamerProfilePojo spamerProfilePojo = new SpamerProfilePojo();
        request
                .headers("token", chiefTokenWith2FA)
                .param("login",spamerProfilePojo.getLogin())
                .param("email", spamerProfilePojo.getEmail())
                .param("password",spamerProfilePojo.getPassword())
                .param("status", spamerProfilePojo.getStatus())
                .param("bid_id", spamerProfilePojo.getBid())
                .param("telegram_notification", 0)
                .post("https://beta-api.solo-crm.com/users/" + spamerProfilePojo.getUser_id())
                .then()
                .assertThat()
                .statusCode(200);
    }
    @Test(priority = -1)
    public void postUpdateProfileTeamLead(){
        TeamLeadProfilePojo teamLeadProfilePojo = new TeamLeadProfilePojo();
        request
                .headers("token", chiefTokenWith2FA)
                .param("login",teamLeadProfilePojo.getLogin())
                .param("email", teamLeadProfilePojo.getEmail())
                .param("password",teamLeadProfilePojo.getPassword())
                .param("status", teamLeadProfilePojo.getStatus())
                .param("bid_id", teamLeadProfilePojo.getBid())
                .post("https://beta-api.solo-crm.com/users/" + teamLeadProfilePojo.getUser_id())
                .then()
                .assertThat()
                .statusCode(200);
    }
    @Test(priority = -1)
    public void postUpdateProfileHeadManager(){
        ManagerProfilePojo managerProfilePojo = new ManagerProfilePojo();
        request
                .headers("token", chiefTokenWith2FA)
                .param("login",managerProfilePojo.getLogin())
                .param("email", managerProfilePojo.getEmail())
                .param("password",managerProfilePojo.getPassword())
                .param("status", managerProfilePojo.getStatus())
                .param("bid_id", managerProfilePojo.getBid())
                .param("telegram_notification", 0)
                .post("https://beta-api.solo-crm.com/users/" + managerProfilePojo.getUser_id())
                .then()
                .assertThat()
                .statusCode(200);
    }
    @Test
    public void backToInitalPostUpdateProfileBuyingControl(){
        BuyingControlProfilePojo buyingControlProfilePojo = new BuyingControlProfilePojo();
        request
                .headers("token", chiefTokenWith2FA)
                .param("login", "buyingControl_TEST_API")
                .param("email", buyingControlProfilePojo.getEmail())
                .param("password",buyingControlProfilePojo.getPassword())
                .param("status", buyingControlProfilePojo.getStatus())
                .param("bid_id", buyingControlProfilePojo.getBid())
                .post("https://beta-api.solo-crm.com/users/" + buyingControlProfilePojo.getUser_id())
                .then()
                .assertThat()
                .statusCode(200);
    }
    @Test
    public void backToInitalPostUpdateProfileChief(){
        ChiefProfilePojo chiefProfilePojo = new ChiefProfilePojo();
        request
                .headers("token", chiefTokenWith2FA)
                .param("login","chief_TEST_API" )
                .param("email", chiefProfilePojo.getEmail())
                .param("password",chiefProfilePojo.getPassword())
                .param("status", chiefProfilePojo.getStatus())
                .param("bid_id", chiefProfilePojo.getBid())
                .param("telegram_notification", 0)
                .post("https://beta-api.solo-crm.com/users/" + chiefProfilePojo.getUser_id())
                .then()
                .assertThat()
                .statusCode(200);
    }
    @Test
    public void backToInitalPostUpdateProfileCm(){
        CmProfilePojo cmProfilePojo = new CmProfilePojo();
        request
                .headers("token", chiefTokenWith2FA)
                .param("login","cm_TEST_API" )
                .param("email", cmProfilePojo.getEmail())
                .param("password",cmProfilePojo.getPassword())
                .param("status", cmProfilePojo.getStatus())
                .param("bid_id", cmProfilePojo.getBid())
                .param("telegram_notification", 0)
                .post("https://beta-api.solo-crm.com/users/" +cmProfilePojo.getUser_id())
                .then()
                .assertThat()
                .statusCode(200);
    }
    @Test
    public void backToInitalPostUpdateProfileControl(){
        ControlProfilePojo controlProfilePojo = new ControlProfilePojo();
        request
                .headers("token", chiefTokenWith2FA)
                .param("login","control_TEST_API" )
                .param("email", controlProfilePojo.getEmail())
                .param("password",controlProfilePojo.getPassword())
                .param("status", controlProfilePojo.getStatus())
                .param("bid_id", controlProfilePojo.getBid())
                .param("telegram_notification", 0)
                .post("https://beta-api.solo-crm.com/users/" + controlProfilePojo.getUser_id())
                .then()
                .assertThat()
                .statusCode(200);
    }
    @Test
    public void backToInitalPostUpdateProfileFinControl(){
        FinControlProfilePojo finControlProfilePojo = new FinControlProfilePojo();
        request
                .headers("token", chiefTokenWith2FA)
                .param("login","finControl_TEST_API")
                .param("email", finControlProfilePojo.getEmail())
                .param("password",finControlProfilePojo.getPassword())
                .param("status", finControlProfilePojo.getStatus())
                .param("bid_id", finControlProfilePojo.getBid())
                .param("telegram_notification", 0)
                .post("https://beta-api.solo-crm.com/users/" + finControlProfilePojo.getUser_id())
                .then()
                .assertThat()
                .statusCode(200);
    }
    @Test
    public void backToInitalPostUpdateProfileFs(){
        FsProfilePojo fsProfilePojo = new FsProfilePojo();
        request
                .headers("token", chiefTokenWith2FA)
                .param("login","fs_TEST_API")
                .param("email", fsProfilePojo.getEmail())
                .param("password",fsProfilePojo.getPassword())
                .param("status", fsProfilePojo.getStatus())
                .param("bid_id", fsProfilePojo.getBid())
                .param("telegram_notification", 0)
                .post("https://beta-api.solo-crm.com/users/" + fsProfilePojo.getUser_id())
                .then()
                .assertThat()
                .statusCode(200);
    }
    @Test
    public void backToInitalPostUpdateProfileHeadControl(){
        HeadControlProfilePojo headControlProfilePojo = new HeadControlProfilePojo();
        request
                .headers("token", chiefTokenWith2FA)
                .param("login","headControl_TEST_API")
                .param("email", headControlProfilePojo.getEmail())
                .param("password",headControlProfilePojo.getPassword())
                .param("status", headControlProfilePojo.getStatus())
                .param("bid_id", headControlProfilePojo.getBid())
                .param("telegram_notification", 0)
                .post("https://beta-api.solo-crm.com/users/" + headControlProfilePojo.getUser_id())
                .then()
                .assertThat()
                .statusCode(200);
    }
    @Test
    public void backToInitalPostUpdateProfileSearcher(){
        SearcherProfilePojo searcherProfilePojo = new SearcherProfilePojo();
        request
                .headers("token", chiefTokenWith2FA)
                .param("login","searcher_TEST_API")
                .param("email", searcherProfilePojo.getEmail())
                .param("password",searcherProfilePojo.getPassword())
                .param("status", searcherProfilePojo.getStatus())
                .param("bid_id", searcherProfilePojo.getBid())
                .param("telegram_notification", 0)
                .post("https://beta-api.solo-crm.com/users/" + searcherProfilePojo.getUser_id())
                .then()
                .assertThat()
                .statusCode(200);
    }
    @Test
    public void backToInitalPostUpdateProfileSpamer(){
        SpamerProfilePojo spamerProfilePojo = new SpamerProfilePojo();
        request
                .headers("token", chiefTokenWith2FA)
                .param("login","spamer_TEST_API" )
                .param("login",spamerProfilePojo.getLogin())
                .param("email", spamerProfilePojo.getEmail())
                .param("password",spamerProfilePojo.getPassword())
                .param("status", spamerProfilePojo.getStatus())
                .param("bid_id", spamerProfilePojo.getBid())
                .post("https://beta-api.solo-crm.com/users/" + spamerProfilePojo.getUser_id())
                .then()
                .assertThat()
                .statusCode(200);
    }
    @Test
    public void backToInitalPostUpdateProfileTeamLead(){
        TeamLeadProfilePojo teamLeadProfilePojo = new TeamLeadProfilePojo();
        request
                .headers("token", chiefTokenWith2FA)
                .param("login","teamLead_TEST_API" )
                .param("login",teamLeadProfilePojo.getLogin())
                .param("email", teamLeadProfilePojo.getEmail())
                .param("password",teamLeadProfilePojo.getPassword())
                .param("status", teamLeadProfilePojo.getStatus())
                .param("bid_id", teamLeadProfilePojo.getBid())
                .param("telegram_notification", 0)
                .post("https://beta-api.solo-crm.com/users/" + teamLeadProfilePojo.getUser_id())
                .then()
                .assertThat()
                .statusCode(200);
    }
    @Test
    public void backToInitalPostUpdateProfileManager(){
        ManagerProfilePojo managerProfilePojo = new ManagerProfilePojo();
        request
                .headers("token", chiefTokenWith2FA)
                .param("login","manager_TEST_API")
                .param("email", managerProfilePojo.getEmail())
                .param("password",managerProfilePojo.getPassword())
                .param("status", managerProfilePojo.getStatus())
                .param("bid_id", managerProfilePojo.getBid())
                .param("telegram_notification", 0)
                .post("https://beta-api.solo-crm.com/users/" + managerProfilePojo.getUser_id())
                .then()
                .assertThat()
                .statusCode(200);
    }
    @Test
    public void backToInitalPostUpdateProfileAuditor(){
        AuditorProfilePojo auditorProfilePojo = new AuditorProfilePojo();
        request
                .headers("token", chiefTokenWith2FA)
                .param("login", "auditor_TEST_API")
                .param("user_id", auditorProfilePojo.getUser_id())
                .param("login", auditorProfilePojo.getLogin())
                .param("email", auditorProfilePojo.getEmail())
                .param("password",auditorProfilePojo.getPassword())
                .param("status", auditorProfilePojo.getStatus())
                .param("bid_id", auditorProfilePojo.getBid())
                .post("https://beta-api.solo-crm.com/users/" + auditorProfilePojo.getUser_id())
                .then()
                .assertThat()
                .statusCode(200);
    }

    @AfterClass
    public void afterUpdateUserProfile(){
        request
                .headers("token", chiefTokenWith2FA)
                .post("https://beta-api.solo-crm.com/security/status/disable/" + chief2FaCode)
                .then()
                .assertThat()
                .statusCode(200);
    }
}
