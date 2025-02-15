package Tests;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get("https://automaticityacademy.ngrok.app/");
    }

    @Test
    public void registerWithValidCredentials() {
        previewPage.clickOnRegisterButton();
        registerPage.inputUsername("sonjasaaaaaa");
        registerPage.inputEmail("sonjaaas96@gmail.com");
        registerPage.inputPassword("sssifra12345");
        registerPage.clickOnRegisterButton();

        wait.until(ExpectedConditions.urlToBe("https://automaticityacademy.ngrok.app/dashboard"));
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(actualUrl, "https://automaticityacademy.ngrok.app/dashboard");
    }

    @Test
    public void registerWithInvalidEmail() {
        previewPage.clickOnRegisterButton();
        registerPage.inputUsername("s");
        registerPage.inputEmail("invalid");
        registerPage.inputPassword("password");
        registerPage.clickOnRegisterButton();

        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p.text-sm.text-red-600")));

        Assert.assertTrue(errorMessage.isDisplayed());
    }

    @Test
    public void registerWithInvalidPassword() {
        previewPage.clickOnRegisterButton();
        registerPage.inputUsername("so");
        registerPage.inputEmail("sonjaa@gmail.com");
        registerPage.inputPassword("1");
        registerPage.clickOnRegisterButton();

        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p.text-sm.text-red-600")));

        Assert.assertTrue(errorMessage.isDisplayed());
    }
}
