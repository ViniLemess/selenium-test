package org.fundatec.vinilemess.seleniumtest.page;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CartPageTest {
    private static WebDriver driver;
    private static CartPage cartPage;

    Logger logger = LoggerFactory.getLogger(CartPageTest.class);

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.setProperty("webdriver.chrome.driver", "/home/vinicius/chromedriver_linux64/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");
        cartPage = new CartPage(driver);
    }

    @Test
    public void mustFillFieldAndSearchSuccessfully() throws InterruptedException{
        try {
            cartPage.fillFieldAndSearch();
        } catch (Exception exception) {
            logger.error(exception.getMessage());
        }
        Thread.sleep(5000);
        Assert.assertEquals("1 result has been found.", cartPage.validateResultsFoundsMessage());
    }

    @Test
    public void mustAddToCartSuccessfully() throws InterruptedException {
        cartPage.addToCart();
    }

    @Test
    public void mustRemoveFromCartSuccessfully() throws InterruptedException {
        cartPage.removeFromCart();
        Assert.assertEquals("Your shopping cart is empty.", cartPage.validateEmptyCartMessage());
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        driver.quit();
    }
}