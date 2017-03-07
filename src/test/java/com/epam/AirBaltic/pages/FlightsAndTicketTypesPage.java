package com.epam.AirBaltic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by Dmitryi_Paulioz on 3/2/2017.
 */
public class FlightsAndTicketTypesPage extends Page {

    @FindBy(css = "div>.btn-continue-booking")
    private WebElement continueButton;

    private String lowFareTitle = "Low Fare Calendar | airBaltic";
    private String currentTitle;
    private int departurePrice;
    private int returnPrice;

    private static final By detailedFire = By.cssSelector(".fare-item-detailed");
    private static final By fire = By.cssSelector(".expandable>a");
    private static final By tariffFire = By.cssSelector(".line>span+span");

    public int getDeparturePrice() {
        return departurePrice;
    }

    public int getReturnPrice() {
        return returnPrice;
    }

    public FlightsAndTicketTypesPage(WebDriver driver) {
        super(driver);
        currentTitle = driver.getTitle();
    }

    private void checkCorrectPage() {
        if (currentTitle.equals(lowFareTitle)) {
            LowFareCalendarPage lowFarePage = new LowFareCalendarPage(driver);
            lowFarePage.confirmBooking();
        }
    }

    private void findPrices() {
        departurePrice = parsePriceField(0);
        returnPrice = parsePriceField(1);
    }

    private int parsePriceField(int i) {
        List<WebElement> list = driver.findElements(By.xpath("//*[contains(@class,'active') and contains(@class,'flight-price')]"));
        String euro = list.get(i).findElement(By.className("av-price")).getText();
        return Integer.parseInt(euro.replace("€", ""));
    }

    public PassengersPage acceptFare() {
        checkCorrectPage();
        findPrices();
        goToPassengersPage();
        return new PassengersPage(driver);
    }

    public Boolean CheckFareCondition() {
        checkCorrectPage();
        Boolean condition = false;
        List<WebElement> listOfTotalPrices = driver.findElements(fire);
        for (WebElement element : listOfTotalPrices) {
            element.sendKeys(Keys.ENTER);
        }
        List<WebElement> listOfDetailedPrices = driver.findElements(detailedFire);
        double adultFare = Double.parseDouble(listOfDetailedPrices.get(0).findElement(tariffFire).getText().replace(" €", ""));
        double childFare = Double.parseDouble(listOfDetailedPrices.get(1).findElement(tariffFire).getText().replace(" €", ""));
        if (childFare >= adultFare*0.75 - 1 && childFare <= adultFare*0.75 + 1){
            condition = true;
        }return condition;
    }

    public PassengersPage goToPassengersPage() {
        wait.waitForElement(continueButton).click();
        continueButton.click();
        return new PassengersPage(driver);
    }
}