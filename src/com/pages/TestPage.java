package com.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TestPage {

	WebDriver driver;
	String sheetName = "LoginDetails";

	public TestPage(WebDriver driver) {

		this.driver = driver;
	}

	public void signUp() {
		driver.findElement(By.linkText("Sign Up ›")).click();
	}

	public void details() throws IOException {
		ExcelPage ep = new ExcelPage();

		WebElement email = driver.findElement(By.id("email"));
		String emailId = ep.getCellValue(sheetName, 0, 0);
		email.sendKeys(emailId);
		email.sendKeys(Keys.ENTER);
		String alert = driver
				.findElement(By
						.xpath("//div[@class='fieldError']/div[contains(text(),'Please enter a valid email address')]"))
				.getText();
		System.out.println("alert message after enteringinvalid email address :::::::::::" + alert);
		String country = ep.getCellValue(sheetName, 1, 0);
		Select select = new Select(driver.findElement(By.id("country")));
		select.selectByVisibleText(country);

	}

	public void login() throws InterruptedException {
		driver.findElement(By.linkText("Log In")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("rememberUn")).click();
	}

}
