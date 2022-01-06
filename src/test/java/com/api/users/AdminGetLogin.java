package com.api.users;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class AdminGetLogin {
    private final static String URL = "https://beta-api.solo-crm.com/";
    RequestSpecification request = given();
    Gson g = new GsonBuilder().setPrettyPrinting().create();

    @Test
    public void getLoginTrue(){
       request
                .contentType(ContentType.JSON)
                //.body(loginAdminPojo)
                .param("login","admin_qa")
                .param("password","132465798")
                .get(URL + "profile/login")
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void getLoginFalse(){
        request
                .contentType(ContentType.JSON)
                .param("login", "1")
                .param("password","1")
                .get(URL + "profile/login")
                .then()
                .assertThat()
                .statusCode(401);
    }

}
