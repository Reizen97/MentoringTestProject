package com.mentoring.ui.google.search;

import com.mentoring.ui.BaseTest;
import com.mentoring.ui.google.search.ResultsPage;
import com.mentoring.ui.google.search.SearchPage;
import org.junit.jupiter.api.Test;

import static com.mentoring.core.ConciseAPI.getDriver;
import static com.mentoring.core.ConciseAPI.openUrl;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchTest extends BaseTest {

    @Test
    public void testSearchResults() {

        SearchPage searchPage = new SearchPage();
        ResultsPage resultsPage = new ResultsPage();

        openUrl("https://www.google.com/ncr");

        searchPage.inputSearchQuery("selenium");

        // FIXME
//        int numberOfResults = resultsPage.getNumberOfResults();
//        assertEquals(10, numberOfResults);

        assertEquals("https://www.seleniumhq.org/", resultsPage.getUrlFromFirstResult());

        resultsPage.openFirstResult();
        assertEquals("Selenium - Web Browser Automation", getDriver().getTitle());
    }
}
