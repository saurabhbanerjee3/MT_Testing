package testcases;

import com.pageobjects.AmzCartPage;
import com.pageobjects.AmzProductPage;
import com.pageobjects.AmzHomePage;
import com.utils.AmzBaseSetup;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.*;

import java.io.IOException;


public class AmzHomePageTest extends AmzBaseSetup {
    public WebDriver driver;
    //public static Logger log = LogManager.getLogger(testcases.AmzHomePageTest.class.getName());
    public static java.util.logging.Logger log = java.util.logging.Logger.getLogger(AmzBaseSetup.class.getName());
    AmzHomePage hPage;
    AmzProductPage amzProductPage;
    AmzCartPage amzCartPage;

    @BeforeTest
    public void initialiseTest() throws IOException {
        driver = IntializeChromeDriver();
        log.info("Initialised Driver");
        hPage = new AmzHomePage(driver);
        amzProductPage = new AmzProductPage(driver);
        amzCartPage = new AmzCartPage(driver);
    }

    @Test()
    public void testAmzPrice() throws InterruptedException, IOException {

        driver.get(getProp().getProperty("url"));
        hPage.getSearchBar().sendKeys(getProp().getProperty("testdata")); // reading data from properties file
        hPage.getSearchBar().sendKeys(Keys.ENTER);
        String priceHome = hPage.getPriceAtHome();
        log.info("Retrieved Price value as " + priceHome );

        Assert.assertEquals(priceHome.isBlank(), false); //verifying if the price has the value
        log.info("the values matched with home page " + priceHome);

        hPage.getBookDetail().click();
        String actualPrice = amzProductPage.getItemPriceString();
        log.info("Retrieved the price at prodcut page " + actualPrice);


        Assert.assertEquals(actualPrice.isBlank(), false);
        log.info("Check if price is not blank ");

        Assert.assertEquals(priceHome, actualPrice); //validating the price from both the pages
        log.info("Validate the price value from two pages are matched");

        amzProductPage.getAddToCart().click();
        String priceAtCart = amzCartPage.getPriceAtCartString();
        log.info("Get the price from cart page " + priceAtCart);

        Assert.assertEquals(priceHome,priceAtCart);
        log.info("Validate the price at home page " + priceHome+"is matched with the price at cart page " + priceAtCart);
        amzCartPage.getProceedToCartButton().click();

    }

    @Test
    public void testReport()
    {
        System.out.println("Dummy test 1 for reporting purpose ");
    }

    @Test
    public void testReport2()
    {
        System.out.println("Dummy test 2 for reporting purpose ");
    }
    @AfterTest
    public void quitDriver() {
        driver.quit();
    }

    @DataProvider
    public Object[][] getData() throws IOException {

        Object[][] data=new Object[2][3];
        //0th row
        data[0][0]=getProp().getProperty("testdata");


        return data;

    }

}


