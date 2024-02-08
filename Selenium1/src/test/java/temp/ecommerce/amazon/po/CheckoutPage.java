package temp.ecommerce.amazon.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {

    @FindBy(xpath = "//input[@aria-labelledby='attach-sidesheet-checkout-button-announce']")
    private WebElement proceedToCheckoutButton;

    @FindBy(id = "proceed-to-checkout-action")
    private WebElement checkoutButton;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public boolean proceedToCheckout() {
        try {
            proceedToCheckoutButton.click();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }


}