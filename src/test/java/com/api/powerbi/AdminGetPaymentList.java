package com.api.powerbi;

import com.api.BaseURL;
import com.api.token2FA.GenerateUserTokenWith2FaForAdmin;
import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import static java.lang.String.valueOf;

public class AdminGetPaymentList {
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

    @Test
    private void test(){
        request
                .headers("token", userTokenWith2FA)
                .get(URL+"powerbi/paymentList/JUv4tVlWTalpf0PM1P6oeBZEgk7wbAE")
                .then()
                .assertThat()
                .statusCode(200);

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
