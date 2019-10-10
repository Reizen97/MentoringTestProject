package com.mentoring.ui.google.gmail;

import com.mentoring.ui.google.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.mentoring.core.ConciseAPI.waitFor;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;


public class LoginPage extends BasePage {

    public LoginPage singIn() {

        waitFor(elementToBeClickable(By.linkText("Sign in"))).click();
        return this;
    }

    public LoginPage inputEmail(String email) {

        waitElementClickability("#identifierId").sendKeys(email + Keys.ENTER);
        return this;
    }

    public LoginPage inputPassword(String password) {

        waitElementClickability("[name='password']").sendKeys(password + Keys.ENTER);
        return this;
    }
}
