package com.epam.AirBaltic.pages;

import com.epam.AirBaltic.PageTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Katerina_Karpenia on 3/2/2017.
 */
public class SummaryPage extends Page {

    @FindBy(css = "div.jq-selectbox__select-text.needsclick")
    private WebElement paymentMethodLocator;

    @FindBy(xpath = ".//*[@id='mCSB_4_container']/ul/li[2]")
    private WebElement selectCreditCard;

    @FindBy(id = "#btnSubmit")
    private WebElement submitButton;


    public SummaryPage(WebDriver driver) {
        super(driver);
    }

    public void choosePaymentMethod() {
        paymentMethodLocator.click();
        selectCreditCard.click();

    }

    public void clickSubmitButton() {
        submitButton.click();
    }

}
