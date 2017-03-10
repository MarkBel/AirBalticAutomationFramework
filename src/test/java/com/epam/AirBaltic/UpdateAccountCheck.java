package com.epam.AirBaltic;

import com.epam.AirBaltic.AbstractPageTest;
import com.epam.AirBaltic.pages.EditProfilePage;
import com.epam.AirBaltic.pages.LoginForm;
import com.epam.AirBaltic.util.PropertyLoader;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

/**
 * Created by Kseniya_Kunda on 3/3/2017.
 */
public class UpdateAccountCheck extends AbstractPageTest {

    protected static final String USER_NAME = PropertyLoader.getProperty("user.name");
    protected static final String USER_PASSWORD = PropertyLoader.getProperty("user.password");
    private EditProfilePage editProfilePage;
    private LoginForm loginForm;

    @Test
    public void updateAccountTest(){
        loginForm = startPage.goToLoginForm();
        startPage = loginForm.login(USER_NAME, USER_PASSWORD);
        startPage.loginCheck();
        editProfilePage = startPage.goToEditProfilePage();
        editProfilePage.updateCountry();

        Assert.assertTrue(editProfilePage.checkChangedCountry(), "Country is not updated!");
    }

}
