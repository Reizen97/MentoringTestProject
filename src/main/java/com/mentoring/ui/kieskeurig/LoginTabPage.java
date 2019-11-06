package com.mentoring.ui.kieskeurig;

import com.mentoring.ui.BasePage;
import org.openqa.selenium.By;

import static com.mentoring.core.ConciseAPI.waitFor;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;


public class LoginTabPage extends BasePage {

    public String getUserName() {

        return waitFor(visibilityOfElementLocated(By.cssSelector("div.site-header__content a.js-username"))).getText();
    }
}
