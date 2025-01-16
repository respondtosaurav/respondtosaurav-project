package com.webdriveroperation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverOperation extends com.propertiesoperation.PropertiesOperation {

    public WebDriver driver;

    public WebDriverOperation() {
        this.driver = driver;
    }

    protected   WebDriver getDriver(String browser) {
        try {
            if (browser.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                return this.driver = new ChromeDriver();
            } else if (browser.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                return this.driver = new FirefoxDriver();
            } else if (browser.equalsIgnoreCase("edge")) {
                WebDriverManager.edgedriver().setup();
                return this.driver = new EdgeDriver();
            } else {
                WebDriverManager.chromedriver().setup();
                return this.driver = new ChromeDriver();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Browser not supported");
        }

    }

}
