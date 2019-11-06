package com.mentoring.ui.kieskeurig;

import com.mentoring.ui.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.mentoring.helpers.Precondition.precondition;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UIElementsTest extends BaseTest {

    @Test
    public void testPresenceOfUIElements() {

        MainPage mainPage = new MainPage();

        precondition().visit(env.url())
                .accept().build();

        assertTrue(mainPage.isElementVisible(By.cssSelector("a.logo")));
        assertTrue(mainPage.isElementVisible(By.cssSelector("div.site-header__content a.js-show-login")));
        assertTrue(mainPage.isElementVisible(By.cssSelector(".search")));

        assertEquals("Kieskeurig.nl | Kijk wat 'ie kan", mainPage.getTitle());
    }
}
