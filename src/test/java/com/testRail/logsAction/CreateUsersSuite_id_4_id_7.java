package com.testRail.logsAction;

import com.TestRails;
import com.testRail.APIClient;
import com.testRail.APIException;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class CreateUsersSuite_id_4_id_7 {
    /**
     * Чтобы можно было отправлять запросы Апишки
     */
    RequestSpecification request = RestAssured.given();
    /**
     * Admin
     */
    public String userTokenWith2FA;
    public String user2FaCode;
    /**
     * TL
     */
    public String teamLeadTokenWith2FA;
    public String teamLead2FaCode;
    /**
     * Chief
     */
    public String chiefTokenWith2FA;
    public String chief2FaCode;
    /**
     * Manager
     */
    public String managerTokenWith2FA;
    public String manager2FaCode;
    /**
     * Auditor
     */
    public String auditorTokenWith2FA;
    public String auditor2FaCode;
    /**
     * Buying Control
     */
    public String buyingControlTokenWith2FA;
    public String buyingControl2FaCode;
    /**
     * CM
     */
    public String cmWith2FA;
    public String cm2FaCode;
    /**
     * Control
     */
    public String controlWith2FA;
    public String control2FaCode;
    /**
     * Fin Control
     */
    public String finControlWith2FA;
    public String finControl2FaCode;
    /**
     * FS
     */
    public String fsWith2FA;
    public String fs2FaCode;
    /**
     * Head Control
     */
    public String headControlTokenWith2FA;
    public String headControl2FaCode;
    /**
     * Retention Manager
     */
    public String retentionManagerTokenWith2FA;
    public String retentionManager2FaCode;
    /**
     * Retention Team Lead
     */
    public String retentionTeamLeadTokenWith2FA;
    public String retentionTeamLead2FaCode;
    /**
     * Searcher
     */
    public String searcherTokenWith2FA;
    public String searcher2FaCode;
    /**
     * Spamer
     */
    public String spamerTokenWith2FA;
    public String spamer2FaCode;

    /**
     * Инфа для ТестРейл
     */
    String PROJECT_ID = "1";
    APIClient client = null;

    @BeforeSuite
    public void createSuite(ITestContext ctx) throws IOException, APIException {
        client = new APIClient("https://solocrmtest.testrail.io");
        client.setUser("vitaliy.hrebeniuk.qa@gmail.com");
        client.setPassword("3513355dD!");
        Map data = new HashMap();
        data.put("include_all",true);
        data.put("name","Login Valid Suite "+System.currentTimeMillis());
        data.put("suite_id",17);
        JSONObject c;
        c = (JSONObject)client.sendPost("add_run/"+PROJECT_ID,data);
        Long suite_id = (Long)c.get("id");
        ctx.setAttribute("suiteId",suite_id);
    }

    @BeforeMethod
    public void beforeTest(ITestContext ctx, Method method) throws NoSuchMethodException {
        Method m = CreateUsersSuite_id_4_id_7.class.getMethod(method.getName());

        if (m.isAnnotationPresent(TestRails.class)) {
            TestRails ta = m.getAnnotation(TestRails.class);
            System.out.println(ta.id());
            ctx.setAttribute("caseId",ta.id());
        }
    }
    @TestRails(id="134")
    @Test
    public void	adminCreateUserAdmin() {}
    @TestRails(id="135")
    @Test
    public void adminCreateUserAuditor() {}
    @TestRails(id="136")
    @Test
    public void adminCreateUserBuyingControl() {}
    @TestRails(id="137")
    @Test
    public void adminCreateUserChief() {}
    @TestRails(id="138")
    @Test
    public void adminCreateUserCm() {}
    @TestRails(id="139")
    @Test
    public void adminCreateUserControl() {}
    @TestRails(id="140")
    @Test
    public void adminCreateUserFinControl() {}
    @TestRails(id="141")
    @Test
    public void adminCreateUserFs() {}
    @TestRails(id="142")
    @Test
    public void adminCreateUserHeadControl() {}
    @TestRails(id="143")
    @Test
    public void adminCreateUserManager() {}
    @TestRails(id="144")
    @Test
    public void adminCreateUserRetentionManager() {}
    @TestRails(id="145")
    @Test
    public void adminCreateUserRetentionTeamLead() {}
    @TestRails(id="146")
    @Test
    public void adminCreateUserSearcher() {}
    @TestRails(id="147")
    @Test
    public void adminCreateUserSpamer() {}
    @TestRails(id="148")
    @Test
    public void adminCreateUserTeamLead() {}
    @TestRails(id="149")
    @Test
    public void chiefCreateUserAuditor() {}
    @TestRails(id="150")
    @Test
    public void chiefCreateUserCm() {}
    @TestRails(id="151")
    @Test
    public void chiefCreateUserControl() {}
    @TestRails(id="152")
    @Test
    public void chiefCreateUserFs() {}
    @TestRails(id="153")
    @Test
    public void chiefCreateUserHeadControl() {}
    @TestRails(id="154")
    @Test
    public void chiefCreateUserManager() {}
    @TestRails(id="155")
    @Test
    public void chiefCreateUserRetentionManager() {}
    @TestRails(id="156")
    @Test
    public void chiefCreateUserRetentionTeamLead() {}
    @TestRails(id="157")
    @Test
    public void chiefCreateUserSearcher() {}
    @TestRails(id="158")
    @Test
    public void chiefCreateUserSpamer() {}
    @TestRails(id="159")
    @Test
    public void chiefCreateUserTeamLead() {}
    @TestRails(id="160")
    @Test
    public void teamLeadCreateUserControl() {}
    @TestRails(id="161")
    @Test
    public void teamLeadCreateUserManager() {}
    @TestRails(id="162")
    @Test
    public void teamLeadCreateUserSearcher() {}
    @TestRails(id="163")
    @Test
    public void teamLeadCreateUserSpamer() {}
    @TestRails(id="164")
    @Test
    public void teamLeadCreateUserTeamLead() {}

    @AfterMethod
    public void afterTest(ITestResult result, ITestContext ctx) throws IOException, APIException {
        Map data = new HashMap();
        if(result.isSuccess()) {
            data.put("status_id",1);
        }
        else {
            data.put("status_id", 5);
            data.put("comment", result.getThrowable().toString());
        }

        String caseId = (String)ctx.getAttribute("caseId");
        Long suiteId = (Long)ctx.getAttribute("suiteId");
        client.sendPost("add_result_for_case/"+suiteId+"/"+caseId,data);

    }

}
