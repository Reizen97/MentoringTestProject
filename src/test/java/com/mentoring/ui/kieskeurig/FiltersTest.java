package com.mentoring.ui.kieskeurig;

import com.mentoring.ui.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.mentoring.core.ConciseAPI.openUrl;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FiltersTest extends BaseTest {

    @Test
    public void filtersForCurrencyTest() {

        MainPage mainPage = new MainPage();
        ProductPage productPage = new ProductPage();

        openUrl("https://www.kieskeurig.nl/");

        //TODO Add login

        mainPage.acept()
                .selectCategory("smartphone");

        List<WebElement> products = productPage.sort("Prijs - Aflopend")
                .getAllProducts();

        List<String> priceOfSmartphones = products.stream()
                .map(i -> i.findElement(By.cssSelector("span.price strong")).getText())
                .collect(Collectors.toList());

        List<String> sortedPrices = priceOfSmartphones.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        assertEquals(priceOfSmartphones, sortedPrices);
    }
}
