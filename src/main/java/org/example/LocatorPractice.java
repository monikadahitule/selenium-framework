package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LocatorPractice {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.password_manager_leak_detection", false);
        options.addArguments("--start-maximized");
        options.setExperimentalOption("prefs", prefs);

        WebDriver driver = new ChromeDriver(options);
        try {
            driver.get("https://www.saucedemo.com/");
            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();
            List<WebElement> elementList = driver.findElements(By.className("inventory_item_name"));
            System.out.println("Size : " + elementList.size());

            elementList.stream().map(WebElement::getText).forEach(System.out::println);
            List<String> names = elementList.stream().map(WebElement::getText).toList();
            System.out.println(names);

            elementList.stream().map(WebElement::getText).filter(s -> s.toLowerCase().contains("t-shirt")).forEach(System.out::println);
            names.stream().filter(s -> s.toLowerCase().contains("t-shirt")).forEach(System.out::println);

            System.out.println(elementList.stream().map(WebElement::getText).filter(s -> s.toLowerCase().contains("t-shirt")).count());
            System.out.println(elementList.stream().map(w -> w.getText()).anyMatch(s -> s.equals("Sauce Labs Backpack")));


            //prints the name sorted
            elementList.stream().map(WebElement::getText).sorted().forEach(System.out::println);

            //Add the Sauce Labs Backpack to the cart.
            //driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
            //or
            driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();


            String badge = driver.findElement(By.cssSelector(".shopping_cart_badge")).getText();
            System.out.println("Badge value :" + badge);

            String productName = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).getText();
            System.out.println("Product name :" + productName);

            System.out.println("find element with xpath partial string :" + driver.findElement(By.xpath("//div[contains(text(),'Backpack')]")).getText());
        }

        finally {
            driver.quit();
        }

    }
}
