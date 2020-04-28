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
import com.util.ExcelUtility;

public class MyNetworkListPageTest extends BasePage {
	
	LoginPage loginPage;
	MyNetworkListPage myNetworkListPage;
	ExcelUtility reader;
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		myNetworkListPage = loginPage.verify_login_functionality(prop.getProperty("username"), prop.getProperty("password"));
		reader = new ExcelUtility(prop.getProperty("excelFilePath"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void Search_network_option_Test() throws Exception {
		myNetworkListPage.verify_Search_newtwork_option();
		Reporter.log("Network search option is functional", true);
	}
	
	@Test(enabled=false)
	public void Prompt_message_for_unknown_network_search_Test() throws Exception {
		myNetworkListPage.verify_Prompt_message_for_unknown_network_search(reader.getCellData("NetworkList", 0, 1));
	}
	
	@Test
	public void Error_message_on_clicking_next_button_without_entering_network_name() throws Exception {
		myNetworkListPage.verify_Error_message_on_clicking_next_button_without_entering_network_name();
	}
	
	@Test
	public void Create_Industry_Alliance_Network_without_uploading_companies_data() throws Exception {
		myNetworkListPage.verify_Create_Industry_Alliance_Network_without_uploading_companies_data(
				reader.getOrderedRandomData("NetworkList", 0, 2), 
				reader.getCellData("NetworkList", 1, 2), reader.getCellData("NetworkList", 2, 2), 
				reader.getCellData("NetworkList", 3, 2), reader.getCellData("NetworkList", 4, 2), 
				reader.getCellData("NetworkList", 5, 2), reader.getCellData("NetworkList", 6, 2), 
				reader.getCellData("NetworkList", 7, 2), System.getProperty("user.dir")+"\\Files\\Network.png");
	}
	
	@Test
	public void Create_Industry_Alliance_Network_Test() throws Exception {
		myNetworkListPage.verify_Create_Industry_Alliance_Network(
				reader.getOrderedRandomData("NetworkList", 0, 3), 
				reader.getCellData("NetworkList", 1, 3), reader.getCellData("NetworkList", 2, 3), 
				reader.getCellData("NetworkList", 3, 3), reader.getCellData("NetworkList", 4, 3), 
				reader.getCellData("NetworkList", 5, 3), reader.getCellData("NetworkList", 6, 3), 
				reader.getCellData("NetworkList", 7, 3), System.getProperty("user.dir")+"\\Files\\Network2.jpg",
				System.getProperty("user.dir")+"\\Files\\Company List Template.xlsx", 
				reader.getCellData("NetworkList", 8, 3), System.getProperty("user.dir")+"\\Files\\Company Data Template.xlsx");
	}
	
	@Test
	public void verify_OEM_and_Subcontractor_networks_selection_Test() throws Exception {
		myNetworkListPage.verify_OEM_and_Subcontractor_networks_selection();
		Reporter.log("OEM & Subcontractor networks selection is functional", true);
	}
	
	@Test
	public void verify_Network_leader_field_is_editable_or_not() throws Exception {
		myNetworkListPage.verify_Network_leader_field_is_editable_or_not();
		Reporter.log("Network leader field for all types of networks is disabled by default", true);
	}
	
	@Test(dependsOnMethods="Create_Industry_Alliance_Network_Test")
	public void Open_created_network_Test() throws Exception {
		myNetworkListPage.verify_Open_created_network(reader.getCellData("NetworkList", 0, 3));
	}
	
	@Test
	public void verify_Create_Network_with_old_and_new_companies_Test() throws Exception {
		myNetworkListPage.verify_Create_Network_with_old_and_new_companies(
				reader.getOrderedRandomData("NetworkList", 0, 4), 
				reader.getCellData("NetworkList", 1, 4), reader.getCellData("NetworkList", 2, 4), 
				reader.getCellData("NetworkList", 3, 4), reader.getCellData("NetworkList", 4, 4), 
				reader.getCellData("NetworkList", 5, 4), reader.getCellData("NetworkList", 6, 4), 
				reader.getCellData("NetworkList", 7, 4), System.getProperty("user.dir")+"\\Files\\Network3.png",
				System.getProperty("user.dir")+"\\Files\\Company List Template new and old.xlsx", 
				reader.getCellData("NetworkList", 8, 4), System.getProperty("user.dir")+"\\Files\\Company Data Template.xlsx");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
