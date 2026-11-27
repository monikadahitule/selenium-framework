package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductPage {
    private final WebDriver driver;

    private final By productNames = By.className("inventory_item_name");
    private final By cartBadge = By.className("shopping_cart_badge");

    public ProductPage(WebDriver driver){
        this.driver = driver;
    }
    public List<String> getProductNames(){
        List<String> nameList = driver.findElements(productNames).stream().map(WebElement::getText).toList();
        return nameList;
    }
    public  void addToCart(String productName){
        String productId = "add-to-cart-" + productName.toLowerCase().replace(" ","-");
        driver.findElement(By.id(productId)).click();

    }
    public  int getCartCount(){
        List<WebElement> badges = driver.findElements(cartBadge);
        if(badges.isEmpty()){
            return 0;
        }
        return Integer.parseInt(badges.get(0).getText());
    }
}
