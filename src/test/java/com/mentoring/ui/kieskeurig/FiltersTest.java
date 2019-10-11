package com.mentoring.ui.kieskeurig;

import com.mentoring.ui.BaseTest;
import org.junit.jupiter.api.Test;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.mentoring.core.ConciseAPI.openUrl;
import static com.mentoring.core.Configuration.KIESKEURIG_EMAIL;
import static com.mentoring.core.Configuration.KIESKEURIG_PASSWORD;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class FiltersTest extends BaseTest {

    @Test
    public void filterPriceDescendingTest() {

        MainPage mainPage = new MainPage();
        ProductPage productPage = new ProductPage();
        LoginTabPage loginTabPage = new LoginTabPage();

        openUrl("https://www.kieskeurig.nl/");

        mainPage.acept();

        mainPage.openLoginFrame();
        loginTabPage.openLoginTab()
                .inputLogin(KIESKEURIG_EMAIL)
                .inputPassword(KIESKEURIG_PASSWORD)
                .login();

        mainPage.selectCategory("smartphone");

        List<Double> priceOfSmartphones = productPage.getPrice(productPage.sort("Prijs - Aflopend")
                .showAllFilters("Merken")
                .selectFilters("Nokia")
                .selectSubscription()
                .selectFilters("5 tot 6 inch")
                .selectFilters("6 tot 7 inch")
                .getAllProducts());

        List<Double> sortedPrices = priceOfSmartphones.stream()
                .sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        assertEquals(priceOfSmartphones, sortedPrices);
    }

    @Test
    public void filterReviewScoreTest() {

        MainPage mainPage = new MainPage();
        ProductPage productPage = new ProductPage();
        LoginTabPage loginTabPage = new LoginTabPage();

        openUrl("https://www.kieskeurig.nl/");

        mainPage.acept();

        mainPage.openLoginFrame();
        loginTabPage.openLoginTab()
                .inputLogin(KIESKEURIG_EMAIL)
                .inputPassword(KIESKEURIG_PASSWORD)
                .login();

        mainPage.selectCategory("wasmachine");

        List<Double> reviewScore = productPage.sort("Reviewscore")
                                              .showAllFilters("Merken")
                                              .selectFilters("Zanussi")
                                              .getReviewScore();

        List<Double> sortedReviewScore = reviewScore.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        assertEquals(reviewScore, sortedReviewScore);
    }
}
