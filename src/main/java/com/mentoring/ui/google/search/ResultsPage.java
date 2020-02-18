package com.mentoring.ui.google.search;

import com.mentoring.ui.google.BasePage;
import org.openqa.selenium.By;

import static com.mentoring.ui.core.ConciseAPI.waitFor;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElementsLocatedBy;


public class ResultsPage extends BasePage {

    public String getUrlFromFirstResult() {
        return waitFor(presenceOfElementLocated(By.cssSelector("div > link"))).getAttribute("href");
    }

    public void openFirstResult() {

        waitElementClickability("h3 > div").click();
    }

    public int getNumberOfResults() {
        return waitFor(visibilityOfAllElementsLocatedBy(By.cssSelector(".srg > div"))).size();
    }
}
