package com.mentoring.ui.gmail;

import com.mentoring.ui.BaseTest;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static com.mentoring.core.Configuration.EMAIL;
import static com.mentoring.core.Configuration.PASSWORD;
import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class MessageTest extends BaseTest {

    @Test
    public void TestSendMessage() {

        LoginPage loginPage = new LoginPage();
        GmailPage gmailPage = new GmailPage();

        loginPage.openGmail("http://gmail.com")
                .inputEmail(EMAIL)
                .inputPassword(PASSWORD);

        String subject = format("Test %s", LocalDateTime.now().toLocalDate().toString());

        gmailPage.createNewLetter()
                .inputRecipient(EMAIL)
                .inputSubject(subject)
                .inputMessage("Test")
                .sendMessage();

        String actualResult = gmailPage.getSubjectOfLastMessage();

        assertEquals(subject, actualResult);
    }
}
