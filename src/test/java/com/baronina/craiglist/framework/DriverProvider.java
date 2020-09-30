package com.baronina.craiglist.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

/** Provides driver for the tests. */
public class DriverProvider {
    private static final String BROWSER = "chrome";

    public static WebDriver getDriver(){
        if(BROWSER.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", "/Users/hannabaronina/Documents/automation_drivers/chromedriver3");
            return new ChromeDriver();
        } else if(BROWSER.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver", "/Users/hannabaronina/Documents/automation_drivers/geckodriver");
            return new FirefoxDriver();
        } else if(BROWSER.equalsIgnoreCase("safari")){
            System.setProperty("webdriver.safari.noinstall", "true");
            return new SafariDriver();
        }
        throw new RuntimeException("Driver not found");
    }
}
