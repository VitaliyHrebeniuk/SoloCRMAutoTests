package com.api.users;

import com.api.users.token2FA.GenerateUserTokenWith2FA;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static javafx.scene.AccessibleAttribute.ROLE;

public class UserAdminPostUpdateAnotherProfile {
    public String userTokenWith2FA;
    public String user2FaCode;
    RequestSpecification request = RestAssured.given();
    final String ROLE_ADMIN = "admin", LOGIN_ADMIN = "admin_API_TEST_";
    final String ROLE_AUDITOR = "auditor", LOGIN_AUDITOR = "auditor_API_TEST_";
    final String ROLE_BUYING_CONTROL = "buying_control", LOGIN_BUYING_CONTROL = "buying_control_API_TEST_";
    final String ROLE_CHIEF = "chief", LOGIN_CHIEF = "chief_API_TEST_";
    final String ROLE_BUYING_CM = "cm", LOGIN_CM = "cm_API_TEST_";
    final String ROLE_CONTROL = "control", LOGIN_CONTROL = "control_API_TEST_";
    final String ROLE_FIN_CONTROL = "fincontrol", LOGIN_FIN_CONTROL = "fin_control_API_TEST_";
    final String ROLE_FS = "fs", LOGIN_FS = "fs_API_TEST_";
    final String ROLE_HEAD_CONTROL = "head_control", LOGIN_HEAD_CONTROL = "head_control_API_TEST_";
    final String ROLE_MANAGER = "manager", LOGIN_MANAGER = "manager_API_TEST_";
    final String ROLE_SEARCHER = "searcher", LOGIN_SEARCHER = "searcher_API_TEST_";
    final String ROLE_SPAMER = "spamer", LOGIN_SPAMER = "spamer_API_TEST_";
    final String ROLE_TEAMLEAD = "teamlead", LOGIN_TEAMLEAD = "teamlead_API_TEST_";
    final String PASSWORD = "132465798";
    final String NAME = "admin_qa";
    final String TELEGRAM = "API_TEST";
    final String STATUS = "active";
    final Integer BID = 84;
    final String TEAM = "";
    final String[] SEO_PROJECTS = {};
    final String[] BUYER_DEALS = {};
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

    final HashMap<String, HashMap<String, Boolean>> cpiProductAcces = new HashMap<>(5);
    final HashMap<String, HashMap<String, Boolean>> cpmProductAcces = new HashMap<>(5);
    final HashMap<String, HashMap<String, Boolean>> fixAppProductAcces = new HashMap<>(5);
    final HashMap<String, HashMap<String, Boolean>> fixB2bProductAcces = new HashMap<>(5);
    final HashMap<String, HashMap<String, Boolean>> fixRSProductAcces = new HashMap<>(5);
    final HashMap<String, HashMap<String, Boolean>> fixSmmProductAcces = new HashMap<>(5);
    final HashMap<String, HashMap<String, Boolean>> fixWebProductAcces = new HashMap<>(5);
    final HashMap<String, HashMap<String, Boolean>> fixZidProductAcces = new HashMap<>(5);
    final HashMap<String, HashMap<String, Boolean>> googleDocsProductAcces = new HashMap<>(5);
    final HashMap<String, HashMap<String, Boolean>> offlineProductAcces = new HashMap<>(5);
    final HashMap<String, HashMap<String, Boolean>> zidCidProductAcces = new HashMap<>(5);

    final HashMap<String, Boolean> cpiProductMap = new HashMap<>(5);
    final HashMap<String, Boolean> cpmProductMap = new HashMap<>(5);
    final HashMap<String, Boolean> fixAppProductMap = new HashMap<>(5);
    final HashMap<String, Boolean> fixB2bProductMap = new HashMap<>(5);
    final HashMap<String, Boolean> fixRSProductMap = new HashMap<>(5);
    final HashMap<String, Boolean> fixSmmProductMap = new HashMap<>(5);
    final HashMap<String, Boolean> fixWebProductMap = new HashMap<>(5);
    final HashMap<String, Boolean> fixZidProductMap = new HashMap<>(5);
    final HashMap<String, Boolean> googleDocsProductMap = new HashMap<>(5);
    final HashMap<String, Boolean> offlineProductMap = new HashMap<>(5);
    final HashMap<String, Boolean> zidCidProductMap = new HashMap<>(5);
    final static HashMap<String, HashMap<String, Boolean>>productDealTypeAccess = new HashMap<>(5);
    private Object jsonProductDealType;

    private String generateRandomNumber(){
        double a = 20 + Math.random()*40;
        return String.valueOf(a);
    }

    @BeforeMethod
    private void beforeUpdateProfileAdmin(){
        GenerateUserTokenWith2FA generateUserTokenWith2FA = new GenerateUserTokenWith2FA();
        this.userTokenWith2FA = generateUserTokenWith2FA.set2faForAccount();
        this.user2FaCode = generateUserTokenWith2FA.get2FaCode;
        productDealTypeAccess.put("cpi",cpiProductMap);
        productDealTypeAccess.put("cpm",cpmProductMap);
        productDealTypeAccess.put("fix_app",fixAppProductMap);
        productDealTypeAccess.put("fix_b2b",fixB2bProductMap);
        productDealTypeAccess.put("fix_rs",fixRSProductMap);
        productDealTypeAccess.put("fix_smm",fixSmmProductMap);
        productDealTypeAccess.put("fix_web",fixWebProductMap);
        productDealTypeAccess.put("fix_zid",fixZidProductMap);
        productDealTypeAccess.put("google_docs",googleDocsProductMap);
        productDealTypeAccess.put("offline",offlineProductMap);
        productDealTypeAccess.put("zid_cid",zidCidProductMap);
        cpiProductMap.put("1_", false);
        cpiProductMap.put("2_", false);
        cpiProductMap.put("3_", false);
        cpiProductMap.put("4_", false);
        cpiProductMap.put("5_", false);
        cpmProductMap.put("1_", false);
        cpmProductMap.put("2_", false);
        cpmProductMap.put("3_", false);
        cpmProductMap.put("4_", false);
        cpmProductMap.put("5_", false);
        fixAppProductMap.put("1_", false);
        fixAppProductMap.put("2_", false);
        fixAppProductMap.put("3_", false);
        fixAppProductMap.put("4_", false);
        fixAppProductMap.put("5_", false);
        fixB2bProductMap.put("1_", false);
        fixB2bProductMap.put("2_", false);
        fixB2bProductMap.put("3_", false);
        fixB2bProductMap.put("4_", false);
        fixB2bProductMap.put("5_", false);
        fixRSProductMap.put("1_", false);
        fixRSProductMap.put("2_", false);
        fixRSProductMap.put("3_", false);
        fixRSProductMap.put("4_", false);
        fixRSProductMap.put("5_", false);
        fixSmmProductMap.put("1_", false);
        fixSmmProductMap.put("2_", false);
        fixSmmProductMap.put("3_", false);
        fixSmmProductMap.put("4_", false);
        fixSmmProductMap.put("5_", false);
        fixWebProductMap.put("1_", false);
        fixWebProductMap.put("2_", false);
        fixWebProductMap.put("3_", false);
        fixWebProductMap.put("4_", false);
        fixWebProductMap.put("5_", false);
        fixZidProductMap.put("1_", false);
        fixZidProductMap.put("2_", false);
        fixZidProductMap.put("3_", false);
        fixZidProductMap.put("4_", false);
        fixZidProductMap.put("5_", false);
        googleDocsProductMap.put("1_", false);
        googleDocsProductMap.put("2_", false);
        googleDocsProductMap.put("3_", false);
        googleDocsProductMap.put("4_", false);
        googleDocsProductMap.put("5_", false);
        offlineProductMap.put("1_", false);
        offlineProductMap.put("2_", false);
        offlineProductMap.put("3_", false);
        offlineProductMap.put("4_", false);
        offlineProductMap.put("5_", false);
        zidCidProductMap.put("1_",false);
        zidCidProductMap.put("2_",false);
        zidCidProductMap.put("3_",false);
        zidCidProductMap.put("4_",false);
        zidCidProductMap.put("5_",false);
        Gson g = new Gson();
        jsonProductDealType = g.toJson(productDealTypeAccess);
    }

    @Test
    public void postUpdateProfileAdmin(){
        request
                .headers("token", userTokenWith2FA)
                .param("login", LOGIN_ADMIN)
                .param("name", NAME)
                .param("role", ROLE_ADMIN)
                .param("email", LOGIN_ADMIN + generateRandomNumber())
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
                .post("https://beta-api.solo-crm.com/users/190")
                .then()
                .assertThat()
                .statusCode(200);
    }
    @Test
    public void postUpdateProfileAuditor(){
        request
                .headers("token", userTokenWith2FA)
                .headers("Contet-Type","application/json;charset=utf-8")
                .param("user_id", 425)
                //.param("buyer_deals", BUYER_DEALS)
                .param("login", LOGIN_AUDITOR)
                .param("name", NAME)
                .param("role", ROLE_AUDITOR)
                .param("email", LOGIN_AUDITOR + generateRandomNumber())
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
                .param("product_deal_type_access", jsonProductDealType)
                .post("https://beta-api.solo-crm.com/users/425")
                .then()
                .assertThat()
                .statusCode(200);
    }
    @Test
    public void postUpdateProfileBuyingControl(){
        request
                .headers("token", userTokenWith2FA)
                .param("login", LOGIN_BUYING_CONTROL)
                .param("name", NAME)
                .param("role", ROLE)
                .param("email", LOGIN_BUYING_CONTROL + generateRandomNumber())
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
                .post("https://beta-api.solo-crm.com/users/1")
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
