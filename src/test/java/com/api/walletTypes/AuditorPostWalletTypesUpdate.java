package com.api.walletTypes;

import com.api.BaseURL;
import com.api.token2FA.GenerateUserTokenWith2FaForAuditor;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AuditorPostWalletTypesUpdate {
    public String userTokenWith2FA;
    public String user2FaCode;
    RequestSpecification request = RestAssured.given();
    BaseURL baseURL = new BaseURL();
    final String URL = baseURL.baseURL;

    @BeforeClass
    private void beforeUpdateProfileAuditor() {
        GenerateUserTokenWith2FaForAuditor generateUserTokenWith2FaForAuditor = new GenerateUserTokenWith2FaForAuditor();
        this.userTokenWith2FA = generateUserTokenWith2FaForAuditor.set2faForAccount();
        this.user2FaCode = generateUserTokenWith2FaForAuditor.auditor2FaCode;
    }

    @Test
    private void test(){
        request
                .headers("token", userTokenWith2FA)
                .post(URL + "wallet/types/update/45")
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
