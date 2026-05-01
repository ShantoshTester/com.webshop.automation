package com.webshop.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GiftCardsTest extends BaseTest {

    @Test(priority =1)
    public void testGiftCardsPage() {
        logger = report.createTest("Test Gift Cards Page");
        homePage.clickLoginLink();
        logger.pass("clicked on login link");
        loginPage.doLogin("selauto1@test.com","Pass@123");
        logger.pass("logged in with valid credentials");
        homePage.clickGiftCardsMenu();
        logger.pass("clicked on gift cards menu");
        String header = giftCardsPage.getGiftCardsPageHeader();
        Assert.assertEquals(header, "Gift Cards");
        logger.pass("gift cards page header is verified");
        homePage.clickLogoutLink();
        logger.pass("clicked on logout link");
    }

    @Test(priority = 2)
    public void testGiftCardsCount() {
        logger = report.createTest("Test Gift Cards Count");
        homePage.clickLoginLink();
        logger.pass("clicked on login link");
        loginPage.doLogin("selauto1@test.com", "Pass@123");
        logger.pass("logged in with valid credentials");
        homePage.clickGiftCardsMenu();
        logger.pass("clicked on gift cards menu");
        int count = giftCardsPage.getGiftCardsCount();
        Assert.assertEquals(count, 4);
        logger.pass("gift cards count is verified");
        homePage.clickLogoutLink();
        logger.pass("clicked on logout link");
    }
}
