package com.epam.AirBaltic.tests.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by Kate on 10.06.17.
 */

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        plugin = {
                "pretty", "json:target/Cucumber.json",
                "html:target/cucumber-html-report"
        },
        features = "src/test/resources/com/epam/AirBaltic/tests/cucumber",
        tags = {"@Price, @Account, @Reservation"},
        glue = {"classpath:com/epam/AirBaltic/tests/cucumber/"}

)
public class RunningCucumberTest {


}
