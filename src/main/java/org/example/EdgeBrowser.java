package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeBrowser {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.saucedemo.com");
        System.out.println("Title : " + driver.getTitle());
        System.out.println("URL : " +driver.getCurrentUrl());
        driver.quit();
    }
}
