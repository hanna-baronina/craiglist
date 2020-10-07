package com.baronina.craiglist.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PostTypePage {
    WebDriver driver;

    private By typeSelector = By.cssSelector(".selection-list li:nth-child(6)");

    public PostTypePage(WebDriver driver){
        this.driver = driver;
    }

    public void selectType() {
        driver.findElement(typeSelector).click();
    }
}
