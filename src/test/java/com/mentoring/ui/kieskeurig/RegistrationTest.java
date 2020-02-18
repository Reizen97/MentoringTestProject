package com.mentoring.ui.kieskeurig;

import com.github.javafaker.Faker;
import com.mentoring.ui.BaseTest;
import com.mentoring.ui.google.gmail.GmailPage;
import com.mentoring.ui.google.gmail.LoginPage;
import org.junit.jupiter.api.Test;

import static com.mentoring.ui.core.ConciseAPI.openUrl;
import static com.mentoring.ui.core.ConciseAPI.switchToTab;
import static com.mentoring.ui.core.Configuration.EMAIL;
import static com.mentoring.ui.core.Configuration.PASSWORD;
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

        openUrl(env.url());

        Faker faker = new Faker();

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String password = faker.internet().password();
        String login = faker.lorem().fixedString(8).concat(firstName);
        String email = format("ab4180964%s@gmail.com", "+".concat(firstName+lastName));

        mainPage.acept();
        mainPage.openLoginFrame();

        registerTabPage.openRegistrationTab()
                .inputLogin(login)
                .inputFirstName(firstName)
                .inputLastName(lastName)
                .inputEmail(email)
                .inputPassword(password)
                .inputVerifyPassword(password)
                .register();

        assertEquals("Je account is aangemaakt, je ontvangt direct een mail waarin je jouw account kunt bevestigen.",
                registerTabPage.getSuccessMessage());

        openUrl("https://www.google.com/ncr");

        loginPage.singIn()
                .inputEmail(EMAIL)
                .inputPassword(PASSWORD)
                .hoverOn("Gmail");

        gmailPage.clickOnFirstMessageWithSubject("Bevestiging registratie Kieskeurig")
                .submitRegistration(email.replaceAll("@gmail.com", ""));

        switchToTab(1);

        assertEquals("Bedankt voor het activeren van je account. Je account is nu succesvol geactiveerd.",
                mainPage.getActivationMessage());

        mainPage.openLoginFrame();
        loginTabPage.openLoginTab()
                .inputLogin(email)
                .inputPassword(password)
                .login();

        String actualUserName = loginTabPage.getUserName();
        assertEquals(login, actualUserName);
    }
}
