package com.selenium.pages;

import com.selenium.util.CommonUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    private CommonUtils commonUtils;

    @FindBy(xpath = "//div[@class='panel header']//a[contains(text(),'Sign In')]")
    private WebElement signIn;

    @FindBy(xpath = "//div[@class='panel header']//a[contains(text(),'Create Account')]")
    private WebElement createAccountLink;

    @FindBy(css = "#email")
    private WebElement email;

    @FindBy(css = "#pass")
    private WebElement password;

    @FindBy(css = "#send2")
    private WebElement createAccountButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.commonUtils = new CommonUtils(this.driver);
        PageFactory.initElements(this.driver, this);
    }

    public void initializeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://magento.softwaretestingboard.com/");
    }

    public void maximizeWindow() {
        driver.manage().window().maximize();
        System.out.println("Window maximized");
    }

    public void printCurrentTitle() {
        if (driver != null) {
            System.out.println("Current Title: " + driver.getTitle());
        } else {
            System.out.println("WebDriver is not initialized.");
        }
    }

    public void clickSignIn() {
        System.out.println("Sign In link found");
        commonUtils.wait.until(ExpectedConditions.elementToBeClickable(signIn)).click();
        System.out.println("Sign In Link clicked");
    }

    public void clickCreateAccountLink() {
        commonUtils.wait.until(ExpectedConditions.elementToBeClickable(createAccountLink)).click();
        System.out.println("Create Account link clicked");
    }

    public void fillCreateAccountForm(String userEmail, String userPassword) {
        commonUtils.fillFormField(email, userEmail);
        commonUtils.fillFormField(password, userPassword);
    }

    public void clickCreateAccountButton() {
        commonUtils.wait.until(ExpectedConditions.elementToBeClickable(createAccountButton)).click();
        System.out.println("Create Account Button Clicked");
    }
}
