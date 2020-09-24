package com.baronina.craiglist.test;

import com.baronina.craiglist.framework.DriverProvider;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/** Tests for Craiglist main page. */
public class MainPageTest {
    private static final String MAIN_PAGE_URL = "https://sfbay.craigslist.org/";
    private WebDriver driver;

    @Before
    public void before(){
        driver = DriverProvider.getDriver();
        driver.get(MAIN_PAGE_URL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void verifyTitle(){
        String actualTitle = driver.getTitle();
        Assert.assertEquals("craigslist: SF bay area jobs, apartments, " +
                "for sale, services, community, and events" , actualTitle);
    }

    @Test
    public void verifyRegionHeader(){
       String actualRegion = driver.findElement(By.cssSelector("h2")).getText();
       Assert.assertEquals("SF bay area", actualRegion);
    }

    @Test
    public void verifyRegionSelector(){
        driver.findElement(By.cssSelector("a[title='san francisco']")).click();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2")));

        String actualHeader = driver.findElement(By.cssSelector("h2")).getText();
        Assert.assertEquals("city of san francisco", actualHeader);
    }

    @After
    public void after(){
        driver.quit();
    }
}
