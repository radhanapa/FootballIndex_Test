package com.codepack.utilities;

import org.json.JSONException;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

/**
 * A collection of useful methods for using with Selenium
 */
public class SeleniumUtils {

    private static int NORMAL_TIMEOUT = 20;
    private static int LONG_TIMEOUT = 30;

    public static void waitForPresence(WebDriver webDriver, By locator) {
        WebDriverWait driverWait = new WebDriverWait(webDriver, NORMAL_TIMEOUT);
        driverWait.until(presenceOfElementLocated(locator));
    }

    public static void waitUntilVisible(WebDriver webDriver, By locator) {
        WebDriverWait driverWait = new WebDriverWait(webDriver, NORMAL_TIMEOUT);
        driverWait.until(visibilityOfElementLocated(locator));
    }

    public static void waitUntilVisible(WebDriver webDriver, WebElement element) {
        WebDriverWait driverWait = new WebDriverWait(webDriver, NORMAL_TIMEOUT);
        driverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitUntilTextPresent(WebDriver webDriver, By locator, String expectedText) {
        WebDriverWait driverWait = new WebDriverWait(webDriver, NORMAL_TIMEOUT);
        driverWait.until(ExpectedConditions.textToBePresentInElementLocated(locator, expectedText));
    }

    public static void waitUntilInvisible(WebDriver webDriver, By locator) {
        WebDriverWait driverWait = new WebDriverWait(webDriver, NORMAL_TIMEOUT);
        driverWait.until(invisibilityOfElementLocated(locator));
    }

    public static void acceptAlertIfPresent(WebDriver webDriver) {
        WebDriverWait wait = new WebDriverWait(webDriver, 1);
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = webDriver.switchTo().alert();
            alert.accept();
            webDriver.switchTo().defaultContent();
        } catch (Exception e) {
            // No alert
        }
    }

    public static void dismissAlertIfPresent(WebDriver webDriver) {
        WebDriverWait wait = new WebDriverWait(webDriver, 1);
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = webDriver.switchTo().alert();
            alert.dismiss();
            webDriver.switchTo().defaultContent();
        } catch (Exception e) {
            // No alert
        }
    }

    public static void waitUntilPresent(WebDriver webDriver, By locator) {
        WebDriverWait driverWait = new WebDriverWait(webDriver, NORMAL_TIMEOUT);
        driverWait.until(presenceOfElementLocated(locator));
    }

    public static void waitUntilClickable(WebDriver webDriver, By locator) {
        WebDriverWait driverWait = new WebDriverWait(webDriver, NORMAL_TIMEOUT);
        driverWait.until(ExpectedConditions.elementToBeClickable(locator));
    }


    public static void scrollIntoView(WebDriver webDriver, WebElement element) {
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void waitForPageLoad(WebDriver webDriver) {
        Wait<WebDriver> wait = new WebDriverWait(webDriver, LONG_TIMEOUT);
        wait.until(driver -> String
                .valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
                .equals("complete"));
    }

    public static void assertInnerHTMLOfElement(WebDriver webDriver, String cssSelector,
                                                String expectedValue, boolean expected) throws JSONException {
        By locator = cssSelector(cssSelector);

        if (expected) {
            waitUntilVisible(webDriver, locator);
            assertThat(webDriver.findElement(locator).getAttribute("innerHTML")).isEqualTo(expectedValue);
        } else {
            try {
                assertThat(webDriver.findElement(locator).getAttribute("innerHTML")).isNotEqualTo(expectedValue);
            } catch (NoSuchElementException e) {
                // No-op. If it doesn't exist then we can assert that it doesnt contain text equalling the given
            }
        }
    }

    public static void assertTextOfElement(WebDriver webDriver, String cssSelector,
                                           String expectedValue, boolean expected)
            throws JSONException {
        By locator = cssSelector(cssSelector);

        if (expected) {
            waitUntilTextPresent(webDriver, locator, expectedValue);
            assertThat(webDriver.findElement(locator).getText()).isEqualTo(expectedValue);
        } else {
            try {
                assertThat(webDriver.findElement(locator).getText()).isNotEqualTo(expectedValue);
            } catch (NoSuchElementException e) {
                // No-op. If it doesn't exist then we can assert that it doesnt contain text equalling the given
            }
        }
    }
}

