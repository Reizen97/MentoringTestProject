package com.mentoring.ui.gmail;

import com.mentoring.ui.BasePage;
import org.openqa.selenium.By;

import static com.mentoring.core.ConciseAPI.getDriver;
import static com.mentoring.core.ConciseAPI.waitFor;
import static java.lang.String.format;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;


public class GmailPage extends BasePage {

    public GmailPage createNewLetter() {

        waitFor(elementToBeClickable(By.xpath("//div[text()='Compose']"))).click();
        return this;
    }

    public GmailPage inputRecipient(String email) {

        getDriver().findElement(By.name("to")).sendKeys(email);
        return this;
    }

    public GmailPage inputSubject(String subject) {

        getDriver().findElement(By.name("subjectbox")).sendKeys(subject);
        return this;
    }

    public GmailPage inputMessage(String message) {

        getDriver().findElement(By.xpath("//div[@aria-label='Message Body']")).sendKeys(message);
        return this;
    }

    public GmailPage sendMessage() {

        getDriver().findElement(By.xpath("//div[text()='Send']")).click();
        waitFor(presenceOfElementLocated(By.xpath("//*[text()='Message sent.']")));
        return this;
    }

    public GmailPage clickOnFirstMessageWithSubject(String subject) {

        getDriver().findElement(By.xpath(format("(//span[contains(text(),'%s')])[2]", subject))).click();
        return this;
    }

    public String getSubjectOfLastMessage() {
        return waitFor(visibilityOfElementLocated(By.xpath("//tr[1]/td[6]/div/div/div"))).getText();
    }

    public GmailPage submitRegistration(String email) {

        waitFor(elementToBeClickable(By.xpath(format("(//*[contains(@name,'%s')]/ancestor::div[@class='adn ads']/descendant::a)[1]", email)))).click();
        return this;
    }
}
