package com.mentoring.ui;

import com.mentoring.core.ConciseAPI;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeDriver;


public class BaseTest {

    @BeforeEach
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        ConciseAPI.setDriver(new ChromeDriver());
    }

    @AfterEach
    public void tearDown() {
        ConciseAPI.getDriver().quit();
    }
}
