package com.mentoring.ui.kieskeurig;

import com.mentoring.ui.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.mentoring.core.ConciseAPI.executeJavaScript;
import static com.mentoring.core.ConciseAPI.getDriver;
import static com.mentoring.core.ConciseAPI.waitFor;
import static java.lang.String.format;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class ProductPage extends BasePage {

    public ProductPage sort(String parameter) {

        waitFor(elementToBeClickable(By.cssSelector("div.sidebar-block div.dropdown"))).click();
        waitFor(elementToBeClickable(By.xpath(format("//*[@class='sidebar']/descendant::*[contains(text(), '%s')]", parameter)))).click();
        return this;
    }

    public List<WebElement> getAllProducts() {

        waitForAjax();
        return getDriver().findElements(By.cssSelector("div.js-product-lists article.product-tile"));
    }

    public Integer getPrice() {

        return Integer.valueOf(getDriver().findElement(By.cssSelector("span.price strong")).getText());
    }
}
