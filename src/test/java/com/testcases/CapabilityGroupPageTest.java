package com.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.base.BasePage;
import com.pages.CapabilityGroupPage;
import com.pages.LoginPage;
import com.pages.MyNetworkListPage;
import com.pages.NetworkDashBoardPage;
import com.pages.TenderPage;
import com.util.ExcelUtility;

public class CapabilityGroupPageTest extends BasePage {
	LoginPage loginPage;
	MyNetworkListPage myNetworkListPage;
	NetworkDashBoardPage networkDashBoardPage;
	ExcelUtility reader;
	CapabilityGroupPage capabilityGroupPage;


	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		loginPage = new LoginPage();
		myNetworkListPage = loginPage.verify_login_functionality(prop.getProperty("username"), prop.getProperty("password"));
		reader = new ExcelUtility(prop.getProperty("excelFilePath"));
		networkDashBoardPage = myNetworkListPage.Open_Network_Dashboard_Page(reader.getCellData("NetworkList", 0, 3));
		capabilityGroupPage = networkDashBoardPage.open_CapabilityGroupPage();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
	
}
