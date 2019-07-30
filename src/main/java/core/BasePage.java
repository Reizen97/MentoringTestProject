package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static core.Configuration.TIMEOUT;


public class BasePage {
    private static WebDriver driver;
    private WebDriverWait wait =  new WebDriverWait(driver, TIMEOUT);

    public static void setDriver(WebDriver driver) {
        BasePage.driver = driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    protected void clickToElement(By locator) {
        driver.findElement(locator).click();
    }

    protected void inputText(By locator, String text) {
        driver.findElement(locator).sendKeys(text);
    }

    protected void getUrl(String url) {
        driver.get(url);
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
