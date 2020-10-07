package com.baronina.craiglist.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreatePostPage {
    private WebDriver driver;

    private By postingTitleField = By.id("PostingTitle");
    private By cityField = By.id("geographic_area");
    private By postalCodeField = By.id("postal_code");
    private By postingBodyField = By.id("PostingBody");
    private By continueButton = By.xpath("//button[@name='go']");
    private By confirmButton = By.className("continue");
    private By doneWithImagesButton = By.className("done");

    public CreatePostPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterPostingTitle(String title) {
        driver.findElement(postingTitleField).sendKeys(title);
    }

    public void enterCity(String city) {
        driver.findElement(cityField).sendKeys(city);
    }

    public void enterPostalCode(String postalCode) {
        driver.findElement(postalCodeField).sendKeys(postalCode);
    }

    public void enterPostingBody(String body) {
        driver.findElement(postingBodyField).sendKeys(body);
    }

    public void clickContinueButton() {
        driver.findElement(continueButton).click();
    }

    public void clickConfirmButton() {
        driver.findElement(confirmButton).click();
    }

    public void clickDoneWithImagesButton() {
        driver.findElement(doneWithImagesButton).click();
    }
}
