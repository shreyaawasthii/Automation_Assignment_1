//package com.selenium.pages;
//
//import com.selenium.util.CommonUtils;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//
//
//public class ComparePage {
//
//    private WebDriver driver;
//    private CommonUtils commonUtils;
//
//    @FindBy(css = "div.product-addto-links a.action.tocompare")
//    private WebElement addToCompareButton;
//
//    @FindBy(xpath = "//ul[@class='compare wrapper']//a[@class='action compare']")
//    private WebElement compareProductLink;
//
//    @FindBy(xpath = "(//div[@class='reviews-actions']/a)[1]")
//    private WebElement reviewLink;
//
//    public ComparePage() {
//        this.driver = driver;
//        this.commonUtils = new CommonUtils(driver);
//        // Initialize elements using PageFactory
//        PageFactory.initElements(driver, this);
//    }
//
//    public void addToCompare() {
//        commonUtils.waitAndClick(addToCompareButton);
//        System.out.println("Item added to Compare");
//    }
//
//    public void addToCartWithMoreReviews() {
//        commonUtils.waitAndClick(compareProductLink);
//
//        String productReviews = reviewLink.getText();
//
//        // Extract and compare the reviews (dummy logic, replace with actual implementation)
//        int reviewsCount = Integer.parseInt(productReviews.split(" ")[0]);
//        if (reviewsCount > 0) {
//            System.out.println("Adding item with more reviews to Cart");
//            // Implement logic to add the item to the cart
//        } else {
//            System.out.println("No reviews available for the item.");
//        }
//    }
//
//    public void removeItemsFromComparison() {
//        By removeItemLocator = By.xpath("(//td[@class='cell remove product hidden-print']/a[@class='action delete'])[1]");
//        commonUtils.waitAndClick(removeItemLocator);
//        System.out.println("Remove Item clicked");
//
//        By confirmRemovalLocator = By.xpath("//button[@class='action-primary action-accept']");
//        commonUtils.waitAndClick(confirmRemovalLocator);
//        System.out.println("OK clicked");
//
//        // Repeat the process for the second item (dummy logic, replace with actual implementation)
//        commonUtils.waitAndClick(removeItemLocator);
//        System.out.println("Remove Item clicked");
//
//        commonUtils.waitAndClick(confirmRemovalLocator);
//        System.out.println("OK clicked");
//
//        System.out.println("Items removed from Comparison");
//    }
//}
