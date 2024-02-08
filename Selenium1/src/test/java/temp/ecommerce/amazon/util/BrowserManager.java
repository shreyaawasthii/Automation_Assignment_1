package temp.ecommerce.amazon.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;

import java.util.concurrent.TimeUnit;

public class BrowserManager {
    public static WebDriver getDriver(String Browsertype, String url){
        //System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/test/resources/chromedriver-linux64/chromedriver");
        ChromeOptions options;
        WebDriver driver=null;

        if(Browsertype.equalsIgnoreCase("chrome")){
            options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/test/resources/chromedriver-linux64/chromedriver");
            driver = new ChromeDriver(options);
        } else if (Browsertype.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (Browsertype.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else {
            Assert.assertTrue(false,"No Browser type sent");
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);
        Reporter.log("Navigated to Browser: "+Browsertype+" URL: "+url,true);
        return driver;
    }
}
