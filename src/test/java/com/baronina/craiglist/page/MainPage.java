package com.baronina.craiglist.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class MainPage {
    public static final String PAGE_URL = "https://sfbay.craigslist.org/";

    private WebDriver driver;
    private By searchField = By.id("query");

    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    public void executeSearch(String searchText){
        driver.findElement(searchField).sendKeys(searchText, Keys.ENTER);
    }
}
