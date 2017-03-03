package com.epam.AirBaltic.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

/**
 * Created by Katerina_Karpenia on 3/2/2017.
 */
public class SummaryPage extends Page {

    private static final String ERROR_TERMS_AND_CONDITIONS_EXCEPTION = "To continue, please accept the terms and conditions. Please check the booking data again before you proceed.";

    @FindBy(css = "div.jq-selectbox__select-text.needsclick")
    private WebElement paymentMethodLocator;

    @FindBy(xpath = ".//*[@id='mCSB_4_container']/ul/li[2]")
    private WebElement selectCreditCard;

    @FindBy(css = ".clearfix>.button-green")
    private WebElement submitButton;

    @FindBy(css = ".summary-error")
    private WebElement termsAndConditionsError;


    public SummaryPage(WebDriver driver) {
        super(driver);
    }

    public void choosePaymentMethod() {
        paymentMethodLocator.click();
        selectCreditCard.click();

    }

    public boolean checkTermsAndConditions() {
        submitButton.click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        return termsAndConditionsError.getText().contains(ERROR_TERMS_AND_CONDITIONS_EXCEPTION);
    }

}
