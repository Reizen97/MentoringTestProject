package pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage{

    public LoginPage openGmail(String url) {
        getUrl(url);
        return this;
    }

    public LoginPage inputEmail(String email) {
        waitPresantsOfElement(By.id("identifierId"));
        inputText(By.id("identifierId"), email);
        waitElementToBeClickable(By.id("identifierNext"));
        clickToElement(By.id("identifierNext"));
        return this;
    }

    public GmailPage inputPassword(String password) {
        waitPresantsOfElement(By.name("password"));
        inputText(By.name("password"), password);
        waitElementToBeClickable(By.id("passwordNext"));
        clickToElement(By.id("passwordNext"));
        return new GmailPage();
    }
}
