package com.epam.AirBaltic.util;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class FluentWaitUtil {
    private WebDriver driverWait;
    private Wait<WebDriver> wait;
    private Wait<WebDriver> waitFluent;
    private final int WAIT_15_SEC = 15;


    public FluentWaitUtil(WebDriver driver) {
        this.driverWait = driver;
        wait = new WebDriverWait(this.driverWait, WAIT_15_SEC).ignoring(StaleElementReferenceException.class, WebDriverException.class)
                .withMessage("Element was not found by locator!");
        waitFluent = new org.openqa.selenium.support.ui.FluentWait<>(driver).withTimeout(15, TimeUnit.MINUTES).pollingEvery(2, TimeUnit.MINUTES).ignoring(ElementNotFoundException.class);
    }

    public WebElement waitForElementIsClickable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }

    public WebElement waitForElement(WebElement element){
        waitFluent.until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }
}
