package com.mentoring.ui.gmail;

import com.mentoring.ui.BasePage;
import org.openqa.selenium.By;

import static com.mentoring.core.ConciseAPI.clickToElement;
import static com.mentoring.core.ConciseAPI.inputText;


public class LoginPage extends BasePage {

    public LoginPage inputEmail(String email) {

        inputText(By.id("identifierId"), email);
        clickToElement(By.id("identifierNext"));
        return this;
    }

    public LoginPage inputPassword(String password) {

        inputText(By.name("password"), password);
        clickToElement(By.id("passwordNext"));
        return this;
    }
}
