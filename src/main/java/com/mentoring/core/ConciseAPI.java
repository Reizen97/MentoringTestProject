package com.mentoring.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.List;

import static com.mentoring.core.Configuration.POLLING;
import static com.mentoring.core.Configuration.TIMEOUT;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfAllElementsLocatedBy;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;


public final class ConciseAPI {

    private static WebDriver driver;

    public static void setDriver(WebDriver driver) {
        ConciseAPI.driver = driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static <T> T waitFor(ExpectedCondition<T> conditions, Duration timeout, Duration polling) {

        return new FluentWait<>(getDriver())
                .withTimeout(timeout)
                .pollingEvery(polling)
                .ignoring(WebDriverException.class, IndexOutOfBoundsException.class)
                .until(conditions);
    }

    public static <T> T waitFor(ExpectedCondition<T> conditions) {
        return waitFor(conditions, TIMEOUT, POLLING);
    }

    public static void clickToElement(By locator) {

        click(waitFor(elementToBeClickable(locator))).perform();
    }

    public static void inputText(By locator, String text) {

        waitFor(elementToBeClickable(locator)).clear();
        waitFor(elementToBeClickable(locator)).sendKeys(text);
    }

    public static void openUrl(String url) {
        getDriver().get(url);
    }

    public static List<WebElement> getListOfElements(By locator) {
        return waitFor(presenceOfAllElementsLocatedBy(locator));
    }

    public static String getText(By locator) {
        return waitFor(presenceOfElementLocated(locator)).getText();
    }

    public static String getAttribute(By locator, String attribute) {
        return waitFor(presenceOfElementLocated(locator)).getAttribute(attribute);
    }

    public static Actions click(WebElement element) {
        return new Actions(getDriver())
                .moveToElement(element)
                .click();
    }
}
