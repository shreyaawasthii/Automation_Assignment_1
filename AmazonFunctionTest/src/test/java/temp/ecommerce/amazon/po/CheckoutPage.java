package temp.ecommerce.amazon.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {

    @FindBy(xpath = "//input[@aria-labelledby='attach-sidesheet-checkout-button-announce']")
    private WebElement proceedToCheckoutButton;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void proceedToCheckout() {
        proceedToCheckoutButton.click();
    }

    public void assertProceedToCheckout() {
        proceedToCheckout();
    }
}