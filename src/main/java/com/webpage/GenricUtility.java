package com.webpage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.webdriveroperation.WebDriverOperation;

public class GenricUtility extends WebDriverOperation {

    // PropertiesOperation propertiesOperation = new PropertiesOperation();
    public static WebDriver driver;
    // public static String locators;
    // public static String locator;

    public GenricUtility() {
        super();
    }

    private  String getConfigfilevalue(String key) {
        return getPropertyValue("/config.properties", key);
    }

    private  String getLocatorProperties(String key) {
        return getPropertyValue("/Locators.properties", key);
    }

    private  String[] getLocator(String Locators) {
        return getLocatorProperties(Locators).split("#");
    }

    private  String getLocatorType(String Locators) {
        try {
            String[] locators = getLocator(Locators);
            if (locators.length > 0) {
                return locators[0];
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private  String getLocatorValue(String Locators) {
        try {
            String[] locators = getLocator(Locators);
            if (locators.length > 0) {
                return locators[1];
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public By locator(String Locators) {
        return by(getLocatorType(Locators), getLocatorValue(Locators));
    }

    private  By by(String locators, String locator) {
        try {
            switch (locators.toLowerCase()) {
                case "xpath":
                    return By.xpath(locator);
                case "id":
                    return By.id(locator);
                case "className":
                    return By.className(locator);
                case "cssSelector":
                    return By.cssSelector(locator);
                case "linkText":
                    return By.linkText(locator);
                case "name":
                    return By.name(locator);
                case "partialLinkText":
                    return By.partialLinkText(locator);
                case "tagName":
                    return By.tagName(locator);
                default:
                    throw new IllegalArgumentException("Invalid locator type: " + locators);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to create By object", e);
        }
    }

    protected  WebDriver getDriver() {
        this.driver = getDriver(getConfigfilevalue("browserdriver"));
        this.driver.manage().window().maximize();
        this.driver.get(getConfigfilevalue("uat"));
        return driver;
    }

    public void quitBrowser() {
        driver.quit();
    }

    public void closeBrowser() {
        driver.close();
    }

    public WebElement findElement(String locator) {
        return driver.findElement(locator(locator));
    }

    public List<WebElement> findElements(String locator) {
        return driver.findElements(locator(locator));
    }

    public WebDriverWait Wait(long timeoutInSeconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
    }

    public WebElement visibilityofElement(String locator){
        return Wait(10).until(ExpectedConditions.visibilityOfElementLocated(locator(locator)));
    }

    public List<WebElement> visibilityofelemrnts(String locator){
        return  Wait(10).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator(locator)));
    }
}
