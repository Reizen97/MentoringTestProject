package pageobjects;

import base.BasePage;
import base.WebDriverSetUp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleMainPage extends BasePage {

    public GoogleMainPage(WebDriver driver) {
        super(driver);
    }

    public SignInPage singIn() {
        waitPresantsOfElement(By.id("gb_70"));
        clickToElement(By.id("gb_70"));
        return new SignInPage(driver);
    }
}
