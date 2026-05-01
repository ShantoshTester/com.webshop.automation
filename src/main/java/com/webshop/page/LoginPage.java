package com.webshop.page;

import com.webshop.base.DriverScript;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends DriverScript {

    // ============================== Page Elements ========================================== //

    @FindBy(id="Email") private WebElement emailTextBox;
    @FindBy(name="Password") private WebElement passwordTextBox;
    @FindBy(xpath="//input[@class='button-1 login-button']") private WebElement loginButton;
    @FindBy(linkText = "Forgot password?") private WebElement forgotPasswordLink;
    @FindBy(id = "RememberMe") private WebElement rememberMeCheckBox;
    @FindBy(xpath = "//span[contains(text(),'Please correct the errors and try again')]")
    private WebElement loginErrorMessage;

    // ============================== Page Initialization ===================================== //

    // PageFactory is a class provided by Selenium which supports the Page Object pattern.
    // It is used to initialize the elements of the Page Object or instantiate the Page Objects itself.
    public LoginPage() {
        PageFactory.initElements(driver,this);
    }

    // ============================== Page Actions/Methods ===================================== //

    public void doLogin(String email, String password) {
        enterEmailID(email);
        enterPassword(password);
        clickLoginButton();
    }

    public String getLoginErrorMessage() {
        String errorMessage = loginErrorMessage.getText();
        System.out.println("Login Error Message is :: " + errorMessage);
        return errorMessage;
    }

    public String getLoginPageTitle() {
        String title = driver.getTitle();
        System.out.println("Login Page Title is :: " + title);
        return title;
    }

    public void enterEmailID(String email) {
        emailTextBox.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordTextBox.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public boolean isForgotPasswordLinkDisplayed() {
        return forgotPasswordLink.isDisplayed();
    }

    public boolean isRememberMeCheckBoxSelected() {
        return rememberMeCheckBox.isSelected();
    }






}
