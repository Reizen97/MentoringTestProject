package pageobjects;

import base.BasePage;
import org.openqa.selenium.By;

public class GoogleMainPage extends BasePage {

    public SignInPage singIn() {
        waitPresantsOfElement(By.id("gb_70"));
        clickToElement(By.id("gb_70"));
        return new SignInPage();
    }
}
