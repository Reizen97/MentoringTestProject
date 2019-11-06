package com.mentoring.helpers;

import org.openqa.selenium.By;

import static com.mentoring.core.ConciseAPI.getDriver;
import static com.mentoring.core.ConciseAPI.waitFor;
import static java.lang.String.format;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class Precondition {

    private final String url;
    private final String tab;
    private final String login;
    private final String password;
    private final String buttonName;

    private Precondition(PreconditionBuilder builder) {

        this.url = builder.url;
        this.tab = builder.tab;
        this.login = builder.login;
        this.password = builder.password;
        this.buttonName = builder.buttonName;
    }

    static public class PreconditionBuilder{

        private String url;
        private String tab;
        private String login;
        private String password;
        private String buttonName;

        public PreconditionBuilder visit(String url) {

            this.url = url;

            getDriver().get(url);
            return this;
        }

        public PreconditionBuilder openTab(String tab) {

            this.tab = tab;

            String locator = format("a.js-user-login--%s-toggle", tab.toLowerCase());
            waitFor(elementToBeClickable(By.cssSelector(locator))).click();

            return this;
        }

        public PreconditionBuilder submit(String buttonName) {

            this.buttonName = buttonName;

            String locator = format("form.js-user-login--%s button[type='submit']", buttonName);

            waitFor(elementToBeClickable(By.cssSelector(locator))).click();
            return this;
        }

        public PreconditionBuilder accept() {

            waitFor(elementToBeClickable(By.cssSelector("div.modal-consent__right button.js-consent-accept"))).click();
            return this;
        }

        public PreconditionBuilder openLoginFrame() {

            waitFor(elementToBeClickable(By.cssSelector("div.site-header__content a.js-show-login"))).click();
            return this;
        }

        public PreconditionBuilder inputLogin(String login) {

            this.login =login;

            waitFor(elementToBeClickable(By.name("username"))).sendKeys(login);
            return this;
        }

        public PreconditionBuilder inputPassword(String password) {

            this.password = password;

            waitFor(elementToBeClickable(By.cssSelector("form.user-login--login input[name='password']"))).sendKeys(password);
            return this;
        }

        public Precondition build() {
            return new Precondition(this);
        }
    }

    public static PreconditionBuilder precondition() {
        return new PreconditionBuilder();
    }
}
