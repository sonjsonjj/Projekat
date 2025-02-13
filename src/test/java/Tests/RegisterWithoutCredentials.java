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

public class RegisterWithoutCredentials {

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

        // Click Register Button without filling out the fields
        registerButton1.click();

        // Wait for the error messages to appear
        WebElement usernameErrorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='The username field is required.']")));
        WebElement emailErrorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='The email field is required.']")));
        WebElement passwordErrorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='The password field is required.']")));

        // Assert that the error messages are displayed
        Assert.assertTrue(usernameErrorMessage.isDisplayed(), "Username error message is not displayed!");
        Assert.assertTrue(emailErrorMessage.isDisplayed(), "Email error message is not displayed!");
        Assert.assertTrue(passwordErrorMessage.isDisplayed(), "Password error message is not displayed!");

        // Assert the text of the error messages
        Assert.assertEquals(usernameErrorMessage.getText(), "The username field is required.", "Username error message text does not match!");
        Assert.assertEquals(emailErrorMessage.getText(), "The email field is required.", "Email error message text does not match!");
        Assert.assertEquals(passwordErrorMessage.getText(), "The password field is required.", "Password error message text does not match!");

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