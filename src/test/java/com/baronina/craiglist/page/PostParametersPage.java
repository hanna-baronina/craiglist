package com.baronina.craiglist.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PostParametersPage {
    private WebDriver driver;

    private By locationSelector = By.cssSelector(".selection-list li:nth-child(6)");
    private By citySelector = By.cssSelector(".radio-option");
    private By typeSelector = By.cssSelector(".selection-list li:nth-child(6)");
    private By categorySelector = By.cssSelector(".radio-option");

    public PostParametersPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectLocation() {
        driver.findElement(locationSelector).click();
    }

    public void selectCity() {
        driver.findElement(citySelector).click();
    }

    public void selectType() {
        driver.findElement(typeSelector).click();
    }

    public void selectCategory() {
        driver.findElement(categorySelector).click();
    }
}
