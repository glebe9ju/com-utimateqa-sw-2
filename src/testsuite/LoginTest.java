package testsuite;

import browserfactory.BaseTest;
import com.google.common.base.Verify;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.DynAnyPackage.Invalid;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginTest extends BaseTest {
    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        //click on the ‘Sign In’ link
        WebElement signIn = driver.findElement(By.partialLinkText("Sign In"));
        signIn.click();
        //Verify the text ‘Welcome Back!’
        WebElement welcome = driver.findElement(By.className("page__heading"));
        Assert.assertEquals("Wrong font style", "Welcome Back!", welcome.getText());

    }

    @Test
    public void verifyTheErrorMessage() {
        // click on the ‘Sign In’ link
        WebElement signIn = driver.findElement(By.partialLinkText("Sign In"));
        signIn.click();
        // Enter invalid username
        WebElement invalidUserName = driver.findElement(By.id("user[email]"));
        invalidUserName.sendKeys("hey123@yahoo.com");
        //Enter invalid password
        WebElement invalidPassWord = driver.findElement(By.name("user[email]"));
        invalidPassWord.sendKeys("hey123");
        //Click on Login button
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Sign in']"));
        loginButton.click();
       // Verify the error message ‘Invalid email
        WebElement invalidEmailOrPassword = driver.findElement(By.className("form-error__list-item"));
        Assert.assertEquals("Invalid Email and Password", "Invalid email or password.", invalidEmailOrPassword.getText());
    }
    @After
    public void tearDown() {
        closeBrowsers();
    }


}
