package com.mentoring.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static com.mentoring.core.ConciseAPI.getDriver;
import static com.mentoring.core.ConciseAPI.waiter;


public class BasePage {

    protected void clickToElement(By locator) {
        getDriver().findElement(locator).click();
    }

    protected void inputText(By locator, String text) {
        WebElement element = getDriver().findElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    protected void getUrl(String url) {
        getDriver().get(url);
    }

    protected WebElement getElement(ExpectedCondition<WebElement> condition) {
        return waiter(condition);
    }

    protected List<WebElement> getListOfElements(By locator) {
        waiter(ExpectedConditions.presenceOfElementLocated(locator));
        return getDriver().findElements(locator);
    }

    protected String getText(WebElement element) {
        return element.getText();
    }

    protected String getValue(WebElement element) {
        return element.getAttribute("href");
    }

    protected void waitPresentsOfElement(By locator) {
        waiter(ExpectedConditions.presenceOfElementLocated(locator));
    }

    protected void waitElementToBeClickable(By locator) {
        waiter(ExpectedConditions.elementToBeClickable(locator));
    }
}
