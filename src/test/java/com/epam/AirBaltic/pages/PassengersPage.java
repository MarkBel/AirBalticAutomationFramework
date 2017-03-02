package com.epam.AirBaltic.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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




}
