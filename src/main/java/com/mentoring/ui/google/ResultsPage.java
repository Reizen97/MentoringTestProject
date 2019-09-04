package com.mentoring.ui.google;

import com.mentoring.ui.BasePage;
import org.openqa.selenium.By;

import static com.mentoring.core.ConciseAPI.clickToElement;
import static com.mentoring.core.ConciseAPI.getAttribute;
import static com.mentoring.core.ConciseAPI.getListOfElements;


public class ResultsPage extends BasePage {

    public String getUrlFromFirstResult() {
        return getAttribute(By.cssSelector("div > link"), "href");
    }

    public ResultsPage openFirstResult() {

        clickToElement(By.xpath("//div/link/../div/div/div/a"));
        return this;
    }

    public int getNumberOfResults() {
        return getListOfElements(By.cssSelector("div.srg > div.g > div")).size();
    }
}
