import base.WebDriverSetUp;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.GoogleMainPage;
import pageobjects.SignInPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SendLetterTest {
    private WebDriverContext webDriverContext;

    private GoogleMainPage googleMainPage;
    private SignInPage signInPage;

    public SendLetterTest(WebDriverContext webDriverContext) {
        this.webDriverContext = webDriverContext;
    }

    @BeforeEach
    public void openBrowser() {
        webDriverContext = WebDriverContextSetUp.setUpWebDriverContext(webDriverContext);
    }

    @AfterEach
    public void closeBrowser() {
        WebDriverContextSetUp.closeWebDriver(webDriverContext);
    }

    @Test
    public void sendLetter() {
        googleMainPage = webDriverContext.getBasePegeManager().openGoogle();
        googleMainPage.singIn();
        signInPage.inputEmail("ab4180964@gmail.com");
        signInPage.inputPassword("ab<3appels");
//        assertTrue(driver.findElement(By.id("identifierId")).isDisplayed());
//        driver.findElement(By.id("identifierId")).sendKeys("ab4180964@gmail.com");
//        driver.findElement(By.id("identifierNext")).click();
//        waitUntilPresent(By.xpath("//input[@name='password']"));
//        assertTrue(driver.findElement(By.id("profileIdentifier")).isDisplayed());
//        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("ab<3appels");
//        WebDriverWait wait = new WebDriverWait(driver, 5);
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='passwordNext']")));
//        driver.findElement(By.xpath("//div[@id='passwordNext']")).click();
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Gmail']")));
//        driver.findElement(By.xpath("//a[text()='Gmail']")).click();
//        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".T-I-KE")));
//        driver.findElement(By.cssSelector(".T-I-KE")).click();
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='New Message']")));
//
//        driver.findElement(By.id(":97")).sendKeys("ab4180964@gmail.com");
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='subjectbox']")));
//        driver.findElement(By.xpath("//input[@name='subjectbox']")).sendKeys("Test");
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-label='Message Body']")));
//        driver.findElement(By.xpath("//div[@aria-label='Message Body']")).sendKeys("Test");
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-label='Send (Ctrl-Enter)']")));
//        driver.findElement(By.xpath("//div[@aria-label='Send (Ctrl-Enter)']")).click();
    }
}
