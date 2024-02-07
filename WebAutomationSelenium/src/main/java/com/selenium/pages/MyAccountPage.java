//package com.selenium.pages;
//
//import com.selenium.util.CommonUtils;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.By;
//
//public class MyAccountPage {
//
//    private WebDriver driver;
//    private CommonUtils commonUtils;
//
//    @FindBy(xpath = "(//button[@class='action switch'])[1]")
//    private WebElement dropdownButton;
//
//    @FindBy(xpath = "//li[@class='customer-welcome active']//a[contains(text(),'My Account')]")
//    private WebElement myAccountLink;
//
//    @FindBy(xpath = "//a[contains(text(), 'Address Book')]")
//    private WebElement addressBookLink;
//
//    @FindBy(xpath = "//button[@type='button' and @role='add-address' and @title='Add New Address' and contains(@class, 'add')]")
//    private WebElement addAddressButton;
//
//    @FindBy(css = "div.box-address-billing a.action.edit")
//    private WebElement changeBillingAddressLink;
//
//    @FindBy(css = "#telephone")
//    private WebElement telephoneField;
//
//    @FindBy(css = "#street_1")
//    private WebElement street1Field;
//
//    @FindBy(css = "#street_2")
//    private WebElement street2Field;
//
//    @FindBy(css = "#street_3")
//    private WebElement street3Field;
//
//    @FindBy(css = "#country")
//    private WebElement countrySelect;
//
//    @FindBy(css = "#region_id")
//    private WebElement regionSelect;
//
//    @FindBy(css = "#city")
//    private WebElement cityField;
//
//    @FindBy(css = "#zip")
//    private WebElement zipCodeField;
//
//    @FindBy(css = "button.action.save.primary")
//    private WebElement saveAddressButton;
//
//    public MyAccountPage(WebDriver driver) {
//        this.driver = driver;
//        this.commonUtils = new CommonUtils(driver);
//        PageFactory.initElements(driver, this);
//    }
//
//    public void navigateToMyAccount() {
//        commonUtils.waitForElementClickable(dropdownButton);
//        dropdownButton.click();
//        commonUtils.waitForElementClickable(myAccountLink);
//        myAccountLink.click();
//    }
//
//    public void addShippingAddress() {
//        addressBookLink.click();
//        telephoneField.click();
//        telephoneField.sendKeys("9876543210");
//        commonUtils.waitForElementVisibility(street1Field);
//        street1Field.clear();
//        street1Field.sendKeys("13B");
//        commonUtils.waitForElementVisibility(street2Field);
//        street2Field.clear();
//        street2Field.sendKeys("Flex Apartments");
//        commonUtils.waitForElementVisibility(street3Field);
//        street3Field.clear();
//        street3Field.sendKeys("Sector 59");
//        countrySelect.click();
//        commonUtils.waitForElementClickable(countrySelect.findElement(
//                By.xpath("//option[@value='IN' and text()='India']")));
//        regionSelect.click();
//        commonUtils.waitForElementClickable(regionSelect.findElement(
//                By.xpath("//option[@value='542' and text()='Delhi']")));
//        commonUtils.fillFormField(cityField, "Delhi");
//        commonUtils.waitForElementVisibility(zipCodeField);
//        zipCodeField.clear();
//        zipCodeField.sendKeys("201301");
//        saveAddressButton.click();
//        commonUtils.waitForElementStaleness(driver.findElement(By.tagName("body")));
//    }
//
//    public void changeBillingAddress() {
//        changeBillingAddressLink.click();
//        commonUtils.waitForElementVisibility(cityField);
//        cityField.clear();
//        commonUtils.fillFormField(cityField, "Gurugram");
//        commonUtils.waitForElementVisibility(zipCodeField);
//        zipCodeField.clear();
//        zipCodeField.sendKeys("122015");
//        saveAddressButton.click();
//        commonUtils.waitForElementStaleness(driver.findElement(By.tagName("body")));
//    }
//}
