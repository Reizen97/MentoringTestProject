package com.mentoring.ui.google;

import com.mentoring.ui.BaseTest;
import org.junit.jupiter.api.Test;

import static com.mentoring.core.ConciseAPI.openUrl;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchTest extends BaseTest {

    @Test
    public void testSearchResults() {

        SearchPage searchPage = new SearchPage();
        ResultsPage resultsPage = new ResultsPage();
        SeleniumPage seleniumPage = new SeleniumPage();

        openUrl("https://www.google.com/");

        searchPage.inputSearchQuery("selenium")
                .startSearch();

        int numberOfResults = resultsPage.getNumberOfResults();
        assertEquals(10, numberOfResults);

        String actualFirstUrl = resultsPage.getUrlFromFirstResult();

        assertEquals("https://www.seleniumhq.org/", actualFirstUrl);

        resultsPage.openFirstResult();

        String actualTitleFromResultPage = seleniumPage.getTitle();

        assertEquals("Browser Automation", actualTitleFromResultPage);
    }
}
