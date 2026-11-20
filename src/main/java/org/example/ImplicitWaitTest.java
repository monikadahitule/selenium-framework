package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ImplicitWaitTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        try{
            driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
            driver.findElement(By.cssSelector("#start>button")).click();
            WebElement finish = driver.findElement(By.id("finish"));
            System.out.println(finish.getText());

        }finally {
            driver.quit();
        }
    }
}
