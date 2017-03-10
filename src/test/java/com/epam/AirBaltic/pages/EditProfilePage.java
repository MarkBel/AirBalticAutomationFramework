package com.epam.AirBaltic.pages;

import com.epam.AirBaltic.util.AdditionalConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

/**
 * Created by Kseniya_Kunda on 3/3/2017.
 */
public class EditProfilePage extends Page {

    private String chosenCountry;
    private Random random;
    private StartPage startPage;

    @FindBy(css = "#businessCountry+div>.select_box")
    private WebElement inputCountry;

    @FindBy(id = "submit_pax_account_new_form")
    private WebElement buttonSave;

    @FindBy(css = "#logo>img")
    private WebElement buttonAirBaltic;

    @FindBy(xpath = "//ul[@class='drop_down'][@rel='businessCountry']/li")
    private List<WebElement> countries;

    public EditProfilePage(WebDriver driver) {
        super(driver);
        random = new Random();
    }

    private void setCountry(int changedCountry) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(inputCountry));
        inputCountry.click();
        countries.get(changedCountry).click();
    }

    private void saveUpdates() {
        buttonSave.click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(buttonSave));
        inputCountry.click();
    }

    private void uploadPage(){
        startPage = goToStartPage();
        startPage.goToEditProfilePage();
    }

    public EditProfilePage updateCountry(int changedCountry) {
        setCountry(changedCountry);
        saveUpdates();
        uploadPage();
        return this;
    }

    public Boolean checkChangedCountry(String changedCountry) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(buttonSave));
        return inputCountry.getText().equals(changedCountry);
    }

    public StartPage goToStartPage() {
        buttonAirBaltic.click();
        return new StartPage(driver);
    }


}
