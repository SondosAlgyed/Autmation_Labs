package Pages;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Homepage {
    WebDriver driver;
    Actions actions;
    WebDriverWait wait;

    public Homepage(WebDriver driver) {
        this.driver = driver;
        // actions = new Actions(driver);
    }

    WebElement GetPaidButton = driver.findElement(By.cssSelector("a[class='btn btn-info btn-outline mob-dropdown-btn']"));
    public void clickOnGetPaidButton()
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(GetPaidButton));
        GetPaidButton.click();
        GetPaidButton.click();

        /*actions.moveToElement(GetPaidButton).perform();
        WebElement CreateOtherDocumentsBtn=driver.findElement(By.linkText("Create other documents"));
       CreateOtherDocumentsBtn.click();*/

    }

}

