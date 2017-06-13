package com.epam.AirBaltic.tests.cucumber.steps;

import com.epam.AirBaltic.pages.EditProfilePage;
import com.epam.AirBaltic.pages.StartPage;
import com.epam.AirBaltic.tests.PreparationSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

/**
 * Created by Kate on 08.06.17.
 */

public class UpdateAccountCucumberSteps extends PreparationSteps {

    private static final String ERROR_MESSAGE = "Only Latin characters are allowed";

    @When("^I go to Edit Profile Page$")
    public void iGoToEditPage() throws Throwable {
        startPage.goToEditProfilePage();
}

    @And("^I update surname$")
    public void iUpdateSurname() throws Throwable {
        new EditProfilePage(driver).updateSurname(NEW_SURNAME);
}

    @Then("^I get Error Message$")
    public void iGetErrorMessage() throws Throwable {
        Assert.assertTrue(new EditProfilePage(driver)
                .getErrorMessage(ERROR_MESSAGE), "Surname is updated!");
}




}
