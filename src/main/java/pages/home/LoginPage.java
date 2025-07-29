package pages.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

public class LoginPage extends BasePage {
    @FindBy(id = "user-name")
    WebElement usernamefield;

    @FindBy(id = "password")
    WebElement passwordfield;

    @FindBy(id = "login-button")
    WebElement LoginLink;

    @FindBy(tagName = "h3")

    public WebElement lvlError;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public LoginPage() {

    }

    public void enterusername(String username) {
        usernamefield.sendKeys(username);
    }

    public void enterpassword(String password) {
        passwordfield.sendKeys(password);
    }

    public void clickLoginLink() {
        LoginLink.click();
    }
}
