package temp.ecommerce.amazon.po;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchBar;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void searchForProduct(String searchTerm) {
        searchBar.click();
        searchBar.sendKeys(searchTerm);
        searchBar.sendKeys(Keys.ENTER);
    }
    public void assertSearchForProduct(String searchTerm) {
        searchForProduct(searchTerm);
    }
}
