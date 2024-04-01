package test.loginTests.negetiveTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ValidateLockedUserError {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        WebElement text = driver.findElement(By.cssSelector("#login_button_container > div > form > div.error-message-container.error > h3"));
        String errorMsg = text.getText();

        if (errorMsg.equals("Epic sadface: Sorry, this user has been locked out.")) {
            System.out.println("Error: " + errorMsg);
        } else {
            System.out.println("Epic sadface: Username and password do not match any user in this service");
        }

        driver.quit();
    }
}