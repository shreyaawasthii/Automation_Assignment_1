//package com.selenium.util;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.time.Duration;
//
//public class CommonUtils {
//
//    public WebDriver driver;
//    public WebDriverWait wait;
//
//    public CommonUtils(WebDriver driver) {
//        this.driver = driver;
//        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//    }
//
//    public void fillFormField(String locator, String text) {
//        WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator)));
//        field.clear();
//        field.sendKeys(text);
//    }
//
//    public void waitAfterFieldFill() {
//        WebDriverWait fieldWait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        fieldWait.until(ExpectedConditions.stalenessOf(driver.findElement(By.tagName("body"))));
//    }
//
//    public WebElement getElementByLocator(By locator) {
//        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
//    }
//
//    public void clickElement(By locator) {
//        getElementByLocator(locator).click();
//    }
//
//    public void waitAndClick(WebElement element) {
//        WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(element));
//        clickableElement.click();
//    }
//
//    public void waitAndClick(By by) {
//        waitAndClick(driver.findElement(by));
//    }
//
//    public void hoverAndClick(WebElement elementToHover, WebElement elementToClick) {
//        Actions actions = new Actions(driver);
//        actions.moveToElement(elementToHover).perform();
//        wait.until(ExpectedConditions.elementToBeClickable(elementToClick)).click();
//    }
//
//    public void waitForElementClickable(WebElement element) {
//        wait.until(ExpectedConditions.elementToBeClickable(element));
//    }
//
//
//    public void waitForElementVisibility(WebElement element) {
//        wait.until(ExpectedConditions.visibilityOf(element));
//    }
//
//    public void waitForElementStaleness(WebElement element) {
//        wait.until(ExpectedConditions.stalenessOf(element));
//    }
//
//    public void fillFormField(WebElement element, String text) {
//        element.clear();
//        element.sendKeys(text);
//    }
//
//    public void selectOptionByText(By locator, String optionText) {
//        WebElement dropdown = getElementByLocator(locator);
//        dropdown.click();
//        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//option[text()='" + optionText + "']")));
//        option.click();
//    }
//
//    public WebDriver getDriver() {
//        return driver;
//    }
//}
