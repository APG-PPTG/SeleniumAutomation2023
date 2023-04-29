package com.nopcommerce.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.LoginPage;
import com.nopcommerce.testBase.BaseClass;

public class TC_LoginTest_001 extends BaseClass
{
	//public WebDriver driver;
	
//	@BeforeClass
//	public void setup() {
//		WebDriverManager.chromedriver().setup();
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--remote-allow-origins=*");
//		driver = new ChromeDriver(options);
//		
//		//ChromeDriver driver = new ChromeDriver(options);
//	}
	
	@Test
	public void loginTest() throws IOException
	{
		logger.info("******** Starting TC_LoginTest_001 ********");
		driver.get(configPropObject.getProperty("baseURL"));
		LoginPage lp=new LoginPage(driver);
		
		logger.info("******** Providing Login Credentials ********");
		lp.setUserName(configPropObject.getProperty("useremail"));
		lp.setPassword(configPropObject.getProperty("password"));
		lp.clickLogin();
		
		String exp_title="Dashboard / nopCommerce administration1";
		String act_title=driver.getTitle();
		
		if(exp_title.equals(act_title))
		{
			logger.info("******** TC_LoginTest_001 Passed ********");
			Assert.assertTrue(true);
		}
		else
		{
			logger.info("********  TC_LoginTest_001 Failed ********");
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);

		}
	
		logger.info("******** Finished TC_LoginTest_001 ********");
		logger.info("******** ========================= ********");

	}
	
//	@AfterClass
//	public void tearDown() {
//		driver.close();
//	}
	
}
