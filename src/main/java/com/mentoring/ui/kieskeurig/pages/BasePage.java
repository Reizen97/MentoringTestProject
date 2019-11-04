package com.mentoring.ui.kieskeurig.pages;

import org.openqa.selenium.By;

import static com.mentoring.core.ConciseAPI.waitFor;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class BasePage {

    public void accept() {

        waitFor(elementToBeClickable(By.cssSelector("div.modal-consent__right button.js-consent-accept"))).click();
    }

    public void openLoginFrame() {

        waitFor(elementToBeClickable(By.cssSelector("div.site-header__content a.js-show-login"))).click();
    }
}
