package com.ministryoftesting;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.*;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

//    Welcome to UI Automation Challenge 2
//
//    For this challenge it's all about creating clean, readable and maintainable code. Below
//    are five tests that work (just about) but require cleaning up. Update this class so that
//    code base so that it's easier to maintain, more readable and has sensible ways of asserting
//    data. You might want to research different approaches to improving UI automation such as
//    Page Object Models and implicit vs. explicit waits

public class Challenge2Tests {

//  Test one: Check to see if you can log in with valid credentials
    @Test
    public void checkLoginWithValidCredentialsTest(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://automationintesting.online/#/admin");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.populateUsername("admin");
        loginPage.populatePassword("password");
        loginPage.clickLogin();

        RoomListingPage roomListingPage = new RoomListingPage(driver);

        MatcherAssert.assertThat(roomListingPage.roomFormExists(), is(true));
    }

//  Test two: Check to see if rooms are saved and displayed in the UI
    @Test
    public void checkCreatedRoomIsDisplayedTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://automationintesting.online/#/admin");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.populateUsername("admin");
        loginPage.populatePassword("password");
        loginPage.clickLogin();

        RoomListingPage roomListingPage = new RoomListingPage(driver);
        int initialRoomCount = roomListingPage.roomCount();

        roomListingPage.populateRoomNumber("102");
        roomListingPage.setRoomPrice("100");
        roomListingPage.checkWifi();
        roomListingPage.checkSafe();
        roomListingPage.checkRadio();
        roomListingPage.clickCreateRoom();

        int currentRoomCount = roomListingPage.roomCount();
        MatcherAssert.assertThat(currentRoomCount, is(initialRoomCount + 1));
    }

//  Test three: Check to see the confirm message appears when branding is updated
    @Test
    public void checkUpdateBrandingTest(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://automationintesting.online/#/admin");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.populateUsername("admin");
        loginPage.populatePassword("password");
        loginPage.clickLogin();

        driver.get("https://automationintesting.online/#/admin/branding");

        BrandingPage brandingPage = new BrandingPage(driver);
        brandingPage.setName("Test");
        brandingPage.clickUpdate();

        boolean popupIsDisplayed = brandingPage.isPopupDisplayed();

        assertEquals(true, popupIsDisplayed);
    }

//  Test four: Check to see if the contact form shows a success message
    @Test
    public void contactFormTest(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://automationintesting.online");

        HomePage homePage = new HomePage(driver);
        homePage.setContactFormName("TEST123");
        homePage.setContactFormEmail("TEST123@TEST.COM");
        homePage.setContactFormPhone("01212121311");
        homePage.setContactFormSubject("TEsTEST");
        homePage.setContactFormDescription("TEsTESTTEsTESTTEsTEST");
        homePage.clickContactFormSubmit();

        String response = homePage.getResponseText();

        assertEquals(true, response.contains("Thanks for getting in touch"));
}

//  Test five: Check to see if unread messages are bolded
    @Test
    public void checkUnreadMessagesAreBoldTest(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://automationintesting.online/#/admin/messages");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.populateUsername("admin");
        loginPage.populatePassword("password");
        loginPage.clickLogin();

        NavPage navPage = new NavPage(driver);
        navPage.clickNotification();

        MessagePage messagePage = new MessagePage(driver);
        List<WebElement> messages = messagePage.getBoldedMessages();

        assertEquals(true, (messages.size() > 0));
    }

}
