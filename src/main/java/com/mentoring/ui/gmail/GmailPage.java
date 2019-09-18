package com.mentoring.ui.gmail;

import com.mentoring.ui.BasePage;
import org.openqa.selenium.By;

import static com.mentoring.core.ConciseAPI.clickToElement;
import static com.mentoring.core.ConciseAPI.getText;
import static com.mentoring.core.ConciseAPI.inputText;
import static com.mentoring.core.ConciseAPI.waitFor;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;


public class GmailPage extends BasePage {

    public GmailPage createNewLetter() {

        clickToElement(By.xpath("//div[text()='Compose']"));
        return this;
    }

    public GmailPage inputRecipient(String email) {

        inputText(By.name("to"), email);
        return this;
    }

    public GmailPage inputSubject(String subject) {

        inputText(By.name("subjectbox"), subject);
        return this;
    }

    public GmailPage inputMessage(String message) {

        inputText(By.xpath("//div[@aria-label='Message Body']"), message);
        return this;
    }

    public GmailPage sendMessage() {

        clickToElement(By.xpath("//div[text()='Send']"));
        waitFor(presenceOfElementLocated(By.xpath("//*[text()='Message sent.']")));
        return this;
    }

    public GmailPage clickOnFirstMessage() {

        clickToElement(By.cssSelector("div.Cp tr:first-child td:nth-child(6)"));
        return this;
    }

    public String getSubjectOfLastMessage() {
        return getText(By.xpath("//tr[1]/td[6]/div/div/div"));
    }

    public GmailPage submitRegistration() {

        clickToElement(By.cssSelector("div.h7.ie.nH.oy8Mbf div.a3s.aXjCH a:nth-child(2)"));
        return this;
    }
}
