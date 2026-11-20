package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownPractice {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        try{
            driver.get("https://the-internet.herokuapp.com/dropdown");
            WebElement dropdownElement = driver.findElement(By.id("dropdown"));
            Select dropdown = new Select(dropdownElement);

            dropdown.selectByVisibleText("Option 2");
            System.out.println(dropdown.getFirstSelectedOption().getText());

            dropdown.selectByValue("1");
            System.out.println(dropdown.getFirstSelectedOption().getText());

            dropdown.selectByIndex(2);
            System.out.println(dropdown.getFirstSelectedOption().getText());

            dropdown.getOptions().stream().map(WebElement::getText).forEach(System.out::println);

        }finally {
            driver.quit();
        }
    }
}
