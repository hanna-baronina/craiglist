package com.baronina.craiglist.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PostingSuccessPage {
    WebDriver driver;

    private By successPostingHeader = By.cssSelector("h4");

    public PostingSuccessPage(WebDriver driver){
        this.driver = driver;
    }

    public String getSuccessPostingHeader(){
        return driver.findElement(successPostingHeader).getText();
    }
}
