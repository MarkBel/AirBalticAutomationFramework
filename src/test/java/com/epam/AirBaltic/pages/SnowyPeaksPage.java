package com.epam.AirBaltic.pages;

import com.epam.AirBaltic.util.AdditionalConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SnowyPeaksPage extends Page {

    private static final By OFFER_LINE_LOCATOR = By.xpath("//div[@class='flight-line']");
    private static final By PRICE_LOCATOR = By.xpath("//div[@class='price-eur']");
    private static final String SNOWY_PEAKS_PAGE_URL = "https://www.airbaltic.com/en-BY/campaign/winter-2016-2017";

    @FindBy(xpath = "//div[contains(@class, 'sort-selection-price')]")
    private WebElement linkSortOffersByPrice;  //testcase #6

    @FindBy(xpath = "//input[@name='flt_origin_text']")
    private WebElement fMenuOrigins;


    public SnowyPeaksPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void Open() {
        driver.navigate().to(SNOWY_PEAKS_PAGE_URL);
    }

    public void clickSortOffersByPriceLink() {
        linkSortOffersByPrice.click();
    }

    public void scrollToPriceTable () {
        this.scrollToElementWithJS(fMenuOrigins);
    }

    private boolean isOffersSortedByPriceDsc() {
        return linkSortOffersByPrice.getAttribute("class").contains("sort-dsc");
    }

    public void sortOffersByPrice() {
        if (!isOffersSortedByPriceDsc()){
            clickSortOffersByPriceLink();
        }
        (new WebDriverWait(this.driver, WAIT_3_SEC)).until(AdditionalConditions.
                jQueryCompleted());
    }

    public boolean isOffersSortedCorrectly () {
        List<WebElement> pricesList = this.driver.findElements(PRICE_LOCATOR);
        for (int i = 0; i < pricesList.size()-1; i++) {
//            logger.info("Counter i=" + i);
            String str1 = pricesList.get(i).getText();
//            logger.info(str1);
            String str2 = pricesList.get(i+1).getText();
//            logger.info(str2);
            if (!(extractPriceFromStr(str1) >= extractPriceFromStr(str2))) {
                return false;
            }
        }
        return true;
    }

    private Integer extractPriceFromWebEl (WebElement webEl) {
        return Integer.parseInt(webEl.getText().replaceAll("[^0-9]",""));
    }

    private Integer extractPriceFromStr (String str) {
        return Integer.parseInt(str.replaceAll("[^0-9]",""));
    }



}
