package com.baronina.craiglist.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage {
    WebDriver driver;

    private By linkToMainPage= By.linkText("craigslist");

    public AccountPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickLinkToMainPage(){
        driver.findElement(linkToMainPage).click();
    }
}
