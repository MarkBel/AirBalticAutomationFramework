package com.epam.AirBaltic;

import com.epam.AirBaltic.PageTest;
import com.epam.AirBaltic.pages.EditProfilePage;
import com.epam.AirBaltic.util.PropertyLoader;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Kseniya_Kunda on 3/3/2017.
 */
public class UpdateAccountCheck extends PageTest {

    protected static final String USER_NAME = PropertyLoader.getProperty("user.name");
    protected static final String USER_PASSWORD = PropertyLoader.getProperty("user.password");
    private EditProfilePage editProfilePage;

    @Test
    public void updateAccountTest(){
        startPage.loginCheck(USER_NAME, USER_PASSWORD);
        editProfilePage = startPage.goToEditProfilePage();
        editProfilePage.updateCountry();

        Assert.assertTrue(editProfilePage.checkChangedCountry(), "Country is not updated!");
    }
}
