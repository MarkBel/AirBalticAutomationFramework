package com.epam.AirBaltic.pages;

import org.openqa.selenium.By;
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

    @FindBy(css = ".icon-remove")
    private WebElement additionalButton;


    public SummaryPage(WebDriver driver) {
        super(driver);
    }

    public SummaryPage choosePaymentMethod() {
        additionalButton.click();
        wait.waitForElementIsClickable(paymentMethodLocator);
        paymentMethodLocator.click();
        wait.waitForElementIsClickable(selectCreditCard);
        selectCreditCard.click();
        return new SummaryPage(driver);

    }

    public boolean termsAndConditionsNotAccepted() {
        submitButton.click();
        wait.waitForVisibilityOfElement(termsAndConditionsError);
        return termsAndConditionsError.getText().contains(ERROR_TERMS_AND_CONDITIONS_EXCEPTION);
    }

}
