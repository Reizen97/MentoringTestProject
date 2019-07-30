package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class GmailPage extends BasePage {

    public GmailPage createNewLetter() {
        waitElementToBeClickable(By.xpath("//div[text()='Compose']"));
        clickToElement(By.xpath("//div[text()='Compose']"));
        return this;
    }

    public GmailPage inputRecipient(String email) {
        waitPresentsOfElement(By.name("to"));
        inputText(By.name("to"), email);
        return this;
    }

    public GmailPage inputSubject(String subject) {
        waitPresentsOfElement(By.name("subjectbox"));
        inputText(By.name("subjectbox"), subject);
        return this;
    }

    public GmailPage inputMessage(String message) {
        waitPresentsOfElement(By.xpath("//div[@aria-label='Message Body']"));
        inputText(By.xpath("//div[@aria-label='Message Body']"), message);
        return this;
    }

    public GmailPage sendMessage() {
        waitElementToBeClickable(By.xpath("//div[text()='Send']"));
        clickToElement(By.xpath("//div[text()='Send']"));
        waitPresentsOfElement(By.xpath("//*[text()='Message sent.']"));
        return this;
    }

    public String getSubjectOfLastMessage() {
        return getText(
                getElement(ExpectedConditions.presenceOfElementLocated(
                                By.xpath("//tr[1]/td[6]/div/div/div"))));
    }
}
