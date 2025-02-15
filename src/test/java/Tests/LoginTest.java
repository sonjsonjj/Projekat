package Tests;

import Base.BaseTest;
import Pages.PreviewPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get("https://automaticityacademy.ngrok.app/");
    }

    @Test
    public void loginWithValidCredentials() {
        previewPage.clickOnLoginButton();
        loginPage.inputEmail("sonja.kesic96@gmail.com");
        loginPage.inputPassword("sifra123");
        loginPage.clickSignInButton();

        Assert.assertTrue(dashboardPage.getDashboardButton().isDisplayed(), "Dashboard button not displayed after login");
    }

    @Test
    public void loginWithInvalidEmail() {
        previewPage.clickOnLoginButton();
        loginPage.inputEmail("invalid");
        loginPage.inputPassword("sifra123");
        loginPage.clickSignInButton();

        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p.text-sm.text-red-600")));

        Assert.assertTrue(errorMessage.isDisplayed());
    }

    @Test
    public void loginWithInvalidPassword() {
        previewPage.clickOnLoginButton();
        loginPage.inputEmail("sonja.kesic96@gmail.com");
        loginPage.inputPassword("invalid");
        loginPage.clickSignInButton();

        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p.text-sm.text-red-600")));

        Assert.assertTrue(errorMessage.isDisplayed());
    }

    @Test
    public void loginWithInvalidCredentials() {
        previewPage.clickOnLoginButton();
        loginPage.inputEmail("invalid@gmail.com");
        loginPage.inputPassword("invalid");
        loginPage.clickSignInButton();

        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p.text-sm.text-red-600")));

        Assert.assertTrue(errorMessage.isDisplayed());
    }

    @Test
    public void loginWithoutEmail() {
        previewPage.clickOnLoginButton();
        loginPage.inputPassword("sifra123");
        loginPage.clickSignInButton();

        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".text-sm.text-red-600")));

        Assert.assertTrue(errorMessage.isDisplayed());
    }

    @Test
    public void loginWithoutPassword() {
        previewPage.clickOnLoginButton();
        loginPage.inputEmail("sonja.kesic96@gmail.com");
        loginPage.clickSignInButton();

        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".text-sm.text-red-600")));

        Assert.assertTrue(errorMessage.isDisplayed());
    }

}