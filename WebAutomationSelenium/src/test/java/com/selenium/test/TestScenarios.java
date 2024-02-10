package com.selenium.test;

import com.selenium.pages.*;
import com.selenium.pages.MyAccountPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class TestScenarios {

    private WebDriver driver;

    @Test(priority = 0)
    public void executeTestScenarios() {
        // Initializing pages
        HomePage homePage = new HomePage(driver);
        SignInPage signInPage = new SignInPage();
        MyAccountPage myAccountPage = new MyAccountPage();
        WishlistPage wishlistPage = new WishlistPage();
        ComparePage comparePage = new ComparePage();

        // Test Steps
        homePage.initializeDriver();
        homePage.maximizeWindow();
        homePage.printCurrentTitle();
        homePage.clickSignIn();

//        signInPage.signIn();
//        signInPage.clickSignInLink();
//        signInPage.fillEmail("shiksha@gmail.com");
//        signInPage.fillPassword("admin@1234");
//        signInPage.clickSignInButton();
//
//        myAccountPage.navigateToMyAccount();
//        myAccountPage.addShippingAddress();
//        myAccountPage.changeBillingAddress();
//
//        wishlistPage.addToWishlist();
//        wishlistPage.visitMyWishlist();
//        wishlistPage.removeFirstItem();
//        wishlistPage.addToCartLastItem();
//
//        comparePage.addToCompare();
//        comparePage.addToCartWithMoreReviews();
//        comparePage.removeItemsFromComparison();
    }
}