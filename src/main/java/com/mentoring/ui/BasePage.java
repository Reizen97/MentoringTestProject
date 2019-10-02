package com.mentoring.ui;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.mentoring.core.ConciseAPI.action;

import static com.mentoring.core.ConciseAPI.executeJavaScript;
import static com.mentoring.core.ConciseAPI.getDriver;
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

    public void waitForAjax() {
        new WebDriverWait(getDriver(), 180).until((ExpectedCondition<Boolean>) driver -> {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            return (Boolean) (executor != null ? executor.executeScript("return jQuery.active == 0") : null);
        });
    }
}
