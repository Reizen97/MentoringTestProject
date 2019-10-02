package com.mentoring.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.mentoring.core.ConciseAPI.action;

import static com.mentoring.core.ConciseAPI.waitFor;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;


public class BasePage {

    public void hoverOn(String name) {

        WebElement burger = waitElementClickability("#gbwa");

        action().moveToElement(burger).perform();
        burger.click();

        WebElement googleApp = waitFor(elementToBeClickable(By.xpath(String.format("//span[contains(text(), '%s')]", name))));

        action().moveToElement(googleApp)
                .click()
                .build()
                .perform();
    }

    public WebElement waitElementClickability(String cssSelector) {
        return waitFor(elementToBeClickable(By.cssSelector(cssSelector)));
    }

}
