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

public class YouthOfferPage extends Page {

    private static final String YOUTH_OFFER_PAGE_URL = "https://www.airbaltic.com/youth-offer";

    private static final By SELECTED_DDMENU_ITEM = By.xpath("//span[@class='twitter-typeahead']/descendant::strong[@class='tt-highlight']");

    @FindBy(xpath = "//div[@class='input-group input-suggest-main dest-field-specific'][1]")
    private WebElement fMenuOrigins;

    @FindBy(xpath = "//input[@name='flt_origin_text']")
    private WebElement fMenuOrigins_1;

    @FindBy(xpath = "//div[@class='input-group input-suggest-main dest-field-specific'][1]/descendant::div[@class='tt-suggestion tt-selectable']")
    private List<WebElement> listDDMenuOrigins;

    @FindBy(xpath = "//div[@class='flight-line']/div[@class='origin']")
    private List<WebElement> listOfferOrigins;


    public YouthOfferPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void Open() {
        driver.navigate().to(YOUTH_OFFER_PAGE_URL);
    }

    private Integer getOriginMenuItemsCount() {
        return listDDMenuOrigins.size();
    }

    public void selectDDMenuItem(Integer menuItemNum) {
        if (menuItemNum < listDDMenuOrigins.size()-1 && menuItemNum >= 0) {
            listDDMenuOrigins.get(menuItemNum).click();
        }
    }

    public String getSelectedOriginCity() {
        return fMenuOrigins_1.getAttribute("value").split(" ")[0];
    }

    public void setOriginCity(String city) {
        (new WebDriverWait(this.driver, 5)).until(ExpectedConditions.
                        elementToBeClickable(fMenuOrigins_1)).click();
        fMenuOrigins_1.sendKeys(city.substring(0, 1));
        (new WebDriverWait(this.driver, 5)).until(AdditionalConditions.
                jQueryCompleted());
    }

    /* TODO */
    public void setOriginCity(Integer position) {

    }

    public void clearOriginCity() {
        fMenuOrigins_1.clear();
    }

    public Integer getOffersNumberFromCurrentCity() {
        return listOfferOrigins.size();
    }

    public boolean isOriginsShownCorrectly() {
        boolean result = false;
        String selectedCity = getSelectedOriginCity();
        for (int i = 0; i < listOfferOrigins.size(); i++) {
            if (extractCityFromStr(listOfferOrigins.get(i).getText()).equals(selectedCity)) {
                result = true;
            } else {
                result = false;
                break;
            }
        }
        return result;
    }

    private String extractCityFromStr(String str) {
        return  str.replaceAll("[A-Z]+?$", "");
    }

}
