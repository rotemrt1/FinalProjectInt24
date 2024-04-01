package test.sanityTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BuyProductsScenario {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();


        String currentURL = driver.getCurrentUrl();
        if (currentURL.equals("https://www.saucedemo.com/inventory.html")) {
            System.out.println("You've logged in successfully : " + currentURL);
        }  else {
            System.out.println("Login failed");
        }

        WebElement pageTitle = driver.findElement(By.cssSelector("#header_container > div.header_secondary_container > span"));
        String title = pageTitle.getText();

        if (title.equals("Products")) {
            System.out.println("The Title has be found by :" + title);
        } else {
            System.out.println("Title Not found");
        }

        WebElement addToCartFirstItem = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        addToCartFirstItem.click();
        WebElement addToCartSecondItems = driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket"));
        addToCartSecondItems.click();
        WebElement cart = driver.findElement(By.cssSelector("#shopping_cart_container > a > span"));
        String cartItemsCountText = cart.getText();

        if (cartItemsCountText.equals("2")) {
            System.out.println("you have add 2 items into the cart");
        } else {
            System.out.println("no items added to the cart");
        }
        cart.click();
        driver.findElement(By.cssSelector("#continue-shopping")).click();

        driver.get("https://www.saucedemo.com/checkout-step-one.html");
        String checkoutStepOne = driver.getCurrentUrl();

        if (checkoutStepOne.equals("htts://www.saucedemo.com/checkout-step-one.html")) {
            System.out.println("you are in the checkout-step-One page");
        } else {
            System.out.println("Wrong page");
        }

        driver.findElement(By.id("first-name")).sendKeys("Rotem");
        driver.findElement(By.id("last-name")).sendKeys("Bechor");
        driver.findElement(By.id("postal-code")).sendKeys("5851226");
        driver.findElement(By.cssSelector("#continue")).click();

        String checkoutStepTwo = driver.getCurrentUrl();
        if (checkoutStepTwo.equals("https://www.saucedemo.com/checkout-step-two.html")) {
            System.out.println("you are in the checkout-step-Two page");
        } else {
            System.out.println("Wrong page");
        }

        driver.findElement(By.cssSelector("#finish")).click();

        String checkoutComplete = driver.getCurrentUrl();
        if (checkoutComplete.equals("https://www.saucedemo.com/checkout-complete.html")) {
            System.out.println("Order successfully placed");
        } else {
            System.out.println("Wrong page");
        }
        driver.quit();
    }
}