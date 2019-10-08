package com.mentoring.ui.kieskeurig;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

import static com.mentoring.core.ConciseAPI.action;
import static com.mentoring.core.ConciseAPI.getDriver;
import static com.mentoring.core.ConciseAPI.waitFor;
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
            action().moveToElement(waitFor(visibilityOfElementLocated(By.cssSelector("div.pagination")))).build().perform();
        } while (getDriver().findElements(By.id("js-product-list-scroll-detection")).size() == 1);

        return waitFor(visibilityOfAllElementsLocatedBy(By.cssSelector("div.js-product-lists article.product-tile.js-product")));
    }

    public List<String> getPrice(List<WebElement> products) {
        return products.stream()
                .map(i -> i.findElement(By.cssSelector("span.price strong")).getText().replaceAll("€ ",""))
                .collect(Collectors.toList());
    }
}
