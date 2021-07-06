package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmzHomePage {
    WebDriver driver;

    public AmzHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = ".//*[@id='twotabsearchtextbox']")
    WebElement searchBar;

    @FindBy(xpath = "(.//*[@class=\"s-image\"])[1]")
    WebElement bookDetail;

    @FindBy(xpath = "//input[@id='nav-search-submit-button']")
    WebElement searchButton;

    @FindBy(xpath = "//*[@id=\"search\"]/div[1]/div/div[1]/div/span[3]/div[2]/div[2]/div/span/div/div/div/div/div[2]/div[2]/div/div/div[3]/div[1]/div/div[1]/div[2]/a/span[1]/span[2]/span[2]")
    WebElement priceAtHome;

    @FindBy(xpath = "//*[@id=\"search\"]/div[1]/div/div[1]/div/span[3]/div[2]/div[2]/div/span/div/div/div/div/div[2]/div[2]/div/div/div[3]/div[1]/div/div[1]/div[2]/a/span[1]/span[2]/span[3]")
    WebElement priceAtHomeFraction;

    public WebElement getSearchBar() {
        return searchBar;
    }

    public WebElement getBookDetail() {
        return bookDetail;
    }

    public String getPriceAtHome() {
        String priceAtHomeString = "$" + priceAtHome.getText() + "." + priceAtHomeFraction.getText();
        System.out.println("Price at Home PAge " + priceAtHomeString);
        return priceAtHomeString;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }

}

