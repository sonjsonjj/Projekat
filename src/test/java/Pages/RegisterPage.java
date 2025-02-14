package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {

    WebDriver driver;
    WebDriverWait wait;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement getUsernameField() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
    }

    public WebElement getEmailField()  {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
    }

    public WebElement getPasswordField() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
    }

    public WebElement getRegisterButton() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[aria-label='Register']")));
    }

    //---------------------------

    public void inputUsername(String username) {
        getUsernameField().clear();
        getUsernameField().sendKeys(username);
    }

    public void inputEmail(String email) {
        getEmailField().clear();
        getEmailField().sendKeys(email);
    }

    public void inputPassword(String password) {
        getPasswordField().clear();
        getPasswordField().sendKeys(password);
    }

    public void clickOnRegisterButton() {
        getRegisterButton().click();
    }
}
