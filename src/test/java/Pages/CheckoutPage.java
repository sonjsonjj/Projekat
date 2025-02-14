package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CheckoutPage {

    WebDriver driver;
    WebDriverWait wait;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Initialize wait properly
    }

    public WebElement nextStepButton() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='p-button-label p-c' and @data-pc-section='label' and contains(text(),'Next step')]")));
    }

    public WebElement nextStepButton2() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Next step']//span[@class='p-button-label p-c' and @data-pc-section='label' and text()='Next step']")));
    }

    public WebElement nextStepButton3() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='p-button-label p-c' and @data-pc-section='label' and text()='Next step']")));
    }

    public WebElement placeYourOrderButton() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Place your order!' and .//span[text()='Place your order!']]")));
    }
}