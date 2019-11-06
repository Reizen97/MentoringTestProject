package com.mentoring.ui.gmail;

import com.mentoring.ui.BasePage;
import org.openqa.selenium.By;

import static com.mentoring.core.ConciseAPI.waitFor;
import static java.lang.String.format;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;


public class GmailPage extends BasePage {

    public GmailPage clickOnFirstMessageWithSubject(String subject) {

        waitFor(elementToBeClickable(By.xpath(format("(//span[contains(text(),'%s')])[2]", subject)))).click();
        return this;
    }

    public GmailPage submitRegistration(String email) {

        waitFor(elementToBeClickable(By.xpath(format("(//*[contains(@name,'%s')]/ancestor::div[@class='adn ads']/descendant::a)[1]", email)))).click();
        return this;
    }
}
