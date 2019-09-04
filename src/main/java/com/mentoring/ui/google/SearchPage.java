package com.mentoring.ui.google;

import com.mentoring.ui.BasePage;
import org.openqa.selenium.By;

import static com.mentoring.core.ConciseAPI.clickToElement;
import static com.mentoring.core.ConciseAPI.inputText;


public class SearchPage extends BasePage {

    public SearchPage inputSearchQuery(String query) {

        inputText(By.cssSelector("input.gsfi"), query);
        return this;
    }

    public SearchPage startSearch() {

        clickToElement(By.cssSelector("div[jsname='VlcLAe']> center > input:first-child"));
        return this;
    }
}
