package com.api.payments;

import com.api.BaseURL;
import com.api.token2FA.GenerateUserTokenWith2FaForAdmin;
import com.api.token2FA.GenerateUserTokenWith2FaForFs;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FsPostUploadFile {
    public String userTokenWith2FA;
    public String user2FaCode;
    RequestSpecification request = RestAssured.given();
    BaseURL baseURL = new BaseURL();
    final String URL = baseURL.baseURL;

    @BeforeClass
    private void beforeUpdateProfileAdmin() {
        GenerateUserTokenWith2FaForFs generateUserTokenWith2FaForFs = new GenerateUserTokenWith2FaForFs();
        this.userTokenWith2FA = generateUserTokenWith2FaForFs.set2faForAccount();
        this.user2FaCode = generateUserTokenWith2FaForFs.fs2FaCode;
    }

    @Test
    private void test(){
        request
                .headers("token", userTokenWith2FA)
                .post(URL+"payments/uploadFile/1065102")
                .then()
                .assertThat()
                .statusCode(422);
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
