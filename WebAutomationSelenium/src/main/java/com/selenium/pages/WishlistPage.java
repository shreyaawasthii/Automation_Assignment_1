package com.selenium.pages;

import com.selenium.util.CommonUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishlistPage {

    protected WebDriver driver;
    private final CommonUtils commonUtils;

    // Locators
    @FindBy(id = "ui-id-3")
    private WebElement whatsNew;

    @FindBy(css = "div.product-addto-links a[data-action='add-to-wishlist']")
    private WebElement addToWishlist;

    @FindBy(xpath = "(//ul[@class='header links']//li[@class='link wishlist']//a)[position() = 1]")
    private WebElement myWishlist;

    @FindBy(xpath = "(//div[@class='products-grid wishlist']//li[@class='product-item'])[position() = 1]")
    private WebElement firstWishlistItem;

    @FindBy(xpath = "(//a[@title='Remove Item'])[1]")
    private WebElement removeItem;

    // Constructor
    public WishlistPage() {
        this.driver = driver;
        this.commonUtils = new CommonUtils(driver);
        PageFactory.initElements(driver, this);
    }

    public void addToWishlist() {
        commonUtils.waitAndClick(whatsNew);
        commonUtils.waitAndClick(By.xpath("(//ol[@class='product-items widget-product-grid']//a[@class='product-item-photo'])[position() = 1]"));
        commonUtils.waitAndClick(addToWishlist);
        System.out.println("First Item added to wishlist");

        commonUtils.waitAndClick(whatsNew);
        commonUtils.waitAndClick(By.xpath("(//ol[@class='product-items widget-product-grid']//a[@class='product-item-photo'])[position() = 2]"));
        commonUtils.waitAndClick(addToWishlist);

        commonUtils.waitAndClick(whatsNew);
        commonUtils.waitAndClick(By.xpath("(//ol[@class='product-items widget-product-grid']//a[@class='product-item-photo'])[position() = 3]"));
        commonUtils.waitAndClick(addToWishlist);
    }

    public void visitMyWishlist() {
        commonUtils.waitAndClick(By.xpath("(//button[@class='action switch'])[1]"));
        commonUtils.waitAndClick(myWishlist);
        System.out.println("Visit My Wishlist clicked");
    }

    public void removeFirstItem() {
        commonUtils.hoverAndClick(firstWishlistItem, removeItem);
        System.out.println("First item removed");
    }

    public void addToCartLastItem() {
        commonUtils.waitAndClick(By.xpath("(//div[@class='products-grid wishlist']//li[@class='product-item'])[last()]"));
        commonUtils.waitAndClick(By.id("option-label-size-143-item-167"));
        commonUtils.waitAndClick(By.id("option-label-color-93-item-50"));
        commonUtils.waitAndClick(By.id("product-addtocart-button"));
        System.out.println("Add to cart clicked");
    }
}
