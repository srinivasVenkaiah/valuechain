/**
 * @author UmaMaheswararao
 */

package com.testcases;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BasePage;
import com.pages.LoginPage;
import com.pages.MyNetworkListPage;
import com.pages.NetworkDashBoardPage;
import com.pages.SettingsPage;
import com.util.ExcelUtility;

public class SettingsPageTest extends BasePage {
	
	LoginPage loginPage;
	MyNetworkListPage myNetworkListPage;
	NetworkDashBoardPage networkDashBoardPage;
	SettingsPage settingsPage;
	ExcelUtility reader;
	
	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		loginPage = new LoginPage();
		myNetworkListPage = loginPage.verify_login_functionality(prop.getProperty("username"), prop.getProperty("password"));
		reader = new ExcelUtility(prop.getProperty("excelFilePath"));
		networkDashBoardPage = myNetworkListPage.Open_Network_Dashboard_Page(reader.getCellData("NetworkList", 0, 3));
		settingsPage = networkDashBoardPage.Open_Settings_Page();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void verify_Settings_page_Test() {
		settingsPage.verify_Settings_page();
		Reporter.log("Settings page opened successfully", true);
	}
	
	@Test(dependsOnMethods="verify_Settings_page_Test")
	public void verify_Create_network_specific_tag_and_verify_it_in_Networkdashboard_and_Companies_page_select_tag_options_Test() throws Exception {
		settingsPage.verify_Create_network_specific_tag_and_verify_it_in_Networkdashboard_and_Companies_page_select_tag_options(
				reader.getOrderedRandomData("Settings", 0, 1), reader.getCellData("Settings", 1, 1), 
				reader.getCellData("Settings", 2, 1));
		
	}
	
	@Test(dependsOnMethods="verify_Settings_page_Test")
	public void verify_Delete_network_specific_tag_Test() throws Exception {
		settingsPage.verify_Delete_network_specific_tag(
				reader.getCellData("Settings", 0, 2), reader.getCellData("Settings", 1, 2), 
				reader.getCellData("Settings", 2, 2), reader.getCellData("Settings", 3, 2));
		
	}
	
	@Test(dependsOnMethods="verify_Settings_page_Test")
	public void verify_Add_network_tag_without_tag_name_and_verify_error_msg() throws Exception {
		settingsPage.verify_Add_network_tag_without_tag_name_and_verify_error_msg(
				reader.getCellData("Settings", 0, 3));
	}
	
	@Test(dependsOnMethods="verify_Settings_page_Test", enabled=true)
	public void verify_Default_visibility_of_network_menu_for_the_network_connected_user_Test() throws Exception {
		settingsPage.verify_Default_visibility_of_network_menu_for_the_network_connected_user(
				reader.getCellData("Settings", 0, 4), reader.getCellData("NetworkList", 0,3));
	}
	
	@Test(dependsOnMethods="verify_Settings_page_Test", enabled=true)
	public void verify_Network_menu_invisibility_after_unckecking_options_for_the_network_connected_user_Test() throws Exception {
		settingsPage.verify_Network_menu_invisibility_after_unckecking_options_for_the_network_connected_user(
				reader.getCellData("Settings", 0, 4), reader.getCellData("NetworkList", 0, 3));
	}
	
	@Test(dependsOnMethods="verify_Settings_page_Test")
	public void create_CapabilityGroup_Test() throws Exception {
		settingsPage.create_CapabilityGroup(reader.getOrderedRandomData("CapabilityGroup", 0, 1));
	}

	@Test(dependsOnMethods="verify_Settings_page_Test")
	public void mandatory_Name_For_CapabilityGroup_Test() {
		settingsPage.mandatory_Name_For_CapabilityGroup();
	}
	
	@Test(dependsOnMethods="create_CapabilityGroup_Test")
	public void verify_Already_ExistedGroup_Test() throws Exception {
		settingsPage.verify_Already_ExistedGroup(reader.getCellData("CapabilityGroup", 0, 1));
	}
	
	@Test(dependsOnMethods="verify_Settings_page_Test")
	public void delete_Group_Test() throws Exception {
		settingsPage.delete_Group(reader.getOrderedRandomData("CapabilityGroup", 0, 4));
	}
	
	@Test(dependsOnMethods="verify_Settings_page_Test")
	public void disable_Group_Test() throws Exception {
		settingsPage.disable_Group(reader.getOrderedRandomData("CapabilityGroup", 0, 3));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	

	
}
