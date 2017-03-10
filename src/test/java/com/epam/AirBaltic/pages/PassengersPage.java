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

    @FindBy(name = "lastname_ADT_0")
    private WebElement inputLastName;

    @FindBy(name = "email_0")
    private WebElement inputEmail;

    @FindBy(name = "phone_M")
    private WebElement inputPhoneNo;

    @FindBy(xpath = "//span[@class='item-control salutation']")
    private WebElement dDMenuSelectTitle;

    @FindBy(xpath = "//span[@class='item-control salutation']//li")
    private List<WebElement> listOfTitles;


    public PassengersPage(WebDriver driver) {
        super(driver);
    }


    public TravelExtrasPage goToTravelExtrasPage() {
        inputFirstName.click();
        wait.waitForElementIsClickable(continueButton);
        continueButton.click();
        return new TravelExtrasPage(driver);
    }

}
