package org.openMrs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WelcomePageTest {
    public static void main(String[] args) {
        System.out.println("Hello World....");
        // Set the system property for the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "src/main/resources/Driver/CD139v.exe"); // Example path for Windows

        // Initialize the ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Perform automation tasks
        driver.get("https://www.google.com");
        System.out.println("Page title: " + driver.getTitle());

        // Close the browser
        driver.quit();
    }
}
