package com.epam.AirBaltic.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Sample page
 */
public class StartPage extends Page {


    @FindBy(how = How.TAG_NAME, using = "h1")
    @CacheLookup
    public WebElement header;

    @FindBy(xpath = "//button[@id='flights-form-btn']")
    WebElement btnBookAndFlights;

    @FindBy(xpath = "//input[@id='flt_destin_text']")
    WebElement inptDestTo;

    @FindBy(id = "myairbaltic-href")
    private WebElement buttonMyAirBaltic;

    @FindBy(css = "#dropdownMenu3")
    private WebElement buttonMyAccount;

    @FindBy(xpath = "//li[@role='presentation']/a[@href='#']")
    private WebElement buttonLogout;

    @FindBy(xpath = "//li[@role='presentation']/a[@href='/edit-a-customer-account']")
    private WebElement buttonEditMyProfile;

    @FindBy(css = "a#ancillary-2-en.item.pull-left")
    public WebElement linkFlySnowyPeaks;  //testcase #6

    @FindBy(css = "div.menu-item.drop-flights")
    public WebElement linkFlights;  //testcase #4

    //ul/li/a[@href='/youth-offer']
    @FindBy(xpath = "//div[@class='mega-list']/ul/li/a[@href='/youth-offer']")
    public WebElement linkYouthOffer;  //testcase #4

    public StartPage(WebDriver driver) {
        super(driver);
    }

    public BookAFlightForm goToBookAFlightForm() {
        return new BookAFlightForm(driver);
    }

    public LoginForm goToLoginForm(){
        buttonMyAirBaltic.click();
        return new LoginForm(driver);
    }

    public void logout(String url){
        driver.navigate().to(url);
        buttonMyAccount.click();
        buttonLogout.click();
    }

    public EditProfilePage goToEditProfilePage() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(buttonMyAccount));
        buttonMyAccount.click();
        buttonEditMyProfile.click();
        return new EditProfilePage(driver);
    }

    public SnowyPeaksPage clickFlySnowyPeaksLink() {
        linkFlySnowyPeaks.click();
        return new SnowyPeaksPage(this.driver);
    }

    public void clickFlightsLink() {
        linkFlights.click();
    }

    public void clickYouthOfferLink() {
        linkYouthOffer.click();
    }

    public YouthOfferPage gotoYouthOfferPageByLink() {
        this.clickFlightsLink();
        (new WebDriverWait(this.driver, 5)).until(ExpectedConditions.
                visibilityOf(linkYouthOffer));
        this.clickYouthOfferLink();
        return new YouthOfferPage(this.driver);
    }


}
