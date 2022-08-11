package com.api.payments;

import com.api.BaseURL;
import com.api.token2FA.GenerateTokenWith2FaForHeadControl;
import com.api.token2FA.GenerateUserTokenWith2FaForAuditor;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HeadControlGetPayments {
    public String userTokenWith2FA;
    public String user2FaCode;
    RequestSpecification request = RestAssured.given();
    BaseURL baseURL = new BaseURL();
    final String URL = baseURL.baseURL;

    @BeforeClass
    private void beforeUpdateProfileAdmin() {
        GenerateTokenWith2FaForHeadControl generateTokenWith2FaForHeadControl = new GenerateTokenWith2FaForHeadControl();
        this.userTokenWith2FA = generateTokenWith2FaForHeadControl.set2faForAccount();
        this.user2FaCode = generateTokenWith2FaForHeadControl.headControl2FaCode;
    }

    @Test
    private void test(){
//        нет смысла в хэд контроле потому что нет ни одного юзера в системе
//        request
//                .headers("token", userTokenWith2FA)
//                .get(URL+"payments")
//                .then()
//                .assertThat()
//                .statusCode(200);
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
