package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.Generic_Utility.BaseClass;

public class DataProviderTest {

	@DataProvider
	public Object[][] dataProviderTest() {
		Object[][] objarr = new Object[2][2];
		objarr[0][0] = "bike";
		objarr[0][1] = "biker.com";

		objarr[1][0] = "car";
		objarr[1][1] = "carwale.com";
		return objarr;
	}
	@Test(dataProvider = "dataProviderTest")
	public void productDetails(String productName, String website) {
		String key = "webdriver.chrome.driver";
		String value = "./chromedriver.exe";
		System.setProperty(key, value);
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[text()='Products']")).click();
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(productName);
		driver.findElement(By.name("website")).sendKeys(website);
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		driver.quit();
		
	}

}
