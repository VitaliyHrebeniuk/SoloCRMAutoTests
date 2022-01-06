package com.api.users;
import com.api.users.token2FA.GenerateUserTokenWith2FaForChief;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ChiefGetUserProfile {
    public String chiefTokenWith2FA;
    public String chief2FaCode;
    RequestSpecification request = RestAssured.given();

    @BeforeMethod
    private void beforeGetProfile() {
        GenerateUserTokenWith2FaForChief generateUserTokenWith2FaForChief = new GenerateUserTokenWith2FaForChief();
        this.chiefTokenWith2FA = generateUserTokenWith2FaForChief.set2faForAccount();
        this.chief2FaCode = generateUserTokenWith2FaForChief.chief2FaCode;
    }

    @Test
    private void getUserProfile(){
        request
                .headers("token", chiefTokenWith2FA)
                .get("https://beta-api.solo-crm.com/users/1")
                .then()
                .assertThat()
                .statusCode(200);
    }

    @AfterMethod
    public void afterGetProfile(){
        request
                .headers("token", chiefTokenWith2FA)
                .post("https://beta-api.solo-crm.com/security/status/disable/" + chief2FaCode)
                .then()
                .assertThat()
                .statusCode(200);
    }
}