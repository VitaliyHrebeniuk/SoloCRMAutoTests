package com.api.methods;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;


public class GetMethod {
    public Response withToken(String token, String resource, int expSC){
        RestAssured.baseURI = "";
        return given()
                .headers("token", token)
                .get(resource)
                .then()
                .assertThat()
                .statusCode(expSC)
                .extract()
                .response();

    }
}
