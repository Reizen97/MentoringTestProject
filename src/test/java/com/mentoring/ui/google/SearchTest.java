package com.mentoring.ui.google;

import com.mentoring.ui.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchTest extends BaseTest {

    @Test
    public void TestSearchResults() {

        SearchPage searchPage = new SearchPage();
        ResultsPage resultsPage = new ResultsPage();
        SeleniumPage seleniumPage = new SeleniumPage();

        searchPage.openGoogle("https://www.google.com/")
                .inputSearchQuery("selenium")
                .startSearch();

        String actualFirstUrl = resultsPage.getUrlFromFirstResult();

        assertEquals("https://www.seleniumhq.org/", actualFirstUrl);

        resultsPage.openFirstResult();

        String actualTitleFromResultPage = seleniumPage.getTitle();

        assertEquals("Browser Automation", actualTitleFromResultPage);
    }
}
