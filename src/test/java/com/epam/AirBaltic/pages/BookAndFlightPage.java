package com.epam.AirBaltic.pages;

import org.junit.FixMethodOrder;
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

    private static final String ERROR_MESSAGE = "The date of the inbound flight cannot be earlier than the date of the outbound flight. Please adjust your selection.";
    private static final String RETURN_DATE_ATTRIBUTE = "display: none;";
    private static final String ERROR_INPUT_EXCEPTION = "The number of infants can not be higher than the number of adults. Only an adult can accompany an infant.";

    @FindBy(xpath = "//div[@data-container-id=\"returnDate\"]/input[@id=\"flt_returning_on\"]")
    WebElement inptReturnDate;

    @FindBy(xpath = "//span[@id='flt_returning_on-error']")
    WebElement inptError;

    @FindBy(xpath = "//span[@id='one_way-styler']")
    WebElement radioBtnOneWayTrip;

    @FindBy(xpath = "//div[@id='return-date-div']")
    WebElement elemReturnDate;

    @FindBy(xpath = "//a[@class=\"dropdown-toggle needsclick\" and text()='0 infants']")
    WebElement listInfants;

    @FindBy(xpath = "//div[@id='mCSB_3_container']/li[3]/a")
    WebElement numberOfInfants;

    @FindBy(xpath = "//button[@class='btn btn-default light-elem-btn button-green findflights-btn']")
    WebElement btnBookandFligh;

    @FindBy(xpath = "//td[@id='errors']/span")
    WebElement inputNumberOfInfantsError;

    public BookAndFlightPage(WebDriver driver) {
        super(driver);
    }


    public boolean checkReturnDate() {
        inptReturnDate.sendKeys("01.02.2017");
        inptReturnDate.sendKeys(Keys.ENTER);

        driver.manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS);

        return ERROR_MESSAGE.equals(inptError.getText());

    }

    public boolean checkOneWayTripAction() {

        radioBtnOneWayTrip.click();

        return RETURN_DATE_ATTRIBUTE.equals(elemReturnDate.getAttribute("style"));


    }

    public boolean checkNumberInfactsTichets() {

        inptReturnDate.sendKeys("10.03.2017");
        inptReturnDate.sendKeys(Keys.ENTER);


        driver.manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS);

        listInfants.click();

        numberOfInfants.click();

        btnBookandFligh.click();


        return inputNumberOfInfantsError.getText().contains(ERROR_INPUT_EXCEPTION);

    }


}
