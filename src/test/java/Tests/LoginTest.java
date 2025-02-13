package Tests;

import Base.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get("https://automaticityacademy.ngrok.app/");
    }

    @Test
    public void loginWithValidCredentials() {


    }
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

        // Enter credentials and submit the login form
        emailField.sendKeys("sonjaaa.kesic96@gmail.com");
        passwordField.sendKeys("sifra123");
        signInButton.click();

        // Wait for the page to navigate to the dashboard URL
        wait.until(ExpectedConditions.urlToBe("https://automaticityacademy.ngrok.app/dashboard"));

        // Assert the current URL after login
        String currentUrl = driver.getCurrentUrl();

        // Assert that the current URL matches the expected URL after login
        Assert.assertEquals(currentUrl, "https://automaticityacademy.ngrok.app/dashboard");

        // Close the driver after the test
        driver.quit();
    }
}