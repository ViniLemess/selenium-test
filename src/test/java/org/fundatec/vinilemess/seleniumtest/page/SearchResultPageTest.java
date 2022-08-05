package org.fundatec.vinilemess.seleniumtest.page;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchResultPageTest {
    private static WebDriver driver;
    private static SearchResultPage searchResultPage;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.setProperty("webdriver.chrome.driver", "/home/vinicius/chromedriver_linux64/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");
        searchResultPage = new SearchResultPage(driver);
    }

    @Test
    public void mustFillFieldAndSearchSuccessfully() throws InterruptedException{
        searchResultPage.fillFieldAndSearch();
        Assert.assertEquals("1 result has been found.", searchResultPage.validateResults());
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        driver.quit();
    }
}