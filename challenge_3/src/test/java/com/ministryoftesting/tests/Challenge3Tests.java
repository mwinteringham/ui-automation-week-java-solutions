package com.ministryoftesting.tests;

import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.selenium.Eyes;
import com.ministryoftesting.pageobjects.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

//    Welcome to UI Automation Challenge 3
//
//    For this challenge the focus is improving the assertion for an existing
//    UI automation test. Rather than asserting on the DOM's state, update the
//    the test below to do a visual check of the page. Once you've completed
//    the sample check. Create your own example check.

public class Challenge3Tests {

    WebDriver driver;

    @Before
    public void buildDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void checkTheHomePageData(){
        Eyes eyes = new Eyes();

        eyes.setApiKey(System.getenv("APPLITOOLS_API_KEY"));

        eyes.open(driver, "RBP","Home Visual Test", new RectangleSize(1400, 700));
        eyes.setForceFullPageScreenshot(true);

        driver.navigate().to("https://automationintesting.online/");

        eyes.checkWindow("Home state");
    }

}
