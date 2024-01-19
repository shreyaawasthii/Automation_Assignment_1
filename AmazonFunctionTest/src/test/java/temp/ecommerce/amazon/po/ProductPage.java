package temp.ecommerce.amazon.po;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

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

    public boolean clickOnFirstItem() {
        System.out.println("first item clicked");
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", firstItem);
            firstItem.click();
            return true;  // Return true if the click is successful
        } catch (Exception e) {
            e.printStackTrace();
            return false;  // Return false if the click fails
        }
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
               // return element.getSize().getHeight() > 0 && element.getSize().getWidth() > 0;
                System.out.println("Element found");
                return true;
            }
            return false;
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            return false;
        }
    }

    public void assertIsColorButtonPresent() {
        boolean isColorButtonPresent = isColorButtonPresent();
        Assert.assertTrue(isColorButtonPresent, "Color button is not present.");
    }

    public boolean clickOnColorButton() {
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", colorButton);
            colorButton.click();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void assertClickOnColorButton() {
        //Assert.assertTrue(clickOnColorButton(), "Color button is not clicked.");
    }

    private void scrollIntoView(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        System.out.println("Scroll into view entered");
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        System.out.println(driver.getWindowHandles());
        // Get the handles of all open tabs or windows
        String currentWindowHandle = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(currentWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
       // driver.switchTo().window()
       /* js.executeScript("arguments[0].scrollIntoView(true);", element);
        System.out.println("Scrolling done");*/
    }

    public boolean addToCart() {
        try {
            System.out.println("cart");
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", addToCartButton);

            if (addToCartButton.isEnabled() && addToCartButton.isDisplayed()) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToCartButton);
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

}
