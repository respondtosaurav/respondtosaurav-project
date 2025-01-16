package com.webpage;

import org.openqa.selenium.WebDriver;

public class Login extends GenricUtility{
    public static WebDriver driver;
    public Login(){
        super();
        this.driver = getDriver();
    }
 
    public void clickonloginbutton(String locator){
        driver.findElement(locator(locator)).click();
    }

    public void selectUserType(String locator){
        visibilityofElement(locator).click();
        
    }

    

}
