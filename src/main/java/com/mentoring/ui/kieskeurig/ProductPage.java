package com.mentoring.ui.kieskeurig;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.Collectors;

import static com.mentoring.ui.core.ConciseAPI.action;
import static com.mentoring.ui.core.ConciseAPI.getDriver;
import static com.mentoring.ui.core.ConciseAPI.waitFor;
import static java.lang.String.format;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElementsLocatedBy;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class ProductPage extends BasePage {

    public ProductPage sort(String parameter) {

        waitFor(elementToBeClickable(By.cssSelector("div.sidebar-block div.dropdown"))).click();
        waitFor(elementToBeClickable(By.xpath(format("//*[@class='sidebar']/descendant::*[contains(text(), '%s')]", parameter)))).click();
        return this;
    }

    public ProductPage selectSubscription() {

        waitFor(elementToBeClickable(By.xpath("//input[@id='tds_true']/.."))).click();
        return this;
    }

    public ProductPage selectFilters(String filter) {

        action().moveToElement(waitFor(elementToBeClickable(By.xpath(format("//label/span[contains(text(),'%s')]",filter)))))
                .click()
                .build()
                .perform();
        waitFor(visibilityOfElementLocated(By
                .xpath(format("//li[@class = 'filter-single ellipsis']/span[contains(text(),'%s')]",filter))));

        return this;
    }

    public List<WebElement> getAllProducts() {

        do {
            action().moveToElement(waitFor(visibilityOfElementLocated(By.cssSelector("div.pagination"))))
                    .moveToElement(waitFor(visibilityOfElementLocated(By.cssSelector(".site-footer__copyright"))))
                    .build().perform();
        } while (getDriver().findElements(By.id("js-product-list-scroll-detection")).size() > 0);


        return waitFor(visibilityOfAllElementsLocatedBy(By.cssSelector("div.js-product-lists>div.products>article.product-tile.js-product")));
    }

    public List<Double> getPrice(List<WebElement> products) {

        return products.stream()
                .filter(i->i.getText().contains("v.a."))
                .map(i -> Double.valueOf(i.findElement(By.cssSelector("span.price strong")).getText()
                        .replaceAll("€ ","").replaceAll(",", ".")))
                .collect(Collectors.toList());
    }

    public ProductPage showAllFilters(String filterName) {

        action().moveToElement(waitFor(elementToBeClickable(
                By.xpath(format("(//*[contains(text(),'%s')]/../following-sibling::*/descendant::a[@class='filter-expand'])[1]",
                        filterName)))))
                .click()
                .build()
                .perform();

        return this;
    }

    public List<Double> getReviewScore() {

        return waitFor(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#products .rating .label"))).stream()
                .map(WebElement::getText)
                .map(ProductPage::replace)
                .map(Double::parseDouble)
                .collect(Collectors.toList());
    }

    public static String replace(String string) {
        return string.replace(",",".");
    }

    public int getNumbersOfResults() {

        return Integer.valueOf(waitFor(visibilityOfElementLocated(By.cssSelector(".results")))
                .getText().replaceAll("[a-zA-Z]", "").trim());
    }
}