package com.epam.AirBaltic.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Katerina_Karpenia on 3/1/2017.
 */
public class LoginForm extends Page{

    @FindBy(id = "myairbaltic-href")
    private WebElement loginButton;

    @FindBy(id = "loginFormLogin")
    private WebElement inputEmail;

    @FindBy(id = "loginFormPassword")
    private WebElement inputPassword;

    @FindBy(id = "login-btn")
    private WebElement buttonSubmit;

    public LoginForm(WebDriver driver) {
        super(driver);
    }

    public void login(String email, String password) {
        inputEmail.clear();
        inputEmail.sendKeys(email);
        inputPassword.clear();
        inputPassword.sendKeys(password);
        buttonSubmit.click();
    }

}
