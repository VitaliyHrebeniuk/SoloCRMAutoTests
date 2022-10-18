package com.api.login;

import com.APIClient;
import com.APIException;
import com.TestRails;
import com.api.token2FA.GenerateUserTokenWith2FaForAdmin;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class AdminLoginValid
{
    public String userTokenWith2FA;
    public String user2FaCode;
    String PROJECT_ID = "1";
    APIClient client = null;

    @BeforeSuite
    public void createSuite(ITestContext ctx) throws IOException, APIException {
        client = new APIClient("https://solocrmtest.testrail.io");
        client.setUser("vitaliy.hrebeniuk.qa@gmail.com");
        client.setPassword("3513355dD!");
        Map data = new HashMap();
        data.put("include_all",true);
        data.put("name","Test Run "+System.currentTimeMillis());
        data.put("suite_id",5);
        JSONObject c;
        c = (JSONObject)client.sendPost("add_run/"+PROJECT_ID,data);
        Long suite_id = (Long)c.get("id");
        ctx.setAttribute("suiteId",suite_id);
    }

    @BeforeMethod
    public void beforeTest(ITestContext ctx,Method method) throws NoSuchMethodException {
        Method m = AdminLoginValid.class.getMethod(method.getName());

        if (m.isAnnotationPresent(TestRails.class)) {
            TestRails ta = m.getAnnotation(TestRails.class);
            System.out.println(ta.id());
            ctx.setAttribute("caseId",ta.id());
        }
    }
    @TestRails(id="3")
    @Test
    public void validLogin()
    {
        GenerateUserTokenWith2FaForAdmin generateUserTokenWith2FAForAdmin = new GenerateUserTokenWith2FaForAdmin();
        this.userTokenWith2FA = generateUserTokenWith2FAForAdmin.set2faForAccount();
        this.user2FaCode = generateUserTokenWith2FAForAdmin.admin2FaCode;
    }

    @TestRails(id="4")
    @Test
    public void invalidLogin()
    {

    }

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
