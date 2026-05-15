package com.webshop.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ComputersPageTest extends BaseTest {

    @Test(priority = 1)
    public void testComputersPage() {
        logger = report.createTest("Test Computers Page");
        homePage.clickLoginLink();
        logger.pass("clicked on login link");
        loginPage.doLogin("selauto1@test.com","Pass@123");
        logger.pass("logged in with valid credentials");
        homePage.clickComputersMenu();
        logger.pass("clicked on computers menu");
        String header = computersPage.getComputersPageHeader();
        Assert.assertEquals(header, "Computers");
        logger.pass("computers page header is verified");
        homePage.clickLogoutLink();
        logger.pass("clicked on logout link");
    }

    @Test(priority = 2)
    public void testComputersCount() {
        logger = report.createTest("Test Computers Count");
        homePage.clickLoginLink();
        logger.pass("clicked on login link");
        loginPage.doLogin("selauto1@test.com", "Pass@123");
        logger.pass("logged in with valid credentials");
        homePage.clickComputersMenu();
        logger.pass("clicked on computers menu");
        int count = computersPage.getComputersCount();
        Assert.assertEquals(count, 3);
        logger.pass("computers count is verified");
        homePage.clickLogoutLink();
        logger.pass("clicked on logout link");
    }
}
