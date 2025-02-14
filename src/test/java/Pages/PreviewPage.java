package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PreviewPage {

    WebDriver driver;
    WebElement loginButton;

    public PreviewPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getLoginButton() {
        return driver.findElement(By.id("loginBtn"));
    }

    public WebElement getRegisterButton() {
        return driver.findElement(By.linkText("Register"));
    }

    //----------------------

    public void clickOnLoginButton() {
        getLoginButton().click();
    }

    public void clickOnRegisterButton() {
        getRegisterButton().click();
    }
}
