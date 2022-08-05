package org.fundatec.vinilemess.seleniumtest.page;


import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPageTest {
    private static WebDriver driver;
    private static LoginPage loginPage;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.setProperty("webdriver.chrome.driver", "/home/vinicius/chromedriver_linux64/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void mustValidateErrorMessageSuccessfully() throws InterruptedException{
        loginPage.submitEmptyLogin();
        Assert.assertEquals("An email address required.", loginPage.validateErrorMessage());
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        driver.quit();
    }
}