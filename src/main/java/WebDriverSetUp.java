import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverSetUp {
    private WebDriver driver;

    public WebDriver getDriver() {
        if (driver == null) {
            closeDriver();
        }
        return driver;
    }

    private void createDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    private void closeDriver() {
        driver.close();
        driver.quit();
    }
}
