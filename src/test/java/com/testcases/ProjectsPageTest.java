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
import com.pages.ProjectsPage;
import com.util.ExcelUtility;

public class ProjectsPageTest extends BasePage {
	
	LoginPage loginPage;
	MyNetworkListPage myNetworkListPage;
	NetworkDashBoardPage networkDashBoardPage;
	ProjectsPage projectsPage;
	ExcelUtility reader;
	
	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		loginPage = new LoginPage();
		myNetworkListPage = loginPage.verify_login_functionality(prop.getProperty("username"), prop.getProperty("password"));
		reader = new ExcelUtility(prop.getProperty("excelFilePath"));
		networkDashBoardPage = myNetworkListPage.Open_Network_Dashboard_Page(reader.getCellData("NetworkList", 0, 3));
		projectsPage = networkDashBoardPage.Open_Projects_Page();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void verify_Projects_page_Test() {
		projectsPage.verify_Projects_page();
		Reporter.log("Projects page opened successfully", true);
	}

	@Test(dependsOnMethods="verify_Projects_page_Test")
	public void verify_Create_new_project_Test() throws Exception {
		projectsPage.verify_Create_new_project(reader.getOrderedRandomData("Projects", 0, 1), 
				reader.getCellData("Projects", 1, 1), reader.getCellData("Projects", 2, 1), 
				reader.getCellData("Projects", 3, 1), reader.getCellData("Projects", 4, 1), 
				reader.getCellData("Projects", 5, 1), reader.getCellData("Projects", 6, 1), 
				reader.getCellData("Projects", 7, 1), reader.getCellData("Projects", 8, 1), 
				reader.getCellData("Projects", 9, 1), reader.getCellData("Projects", 10, 1));
		Reporter.log("Project created successfully", true);
	}

	@Test(dependsOnMethods="verify_Projects_page_Test")
	public void verify_Add_Detail_spec_to_the_project_Test() throws Exception {
		projectsPage.verify_Add_Detail_spec_to_the_project(reader.getOrderedRandomData("Projects", 0, 2),  
				reader.getCellData("Projects", 1, 2), reader.getCellData("Projects", 2, 2), 
				reader.getCellData("Projects", 3, 2), reader.getCellData("Projects", 4, 2), 
				System.getProperty("user.dir")+"\\Files\\wheel.jpg", reader.getCellData("Projects", 5, 2));
		Reporter.log("Detail spec added to project successfully", true);
	}

	@Test(dependsOnMethods="verify_Projects_page_Test")
	public void verify_Documents_tab_and_Upload_file_or_picture_Test() throws Exception {
		projectsPage.verify_Documents_tab_and_Upload_file_or_picture(reader.getOrderedRandomData("Projects", 0, 3), 
				reader.getCellData("Projects", 1, 3), System.getProperty("user.dir")+"\\Files\\volvo.png", 
				System.getProperty("user.dir")+"\\Files\\test.jpeg", reader.getCellData("Projects", 2, 3), 
				reader.getCellData("Projects", 3, 3), System.getProperty("user.dir")+"\\Files\\Empty Report.xlsx");
		Reporter.log("Decument tab verified and file or picture uploaded successfully", true);
	}
























	

}
