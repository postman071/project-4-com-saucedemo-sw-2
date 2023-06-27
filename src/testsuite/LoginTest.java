package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest
{
    String baseUrl="https://www.saucedemo.com/";

    @Before
    public void setUp()
    {
        openBrowser(baseUrl);
    }
    @Test
    public void VerifyUserShouldLoginSuccessfullyWithValidCredentials() {
        // Enter "standard_user" Username
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        // Enter "secret_sauce"password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        // Click on the loginLink
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        //Verify the text "PRODUCTS"
        String expectedText="Products";
        String actualText=driver.findElement(By.xpath("//span[@class ='title']")).getText();
        Assert.assertEquals(expectedText,actualText);
    }
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage()
    {
        // Enter "standard_user" Username
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        // Enter "secret_sauce"password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        // Click on the loginLink
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        // Verify that six products are displayed on page
        String expectedText= "Sauce Labs Backpack";
        String actualText=driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText();
        // Verify the Both messages are
        Assert.assertEquals(expectedText,actualText);
    }

    @After
    public void tearDown()
    {
      // closeBrowser();
    }

}
