package Pack123;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ExcelLibrary.ExcelDataConfig;
import PageObjects.PageObj;

public class Test2 extends BaseClass {

	WebDriver driver;

	@BeforeTest
	public void launchbrowser() throws IOException {
		driver = launchBrowser();
	}

	@Test
	public void launchUrl() throws IOException {
		driver.get(prop.getProperty("url"));

	}

	@Test(dataProvider = "passData")
	public void loginFb(String username, String password) throws IOException {

		driver = launchBrowser();
		driver.get(prop.getProperty("url"));
		PageObj p = new PageObj(driver);
		p.email().sendKeys(username);
		p.PassWord().sendKeys(password);
		p.clickLogin();
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(System.getProperty("user.dir") + "\\screenshots\\2.png"));
		System.out.print("Screenshot has been captured successfully");

	}

	@Test(priority = 2)
	public void loginFbWrongCred() throws InterruptedException, IOException {

		driver = launchBrowser();
		String Expectederror = "The email address or mobile number you entered isn't connected to an account. Find your account and log in.";
		driver.get(prop.getProperty("url"));
		PageObj p = new PageObj(driver);
		p.email().sendKeys("uhih");
		p.PassWord().sendKeys("gfbd");
		p.clickLogin();
		Thread.sleep(20);
		String ActualError = driver.findElement(By.cssSelector("div._9ay7")).getText();
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(System.getProperty("user.dir") + "\\screenshots\\1.png"));
		Assert.assertEquals(Expectederror, ActualError);

	}

	@DataProvider
	public Object[][] passData() throws IOException {
		ExcelDataConfig config = new ExcelDataConfig(System.getProperty("user.dir")+"\\123.xlsx");
	

		Object[][] data = new Object[5][2];

		for (int i = 0; i < 5; i++) {
			data[i][0] = config.getData(0, i, 0);
			data[i][1] = config.getData(0, i, 1);

		}
		return data;
	}

	

}
