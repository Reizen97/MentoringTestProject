package com.mentoring.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.mentoring.core.ConciseAPI.action;
import static com.mentoring.core.ConciseAPI.clickToElement;
import static com.mentoring.core.ConciseAPI.waitFor;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfAllElementsLocatedBy;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;


public class BasePage {

    public void singIn() {
        waitFor(elementToBeClickable(By.xpath("//a[contains(@href,'accounts.google.com')]"))).click();
    }

    public void openGoogleApps() {
        WebElement burger = waitFor(elementToBeClickable(By.cssSelector("#gbwa")));

        action().moveToElement(burger).perform();
        burger.click();

    }

    public void openGmail() {
        WebElement burger = waitFor(elementToBeClickable(By.cssSelector("#gbwa")));

        action().moveToElement(burger).perform();

        WebElement gmail = waitFor(presenceOfElementLocated(By.xpath("//li/a[contains(@href,'mail.google.com')]/span[@class='MrEfLc']")));

        action().moveToElement(burger).perform();
        gmail.click();
    }

}
