package com.mentoring.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.mentoring.core.Configuration.TIMEOUT;


public class ConciseAPI {

    private static WebDriver driver;

    public static void setDriver(WebDriver driver) {
        ConciseAPI.driver = driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static <T> T waiter(ExpectedCondition<T> conditions) {
        WebDriverWait wait = new WebDriverWait(getDriver(), TIMEOUT);
        return wait.until(conditions);
    }

}
