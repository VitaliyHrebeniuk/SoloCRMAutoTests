package com.api.users;

import com.api.users.token2FA.GenerateUserTokenWith2FA;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.HashMap;

import static javafx.scene.AccessibleAttribute.ROLE;


public class UserAdminPostUpdateSelfProfile {
    public String userTokenWith2FA;
    public String user2FaCode;
    RequestSpecification request = RestAssured.given();
    final String LOGIN = "admin_TEST";
    final String PASSWORD = "132465798";
    final String NAME = "admin_qa";
    final String EMAIL = "admin_qa_qa@gmail.com";
    final String TELEGRAM = "VitaliyQA";
    final String STATUS = "active";
    final Integer BID = 84;
    final String TEAM = "";
    final String[] SEO_PROJECTS = {};
    final String[] TAGS = {};
    final boolean BUYING_ACCESS = true;
    final boolean BUYING_CONTROL_RATING = false;
    final boolean BUYING_CONTROL_SMS = false;
    final boolean BUYING_CONTROL_REOPEN = false;
    final boolean BUYING_CONTROL_RS = false;
    final boolean CLIENT_STAT_UPLOAD = false;
    final boolean IMPORT_ACCESS = false;
    final boolean LG_ACCESS = true;
    final boolean OFFLINE_ACCESS = true;
    final boolean RESULT_ACCESS = true;
    final boolean RETENTION_ACCESS = true;
    final boolean SEO_ACCESS = true;
    final boolean OPERATION_STATS_ACCESS = false;
    final boolean AGENT_ACCESS = false;
    final HashMap<String, Boolean> cpiProductAcces = new HashMap<>(5);
    final HashMap<String, Boolean> cpmProductAcces = new HashMap<>(5);
    final HashMap<String, Boolean> fixAppProductAcces = new HashMap<>(5);
    final HashMap<String, Boolean> fixB2bProductAcces = new HashMap<>(5);
    final HashMap<String, Boolean> fixRSProductAcces = new HashMap<>(5);
    final HashMap<String, Boolean> fixSmmProductAcces = new HashMap<>(5);
    final HashMap<String, Boolean> fixWebProductAcces = new HashMap<>(5);
    final HashMap<String, Boolean> fixZidProductAcces = new HashMap<>(5);
    final HashMap<String, Boolean> googleDocsProductAcces = new HashMap<>(5);
    final HashMap<String, Boolean> offlineProductAcces = new HashMap<>(5);
    final HashMap<String, Boolean> zidCidProductAcces = new HashMap<>(5);
    final String[] numbers = {"1_", "2_", "3_", "4_", "5_"};


    @BeforeMethod
    private void beforeUpdateProfileAdmin(){
        GenerateUserTokenWith2FA generateUserTokenWith2FA = new GenerateUserTokenWith2FA();
        this.userTokenWith2FA = generateUserTokenWith2FA.set2faForAccount();
        this.user2FaCode = generateUserTokenWith2FA.get2FaCode;
        for (String number : numbers) {
            cpiProductAcces.put(number, false);
            cpmProductAcces.put(number, false);
            fixAppProductAcces.put(number, false);
            fixB2bProductAcces.put(number, false);
            fixRSProductAcces.put(number, false);
            fixSmmProductAcces.put(number, false);
            fixWebProductAcces.put(number, false);
            fixZidProductAcces.put(number, false);
            googleDocsProductAcces.put(number, false);
            offlineProductAcces.put(number, false);
            zidCidProductAcces.put(number, false);
        }
    }

    @Test
    public void postUpdateProfileAdmin(){
        request
                .headers("token", userTokenWith2FA)
                .param("login", LOGIN)
                .param("name", NAME)
                .param("role", ROLE)
                .param("email", EMAIL)
                .param("telegram", TELEGRAM)
                .param("password",PASSWORD)
                .param("status", STATUS)
                .param("bid_id", BID)
                .param("team", TEAM)
                .param("telegram_notification", 0)
                .param("seo_project_ids", (Object[]) SEO_PROJECTS)
                .param("tags", (Object[]) TAGS)
                .param("buying", BUYING_ACCESS)
                .param("buying_control_rating", BUYING_CONTROL_RATING)
                .param("buying_control_sms", BUYING_CONTROL_SMS)
                .param("buying_control_reopen", BUYING_CONTROL_REOPEN)
                .param("buying_control_rs", BUYING_CONTROL_RS)
                .param("client_stat_upload", CLIENT_STAT_UPLOAD)
                .param("import", IMPORT_ACCESS)
                .param("lg", LG_ACCESS)
                .param("offline", OFFLINE_ACCESS)
                .param("result_access", RESULT_ACCESS)
                .param("retention", RETENTION_ACCESS)
                .param("seo_access", SEO_ACCESS)
                .param("operation_stats", OPERATION_STATS_ACCESS)
                .param("agent",AGENT_ACCESS)
                .param("product_deal_type_access",
                            cpiProductAcces,
                            cpmProductAcces,
                            fixAppProductAcces,
                            fixB2bProductAcces,
                            fixRSProductAcces,
                            fixSmmProductAcces,
                            fixWebProductAcces,
                            fixZidProductAcces,
                            googleDocsProductAcces,
                            offlineProductAcces,
                            zidCidProductAcces)
                .post("https://beta-api.solo-crm.com/profile")
                .then()
                .assertThat()
                .statusCode(200);
    }

    @AfterMethod
    public void afterUpdateUserProfile(){
        request
                .headers("token", userTokenWith2FA)
                .post("https://beta-api.solo-crm.com/security/status/disable/" + user2FaCode)
                .then()
                .assertThat()
                .statusCode(200);
    }


}
