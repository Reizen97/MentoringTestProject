package com.mentoring.ui.kieskeurig.pages;

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

        return waitFor(presenceOfElementLocated(By.cssSelector(".success-message .msg"))).getText();
    }

    public boolean isElementVisible(By locator) {

        return waitFor(presenceOfElementLocated(locator)).isDisplayed();
    }

    public String getTitle() {

        return getDriver().getTitle();
    }
}
