package com.epam.AirBaltic.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

/**
 * Created by Kseniya_Kunda on 3/3/2017.
 */
public class EditProfilePage extends Page {

    @FindBy(css = "#familyName")
    private WebElement inputSurname;

    @FindBy(id = "submit_pax_account_new_form")
    private WebElement buttonSave;

    @FindBy(css = "#logo>img")
    private WebElement buttonAirBaltic;

    @FindBy(css = ".errors>li")
    private WebElement errorMessageCss;

    public EditProfilePage(WebDriver driver) {
        super(driver);
    }

    private void setSurname(String newSurname) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(inputSurname));
        inputSurname.clear();
        inputSurname.sendKeys(newSurname);
    }

    private void saveUpdates() {
        buttonSave.click();
    }

    public EditProfilePage updateSurname(String newSurname) {
        setSurname(newSurname);
        saveUpdates();
        return this;
    }

    public Boolean checkErrorMessage(String errorMessage) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(buttonSave));
        return errorMessageCss.getText().equals(errorMessage);
    }

    public StartPage goToStartPage() {
        buttonAirBaltic.click();
        return new StartPage(driver);
    }


}
