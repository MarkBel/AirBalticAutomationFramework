package com.epam.AirBaltic.pages;

import com.epam.AirBaltic.util.FluentWaitUtil;
import com.epam.AirBaltic.util.SessionHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.logging.Logger;

/**
 * Abstract class representation of a Page in the UI. Page object pattern
 */
public abstract class Page {

    public final static Integer WAIT_3_SEC = 3;
    public final static Integer WAIT_5_SEC = 5;

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

    public void clickOnElementWithJS(WebElement webElement) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", webElement);
    }

    public void scrollToElementWithJS(WebElement webElement) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", webElement);
    }

    public boolean isElementPresent(By by) {
        return driver.findElements(by).size() > 0;
    }

    public void getScreenShot() {
        try {
            SessionHelper.captureScreenShot(this.driver, this.getClass().getSimpleName());
        } catch (IOException e) {
            logger.info(e.getMessage());
        }
    }
}
