package com.webshop.page;

import com.webshop.base.DriverScript;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ComputersPage extends DriverScript {

    // ============================== Page Elements ========================================== //

    @FindBy(xpath = "//h1[text()='Computers']") private WebElement computersHeader;
    @FindBy(xpath="//div[@class='item-box']/div") private List<WebElement> computerProductsCount;

    // ============================== Page Initialization ===================================== //

    public ComputersPage() {
        PageFactory.initElements(driver,this);
    }

    // ============================== Page Actions/Methods ===================================== //

    public int getComputersCount() {
        int count = computerProductsCount.size();
        System.out.println("Total Computers are :: " + count);
        return count;
    }

    public String getComputersPageHeader() {
        String header = computersHeader.getText();
        System.out.println("Computers Page Header is :: " + header);
        return header;
    }
}
