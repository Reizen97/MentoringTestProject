package com.mentoring.core;

import org.openqa.selenium.WebDriver;


public class ConciseAPI {

    private static WebDriver driver;

    public static void setDriver(WebDriver driver) {
        ConciseAPI.driver = driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }

}
