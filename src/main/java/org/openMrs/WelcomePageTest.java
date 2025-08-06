package org.openMrs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WelcomePageTest {
    public static void main(String[] args) {
        System.out.println("Hello World....");
        // Set the system property for the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "src/main/resources/Driver/CD139v.exe"); // Example path for Windows

        // Initialize the ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Perform automation tasks
        driver.get("https://demoqa.com/");

        String act_Title = driver.getTitle();
        System.out.printf(act_Title);

        String expectedTitle= "DEMOQA";
        if(act_Title.equals(expectedTitle)) {
            System.out.println("Test script passed");
        }else {
            System.out.println("Test script failed");
        }
        driver.close();
    }
}
