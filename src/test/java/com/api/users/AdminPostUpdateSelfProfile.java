package com.api.users;

import com.api.users.token2FA.GenerateUserTokenWith2FaForAdmin;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static javafx.scene.AccessibleAttribute.ROLE;


public class AdminPostUpdateSelfProfile {
    public String userTokenWith2FA;
    public String user2FaCode;
    RequestSpecification request = RestAssured.given();
    final String LOGIN = "admin_TEST" + generateRandomNumber();
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

    @BeforeMethod
    private void beforeUpdateProfileAdmin(){
        GenerateUserTokenWith2FaForAdmin generateUserTokenWith2FAForAdmin = new GenerateUserTokenWith2FaForAdmin();
        this.userTokenWith2FA = generateUserTokenWith2FAForAdmin.set2faForAccount();
        this.user2FaCode = generateUserTokenWith2FAForAdmin.admin2FaCode;
    }

    @Test
    public void postUpdateProfileAdmin(){
        request
                .headers("token", userTokenWith2FA)
                .param("login", LOGIN)
                .param("name", NAME)
                .param("role", ROLE)
                .param("email", EMAIL)
                .param("password",PASSWORD)
                .param("status", STATUS)
                .param("bid_id", BID)
                .post(URL + "profile")
                .then()
                .assertThat()
                .statusCode(200);
    }

    @AfterMethod
    public void afterUpdateUserProfile(){
        request
                .headers("token", userTokenWith2FA)
                .post(URL + "security/status/disable/" + user2FaCode)
                .then()
                .assertThat()
                .statusCode(200);
    }


}
