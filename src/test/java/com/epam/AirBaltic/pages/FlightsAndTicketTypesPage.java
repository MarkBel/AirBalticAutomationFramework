package com.epam.AirBaltic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by Dmitryi_Paulioz on 3/2/2017.
 */
public class FlightsAndTicketTypesPage extends Page {

    private WebElement acceptButton;
    private String lowFareTitle = "Low Fare Calendar | airBaltic";
    private String currentTitle;
    private int departurePrice;
    private int returnPrice;


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

    private void clickAcceptButton() {
        acceptButton = driver.findElement(By.xpath("//div[contains(@class, 'login-guest')]//button"));
        acceptButton.click();
    }

    private void checkCorrectPage() {
        if (currentTitle.equals(lowFareTitle)) {
            LowFareCalendarPage lowFarePage = new LowFareCalendarPage(driver);
            lowFarePage.confirmBooking();
        }
    }

    private void findPrices(){
        departurePrice = parsePriceField(0);
        returnPrice = parsePriceField(1);
    }

    private int parsePriceField(int i) {
        List<WebElement> list = driver.findElements(By.xpath("//*[contains(@class,'active') and contains(@class,'flight-price')]"));
        String euro = list.get(i).findElement(By.className("av-price")).getText();
        return Integer.parseInt(euro.replace("€", ""));
    }

    public void acceptFare() {
        checkCorrectPage();
        findPrices();
        clickAcceptButton();
    }

}
