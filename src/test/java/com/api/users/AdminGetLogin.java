package com.api.users;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class AdminGetLogin {
    final String URL = "https://test-api.solo-crm.com/";
    RequestSpecification request = given();
    Gson g = new GsonBuilder().setPrettyPrinting().create();

    @Test
    public void getLoginTrue(){
       request
                .contentType(ContentType.JSON)
                .queryParam("login","admin_qa")
                .queryParam("password","132465798")
                .post(URL + "profile/login")
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
                .post(URL + "profile/login")
                .then()
                .assertThat()
                .statusCode(422);
    }

}
