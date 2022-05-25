package com.api.requests;

import com.fasterxml.jackson.databind.ser.Serializers;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class UserRequests extends BaseRequsets {
    public String getUserRequest(String token, String resource, int expectedStatusCode){
        Response response = getMethods
                .withToken(token, resource, expectedStatusCode);
        return response.asString();
    }
}
