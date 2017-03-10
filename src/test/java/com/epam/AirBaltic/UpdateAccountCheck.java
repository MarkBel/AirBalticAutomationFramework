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
    private static final String ORIGIN_COUNTRY = PropertyLoader.getProperty("editProfilePage.originCountry");
    private static final String CHANGED_COUNTRY_NAME = PropertyLoader.getProperty("editProfilePage.changedCountry");
    private static final int CHANGED_COUNTRY_NUMBER = 6;

    @Test
    public void updateAccountTest(){

        Assert.assertTrue(startPage
                .goToLoginForm()
                .login(USER_NAME, USER_PASSWORD)
                .goToEditProfilePage()
                .updateCountry(CHANGED_COUNTRY_NUMBER)
                .checkChangedCountry(CHANGED_COUNTRY_NAME), "Country is not updated!");
    }

    @AfterMethod
    public void returnOriginalCountry() {

    }

}
