/**
 * @author UmaMaheswararao
 */

package com.testcases;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BasePage;
import com.pages.AdvancedSearchPage;
import com.pages.LoginPage;
import com.pages.MyNetworkListPage;
import com.pages.NetworkDashBoardPage;
import com.util.ExcelUtility;

public class AdvancedSearchPageTest extends BasePage {
	
	LoginPage loginPage;
	MyNetworkListPage myNetworkListPage;
	NetworkDashBoardPage networkDashBoardPage;
	AdvancedSearchPage advancedSearchPage;
	ExcelUtility reader;
	
	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		loginPage = new LoginPage();
		myNetworkListPage = loginPage.verify_login_functionality(prop.getProperty("username"), prop.getProperty("password"));
		reader = new ExcelUtility(prop.getProperty("excelFilePath"));
		networkDashBoardPage = myNetworkListPage.Open_Network_Dashboard_Page(reader.getCellData("NetworkList", 0, 3));
		advancedSearchPage = networkDashBoardPage.Open_Advanced_Search_Page();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void verify_Advanced_Search_Page_Test() {
		advancedSearchPage.verify_Advanced_Search_Page();
		Reporter.log("Advanced search page opened successfully", true);
	}
	
	@Test
	public void verify_Search_by_Companies_Test() throws Exception {
		advancedSearchPage.verify_Search_by_Companies();
	}
	
	@Test
	public void verify_Search_by_Products_Test() throws Exception {
		advancedSearchPage.verify_Search_by_Products();
	}
	
	@Test
	public void verify_Search_by_Services_Test() throws Exception {
		advancedSearchPage.verify_Search_by_Services();
	}
	
	@Test
	public void verify_Search_by_Projects_Test() throws Exception {
		advancedSearchPage.verify_Search_by_Projects();
	}
	
	/*@Test
	public void verify_Search_by_Company_sites_Test() throws Exception {
		advancedSearchPage.verify_Search_by_Company_sites();
	}
	*/
	
	@Test
	public void verify_Filter_by_Tag_option_Test() throws Exception {
		advancedSearchPage.verify_Filter_by_Tag_option(reader.getCellData("AdvancedSearch", 0, 1));
		Reporter.log("Filter by tag option is functional", true);
	}
	
	@Test
	public void verify_Filter_by_iQapture_option_Test() throws Exception {
		advancedSearchPage.verify_Filter_by_iQapture_option();
	}
	
	@Test
	public void verify_Filter_by_status_Test() throws Exception {
		advancedSearchPage.verify_Filter_by_status();
	}
	
	@Test
	public void verify_Filter_by_Current_production_and_Maximum_production_Test() throws Exception {
		advancedSearchPage.verify_Filter_by_Current_production_and_Maximum_production(
				reader.getCellData("AdvancedSearch", 0, 2), reader.getCellData("AdvancedSearch", 1, 2), 
				reader.getCellData("AdvancedSearch", 2, 2), reader.getCellData("AdvancedSearch", 3, 2));
	}
	
	@Test
	public void verify_Filter_by_Type_Test() throws Exception {
		advancedSearchPage.verify_Filter_by_Type();
	}
	
	@Test
	public void verify_Filter_by_Current_capacity_and_Maximum_capacity_Test() throws Exception {
		advancedSearchPage.verify_Filter_by_Current_capacity_and_Maximum_capacity(
				reader.getCellData("AdvancedSearch", 0, 3), reader.getCellData("AdvancedSearch", 1, 3), 
				reader.getCellData("AdvancedSearch", 2, 3), reader.getCellData("AdvancedSearch", 3, 3));
	}
	
	@Test
	public void verify_Filter_by_Funding_Source_Test() throws Exception {
		advancedSearchPage.verify_Filter_by_Funding_Source(reader.getCellData("AdvancedSearch", 0, 4));
	}
	
	@Test
	public void verify_Filter_by_Project_value_Test() throws Exception {
		advancedSearchPage.verify_Filter_by_Project_value(reader.getCellData("AdvancedSearch", 0, 5), 
				reader.getCellData("AdvancedSearch", 1, 5));
	}
	
	@Test
	public void verify_Save_favorite_search_Test() throws Exception {
		advancedSearchPage.verify_Save_favorite_search(
				reader.getCellData("AdvancedSearch", 0, 6), reader.getCellData("AdvancedSearch", 1, 6), 
				reader.getCellData("AdvancedSearch", 2, 6), reader.getCellData("AdvancedSearch", 3, 6), 
				reader.getCellData("AdvancedSearch", 4, 6));
	}
	
	@Test(dependsOnMethods="verify_Save_favorite_search_Test")
	public void verify_Remove_favorite_search_Test() throws Exception {
		advancedSearchPage.verify_Remove_favorite_search(reader.getCellData("AdvancedSearch", 4, 6));
		Reporter.log("Favorite search removed", true);
	}
	
	@Test
	public void verify_Error_message_on_saving_same_search_multiple_times_Test() throws Exception {
		advancedSearchPage.verify_Error_message_on_saving_same_search_multiple_times(
				reader.getCellData("AdvancedSearch", 0, 7));
	}
	
	@Test
	public void verify_Error_message_on_removing_saved_item_without_selecting_any_saved_item() throws Exception {
		advancedSearchPage.verify_Error_message_on_removing_saved_item_without_selecting_any_saved_item();
	}
	
	@Test
	public void verify_filter_by_BOM_Test() throws Exception {
		advancedSearchPage.verify_filter_by_BOM(reader.getCellData("AdvancedSearch", 0, 8));
	}
	
	
	
	
	
	
}
