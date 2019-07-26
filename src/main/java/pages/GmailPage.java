package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static core.Configuration.EMAIL;
import static java.lang.String.format;

public class GmailPage extends BasePage {

    public GmailPage createNewLetter() {
        waitElementToBeClickable(By.xpath("//div[text()='Compose']"));
        clickToElement(By.xpath("//div[text()='Compose']"));
        return this;
    }

    public GmailPage inputRecipient(String email) {
        waitPresantsOfElement(By.name("to"));
        inputText(By.name("to"), email);
        return this;
    }

    public GmailPage inputSubject(String subject) {
        waitPresantsOfElement(By.name("subjectbox"));
        inputText(By.name("subjectbox"), subject);
        return this;
    }

    public GmailPage inputMessage(String message) {
        waitPresantsOfElement(By.xpath("//div[@aria-label='Message Body']"));
        inputText(By.xpath("//div[@aria-label='Message Body']"), message);
        return this;
    }

    public GmailPage sendMessage() {
        waitElementToBeClickable(By.xpath("//div[text()='Send']"));
        clickToElement(By.xpath("//div[text()='Send']"));
        waitPresantsOfElement(By.xpath("//*[text()='Message sent.']"));
        return this;
    }

    public String getSenderOfLastMessage() {
        String locator = format("(//span[@email='%s'])[2]", EMAIL);
        return getText(getElement
                (ExpectedConditions.presenceOfElementLocated
                        (By.xpath(locator))));
    }

}
