package com.ui.CreateTaskInJira;

import com.ui.BaseTest;
import com.ui.Jira.Jira;
import org.testng.annotations.Test;

public class CreateTaskInJira extends BaseTest {
    @Test
    public void createTask() throws InterruptedException {
        new Jira(webDriver, jiraURL)
                .inputEmailField("")
                .clickOnContinueButton()
                .inputPassword("")
                .clickOnEnterButton()
                .sleep()
                .clickComment()
                .inputComment()
                .clickOnSendCommentButton();
        Thread.sleep(5000);
    }

}
