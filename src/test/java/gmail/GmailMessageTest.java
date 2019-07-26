package gmail;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.GmailPage;
import pages.LoginPage;

import static core.Configuration.EMAIL;
import static core.Configuration.PASSWORD;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GmailMessageTest extends BaseTest {

    private LoginPage loginPage;
    private GmailPage gmailPage;

    @Test
    public void sendMessage() {
        loginPage = new LoginPage();
        loginPage.openGmail("http://gmail.com")
                .inputEmail(EMAIL);
        gmailPage = loginPage.inputPassword(PASSWORD);
        gmailPage.createNewLetter()
                .inputRecipient(EMAIL)
                .inputSubject("Test")
                .inputMessage("Test")
                .sendMessage();

        String actualResult = gmailPage.getSenderOfLastMessage();
        String expectedResult = "me";
        assertEquals(actualResult, expectedResult);
    }
}
