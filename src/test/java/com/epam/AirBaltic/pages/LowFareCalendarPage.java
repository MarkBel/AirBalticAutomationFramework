package com.epam.AirBaltic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Dmitryi_Paulioz on 3/1/2017.
 */
public class LowFareCalendarPage extends Page {

    @FindBy(xpath = "//*[@id='your-selection']//span[2]")
    private WebElement priceField;
    private String cheepTicketsPageURL = "https://tickets.airbaltic.com/en/book/avail";

    @FindBy(xpath = "//button[@class='btn-continue-booking']")
    private WebElement cheepPageButton;

    private WebElement accessButton;


    public LowFareCalendarPage(WebDriver driver) {
        super(driver);
    }

    private void getTicketsPrice(){
        System.out.println(priceField.getText());
    }

    private void clickSkipCheepButton(){
        cheepPageButton.click();
    }

    private void clickAcceptButton(){
        accessButton = driver.findElements(By.xpath("//*[@class='btn-green']")).get(1);
        accessButton.click();
    }

    public void confirmBooking(){
        getTicketsPrice();
        if(driver.getCurrentUrl().equals(cheepTicketsPageURL)) {
            clickSkipCheepButton();
        }
        clickAcceptButton();
    }

}
