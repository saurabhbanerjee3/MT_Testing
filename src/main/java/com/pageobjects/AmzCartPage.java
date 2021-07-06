package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmzCartPage {
    public WebDriver driver;


    public AmzCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"hlb-subcart\"]/div[1]/span/span[2]")
    WebElement priceAtCart;

    @FindBy(xpath = "//*[@id=\"hlb-ptc-btn-native\"]")
    WebElement proceedToCartButton;

    public WebElement getPriceAtCart() {
        return priceAtCart;
    }

    public String getPriceAtCartString() {
        String priceAtCartString = priceAtCart.getText();
        return priceAtCartString;
    }

    public WebElement getProceedToCartButton() {
        return proceedToCartButton;
    }
}
