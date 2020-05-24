package com.codepack.steps.randomdategenerator;

import com.codepack.model.AbstractSeleniumSteps;
import com.codepack.model.SeleniumDriverContainer;
import com.codepack.uiobjects.randomdategenerator.DateGeneratorPageObjects;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class DateGeneratorFunctionalitySteps extends AbstractSeleniumSteps {

    private final DateGeneratorPageObjects dateGeneratorPageObjects;


    @Autowired
    public DateGeneratorFunctionalitySteps(SeleniumDriverContainer seleniumDriverContainer, DateGeneratorPageObjects dateGeneratorPageObjects) {
        super(seleniumDriverContainer);
        this.dateGeneratorPageObjects = dateGeneratorPageObjects;
        PageFactory.initElements(webDriver(), dateGeneratorPageObjects);
    }


    @Given("^I am on date generator home page$")
    public void iAmOnDateGeneratorHomePage() {
        dateGeneratorPageObjects.navigateToDateGenerator();
    }

    @When("^I enter date generator properties$")
    public void iEnterDateGeneratorProperties() {
        dateGeneratorPageObjects.enterTextInNumerOfDates("1");
        dateGeneratorPageObjects.selectDateFormat("yyyy-mm-dd-hh-mm-ss");
    }

    @Then("^I submit values$")
    public void iSubmitValues() {
        dateGeneratorPageObjects.clickGenerateButton();
    }

    @And("^I verify result$")
    public void iVerifyResult() {
        dateGeneratorPageObjects.verifyResult();
    }

    @When("^I enter date generator properties \"(.*)\" , \"(.*)\" , \"(.*)\" and \"(.*)\"$")
    public void iEnterDateGeneratorPropertiesAnd(String count, String dateFormat, String startDate, String endDate) {
        dateGeneratorPageObjects.enterTextInNumerOfDates(count);
        dateGeneratorPageObjects.selectDateFormat(dateFormat);

        if (dateFormat.equalsIgnoreCase("custom")) {
            dateGeneratorPageObjects.enterTextInCustomDateFormat("YY-MM-DD");
        }
        dateGeneratorPageObjects.enterTextInStartDate(startDate);
        dateGeneratorPageObjects.enterTextInEndDate(endDate);
    }

    @When("^I enter custom format as \"(.*)\" with date generator properties \"(.*)\" , \"(.*)\" , \"(.*)\" and \"(.*)\"$")
    public void iEnterCustomFormatAsWithDateGeneratorPropertiesAnd(String customDateFormat, String count, String dateFormat, String startDate, String endDate) {
        dateGeneratorPageObjects.enterTextInNumerOfDates(count);
        dateGeneratorPageObjects.selectDateFormat(dateFormat);

        if (dateFormat.equalsIgnoreCase("custom")) {
            dateGeneratorPageObjects.enterTextInCustomDateFormat(customDateFormat);
        }
        dateGeneratorPageObjects.enterTextInStartDate(startDate);
        dateGeneratorPageObjects.enterTextInEndDate(endDate);
    }

    @And("^I verify result and fail$")
    public void iVerifyResultAndFail() {
        Assert.assertTrue(false);
    }
}

