/**
 * @author UmaMaheswararao
 */

package com.testcases;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BasePage;
import com.pages.ExplorePage;
import com.pages.LoginPage;
import com.pages.MyNetworkListPage;
import com.pages.NetworkDashBoardPage;
import com.util.ExcelUtility;

public class ExplorePageTest extends BasePage {
	
	LoginPage loginPage;
	MyNetworkListPage myNetworkListPage;
	NetworkDashBoardPage networkDashBoardPage;
	ExplorePage explorePage;
	ExcelUtility reader;
	
	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		loginPage = new LoginPage();
		myNetworkListPage = loginPage.verify_login_functionality(prop.getProperty("username"), prop.getProperty("password"));
		reader = new ExcelUtility(prop.getProperty("excelFilePath"));
		networkDashBoardPage = myNetworkListPage.Open_Network_Dashboard_Page(reader.getCellData("NetworkList", 0, 3));
		explorePage = networkDashBoardPage.Open_Explore_Page();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void verify_Explore_page_Test() {
		explorePage.verify_Explore_page();
		Reporter.log("Explore page opened successfully", true);
	}
	
	@Test(dependsOnMethods="verify_Explore_page_Test")
	public void verify_Map_contains_companies_and_enable_map_settings() throws Exception {
		explorePage.verify_Map_contains_companies_and_enable_map_settings();
		Reporter.log("Explore page map and settings are functional", true);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
