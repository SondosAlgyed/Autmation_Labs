package tests;

import Pages.Homepage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckElementPriceTest
{
    WebDriver driver;
    Homepage home;

    @BeforeClass
    public void openWebSite()
    {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.levelset.com/");
    }
    @Test
    public void verifyPrice()
    {
        home=new Homepage(driver);
        home.clickOnGetPaidButton();

    }

   /* @AfterClass
    public void closeBrowser()
    {
        driver.quit();
    }*/
}
