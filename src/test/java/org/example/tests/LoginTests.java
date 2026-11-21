package org.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
      driver = new ChromeDriver();
      driver.get("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void validLoginOpensProductsPage() {
        // 1. type the username and password, click the login button
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // 2. check the URL (see the assertion below)
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
    }
    @Test
    public void wrongPasswordShowsError(){
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce1");
        driver.findElement(By.id("login-button")).click();
        String errorText = driver.findElement(By.className("error-message-container")).getText();
        Assert.assertTrue(errorText.contains("do not match"),"Error message should say the credentials do not match, but it was:" + errorText);


    }
}
