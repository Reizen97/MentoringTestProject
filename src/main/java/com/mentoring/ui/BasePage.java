package com.mentoring.ui;

import org.openqa.selenium.By;

import static com.mentoring.core.ConciseAPI.clickToElement;
import static com.mentoring.core.ConciseAPI.waitFor;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;


public class BasePage {

    public void singIn() {
        waitFor(elementToBeClickable(By.xpath("//a[contains(@href,'accounts.google.com')]"))).click();
    }

    public void openGoogleApps() {
        clickToElement(By.xpath("//div/a[contains(@href,'https://www.google.com/intl')]"));
    }

    public void openGmail() {
        clickToElement(By.xpath("//li/a[contains(@href,'mail.google.com')]/span[@class='MrEfLc']"));
    }

}
