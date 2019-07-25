package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverSetUp {
    private WebDriver driver;

    public WebDriver getDriver() {
        if (driver == null) {
            createDriver();
        }
        return driver;
    }

    private void createDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    public void closeDriver() {
        driver.close();
        driver.quit();
    }
}
