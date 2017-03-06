package com.epam.AirBaltic.pages;

import com.epam.AirBaltic.entity.Passenger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

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

    @FindBy(xpath = "//div[contains(text(),'Mr.')]")
    private WebElement selectTitle;

    public PassengersPage(WebDriver driver) {
        super(driver);
    }


    public TravelExtrasPage goToTravelExtrasPage() {
        //wait.waitForElement(continueButton).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        continueButton.click();
        return new TravelExtrasPage(driver);
    }

    public PassengersPage enterPassengersData(Passenger passenger) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        selectTitle.click();
        inputFirstName.clear();
        inputFirstName.sendKeys(passenger.getFirstName());

        inputLastName.clear();
        inputLastName.sendKeys(passenger.getLastName());

        inputEmail.clear();
        inputEmail.sendKeys(passenger.getEmail());

        inputPhoneNo.clear();
        inputPhoneNo.sendKeys(passenger.getPhoneNo());
        return this;
    }

    public TravelExtrasPage goToTravelExstrasPage() {
        wait.waitForElement(continueButton).click();
        return new TravelExtrasPage(driver);
    }


}
