package com.api.methods;

import io.restassured.response.Response;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class PostMethod {
    public Response withToken(String token, String resource, int expSC, HashMap<String,String> param){
        return given()
                .headers("token",token)
                .param(String.valueOf(param))
                .param(String.valueOf(param))
                .param(String.valueOf(param))
                .param(String.valueOf(param))
                .param(String.valueOf(param))
                .post(resource)
                .then()
                .assertThat()
                .statusCode(expSC)
                .extract()
                .response();
    }

    public String generateRandomNumber(){
        double a = 20 + Math.random()*40;
        return String.valueOf(a);
    }
}
