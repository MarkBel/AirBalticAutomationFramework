package com.epam.AirBaltic.tests;

import com.epam.AirBaltic.util.PropertyLoader;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

/**
 * Created by Kseniya_Kunda on 3/3/2017.
 */
public class UpdateAccountVerification extends PreparationSteps {

    protected static final String USER_NAME = PropertyLoader.getProperty("user.name");
    protected static final String USER_PASSWORD = PropertyLoader.getProperty("user.password");
    private static final String NEW_SURNAME = PropertyLoader.getProperty("editProfilePage.newSurname");
    private static final String ERROR_MESSAGE = "Only Latin characters are allowed";

    @Test
    public void updateAccountTest() {

        Assert.assertTrue(startPage
                .goToLoginForm()
                .login(USER_NAME, USER_PASSWORD)
                .goToEditProfilePage()
                .updateSurname(NEW_SURNAME)
                .checkErrorMessage(ERROR_MESSAGE), "Surname is updated!");
    }
}
