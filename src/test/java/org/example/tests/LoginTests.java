package org.example.tests;

import org.example.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests {
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
      driver = new ChromeDriver();
      loginPage = new LoginPage(driver);
      loginPage.open();

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void validLoginOpensProductsPage() {
        // 1. type the username and password, click the login button
        loginPage.login("standard_user","secret_sauce");
        // 2. check the URL
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
    }
    @Test
    public void wrongPasswordShowsError(){
        loginPage.login("standard_user","secret_sauce1");
        String errorText = loginPage.getErrorMessage();
        Assert.assertTrue(errorText.contains("do not match"),"Error message should say the credentials do not match, but it was:" + errorText);
    }

    @Test
    public void emptyUsernameShowsError(){
        loginPage.login("","secret_sauce1");
        String errorText = loginPage.getErrorMessage();
        Assert.assertTrue(errorText.contains("Username is required"),"Error message should say the Username is required, but it was:" + errorText);
    }
}
