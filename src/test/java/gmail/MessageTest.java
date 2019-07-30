package gmail;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.GmailPage;
import pages.LoginPage;

import java.time.LocalDateTime;

import static core.Configuration.EMAIL;
import static core.Configuration.PASSWORD;
import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class MessageTest extends BaseTest {

    @Test
    public void sendMessage() {

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
