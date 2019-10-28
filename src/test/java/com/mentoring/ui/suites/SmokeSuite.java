package com.mentoring.ui.suites;

import com.mentoring.ui.kieskeurig.RegistrationTest;
import com.mentoring.ui.kieskeurig.UIElementsTest;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;


@RunWith(JUnitPlatform.class)
@SelectClasses({RegistrationTest.class
                , UIElementsTest.class
})
public class SmokeSuite {
}
