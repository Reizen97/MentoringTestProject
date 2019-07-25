package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    private WebDriverSetUp webDriverSetUp;
    public WebDriver driver = webDriverSetUp.getDriver();
    private WebDriverWait wait = new WebDriverWait(driver, 5);

    protected void clickToElement(By locator) {
        driver.findElement(locator).click();
    }

    protected void inputText(By locator, String text) {
        driver.findElement(locator).sendKeys(text);
    }

    protected void waitPresantsOfElement(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    protected void waitElementToBeClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

}
