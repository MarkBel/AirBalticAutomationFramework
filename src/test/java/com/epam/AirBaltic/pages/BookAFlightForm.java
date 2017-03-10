package com.epam.AirBaltic.pages;

import com.epam.AirBaltic.util.DateGenerator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    @FindBy(xpath = "//div[@data-container-id=\"returnDate\"]/input[@id=\"flt_returning_on\"]")
    private WebElement inputReturnDate;

    @FindBy(xpath = "//span[@id='one_way-styler']")
    private WebElement radioBtnOneWayTrip;

    @FindBy(xpath = "//span[@id='flt_returning_on-error']")
    private WebElement inputError;

    @FindBy(xpath = "//td[@id='errors']/span")
    private WebElement inputNumberOfInfantsError;

    @FindBy(xpath = "//a[@class=\"dropdown-toggle needsclick\" and text()='0 infants']")
    private WebElement listInfants;

    @FindBy(xpath = "//div[@id='mCSB_3_container']/li[3]/a")
    private WebElement numberOfInfants;

    @FindBy(xpath = "//button[@class='btn btn-default light-elem-btn button-green findflights-btn']")
    private WebElement btnBookandFlighAction;

    @FindBy(xpath = "//div[@id='positioner']/div/button")
    private WebElement buttonGoFlightsAndTicketsTypesPage;

    @FindBy(xpath = "//div[@id=\"return-date-div\"]")
    private WebElement fieldReturnDateVisibality;


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
    }

    private BookAFlightForm setDepartureDate(int departureDateDelta) {
        setDepartureDate(DateGenerator.getDate(departureDateDelta));
        return this;
    }

    private BookAFlightForm setReturnDate(int returnDateDelta) {
        setReturnDate(DateGenerator.getDate(returnDateDelta));
        return this;
    }

    private BookAFlightForm setUnvalidReturnDate(int returnUnvalidDateDelta) {
        setReturnDate(DateGenerator.getDate(returnUnvalidDateDelta));
        return this;
    }

    public BookAFlightForm setDepartureDate(String date) {
        //System.out.println(inputDepartureDate.getLocation());
        wait.waitForElement(inputDepartureDate).clear();
        inputDepartureDate.sendKeys(date);
        return this;
    }

    public BookAFlightForm setReturnDate(String date) {
        //System.out.println(inputReturnDate.getLocation());
        wait.waitForElement(inputReturnDate).clear();
        inputReturnDate.sendKeys(date);
        return this;
    }

    private BookAFlightForm clickFindFlightsFaresButton() {
        wait.waitForElement(buttonFindFlightsFares);
        buttonFindFlightsFares.click();
        return this;
    }

    public FlightsAndTicketTypesPage goToFlightsAndTicketTypesPage() {
        clickFindFlightsFaresButton();
        return new FlightsAndTicketTypesPage(driver);
    }

    public BookAFlightForm fillBookAndFlightForm(String originAirport, String destinationAirport, int dep_date_delta, int return_date_delta) {
        choseCountryFrom(originAirport);
        choseCountryTo(destinationAirport);
        pressFindFlightsButton();
        setDepartureDate(dep_date_delta);
        setReturnDate(return_date_delta);
        return this;
    }

    public BookAFlightForm addChild() {
        buttonAddChild.click();
        return this;
    }

    public void addInfant() {
        buttonAddInfant.click();
        buttonAddInfant.click();
    }

    public boolean checkReturnDate(String originAirport, String destinationAirport, int returnUnvalidDateDelta, String ERROR_MESSAGE) {
        choseCountryFrom(originAirport);
        choseCountryTo(destinationAirport);
        if (btnBookAndFlights.isDisplayed()) {
            btnBookAndFlights.click();
        }
        setUnvalidReturnDate(returnUnvalidDateDelta);
        clickFindFlightsFaresButton();
        return ERROR_MESSAGE.equals(inputError.getText());

    }

    public boolean checkOneWayTripAction(String originAirport, String destinationAirport, String RETURN_DATE_ATTRIBUTE) {
        choseCountryFrom(originAirport);
        choseCountryTo(destinationAirport);
        if (btnBookAndFlights.isDisplayed()) {
            btnBookAndFlights.click();
        }
        radioBtnOneWayTrip.click();
        return RETURN_DATE_ATTRIBUTE.equals(fieldReturnDateVisibality.getAttribute("style"));
    }

    public boolean checkNumberInfactsTickets(String originAirport, String destinationAirport, String ERROR_INPUT_EXCEPTION) {
        choseCountryFrom(originAirport);
        choseCountryTo(destinationAirport);
        if (btnBookAndFlights.isDisplayed()) {
            btnBookAndFlights.click();
        }
        setReturnDate(DateGenerator.getDate(6));
        addTwoInfants();
        btnBookandFlighAction.click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(inputNumberOfInfantsError));
        String textMessage = inputNumberOfInfantsError.getText().substring(0, inputNumberOfInfantsError.getText().indexOf('(') - 1);
        return textMessage.equals(ERROR_INPUT_EXCEPTION);
    }

    private void addTwoInfants() {
        listInfants.click();
        numberOfInfants.click();
    }

}
