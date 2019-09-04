package com.mentoring.ui.google;

import com.mentoring.ui.BasePage;
import org.openqa.selenium.By;

import static com.mentoring.core.ConciseAPI.getText;

public class SeleniumPage extends BasePage {

    public String getTitle() {
        return  getText(By.cssSelector("h1 > a"));
    }
}
