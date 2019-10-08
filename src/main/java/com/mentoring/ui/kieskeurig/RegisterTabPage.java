package com.mentoring.ui.kieskeurig;

import org.openqa.selenium.By;

import static com.mentoring.core.ConciseAPI.getDriver;
import static com.mentoring.core.ConciseAPI.waitFor;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;


public class RegisterTabPage extends BasePage {

    public RegisterTabPage openRegistrationTab() {

        waitFor(elementToBeClickable(By.cssSelector("a.js-user-login--register-toggle"))).click();
        return this;
    }

    public RegisterTabPage inputLogin(String login) {

        waitFor(elementToBeClickable(By.name("account_displayname"))).sendKeys(login);
        return this;
    }

    public RegisterTabPage inputFirstName(String firstName) {

        waitFor(elementToBeClickable(By.name("account_first_name"))).sendKeys(firstName);
        return this;
    }

    public RegisterTabPage inputLastName(String lastName) {

        waitFor(elementToBeClickable(By.name("account_last_name"))).sendKeys(lastName);
        return this;
    }

    public RegisterTabPage inputPassword(String password) {

        getDriver().findElement(By.cssSelector("form.user-login--register input[name='password']")).sendKeys(password);
        return this;
    }

    public RegisterTabPage inputVerifyPassword(String password) {

        getDriver().findElement(By.cssSelector("form.user-login--register input[name='password-verify']")).sendKeys(password);
        return this;
    }

    public RegisterTabPage inputEmail(String email) {

        getDriver().findElement(By.cssSelector("form.js-user-login--register input[name='account_email']")).sendKeys(email);
        return this;
    }

    public RegisterTabPage register() {

        getDriver().findElement(By.cssSelector("form.js-user-login--register button[type='submit']")).click();
        waitFor(presenceOfElementLocated(By.cssSelector("div.msg")));
        return this;
    }

    public boolean isSuccessMessageDisplayed() {

        return (getDriver().findElements(By.cssSelector(".modal-success-message .msg")).size() == 1);
    }
}
