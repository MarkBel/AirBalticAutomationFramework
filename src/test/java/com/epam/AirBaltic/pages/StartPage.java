package com.epam.AirBaltic.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

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




  public StartPage(WebDriver driver) {
    super(driver);
  }

  public BookAndFlightPage openBookAndFlights() {

    inptDestTo.clear();
    inptDestTo.sendKeys("Oslo");

    btnBookAndFlights.click();

    return new BookAndFlightPage(driver);

  }


}
