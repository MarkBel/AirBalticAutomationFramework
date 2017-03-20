package com.epam.AirBaltic.pages;

import com.epam.AirBaltic.util.AdditionalConditions;
import com.epam.AirBaltic.util.DateGenerator;
import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by Kseniya_Kunda on 3/1/2017.
 */
public class BookAFlightForm extends Page {

    @FindBy(css = "#positioner button")
    private WebElement buttonFindFlightsFares;

    @FindBy(css = "#flt_origin_text")
    private WebElement inputFlyFrom;

    @FindBy(css = "#flt_destin_text")
    private WebElement inputFlyTo;

    @FindBy(css = "#flt_leaving_on")
    private WebElement inputDepartureDate;

    @FindBy(css = "#top-dropdown-menu2+div")
    private WebElement buttonAddChild;

    @FindBy(css = "#top-dropdown-menu3+div")
    private WebElement buttonAddInfant;

    @FindBy(xpath = "//button[@id='flights-form-btn']")
    private WebElement btnBookAndFlights;

    @FindBy(xpath = "//div[@data-container-id='returnDate']/input[@id='flt_returning_on']")
    private WebElement inputReturnDate;

    @FindBy(xpath = "//span[@id='one_way-styler']")
    private WebElement radioBtnOneWayTrip;

    @FindBy(xpath = "//span[@id='flt_returning_on-error']")
    private WebElement returnDateErrorText;

    @FindBy(xpath = "//td[@id='errors']/span[@class='help-block']")
    private WebElement infantsNumberErrorText;

    @FindBy(xpath = "//a[@class=\"dropdown-toggle needsclick\" and text()='0 infants']")
    private WebElement listInfants;

    @FindBy(xpath = "//div[@id='mCSB_3_container']/li/a")
    private List<WebElement> listNumberOfInfants;

    @FindBy(xpath = "//button[@class='btn btn-default light-elem-btn button-green findflights-btn']")
    private WebElement btnBookandFlighAction;

    @FindBy(xpath = "//div[@id='positioner']/div/button")
    private WebElement buttonGoFlightsAndTicketsTypesPage;

    @FindBy(xpath = "//div[@id='return-date-div']")
    private WebElement fieldReturnDateVisibality;

    @FindBy(css = "#return-date-div label")
    private WebElement returnDateLabel;

    @FindBy(css = "#depDateGroup label")
    private WebElement departureDateLabel;

    private static int TOMORROW_DAY = 1;


    public BookAFlightForm(WebDriver driver) {
        super(driver);
    }

    private BookAFlightForm choseCountryFrom(String originAirport) {
        inputFlyFrom.clear();
        inputFlyFrom.sendKeys(originAirport);
        return this;
    }

    private BookAFlightForm choseCountryTo(String destinationAirport) {
        inputFlyTo.clear();
        inputFlyTo.sendKeys(destinationAirport);
        return this;
    }

    private void pressFindFlightsButton() {
        if (btnBookAndFlights.isDisplayed()) {
            btnBookAndFlights.click();
        }
        (new WebDriverWait(this.driver, WAIT_10_SEC)).until(AdditionalConditions.jQueryCompleted());
    }

    private BookAFlightForm setDepartureDate(int departureDateDelta) {
        wait.waitForElement(inputDepartureDate).clear();
        inputDepartureDate.sendKeys(DateGenerator.getDate(departureDateDelta));
        departureDateLabel.click();
        return this;
    }

//    public BookAFlightForm setDepartureDate(String date) {
//        wait.waitForElement(inputDepartureDate).clear();
//        inputDepartureDate.sendKeys(date);
//        return this;
//    }

    private BookAFlightForm setReturnDate(int returnDateDelta) {
        wait.waitForElement(inputReturnDate).clear();
        inputReturnDate.sendKeys(DateGenerator.getDate(returnDateDelta));
        returnDateLabel.click();
        return this;
    }

//    public BookAFlightForm setReturnDate(String date) {
//        wait.waitForElement(inputReturnDate).clear();
//        inputReturnDate.sendKeys(date);
//        return this;
//    }

    private BookAFlightForm clickFindFlightsFaresButton() {
        wait.waitForElementIsClickable(buttonFindFlightsFares).click();
//       (new WebDriverWait(this.driver, WAIT_10_SEC)).until(AdditionalConditions.jQueryCompleted());
//        (new WebDriverWait(this.driver, WAIT_10_SEC)).until(ExpectedConditions.invisibilityOf(buttonFindFlightsFares));
        return this;
    }

    public FlightsAndTicketTypesPage goToFlightsAndTicketTypesPage() {
        clickFindFlightsFaresButton();
        return new FlightsAndTicketTypesPage(driver);
    }

    public BookAFlightForm fillBookAndFlightForm(String originAirport, String destinationAirport, int depDateDelta, int returnDateDelta) {
        choseCountryFrom(originAirport);
        choseCountryTo(destinationAirport);
        pressFindFlightsButton();
        setDepartureDate(depDateDelta);
        setReturnDate(returnDateDelta);
        return this;
    }

    public BookAFlightForm addChild() {
        buttonAddChild.click();
        return this;
    }

    public boolean checkReturnDate(String originAirport, String destinationAirport, int returnInvalidDateDelta, String ERROR_MESSAGE) {
        choseCountryFrom(originAirport);
        choseCountryTo(destinationAirport);
        pressFindFlightsButton();
        setDepartureDate(TOMORROW_DAY);
        setReturnDate(returnInvalidDateDelta);
        inputReturnDate.submit();
//        clickFindFlightsFaresButton();
        return getErrorMessage().equals(ERROR_MESSAGE);
    }

    public boolean checkOneWayTripReturnDateVisibility(String originAirport, String destinationAirport, String RETURN_DATE_ATTRIBUTE) {
        choseCountryFrom(originAirport);
        choseCountryTo(destinationAirport);
        pressFindFlightsButton();
        wait.waitForElementIsClickable(radioBtnOneWayTrip).click();
        (new WebDriverWait(this.driver, WAIT_10_SEC)).until(AdditionalConditions.jQueryCompleted());
        return fieldReturnDateVisibality.isDisplayed();
    }

    public boolean checkNumberInfantsTickets(String originAirport, String destinationAirport, String ERROR_INPUT_EXCEPTION, int returnDateDelta) {
        choseCountryFrom(originAirport);
        choseCountryTo(destinationAirport);
        pressFindFlightsButton();
        setDepartureDate(TOMORROW_DAY);
        setReturnDate(returnDateDelta);
        addInfants(2);
        clickFindFlightsFaresButton();
        (new WebDriverWait(this.driver, WAIT_10_SEC)).ignoring(ElementNotFoundException.class).
                                            until(ExpectedConditions.visibilityOf(infantsNumberErrorText));
//        wait.waitForElement(buttonFindFlightsFares);
//        String outputText = getErrorMessage();
//        logger.info("In fact error message is: " + outputText);
        return getErrorMessage().contains(ERROR_INPUT_EXCEPTION);
    }

    private String getErrorMessage() {
        String errorMsg;
        if (infantsNumberErrorText.isDisplayed()) {
            errorMsg = infantsNumberErrorText.getText();
        } else if (returnDateErrorText.isDisplayed()) {
            errorMsg = returnDateErrorText.getText();
        } else {
            errorMsg = "";
        }
        return errorMsg;
    }

    private void addInfants(int number) {
        wait.waitForElementIsClickable(listInfants).click();
        wait.waitForElementIsClickable(listNumberOfInfants.get(number + 1)).click();
    }

}
