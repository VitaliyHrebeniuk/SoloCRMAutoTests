package com.api.users;

import com.api.users.pojo.auditorUpdateProfileUser.*;
import com.api.users.token2FA.GenerateUserTokenWith2FA;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Demo {
    public static String userTokenWith2FA;
    public static String user2FaCode;
    final static String ROLE_ADMIN = "admin", LOGIN_ADMIN = "admin_API_TEST_";
    final static String ROLE_AUDITOR = "auditor", LOGIN_AUDITOR = "auditor_API_TEST_";
    final static String ROLE_BUYING_CONTROL = "buying_control", LOGIN_BUYING_CONTROL = "buying_control_API_TEST_";
    final static String ROLE_CHIEF = "chief", LOGIN_CHIEF = "chief_API_TEST_";
    final static String ROLE_BUYING_CM = "cm", LOGIN_CM = "cm_API_TEST_";
    final static String ROLE_CONTROL = "control", LOGIN_CONTROL = "control_API_TEST_";
    final static String ROLE_FIN_CONTROL = "fincontrol", LOGIN_FIN_CONTROL = "fin_control_API_TEST_";
    final static String ROLE_FS = "fs", LOGIN_FS = "fs_API_TEST_";
    final static String ROLE_HEAD_CONTROL = "head_control", LOGIN_HEAD_CONTROL = "head_control_API_TEST_";
    final static String ROLE_MANAGER = "manager", LOGIN_MANAGER = "manager_API_TEST_";
    final static String ROLE_SEARCHER = "searcher", LOGIN_SEARCHER = "searcher_API_TEST_";
    final static String ROLE_SPAMER = "spamer", LOGIN_SPAMER = "spamer_API_TEST_";
    final static String ROLE_TEAMLEAD = "teamlead", LOGIN_TEAMLEAD = "teamlead_API_TEST_";
    final static String PASSWORD = "132465798";
    final static String NAME = "admin_qa";
    final static String TELEGRAM = "API_TEST";
    final static String STATUS = "active";
    final static Integer BID = 84;
    final static String TEAM = "";
    final static String[] SEO_PROJECTS = {};
    final static String[] BUYER_DEALS = {};
    final static String[] TAGS = {};
    final static boolean BUYING_ACCESS = true;
    final static boolean BUYING_CONTROL_RATING = false;
    final static boolean BUYING_CONTROL_SMS = false;
    final static boolean BUYING_CONTROL_REOPEN = false;
    final static boolean BUYING_CONTROL_RS = false;
    final static boolean CLIENT_STAT_UPLOAD = false;
    final static boolean IMPORT_ACCESS = false;
    final static boolean LG_ACCESS = true;
    final static boolean OFFLINE_ACCESS = true;
    final static boolean RESULT_ACCESS = true;
    final static boolean RETENTION_ACCESS = true;
    final static boolean SEO_ACCESS = true;
    final static boolean OPERATION_STATS_ACCESS = false;
    final static boolean AGENT_ACCESS = false;
    static List<Object> emptyList = Collections.emptyList();


    private static String generateRandomNumber(){
        double a = 20 + Math.random()*40;
        return String.valueOf(a);
    }
    public List<MainRoot> getCaseModel(){

        Cpi cpi = new Cpi(false,false,false,false,false);
        Cpm cpm = new Cpm(false,false,false,false,false);
        FixApp fixApp = new FixApp(false,false,false,false,false);
        FixB2b fixB2b = new FixB2b(false,false,false,false,false);
        FixRs fixRs = new FixRs(false,false,false,false,false);
        FixSmm fixSmm = new FixSmm(false,false,false,false,false);
        FixWeb fixWeb = new FixWeb(false,false,false,false,false);
        FixZid fixZid = new FixZid(false,false,false,false,false);
        GoogleDocs googleDocs = new GoogleDocs(false,false,false,false,false);
        Offline offline = new Offline(false,false,false,false,false);
        ZidCid zidCid = new ZidCid(false,false,false,false,false);

        ProductDealTypeAccess productDealTypeAccess = new ProductDealTypeAccess();
        productDealTypeAccess.setCpi(cpi);
        productDealTypeAccess.setCpm(cpm);
        productDealTypeAccess.setFix_app(fixApp);
        productDealTypeAccess.setFix_b2b(fixB2b);
        productDealTypeAccess.setFix_rs(fixRs);
        productDealTypeAccess.setFix_smm(fixSmm);
        productDealTypeAccess.setFix_web(fixWeb);
        productDealTypeAccess.setFix_zid(fixZid);
        productDealTypeAccess.setGoogle_docs(googleDocs);
        productDealTypeAccess.setOffline(offline);
        productDealTypeAccess.setZid_cid(zidCid);

        MainRoot mainRoot = new MainRoot();
        mainRoot.setProduct_deal_type_access(productDealTypeAccess);

        List<MainRoot> mainRootList = new ArrayList<>();
        mainRootList.add(mainRoot);

        CaseResult caseResult = new CaseResult();
        caseResult.setRunsList(mainRootList);

        return mainRootList;
    }
    public static void main(String[] args) {
        //Requset
        RequestSpecification request = RestAssured.given();
        //GsonBuilderFor
        Gson g = new GsonBuilder().setPrettyPrinting().create();
        Demo demo = new Demo();
        //Generate TokenWith2FA
        GenerateUserTokenWith2FA generateUserTokenWith2FA = new GenerateUserTokenWith2FA();
        userTokenWith2FA = generateUserTokenWith2FA.set2faForAccount();

         Response response = request
                .headers("token", userTokenWith2FA)
                .headers("Contet-Type","application/json;charset=utf-8")
                .param("user_id", 425)
                .param("login", LOGIN_AUDITOR)
                .param("role", ROLE_AUDITOR)
                .param("email", LOGIN_AUDITOR + generateRandomNumber())
                .param("password",PASSWORD)
                .param("bid_id", BID)
                .queryParams("product_deal_type_access",demo.getCaseModel())
                .post("https://beta-api.solo-crm.com/users/425");

        System.out.println(g.toJson(demo.getCaseModel()));
    }
}
