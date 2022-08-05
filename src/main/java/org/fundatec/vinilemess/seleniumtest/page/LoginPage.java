package org.fundatec.vinilemess.seleniumtest.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private final WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void submitEmptyLogin() throws InterruptedException{
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
		driver.findElement(By.xpath("//button[@id='SubmitLogin']")).click();
	}
	
    public String validateErrorMessage(){
        return driver.findElement(By.xpath("//li[contains(text(),'An email address required.')]")).getText();
    }
}
