package com.epam.AirBaltic.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by Katerina_Karpenia on 3/2/2017.
 */
public class TravelExtrasPage extends Page {

    @FindBy(xpath = "//*[contains(text(), 'Seat me anywhere')]")
    private WebElement seatMeAnyWhereButton;

    @FindBy(css = "div>#btn-continue-booking")
    private WebElement continueButton;

    @FindBys(@FindBy(xpath = "//div[@class='seat-container seat-available seat-priority']"))
    private List<WebElement> availableSeats;


    public TravelExtrasPage(WebDriver driver) {
        super(driver);
    }

    public SummaryPage goToSummaryPage() {
        seatMeAnyWhereButton.click();
        continueButton.click();
        return new SummaryPage(driver);
    }

    public boolean isOneSeatSelected(){
        availableSeats.get(0).click();
        availableSeats.get(1).click();
        return availableSeats.get(0).isSelected();
    }
}
