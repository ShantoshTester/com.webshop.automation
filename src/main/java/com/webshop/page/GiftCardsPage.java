package com.webshop.page;

import com.webshop.base.DriverScript;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GiftCardsPage extends DriverScript  {

    // ============================== Page Elements ========================================== //

    @FindBy(xpath = "//h1[text()='Gift Cards']") private WebElement giftCardsHeader;
    @FindBy(xpath="//div[@class='product-grid']/div") private List<WebElement> giftCardsCount;

    // ============================== Page Initialization ===================================== //

    public GiftCardsPage() {
        PageFactory.initElements(driver,this);
    }

    // ============================== Page Actions/Methods ===================================== //

    public int getGiftCardsCount() {
        int count = giftCardsCount.size();
        System.out.println("Total Gift Cards are :: " + count);
        return count;
    }

    public String getGiftCardsPageHeader() {
        String header = giftCardsHeader.getText();
        System.out.println("Gift Cards Page Header is :: " + header);
        return header;
    }
}
