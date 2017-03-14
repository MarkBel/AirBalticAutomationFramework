package com.epam.AirBaltic.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by Dmitryi_Paulioz on 3/2/2017.
 */
public class FlightsAndTicketTypesPage extends Page {

    @FindBy(css = "div>.btn-continue-booking")
    private WebElement continueButton;

    private final String lowFareTitle = "Low Fare Calendar | airBaltic";
    private String currentTitle;
    private static double departurePrice;
    private static double returnPrice;

    private static final By detailedFire = By.cssSelector(".fare-item-detailed");
    private static final By fire = By.cssSelector(".expandable>a");
    private static final By tariffFire = By.cssSelector(".line>span+span");

    public static double getDeparturePrice() {
        return departurePrice;
    }

    public static double getReturnPrice() {
        return returnPrice;
    }

    public FlightsAndTicketTypesPage(WebDriver driver) {
        super(driver);
    }

    private void checkCorrectPage() {
        currentTitle = driver.getTitle();
        if (currentTitle.equals(lowFareTitle)) {
            LowFareCalendarPage lowFarePage = new LowFareCalendarPage(driver);
            lowFarePage.confirmBooking();
        }
    }

    private void findPrices() {
        departurePrice = parsePriceField(0);
        returnPrice = parsePriceField(1);
    }

    private double parsePriceField(int i) {
        List<WebElement> list = driver.findElements(By.xpath("//*[contains(@class,'active') and contains(@class,'flight-price')]"));
        String euroPriceWithoutCents = list.get(i).findElement(By.className("av-price")).getText().replace("€", "");
        StringBuffer euroPriceWithCents = new StringBuffer(euroPriceWithoutCents);
        euroPriceWithCents.insert(euroPriceWithoutCents.length() - 2, ".");
        System.out.println(Double.parseDouble(euroPriceWithCents.toString()));
        return Double.parseDouble(euroPriceWithCents.toString());
    }

    public PassengersPage acceptFare() {
        checkCorrectPage();
        findPrices();
        goToPassengersPage();
        return new PassengersPage(driver);
    }

    public Boolean isFareConditionObserved(double saleForChildTicket, int deltaForChildTicket) {
        checkCorrectPage();
        List<WebElement> listOfTotalPrices = driver.findElements(fire);
        for (WebElement element : listOfTotalPrices) {
            element.sendKeys(Keys.ENTER);
        }
        List<WebElement> listOfDetailedPrices = driver.findElements(detailedFire);
        double adultFare = Double.parseDouble(listOfDetailedPrices.get(0).findElement(tariffFire).getText().replace(" €", ""));
        double childFare = Double.parseDouble(listOfDetailedPrices.get(1).findElement(tariffFire).getText().replace(" €", ""));
        return (childFare >= adultFare * saleForChildTicket - deltaForChildTicket && childFare <= adultFare * saleForChildTicket + deltaForChildTicket);
    }

    public PassengersPage goToPassengersPage() {
        wait.waitForVisibilityOfElement(continueButton);
        continueButton.click();
        return new PassengersPage(driver);
    }
}
