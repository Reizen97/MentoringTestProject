package com.mentoring.ui.kieskeurig;

import com.mentoring.ui.BasePage;
import org.openqa.selenium.By;

import static com.mentoring.core.ConciseAPI.getDriver;
import static com.mentoring.core.ConciseAPI.waitFor;


public class LoginTabPage extends BasePage {

    public LoginTabPage openLoginFrame() {

        getDriver().findElement(By.cssSelector("div.site-header__content a.js-show-login")).click();
        return this;
    }

    public LoginTabPage openLoginTab() {

        getDriver().findElement(By.cssSelector("a.js-user-login--login-toggle")).click();
        return this;
    }

    public LoginTabPage inputLogin(String login) {

        getDriver().findElement(By.name("username")).sendKeys(login);
        return this;
    }

    public LoginTabPage inputPassword(String password) {

        getDriver().findElement(By.cssSelector("form.user-login--login input[name='password']")).sendKeys(password);
        return this;
    }

    public LoginTabPage login() {

        getDriver().findElement(By.cssSelector("form.js-user-login--login button[type='submit']")).click();
//        waitFor(presenceOfElementLocated(By.cssSelector("div.msg")));
        return this;
    }

    public String getUserName() {

        return getDriver().findElement(By.cssSelector("div.site-header__content a.js-username")).getText();
    }
}
