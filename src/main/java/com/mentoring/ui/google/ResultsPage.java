package com.mentoring.ui.google;

import com.mentoring.ui.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ResultsPage extends BasePage {

    public String getUrlFromFirstResult() {
        return getValue(getElement(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector("div > link"))));
    }

    public ResultsPage openFirstResult() {
        waitElementToBeClickable(By.xpath("//div/link/../div/div/div/a"));
        clickToElement(By.xpath("//div/link/../div/div/div/a"));
        return this;
    }
}
