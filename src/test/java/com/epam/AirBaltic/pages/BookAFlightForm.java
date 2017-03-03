package com.epam.AirBaltic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by Kseniya_Kunda on 3/1/2017.
 */
public class BookAFlightForm extends Page{

    private String originAirport = "Riga (RIX) - Latvia";
    private String destinationAirport = "Berlin (Tegel) (TXL) - Germany";
    By originCalendarDaysXpath = By.xpath("//div[@id='depDateGroup']//table/tbody/tr/td[@data-handler='selectDay']");
    By destinationCalendarDaysXpath = By.xpath("//div[@id='return-date-div']//table/tbody/tr/td[@data-handler='selectDay']");
    private static final String ERROR_MESSAGE = "The date of the inbound flight cannot be earlier than the date of the outbound flight. Please adjust your selection.";
    private static final String RETURN_DATE_ATTRIBUTE = "display: none;";
    private static final String ERROR_INPUT_EXCEPTION = "The number of infants can not be higher than the number of adults. Only an adult can accompany an infant.";


    @FindBy(css = "#positioner button")
    WebElement buttonFindFlightsFares;

    @FindBy(css = "#flt_origin_text")
    WebElement inputFlyFrom;

    @FindBy(css = "#flt_destin_text")
    WebElement inputFlyTo;

    @FindBy(css = "#flt_leaving_on")
    WebElement inputDepartureDate;

    @FindBy(css = "#flt_returning_on")
    WebElement inputReturnDate;

    @FindBy(css = "#top-dropdown-menu2+div")
    WebElement buttonAddChild;

    @FindBy(xpath = "//button[@id='flights-form-btn']")
    WebElement btnBookAndFlights;

    @FindBy(xpath = "//div[@data-container-id=\"returnDate\"]/input[@id=\"flt_returning_on\"]")
    WebElement inptReturnDate;

    @FindBy(xpath = "//span[@id='one_way-styler']")
    WebElement radioBtnOneWayTrip;

    @FindBy(xpath = "//span[@id='flt_returning_on-error']")
    WebElement inptError;


    @FindBy(xpath = "//td[@id='errors']/span")
    WebElement inputNumberOfInfantsError;

    @FindBy(xpath = "//a[@class=\"dropdown-toggle needsclick\" and text()='0 infants']")
    WebElement listInfants;

    @FindBy(xpath = "//div[@id='mCSB_3_container']/li[3]/a")
    WebElement numberOfInfants;

    @FindBy(xpath = "//button[@class='btn btn-default light-elem-btn button-green findflights-btn']")
    WebElement btnBookandFlighAction;

    @FindBy(xpath = "//div[@id='positioner']/div/button")
    private WebElement buttonGoFlightsAndTicketsTypesPage;

    @FindBy(xpath = "//div[@id=\"return-date-div\"]")
    WebElement fieldReturnDateVisibality;


    public BookAFlightForm(WebDriver driver) {
        super(driver);
    }

    public BookAFlightForm choseCountryFrom(){
        inputFlyFrom.clear();
        inputFlyFrom.sendKeys(originAirport);
        return this;
    }

    public BookAFlightForm choseCountryTo(){
        inputFlyTo.clear();
        inputFlyTo.sendKeys(destinationAirport);
        return this;
    }

    public void pressFindFlightsButton(){
        btnBookAndFlights.click();
    }

    public BookAFlightForm setDepartureDate(){
        if (inputDepartureDate.isDisplayed()){
            inputDepartureDate.clear();
            inputDepartureDate.sendKeys(Keys.ENTER);
            driver.findElements(originCalendarDaysXpath).get(2).click();
        }else {
            btnBookAndFlights.click();
            inputDepartureDate.clear();
            inputDepartureDate.sendKeys(Keys.ENTER);
            driver.findElements(originCalendarDaysXpath).get(2).click();
        }
        return this;
    }

    public BookAFlightForm setReturnDate(){
        driver.findElements(destinationCalendarDaysXpath).get(5).click();
        return this;
    }
    
    public void addChild(){
        buttonAddChild.click();
    }

    public FlightsAndTicketTypesPage goToFlightsAndTicketTypesPage(){
        buttonFindFlightsFares.click();
        return new FlightsAndTicketTypesPage(driver);
    }

    public void fillBookAndFlightForm() {
        choseCountryFrom();
        choseCountryTo();
        pressFindFlightsButton();
        setDepartureDate();
        setReturnDate();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        goToFlightsAndTicketTypesPage();

    }

    public BookAFlightForm setReturnDate(String date){

        inptReturnDate.sendKeys(date);
        inptReturnDate.sendKeys(Keys.ENTER);
        return this;
    }


    public boolean checkReturnDate() {
        choseCountryFrom();
        choseCountryFrom();
        btnBookAndFlights.click();
        setReturnDate("01.02.2017");
        driver.manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS);
        return ERROR_MESSAGE.equals(inptError.getText());

    }

    public boolean checkOneWayTripAction() {
        choseCountryFrom();
        choseCountryFrom();
        btnBookAndFlights.click();
        radioBtnOneWayTrip.click();
        //String text = inptReturnDate.getAttribute("style");
        return RETURN_DATE_ATTRIBUTE.equals(fieldReturnDateVisibality.getAttribute("style"));
    }

    public boolean checkNumberInfactsTichets() {
        choseCountryFrom();
        choseCountryFrom();
        btnBookAndFlights.click();
        setReturnDate("10.03.2017");
        driver.manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS);
        addTwoInfants();
        btnBookandFlighAction.click();
        return inputNumberOfInfantsError.getText().contains(ERROR_INPUT_EXCEPTION);

    }


    public void addTwoInfants()
    {
        listInfants.click();
        numberOfInfants.click();
    }

    public FlightsAndTicketTypesPage continueBooking(){
        buttonGoFlightsAndTicketsTypesPage.click();
        return new FlightsAndTicketTypesPage(driver);
    }

}
