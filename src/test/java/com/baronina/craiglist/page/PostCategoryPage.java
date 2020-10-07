package com.baronina.craiglist.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PostCategoryPage {
    WebDriver driver;

    private By categorySelector = By.cssSelector(".radio-option");

    public PostCategoryPage(WebDriver driver){
        this.driver = driver;
    }

    public void selectCategory() {
        driver.findElement(categorySelector).click();
    }
}
