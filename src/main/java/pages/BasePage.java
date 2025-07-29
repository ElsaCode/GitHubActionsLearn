package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverManager;

import java.sql.Driver;

public class BasePage {

    protected WebDriver driver;

    public BasePage(){
        this.driver = DriverManager.getDriver();
        PageFactory.initElements(driver, this);
    }
}
