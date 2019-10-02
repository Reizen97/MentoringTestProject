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
        MainPage mainPage = new MainPage();

        openUrl("https://www.kieskeurig.nl/");

        String email = format("ab4180964%s%s@gmail.com", "+", Calendar.getInstance().getTime()).replaceAll("( |:)", "");
        String name = Calendar.getInstance().getTime().toString().replaceAll("( |:)", "");

        mainPage.acept();

        registerTabPage
                .openLoginFrame()
                .openRegistrationTab()
                .inputLogin(name)
                .inputFirstName(name)
                .inputLastName(name)
                .inputEmail(email)
                .inputPassword(email)
                .inputVerifyPassword(email)
                .register();

        openUrl("https://www.google.com/ncr");

        loginPage
                .singIn()
                .inputEmail(EMAIL)
                .inputPassword(PASSWORD)
                .hoverOn("Gmail");

        gmailPage
                .clickOnFirstMessageWithSubject("Bevestiging registratie Kieskeurig")
                .submitRegistration(name);

//        openUrl("https://www.kieskeurig.nl/");

        loginTabPage
                .openLoginFrame()
                .openLoginTab()
                .inputLogin(name)
                .inputPassword(email)
                .login();

        String actualUserName = loginTabPage.getUserName();
        assertEquals(name, actualUserName);
    }
}
