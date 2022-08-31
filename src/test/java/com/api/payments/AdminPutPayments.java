package com.api.payments;

import com.api.BaseURL;
import com.api.token2FA.GenerateUserTokenWith2FaForAdmin;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static java.lang.String.valueOf;

public class AdminPutPayments {
    public String userTokenWith2FA;
    public String user2FaCode;
    RequestSpecification request = RestAssured.given();
    BaseURL baseURL = new BaseURL();
    final String URL = baseURL.baseURL;

    @BeforeClass
    private void beforeUpdateProfileAdmin() {
        GenerateUserTokenWith2FaForAdmin generateUserTokenWith2FAForAdmin = new GenerateUserTokenWith2FaForAdmin();
        this.userTokenWith2FA = generateUserTokenWith2FAForAdmin.set2faForAccount();
        this.user2FaCode = generateUserTokenWith2FAForAdmin.admin2FaCode;
    }
    private String getDate(){
        Date today;
        String result;
        SimpleDateFormat ymd;
        SimpleDateFormat hours;
        SimpleDateFormat minutes;
        String minutes_result;
        int minutest_result_int;
        today = new Date();

        ymd = new SimpleDateFormat("y-M-d");
        hours = new SimpleDateFormat("H:");
        minutes = new SimpleDateFormat("m");
        minutes_result = valueOf(minutes.format(today));
        minutest_result_int = Integer.parseInt(valueOf(minutes_result))+ 2;
        result = ymd.format(today) + " " + hours.format(today) + minutest_result_int;
        return result;
    }
    private String getDate2(){
        Date today;
        String result;
        SimpleDateFormat ym;
        SimpleDateFormat d;
        SimpleDateFormat hours;
        SimpleDateFormat minutes;
        String minutes_result;
        int minutest_result_int;
        String d_result;
        int d_result_int;
        today = new Date();

        ym = new SimpleDateFormat("y-M-");
        d = new SimpleDateFormat("d");
        d_result = valueOf(d.format(today));
        d_result_int = Integer.parseInt(valueOf(d_result))+ 1;
        hours = new SimpleDateFormat("H:");
        minutes = new SimpleDateFormat("m");
        minutes_result = valueOf(minutes.format(today));
        minutest_result_int = Integer.parseInt(valueOf(minutes_result))+ 2;

        result = ym.format(today)+ d_result_int  + " " + hours.format(today) + minutest_result_int;
        return result;
    }

    @Test
    private void test(){
        request
                .headers("token", userTokenWith2FA)
                .param("start", getDate())
                .param("end", getDate2())
                .param("wallet_id", 1)
                .param("summary",1)
                .param("deal_id",37776)
                .put(URL+"payments")
                .then()
                .assertThat()
                .statusCode(201);
    }

    @AfterClass
    public void afterUpdateUserProfile(){
        request
                .headers("token", userTokenWith2FA)
                .post(URL+"security/status/disable/" + user2FaCode)
                .then()
                .assertThat()
                .statusCode(200);
    }
}
