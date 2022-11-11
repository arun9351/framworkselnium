package base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class base1 {

	public static WebDriver driver;
	public static Properties p2 = new Properties();
	public static Properties loctor = new Properties();
	public static FileReader file1;
	public static FileReader file2;

	@BeforeMethod()
	public void saitup() throws IOException {
		if (driver == null) {
			System.out.println("print the path:" + System.getProperty("user.dir"));
			FileReader file1 = new FileReader(
					System.getProperty("user.dir") + "\\src\\test\\resources\\configurefile\\configure.properties");
			FileReader file2 = new FileReader(
					System.getProperty("user.dir") + "\\src\\test\\resources\\configurefile\\locator.properties");

			p2.load(file1);
			loctor.load(file2);
		}

		if (p2.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(p2.getProperty("testurl"));

		} else if (p2.getProperty("browser").equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.get(p2.getProperty("testurl"));

		} else if (p2.getProperty("browser").equalsIgnoreCase("fireforex")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.get(p2.getProperty("testurl"));
		}

	}

	@AfterMethod()
	public void teardown() throws InterruptedException {
		Thread.sleep(6000);
		driver.close();
		System.out.println("close web broswer");

	}

}
