package com.selenium.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class MyAccountPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://magento.softwaretestingboard.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void SignIn() {
        By signInLocator = By.xpath("//div[@class='panel header']//a[contains(text(),'Sign In')]");
        WebElement createAccountLink = wait.until(ExpectedConditions.elementToBeClickable(signInLocator));
        createAccountLink.click();
        System.out.println("sign in clicked");

        By email = By.cssSelector("#email");
        wait.until(ExpectedConditions.visibilityOfElementLocated(email));
        System.out.println("email found");
        fillFormField("#email", "shiksha@gmail.com");
        System.out.println("email filled");


        By password = By.cssSelector("#pass");
        wait.until(ExpectedConditions.visibilityOfElementLocated(password));
        System.out.println("password found");
        fillFormField("#pass", "admin@1234");
        System.out.println("password filled");

        // Click on the "Create Account" button
        WebElement createAccountButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#send2")));
        createAccountButton.click();
        System.out.println("SignIn Button Clicked");

    }

    @Test(priority = 1)
    public void navigateToMyAccount() {

        By dropdownButtonLocator = By.xpath("(//button[@class='action switch'])[1]");
        WebElement dropdownButton = wait.until(ExpectedConditions.elementToBeClickable(dropdownButtonLocator));
        System.out.println("My Account button found");
        dropdownButton.click();
        System.out.println("Dropdown button clicked");

        // Select "My Account" from the dropdown
        By myAccountLocator = By.xpath("//li[@class='customer-welcome active']//a[contains(text(),'My Account')]");
        WebElement myAccountLink = wait.until(ExpectedConditions.elementToBeClickable(myAccountLocator));
        myAccountLink.click();
        System.out.println("My Account link clicked");


    }

//    @Test(priority = 2)
//    public void addShippingAddress() {
//        By addressBookLocator = By.xpath("//a[contains(text(), 'Address Book')]");
//        WebElement addressBookLink = wait.until(ExpectedConditions.elementToBeClickable(addressBookLocator));
//        addressBookLink.click();
//
//        // Fill in the telephone number
//        WebElement telephoneField = driver.findElement(By.cssSelector("#telephone"));
//        telephoneField.click();
//        telephoneField.sendKeys("9876543210");
//        System.out.println("Telephone number filled");
//
//        By Address1 = By.cssSelector("#street_1");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(Address1));
//        System.out.println("Street 1 found");
//        fillFormField("#street_1", "13B");
//
//        By Address2 = By.cssSelector("#street_2");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(Address2));
//        System.out.println("Street 2 found");
//        fillFormField("#street_2", "Flex Appartments");
//
//        By Address3 = By.cssSelector("#street_3");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(Address3));
//        System.out.println("Street 3 found");
//        fillFormField("#street_3", "Sector 59");
//
//        // Select country
//        WebElement countrySelect = driver.findElement(By.cssSelector("#country"));
//        countrySelect.click();
//        WebElement indiaOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//option[@value='IN' and text()='India']")));
//        indiaOption.click();
//        System.out.println("Country selected");
//
//        // Select region (Delhi)
//        WebElement regionSelect = driver.findElement(By.cssSelector("#region_id"));
//        regionSelect.click();
//        WebElement delhiOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//option[@value='542' and text()='Delhi']")));
//        delhiOption.click();
//        System.out.println("Region (Delhi) selected");
//
//        // Fill in the city
//        fillFormField("#city", "Delhi");
//
//        By zipCode = By.cssSelector("#zip");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(zipCode));
//        System.out.println("Street 2 found");
//        fillFormField("#zip", "201301");
//
//        // Click on Save Address button
//        WebElement saveAddressButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.action.save.primary")));
//        saveAddressButton.click();
//        System.out.println("Save Address button clicked");
//        waitAfterFieldFill();
//
//    }
//
//    @Test(priority = 3)
//    public void clickAddAddress() {
//        By addressBookLocator = By.xpath("//a[contains(text(), 'Address Book')]");
//        WebElement addressBookLink = wait.until(ExpectedConditions.elementToBeClickable(addressBookLocator));
//        addressBookLink.click();
//
//        By addAddressLocator = By.xpath("//button[@type='button' and @role='add-address' and @title='Add New Address' and contains(@class, 'add')]");
//        WebElement addAddress = wait.until(ExpectedConditions.elementToBeClickable(addAddressLocator));
//        addAddress.click();
//
//        WebElement telephoneField = driver.findElement(By.cssSelector("#telephone"));
//        telephoneField.click();
//        telephoneField.sendKeys("9876543210");
//        System.out.println("Telephone number filled");
//
//        By Address1 = By.cssSelector("#street_1");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(Address1));
//        System.out.println("Street 1 found");
//        fillFormField("#street_1", "108/201");
//
//        By Address2 = By.cssSelector("#street_2");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(Address2));
//        System.out.println("Street 2 found");
//        fillFormField("#street_2", "Shanti Appartments");
//
//        By Address3 = By.cssSelector("#street_3");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(Address3));
//        System.out.println("Street 3 found");
//        fillFormField("#street_3", "Vikas Nagar");
//
//        // Select country
//        WebElement countrySelect = driver.findElement(By.cssSelector("#country"));
//        countrySelect.click();
//        WebElement indiaOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//option[@value='IN' and text()='India']")));
//        indiaOption.click();
//        System.out.println("Country selected");
//
//        // Select region (Delhi)
//        WebElement regionSelect = driver.findElement(By.cssSelector("#region_id"));
//        regionSelect.click();
//        WebElement UPOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//option[@value='566' and text()='Uttar Pradesh']")));
//        UPOption.click();
//        System.out.println("Region (UP) selected");
//
//        By city = By.cssSelector("#city");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(city));
//        fillFormField("#city", "Kanpur");
//
//        By zipCode = By.cssSelector("#zip");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(zipCode));
//        System.out.println("Street 2 found");
//        fillFormField("#zip", "208012");
//
//        // Click on Save Address button
//        WebElement saveAddressButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.action.save.primary")));
//        saveAddressButton.click();
//        System.out.println("Save Address button clicked");
//        waitAfterFieldFill();
//    }
//
//    @Test(priority = 4)
//    public void changeBillingAddress() {
//
//        By changeBillingAddressLocator = By.cssSelector("div.box-address-billing a.action.edit");
//        WebElement changeAddress = wait.until(ExpectedConditions.elementToBeClickable(changeBillingAddressLocator));
//        changeAddress.click();
//
//        By city = By.cssSelector("#city");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(city));
//        fillFormField("#city", "Gurugram");
//
//        By zipCode = By.cssSelector("#zip");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(zipCode));
//        System.out.println("Street 2 found");
//        fillFormField("#zip", "122015");
//
//        WebElement saveAddressButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.action.save.primary")));
//        saveAddressButton.click();
//        System.out.println("Save Address button clicked");
//        waitAfterFieldFill();
//   }


    @Test(priority = 5)
    public void wishlist() {

        By WomenSectionLocator = By.id("ui-id-4");
        WebElement WomenSection = wait.until(ExpectedConditions.elementToBeClickable(WomenSectionLocator));
        WomenSection.click();

        By fistItemLocator = By.xpath("(//ol[@class='product-items widget-product-grid']//div[@class='product-item-info'])[1]");
        WebElement firstItem = wait.until(ExpectedConditions.elementToBeClickable(fistItemLocator));

        Actions actions = new Actions(driver);
        actions.moveToElement(firstItem).perform();
        System.out.println("hover performed on first item for wishlist");

        By addToWishlistLocator = By.xpath("(//div[@class='actions-secondary']/a[@title='Add to Wish List'])[1]");
        WebElement addToWhishlist = wait.until(ExpectedConditions.elementToBeClickable(addToWishlistLocator));
        addToWhishlist.click();
        System.out.println("First Item added to wishlist");

        System.out.println("Waiting for women section to get opened");
        WomenSection =wait.until(ExpectedConditions.elementToBeClickable(WomenSectionLocator));
        System.out.println("Found women section 2nd time");
        WomenSection.click();
        System.out.println("women section 2nd time clicked");

        By secondItemLocator = By.xpath("(//ol[@class='product-items widget-product-grid']//div[@class='product-item-info'])[2]");
        WebElement secondItem = wait.until(ExpectedConditions.elementToBeClickable(secondItemLocator));

        actions.moveToElement(secondItem).perform();
        System.out.println("hover performed on second item for wishlist");

        By addToWishlistLocator2 = By.xpath("(//div[@class='actions-secondary']/a[@title='Add to Wish List'])[2]");
        WebElement addToWishlist2 =wait.until(ExpectedConditions.elementToBeClickable(addToWishlistLocator2));
        addToWishlist2.click();
        System.out.println("Second Item added to wishlist");

        System.out.println("Finding women section 3rd time");
        WomenSection =wait.until(ExpectedConditions.elementToBeClickable(WomenSectionLocator));
        WomenSection.click();

        By thirdItemLocator = By.xpath("(//ol[@class='product-items widget-product-grid']//div[@class='product-item-info'])[3]");
        WebElement thirdItem = wait.until(ExpectedConditions.elementToBeClickable(thirdItemLocator));

        actions.moveToElement(thirdItem).perform();
        System.out.println("hover performed on third item for wishlist");

        By addToWishlistLocator3 = By.xpath("(//div[@class='actions-secondary']/a[@title='Add to Wish List'])[3]");
        WebElement addToWhishlist3 = wait.until(ExpectedConditions.elementToBeClickable(addToWishlistLocator3));
        addToWhishlist3.click();
        System.out.println("Third Item added to wishlist");


    }

    @Test(priority = 6)
    public void myWishlist() {

        By dropdownButtonLocator = By.xpath("(//button[@class='action switch'])[1]");
        WebElement dropdownButton = wait.until(ExpectedConditions.elementToBeClickable(dropdownButtonLocator));
        System.out.println("My Account button found");
        dropdownButton.click();
        System.out.println("Dropdown button clicked");

        By myWishlistLocator = By.xpath("(//ul[@class='header links']//li[@class='link wishlist']//a)[position() = 1]");
        WebElement visitMyWishlist = wait.until(ExpectedConditions.elementToBeClickable(myWishlistLocator));
        visitMyWishlist.click();
        System.out.println("visitMyWishlist clicked");

        //first product of wishlist
        By firstWishlistItemLocator = By.xpath("(//div[@class='products-grid wishlist']//li[@class='product-item'])[position() = 1]");
        WebElement firstWishlistItem = wait.until(ExpectedConditions.elementToBeClickable(firstWishlistItemLocator));

        // Hover over the first product
        Actions actions = new Actions(driver);
        actions.moveToElement(firstWishlistItem).perform();
        System.out.println("hover performed");

        // Locate the "Remove Item" link for the first product
        By removeItemLocator = By.xpath("(//a[@title='Remove Item'])[1]");
        WebElement removeItemLink = wait.until(ExpectedConditions.elementToBeClickable(removeItemLocator));
        System.out.println("remove button located");

        removeItemLink.click();
        System.out.println("first item removed");

        //last product of wishlist
        By lastWishlistItemLocator = By.xpath("(//div[@class='products-grid wishlist']//li[@class='product-item'])[last()]");
        WebElement lastWishlistItem = wait.until(ExpectedConditions.elementToBeClickable(lastWishlistItemLocator));
        lastWishlistItem.click();

        By selectSizeLocator = By.xpath("//div[@attribute-code='size']//div[@class='swatch-attribute-options clearfix']//div[@index='0']");
        WebElement selectSize = wait.until(ExpectedConditions.elementToBeClickable(selectSizeLocator));
        selectSize.click();

        By selectColorLocator = By.xpath("//div[@attribute-code='color']//div[@class='swatch-attribute-options clearfix']//div[@index='0']");
        WebElement selectColor = wait.until(ExpectedConditions.elementToBeClickable(selectColorLocator));
        selectColor.click();

        By addToCartLocator = By.id("product-addtocart-button");
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(addToCartLocator));
        addToCartButton.click();
        System.out.println("add to cart clicked");

    }


    @Test(priority = 7)
    public void addToCompare() {

        By WomenSectionLocator = By.id("ui-id-4");
        WebElement WomenSection = wait.until(ExpectedConditions.elementToBeClickable(WomenSectionLocator));
        WomenSection.click();

        By fistItemLocator = By.xpath("(//ol[@class='product-items widget-product-grid']//div[@class='product-item-info'])[1]");
        WebElement firstItem = wait.until(ExpectedConditions.elementToBeClickable(fistItemLocator));

        Actions actions = new Actions(driver);
        actions.moveToElement(firstItem).perform();
        System.out.println("hover performed on first item for compare");

        By addToCompareLocator = By.xpath("(//div[@class='actions-secondary']/a[@title='Add to Compare'])[1]");
        WebElement addToCompare = wait.until(ExpectedConditions.elementToBeClickable(addToCompareLocator));
        addToCompare.click();
        System.out.println("First Item added to compare");

        By secondItemLocator = By.xpath("(//ol[@class='product-items widget-product-grid']//div[@class='product-item-info'])[2]");
        WebElement secondItem = wait.until(ExpectedConditions.elementToBeClickable(secondItemLocator));

        actions.moveToElement(secondItem).perform();
        System.out.println("hover performed on second item for wishlist");

        By addToCompareLocator2 = By.xpath("(//div[@class='actions-secondary']/a[@title='Add to Compare'])[2]");
        WebElement addToCompare2 = wait.until(ExpectedConditions.elementToBeClickable(addToCompareLocator2));
        addToCompare2.click();
        System.out.println("Second Item added to compare");

        By compareLinkLocator = By.xpath("//li[@class='item link compare']/a[@class='action compare']");
        WebElement comparelink = wait.until(ExpectedConditions.elementToBeClickable(compareLinkLocator));
        comparelink.click();
        System.out.println("Compare link clicked");
    }

    @Test(priority = 8)
    public void reviewsComparison() {

        WebElement reviewsElement1 = null;
        List<WebElement> reviewsList1 = driver.findElements(By.xpath("(//div[@class='reviews-actions']/a[@class='action view'])[1]"));
        if (!reviewsList1.isEmpty()) {
            reviewsElement1 = reviewsList1.get(0);
        } else {
            System.out.println("Reviews for Product 1 not found. Setting to 0.");
        }

        String product1ReviewsText = (reviewsElement1 != null) ? reviewsElement1.getText() : "0";
        int product1Reviews = extractNumericValue(product1ReviewsText);
        System.out.println("Reviews for Product 1: " + product1Reviews);

        WebElement reviewsElement2 = null;
        List<WebElement> reviewsList2 = driver.findElements(By.xpath("(//div[@class='reviews-actions']/a[@class='action view'])[2]"));
        if (!reviewsList2.isEmpty()) {
            reviewsElement2 = reviewsList2.get(0);
        } else {
            System.out.println("Reviews for Product 2 not found. Setting to 0.");
        }

        String product2ReviewsText = (reviewsElement2 != null) ? reviewsElement2.getText() : "0";
        int product2Reviews = extractNumericValue(product2ReviewsText);
        System.out.println("Reviews for Product 2: " + product2Reviews);

        if (product1Reviews == product2Reviews) {
            System.out.println("Both products have the same number of reviews.");
            WebElement product1Link = driver.findElement(By.xpath("(//td[@class='cell product info']//a[@class='product-item-photo'])[1]"));
            product1Link.click();

            By selectSizeLocator = By.xpath("//div[@attribute-code='size']//div[@class='swatch-attribute-options clearfix']//div[@index='0']");
            WebElement selectSize = wait.until(ExpectedConditions.elementToBeClickable(selectSizeLocator));
            selectSize.click();

            By selectColorLocator = By.xpath("//div[@attribute-code='color']//div[@class='swatch-attribute-options clearfix']//div[@index='0']");
            WebElement selectColor = wait.until(ExpectedConditions.elementToBeClickable(selectColorLocator));
            selectColor.click();

            By addToCartLocator = By.id("product-addtocart-button");
            WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(addToCartLocator));
            addToCartButton.click();
            System.out.println("Add to cart clicked for Product 1.");

        } else {
            System.out.println("The number of reviews for the two products is different.");
            WebElement productToClick = (product1Reviews > product2Reviews) ? reviewsElement1 : reviewsElement2;
            System.out.println(productToClick);
            productToClick.click();

            System.out.println("Product entered");

//            By overlayLocator = By.xpath("//div[@attribute-code='size']//div[@class='swatch-attribute-options clearfix']//div[@index='0']");
//            wait.until(ExpectedConditions.invisibilityOfElementLocated(overlayLocator));

            By selectSizeLocator = By.xpath("//div[@attribute-code='size']//div[@index='0']");
            //By selectSizeLocator = By.xpath("//div[@attribute-code='size']//div[@class='swatch-attribute-options clearfix']//div[@index='0']");
            WebElement selectSize = wait.until(ExpectedConditions.elementToBeClickable(selectSizeLocator));

            Actions actions = new Actions(driver);
            actions.moveToElement(selectSize).click().perform();

            By selectColorLocator = By.xpath("//div[@attribute-code='color']//div[@index='0']");
            WebElement selectColor = wait.until(ExpectedConditions.elementToBeClickable(selectColorLocator));
            actions.moveToElement(selectColor).click().perform();

            By addToCartLocator = By.id("product-addtocart-button");
            WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(addToCartLocator));
            addToCartButton.click();
            System.out.println("Add to cart clicked for the product with more reviews.");
        }
    }


    private int extractNumericValue(String text) {
        // Use regular expression to extract only numeric part from the text
        String numericPart = text.replaceAll("[^0-9]", "");
        return numericPart.isEmpty() ? 0 : Integer.parseInt(numericPart);
    }


@Test(priority = 9)
public void removeComparisonItems() {

    By compareLinkLocator = By.xpath("//li[@class='item link compare']/a[@class='action compare']");
    WebElement comparelink = wait.until(ExpectedConditions.elementToBeClickable(compareLinkLocator));
    comparelink.click();
    System.out.println("Compare link clicked");

    By removeItemLocator = By.xpath("(//td[@class='cell remove product hidden-print']/a[@class='action delete'])[1]");

    WebElement removeItem = new WebDriverWait(driver, Duration.ofSeconds(30))
            .until(ExpectedConditions.elementToBeClickable(removeItemLocator));

    System.out.println("Remove item symbol found");
    removeItem.click();
    System.out.println("Remove Item clicked");

    By confirmRemovalLocator = By.xpath("//button[@class='action-primary action-accept']");


    WebElement confirmRemoval = new WebDriverWait(driver, Duration.ofSeconds(30))
            .until(ExpectedConditions.elementToBeClickable(confirmRemovalLocator));

    System.out.println("OK button found");
    confirmRemoval.click();
    System.out.println("OK clicked");


    WebElement removeItem1 = new WebDriverWait(driver, Duration.ofSeconds(30))
            .until(ExpectedConditions.elementToBeClickable(removeItemLocator));

    System.out.println("Remove item symbol found");
    removeItem1.click();
    System.out.println("Remove Item clicked");

    confirmRemoval = new WebDriverWait(driver, Duration.ofSeconds(30))
            .until(ExpectedConditions.elementToBeClickable(confirmRemovalLocator));

    System.out.println("OK button found 2");
    confirmRemoval.click();
    System.out.println("OK clicked");

}

    @Test(priority = 10)
    public void visitCartAndPrintSize() {
        // Click on the cart icon
        System.out.println("visit cart");
        WebElement cartIcon = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.action.showcart")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cartIcon);
        cartIcon.click();
        System.out.println("Cart entered");

        // Wait for the cart to load
        By cartSizeLocator = By.xpath("//span[@class='counter-number']");
        WebElement cartSizeElement = wait.until(ExpectedConditions.visibilityOfElementLocated(cartSizeLocator));
        System.out.println("Cart size found");

        // Get and print the size of the cart
        String cartSize = cartSizeElement.getText();
        System.out.println("Cart Size: " + cartSize);

        By WomenSectionLocator = By.id("ui-id-4");
        WebElement WomenSection = wait.until(ExpectedConditions.elementToBeClickable(WomenSectionLocator));
        WomenSection.click();

        By fistItemLocator = By.xpath("(//ol[@class='product-items widget-product-grid']//div[@class='product-item-info'])[1]");
        WebElement firstItem = wait.until(ExpectedConditions.elementToBeClickable(fistItemLocator));
        firstItem.click();

        By selectSizeLocator = By.xpath("//div[@attribute-code='size']//div[@class='swatch-attribute-options clearfix']//div[@index='0']");
        WebElement selectSize = wait.until(ExpectedConditions.elementToBeClickable(selectSizeLocator));
        selectSize.click();

        By selectColorLocator = By.xpath("//div[@attribute-code='color']//div[@class='swatch-attribute-options clearfix']//div[@index='0']");
        WebElement selectColor = wait.until(ExpectedConditions.elementToBeClickable(selectColorLocator));
        selectColor.click();

        By addToCartLocator = By.id("product-addtocart-button");
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(addToCartLocator));
        addToCartButton.click();
        System.out.println("add to cart clicked");

        System.out.println("visit cart1");

        try {
            cartSizeElement = wait.until(ExpectedConditions.visibilityOfElementLocated(cartSizeLocator));
        } catch (StaleElementReferenceException e) {
            // Re-locate the element and retry
            cartSizeElement = wait.until(ExpectedConditions.visibilityOfElementLocated(cartSizeLocator));
        }

        String cartSizeAfterChange = cartSizeElement.getText();
        System.out.println("Cart Size after change: " + cartSizeAfterChange);

        try {
            // Try clicking the cartIcon directly
            cartIcon.click();
            System.out.println("Cart entered");
        } catch (StaleElementReferenceException e) {
            // If stale element reference exception occurs, re-locate and click again
            cartIcon = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.action.showcart")));
            cartIcon.click();
            System.out.println("Cart re-entered ");
        }

        By viewNeditCartLocator = By.cssSelector("a.action.viewcart");
        WebElement viewNeditCart = wait.until(ExpectedConditions.elementToBeClickable(viewNeditCartLocator));
        viewNeditCart.click();
        System.out.println("Edit cart clicked");

        By orderTotalLocator = By.cssSelector("td.amount[data-th='Order Total']");
        WebElement orderTotalElement = wait.until(ExpectedConditions.visibilityOfElementLocated(orderTotalLocator));
        WebElement totalElement = orderTotalElement.findElement(By.cssSelector("span.price"));
        String orderTotal = totalElement.getText();
        System.out.println("Value of total order: " + orderTotal);

        By proceedToCheckoutLocator = By.xpath("//button[@type='button' and @data-role='proceed-to-checkout']");
        WebElement proceedToCheckoutButton = wait.until(ExpectedConditions.visibilityOfElementLocated(proceedToCheckoutLocator));
        proceedToCheckoutButton.click();

        By shipHereButtonLocator = By.xpath("//button[@type='button' and contains(@class, 'action-select-shipping-item')]");
        WebElement shipHereButton = wait.until(ExpectedConditions.visibilityOfElementLocated(shipHereButtonLocator));
        shipHereButton.click();

        By nextButtonLocator = By.xpath("//button[@data-role='opc-continue' and @type='submit' and contains(@class, 'button action continue primary')]");
        WebElement nextButton = wait.until(ExpectedConditions.visibilityOfElementLocated(nextButtonLocator));
        nextButton.click();

        By checkboxLocator = By.id("billing-address-same-as-shipping-checkmo");
        WebElement clickCheckbox = driver.findElement(checkboxLocator);
        clickCheckbox.click();

        By placeOrderButtonLocator = By.xpath("//button[contains(@class, 'action primary checkout') and contains(@data-bind, 'click: placeOrder')]");
        WebElement placeOrderButton = driver.findElement(placeOrderButtonLocator);
        placeOrderButton.click();

        By printRecieptLocator = By.xpath("//a[contains(@class, 'action print') and @rel='noopener']");
        WebElement printReciept = driver.findElement(printRecieptLocator);
        printReciept.click();

    }


    private void fillFormField(String locator, String text) {
        WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator)));
        field.clear();
        field.sendKeys(text);
    }

    private void waitAfterFieldFill() {
        WebDriverWait fieldWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Wait for the field to become stale, indicating that the operation is complete
        fieldWait.until(ExpectedConditions.stalenessOf(driver.findElement(By.id("maincontent"))));
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}

