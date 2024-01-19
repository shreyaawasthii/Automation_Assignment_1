import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Test1 {

    public static ChromeOptions options;
    public static WebDriver driver;

    @BeforeTest
    void Setup() throws InterruptedException {
        options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/test/resources/chromedriver-linux64/chromedriver");
        //System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        //driver = new ChromeDriver();
        driver = new ChromeDriver(options);
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        assert driver.getTitle().contains("Amazon") : "Site launch verification failed";
        searchInSearchBar(driver, "boat headphone");
        clickOnFirstItem(driver);
        clickOnColor(driver);
        addToCart(driver);
        proceedToCheckout(driver);
    }

    @Test(priority = 0)

    public static void searchInSearchBar(WebDriver driver, String searchTerm) {
        try {
            // Find the search bar element by its locator (modify as per your HTML structure)
            WebElement searchBar = driver.findElement(By.id("twotabsearchtextbox"));

            // Click on the search bar to activate it
            searchBar.click();

            // Type the search term into the search bar
            searchBar.sendKeys(searchTerm);

            // Simulate pressing the "Enter" key
            searchBar.sendKeys(Keys.ENTER);
        } catch (Exception e) {
            // Handle any exceptions that may occur
            e.printStackTrace();
        }
        // Assertion: Check whether it has landed on the correct page
       // Assert.assertTrue(driver.getTitle().contains("boat headphone"));
    }

    @Test(priority = 1)
    public static void clickOnFirstItem(WebDriver driver) throws InterruptedException {

        // Locate the first item in the search results and click on "colours/patterns"
        WebElement firstItem = driver.findElement(By.xpath("//a[contains(@class, 'a-link-normal') and @href and .//div[@class='a-section aok-relative s-image-fixed-height']//img[@data-image-index='1']]"));
        System.out.println("1");
        firstItem.click();

    }

    @Test(priority = 2)
    public static void clickOnColor(WebDriver driver) throws InterruptedException{
        // Switch to the new window or tab (assuming it's the second window/tab, change index accordingly)
        String parentWindowHandle = driver.getWindowHandle();
        System.out.println(parentWindowHandle);
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(parentWindowHandle)) {
                System.out.println("Check if current window handle equals current window handle: "+                         windowHandle.equals(parentWindowHandle));
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        // Check if the color button is present
        boolean isColorButtonPresent = false;

        try {
            // Wait for the "color" button to be clickable
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement colorButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("a-autoid-20-announce")));

            // Scroll into view
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView();", colorButton);

            // Set the flag to true if the color button is present
            isColorButtonPresent = true;

            // Click on the "color" button
            colorButton.click();
        } catch (Exception e) {
            // Handle the exception or log it (e.g., button not found)
            e.printStackTrace();
        }

    }

    @Test(priority = 3)
    public static void addToCart(WebDriver driver) {
        try {
             /*
            // Switch to the new window or tab (assuming it's the second window/tab, change index accordingly)
            String parentWindowHandle = driver.getWindowHandle();
            for (String windowHandle : driver.getWindowHandles()) {
                if (!windowHandle.equals(parentWindowHandle)) {
                    driver.switchTo().window(windowHandle);
                    break;
                }
            }
            */

            System.out.println("2");
            // Wait for the element to be present (you may need to use WebDriverWait for better handling)
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            //wait.until(ExpectedConditions.urlContains("https://www.amazon.in/boAt-Rockerz-255-Max-Bluetooth/dp/B0CGZP6P8Z/ref=sr_1_1_sspa?keywords=boat%2Bheadphone&qid=1705492780&sr=8-1-spons&sp_csd=d2lkZ2V0TmFtZT1zcF9hdGY&th=1")); // Update with the expected URL or identifier
            WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='add-to-cart-button' and @name='submit.add-to-cart']")));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView();", addToCartButton);
            System.out.println("3");
            if (addToCartButton.isEnabled() && addToCartButton.isDisplayed()) {
                js.executeScript("arguments[0].click();", addToCartButton);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Assertion: Check whether the item has been added or not
        //assert driver.findElement(By.xpath("//input[@id='add-to-cart-button' and @name='submit.add-to-cart']")).getText().equals("1") : "Add to Cart verification failed";
    }

    @Test(priority = 4)
    public void proceedToCheckout(WebDriver driver) {
        try {
            System.out.println("4");
            /*
            // Switch to the new window or tab (assuming it's the second window/tab, change index accordingly)
            String parentWindowHandle = driver.getWindowHandle();
            for (String windowHandle : driver.getWindowHandles()) {
                if (!windowHandle.equals(parentWindowHandle)) {
                    driver.switchTo().window(windowHandle);
                    break;
                }
            }
            */
            // Wait for the pop-up to appear (you may need to adjust the timeout)
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Change the timeout duration as needed
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@aria-labelledby='attach-sidesheet-checkout-button-announce']"))); // Replace 'your-popup-class' with the actual class of the pop-up

            // Locate the "Proceed to Buy" button
        WebElement proceedToCheckoutButton = driver.findElement(By.xpath("//input[@aria-labelledby='attach-sidesheet-checkout-button-announce']"));
            wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckoutButton));
            System.out.println("5");
        proceedToCheckoutButton.click();
        } catch (Exception e) {
            e.printStackTrace();
        }

           // assert !driver.getCurrentUrl().equals("your_original_url") : "Proceed to Buy verification failed";
        }
    }

