package com.ui.token2Fa;

import de.taimos.totp.TOTP;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.codec.binary.Base32;
import org.apache.commons.codec.binary.Hex;

public class GenerateUserTokenWith2FaForCmUI {
    final String LOGIN_TRUE = "cm_TEST_UI";
    final String PASSWORD_TRUE = "132465798";
    public String cmTokenWithout2FA;
    public String cm2FACode;
    public String cmWith2FA;
    public String cm2FaCode;
    public RequestSpecification request = RestAssured.given();
    final String URL = "https://beta-api.solo-crm.com/";

    public String setUserTokenWithout2FA(){
        Response response = request
                .queryParams("login", LOGIN_TRUE)
                .queryParams("password", PASSWORD_TRUE)
                .post(URL+"profile/login");
        this.cmTokenWithout2FA = response.path("data.token").toString();
        return cmTokenWithout2FA;
    }

    public String generateUser2FACode(){
        String setUserTokenWithout2FA = setUserTokenWithout2FA();
        Response response = request
                .headers("token", setUserTokenWithout2FA)
                .get(URL+"security/generate/code/qr");
        this.cm2FACode = response.path("data.security_code").toString();
        return cm2FACode;
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
        this.cm2FaCode = chief2FaCode();
        Response response = request
                .headers("token",setUserTokenWithout2FA())
                .post(URL+"security/verify/" + cm2FaCode);
        this.cmWith2FA = response.path("data.token").toString();
        return cmWith2FA;
    }
}
