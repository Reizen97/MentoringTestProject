package com.mentoring.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.mentoring.core.ConciseAPI.getDriver;
import static com.mentoring.core.Configuration.TIMEOUT;

public class BasePage {

    private WebDriverWait wait =  new WebDriverWait(getDriver(), TIMEOUT);

    protected void clickToElement(By locator) {
        getDriver().findElement(locator).click();
    }

    protected void inputText(By locator, String text) {
        getDriver().findElement(locator).sendKeys(text);
    }

    protected void getUrl(String url) {
        getDriver().get(url);
    }

    protected WebElement getElement(ExpectedCondition<WebElement> condition) {
        return wait.until(condition);
    }

    protected String getText(WebElement element) {
        return element.getText();
    }

    protected void waitPresentsOfElement(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    protected void waitElementToBeClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
}
