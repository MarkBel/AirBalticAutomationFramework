package com.epam.AirBaltic.pages;

import com.epam.AirBaltic.util.DateGenerator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by Kseniya_Kunda on 3/1/2017.
 */
public class BookAFlightForm extends Page{

    private String originAirport = "Riga (RIX) - Latvia";
    private String destinationAirport = "Berlin (Tegel) (TXL) - Germany";
    private static final String ERROR_MESSAGE = "The date of the inbound flight cannot be earlier than the date of the outbound flight. Please adjust your selection.";
    private static final String RETURN_DATE_ATTRIBUTE = "display: none;";
    private static final String ERROR_INPUT_EXCEPTION = "The number of infants can not be higher than the number of adults. Only an adult can accompany an infant.";
    private int departureDateDelta = 2;
    private int returnDateDelta = 5;

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

    private BookAFlightForm choseCountryFrom(){
        inputFlyFrom.clear();
        inputFlyFrom.sendKeys(originAirport);
        return this;
    }

    private BookAFlightForm choseCountryTo(){
        inputFlyTo.clear();
        inputFlyTo.sendKeys(destinationAirport);
        return this;
    }

    private void pressFindFlightsButton(){
        if (btnBookAndFlights.isDisplayed()) {
            btnBookAndFlights.click();
        }
    }

    private BookAFlightForm setDepartureDate(){
        setDepartureDate(DateGenerator.getDate(departureDateDelta));
        return this;
    }

    private BookAFlightForm setReturnDate(){
        setReturnDate(DateGenerator.getDate(returnDateDelta));
        return this;
    }

    public FlightsAndTicketTypesPage goToFlightsAndTicketTypesPage(){
        buttonFindFlightsFares.click();
        return new FlightsAndTicketTypesPage(driver);
    }

    public BookAFlightForm fillBookAndFlightForm() {
        choseCountryFrom();
        choseCountryTo();
        pressFindFlightsButton();
        setDepartureDate();
        setReturnDate();
        return this;
    }

    public void addChild(){
        buttonAddChild.click();
    }

    public void addInfant(){
        buttonAddInfant.click();
        buttonAddInfant.click();
    }

    public BookAFlightForm setDepartureDate(String date){
        inputDepartureDate.sendKeys(date);
        inputDepartureDate.sendKeys(Keys.ENTER);
        return this;
    }

    public BookAFlightForm setReturnDate(String date){
        inputReturnDate.sendKeys(date);
        inputReturnDate.sendKeys(Keys.ENTER);
        return this;
    }

    public boolean checkReturnDate() {
        choseCountryFrom();
        choseCountryTo();
        btnBookAndFlights.click();
        setReturnDate("01.02.2017");
        return ERROR_MESSAGE.equals(inputError.getText());

    }

    public boolean checkOneWayTripAction() {
        choseCountryFrom();
        choseCountryTo();
        if (btnBookAndFlights.isDisplayed()) {
            btnBookAndFlights.click();
        }
        radioBtnOneWayTrip.click();
        return RETURN_DATE_ATTRIBUTE.equals(fieldReturnDateVisibality.getAttribute("style"));
    }

    public boolean checkNumberInfactsTickets() {
        choseCountryFrom();
        choseCountryTo();
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

    private void addTwoInfants()
    {
        listInfants.click();
        numberOfInfants.click();
    }

}
