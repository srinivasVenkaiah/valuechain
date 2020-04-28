/**
 * @author UmaMaheswararao
 */

package com.testcases;

import java.nio.file.Paths;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BasePage;
import com.pages.LoginPage;
import com.pages.MyNetworkListPage;
import com.pages.NetworkDashBoardPage;
import com.util.ExcelUtility;

public class NetworkDashBoardPageTest extends BasePage {
	
	LoginPage loginPage;
	MyNetworkListPage myNetworkListPage;
	NetworkDashBoardPage networkDashBoardPage;
	ExcelUtility reader;
	
	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		loginPage = new LoginPage();
		myNetworkListPage = loginPage.verify_login_functionality(prop.getProperty("username"), prop.getProperty("password"));
		reader = new ExcelUtility(prop.getProperty("excelFilePath"));
		networkDashBoardPage = myNetworkListPage.Open_Network_Dashboard_Page(reader.getCellData("NetworkList", 0, 3));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void verify_View_uploaded_companies_details_Test() throws Exception {
		networkDashBoardPage.verify_View_uploaded_companies_details();
	}
	
	@Test
	public void verify_View_What_we_do_tab_options_for_the_given_company_Test() throws Exception {
		networkDashBoardPage.verify_View_What_we_do_tab_options_for_the_given_company(reader.getCellData("NetworkDashboard", 0, 9));
	}
	
	@Test
	public void verify_View_Intelligence_tab_options_for_the_given_company_Test() throws Exception {
		networkDashBoardPage.verify_View_Intelligence_tab_options_for_the_given_company(reader.getCellData("NetworkDashboard", 0, 1));
	}
	
	@Test
	public void verify_Error_message_for_Interests_tab_without_sharing_interests_for_the_given_company_Test() throws Exception {
		networkDashBoardPage.verify_Error_message_for_Interests_tab_without_sharing_interests_for_the_given_company(
				reader.getCellData("NetworkDashboard", 0, 1), reader.getCellData("NetworkDashboard", 0, 2));
	}
	
	@Test
	public void verify_View_Collaborations_tab_options_for_the_given_company_Test() throws Exception {
		networkDashBoardPage.verify_View_Collaborations_tab_options_for_the_given_company(reader.getCellData("NetworkDashboard", 0, 1));
	}
	
	@Test
	public void verify_Add_and_Remove_tags_from_the_company_Test() throws Exception {
		networkDashBoardPage.verify_Add_and_Remove_tags_from_the_company(reader.getCellData("NetworkDashboard", 0, 1), 
				reader.getCellData("NetworkDashboard", 0, 3));
	}
	
	@Test
	public void verify_Switch_to_Invitation_mode_and_validate_the_tab_results_Test() throws Exception {
		networkDashBoardPage.verify_Switch_to_Invitation_mode_and_validate_the_tab_results();
	}
	
	@Test
	public void verify_Download_companies_template_Test() throws Exception {
		networkDashBoardPage.verify_Download_companies_template(
				Paths.get(System.getProperty("user.home"), "Downloads").toString(), 
				reader.getCellData("NetworkDashboard", 0, 4));
	}
	
	@Test
	public void verify_Upload_companies_template_Test() throws Exception {
		networkDashBoardPage.verify_Upload_companies_template(
				System.getProperty("user.dir")+"\\Files\\Company List Template2.xlsx");
	}
	
	@Test
	public void verify_manadatory_fields_error_message_while_adding_company_Test() throws Exception {
		networkDashBoardPage.verify_manadatory_fields_error_message_while_adding_company();
	}
	
	@Test
	public void verify_Add_company_to_network_Test() throws Exception {
		networkDashBoardPage.verify_Add_company_to_network(
				reader.getOrderedRandomData("NetworkDashboard", 0, 5), reader.getCellData("NetworkDashboard", 1, 5), 
				reader.getCellData("NetworkDashboard", 2, 5), reader.getCellData("NetworkDashboard", 3, 5));
	}
	
	@Test
	public void verify_Add_company_to_network_and_verify_in_Not_Connected_list_Test() throws Exception {
		networkDashBoardPage.verify_Add_company_to_network_and_verify_in_Not_Connected_list(
				reader.getOrderedRandomData("NetworkDashboard", 0, 6));
	}
	
	@Test
	public void verify_Invite_selected_company_Test() throws Exception {
		networkDashBoardPage.verify_Invite_selected_company(reader.getCellData("NetworkDashboard", 0, 8));
	}
	
	@Test(dependsOnMethods="verify_Invite_selected_company_Test")
	public void verify_Invite_all_companies_Test() throws Exception {
		networkDashBoardPage.verify_Invite_all_companies();
	}
	
	@Test(dependsOnMethods = "verify_Invite_selected_company_Test")
	public void verify_Send_invite_compnay_again_Test() throws Exception {
		networkDashBoardPage.verify_Send_invite_compnay_again();
	}
	
	@Test
	public void verify_Search_companies_from_active_companies_dashboard_Test() throws Exception {
		networkDashBoardPage.verify_Search_companies_from_active_companies_dashboard(
				reader.getCellData("NetworkDashboard", 0, 9));
	}
	
	@Test
	public void verify_Invite_fail_alert_for_the_company_which_doesnot_have_email_Test() throws Exception {
		networkDashBoardPage.verify_Invite_fail_alert_for_the_company_which_doesnot_have_email(
				reader.getOrderedRandomData("NetworkDashboard", 0, 7));
	}
	
	@Test
	public void verify_Disconnect_company_from_the_network_Test() throws Exception {
		networkDashBoardPage.verify_Disconnect_company_from_the_network(
				reader.getCellData("NetworkDashboard", 0, 8));
	}
	
	@Test
	public void verify_Radar_search_and_save_error_messages_Test() throws Exception {
		networkDashBoardPage.verify_Radar_search_error_message();
	}
	
	@Test
	public void verify_Radar_search_option_Test() throws Exception {
		networkDashBoardPage.verify_Radar_search_option(reader.getCellData("NetworkDashboard", 0, 1));
	}
	
	@Test
	public void verify_Radar_save_option_Test() throws Exception {
		networkDashBoardPage.verify_Radar_save_option(reader.getCellData("NetworkDashboard", 0, 6));
	}
	
	@Test
	public void verify_Radar_save_option_warning_alert_on_saving_already_saved_item() throws Exception {
		networkDashBoardPage.verify_Radar_save_option_warning_alert_on_saving_already_saved_item(
				reader.getCellData("NetworkDashboard", 0, 5));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
