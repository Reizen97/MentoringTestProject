package com.mentoring.ui.suites;

import com.mentoring.ui.gmail.MessageTest;
import com.mentoring.ui.google.search.SearchTest;
import com.mentoring.ui.kieskeurig.FiltersTest;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses({FiltersTest.class
                , MessageTest.class
                , SearchTest.class})
public class RegressionSuite {
}
