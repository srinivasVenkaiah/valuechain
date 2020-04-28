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
import com.pages.ProductsPage;
import com.util.ExcelUtility;

public class ProductsPageTest extends BasePage {
	
	LoginPage loginPage;
	MyNetworkListPage myNetworkListPage;
	NetworkDashBoardPage networkDashBoardPage;
	ProductsPage productsPage;
	ExcelUtility reader;
	
	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		loginPage = new LoginPage();
		myNetworkListPage = loginPage.verify_login_functionality(prop.getProperty("username"), prop.getProperty("password"));
		reader = new ExcelUtility(prop.getProperty("excelFilePath"));
		networkDashBoardPage = myNetworkListPage.Open_Network_Dashboard_Page(reader.getCellData("NetworkList", 0, 3));
		productsPage = networkDashBoardPage.Open_Products_Page();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void verify_Products_page_Test() {
		productsPage.verify_Products_page();
		Reporter.log("Products page opened successfully", true);
	}
	
	@Test(dependsOnMethods="verify_Products_page_Test")
	public void verify_Create_new_product_Test() {
		productsPage.verify_Create_new_product(reader.getOrderedRandomData("Products", 0, 1), 
				reader.getCellData("Products", 1, 1), reader.getCellData("Products", 2, 1), 
				reader.getCellData("Products", 3, 1), reader.getCellData("Products", 4, 1), 
				reader.getCellData("Products", 5, 1), reader.getCellData("Products", 6, 1),
				reader.getCellData("Products", 7, 1), reader.getCellData("Products", 8, 1),
				reader.getCellData("Products", 9, 1), reader.getCellData("Products", 10, 1));
		Reporter.log("Product created successfully", true);
	}
	
	@Test(dependsOnMethods="verify_Products_page_Test")
	public void verify_Add_Detail_spec_to_the_product_Test() throws Exception {
		productsPage.verify_Add_Detail_spec_to_the_product(reader.getOrderedRandomData("Products", 0, 2),  
				reader.getCellData("Products", 1, 2), reader.getCellData("Products", 2, 2), 
				reader.getCellData("Products", 3, 2), reader.getCellData("Products", 4, 2), 
				System.getProperty("user.dir")+"\\Files\\wheel.jpg", reader.getCellData("Products", 5, 2));
		Reporter.log("Detail spec added to product successfully", true);
	}
	
	@Test(dependsOnMethods="verify_Products_page_Test")
	public void verify_Documents_tab_and_Upload_file_or_picture_Test() throws Exception {
		productsPage.verify_Documents_tab_and_Upload_file_or_picture(reader.getOrderedRandomData("Products", 0, 3), 
				reader.getCellData("Products", 1, 3), System.getProperty("user.dir")+"\\Files\\volvo.png", 
				System.getProperty("user.dir")+"\\Files\\test.jpeg", reader.getCellData("Products", 2, 3), 
				reader.getCellData("Products", 3, 3), System.getProperty("user.dir")+"\\Files\\Empty Report.xlsx");
		Reporter.log("Decument tab verified and file or picture uploaded successfully", true);
	}
	
	@Test(dependsOnMethods="verify_Products_page_Test")
	public void verify_Search_the_required_product_and_delete_the_product_Test() throws Exception {
		productsPage.verify_Search_the_required_product_and_delete_the_product(reader.getCellData("Products", 0, 4));
		Reporter.log("Given product searched and Deleted successfully", true);
	}
	
	@Test(dependsOnMethods="verify_Products_page_Test")
	public void verify_Download_Products_template_Test() throws Exception {
		productsPage.verify_Download_Products_template(Paths.get(System.getProperty("user.home"), "Downloads").toString(), 
				reader.getCellData("Products", 0, 5));
	}
	
	@Test(dependsOnMethods="verify_Products_page_Test")
	public void verify_Upload_Template_Test() throws Exception {
		productsPage.verify_Upload_Template(System.getProperty("user.dir")+"\\Files\\Products List Template.xlsx", "Demo Product 1");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	


	
	
}
