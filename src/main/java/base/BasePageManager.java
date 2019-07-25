package base;

import org.openqa.selenium.WebDriver;
import pageobjects.GoogleMainPage;

public class BasePageManager {
    private WebDriver driver;

    public BasePageManager(WebDriver driver) {
        this.driver = driver;
    }

    public GoogleMainPage openGoogle() {
        driver.get("https://www.google.com/");
        return new GoogleMainPage(driver);
    }
}
