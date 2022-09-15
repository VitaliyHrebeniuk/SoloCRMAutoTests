package com.api.partners.users;

import com.api.BaseURL;
import com.api.token2FA.GenerateUserTokenWith2FaForAdmin;
import com.api.token2FA.GenerateUserTokenWith2FaForManager;
import com.ui.token2Fa.GenerateUserTokenWith2FaForManagerUI;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AdminDisable2Fa {

    public String managerTokenWith2FA;
    public String manager2FaCode;
    public String userTokenWith2FA;
    public String user2FaCode;
    RequestSpecification request = RestAssured.given();
    BaseURL baseURL = new BaseURL();
    final String URL = baseURL.baseURL;


    @BeforeClass
    private void beforeUpdateProfileAdmin() {
        GenerateUserTokenWith2FaForAdmin generateUserTokenWith2FAForAdmin = new GenerateUserTokenWith2FaForAdmin();
        this.userTokenWith2FA = generateUserTokenWith2FAForAdmin.set2faForAccount();
        this.user2FaCode = generateUserTokenWith2FAForAdmin.admin2FaCode;

        GenerateUserTokenWith2FaForManagerUI generateUserTokenWith2FaForManager = new GenerateUserTokenWith2FaForManagerUI();
        this.managerTokenWith2FA = generateUserTokenWith2FaForManager.set2faForAccount();
        this.manager2FaCode = generateUserTokenWith2FaForManager.manager2FaCode;

    }

    @Test
    private void connect2FaForAdmin(){
        request
                .headers("token", userTokenWith2FA)
                .post(URL+"security/disable/887")
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
