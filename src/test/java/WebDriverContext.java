import base.BasePageManager;
import base.WebDriverSetUp;
import org.openqa.selenium.WebDriver;

public class WebDriverContext {
    private WebDriverSetUp webDriverSetUp;
    private WebDriver webDriver;
    private BasePageManager basePageManager;

    public BasePageManager getBasePageManager() {
        return basePageManager;
    }

    public void setBasePegeManager(BasePageManager basePageManager) {
        this.basePageManager = basePageManager;
    }



    public WebDriverSetUp getWebDriverSetUp() {
        return webDriverSetUp;
    }

    public void setWebDriverSetUp(WebDriverSetUp webDriverSetUp) {
        this.webDriverSetUp = webDriverSetUp;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

}
