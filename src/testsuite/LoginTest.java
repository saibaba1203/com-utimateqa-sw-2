package testsuite;

import broserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://courses.ultimateqa.com/";

    @Before

    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test

    public void userShouldNavigateToLoginPageSuccessfully(){
        driver.findElement(By.linkText("Sign In")).click();
        String expectedMessage = "Welcome Back!";

        WebElement message = driver.findElement(By.xpath("//h1[normalize-space()='Welcome Back!']"));
        String actualMessage = message.getText();
        Assert.assertEquals("Welcome Back! text is not displayed",expectedMessage , actualMessage);

    }
    @Test
    public void verifyTheErrorMessage(){
        driver.findElement(By.linkText("Sign In")).click();
        driver.findElement(By.xpath("//input[@id='user[email]']")).sendKeys("ab@gmil.com");
        driver.findElement(By.xpath("//input[@id='user[password]']")).sendKeys("anand");
        driver.findElement(By.xpath("//input[@value='Sign in']")).click();
        String expectedMessage = "Invalid email or password.";

        WebElement message = driver.findElement(By.xpath("//li[contains(text(),'Invalid email or password.')]"));
        String actualMessage = message.getText();
        Assert.assertEquals("Error message text is not displayed",expectedMessage , actualMessage);


    }

    }




