package com.api.users.token2FA;

import de.taimos.totp.TOTP;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.codec.binary.Base32;
import org.apache.commons.codec.binary.Hex;

public class GenerateUserTokenWith2FA {
    final String LOGIN_TRUE = "admin_TEST";
    final String PASSWORD_TRUE = "132465798";
    public String userTokenWithout2FA;
    public String user2FACode;
    public String userTokenWith2FA;
    public RequestSpecification request = RestAssured.given();
    public String get2FaCode;

    public String setUserTokenWithout2FA(){
        Response response = request
                .param("login", LOGIN_TRUE)
                .param("password", PASSWORD_TRUE)
                .get("https://beta-api.solo-crm.com/profile/login");
        userTokenWithout2FA = response.path("data.token").toString();
        return userTokenWithout2FA;
    }
    public String generateUser2FACode(){
        String setUserTokenWithout2FA = setUserTokenWithout2FA();
        Response response = request
                .headers("token", setUserTokenWithout2FA)
                .get("https://beta-api.solo-crm.com/security/generate/code/qr");
        user2FACode = response.path("data.security_code").toString();
        return user2FACode;
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
        this.get2FaCode = get2FaCode();
        Response response = request
                .headers("token",setUserTokenWithout2FA())
                .post("https://beta-api.solo-crm.com/security/verify/" + get2FaCode);
        this.userTokenWith2FA = response.path("data.token").toString();
        return userTokenWith2FA;
    }

    public void delete2FaForAccount(){
        request
                .headers("token", userTokenWith2FA)
                .post("https://beta-api.solo-crm.com/security/status/disable/" + get2FaCode)
                .then()
                .assertThat()
                .statusCode(200);
    }

}
