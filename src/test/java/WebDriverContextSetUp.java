import base.BasePageManager;
import base.WebDriverSetUp;
import org.openqa.selenium.WebDriver;

public class WebDriverContextSetUp {

    public static WebDriverContext setUpWebDriverContext(WebDriverContext webDriverContext) {
        WebDriverSetUp webDriverSetUp = new WebDriverSetUp();
        webDriverContext.setWebDriverSetUp(webDriverSetUp);

        WebDriver webDriver = webDriverSetUp.getDriver();
        webDriverContext.setWebDriver(webDriver);

        BasePageManager basePageManager = new BasePageManager(webDriver);
        webDriverContext.setBasePegeManager(basePageManager);

        return webDriverContext;
    }

    public static void closeWebDriver(WebDriverContext webDriverContext) {
        WebDriverSetUp webDriverSetUp = webDriverContext.getWebDriverSetUp();
        webDriverSetUp.closeDriver();
    }
}
