package com.api.partners.users;

import com.api.token2FA.GenerateUserTokenWith2FaForAdmin;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Demo {
    public static String userTokenWith2FA;
    public static String user2FaCode;

    private static String generateRandomNumber(){
        double a = 20 + Math.random()*40;
        return String.valueOf(a);
    }
    public static void main(String[] args) {
        //Requset
        RequestSpecification request = RestAssured.given();
        //GsonBuilderFor
        Gson g = new GsonBuilder().setPrettyPrinting().create();
        Demo demo = new Demo();
        //Generate TokenWith2FA
        GenerateUserTokenWith2FaForAdmin generateUserTokenWith2FAForAdmin = new GenerateUserTokenWith2FaForAdmin();
        userTokenWith2FA = generateUserTokenWith2FAForAdmin.set2faForAccount();

         Response response = request
                .headers("token", userTokenWith2FA)
                .headers("Contet-Type","application/json;charset=utf-8")

//                .param("user_id", 425)
//                .param("login", LOGIN_AUDITOR)
//                .param("role", ROLE_AUDITOR)
//                .param("email", LOGIN_AUDITOR + generateRandomNumber())
//                .param("password",PASSWORD)
//                .param("bid_id", BID)
//                .queryParams("product_deal_type_access",demo.getCaseModel())
                .post("https://beta-api.solo-crm.com/users/425");

        System.out.println("asd");
    }
}
