package com.epam.AirBaltic.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


/**
 * Sample page
 */
public class StartPage extends Page {


    @FindBy(how = How.TAG_NAME, using = "h1")
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

    @FindBy(xpath = "//li[2]/a[@id='ancillary-2-en']/span[@class='product-description']/div/strong")
    public WebElement linkFlySnowyPeaks;  //testcase #6

    @FindBy(css = "div.menu-item.drop-flights")
    public WebElement linkFlights;  //testcase #4

    //ul/li/a[@href='/youth-offer']
    @FindBy(xpath = "//div[@class='mega-list']/ul/li/a[@href='/youth-offer']")
    public WebElement linkYouthOffer;  //testcase #4

    @FindBy(xpath = "//div[@class='footer-menu col-md-7 col-lg-7']/a[3]")
    public WebElement linkCareer;

    private static final By buttonClose = By.xpath("//div[@class='insider-opt-in-notification-button insider-opt-in-disallow-button']");

    private static final By LINK_LOGIN_FORM = By.id("myairbaltic-href");
    private static final By LINK_DD_USERMENU = By.cssSelector("a#dropdownMenu3.dropdown-toggle");
    private static final By POPUP_NOTHANKS_BUTTON = By.cssSelector("div.insider-opt-in-notification-button.insider-opt-in-disallow-button");

    public StartPage(WebDriver driver) {
        super(driver);
        closePopUpWindow();
    }


    public StartPage getLoginStatement() {
        new WebDriverWait(driver, WAIT_10_SEC).until(ExpectedConditions.visibilityOf(buttonMyAccount));
        return new StartPage(driver);
    }

    public BookAFlightForm goToBookAFlightForm() {
        return new BookAFlightForm(driver);
    }

    public LoginForm goToLoginForm(){
        wait.waitForElementIsClickable(buttonMyAirBaltic);
        buttonMyAirBaltic.sendKeys(Keys.ENTER);
        return new LoginForm(driver);
    }

    public void logout(String url){
        driver.navigate().to(url);
        buttonMyAccount.click();
        buttonLogout.click();
        driver.manage().deleteAllCookies();
    }

    public EditProfilePage goToEditProfilePage() {
        wait.waitForVisibilityOfElement(buttonMyAccount);
        buttonMyAccount.click();
        buttonEditMyProfile.click();
        return new EditProfilePage(driver);
    }

    public SnowyPeaksPage clickFlySnowyPeaksLink() {
        clickOnElementWithJS(linkFlySnowyPeaks);
//        linkFlySnowyPeaks.click();
        (new WebDriverWait(this.driver, WAIT_10_SEC)).until(ExpectedConditions.
                titleContains("Winter"));
        logger.info("Opened page with title " + this.getTitle());
        return new SnowyPeaksPage(this.driver);

    }

    public void clickFlightsLink() {
        linkFlights.click();
        logger.info("Opened page with title " + this.getTitle());
    }

    public void clickYouthOfferLink() {
        linkYouthOffer.click();
        logger.info("Opened page with title " + this.getTitle());
    }

    public YouthOfferPage gotoYouthOfferPageByLink() {
        this.clickFlightsLink();
        (new WebDriverWait(this.driver, WAIT_3_SEC)).until(ExpectedConditions.
                visibilityOf(linkYouthOffer));
        this.clickYouthOfferLink();
        return new YouthOfferPage(this.driver);
    }

    public void clickCareerLink() {
        linkCareer.click();
        (new WebDriverWait(this.driver, WAIT_10_SEC)).until(ExpectedConditions.
                titleContains("Career"));
        logger.info("Opened page with title " + this.getTitle());
    }

    public void closePopUpWindow()
    {
        if(isElementPresent(buttonClose,driver))
        {
            WebElement element = driver.findElement(buttonClose);
            element.click();
        }
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    public static boolean isElementPresent(By by,WebDriver driver)
    {
        boolean present;
        try
        {
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
            driver.findElement(by);
            present = true;
        }catch (NoSuchElementException e)
        {
            present = false;
        }
        return present;
    }

}
