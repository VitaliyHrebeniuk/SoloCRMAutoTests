package com.api.partners.users;

import com.api.BaseURL;
import com.api.token2FA.GenerateUserTokenWith2FaForManager;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.*;

public class ManagerGetTeamUsersList {
    public String managerTokenWith2FA;
    public String manager2FaCode;
    RequestSpecification request = RestAssured.given();
    BaseURL baseURL = new BaseURL();
    final String URL = baseURL.baseURL;

    @BeforeClass
    private void beforeGetProfile() {
        GenerateUserTokenWith2FaForManager generateUserTokenWith2FaForManager = new GenerateUserTokenWith2FaForManager();
        this.managerTokenWith2FA = generateUserTokenWith2FaForManager.set2faForAccount();
        this.manager2FaCode = generateUserTokenWith2FaForManager.manager2FaCode;
    }

    @Test
    private void getUserProfile(){
        request
                .headers("token", managerTokenWith2FA)
                .get(URL +"users/teamUsersList")
                .then()
                .assertThat()
                .statusCode(200);
    }

    @AfterClass
    public void afterUpdateUserProfile(){
        request
                .headers("token", managerTokenWith2FA)
                .post(URL + "security/status/disable/" + manager2FaCode)
                .then()
                .assertThat()
                .statusCode(200);
    }
}
