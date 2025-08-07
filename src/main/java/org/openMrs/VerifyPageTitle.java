package org.openMrs;
import java.io.File;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.IOException;  // required for handling exceptions

import org.apache.commons.io.FileUtils;  // for copying screenshot files

import java.util.concurrent.TimeUnit;

public class VerifyPageTitle {
    public static void main(String[] args) {
        System.out.println("Hello World....");
        // Set the system property for the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "src/main/resources/Driver/CD139v.exe"); // Example path for Windows

        // Initialize the ChromeDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        try {
            // Perform automation tasks
            driver.get("https://demoqa.com/");

            String act_Title = driver.getTitle();
            System.out.printf(act_Title);

            String expectedTitle = "DEMOQAvvfdsv";
            if (act_Title.equals(expectedTitle)) {
                System.out.println("✅ Title matched: " + act_Title);
                System.out.println("Test case passed");
                takeScreenshot(driver, "title_matched.png");
            } else {
                System.out.println("❌ Title did not match. Actual title: " + act_Title);
                // Take screenshot and store it as a file format
                takeScreenshot(driver, "title_mismatch.png");

                System.out.println("Test case failed");
            }
        } catch (Exception e) {
            System.out.print("Error Occurred : " +e.getMessage());
        }finally {
            // Close the browser..
            driver.quit();
        }

    }
    // Method to take a screenshot
    public static void takeScreenshot(WebDriver driver, String fileName) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File srcFile = ts.getScreenshotAs(OutputType.FILE);
        File destFile = new File(fileName);
        try {
            FileUtils.copyFile(srcFile, destFile);
            System.out.println("📸 Screenshot taken: " + fileName);
        } catch (IOException e) {
            System.out.println("⚠️ Unable to save screenshot: " + e.getMessage());
        }
    }
}
