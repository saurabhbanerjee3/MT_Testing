package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmzProductPage {
    WebDriver driver;
    public AmzProductPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy (xpath="//*[@id=\"mediaTab_heading_2\"]/a/span/div[2]/span")////*[@id="a-autoid-2-announce"]/span[2]/span
    WebElement  itemPrice;

    @FindBy (xpath = "//input[@id='add-to-cart-button']")
    WebElement addToCart;

    public WebElement getItemPrice ()
    {
        return itemPrice;
    }
    public WebElement getAddToCart ()
    {
        return addToCart;
    }

    public  String getItemPriceString()
    {
        String priceValue=itemPrice.getText();
        System.out.println("the price is"+priceValue);
        return priceValue;
    }
}
