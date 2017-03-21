package com.epam.AirBaltic.pages;

import com.epam.AirBaltic.util.AdditionalConditions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by Dmitryi_Paulioz on 3/2/2017.
 */
public class FlightsAndTicketTypesPage extends Page {

    @FindBy(css = "div>.btn-continue-booking")
    private WebElement continueButton;

    @FindBy(css = ".expandable>a")
    private WebElement fireLink;

    private final String LOW_FARE_PAGE_TITLE = "Low Fare Calendar | airBaltic";
    private final String FLIGHTS_AND_TICKETS_PAGE_TITLE = "Available flights | airBaltic";

    private String currentTitle;
    private static double departurePrice;
    private static double returnPrice;


    private static int ATTEMPT_COUNT = 3;
    private static final By DETAILED_FIRE = By.cssSelector(".fare-item-detailed");
    private static final By FIRE = By.cssSelector(".expandable>a");
    private static final By TARIFF_FIRE = By.cssSelector(".line>span+span");
    private static final By DEP_DATE_NOT_AVAIL_ERROR = By.xpath("//div[@class='availability-block availability-step-1']" +
                                                                    "/div[@class='availability-error']/div[@class='error-box']");

    private static final By RET_DATE_NOT_AVAIL_ERROR = By.xpath("//div[@class='availability-block availability-step-2']" +
                                                                    "/div[@class='availability-error']/div[@class='error-box']");

    private static final By DEP_DATES_LIST = By.xpath("//div[@class='availability-block availability-step-1']" +
                                                            "/div[@class='dates-table return']/table/tbody/tr/td");
    private static final By RET_DATES_LIST = By.xpath("//div[@class='availability-block availability-step-2']" +
                                                            "/div[@class='dates-table return']/table/tbody/tr/td");


    public FlightsAndTicketTypesPage(WebDriver driver) {
        super(driver);
        (new WebDriverWait(this.driver, WAIT_5_SEC)).until(ExpectedConditions.titleIs(FLIGHTS_AND_TICKETS_PAGE_TITLE));
    }

    private boolean isSelectedDepDateAvailable() {
        return !isElementPresent(DEP_DATE_NOT_AVAIL_ERROR);
    }

    private  boolean isSelectedRetDateAvailable() {
        return !isElementPresent(RET_DATE_NOT_AVAIL_ERROR);
    }

    private boolean selectFirstAvailableDepDate(int attemptCount) {
        for (int i = 0; i < attemptCount; i++) {
            List<WebElement> datesList =  this.driver.findElements(DEP_DATES_LIST);
            for( int j = 0; j < datesList.size(); j++) {
                if (datesList.get(j).getAttribute("class").equals("date active")) {
                    datesList.get(j+1).click();
                    break;
                }
            }
            (new WebDriverWait(this.driver, WAIT_5_SEC)).until(ExpectedConditions.invisibilityOf(continueButton));
            (new WebDriverWait(this.driver, WAIT_5_SEC)).until(ExpectedConditions.visibilityOf(continueButton));
            if (isSelectedDepDateAvailable()) {
                return true;
            }
        }
        return false;
    }

    private boolean selectFirstAvailableRetDate(int attemptCount) {
        for (int i = 0; i < attemptCount; i++) {
            List<WebElement> datesList =  this.driver.findElements(RET_DATES_LIST);
            for( int j = 0; j < datesList.size(); j++) {
                if (datesList.get(j).getAttribute("class").equals("date active")) {
                    datesList.get(j+1).click();
                    break;
                }
            }
            (new WebDriverWait(this.driver, WAIT_5_SEC)).until(ExpectedConditions.invisibilityOf(continueButton));
            (new WebDriverWait(this.driver, WAIT_5_SEC)).until(ExpectedConditions.visibilityOf(continueButton));
            if (isSelectedRetDateAvailable()) {
                return true;
            }
        }
        return false;
    }


    public static double getDeparturePrice() {
        return departurePrice;
    }

    public static double getReturnPrice() {
        return returnPrice;
    }

    private boolean isPageEnvironmentCorrect() {
        if (driver.getTitle().equals(LOW_FARE_PAGE_TITLE)) {
            LowFareCalendarPage lowFarePage = new LowFareCalendarPage(driver);
            lowFarePage.confirmBooking();
        }
        if (!this.driver.getTitle().equals(FLIGHTS_AND_TICKETS_PAGE_TITLE)) {
            logger.severe("Page FlightsAndTicketTypesPage is not opened");
            return false;
        }
        if (!isSelectedDepDateAvailable()) {
            if (!selectFirstAvailableDepDate(ATTEMPT_COUNT)) {
                logger.severe("Attempt's count to set available departure date is exceeded");
                return false;
            }
        }
        if (!isSelectedRetDateAvailable()) {
            if (!selectFirstAvailableRetDate(ATTEMPT_COUNT)) {
                logger.severe("Attempt's count to set available return date is exceeded");
                return false;
            }
        }
        return true;
    }

    private void findPrices() {
        departurePrice = parsePriceField(0);
        returnPrice = parsePriceField(1);
    }

    private double parsePriceField(int i) {
        List<WebElement> list = driver.findElements(By.xpath("//*[contains(@class,'active') and contains(@class,'flight-price')]"));
        String euroPriceWithoutCents = list.get(i).findElement(By.className("av-price")).getText().replace("€", "");
        StringBuffer euroPriceWithCents = new StringBuffer(euroPriceWithoutCents);
        euroPriceWithCents.insert(euroPriceWithoutCents.length() - 2, ".");
        System.out.println(Double.parseDouble(euroPriceWithCents.toString()));
        return Double.parseDouble(euroPriceWithCents.toString());
    }

    public PassengersPage acceptFare() {
        if (isPageEnvironmentCorrect()) {
            wait.waitForElementIsClickable(fireLink);
            findPrices();
            goToPassengersPage();
            return new PassengersPage(driver);
        } else {
            logger.severe("Verification of FlightsAndTickets page environment failed");
            return null;
        }
    }

    public Boolean isFareConditionObserved(double saleForChildTicket, int deltaForChildTicket) {
        if (isPageEnvironmentCorrect()) {
            logger.info(this.getTitle());
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            wait.waitForElementIsClickable(fireLink);
            List<WebElement> listOfTotalPrices = driver.findElements(FIRE);
            for (WebElement element : listOfTotalPrices) {
                element.sendKeys(Keys.ENTER);
            }
            List<WebElement> listOfDetailedPrices = driver.findElements(DETAILED_FIRE);
            double adultFare = Double.parseDouble(listOfDetailedPrices.get(0).findElement(TARIFF_FIRE).getText().replace(" €", ""));
            double childFare = Double.parseDouble(listOfDetailedPrices.get(1).findElement(TARIFF_FIRE).getText().replace(" €", ""));
            return (childFare >= adultFare * saleForChildTicket - deltaForChildTicket && childFare <= adultFare * saleForChildTicket + deltaForChildTicket);
        }
        return false;
    }

    public PassengersPage goToPassengersPage() {
        wait.waitForVisibilityOfElement(continueButton).click();
        return new PassengersPage(driver);
    }
}
