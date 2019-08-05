package com.mentoring.ui.google;

import com.mentoring.ui.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SeleniumPage extends BasePage {

    public String getTitle() {
        return  getText(getElement(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector("h1 > a"))));
    }
}
