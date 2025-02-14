package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {

    WebDriver driver;
    WebDriverWait wait;
    WebElement dashboardButton;

    public DashboardPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public WebElement getDashboardButton() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Dashboard")));
    }

    public WebElement cartItemIcon() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.p-button")));
    }

    public WebElement cartIcon() {
        return  wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("svg.w-8.h-12")));
    }

    public WebElement checkoutButton() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[aria-label='Checkout']")));
    }
}