package com.epam.AirBaltic.pages;

import com.epam.AirBaltic.util.FluentWaitUtil;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * Abstract class representation of a Page in the UI. Page object pattern
 */
public abstract class Page {

    protected WebDriver driver;
    protected FluentWaitUtil wait;
    Logger logger = Logger.getLogger("TestLogger");

    public Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        wait = new FluentWaitUtil(driver);
    }


    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void jsExecutorWork(WebElement webElement) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", webElement);
    }

    public boolean isElementPresent(By by) {
        return driver.findElements(by).size() > 0;
    }

}
