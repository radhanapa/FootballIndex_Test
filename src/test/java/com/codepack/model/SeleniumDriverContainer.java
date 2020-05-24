package com.codepack.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class SeleniumDriverContainer {
    private WebDriver webDriver =null;

    private static final String BROWSER = System.getProperty("browser", "chrome").toLowerCase();
//    private static final String URL = "http://www.google.co.uk";

    /**
     * Will either return the cached web driver, or create a new one
     * Creation will use the following system properties -
     * browser  - to select which browser to create
     * platform - to select which OS platform the test suite is running from
     *
     * @return a web driver to use
     */
    public WebDriver get() {
        if (webDriver == null) {
            webDriver = createWebDriver();
        }

        return webDriver;
    }

    private WebDriver createWebDriver(){
        if(webDriver == null){
            System.out.println("Initializing Driver");
            if(BROWSER.equalsIgnoreCase("firefox")){
                webDriver = new FirefoxDriver();
            }else if (BROWSER.equalsIgnoreCase("chrome")){
                System.setProperty("webdriver.chrome.driver","./src/test/resources/drivers/chromedriver.exe");
                webDriver = new ChromeDriver();
            }else if (BROWSER.equalsIgnoreCase("IE")){
                System.setProperty("webdriver.ie.driver","./src/test/resources/drivers/IEDriver.exe");
                webDriver = new InternetExplorerDriver();
            }
        }

        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
       // webDriver.navigate().to(URL);
        return webDriver;
    }

    public void close(){
        System.out.println("Closing browser");
        webDriver.close();
        webDriver=null;
    }

    public void quit(){
        System.out.println("Quitting browser");
        webDriver.quit();
        webDriver=null;
    }
}
