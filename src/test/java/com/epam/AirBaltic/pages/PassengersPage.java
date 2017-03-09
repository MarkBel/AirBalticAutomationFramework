package com.epam.AirBaltic.pages;

import com.epam.AirBaltic.entity.Passenger;
import com.epam.AirBaltic.util.AdditionalConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Katerina_Karpenia on 3/2/2017.
 */
public class PassengersPage extends Page {

    @FindBy(css = "div>.btn-continue-booking")
    private WebElement continueButton;

    @FindBy(name = "firstname_ADT_0")
    private WebElement inputFirstName;

    @FindBy(name = "lastname_ADT_0")
    private WebElement inputLastName;

    @FindBy(name = "email_0")
    private WebElement inputEmail;

    @FindBy(name = "phone_M")
    private WebElement inputPhoneNo;

    @FindBy(xpath = "//span[@class='item-control salutation']")
    private WebElement dDMenuSelectTitle;

    @FindBy(xpath = "//span[@class='item-control salutation']//li")
    private List<WebElement > listOfTitles;


    public PassengersPage(WebDriver driver) {
        super(driver);
    }


    public TravelExtrasPage goToTravelExtrasPage() {

        wait.waitForElement(continueButton).click();
        return new TravelExtrasPage(driver);
    }

}
