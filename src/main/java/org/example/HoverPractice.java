package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class HoverPractice {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://the-internet.herokuapp.com/hovers");
            List<WebElement> figures = driver.findElements(By.className("figure"));
            Actions actions = new Actions(driver);

            for (WebElement figure : figures) {
                actions.moveToElement(figure).perform();
                WebElement name = figure.findElement(By.tagName("h5"));
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                wait.until(ExpectedConditions.visibilityOf(name));
                System.out.println(name.getText());
            }
        } finally {
            driver.quit();
        }

    }
}
