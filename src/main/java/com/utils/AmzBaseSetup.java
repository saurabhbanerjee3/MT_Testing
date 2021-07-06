package com.utils;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;



public class AmzBaseSetup {
    public WebDriver driver;
    public  Properties prop;
    public static java.util.logging.Logger log = java.util.logging.Logger.getLogger(AmzBaseSetup.class.getName());
    public Properties getProp() throws IOException {
        prop = new Properties();
        FileInputStream fl = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/com/resources/data.properties");
        prop.load(fl);
        return prop;
    }

    //initialize chrome driver for test
    public WebDriver IntializeChromeDriver() throws IOException {
        String OS = System.getProperty("os.name").toLowerCase();
        //prop = new Properties();
        //FileInputStream fl = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/com/resources/data.properties");
        //prop.load(fl);
        String browserName = getProp().getProperty("browser");

        if (OS.contains("mac") && browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedrivers/chromedriver");
            driver = new ChromeDriver();
        } else {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedrivers/chromedriver.exe");
            driver = new ChromeDriver();
       }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;

    }
    public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
    {
        TakesScreenshot ts=(TakesScreenshot) driver;
        File source =ts.getScreenshotAs(OutputType.FILE);
        String destinationFile = System.getProperty("user.dir")+"/reports/"+testCaseName+".png";
        FileUtils.copyFile(source,new File(destinationFile));
        return destinationFile;

    }


}

