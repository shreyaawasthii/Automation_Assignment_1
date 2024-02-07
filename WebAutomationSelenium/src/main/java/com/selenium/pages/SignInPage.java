//package com.selenium.pages;
//
//import com.selenium.util.CommonUtils;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.Test;
//
//public class SignInPage {
//
//    private CommonUtils commonUtils;
//    private WebDriver driver;
//
//    @FindBy(xpath = "//div[@class='panel header']//a[contains(text(),'Sign In')]")
//    private WebElement signInLink;
//
//    @FindBy(css = "#email")
//    private WebElement emailField;
//
//    @FindBy(css = "#pass")
//    private WebElement passwordField;
//
//    @FindBy(css = "#send2")
//    private WebElement signInButton;
//
//    public SignInPage(WebDriver driver) {
//        this.driver = driver;
//        this.commonUtils = new CommonUtils(driver);
//        PageFactory.initElements(driver, this);
//    }
//
//    @BeforeClass
//    public void setUp() {
//    }
//
//    @Test(priority = 1)
//    public void signIn() {
//        clickSignInLink();
//        fillEmail("summu@gmail.com");
//        fillPassword("password@1234");
//        clickSignInButton();
//        System.out.println("SignIn Button Clicked");
//        commonUtils.waitAfterFieldFill();
//    }
//
//    public void clickSignInLink() {
//        commonUtils.waitForElementClickable(signInLink);
//        signInLink.click();
//        System.out.println("Sign In Link Clicked");
//    }
//
//    public void fillEmail(String email) {
//        commonUtils.waitForElementVisibility(emailField);
//        commonUtils.fillFormField(emailField, email);
//        System.out.println("Email filled");
//    }
//
//    public void fillPassword(String password) {
//        commonUtils.waitForElementVisibility(passwordField);
//        commonUtils.fillFormField(passwordField, password);
//        System.out.println("Password filled");
//    }
//
//    public void clickSignInButton() {
//        commonUtils.waitForElementClickable(signInButton);
//        signInButton.click();
//        System.out.println("Sign In Button Clicked");
//    }
//
//    @AfterClass
//    public void tearDown() {
//        commonUtils.getDriver().quit();
//    }
//}
