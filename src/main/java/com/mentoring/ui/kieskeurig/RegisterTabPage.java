package com.mentoring.ui.kieskeurig;

import com.mentoring.ui.BasePage;
import org.openqa.selenium.By;

import static com.mentoring.core.ConciseAPI.clickToElement;
import static com.mentoring.core.ConciseAPI.inputText;
import static com.mentoring.core.ConciseAPI.waitFor;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class RegisterTabPage extends BasePage {

    public RegisterTabPage acept() {

        clickToElement(By.cssSelector("div.modal-consent__right button.js-consent-accept"));
        return this;
    }

    public RegisterTabPage openLoginFrame() {

        clickToElement(By.cssSelector("div.site-header__content a.js-show-login"));
        return this;
    }

    public RegisterTabPage openRegistrationTab() {

        clickToElement(By.cssSelector("a.js-user-login--register-toggle"));
        return this;
    }

    public RegisterTabPage inputLogin(String login) {

        inputText(By.name("account_displayname"), login);
        return this;
    }

    public RegisterTabPage inputFirstName(String firstName) {

        inputText(By.name("account_first_name"), firstName);
        return this;
    }

    public RegisterTabPage inputLastName(String lastName) {

        inputText(By.name("account_last_name"), lastName);
        return this;
    }

    public RegisterTabPage inputPassword(String password) {

        inputText(By.cssSelector("form.user-login--register input[name='password']"), password);
        return this;
    }

    public RegisterTabPage inputVerifyPassword(String password) {

        inputText(By.cssSelector("form.user-login--register input[name='password-verify']"), password);
        return this;
    }

    public RegisterTabPage inputEmail(String email) {

        inputText(By.cssSelector("form.js-user-login--register input[name='account_email']"), email);
        return this;
    }

    public RegisterTabPage register() {

        clickToElement(By.cssSelector("form.js-user-login--register button[type='submit']"));
        waitFor(presenceOfElementLocated(By.cssSelector("div.msg")));
        return this;
    }
}
