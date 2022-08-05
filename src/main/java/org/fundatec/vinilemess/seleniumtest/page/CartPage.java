package org.fundatec.vinilemess.seleniumtest.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;


public class CartPage {
	
	final WebDriver driver;
	static final String SEARCH = "Faded Short Sleeve T-shirts";

	private static final Logger logger = LoggerFactory.getLogger(CartPage.class);
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void fillFieldAndSearch()  {
		driver.findElement(By.xpath("//input[@id='search_query_top']")).click();
		driver.findElement(By.xpath("//input[@id='search_query_top']")).sendKeys(SEARCH);
		driver.findElement(By.xpath("//header/div[3]/div[1]/div[1]/div[2]/form[1]/button[1]")).click();
	}

	public String validateResultsFoundsMessage() {
		return driver.findElement(By.xpath("//span[contains(text(),'1 result has been found.')]")).getText();
	}
	
	public void addToCart() {
		try {
			fillFieldAndSearch();
		} catch (Exception exception) {
			logger.error(exception.getMessage());
		}
		WebElement addToCart = driver.findElement(By.xpath("//body/div[@id='page']/div[2]/div[1]/div[3]/div[2]/ul[1]/li[1]"));
		Actions action = new Actions(driver);
		action.moveToElement(addToCart).build().perform();

		driver.findElement(By.xpath("//body/div[@id='page']/div[2]/div[1]/div[3]/div[2]/ul[1]/li[1]/div[1]/div[2]/div[2]/a[1]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//header/div[3]/div[1]/div[1]/div[4]/div[1]/div[2]/div[4]/a[1]/span[1]")).click();
	}
	
	public void removeFromCart() {
		try {
			addToCart();
		} catch (Exception exception) {
			logger.error(exception.getMessage());
		}
		driver.findElement(By.xpath("//tbody/tr[@id='product_1_1_0_0']/td[7]/div[1]/a[1]/i[1]")).click();
	}

	public String validateEmptyCartMessage() throws InterruptedException{
		Thread.sleep(10000);
        return driver.findElement(By.xpath("//p[contains(text(),'Your shopping cart is empty.')]")).getText();
	}
}
