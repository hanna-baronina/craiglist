package com.baronina.craiglist.test;

import com.baronina.craiglist.framework.DriverProvider;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
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

        WebElement webElement = driver.findElement(By.cssSelector(".sublinks li:nth-child(1)"));
        List<WebElement> webElements = webElement.findElements(By.cssSelector("a"));
        Assert.assertEquals(0, webElements.size());
    }

    @Test
    public void verifySwitchRegionSelector(){
        driver.findElement(By.xpath("//a[contains(text(),'sby')]")).click();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2")));
        String actualHeader = driver.findElement(By.cssSelector("h2")).getText();
        Assert.assertEquals("south bay area", actualHeader);

        WebElement webElement = driver.findElement(By.cssSelector(".sublinks li:nth-child(2)"));
        List<WebElement> webElements = webElement.findElements(By.cssSelector("a"));
        Assert.assertEquals(0, webElements.size());
    }

    @Test
    public void verifySearchField(){
        driver.findElement(By.id("query")).sendKeys("book", Keys.ENTER);
        String text = driver.findElement(By.cssSelector("input#query")).getAttribute("value");
        Assert.assertEquals("book", text);
        driver.navigate().back();
    }

    @Test
    public void verifyLanguageDropdown(){
        //driver.findElement(By.id("chlang")).click();
        Select dropdown = new Select(driver.findElement(By.id("chlang")));
        dropdown.selectByIndex(1);
    }

    @Test
    public void verifyUserLinks(){
        WebElement userResources = driver.findElement(By.id("user_resources"));
        List<WebElement> links = userResources.findElements(By.cssSelector("a"));
        for(int i = 0; i < links.size(); i++){
            String link = links.get(i).getText();
            driver.findElement(By.linkText(link)).click();
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.history.go(-1)");
            userResources = driver.findElement(By.id("user_resources"));
            links = userResources.findElements(By.cssSelector("a"));
        }
    }

    @After
    public void after(){
       driver.quit();
    }
}
