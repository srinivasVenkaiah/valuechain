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
import com.pages.AnalysePage;
import com.pages.LoginPage;
import com.pages.MyNetworkListPage;
import com.pages.NetworkDashBoardPage;
import com.util.ExcelUtility;

public class AnalysePageTest extends BasePage {
	
	LoginPage loginPage;
	MyNetworkListPage myNetworkListPage;
	NetworkDashBoardPage networkDashBoardPage;
	AnalysePage analysePage;
	ExcelUtility reader;
	
	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		loginPage = new LoginPage();
		myNetworkListPage = loginPage.verify_login_functionality(prop.getProperty("username"), prop.getProperty("password"));
		reader = new ExcelUtility(prop.getProperty("excelFilePath"));
		networkDashBoardPage = myNetworkListPage.Open_Network_Dashboard_Page(reader.getCellData("NetworkList", 0, 3));
		analysePage = networkDashBoardPage.Open_Analyse_Page();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void verify_AnalysePage_Test() {
		analysePage.verify_AnalysePage();
	}

	@Test(dependsOnMethods="verify_AnalysePage_Test")
	public void verify_prompt_message_for_invalid_search_Test() {
		analysePage.verify_prompt_message_for_invalid_search();
		Reporter.log("Prompt message displayed for invalid search", true);
	}

	@Test(dependsOnMethods="verify_AnalysePage_Test")
	public void verify_Add_table_design_report_Test() {
		analysePage.verify_Add_table_design_report(reader.getCellData("Analyse", 0, 1));
		Reporter.log("Table design report created successfully", true);
	}

	@Test(dependsOnMethods="verify_Export_report_to_excel_Test")
	public void verify_Delete_given_report_Test() {
		analysePage.verify_Delete_given_report(reader.getCellData("Analyse", 0, 1));
		Reporter.log("Report deleted successfully", true);
	}

	@Test(dependsOnMethods="verify_AnalysePage_Test")
	public void verify_report_name_field_mandatory_message_Test() {
		analysePage.verify_report_name_field_mandatory_message(reader.getCellData("Analyse", 0, 2));
		Reporter.log("Report name field mandatory message successfully", true);
	}

	@Test(dependsOnMethods="verify_AnalysePage_Test")
	public void verify_Saved_failed_message_for_the_duplicate_report_creation_Test() throws Exception {
		analysePage.verify_Saved_failed_message_for_the_duplicate_report_creation(reader.getCellData("Analyse", 0, 3));
		Reporter.log("Saved failed message displayed successfully for the duplicate report creation", true);
	}

	@Test(dependsOnMethods="verify_AnalysePage_Test")
	public void verify_Delete_table_column_Test() {
		analysePage.verify_Delete_table_column(reader.getCellData("Analyse", 0, 4));
		Reporter.log("Table Column deleted successfully", true);
	}

	@Test(dependsOnMethods="verify_AnalysePage_Test")
	public void verify_Swapping_columns_Test() {
		analysePage.verify_Swapping_columns(reader.getCellData("Analyse", 0, 5));
		Reporter.log("Columns headers and content are swapped successfully", true);
	}

	@Test(dependsOnMethods="verify_AnalysePage_Test")
	public void verify_Add_BarChart_design_report_Test() throws Exception {
		analysePage.verify_Add_BarChart_design_report(reader.getCellData("Analyse", 0, 6), 
				reader.getCellData("Analyse", 1, 6), reader.getCellData("Analyse", 2, 6),
				reader.getCellData("Analyse", 3, 6), reader.getCellData("Analyse", 4, 6),
				reader.getCellData("Analyse", 5, 6), reader.getCellData("Analyse", 6, 6));
		Reporter.log("BarChart created successfully", true);
	}

	@Test(dependsOnMethods="verify_AnalysePage_Test")
	public void verify_Add_PieChart_design_report_Test() throws Exception {
		analysePage.verify_Add_PieChart_design_report(reader.getCellData("Analyse", 0, 7), 
				reader.getCellData("Analyse", 1, 7), reader.getCellData("Analyse", 2, 7),
				reader.getCellData("Analyse", 3, 7), reader.getCellData("Analyse", 4, 7),
				reader.getCellData("Analyse", 5, 7));
		Reporter.log("PieChart created successfully", true);
	}

	@Test(dependsOnMethods="verify_AnalysePage_Test")
	public void verify_Drop_sort_field_Ascending_and_Descending_order_Test() throws Exception {
		analysePage.verify_Drop_sort_field_Ascending_and_Descending_order(reader.getCellData("Analyse", 0, 8), 
				reader.getCellData("Analyse", 1, 8));
		Reporter.log("Dropped field sorted in order successfully", true);
	}

	@Test(dependsOnMethods="verify_AnalysePage_Test")
	public void verify_filter_option_and_Conditional_operation_Test() throws Exception {
		analysePage.verify_filter_option_and_Conditional_operation(reader.getCellData("Analyse", 0, 9), 
				reader.getCellData("Analyse", 1, 9), reader.getCellData("Analyse", 2, 9));
		Reporter.log("Given field is filtered successfully and Conditional operators are functional", true);
	}

	@Test(dependsOnMethods="verify_Add_table_design_report_Test")
	public void verify_Export_report_to_excel_Test() throws Exception {
		analysePage.verify_Export_report_to_excel(reader.getCellData("Analyse", 0, 1), 
				Paths.get(System.getProperty("user.home"), "Downloads").toString());
		Reporter.log("Report exported to excel successfully", true);
	}



















































}
