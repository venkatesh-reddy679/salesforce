package com.test;

import java.io.IOException;

import org.testng.annotations.Test;

import com.pages.TestPage;
import com.utilities.WrapperClass;

public class TestCase extends WrapperClass {

	@Test
	public void f() throws IOException, InterruptedException {
		launchBrowser("chrome", "https://developer.salesforce.com/");
		TestPage tp = new TestPage(driver);

		tp.signUp();
		tp.details();
		tp.login();
		screenshot();
		quit();
	}

}
