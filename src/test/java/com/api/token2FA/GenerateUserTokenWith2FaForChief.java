package com.api.token2FA;

import de.taimos.totp.TOTP;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.codec.binary.Base32;
import org.apache.commons.codec.binary.Hex;

public class GenerateUserTokenWith2FaForChief {
    final String LOGIN_TRUE = "chief_TEST_API";
    final String PASSWORD_TRUE = "132465798";
    public String chiefTokenWithout2FA;
    public String chief2FACode;
    public String chiefTokenWith2FA;
    public String chief2FaCode;
    public RequestSpecification request = RestAssured.given();
    final String URL = "https://test-api.solo-crm.com/";

    public String setUserTokenWithout2FA(){
        Response response = request
                .param("login", LOGIN_TRUE)
                .param("password", PASSWORD_TRUE)
                .get(URL+"profile/login");
        this.chiefTokenWithout2FA = response.path("data.token").toString();
        return chiefTokenWithout2FA;
    }

    public String generateUser2FACode(){
        String setUserTokenWithout2FA = setUserTokenWithout2FA();
        Response response = request
                .headers("token", setUserTokenWithout2FA)
                .get(URL+"security/generate/code/qr");
        this.chief2FACode = response.path("data.security_code").toString();
        return chief2FACode;
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
        this.chief2FaCode = chief2FaCode();
        Response response = request
                .headers("token",setUserTokenWithout2FA())
                .post(URL+"security/verify/" + chief2FaCode);
        this.chiefTokenWith2FA = response.path("data.token").toString();
        return chiefTokenWith2FA;
    }
}
