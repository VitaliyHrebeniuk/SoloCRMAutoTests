package com.api.leads;

import com.api.BaseURL;
import com.api.token2FA.GenerateUserTokenWith2FaForAdmin;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AdminPostLeadsUpdate {
    public String userTokenWith2FA;
    public String user2FaCode;
    RequestSpecification request = RestAssured.given();
    BaseURL baseURL = new BaseURL();
    final String URL = baseURL.baseURL;

    private String generateRandomNumber(){
        double a = 20 + Math.random()*40;
        return String.valueOf(a);
    }

    @BeforeClass
    private void beforeUpdateProfileAdmin() {
        GenerateUserTokenWith2FaForAdmin generateUserTokenWith2FAForAdmin = new GenerateUserTokenWith2FaForAdmin();
        this.userTokenWith2FA = generateUserTokenWith2FAForAdmin.set2faForAccount();
        this.user2FaCode = generateUserTokenWith2FAForAdmin.admin2FaCode;
    }

    @Test
    private void test(){
        request
                .headers("token", userTokenWith2FA)
                .param("link", "https://beta.sol" + generateRandomNumber() +"-crm.com")
                .param("country_id", 1)
                .param("source_type_id",1)
                .param("source_category_id",1)
                .param("traffic", 123)
                .param("leadId", 1069914)
                .param("tagList[]", 1)
                .param("approveClose", 1)
                .post(URL+"leads/update")
                .then()
                .assertThat()
                .statusCode(200);
    }

    @AfterClass
    public void afterUpdateUserProfile(){
        request
                .headers("token", userTokenWith2FA)
                .post(URL+"security/status/disable/" + user2FaCode)
                .then()
                .assertThat()
                .statusCode(200);
    }
}
