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
import com.pages.DataCapturePage;
import com.pages.LoginPage;
import com.pages.MyNetworkListPage;
import com.pages.NetworkDashBoardPage;
import com.util.ExcelUtility;

public class DataCapturePageTest extends BasePage {
	
	LoginPage loginPage;
	MyNetworkListPage myNetworkListPage;
	NetworkDashBoardPage networkDashBoardPage;
	DataCapturePage dataCapturePage;
	ExcelUtility reader;
	
	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		loginPage = new LoginPage();
		myNetworkListPage = loginPage.verify_login_functionality(prop.getProperty("username"), prop.getProperty("password"));
		reader = new ExcelUtility(prop.getProperty("excelFilePath"));
		networkDashBoardPage = myNetworkListPage.Open_Network_Dashboard_Page(reader.getCellData("NetworkList", 0, 3));
		dataCapturePage = networkDashBoardPage.Open_Data_Capture_Page();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void verify_DataCapture_page_Test() {
		dataCapturePage.verify_DataCapture_page();
		Reporter.log("Data Capture page opened successfully", true);
	}

	@Test(dependsOnMethods = "verify_DataCapture_page_Test")
	public void verify_Create_Questionnaire_Test() {
		dataCapturePage.verify_Create_Questionnaire(reader.getCellData("DataCapture", 0, 1));
		Reporter.log("Questionnaire created successfully", true);
	}

	@Test(dependsOnMethods = "verify_DataCapture_page_Test")
	public void verify_error_message_on_creating_questionnaire_without_entering_name_Test() {
		dataCapturePage.verify_error_message_on_creating_questionnaire_without_entering_name();
		Reporter.log("'Please enter Dataset Name.' error message verified successfully", true);
	}

	@Test(dependsOnMethods = "verify_DataCapture_page_Test")
	public void verify_Upload_image_to_questionnaire_Test() throws Exception {
		dataCapturePage.verify_Upload_image_to_questionnaire(reader.getCellData("DataCapture", 0, 2),
				System.getProperty("user.dir")+"\\Files\\volvo.png");
		Reporter.log("Image uploaded to the Questionnaire successfully", true);
	}

	@Test(dependsOnMethods = "verify_DataCapture_page_Test")
	public void verify_Create_fields_Test() throws Exception {
		dataCapturePage.verify_Create_fields(reader.getCellData("DataCapture", 0, 3),
				reader.getCellData("DataCapture", 1, 3), reader.getCellData("DataCapture", 2, 3),
				reader.getCellData("DataCapture", 3, 3), reader.getCellData("DataCapture", 4, 3),
				reader.getCellData("DataCapture", 5, 3), reader.getCellData("DataCapture", 6, 3),
				reader.getCellData("DataCapture", 7, 3), reader.getCellData("DataCapture", 8, 3),
				reader.getCellData("DataCapture", 9, 3));
		Reporter.log("Fields created to the Questionnaire successfully", true);
	}

	@Test(dependsOnMethods = "verify_DataCapture_page_Test")
	public void verify_Advanced_settings_for_Text_Test() throws Exception {
		dataCapturePage.verify_Advanced_settings_for_Text(reader.getCellData("DataCapture", 0, 4),
				reader.getCellData("DataCapture", 1, 4), reader.getCellData("DataCapture", 2, 4),
				reader.getCellData("DataCapture", 3, 4), reader.getCellData("DataCapture", 4, 4),
				reader.getCellData("DataCapture", 5, 4), reader.getCellData("DataCapture", 6, 4),
				reader.getCellData("DataCapture", 7, 4), reader.getCellData("DataCapture", 8, 4),
				reader.getCellData("DataCapture", 9, 4), reader.getCellData("DataCapture", 10, 4),
				reader.getCellData("DataCapture", 11, 4), reader.getCellData("DataCapture", 12, 4),
				reader.getCellData("DataCapture", 13, 4), reader.getCellData("DataCapture", 14, 4),
				reader.getCellData("DataCapture", 15, 4));
		Reporter.log("Advanced settings for Text Questionnaire are functional", true);
	}

	@Test(dependsOnMethods = "verify_DataCapture_page_Test")
	public void verify_MultiChoice_Questionnaire_Test() throws Exception {
		dataCapturePage.verify_MultiChoice_Questionnaire(reader.getCellData("DataCapture", 0, 5),
				reader.getCellData("DataCapture", 1, 5), reader.getCellData("DataCapture", 2, 5),
				reader.getCellData("DataCapture", 3, 5), reader.getCellData("DataCapture", 4, 5),
				reader.getCellData("DataCapture", 5, 5), reader.getCellData("DataCapture", 6, 5));
		Reporter.log("MultiChoice Questionnaire created successfully", true);
	}

	@Test(dependsOnMethods = "verify_DataCapture_page_Test")
	public void verify_MultiChoice_upload_button_functionality_Test() throws Exception {
		dataCapturePage.verify_MultiChoice_upload_button_functionality(reader.getCellData("DataCapture", 0, 6),
				reader.getCellData("DataCapture", 1, 6), 
				System.getProperty("user.dir")+"\\Files\\Dropdown List Items.xlsx");
	}

	@Test(dependsOnMethods = "verify_DataCapture_page_Test")
	public void verify_Date_Questionnaire_Test() throws Exception {
		dataCapturePage.verify_Date_Questionnaire(reader.getCellData("DataCapture", 0, 7),
				reader.getCellData("DataCapture", 1, 7), reader.getCellData("DataCapture", 2, 7),
				reader.getCellData("DataCapture", 3, 7), reader.getCellData("DataCapture", 4, 7));
		Reporter.log("Date Questionnaire created successfully", true);
	}

	@Test(dependsOnMethods = "verify_DataCapture_page_Test")
	public void verify_Advanced_Settings_for_Date_Test() throws Exception {
		dataCapturePage.verify_Advanced_Settings_for_Date(reader.getCellData("DataCapture", 0, 8),
				reader.getCellData("DataCapture", 1, 8), reader.getCellData("DataCapture", 2, 8),
				reader.getCellData("DataCapture", 3, 8), reader.getCellData("DataCapture", 4, 8),
				reader.getCellData("DataCapture", 5, 8), reader.getCellData("DataCapture", 6, 8),
				reader.getCellData("DataCapture", 7, 8), reader.getCellData("DataCapture", 8, 8),
				reader.getCellData("DataCapture", 9, 8), reader.getCellData("DataCapture", 10, 8),
				reader.getCellData("DataCapture", 11, 8), reader.getCellData("DataCapture", 12, 8),
				reader.getCellData("DataCapture", 13, 8), reader.getCellData("DataCapture", 14, 8),
				reader.getCellData("DataCapture", 15, 8));
		Reporter.log("Advanced settings for date questionnaire are functional", true);
	}

	@Test(dependsOnMethods = "verify_DataCapture_page_Test")
	public void verify_Number_Questionnaire_Test() throws Exception {
		dataCapturePage.verify_Number_Questionnaire(reader.getCellData("DataCapture", 0, 9),
				reader.getCellData("DataCapture", 1, 9), reader.getCellData("DataCapture", 2, 9),
				reader.getCellData("DataCapture", 3, 9), reader.getCellData("DataCapture", 4, 9),
				reader.getCellData("DataCapture", 5, 9), reader.getCellData("DataCapture", 6, 9),
				reader.getCellData("DataCapture", 7, 9), reader.getCellData("DataCapture", 8, 9));
		Reporter.log("Number questionnaire created successfully", true);
	}

	@Test(dependsOnMethods = "verify_DataCapture_page_Test")
	public void verify_Advanced_settings_for_Number_Test() throws Exception {
		dataCapturePage.verify_Advanced_settings_for_Number(reader.getCellData("DataCapture", 0, 10),
				reader.getCellData("DataCapture", 1, 10), reader.getCellData("DataCapture", 2, 10),
				reader.getCellData("DataCapture", 3, 10), reader.getCellData("DataCapture", 4, 10),
				reader.getCellData("DataCapture", 5, 10), reader.getCellData("DataCapture", 6, 10),
				reader.getCellData("DataCapture", 7, 10), reader.getCellData("DataCapture", 8, 10),
				reader.getCellData("DataCapture", 9, 10), reader.getCellData("DataCapture", 10, 10),
				reader.getCellData("DataCapture", 11, 10), reader.getCellData("DataCapture", 12, 10),
				reader.getCellData("DataCapture", 13, 10), reader.getCellData("DataCapture", 14, 10),
				reader.getCellData("DataCapture", 15, 10));
		Reporter.log("Advanced settings for number questionnaire are functional", true);
	}

	@Test(dependsOnMethods = "verify_DataCapture_page_Test")
	public void verify_Upload_File_Questionnaire_Test() throws Exception {
		dataCapturePage.verify_Upload_File_Questionnaire(reader.getCellData("DataCapture", 0, 11),
				reader.getCellData("DataCapture", 1, 11));
		Reporter.log("Upload File questionnaire created successfully", true);
	}

	@Test(dependsOnMethods = "verify_DataCapture_page_Test")
	public void verify_Advanced_settings_for_Upload_File_Test() throws Exception {
		dataCapturePage.verify_Advanced_settings_for_Upload_File(reader.getCellData("DataCapture", 0, 12),
				reader.getCellData("DataCapture", 1, 12), reader.getCellData("DataCapture", 2, 12),
				reader.getCellData("DataCapture", 3, 12), reader.getCellData("DataCapture", 4, 12),
				reader.getCellData("DataCapture", 5, 12), reader.getCellData("DataCapture", 6, 12),
				reader.getCellData("DataCapture", 7, 12), reader.getCellData("DataCapture", 8, 12),
				reader.getCellData("DataCapture", 9, 12), reader.getCellData("DataCapture", 10, 12),
				reader.getCellData("DataCapture", 11, 12), reader.getCellData("DataCapture", 12, 12),
				reader.getCellData("DataCapture", 13, 12), reader.getCellData("DataCapture", 14, 12),
				reader.getCellData("DataCapture", 15, 12));
		Reporter.log("Advanced settings for upload file questionnaire are functional", true);
	}

	@Test(dependsOnMethods = "verify_DataCapture_page_Test")
	public void verify_Activity_Questionnaire_Test() throws Exception {
		dataCapturePage.verify_Activity_Questionnaire(reader.getCellData("DataCapture", 0, 13),
				reader.getCellData("DataCapture", 1, 13), reader.getCellData("DataCapture", 2, 13),
				reader.getCellData("DataCapture", 3, 13));
		Reporter.log("Activity questionnaire created successfully", true);
	}

	@Test(dependsOnMethods = "verify_DataCapture_page_Test")
	public void verify_Advanced_settings_for_Activity_Test() throws Exception {
		dataCapturePage.verify_Advanced_settings_for_Activity(reader.getCellData("DataCapture", 0, 14),
				reader.getCellData("DataCapture", 1, 14), reader.getCellData("DataCapture", 2, 14),
				reader.getCellData("DataCapture", 3, 14), reader.getCellData("DataCapture", 4, 14),
				reader.getCellData("DataCapture", 5, 14), reader.getCellData("DataCapture", 6, 14),
				reader.getCellData("DataCapture", 7, 14), reader.getCellData("DataCapture", 8, 14),
				reader.getCellData("DataCapture", 9, 14), reader.getCellData("DataCapture", 10, 14),
				reader.getCellData("DataCapture", 11, 14), reader.getCellData("DataCapture", 12, 14),
				reader.getCellData("DataCapture", 13, 14), reader.getCellData("DataCapture", 14, 14),
				reader.getCellData("DataCapture", 15, 14));
		Reporter.log("Advanced settings for activity questionnaire are functional", true);
	}

	@Test(dependsOnMethods = "verify_DataCapture_page_Test")
	public void verify_Advanced_Questionnaire_Test() throws Exception {
		dataCapturePage.verify_Advanced_Questionnaire(reader.getCellData("DataCapture", 0, 15),
				reader.getCellData("DataCapture", 1, 15), reader.getCellData("DataCapture", 2, 15),
				reader.getCellData("DataCapture", 3, 15), reader.getCellData("DataCapture", 4, 15),
				reader.getCellData("DataCapture", 5, 15));
		Reporter.log("Advanced - Table, Property and Wizard Questionnaires created successfully", true);
	}

	@Test(dependsOnMethods = "verify_DataCapture_page_Test")
	public void verify_Section_Questionnaire_Test() throws Exception {
		dataCapturePage.verify_Section_Questionnaire(reader.getCellData("DataCapture", 0, 16),
				reader.getCellData("DataCapture", 1, 16));
		Reporter.log("Section questionnaire created successfully", true);
	}

	@Test(dependsOnMethods = "verify_DataCapture_page_Test")
	public void verify_Advanced_settings_for_Section_Test() throws Exception {
		dataCapturePage.verify_Advanced_settings_for_Section(reader.getCellData("DataCapture", 0, 17),
				reader.getCellData("DataCapture", 1, 17), reader.getCellData("DataCapture", 2, 17),
				reader.getCellData("DataCapture", 3, 17), reader.getCellData("DataCapture", 4, 17),
				reader.getCellData("DataCapture", 5, 17), reader.getCellData("DataCapture", 6, 17),
				reader.getCellData("DataCapture", 7, 17), reader.getCellData("DataCapture", 8, 17),
				reader.getCellData("DataCapture", 9, 17), reader.getCellData("DataCapture", 10, 17),
				reader.getCellData("DataCapture", 11, 17), reader.getCellData("DataCapture", 12, 17),
				reader.getCellData("DataCapture", 13, 17), reader.getCellData("DataCapture", 14, 17),
				reader.getCellData("DataCapture", 15, 17), reader.getCellData("DataCapture", 16, 17),
				reader.getCellData("DataCapture", 17, 17), reader.getCellData("DataCapture", 18, 17),
				reader.getCellData("DataCapture", 19, 17), reader.getCellData("DataCapture", 20, 17),
				reader.getCellData("DataCapture", 21, 17), reader.getCellData("DataCapture", 22, 17));
		Reporter.log("Advanced settings for section questionnaire are functional", true);
	}

	@Test(dependsOnMethods = "verify_DataCapture_page_Test")
	public void verify_Advanced_settings_for_MiltiChoice_Radio_Test() throws Exception {
		dataCapturePage.verify_Advanced_settings_for_MiltiChoice_Radio(reader.getCellData("DataCapture", 0, 18),
				reader.getCellData("DataCapture", 1, 18), reader.getCellData("DataCapture", 2, 18),
				reader.getCellData("DataCapture", 3, 18), reader.getCellData("DataCapture", 4, 18),
				reader.getCellData("DataCapture", 5, 18), reader.getCellData("DataCapture", 6, 18),
				reader.getCellData("DataCapture", 7, 18), reader.getCellData("DataCapture", 8, 18),
				reader.getCellData("DataCapture", 9, 18), reader.getCellData("DataCapture", 10, 18),
				reader.getCellData("DataCapture", 11, 18), reader.getCellData("DataCapture", 12, 18),
				reader.getCellData("DataCapture", 13, 18), reader.getCellData("DataCapture", 14, 18),
				reader.getCellData("DataCapture", 15, 18));
		Reporter.log("Advanced settings for MutiChoice-Radio questionnaire are functional", true);
	}

	@Test(dependsOnMethods = "verify_DataCapture_page_Test")
	public void verify_Advanced_settings_for_MiltiChoice_DropDown() throws Exception {
		dataCapturePage.verify_Advanced_settings_for_MiltiChoice_DropDown(reader.getCellData("DataCapture", 0, 19),
				reader.getCellData("DataCapture", 1, 19), reader.getCellData("DataCapture", 2, 19),
				reader.getCellData("DataCapture", 3, 19), reader.getCellData("DataCapture", 4, 19),
				reader.getCellData("DataCapture", 5, 19), reader.getCellData("DataCapture", 6, 19),
				reader.getCellData("DataCapture", 7, 19), reader.getCellData("DataCapture", 8, 19),
				reader.getCellData("DataCapture", 9, 19), reader.getCellData("DataCapture", 10, 19),
				reader.getCellData("DataCapture", 11, 19), reader.getCellData("DataCapture", 12, 19),
				reader.getCellData("DataCapture", 13, 19), reader.getCellData("DataCapture", 14, 19),
				reader.getCellData("DataCapture", 15, 19));
		Reporter.log("Advanced settings for MutiChoice-DropDown questionnaire are functional", true);
	}

	@Test(dependsOnMethods = "verify_DataCapture_page_Test")
	public void verify_Advanced_settings_for_MiltiChoice_CheckBox_Test() throws Exception {
		dataCapturePage.verify_Advanced_settings_for_MiltiChoice_CheckBox(reader.getCellData("DataCapture", 0, 20),
				reader.getCellData("DataCapture", 1, 20), reader.getCellData("DataCapture", 2, 20),
				reader.getCellData("DataCapture", 3, 20), reader.getCellData("DataCapture", 4, 20),
				reader.getCellData("DataCapture", 5, 20), reader.getCellData("DataCapture", 6, 20),
				reader.getCellData("DataCapture", 7, 20), reader.getCellData("DataCapture", 8, 20),
				reader.getCellData("DataCapture", 9, 20), reader.getCellData("DataCapture", 10, 20),
				reader.getCellData("DataCapture", 11, 20), reader.getCellData("DataCapture", 12, 20),
				reader.getCellData("DataCapture", 13, 20), reader.getCellData("DataCapture", 14, 20),
				reader.getCellData("DataCapture", 15, 20), reader.getCellData("DataCapture", 16, 20),
				reader.getCellData("DataCapture", 17, 20), reader.getCellData("DataCapture", 18, 20),
				reader.getCellData("DataCapture", 19, 20), reader.getCellData("DataCapture", 20, 20),
				reader.getCellData("DataCapture", 21, 20), reader.getCellData("DataCapture", 22, 20),
				reader.getCellData("DataCapture", 23, 20), reader.getCellData("DataCapture", 24, 20),
				reader.getCellData("DataCapture", 25, 20), reader.getCellData("DataCapture", 26, 20),
				reader.getCellData("DataCapture", 27, 20), reader.getCellData("DataCapture", 28, 20),
				reader.getCellData("DataCapture", 29, 20));
		Reporter.log("Advanced settings for MutiChoice-CheckBox questionnaire are functional", true);
	}

	@Test(dependsOnMethods = "verify_DataCapture_page_Test")
	public void verify_Create_Answers_for_MultiChoice_Test() throws Exception {
		dataCapturePage.verify_Create_Answers_for_MultiChoice(reader.getCellData("DataCapture", 0, 21),
				reader.getCellData("DataCapture", 1, 21), reader.getCellData("DataCapture", 2, 21),
				reader.getCellData("DataCapture", 3, 21), reader.getCellData("DataCapture", 4, 21),
				reader.getCellData("DataCapture", 5, 21), reader.getCellData("DataCapture", 6, 21),
				reader.getCellData("DataCapture", 7, 21), reader.getCellData("DataCapture", 8, 21),
				reader.getCellData("DataCapture", 9, 21));
		Reporter.log("Answers Created for MultiChoice successfully", true);
	}

	@Test(dependsOnMethods = "verify_DataCapture_page_Test")
	public void verify_MultiChoice_Copy_Questions_functionality_Test() throws Exception {
		dataCapturePage.verify_MultiChoice_Copy_Questions_functionality(reader.getCellData("DataCapture", 0, 22),
				reader.getCellData("DataCapture", 1, 22), reader.getCellData("DataCapture", 2, 22),
				reader.getCellData("DataCapture", 3, 22), reader.getCellData("DataCapture", 4, 22),
				reader.getCellData("DataCapture", 5, 22));
		Reporter.log("Copy functionality in MultiChoice is functional", true);
	}

	@Test(dependsOnMethods = "verify_DataCapture_page_Test")
	public void verify_Download_Template_For_MultiChoice_Questionnaire_Test() throws Exception {
		dataCapturePage.verify_Download_Template_For_MultiChoice_Questionnaire(reader.getCellData("DataCapture", 0, 23),
				reader.getCellData("DataCapture", 1, 23));
	}

	@Test(dependsOnMethods = "verify_DataCapture_page_Test")
	public void verify_Rename_Questionnaire() throws Exception {
		dataCapturePage.verify_Rename_Questionnaire(reader.getCellData("DataCapture", 0, 24),
				reader.getCellData("DataCapture", 1, 24));
		Reporter.log("Questionnaire Renamed Successfully", true);
	}

	@Test(dependsOnMethods = "verify_DataCapture_page_Test")
	public void verify_Removing_Questions_From_Questionnaire_Test() throws Exception {
		dataCapturePage.verify_Removing_Questions_From_Questionnaire(reader.getCellData("DataCapture", 0, 25),
				reader.getCellData("DataCapture", 1, 25), reader.getCellData("DataCapture", 2, 25));
		Reporter.log("Questions removed from the questionnaire Successfully", true);
	}

	@Test(dependsOnMethods = "verify_DataCapture_page_Test")
	public void verify_Comment_Adding_Updating_Deleting_Test() throws Exception {
		dataCapturePage.verify_Comment_Adding_Updating_Deleting(reader.getCellData("DataCapture", 0, 26),
				reader.getCellData("DataCapture", 1, 26));
		Reporter.log("Comment Deleted Successfully", true);
	}

	@Test(dependsOnMethods = "verify_Rename_Questionnaire")
	public void verify_Delete_Questionnaire_Test() throws Exception {
		dataCapturePage.verify_Delete_Questionnaire(reader.getCellData("DataCapture", 0, 27));
		Reporter.log("Questionnaire deleted successfully", true);
	}

	@Test(dependsOnMethods = "verify_DataCapture_page_Test")
	public void verify_Settings_Score_Addition_Delete_Copy_Questionnaire_Test() throws Exception {
		dataCapturePage.verify_Settings_Score_Addition_Delete_Copy_Questionnaire(
				reader.getCellData("DataCapture", 0, 28), reader.getCellData("DataCapture", 1, 28),
				reader.getCellData("DataCapture", 2, 28), reader.getCellData("DataCapture", 3, 28),
				reader.getCellData("DataCapture", 4, 28), reader.getCellData("DataCapture", 5, 28),
				reader.getCellData("DataCapture", 6, 28), reader.getCellData("DataCapture", 7, 28),
				reader.getCellData("DataCapture", 8, 28), reader.getCellData("DataCapture", 9, 28),
				reader.getCellData("DataCapture", 10, 28), reader.getCellData("DataCapture", 11, 28),
				reader.getCellData("DataCapture", 12, 28), reader.getCellData("DataCapture", 13, 28),
				reader.getCellData("DataCapture", 14, 28));
		Reporter.log("All settings are enabled successfully", true);
	}

	@Test(dependsOnMethods = "verify_DataCapture_page_Test")
	public void verify_Settings_Score_Multiply_and_strikeout_records_Questionnaire_Test() throws Exception {
		dataCapturePage.verify_Settings_Score_Multiply_and_strikeout_records_Questionnaire(
				reader.getCellData("DataCapture", 0, 29), reader.getCellData("DataCapture", 1, 29),
				reader.getCellData("DataCapture", 2, 29), reader.getCellData("DataCapture", 3, 29),
				reader.getCellData("DataCapture", 4, 29), reader.getCellData("DataCapture", 5, 29),
				reader.getCellData("DataCapture", 6, 29), reader.getCellData("DataCapture", 7, 29),
				reader.getCellData("DataCapture", 8, 29), reader.getCellData("DataCapture", 9, 29),
				reader.getCellData("DataCapture", 10, 29), reader.getCellData("DataCapture", 11, 29),
				reader.getCellData("DataCapture", 12, 29), reader.getCellData("DataCapture", 13, 29),
				reader.getCellData("DataCapture", 14, 29), reader.getCellData("DataCapture", 15, 29));
		Reporter.log("All settings are enabled successfully", true);
	}

	@Test(dependsOnMethods = "verify_DataCapture_page_Test")
	public void verify_Settings_send_email_to_all_companies_and_selected_companies() throws Exception {
		dataCapturePage.verify_Settings_send_email_to_all_companies_and_selected_companies(
				reader.getCellData("DataCapture", 0, 30), reader.getCellData("DataCapture", 1, 30),
				reader.getCellData("DataCapture", 2, 30), reader.getCellData("DataCapture", 3, 30));
	}
	
	// .............................. Capture .......................................................

	@Test(dependsOnMethods = "verify_Activity_Questionnaire_Test")
	public void verify_Capture_Activity_Questionnaire_Test() throws Exception {
		dataCapturePage.verify_Capture_Activity_Questionnaire(reader.getCellData("DataCapture", 0, 13),
				reader.getCellData("DataCapture", 0, 40), reader.getCellData("DataCapture", 1, 40));
	}

	@Test(dependsOnMethods = "verify_Comment_Adding_Updating_Deleting_Test")
	public void verify_Complete_and_reopen_the_Questionnaire_Test() throws Exception {
		dataCapturePage.verify_Complete_and_reopen_the_Questionnaire(reader.getCellData("DataCapture", 0, 26),
				reader.getCellData("DataCapture", 0, 41));
		Reporter.log("Questionnaire completed and reopened successfully", true);
	}

	@Test(dependsOnMethods = "verify_MultiChoice_Questionnaire_Test")
	public void verify_Capture_mutichoice_Questionnaire() throws Exception {
		dataCapturePage.verify_Capture_mutichoice_Questionnaire(reader.getCellData("DataCapture", 0, 5));
	}

	@Test(dependsOnMethods = "verify_Date_Questionnaire_Test")
	public void verify_Capture_Date_Questionnaire_Test() throws Exception {
		dataCapturePage.verify_Capture_Date_Questionnaire(reader.getCellData("DataCapture", 0, 7));
	}

	@Test(dependsOnMethods = "verify_Number_Questionnaire_Test")
	public void verify_Capture_Number_Questionnaire_Test() throws Exception {
		dataCapturePage.verify_Capture_Number_Questionnaire(reader.getCellData("DataCapture", 0, 9),
				reader.getCellData("DataCapture", 0, 42), reader.getCellData("DataCapture", 1, 42),
				reader.getCellData("DataCapture", 2, 42), reader.getCellData("DataCapture", 3, 42));
	}

	@Test(dependsOnMethods = "verify_Upload_File_Questionnaire_Test")
	public void verify_Capture_Upload_Questionnaire_Test() throws Exception {
		dataCapturePage.verify_Capture_Upload_Questionnaire(reader.getCellData("DataCapture", 0, 11),
				System.getProperty("user.dir")+"\\Files\\volvo.png");
	}

	@Test(dependsOnMethods = "verify_Settings_Score_Addition_Delete_Copy_Questionnaire_Test")
	public void verify_Capture_Settings_Score_Addition_Copy_and_Delete_records_Questionnaire() throws Exception {
		dataCapturePage.verify_Capture_Settings_Score_Addition_Copy_and_Delete_records_Questionnaire(
				reader.getCellData("DataCapture", 0, 28));
	}

	@Test(dependsOnMethods = "verify_Settings_Score_Multiply_and_strikeout_records_Questionnaire_Test")
	public void verify_Capture_Settings_Score_Multiply_and_strikeout_records_Questionnaire_Test() throws Exception {
		dataCapturePage.verify_Capture_Settings_Score_Multiply_and_strikeout_records_Questionnaire(
				reader.getCellData("DataCapture", 0, 29));
	}

	@Test(dependsOnMethods = "verify_DataCapture_page_Test")
	public void verify_Download_questionnaire_template_and_Upload_answers_Test() throws Exception {
		dataCapturePage.verify_Download_questionnaire_template_and_Upload_answers(
				reader.getCellData("DataCapture", 0, 43), reader.getCellData("DataCapture", 1, 43),
				reader.getCellData("DataCapture", 2, 43), Paths.get(System.getProperty("user.home"), "Downloads").toString(), 
				reader.getCellData("DataCapture", 3, 43), System.getProperty("user.dir")+"\\Files\\Template test.xlsx");
	}
	
	@Test(dependsOnMethods = "verify_DataCapture_page_Test")
	public void verify_Create_and_capture_the_questionnaitre_for_analyse_section_Test() throws Exception {
		dataCapturePage.verify_Create_and_capture_the_questionnaitre_for_analyse_section(reader.getCellData("DataCapture", 0, 31), 
				reader.getCellData("DataCapture", 1, 31), reader.getCellData("DataCapture", 2, 31), 
				reader.getCellData("DataCapture", 3, 31), reader.getCellData("DataCapture", 4, 31), 
				reader.getCellData("DataCapture", 5, 31), reader.getCellData("DataCapture", 6, 31),	
				reader.getCellData("DataCapture", 7, 31), reader.getCellData("DataCapture", 8, 31));
	}
	
	
	
	







	

}
