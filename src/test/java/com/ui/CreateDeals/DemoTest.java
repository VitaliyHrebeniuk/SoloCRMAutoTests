package com.ui.CreateDeals;

import com.ui.BaseTest;
import com.ui.pages.Auditor.LoginPageAuditor;
import org.testng.annotations.*;

public class DemoTest extends BaseTest {

    @BeforeMethod
        public void print(){
            System.out.println("before TEST");
    }

    @Test
    public void auditorApprove() throws InterruptedException {
        /**
         * Вводим логин, вводим пароль, нажимаем на Sign In,
         * вводим код аутентификации, нажимаем на Send Code.
         */
        LoginPageAuditor loginPageAuditor = new LoginPageAuditor(webDriver, baseURL)
                .inputLogin("")
                .inputPassword("")
                .clickOnSignInButton();
    }

    @AfterMethod
    public void print2(){
        System.out.println("after Test");

    }
}
