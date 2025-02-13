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

    //----------------------

    public void clickOnLoginButton() {
        getLoginButton().click();
    }
}
