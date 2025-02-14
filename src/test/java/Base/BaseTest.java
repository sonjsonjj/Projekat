package Base;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;

    public WebDriverWait wait;

    public PreviewPage previewPage;

    public LoginPage loginPage;

    public DashboardPage dashboardPage;

    public RegisterPage registerPage;

    public CheckoutPage checkoutPage;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        previewPage = new PreviewPage(driver);
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver, wait);
        registerPage = new RegisterPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }
}
