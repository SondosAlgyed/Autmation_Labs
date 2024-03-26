package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class Cart
{
    WebDriver driver;
    String username="standard_user";
    String password="secret_sauce";
    String ElementName = "Sauce Labs Bike Light";

    String xpath;
    SoftAssert softassert;

    @BeforeTest
    public void OpenWebsite()
    {
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/cart.html");
    }

    @Test(priority = 0)
    public void userLogin()
    {
        WebElement usernameTxt= driver.findElement(By.id("user-name"));
        WebElement passwordTxt = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));
        usernameTxt.sendKeys(username);
        passwordTxt.sendKeys(password);
        loginButton.click();
        softassert=new SoftAssert();
        WebElement expectedResult=driver.findElement(By.cssSelector("span.title"));
        softassert.assertTrue(expectedResult.isDisplayed());
        softassert.assertAll();
    }

    @Test(priority=1)
    public void CartValidation()
    {
        addElementToCart(ElementName);
        driver.get("https://www.saucedemo.com/cart.html");
        WebElement Elementnamee=driver.findElement(By.xpath(String.format("//div[@class=\"cart_item\"]//div[@class='inventory_item_name'][text()='%s']",ElementName)));
        softassert=new SoftAssert();
        softassert.assertEquals(Elementnamee.getText(),ElementName);
        softassert.assertAll();

    }
    public void addElementToCart(String ElementName)
    {
        //Generic way
        xpath=String.format("//a[div[contains(text(), '%s')]]/parent::div/following-sibling::div/button",ElementName);
        WebElement AddToCartButton=driver.findElement(By.xpath(xpath));
        AddToCartButton.click();

    }




    @AfterTest
     public void closeBrowser()
    {
        driver.quit();
    }







}
