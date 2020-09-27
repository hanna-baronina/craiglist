package com.baronina.craiglist.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultPage {
    private WebDriver driver;

    private By searchText = By.cssSelector("input#query");
    private By searchResults = By.cssSelector("ul.rows li");
    private By postHeader = By.cssSelector(".result-info h2");

    public SearchResultPage(WebDriver driver){
        this.driver = driver;
    }

    public String getSearchText(){
        return driver.findElement(searchText).getAttribute("value");
    }

    public WebElement getPostElement(int postNumber){
        List<WebElement> postElements = driver.findElements(searchResults);
        return postElements.get(postNumber);
    }

    public String getPostHeader(WebElement post){
       return post.findElement(postHeader).getText();
    }

    public void clickPost(WebElement post){
        post.click();
    }
}
