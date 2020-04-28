/**
 * @author UmaMaheswararao
 */

package com.testcases;

import java.nio.file.Paths;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BasePage;
import com.pages.LoginPage;
import com.pages.MapPage;
import com.pages.MyNetworkListPage;
import com.pages.NetworkDashBoardPage;
import com.util.ExcelUtility;

public class MapPageTest extends BasePage {
	
	LoginPage loginPage;
	MyNetworkListPage myNetworkListPage;
	NetworkDashBoardPage networkDashBoardPage;
	MapPage mapPage;
	ExcelUtility reader;
	
	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		loginPage = new LoginPage();
		myNetworkListPage = loginPage.verify_login_functionality(prop.getProperty("username"), prop.getProperty("password"));
		reader = new ExcelUtility(prop.getProperty("excelFilePath"));
		networkDashBoardPage = myNetworkListPage.Open_Network_Dashboard_Page(reader.getCellData("NetworkList", 0, 3));
		mapPage = networkDashBoardPage.Open_Map_Page();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void verify_Map_page_Test() {
		mapPage.verify_Map_page();
		Reporter.log("Map page opened successfully", true);
	}
	
	@Test(dependsOnMethods="verify_Map_page_Test")
	public void verify_Navigate_to_company_profile_page_from_map_Test() throws Exception {
		mapPage.verify_Navigate_to_company_profile_page_from_map(reader.getCellData("Map", 0, 1));
		Reporter.log("Company profile page is naviagetd successfully from the map successfully", true);
	}
	
	@Test(dependsOnMethods="verify_Map_page_Test")
	public void verify_Add_tag_to_the_company_from_map_Test() throws Exception {
		mapPage.verify_Add_tag_to_the_company_from_map(reader.getCellData("Map", 0, 2), 
				reader.getCellData("Map", 1, 2));
		Reporter.log("Tag added to the company successfully", true);
	}
	
	@Test(dependsOnMethods="verify_Map_page_Test")
	public void verify_Add_new_company_from_map_Test() throws Exception {
		mapPage.verify_Add_new_company_from_map(reader.getCellData("Map", 0, 3),
				reader.getOrderedRandomData("Map", 1, 3), reader.getCellData("Map", 2, 3),
				reader.getCellData("Map", 3, 3), reader.getCellData("Map", 4, 3));
		Reporter.log("New company added successfully", true);
	}
	
	@Test(dependsOnMethods="verify_Map_page_Test")
	public void verify_Download_template_Test() throws Exception {
		mapPage.verify_Download_template(reader.getCellData("Map", 0, 4),
				Paths.get(System.getProperty("user.home"), "Downloads").toString(), 
				reader.getCellData("Map", 1, 4));
		Reporter.log("Company Template downloaded successfully", true);
	}
	
	@Test(dependsOnMethods="verify_Map_page_Test")
	public void verify_Upload_template_Test() throws Exception {
		mapPage.verify_Upload_template(System.getProperty("user.dir")+"\\Files\\Map Company List Template.xlsx");
		Reporter.log("Company Template uploaded successfully", true);
	}
	
	@Test
	public void verify_Disconnect_the_company_from_map_Test() throws Exception {
		mapPage.verify_Disconnect_the_company_from_map();
		Reporter.log("Company disconnection is functional", true);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
