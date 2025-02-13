package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterWithValidCredentials {
    public static void main(String[] args) {

        // Setup WebDriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Open the website
        driver.get("https://automaticityacademy.ngrok.app/");

        // Initialize WebDriverWait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Click the Register button & wait for the new page
        WebElement registerButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("a[href='https://automaticityacademy.ngrok.app/register']")));
        registerButton.click();

        // Wait until URL changes to the register page
        wait.until(ExpectedConditions.urlContains("/register"));

        // Wait for Input Fields to be visible before interacting
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        WebElement registerButton1 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[aria-label='Register']")));

        // Enter Credentials
        usernameField.sendKeys("sonjaaaa");
        emailField.sendKeys("sonjaaaa.kesic96@gmail.com");
        passwordField.sendKeys("sifra123");

        // Click Register Button
        registerButton1.click();

        // Optionally, wait for a confirmation element to appear or check the URL
        // For example:
        // WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("confirmationMessageId")));
        // Assert.assertTrue(confirmationMessage.isDisplayed());

        // Adding a wait to ensure the page is loaded before closing the browser
        try {
            Thread.sleep(2000); // Wait for 2 seconds to see the result of the registration
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Close the browser
        driver.quit();
    }
}