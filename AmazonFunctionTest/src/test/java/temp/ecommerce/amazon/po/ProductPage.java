package temp.ecommerce.amazon.po;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ProductPage extends BasePage {

    @FindBy(id = "a-autoid-20-announce")
    private WebElement colorButton;

    @FindBy(xpath = "//input[@id='add-to-cart-button' and @name='submit.add-to-cart']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//a[contains(@class, 'a-link-normal') and @href and .//div[@class='a-section aok-relative s-image-fixed-height']//img[@data-image-index='1']]")
    private WebElement firstItem;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnFirstItem() {
        System.out.println("first item clicked");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", firstItem);
        firstItem.click();

    }
    public boolean isColorButtonPresent() {
        // Scroll into view using JavaScript Executor
        scrollIntoView(colorButton);
        System.out.println("Scrolling till color button");
        return isElementVisible(colorButton);
    }

    private boolean isElementVisible(WebElement element) {
        try {
            // Check if the element is present in the DOM
            if (element.isDisplayed()) {
                // Check if the element's size is greater than 0
                return element.getSize().getHeight() > 0 && element.getSize().getWidth() > 0;
            }
            return false;
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            // Handle exceptions if necessary
            return false;
        }
    }

    public void assertIsColorButtonPresent() {
        boolean isColorButtonPresent = isColorButtonPresent();
        Assert.assertTrue(isColorButtonPresent, "Color button is not present.");
    }

    public void clickOnColorButton() {
        System.out.println("click color");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", colorButton);
        colorButton.click();
    }

    /*public void assertClickOnColorButton() {
        clickOnColorButton();
    }*/

    private void scrollIntoView(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        System.out.println("Scroll into view entered");
        // Get the handles of all open tabs or windows
        String currentWindowHandle = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(currentWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        System.out.println("Scrolling done");
    }

    public void addToCart() {
        System.out.println("cart");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", addToCartButton);
        if (addToCartButton.isEnabled() && addToCartButton.isDisplayed()) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToCartButton);
        }
    }

    public void assertAddToCart() {
        addToCart();
    }
}
