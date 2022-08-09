package com.api.token2FA;

import com.api.BaseURL;
import de.taimos.totp.TOTP;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.codec.binary.Base32;
import org.apache.commons.codec.binary.Hex;

public class GenerateTokenWith2FaForBuyingControl {
    final String LOGIN_TRUE = "buying_control_TEST_API";
    final String PASSWORD_TRUE = "132465798";
    public String buyingControlTokenWithout2FA;
    public String buyingControl2FACode;
    public String buyingControlWith2FA;
    public String buyingControl2FaCode;
    public RequestSpecification request = RestAssured.given();
    BaseURL baseURL = new BaseURL();
    final String URL = baseURL.baseURL;

    public String setUserTokenWithout2FA(){
        Response response = request
                .queryParams("login", LOGIN_TRUE)
                .queryParams("password", PASSWORD_TRUE)
                .post(URL+"profile/login");
        this.buyingControlTokenWithout2FA = response.path("data.token").toString();
        return buyingControlTokenWithout2FA;
    }

    public String generateUser2FACode(){
        String setUserTokenWithout2FA = setUserTokenWithout2FA();
        Response response = request
                .headers("token", setUserTokenWithout2FA)
                .get(URL+"security/generate/code/qr");
        this.buyingControl2FACode = response.path("data.security_code").toString();
        return buyingControl2FACode;
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
        this.buyingControl2FaCode = chief2FaCode();
        Response response = request
                .headers("token",setUserTokenWithout2FA())
                .post(URL+"security/verify/" + buyingControl2FaCode);
        this.buyingControlWith2FA = response.path("data.token").toString();
        return buyingControlWith2FA;
    }
}
