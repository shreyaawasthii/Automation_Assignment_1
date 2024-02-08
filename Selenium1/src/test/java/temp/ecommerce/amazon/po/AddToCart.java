package temp.ecommerce.amazon.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddToCart extends BasePage {

    @FindBy(xpath = "//input[@id='add-to-cart-button' and @name='submit.add-to-cart']")
    private WebElement addToCartButton;

    public AddToCart(WebDriver driver) {
        super(driver);
    }

    public void addToCart() {
        addToCartButton.click();
    }
}