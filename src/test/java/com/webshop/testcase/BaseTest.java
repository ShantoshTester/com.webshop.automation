package com.webshop.testcase;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.webshop.base.DriverScript;
import com.webshop.page.HomePage;
import com.webshop.page.LoginPage;
import com.webshop.utils.Helper;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class BaseTest extends DriverScript {

    public static ExtentTest logger;
    public static ExtentReports report;
    HomePage homePage;
    LoginPage loginPage;

    @BeforeSuite
    public void setUpReport() {
        ExtentHtmlReporter extent = new ExtentHtmlReporter("./src/test/resources/testreport/index.html");
        report = new ExtentReports();
        report.attachReporter(extent);
    }

    @BeforeMethod
    public void setUp() {
        initApplication();
        homePage = new HomePage();
        loginPage = new LoginPage();
    }

    /*
        * This method will execute after each test method and check the test result.
        * If the test is failed then it will capture the screenshot and attach it to the report.
     */
    @AfterMethod
    public void tearDown(ITestResult result) {

        if(result.getStatus()==ITestResult.FAILURE)
        {
            try {
                logger.fail("Failed",
               MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreen(driver)).build());
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        report.flush();
        quitDriver();
    }
}
