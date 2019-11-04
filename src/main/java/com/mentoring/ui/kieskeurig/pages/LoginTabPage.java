package com.mentoring.ui.kieskeurig.pages;

import org.openqa.selenium.By;

import static com.mentoring.core.ConciseAPI.waitFor;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;


public class LoginTabPage extends BasePage {

    public LoginTabPage openLoginTab() {

        waitFor(elementToBeClickable(By.cssSelector("a.js-user-login--login-toggle"))).click();
        return this;
    }

    public LoginTabPage inputLogin(String login) {

        waitFor(elementToBeClickable(By.name("username"))).sendKeys(login);
        return this;
    }

    public LoginTabPage inputPassword(String password) {

        waitFor(elementToBeClickable(By.cssSelector("form.user-login--login input[name='password']"))).sendKeys(password);
        return this;
    }

    public LoginTabPage login() {

        waitFor(elementToBeClickable(By.cssSelector("form.js-user-login--login button[type='submit']"))).click();
        return this;
    }

    public String getUserName() {

        return waitFor(visibilityOfElementLocated(By.cssSelector("div.site-header__content a.js-username"))).getText();
    }
}
