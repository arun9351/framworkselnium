package testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.base1;
import utilities.readxlfile23;

public class testcase1 extends base1 {

	

	 @Test (dataProvider = "red_xcl", dataProviderClass=readxlfile23.class , groups = "regression")

	public void logindetail(String name, String password) throws InterruptedException {
		driver.get("https://technop2p.in/login");
		 driver.manage().window().maximize();

		WebElement username = driver.findElement(By.name(loctor.getProperty("email_name")));
		username.sendKeys(name);

		WebElement password2 = driver.findElement(By.name(loctor.getProperty("password")));
		password2.sendKeys();

		WebElement login = driver.findElement(By.xpath(loctor.getProperty("login_button")));
		login.click();
		Thread.sleep(2000);

	}
	
}
		
		
	
