package com.api.partners.users.pojo.ProfileUser;

import com.google.gson.annotations.SerializedName;

public class SpamerProfilePojo {
    @SerializedName("role")
    private String role = "spamer";
    @SerializedName("login")
    private String login = "spamer_TEST_API";
    @SerializedName("password")
    private String password = "132465798";
    @SerializedName("status")
    private String status = "active";
    @SerializedName("email")
    private String email = login + generateRandomNumber() + "@g.com";
    @SerializedName("bid_id")
    private Integer bid = 84;
    @SerializedName("user_id")
    private Integer user_id = 897;

    private String generateRandomNumber(){
        double a = 20 + Math.random()*40;
        return String.valueOf(a);
    }

    public String getRole() {
        return role;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getStatus() {
        return status;
    }

    public String getEmail() {
        return email;
    }

    public Integer getBid() {
        return bid;
    }

    public Integer getUser_id() {
        return user_id;
    }
}
