package com.epam.AirBaltic.util;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class AdditionalConditions {

    private static final String JAVA_SCRIPT_EXEC = "return (window.jQuery != null) && (jQuery.active === 0);";

    public static ExpectedCondition<Boolean> jQueryCompleted() {
        return driver -> (Boolean) ((JavascriptExecutor) driver).executeScript(JAVA_SCRIPT_EXEC);
    }

}
