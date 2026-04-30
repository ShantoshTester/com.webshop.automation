package com.webshop.testcase;

import com.aventstack.extentreports.ExtentReports;
import com.webshop.base.DriverScript;
import com.webshop.page.HomePage;
import com.webshop.page.LoginPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest  {

    private static final Logger log = LoggerFactory.getLogger(LoginPageTest.class);

    @Test(priority = 1)
    public void testLoginPageTitle() {
        logger = report.createTest("Test Login Page Title");
        homePage.clickLoginLink();
        logger.pass("click on login link");
        String pageTitle = loginPage.getLoginPageTitle();
        logger.pass("get the login page title");
        Assert.assertTrue(pageTitle.contains("Login"));
        logger.pass("verified the login page title");
    }

    @Test(priority = 2)
    public void testValidLoginFunction() {
        logger= report.createTest("Test Valid Login Functionality");
        homePage.clickLoginLink();
        logger.pass("click on login link");
        loginPage.enterEmailID("selauto1@test.com");
        logger.pass("enter email id");
        loginPage.enterPassword("Pass@123");
        logger.pass("enter password");
        loginPage.clickLoginButton();
        logger.pass("click on login button");
        homePage.isLogoutLinkDisplayed();
        Assert.assertTrue(homePage.isLogoutLinkDisplayed());
        logger.pass("verify logout link is displayed");
        String title = homePage.getHomePageTitle();
        Assert.assertTrue(title.contains("Demo Web Shop"));
        logger.pass("verified home page title");
        homePage.clickLogoutLink();
        logger.pass("click on logout link");
    }

    @Test(priority = 3)
    public void testEmptyLoginFields() {
        logger= report.createTest("Test Empty Login Fields");
        homePage.clickLoginLink();
        logger.pass("click on login link");
        loginPage.clickLoginButton();
        logger.pass("click on login button without entering email and password");
        String errorMessage = loginPage.getLoginErrorMessage();
        Assert.assertTrue(errorMessage.contains("Please correct the errors and try again"));
        logger.pass("verified the login error message");
    }

    @Test(priority = 2)
    public void testValidLoginFunctionScreen() {
        logger= report.createTest("Test Login Functionality with Screenshot");
        homePage.clickLoginLink();
        logger.pass("click on login link");
        loginPage.enterEmailID("selauto1@test.com");
        logger.pass("enter email id");
        loginPage.enterPassword("00000");
        logger.pass("enter password");
        loginPage.clickLoginButton();
        logger.pass("click on login button");
        homePage.isLogoutLinkDisplayed();
        Assert.assertTrue(homePage.isLogoutLinkDisplayed());
        logger.pass("verify logout link is displayed");
        String title = homePage.getHomePageTitle();
        Assert.assertTrue(title.contains("Demo Web Shop"));
        logger.pass("verified home page title");
        homePage.clickLogoutLink();
        logger.pass("click on logout link");
    }




}
