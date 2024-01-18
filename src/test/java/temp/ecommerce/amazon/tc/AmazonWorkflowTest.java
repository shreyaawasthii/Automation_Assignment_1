package temp.ecommerce.amazon.tc;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import temp.ecommerce.amazon.po.*;
import temp.ecommerce.amazon.util.BrowserManager;

public class AmazonWorkflowTest {

    private WebDriver driver;
    private HomePage homePage;
    private ProductPage productPage;
    private AddToCart addToCartPage;
    private CheckoutPage checkoutPage;

    @BeforeClass
    public void setup() {
        driver = BrowserManager.getDriver("chrome", "https://www.amazon.in/");
        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }

    @Test(priority = 0)
    public void testAmazonWorkflow() {
        homePage.searchForProduct("boat headphones");
        Assert.assertTrue(productPage.clickOnFirstItem());
        Assert.assertTrue(productPage.isColorButtonPresent());
        Assert.assertTrue(productPage.clickOnColorButton());
        //productPage.assertClickOnColorButton();
        Assert.assertTrue(productPage.addToCart());
        Assert.assertTrue(checkoutPage.proceedToCheckout());
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}