package testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class myTestClass {

    public WebDriver driver;

    @BeforeAll
    public static void setDriver() {
        //WebDriverManager.chromedriver().setup();
        System.out.println("");
    }

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterEach
    public void quit() {
        driver.quit();
    }

    @Test
    void testCase1(){
        driver.get("https://www.saucedemo.com/");
        driver.findElement(new By.ById("user-name")).sendKeys("standard_user");
        driver.findElement(new By.ById("password")).sendKeys("secret_sauce");
        driver.findElement(new By.ById("login-button")).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        boolean present;
        try {
            present = true;
            driver.findElement(By.id("header_container"));
            driver.findElement(By.cssSelector("#shopping_cart_container>a.shopping_cart_link"));
            driver.findElement(By.className("bm-burger-button"));
            driver.findElement(By.id("logout_sidebar_link"));
            //todo linkovi
        }catch (NoSuchElementException e){
            present=false;
        }
        assertTrue(present);


    }
    @Test
    void testCase2(){
        driver.get("https://www.saucedemo.com/");
        driver.findElement(new By.ById("user-name")).sendKeys("standard_user");
        driver.findElement(new By.ById("password")).sendKeys("secret_sauce");
        driver.findElement(new By.ById("login-button")).click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(new By.ById("item_4_img_link")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String title=driver.findElement(new By.ByCssSelector("div.inventory_details_name.large_size")).getText();
        assertEquals("Sauce Labs Backpack",title);
        driver.findElement(new By.ById("add-to-cart-sauce-labs-backpack")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(new By.ById("back-to-products")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(new By.ById("add-to-cart-sauce-labs-fleece-jacket")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(new By.ById("shopping_cart_container")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(new By.ById("checkout")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(new By.ById("first-name")).sendKeys("Mirko");
        driver.findElement(new By.ById("last-name")).sendKeys("Petrovic");
        driver.findElement(new By.ById("postal-code")).sendKeys("34000");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(new By.ById("continue")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(new By.ById("finish")).click();
        String message=driver.findElement(By.cssSelector("h2.complete-header")).getText();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(new By.ById("react-burger-menu-btn")).click();
        driver.findElement(new By.ById("logout_sidebar_link")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        assertEquals("THANK YOU FOR YOUR ORDER",message);
    }

}

