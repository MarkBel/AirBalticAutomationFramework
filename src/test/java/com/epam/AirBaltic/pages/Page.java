package com.epam.AirBaltic.pages;

import com.epam.AirBaltic.util.FluentWaitUtil;
import com.epam.AirBaltic.util.SessionHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * Abstract class representation of a Page in the UI. Page object pattern
 */
public abstract class Page {

    protected final static Integer WAIT_3_SEC = 3;
    protected final static Integer WAIT_5_SEC = 5;
    protected final static Integer WAIT_10_SEC = 10;
    protected final static Integer WAIT_15_SEC = 15;

    private static final By buttonClose = By.xpath("//div[@class='insider-opt-in-notification-button insider-opt-in-disallow-button']");


    protected WebDriver driver;
    protected FluentWaitUtil wait;
    Logger logger = Logger.getLogger("TestLogger");

    public Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        wait = new FluentWaitUtil(driver);
        closePopUpWindow();
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

    public void closePopUpWindow()
    {
        if(!isElementPresent(buttonClose,driver))
        {

        }
        else
        {
            WebElement element = driver.findElement(buttonClose);
            element.click();
        }
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    public static boolean isElementPresent(By by,WebDriver driver)
    {
        boolean present;
        try
        {
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
            driver.findElement(by);
            present = true;
        }catch (NoSuchElementException e)
        {
            present = false;
        }
        return present;
    }
}
