package com.mentoring.ui.google;

import com.mentoring.ui.BasePage;
import org.openqa.selenium.By;

public class SearchPage extends BasePage {

    public SearchPage openGoogle(String url) {
        getUrl(url);
        return this;
    }

    public SearchPage inputSearchQuery(String query) {
        waitPresentsOfElement(By.cssSelector("input[title='Search']"));
        inputText(By.cssSelector("input[title='Search']"), query);
        return this;
    }

    public SearchPage startSearch() {
        waitElementToBeClickable(By.cssSelector("div:last-child > div > center > input[value='Google Search']"));
        clickToElement(By.cssSelector("div:last-child > div > center > input[value='Google Search']"));
        return this;
    }
}
