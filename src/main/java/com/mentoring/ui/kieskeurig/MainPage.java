package com.mentoring.ui.kieskeurig;

import com.mentoring.ui.BasePage;
import org.openqa.selenium.By;

import static com.mentoring.core.ConciseAPI.getDriver;
import static java.lang.String.format;

public class MainPage extends BasePage {

    public MainPage acept() {

        getDriver().findElement(By.cssSelector("div.modal-consent__right button.js-consent-accept")).click();
        return this;
    }

    public MainPage selectCategory(String category) {

        getDriver().findElement(By.cssSelector(format("div.cat-tile--single-category a[href='/%s']", category))).click();
        return this;
    }
}
