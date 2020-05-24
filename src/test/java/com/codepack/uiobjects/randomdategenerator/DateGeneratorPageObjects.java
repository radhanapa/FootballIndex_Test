package com.codepack.uiobjects.randomdategenerator;

import com.codepack.model.AbstractSeleniumSteps;
import com.codepack.model.SeleniumDriverContainer;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.codepack.utilities.PropertiesUtil.getBaseUrl;

@Component
public class DateGeneratorPageObjects extends AbstractSeleniumSteps {

    @Autowired
    public DateGeneratorPageObjects(SeleniumDriverContainer seleniumDriverContainer) {
        super(seleniumDriverContainer);
    }

    @FindBy(id = "option-count-147fe348")
    WebElement numberOfDatesToGenerate;

    @FindBy(id = "option-format-147fe348")
    WebElement dateFormat;

    @FindBy(className = "generatejson")
    WebElement submitButton;

    @FindBy(className = "data-wrapper")
    WebElement resultBox;

    @FindBy(id = "option-custom-format-147fe348")
    WebElement customDateFormat;

    @FindBy(id = "option-start-147fe348")
    WebElement startDate;

    @FindBy(id = "option-end-147fe348")
    WebElement endDate;

    public void navigateToDateGenerator(){
        webDriver().navigate().to(getBaseUrl());
    }

//    @FindBy(className = "r")
//    WebElement searchResult;
//
    public void enterTextInNumerOfDates(String value){
        numberOfDatesToGenerate.click();
        numberOfDatesToGenerate.clear();
        numberOfDatesToGenerate.sendKeys(value);
        Assert.assertTrue(numberOfDatesToGenerate.getAttribute("value").toString().equalsIgnoreCase(value));
    }

    public void enterTextInCustomDateFormat(String value){
        customDateFormat.click();
        customDateFormat.clear();
        customDateFormat.sendKeys(value);
        Assert.assertTrue(customDateFormat.getAttribute("value").toString().equalsIgnoreCase(value));
    }

    public void enterTextInStartDate(String value){
        startDate.click();
        startDate.clear();
        startDate.sendKeys(value);
        Assert.assertTrue(startDate.getAttribute("value").toString().equalsIgnoreCase(value));
    }

    public void enterTextInEndDate(String value){
        endDate.click();
        endDate.clear();
        endDate.sendKeys(value);
        Assert.assertTrue(endDate.getAttribute("value").toString().equalsIgnoreCase(value));
    }

    public void clickGenerateButton(){
        submitButton.sendKeys(Keys.ENTER);
    }

    public void selectDateFormat(String value){
        Select format = new Select(dateFormat);
        format.selectByValue(value);
    }

    public void verifyResult(){
        String text = resultBox.getText();
        System.out.println("Result is : "+text);
    }

//
//    public void verifyResults(){
//        Assert.assertTrue(searchResult.isDisplayed());
//        searchResult.click();
//        webDriver().quit();
//    }

}
