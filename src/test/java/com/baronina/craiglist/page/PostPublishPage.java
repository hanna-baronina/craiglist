package com.baronina.craiglist.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PostPublishPage {
    WebDriver driver;

    private By publishButton = By.xpath("//button[@value='Continue']");

    public PostPublishPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickPublishButton(){
        driver.findElement(publishButton).click();
    }

    public WebElement getPublishButton(){
        return driver.findElement(publishButton);
    }
}
