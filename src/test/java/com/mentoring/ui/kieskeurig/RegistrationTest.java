package com.mentoring.ui.kieskeurig;

import com.mentoring.ui.BaseTest;
import com.mentoring.ui.gmail.GmailPage;
import com.mentoring.ui.gmail.LoginPage;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static com.mentoring.core.ConciseAPI.openUrl;
import static com.mentoring.core.Configuration.EMAIL;
import static com.mentoring.core.Configuration.PASSWORD;
import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class RegistrationTest extends BaseTest {

    @Test
    public void testRegistration() {

        RegisterTabPage registerTabPage = new RegisterTabPage();
        LoginPage loginPage = new LoginPage();
        GmailPage gmailPage = new GmailPage();
        LoginTabPage loginTabPage = new LoginTabPage();

        openUrl("https://www.kieskeurig.nl/");

        String email = format("ab4180964%s%s@gmail.com", "+", Calendar.getInstance().getTime()).replaceAll("( |:)", "");
        String name = Calendar.getInstance().getTime().toString().replaceAll("( |:)", "");

        registerTabPage.acept()
                .openLoginFrame()
                .openRegistrationTab()
                .inputLogin(name)
                .inputFirstName(name)
                .inputLastName(name)
                .inputEmail(email)
                .inputPassword(email)
                .inputVerifyPassword(email)
                .register();

        openUrl("https://www.gmail.com/");

        loginPage.inputEmail(EMAIL)
                .inputPassword(PASSWORD);

        gmailPage.clickOnFirstMessage()
                .submitRegistration();

        openUrl("https://www.kieskeurig.nl/");

        loginTabPage.openLoginFrame()
                .openLoginTab()
                .inputLogin(name)
                .inputPassword(email)
                .login();

        String actualUserName = loginTabPage.getUserName();
        assertEquals(name, actualUserName);
    }
}
