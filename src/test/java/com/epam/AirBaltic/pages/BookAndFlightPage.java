package com.epam.AirBaltic.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

/**
 * Created by Mark_Rudak on 3/1/2017.
 */
public class BookAndFlightPage extends Page {

    private static final String errorMessage = "The date of the inbound flight cannot be earlier than the date of the outbound flight. Please adjust your selection.";

    @FindBy(xpath = "//div[@data-container-id=\"returnDate\"]/input[@id=\"flt_returning_on\"]")
    WebElement inptReturnDate;

    @FindBy(xpath = "//span[@id='flt_returning_on-error']")
    WebElement inptError;

    public BookAndFlightPage(WebDriver driver) {
        super(driver);
    }


    public boolean checkReturnDate() {
        inptReturnDate.sendKeys("01.02.2017");
        inptReturnDate.sendKeys(Keys.ENTER);

        driver.manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS);

        return errorMessage.equals(inptError.getText());

    }


}
