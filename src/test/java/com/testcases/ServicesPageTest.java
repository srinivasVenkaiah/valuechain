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
import com.pages.MyNetworkListPage;
import com.pages.NetworkDashBoardPage;
import com.pages.ServicesPage;
import com.util.ExcelUtility;

public class ServicesPageTest extends BasePage {
	
	LoginPage loginPage;
	MyNetworkListPage myNetworkListPage;
	NetworkDashBoardPage networkDashBoardPage;
	ServicesPage servicesPage;
	ExcelUtility reader;
	
	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		loginPage = new LoginPage();
		myNetworkListPage = loginPage.verify_login_functionality(prop.getProperty("username"), prop.getProperty("password"));
		reader = new ExcelUtility(prop.getProperty("excelFilePath"));
		networkDashBoardPage = myNetworkListPage.Open_Network_Dashboard_Page(reader.getCellData("NetworkList", 0, 3));
		servicesPage = networkDashBoardPage.Open_Services_Page();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void verify_Services_page_Test() {
		servicesPage.verify_Services_page();
		Reporter.log("Services page opened successfully", true);
	}
	
	@Test(dependsOnMethods="verify_Services_page_Test")
	public void verify_Create_new_service_Test() {
		servicesPage.verify_Create_new_service(reader.getOrderedRandomData("Services", 0, 1), 
				reader.getCellData("Services", 1, 1), reader.getCellData("Services", 2, 1), 
				reader.getCellData("Services", 3, 1), reader.getCellData("Services", 4, 1), 
				reader.getCellData("Services", 5, 1), reader.getCellData("Services", 6, 1),
				reader.getCellData("Services", 7, 1), reader.getCellData("Services", 8, 1),
				reader.getCellData("Services", 9, 1), reader.getCellData("Services", 10, 1));
		Reporter.log("Service created successfully", true);
	}
	
	@Test(dependsOnMethods="verify_Services_page_Test")
	public void verify_Add_Detail_spec_to_the_service_Test() throws Exception {
		servicesPage.verify_Add_Detail_spec_to_the_service(reader.getOrderedRandomData("Services", 0, 2),  
				reader.getCellData("Services", 1, 2), reader.getCellData("Services", 2, 2), 
				reader.getCellData("Services", 3, 2), reader.getCellData("Services", 4, 2), 
				System.getProperty("user.dir")+"\\Files\\wheel.jpg", reader.getCellData("Services", 5, 2));
		Reporter.log("Detail spec added to service successfully", true);
	}
	
	@Test(dependsOnMethods="verify_Services_page_Test")
	public void verify_Documents_tab_and_Upload_file_or_picture_Test() throws Exception {
		servicesPage.verify_Documents_tab_and_Upload_file_or_picture(reader.getOrderedRandomData("Services", 0, 3), 
				reader.getCellData("Services", 1, 3), System.getProperty("user.dir")+"\\Files\\volvo.png", 
				System.getProperty("user.dir")+"\\Files\\test.jpeg", reader.getCellData("Services", 2, 3), 
				reader.getCellData("Services", 3, 3), System.getProperty("user.dir")+"\\Files\\Empty Report.xlsx");
		Reporter.log("Decument tab verified and file or picture uploaded successfully", true);
	}
	
	@Test(dependsOnMethods="verify_Services_page_Test")
	public void verify_Search_the_required_service_and_delete_the_service_Test() throws Exception {
		servicesPage.verify_Search_the_required_service_and_delete_the_service(reader.getCellData("Services", 0, 4));
		Reporter.log("Given service searched and Deleted successfully", true);
	}
	
	@Test(dependsOnMethods="verify_Services_page_Test")
	public void verify_Download_Services_template_Test() throws Exception {
		servicesPage.verify_Download_Services_template(Paths.get(System.getProperty("user.home"), "Downloads").toString(), 
				reader.getCellData("Services", 0, 5));
	}
	
	@Test(dependsOnMethods="verify_Services_page_Test")
	public void verify_Upload_Template_Test() throws Exception {
		servicesPage.verify_Upload_Template(System.getProperty("user.dir")+"\\Files\\Services List Template.xlsx", "Service 1");
	}
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	


	
	
}
