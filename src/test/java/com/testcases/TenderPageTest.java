package com.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BasePage;
import com.pages.LoginPage;
import com.pages.MyNetworkListPage;
import com.pages.NetworkDashBoardPage;
import com.pages.ProductsPage;
import com.pages.TenderPage;
import com.util.ExcelUtility;

public class TenderPageTest extends BasePage{
	LoginPage loginPage;
	MyNetworkListPage myNetworkListPage;
	NetworkDashBoardPage networkDashBoardPage;
	ExcelUtility reader;
	TenderPage tenderPage;
	
	
	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		loginPage = new LoginPage();
		myNetworkListPage = loginPage.verify_login_functionality(prop.getProperty("username"), prop.getProperty("password"));
		reader = new ExcelUtility(prop.getProperty("excelFilePath"));
		networkDashBoardPage = myNetworkListPage.Open_Network_Dashboard_Page(reader.getCellData("NetworkList", 0, 5));
		tenderPage = networkDashBoardPage.open_TenderPage();
	}
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
		
	@Test
	public void createTender_Test() throws Exception {
		tenderPage.createTender(reader.getOrderedRandomData("Tender", 0, 2), System.getProperty("user.dir")+"\\Files\\Tender.xlsx", reader.getCellData("Tender", 1, 2));
	}
	
	@Test(dependsOnMethods="createTender_Test")
	public void submit_SendRFQ_Tender_Test() {
		tenderPage.submit_SendRFQ_Tender(reader.getCellData("Tender", 0, 2), reader.getCellData("Tender", 2, 2));
	}
	
	@Test(dependsOnMethods="submit_SendRFQ_Tender_Test")
	public void verify_RFQ_InTestUser1_Test() throws Exception {
		tenderPage.verify_RFQ_InTestUser1(reader.getCellData("Tender", 3, 2), reader.getCellData("Tender", 4, 2), reader.getCellData("Tender", 0, 2));
	}
	
	@Test(dependsOnMethods="verify_RFQ_InTestUser1_Test")
	public void acknowledge_RFQ_Test() throws Exception {
		tenderPage.acknowledge_RFQ(reader.getCellData("Tender", 3, 2), reader.getCellData("Tender", 4, 2), reader.getCellData("Tender", 0, 2), 
				System.getProperty("user.dir")+"\\files\\TenderAcknowledgeFile.docx", reader.getCellData("Tender", 5, 2));
	}
	
	@Test(dependsOnMethods="acknowledge_RFQ_Test")
	public void verify_AckAndResponse_Test() {
		tenderPage.verify_AckAndResponse(reader.getCellData("Tender", 0, 2), reader.getCellData("Tender", 2, 2), reader.getCellData("Tender", 5, 2));
	}
	
	@Test(dependsOnMethods="verify_AckAndResponse_Test")
	public void selectTender_Test() {
		tenderPage.selectTender(reader.getCellData("Tender", 0, 2));
	}
	
	@Test(dependsOnMethods="createTender_Test")
	public void closeTender_Test() {
		tenderPage.closeTender(reader.getOrderedRandomData("Tender", 0, 3));
	}
	
	@Test(dependsOnMethods="createTender_Test")
	public void deleteTender_Test() {
		tenderPage.deleteTender(reader.getCellData("Tender", 0, 1));
	}
	
	@Test(dependsOnMethods="createTender_Test")
	public void RejectTender_Test() throws Exception {
		tenderPage.RejectTender(reader.getOrderedRandomData("Tender", 0, 5), reader.getCellData("Tender", 2, 2), reader.getCellData("Tender", 3, 2), 
				reader.getCellData("Tender", 4, 2), System.getProperty("user.dir")+"\\files\\Reject.docx", reader.getCellData("Tender", 5, 2));
	}
	
	@Test(dependsOnMethods="RejectTender_Test")
	public void verify_Rejected_tender_Test() {
		tenderPage.verify_Rejected_tender(reader.getCellData("Tender", 0, 5));
	}
	
	@Test(enabled=false)
	public void FilterSupplierByTag_DataCapture_Test() throws Exception {
		tenderPage.FilterSupplierByTag_DataCapture(reader.getCellData("Tender", 0, 6), reader.getCellData("Tender", 1, 6));
	}
	
	
	
}
