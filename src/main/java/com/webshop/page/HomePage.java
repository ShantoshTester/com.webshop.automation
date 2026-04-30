package com.webshop.page;

import com.webshop.base.DriverScript;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends DriverScript {

    // ============================== Page Elements ========================================== //

    @FindBy(linkText = "Log in") private WebElement loginLink;
    @FindBy(linkText = "Log out") private WebElement logoutLink;

    // ============================== Page Initialization ===================================== //

    public HomePage() {
        PageFactory.initElements(driver,this);
    }

    // ============================== Page Actions/Methods ===================================== //

    public String getHomePageTitle() {
        String title = driver.getTitle();
        System.out.println("Home Page Title is :: " + title);
        return title;
    }

    public void clickLogoutLink() {
        logoutLink.click();
    }

    public boolean isLogoutLinkDisplayed() {
       return logoutLink.isDisplayed();
    }

    public void clickLoginLink() {
        loginLink.click();
    }


}
