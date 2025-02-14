package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PurchaseTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get("https://automaticityacademy.ngrok.app/");
    }

    @Test
    public void purchaseItem() {
        previewPage.clickOnLoginButton();
        loginPage.inputEmail("sonja.kesic96@gmail.com");
        loginPage.inputPassword("sifra123");
        loginPage.getSignInButton().click();
        dashboardPage.cartItemIcon().click();
        dashboardPage.cartIcon().click();
        dashboardPage.checkoutButton().click();
        checkoutPage.nextStepButton().click();
        checkoutPage.nextStepButton2().click();
        checkoutPage.nextStepButton3().click();
        checkoutPage.placeYourOrderButton().click();

        verifyDashboardPage();
    }

    public void verifyDashboardPage() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://automaticityacademy.ngrok.app/dashboard");
    }
}
