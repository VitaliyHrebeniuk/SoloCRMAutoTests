package com.api.token2FA;

import de.taimos.totp.TOTP;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.codec.binary.Base32;
import org.apache.commons.codec.binary.Hex;

public class GenerateUserTokenWith2FaForAuditor {
    final String LOGIN_TRUE = "auditor_TEST_API";
    final String PASSWORD_TRUE = "132465798";
    public String auditorTokenWithout2FA;
    public String auditor2FACode;
    public String auditorWith2FA;
    public String auditor2FaCode;
    public RequestSpecification request = RestAssured.given();
    final String URL = "https://test-api.solo-crm.com/";

    public String setUserTokenWithout2FA(){
        Response response = request
                .param("login", LOGIN_TRUE)
                .param("password", PASSWORD_TRUE)
                .get(URL+"profile/login");
        this.auditorTokenWithout2FA = response.path("data.token").toString();
        return auditorTokenWithout2FA;
    }

    public String generateUser2FACode(){
        String setUserTokenWithout2FA = setUserTokenWithout2FA();
        Response response = request
                .headers("token", setUserTokenWithout2FA)
                .get(URL+"security/generate/code/qr");
        this.auditor2FACode = response.path("data.security_code").toString();
        return auditor2FACode;
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
        this.auditor2FaCode = chief2FaCode();
        Response response = request
                .headers("token",setUserTokenWithout2FA())
                .post(URL+"security/verify/" + auditor2FaCode);
        this.auditorWith2FA = response.path("data.token").toString();
        return auditorWith2FA;
    }
}
