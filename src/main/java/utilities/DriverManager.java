package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class DriverManager {

    public static WebDriver driver;

    public static WebDriver getDriver(){
        if(driver == null) {
            driver = WebDriverManager.chromedriver().create();
            driver.manage().window().maximize();
            driver.get("https://www.saucedemo.com/");
        }
        return driver;
    }

    public static void quitDriver(){
        if(driver !=null) {
            driver.quit();
            driver = null;
        }
    }
}
