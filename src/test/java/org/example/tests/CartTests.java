package org.example.tests;

import org.example.pages.LoginPage;
import org.example.pages.ProductPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartTests {
    private WebDriver driver;
    private ProductPage productpage;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productpage = new ProductPage(driver);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void productsPageShowsSixProducts(){

        Assert.assertEquals(productpage.getProductNames().size(),6,"Product names should be 6 but its showing no "+productpage.getProductNames().size());

    }

    @Test
    public void cartIsEmptyAtStart(){
        Assert.assertEquals(productpage.getCartCount(),0,"Cart count should be 0 at start but got " + productpage.getCartCount());

    }

    @Test
    public void addingOneProductUpdatesCartCount(){
        productpage.addToCart("Sauce Labs Backpack");
        Assert.assertEquals(productpage.getCartCount(),1,"Cart count should be 1 after adding one product");
    }

    @Test
    public void addingTwoProductsUpdatesCartCount(){
        productpage.addToCart("Sauce Labs Backpack");
        productpage.addToCart("Sauce Labs Bike Light");
        Assert.assertEquals(productpage.getCartCount(),2,"Cart count should be 2 after adding 2 products");
    }
}
