package com.epam.AirBaltic.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Kseniya_Kunda on 3/3/2017.
 */
public class UpdateAccountTest extends PreparationSteps {

    private static final String ERROR_MESSAGE = "Only Latin characters are allowed";

    @Test
    public void updateSurnameInAccountTest() {

        Assert.assertTrue(startPage
                .goToLoginForm()
                .login(USER_NAME, USER_PASSWORD)
                .goToEditProfilePage()
                .updateSurname(NEW_SURNAME)
                .getErrorMessage(ERROR_MESSAGE), "Surname is updated!");
    }
}
