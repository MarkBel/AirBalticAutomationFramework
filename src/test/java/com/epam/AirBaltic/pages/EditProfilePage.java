package com.epam.AirBaltic.pages;

import org.openqa.selenium.By;
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

    private String chosenCountry;
    private Random random;
    private StartPage startPage;

    @FindBy(css = "#businessCountry+div>.select_box")
    WebElement inputCountry;

    @FindBy(id = "submit_pax_account_new_form")
    WebElement buttonSave;

    @FindBy(css = "#logo>img")
    WebElement buttonAirBaltic;

    private static final By countries = By.xpath("//ul[@class='drop_down'][@rel='businessCountry']/li");

    public EditProfilePage(WebDriver driver) {
        super(driver);
        random = new Random();
    }

    private void setCountry() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(inputCountry));
        List<WebElement> countryList = driver.findElements(countries);
        int chosenCountryNumber = random.nextInt(7) + 2;
        inputCountry.click();
        chosenCountry = countryList.get(chosenCountryNumber).findElement(By.tagName("span")).getText();
        countryList.get(chosenCountryNumber).findElement(By.tagName("span")).click();
    }

    private void saveUpdates() {
        buttonSave.click();
    }

    public void updateCountry() {
        setCountry();
        saveUpdates();
        uploadPage();
    }

    public Boolean checkChangedCountry() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(buttonSave));
        Boolean updatedCountry = false;
        if (inputCountry.getText().equals(chosenCountry)){
            updatedCountry = true;
        }return updatedCountry;
    }

    public StartPage goToStartPage() {
        buttonAirBaltic.click();
        return new StartPage(driver);
    }

    private void uploadPage(){
        startPage = goToStartPage();
        startPage.goToEditProfilePage();
    }

}
