package com.mentoring.ui.kieskeurig;

import org.openqa.selenium.By;

import static com.mentoring.core.ConciseAPI.getDriver;
import static com.mentoring.core.ConciseAPI.waitFor;
import static java.lang.String.format;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class MainPage extends BasePage {

    public MainPage selectCategory(String category) {

        waitFor(elementToBeClickable(By.cssSelector(format("div.cat-tile--single-category a[href='/%s']", category))))
                .click();
        return this;
    }

    public String getActivationMessage() {

        System.out.println(getDriver().getWindowHandle());

        return waitFor(presenceOfElementLocated(By.cssSelector(".success-message .msg"))).getText();
    }
}
