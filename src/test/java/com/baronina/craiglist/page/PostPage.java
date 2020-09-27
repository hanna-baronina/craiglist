package com.baronina.craiglist.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PostPage {
    private WebDriver driver;

    private By postTitle = By.id("titletextonly");
    private By postImage = By.cssSelector("img");
    private By postText = By.cssSelector("#postingbody");
    private By replyButton = By.className("reply-button");
    private By gmailReplyLink = By.cssSelector("a.gmail");

    public PostPage(WebDriver driver){
        this.driver = driver;
    }

    public String getPostTitle(){
        return driver.findElement(postTitle).getText();
    }

    public  boolean isImageDisplayed(){
       return driver.findElement(postImage).isDisplayed();
    }

    public String getImageURL(){
       return driver.findElement(postImage).getAttribute("src");
    }

    public String getPostText(){
        return driver.findElement(postText).getText();
    }

    public void clickReply(){
        driver.findElement(replyButton).click();
    }

    public void clickGMailReply(){
        driver.findElement(gmailReplyLink).click();
    }
}
