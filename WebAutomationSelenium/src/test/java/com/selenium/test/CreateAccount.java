package com.selenium.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class CreateAccount {

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
    }

    @Test
    public void createAccount() {
        By createAccountLocator = By.cssSelector("div.panel.header ul.header.links li a[href*='/customer/account/create/']");
        WebElement createAccountLink = wait.until(ExpectedConditions.elementToBeClickable(createAccountLocator));
        createAccountLink.click();
        System.out.println("create account clicked");

        // Wait for the registration form to be visible
        By registrationFormLocator = By.id("form-validate");
        wait.until(ExpectedConditions.visibilityOfElementLocated(registrationFormLocator));
        System.out.println("form found");

        By firstName = By.cssSelector("#firstname");
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName));
        System.out.println("firstname found");
        fillFormField("#firstname", "Summu");
        System.out.println("firstname filled");

        By lastName = By.cssSelector("#lastname");
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastName));
        fillFormField("#lastname", "Tripathi");
        System.out.println("lastname found");


        By email = By.cssSelector("#email_address");
        wait.until(ExpectedConditions.visibilityOfElementLocated(email));
        System.out.println("email found");
        fillFormField("#email_address", "summu@gmail.com");
        System.out.println("email filled");


        By password = By.cssSelector("#password");
        wait.until(ExpectedConditions.visibilityOfElementLocated(password));
        System.out.println("password found");
        fillFormField("#password", "password@1234");
        System.out.println("password filled");


        By conPassword = By.cssSelector("#password-confirmation");
        wait.until(ExpectedConditions.visibilityOfElementLocated(conPassword));
        System.out.println("confirm password found");
        fillFormField("#password-confirmation", "password@1234");
        System.out.println("confirm password filled");

        // Click on the "Create Account" button
        WebElement createAccountButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.action.submit.primary[title='Create an Account']")));
        createAccountButton.click();
        System.out.println("Submit Button Clicked");
        waitAfterFieldFill();
    }

    private void fillFormField(String locator, String text) {
        WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator)));
        field.clear();
        field.sendKeys(text);
    }


    private void waitAfterFieldFill() {
        WebDriverWait fieldWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        // Wait for the field to become stale, indicating that the operation is complete
        fieldWait.until(ExpectedConditions.stalenessOf(driver.findElement(By.tagName("body"))));
    }


    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}