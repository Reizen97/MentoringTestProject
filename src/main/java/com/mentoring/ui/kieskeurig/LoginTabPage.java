package com.mentoring.ui.kieskeurig;

import com.mentoring.ui.BasePage;
import org.openqa.selenium.By;

import static com.mentoring.core.ConciseAPI.clickToElement;
import static com.mentoring.core.ConciseAPI.getText;
import static com.mentoring.core.ConciseAPI.inputText;
import static com.mentoring.core.ConciseAPI.waitFor;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class LoginTabPage extends BasePage {

    public LoginTabPage acept() {

        clickToElement(By.cssSelector("div.modal-consent__right button.js-consent-accept"));
        return this;
    }

    public LoginTabPage openLoginFrame() {

        clickToElement(By.cssSelector("div.site-header__content a.js-show-login"));
        return this;
    }

    public LoginTabPage openLoginTab() {

        clickToElement(By.cssSelector("a.js-user-login--login-toggle"));
        return this;
    }

    public LoginTabPage inputLogin(String login) {

        inputText(By.name("username"), login);
        return this;
    }

    public LoginTabPage inputPassword(String password) {

        inputText(By.cssSelector("form.user-login--login input[name='password']"), password);
        return this;
    }

    public LoginTabPage login() {

        clickToElement(By.cssSelector("form.js-user-login--login button[type='submit']"));
//        waitFor(presenceOfElementLocated(By.cssSelector("div.msg")));
        return this;
    }

    public String getUserName() {

        return getText(By.cssSelector("div.site-header__content a.js-username"));
    }
}
