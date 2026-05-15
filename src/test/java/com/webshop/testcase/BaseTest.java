package com.webshop.testcase;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.webshop.base.DriverScript;
import com.webshop.page.ComputersPage;
import com.webshop.page.GiftCardsPage;
import com.webshop.page.HomePage;
import com.webshop.page.LoginPage;
import com.webshop.utils.ExcelUtil;
import com.webshop.utils.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;

public class BaseTest extends DriverScript {

    public static ExtentTest logger;
    public static ExtentReports report;
    HomePage homePage;
    LoginPage loginPage;
    GiftCardsPage giftCardsPage;
    ComputersPage computersPage;

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
        giftCardsPage=new GiftCardsPage();
        computersPage = new ComputersPage();
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

    /*
        This data provider method will read the test data from the excel file and return it as a 2D array.
     */
    @DataProvider(name = "loginData")
    public Object[][] getTestData() {
        ExcelUtil exceldata = new ExcelUtil("./src/test/resources/testdata/wsdata.xlsx");
        int rows = exceldata.getRowCount("usercred");
        Object[][] data = new Object[rows][2];

        for(int i=0; i<rows; i++) {
            data[i][0] = exceldata.getCellData("usercred", i, 0);
            data[i][1] = exceldata.getCellData("usercred", i, 1);
        }
        return data;
    }


}
