package com.mentoring.ui.google.search;

import com.mentoring.ui.google.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.mentoring.core.ConciseAPI.waitFor;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;


public class SearchPage extends BasePage {

    public void inputSearchQuery(String query) {

        waitFor(elementToBeClickable(By.cssSelector("input.gsfi"))).sendKeys(query + Keys.ENTER);
    }

}
