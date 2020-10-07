package com.baronina.craiglist.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PostCityPage {
    private WebDriver driver;

    private By citySelector = By.cssSelector(".radio-option");

    public PostCityPage(WebDriver driver){
        this.driver = driver;
    }

    public void selectCity() {
        driver.findElement(citySelector).click();
    }
}
