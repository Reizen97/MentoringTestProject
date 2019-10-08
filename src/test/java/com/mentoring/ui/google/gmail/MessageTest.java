package com.mentoring.ui.google.gmail;

import com.mentoring.ui.BaseTest;
import com.mentoring.ui.google.apps.GmailPage;
import com.mentoring.ui.google.apps.LoginPage;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static com.mentoring.core.ConciseAPI.openUrl;
import static com.mentoring.core.Configuration.EMAIL;
import static com.mentoring.core.Configuration.PASSWORD;
import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class MessageTest extends BaseTest {

    @Test
    public void testSendMessage() {

        LoginPage loginPage = new LoginPage();
        GmailPage gmailPage = new GmailPage();

        openUrl("https://www.google.com/ncr");

        loginPage.singIn()
                .inputEmail(EMAIL)
                .inputPassword(PASSWORD)
                .hoverOn("Gmail");

        String subject = format("Test %s", Calendar.getInstance().getTime());

        gmailPage.createNewLetter()
                .inputRecipient(EMAIL)
                .inputSubject(subject)
                .inputMessage("Test")
                .sendMessage();

        String actualResult = gmailPage.getSubjectOfLastMessage();

        assertEquals(subject, actualResult);
    }

}
