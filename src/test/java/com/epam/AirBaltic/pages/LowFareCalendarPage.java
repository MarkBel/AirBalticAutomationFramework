package com.epam.AirBaltic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Dmitryi_Paulioz on 3/1/2017.
 */
public class LowFareCalendarPage extends Page {

    @FindBy(xpath = "//button[@class='btn-continue-booking']")
    private WebElement cheepPageButton;

    public LowFareCalendarPage(WebDriver driver) {
        super(driver);
    }

    private void clickSkipCheepButton() {
        cheepPageButton.click();
    }

    public void confirmBooking() {
        clickSkipCheepButton();
    }

}
