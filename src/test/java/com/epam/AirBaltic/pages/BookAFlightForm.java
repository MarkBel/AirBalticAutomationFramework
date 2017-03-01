package com.epam.AirBaltic.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Kseniya_Kunda on 3/1/2017.
 */
public class BookAFlightForm extends Page{

    @FindBy(css = "#positioner button")
    WebElement ButtonFindFlightsFares;

    @FindBy(css = "#flt_origin_text")
    WebElement inputFlyFrom;

    @FindBy(css = "#flt_destin_text")
    WebElement inputFlyTo;

    @FindBy(css = "#depDateGroup .soft-keyboard-controller")
    WebElement inputDepartureDate;

    @FindBy(css = "#return-date-div .soft-keyboard-controller")
    WebElement inputReturnDate;

    @FindBy(css = "#top-dropdown-menu2+div")
    WebElement buttonAddChild;


    public BookAFlightForm(WebDriver driver) {
        super(driver);
    }

    public void choseCountryFrom(){
        inputFlyFrom.clear();
        inputFlyFrom.sendKeys("Riga (RIX) - Latvia");
    }

    public void choseCountryTo(){
        inputFlyTo.sendKeys("Berlin (Tegel) (TXL) - Germany");
        inputFlyTo.sendKeys(Keys.ENTER);
    }

    public void setDepartureDate(){
        inputDepartureDate.sendKeys("03.03.2017");
    }

    public void setReturnDate(){
        inputReturnDate.sendKeys("06.03.2017");
    }
}
