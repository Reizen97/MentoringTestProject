package com.mentoring.ui.google;

import com.mentoring.ui.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

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

    public int getNumberOfResults() {

        return getListOfElements(By.cssSelector("div > link")).size()
                + getListOfElements(By.cssSelector(".srg > .g")).size();
    }
}
