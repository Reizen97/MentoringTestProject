package com.mentoring.ui;

import com.mentoring.core.ConciseAPI;
import com.mentoring.core.EnvCofig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeDriver;


public class BaseTest {

    @BeforeEach
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        ConciseAPI.setDriver(new ChromeDriver());
        ConciseAPI.getDriver().manage().window().maximize();
    }

    @AfterEach
    public void tearDown() {
        ConciseAPI.getDriver().quit();
    }
}
