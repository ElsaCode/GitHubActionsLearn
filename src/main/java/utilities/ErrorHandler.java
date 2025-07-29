package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ErrorHandler {

    WebDriver driver = DriverManager.getDriver();

    public String waitErrorMessage(String expectedText){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement errorMessageElement = driver.findElement(By.cssSelector("h3[data-test='error']"));
        wait.until(ExpectedConditions.textToBePresentInElement(errorMessageElement, expectedText));
        return errorMessageElement.getText();
    }
}
