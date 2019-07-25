package pageobjects;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage extends BasePage {
    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public SignInPage inputEmail(String email) {
        waitPresantsOfElement(By.id("identifierId"));
        inputText(By.id("identifierId"), email);
        waitElementToBeClickable(By.id("identifierNext"));
        clickToElement(By.id("identifierNext"));
        return this;
    }

    public MailboxPage inputPassword(String password) {
        waitPresantsOfElement(By.xpath("//input[@name='password']"));
        inputText(By.xpath("//input[@name='password']"), password);
        waitElementToBeClickable(By.xpath("//div[@id='passwordNext']"));
        clickToElement(By.xpath("//div[@id='passwordNext']"));
        return new MailboxPage();
    }
}
