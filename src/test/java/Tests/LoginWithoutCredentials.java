package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginWithoutCredentials {
    public static void main(String[] args) {

        // Setup WebDriver
        WebDriverManager.chromedriver().driverVersion("132.0.6834.159").setup();  // Ensuring ChromeDriver version compatibility
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Open the website
        driver.get("https://automaticityacademy.ngrok.app/");

        // Initialize WebDriverWait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Wait for login button to be visible and click
        WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginBtn")));
        loginButton.click();

        // Wait for email and password fields to be visible
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        WebElement signInButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[aria-label='Sign in']")));

        // Click on sign in button without filling out the form
        signInButton.click();

        // Wait for the error message to be visible
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p.text-sm.text-red-600")));

        // Assert that the error message is displayed
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message is not displayed!");

        // Assert the text of the error message
        Assert.assertEquals(errorMessage.getText(), "The email field is required.", "Error message text does not match!");

        // Close the driver after the test
        driver.quit();
    }
}