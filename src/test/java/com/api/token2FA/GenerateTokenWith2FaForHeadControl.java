package com.api.token2FA;

import com.api.BaseURL;
import de.taimos.totp.TOTP;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.codec.binary.Base32;
import org.apache.commons.codec.binary.Hex;

public class GenerateTokenWith2FaForHeadControl {
    final String LOGIN_TRUE = "head_control_TEST_API";
    final String PASSWORD_TRUE = "132465798";
    public String headControlTokenWithout2FA;
    public String headControl2FACode;
    public String headControlWith2FA;
    public String headControl2FaCode;
    public RequestSpecification request = RestAssured.given();
    BaseURL baseURL = new BaseURL();
    final String URL = baseURL.baseURL;

    public String setUserTokenWithout2FA(){
        Response response = request
                .queryParams("login", LOGIN_TRUE)
                .queryParams("password", PASSWORD_TRUE)
                .post(URL+"profile/login");
        this.headControlTokenWithout2FA = response.path("data.token").toString();
        return headControlTokenWithout2FA;
    }

    public String generateUser2FACode(){
        String setUserTokenWithout2FA = setUserTokenWithout2FA();
        Response response = request
                .headers("token", setUserTokenWithout2FA)
                .get(URL+"security/generate/code/qr");
        this.headControl2FACode = response.path("data.security_code").toString();
        return headControl2FACode;
    }

    public String getTOTPCode(String secretKey) {
        Base32 base32 = new Base32();
        byte[] bytes = base32.decode(secretKey);
        String hexKey = Hex.encodeHexString(bytes);
        return TOTP.getOTP(hexKey);
    }

    public String chief2FaCode() {
        String secretKey = generateUser2FACode();
        String lastCode = null;
        int i = 1;
        while (i == 1) {
            String code = getTOTPCode(secretKey);
            i += 1;
            lastCode = code;
        }
        //System.out.println(lastCode);
        return lastCode;
    }

    public String set2faForAccount(){
        this.headControl2FaCode = chief2FaCode();
        Response response = request
                .headers("token",setUserTokenWithout2FA())
                .post(URL+"security/verify/" + headControl2FaCode);
        this.headControlWith2FA = response.path("data.token").toString();
        return headControlWith2FA;
    }
}
