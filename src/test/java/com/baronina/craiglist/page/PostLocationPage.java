package com.baronina.craiglist.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PostLocationPage {
    private WebDriver driver;

    private By locationSelector = By.cssSelector(".selection-list li:nth-child(6)");

    public PostLocationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectLocation() {
        driver.findElement(locationSelector).click();
    }
}
