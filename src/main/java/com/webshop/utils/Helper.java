package com.webshop.utils;


import com.webshop.base.DriverScript;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class Helper extends DriverScript {

    /*
     * This method will capture the screenshot and return the path of the screenshot
     */
    public static String captureScreen(WebDriver driver)
    {
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String screenPath = "D:/WORKSPACE/BATCH35AUTO/com.qa.webshop/src/test/resources/testreport/screenshots/screen.png";
        try {
            FileHandler.copy(src, new File(screenPath));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return screenPath;
    }

}
// "./testreport/screenshots/screen_"+System.currentTimeMillis()+".png";