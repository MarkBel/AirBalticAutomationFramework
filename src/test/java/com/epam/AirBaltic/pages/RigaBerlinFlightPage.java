package com.epam.AirBaltic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RigaBerlinFlightPage extends Page {

    private String originAirport = "Riga (RIX) - Latvia";
    private String destinationAirport = "Berlin (Tegel) (TXL) - Germany";
    private By originCalendarDaysXpath = By.xpath("//div[@id='depDateGroup']//table/tbody/tr/td[@data-handler='selectDay']");
    private By destinationCalendarDaysXpath = By.xpath("//div[@id='return-date-div']//table/tbody/tr/td[@data-handler='selectDay']");
    private By successfulLoginLocator = By.id("dropdown-menu3");

    @FindBy(xpath = "//*[@id='flights-form-btn']")
    private WebElement findButton;

    @FindBy(xpath = "//input[@placeholder='From']")
    private WebElement originAirportField;

    @FindBy(xpath = "//input[@placeholder='To']")
    private WebElement destinationAirportField;

    @FindBy(xpath = "//*[@id='positioner']/div/button")
    private WebElement acceptButton;

    public RigaBerlinFlightPage(WebDriver driver) {
        super(driver);
    }

    private void clickFindButton() {
        driver.findElements(successfulLoginLocator);
        findButton.click();
    }

    private void typeOriginAirport() {
        originAirportField.clear();
        originAirportField.sendKeys(originAirport);
    }

    private void typeDestinationAirport() {
        destinationAirportField.clear();
        destinationAirportField.sendKeys(destinationAirport);
    }

    private void chooseOriginDate() {
        driver.findElements(originCalendarDaysXpath).get(0).click();
    }

    private void chooseDestinationDate() {
        driver.findElements(destinationCalendarDaysXpath).get(1).click();
    }

    private void clickAcceptButton(){
        acceptButton.click();
    }

    public void fillFields(){
        clickFindButton();
        typeOriginAirport();
        typeDestinationAirport();
        chooseOriginDate();
        chooseDestinationDate();
        clickAcceptButton();
    }
}
