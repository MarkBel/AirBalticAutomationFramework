package com.epam.AirBaltic.pages;

import com.epam.AirBaltic.util.AdditionalConditions;
import com.epam.AirBaltic.util.FluentWaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by Katerina_Karpenia on 3/2/2017.
 */
public class TravelExtrasPage extends Page {

    private static final String EURO_SPLITTERS = "[€ ]";
    private By totalPriceContainer = By.xpath("//div[@class='fare-bottom']//span[2]");

    @FindBy(xpath = "//*[contains(text(), 'Seat me anywhere')]")
    private WebElement seatMeAnyWhereButton;

    @FindBy(css = "div>#btn-continue-booking")
    private WebElement continueButton;

    @FindBy(xpath = "//div[@class='seats-map']/div[@class='map-container']/table[@class='map-plane']" +
            "/tbody/tr/td/div[contains(@class,'seat-available') and not(contains(@class,'open-popup-link'))]")
    private List<WebElement> availableSeats;


    public TravelExtrasPage(WebDriver driver) {
        super(driver);
    }

    public SummaryPage goToSummaryPage() {
        seatMeAnyWhereButton.click();
        wait.waitForElementIsClickable(continueButton);
        continueButton.sendKeys(Keys.ENTER);
        return new SummaryPage(driver);
    }

    public boolean isTwoSeatsForOnePersonCanBeSelected() {
        (new WebDriverWait(this.driver, WAIT_15_SEC)).until(AdditionalConditions.
                jQueryCompleted());
        if (availableSeats.size() > 1) {
            availableSeats.get(0).click();
            availableSeats.get(1).click();
//        clickOnElementWithJS(availableSeats.get(0));
//        clickOnElementWithJS(availableSeats.get(1));
            return availableSeats.get(0).isSelected();
        }
        logger.info("Flight have less then two available seats. Change date of departure");
        return false;
    }

    private double parseTotalPrice() {
        String totalPriceString = driver.findElement(totalPriceContainer).getText().replaceAll(EURO_SPLITTERS, "");
        return Double.parseDouble(totalPriceString);
    }

    public boolean checkSummaryPrice() {
        parseTotalPrice();
        double departmentPrice = FlightsAndTicketTypesPage.getDeparturePrice();
        double returnPrice = FlightsAndTicketTypesPage.getReturnPrice();
        boolean result = (parseTotalPrice() == departmentPrice + returnPrice);
        return result;
    }

}
