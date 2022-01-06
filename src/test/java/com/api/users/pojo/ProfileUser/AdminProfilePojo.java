package com.api.users.pojo.ProfileUser;

import com.google.gson.annotations.SerializedName;

public class AdminProfilePojo {
    @SerializedName("role")
    private String role_admin = "admin";
    @SerializedName("login")
    private String login_admin = "admin_API_TEST" + generateRandomNumber();
    @SerializedName("password")
    private String password = "132465798";
    @SerializedName("status")
    private String status = "active";
    @SerializedName("email")
    private String email = login_admin + generateRandomNumber() + "@g.com";
    @SerializedName("bid_id")
    private Integer bid = 84;
    @SerializedName("user_id")
    private Integer user_id = 884;

    public String getRole_admin() {
        return role_admin;
    }

    public String getLogin_admin() {
        return login_admin;
    }

    public String getPassword() {
        return password;
    }

    public String getStatus() {
        return status;
    }

    public Integer getBid() {
        return bid;
    }

    public Integer getUser_id() {
        return user_id;
    }
    public String getEmail() {
        return email;
    }

    private String generateRandomNumber(){
        double a = 20 + Math.random()*40;
        return String.valueOf(a);
    }
}
