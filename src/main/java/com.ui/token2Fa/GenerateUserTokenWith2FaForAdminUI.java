package com.ui.token2Fa;

import de.taimos.totp.TOTP;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.codec.binary.Base32;
import org.apache.commons.codec.binary.Hex;

public class GenerateUserTokenWith2FaForAdminUI {
    final String LOGIN_TRUE = "aleksandr_qa";
    final String PASSWORD_TRUE = "13581358";
    public String adminTokenWithout2FA;
    public String admin2FACode;
    public String adminTokenWith2FA;
    public String admin2FaCode;
    public RequestSpecification request = RestAssured.given();
    final String URL = "https://test-api.solo-crm.com/";

    public String setUserTokenWithout2FA(){
        Response response = request
                .param("login", LOGIN_TRUE)
                .param("password", PASSWORD_TRUE)
                .post(URL + "profile/login");
        adminTokenWithout2FA = response.path("data.token").toString();
        return adminTokenWithout2FA;
    }

    public String generateUser2FACode(){
        String setUserTokenWithout2FA = setUserTokenWithout2FA();
        Response response = request
                .headers("token", setUserTokenWithout2FA)
                .get( URL + "security/generate/code/qr");
        admin2FACode = response.path("data.security_code").toString();
        return admin2FACode;
    }

    public String getTOTPCode(String secretKey) {
        Base32 base32 = new Base32();
        byte[] bytes = base32.decode(secretKey);
        String hexKey = Hex.encodeHexString(bytes);
        return TOTP.getOTP(hexKey);
    }

    public String get2FaCode() {
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
        this.admin2FaCode = get2FaCode();
        Response response = request
                .headers("token",setUserTokenWithout2FA())
                .post(URL + "security/verify/" + admin2FaCode);
        this.adminTokenWith2FA = response.path("data.token").toString();
        return adminTokenWith2FA;
    }

}
