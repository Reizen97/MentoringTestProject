package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeDriver;

import static pages.BasePage.getDriver;
import static pages.BasePage.setDriver;

public class BaseTest {

    @BeforeEach
    private void setUp() {
        WebDriverManager.chromedriver().setup();
        setDriver(new ChromeDriver());
    }

    @AfterEach
    public void tearDown() {
        getDriver().close();
        getDriver().quit();
    }
}
