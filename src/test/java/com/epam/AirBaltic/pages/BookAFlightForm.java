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
        buttonFindFlightsFares.click();
        inputDepartureDate.clear();
        inputDepartureDate.sendKeys(Keys.ENTER);
        driver.findElements(originCalendarDaysXpath).get(2).click();
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

}
