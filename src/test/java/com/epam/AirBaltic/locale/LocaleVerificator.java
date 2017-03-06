package com.epam.AirBaltic.locale;

import com.epam.AirBaltic.pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.concurrent.TimeUnit;

/**
 * Created by Mark_Rudak on 3/3/2017.
 */
public class LocaleVerificator extends Page {


    @FindBy(xpath = "//button[@id='dropdownMenu2']")
    WebElement fieldLang;

    @FindBy(xpath = "//ul[@class='dropdown-menu lang no-padding no-margin languages']//li[1]//a")
    WebElement fieldEnglishLang;


    public LocaleVerificator(WebDriver driver) {
        super(driver);
    }

    public String getLanguage() {
        return fieldLang.getText();
    }

    public void setLanguage() {
        String lang = "English";
        if (!getLanguage().equals(lang)) {
            fieldLang.click();
            fieldEnglishLang.click();
        }

    }


}
