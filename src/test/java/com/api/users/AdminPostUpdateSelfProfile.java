package com.api.users;

import com.api.token2FA.GenerateUserTokenWith2FaForAdmin;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.*;

import static javafx.scene.AccessibleAttribute.ROLE;


public class AdminPostUpdateSelfProfile {
    public String userTokenWith2FA;
    public String user2FaCode;
    RequestSpecification request = RestAssured.given();
    final String LOGIN = "admin_TEST_API" + generateRandomNumber();
    final String PASSWORD = "132465798";
    final String NAME = "admin_qa";
    final String EMAIL = "admin_qa" + generateRandomNumber() + "@gmail.com";
    final String STATUS = "active";
    final Integer BID = 84;
    final String URL = "https://test-api.solo-crm.com/";

    private String generateRandomNumber() {
        double a = 20 + Math.random() * 4000;
        return String.valueOf(a);
    }

    @BeforeClass
    private void beforeUpdateProfileAdmin(){
        GenerateUserTokenWith2FaForAdmin generateUserTokenWith2FAForAdmin = new GenerateUserTokenWith2FaForAdmin();
        this.userTokenWith2FA = generateUserTokenWith2FAForAdmin.set2faForAccount();
        this.user2FaCode = generateUserTokenWith2FAForAdmin.admin2FaCode;
    }

    @Test
    public void postUpdateProfileAdmin(){
        request
                .headers("token", userTokenWith2FA)
                .param("name", NAME)
                .param("password",PASSWORD)
                .param("telegram", "null")
                .param("telegram_notification",0)
                .post(URL + "profile")
                .then()
                .assertThat()
                .statusCode(200);
    }

    @AfterClass
    public void afterUpdateUserProfile(){
        request
                .headers("token", userTokenWith2FA)
                .post(URL + "security/status/disable/" + user2FaCode)
                .then()
                .assertThat()
                .statusCode(200);
    }


}
