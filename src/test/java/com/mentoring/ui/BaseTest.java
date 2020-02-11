package com.mentoring.ui;

import com.mentoring.core.ConciseAPI;
import com.mentoring.core.Environment;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class BaseTest {

    public Environment env;

    @BeforeEach
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        ConciseAPI.setDriver(new ChromeDriver());
        ConciseAPI.getDriver().manage().window().maximize();
        env = ConfigFactory.create(Environment.class);
    }

    @AfterEach
    public void tearDown() {
        ConciseAPI.getDriver().quit();
    }
}
