package com.epam.AirBaltic.pages;

import com.epam.AirBaltic.entity.Passenger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

/**
 * Created by Katerina_Karpenia on 3/2/2017.
 */
public class PassengersPage extends Page{

    @FindBy(xpath = "//div[@id='your-selection']/div[3]/div/div/div/div[3]/div[2]/span/div/div")
    private WebElement paymentsMethods;

    @FindBy(xpath = "//div[@id='mCSB_11_container']/ul/li[2]")
    private WebElement chooseDebitCreditCard;

//    @FindBy(css = ".passenger-specific")
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

    @FindBy(id = "salutation_ADT_0")
    private Select dropDown;

    public PassengersPage(WebDriver driver) {
        super(driver);
    }

    public void choosePaymentMethod() {
        paymentsMethods.click();
        chooseDebitCreditCard.click();
    }

    public TravelExtrasPage goToTravelExtrasPage() {
//        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        continueButton.click();
        return new TravelExtrasPage(driver);
    }

    public PassengersPage enterPassengersData(Passenger passenger){
        dropDown.selectByVisibleText("Mr.");
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

    public TravelExtrasPage goToTravelExstrasPage(){
        continueButton.click();
        return new TravelExtrasPage(driver);
    }




}
