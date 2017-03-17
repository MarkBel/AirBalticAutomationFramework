package com.epam.AirBaltic.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by Katerina_Karpenia on 3/2/2017.
 */
public class PassengersPage extends Page {

    @FindBy(css = "div>.btn-continue-booking")
    private WebElement continueButton;

    @FindBy(name = "firstname_ADT_0")
    private WebElement inputFirstName;

    public PassengersPage(WebDriver driver) {
        super(driver);
    }


    public TravelExtrasPage goToTravelExtrasPage() {
        wait.waitForElementIsClickable(inputFirstName).click();
        wait.waitForElementIsClickable(continueButton).click();
        return new TravelExtrasPage(driver);
    }

}
