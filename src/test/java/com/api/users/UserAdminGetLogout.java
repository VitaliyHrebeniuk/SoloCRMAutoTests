package com.api.users;

import com.api.users.token2FA.GenerateUserTokenWith2FA;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UserAdminGetLogout {
    public String userTokenWith2FA;
    public String user2FaCode;
    RequestSpecification request = RestAssured.given();

    @BeforeMethod
    private void beforeUpdateProfileAdmin() {
        GenerateUserTokenWith2FA generateUserTokenWith2FA = new GenerateUserTokenWith2FA();
        this.userTokenWith2FA = generateUserTokenWith2FA.set2faForAccount();
        this.user2FaCode = generateUserTokenWith2FA.get2FaCode;
    }

    @Test
    private void getAdminLogout(){
        request
                .headers("token", userTokenWith2FA)
                .post("https://beta-api.solo-crm.com/profile/logout")
                .then()
                .assertThat()
                .statusCode(200);
    }

    @AfterMethod
    public void afterUpdateUserProfile(){
        request
                .headers("token", userTokenWith2FA)
                .post("https://beta-api.solo-crm.com/security/status/disable/" + user2FaCode)
                .then()
                .assertThat()
                .statusCode(200);
    }
}
