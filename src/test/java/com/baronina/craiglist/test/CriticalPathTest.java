package com.baronina.craiglist.test;

import com.baronina.craiglist.framework.DriverProvider;
import com.baronina.craiglist.page.MainPage;
import com.baronina.craiglist.page.PostPage;
import com.baronina.craiglist.page.SearchResultPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/** End-to-End tests for the most critical business scenarios. */
public class CriticalPathTest {
    private WebDriver driver;

    @Before
    public void before() {
        driver = DriverProvider.getDriver();
        driver.get(MainPage.PAGE_URL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void verifyFindPostingAndReply() {
        MainPage mainPage = new MainPage(driver);
        mainPage.executeSearch("book");

        SearchResultPage searchResultPage = new SearchResultPage(driver);
        String actualSearchText = searchResultPage.getSearchText();
        Assert.assertEquals("book", actualSearchText);

        WebElement post = searchResultPage.getPostElement(2);
        String actualPostHeader = searchResultPage.getPostHeader(post);
        Assert.assertTrue(actualPostHeader.toLowerCase().contains("book"));

        searchResultPage.clickPost(post);

        PostPage postPage = new PostPage(driver);
        String actualPostTitle = postPage.getPostTitle();
        Assert.assertTrue(actualPostTitle.toLowerCase().contains("book"));

        Assert.assertTrue(postPage.isImageDisplayed());

        Assert.assertNotNull(postPage.getImageURL());
        Assert.assertTrue(postPage.getImageURL().length() > 0);

        Assert.assertNotNull(postPage.getPostText());
        Assert.assertTrue(postPage.getPostText().length() > 0);

        postPage.clickReply();

        String mainWindow = driver.getWindowHandle();
        postPage.clickGMailReply();

        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.numberOfWindowsToBe(2));

        Set<String> windows = driver.getWindowHandles();
        for(String window : windows){
            if (!mainWindow.equalsIgnoreCase(window)) {
                driver.switchTo().window(window);
                WebDriverWait webDriverWait1 = new WebDriverWait(driver,5);
                webDriverWait1.until(ExpectedConditions.urlContains("mail.google.com"));
            }
        }
    }

    @After
    public void after() {
        driver.quit();
    }
}
