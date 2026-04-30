package com.webshop.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

public class DriverScript {

    public static WebDriver driver;
    Properties prop;

    /*
     * This constructor will load the config file and read the properties from it
     */
    public DriverScript() {
        try
        {
            File file = new File("./src/test/resources/config/config.properties");
            FileInputStream fis = new FileInputStream(file);
            prop = new Properties();
            prop.load(fis);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("unable to load the config file :: " + e.getMessage());
        }
    }

   /*
    * This method will initialize the application based on the properties value from the config file
    */
    public void initApplication()
    {
        String browser = prop.getProperty("browser");
        if(browser.trim().equalsIgnoreCase("chrome"))
        {
            driver = new ChromeDriver();
        }
        else if(browser.trim().equalsIgnoreCase("firefox"))
        {
            driver = new FirefoxDriver();
        }
        else if(browser.trim().equalsIgnoreCase("edge"))
        {
            driver = new EdgeDriver();
        }
        else
        {
            System.out.println("unsupported browser. please check the config file");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        launchApplication();
    }

    /*
     * This method will launch the application based on the url value from the config file
     */
    public void launchApplication() {
        String url = prop.getProperty("url");
        driver.get(url);
    }

    /*
     * This method will quit the driver instance
     */
    public void quitDriver()  {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if(driver != null)
        {
            driver.quit();
        }
    }
}
