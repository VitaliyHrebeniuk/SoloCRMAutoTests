package com.api.users;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;


public class UserAdminGetLogin {
    final String LOGIN_TRUE = "admin_TEST";
    final String PASSWORD_TRUE = "132465798";
    final String LOGIN_FALSE = "admin_TEST";
    final String PASSWORD_FALSE = "1";
    RequestSpecification request = RestAssured.given();

    @Test
    public void getLoginTrue(){
        request.contentType(ContentType.JSON);
        request
                .param("login",LOGIN_TRUE).param("password",PASSWORD_TRUE)
                .get("https://beta-api.solo-crm.com/profile/login")
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void getLoginFalse(){
        request.contentType(ContentType.JSON);
        request
                .param("login",LOGIN_FALSE).param("password",PASSWORD_FALSE)
                .get("https://beta-api.solo-crm.com/profile/login")
                .then()
                .assertThat()
                .statusCode(401);
    }

}
