package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Scanner;

public class BrowserChooser {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Which browser Chrome/Edge/Firefox");
        String browser = scanner.nextLine().trim().toLowerCase();
        WebDriver driver;

        if (browser.equals("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equals("edge")) {
            driver = new EdgeDriver();
        } else if (browser.equals("firefox")) {
            driver = new FirefoxDriver();
        } else {
            throw new IllegalArgumentException("Unexpected browser : " + browser);
        }
        driver.get("https://www.saucedemo.com");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.quit();


}
}
