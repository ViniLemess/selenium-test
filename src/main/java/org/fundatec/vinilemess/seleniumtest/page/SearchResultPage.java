package org.fundatec.vinilemess.seleniumtest.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage {

	private final WebDriver driver;
	private static final String SEARCH = "Faded Short Sleeve T-shirts";
	
	public SearchResultPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void fillFieldAndSearch() throws InterruptedException{
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='search_query_top']")).click();
		driver.findElement(By.xpath("//input[@id='search_query_top']")).sendKeys(SEARCH);
		driver.findElement(By.xpath("//header/div[3]/div[1]/div[1]/div[2]/form[1]/button[1]")).click();
	}
	
    public String validateResults(){
        return driver.findElement(By.xpath("//span[contains(text(),'1 result has been found.')]")).getText();
    }
}
