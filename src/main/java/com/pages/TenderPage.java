package com.pages;

import java.awt.RenderingHints.Key;
import java.nio.file.DirectoryStream.Filter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.base.BasePage;
import com.util.ActionUtils;
import com.util.AjaxLibrary;

public class TenderPage extends BasePage{
	//initialization
	public TenderPage() {
		PageFactory.initElements(driver, this);
	}
	
	// Object Repository
	
	
	// Settings section checked
	@FindBy(xpath="(//span[contains(.,'Network Dashboard')])[2]//preceding::input[1]")
	WebElement cb_NetworkDashboard;

	@FindBy(xpath="(//span[contains(.,'Personalised Dashboard')])[2]//preceding::input[1]")
	WebElement cb_PersonalisedDashboard;

	@FindBy(xpath="(//span[contains(.,'Advanced Search')])[3]//preceding::input[1]")
	WebElement cb_AdvancedSearch;

	@FindBy(xpath="(//span[contains(.,'Explore')])[3]//preceding::input[1]")
	WebElement cb_Explore;

	@FindBy(xpath="(//span[contains(.,'Map')])[3]//preceding::input[1]")
	WebElement cb_Map;

	@FindBy(xpath="(//span[contains(.,'Location Map')])[2]//preceding::input[1]")
	WebElement cb_LocationMap;

	@FindBy(xpath="(//span[contains(.,'Data Capture')])[2]//preceding::input[1]")
	WebElement cb_DataCapture;

	@FindBy(xpath="(//span[contains(.,'Analyse')])[2]//preceding::input[1]")
	WebElement cb_Analyse;
	
	By CreateTender = By.xpath("//span[contains(.,'Add')]");
	By TenderTitleBox = By.xpath("//input[contains(@title,'Tender title')]");
	By TenderUploadFile = By.xpath("//div[text()='Choose a file or drag it here']");
	By TenderContentBox = By.xpath("//div[@class='note-editable panel-body']");
	By SaveTender = By.xpath("//a[@id='btnSaveTender']");
	By SubmitTender = By.xpath("//a[@id='btnSubmitTender']");
	By TenderCloseBtn = By.xpath("//a[text()='Close']");
	By TenderSearchBox = By.xpath("//input[@id='txtSearch']");
	By TenderSearchBtn = By.xpath("//span[text()='Search']");
	By TenderYes = By.xpath("//button[text()='Yes']");
	By TenderSupplier = By.xpath("//a[text()='Select Suppliers']");
	By SupplierSearchBox = By.xpath("//input[@id='txtSearchCompany']");
	By SupplierSearch = By.xpath("//a[text()='Search']");
	By SupplierCheckBox = By.xpath("//input[@type='checkbox']");
	By SaveSupplier = By.xpath("//a[@onclick='TenderList.saveSuppliers()']");
	By CloseSupplier = By.xpath("(//a[text()='Close'])[2]");
	By SendRFQ = By.xpath("//a[@onclick='TenderList.sendRFQ()']");
	By TenderAcknowledge = By.xpath("//a[text()='Acknowledge']");
	By AcknowledgeFile = By.xpath("(//div[text()='Choose a file or drag it here'])[2]");
	By RejectFile = By.xpath("(//div[text()='Choose a file or drag it here'])[2]");
	By Response = By.xpath("//div[@class='note-editable panel-body']");
	By ResponseSave = By.xpath("//a[@id='btnResponseSave']");
	By ResponseSubmit = By.xpath("(//span[text()='SUBMIT'])[2]");
	By CloseTender = By.xpath("//span[text()='Close This Tender']");
	By DeleteTender = By.xpath("//a[@id='btnDelete']");
	By TenderFilter = By.xpath("//a[@id='ShowFilters']");
	By TenderType = By.xpath("//Select[@id='ddlFilter']");
	By TenderView = By.xpath("//button[contains(.,'View')]");
	By TenderSelect = By.xpath("//button[text()='Select']");
	By TenderReject = By.xpath("//a[text()='Reject']");
	By RejectSubmit = By.xpath("(//span[text()='SUBMIT'])[2]");
	By FilterSupplier = By.xpath("//a[@id='btnFilter']");
	By TagSelectBox1 = By.xpath("//select[@id='ddlPSTags']");
	By TagselectBox2 = By.xpath("//input[@class='select2-search__field']");
	By FilterClose = By.xpath("//button[@id='btnCloseFilterDlg']");
	By RemoveTag = By.xpath("//button[@title='Remove']");
	By DataCaptureClose = By.xpath("(//button[text()='Close'])[5]");
	By DataCaptureEdit = By.xpath("//button[@title='Edit']");
	By QuestionDlgClose = By.xpath("//button[@onclick='TenderList.cancelIQFilterEditDlg()']");
	By QuestionRemove = By.xpath("//i[@class='fa fa-close']");
	
	
	//Login into Test user1 - TC26 company
	By johnSmithAcc = By.xpath("//span[text()='John Smith ']");
	By MyAccount = By.xpath("//a[contains(.,'myAccount')]");
	By LoginAs = By.xpath("//span[@class='title'][contains(.,'Log in as')]");
	//By SearchEmailBox = By.xpath("//input[contains(@placeholder,'Search...')]");
	
	@FindBy(xpath="//input[contains(@placeholder,'Search...')]")
	WebElement SearchEmailBox;
	
	By ReLogin = By.xpath("//span[text()='Re Login ']");
	By MyCompanies = By.xpath("//span[contains(.,'myCompanies')]");
	
	
	public void createTender(String TenderName, String filePath, String TenderProfile) throws Exception {
		SoftAssert a = new SoftAssert();
		ActionUtils.ajaxJsClick(driver, CreateTender);
		ActionUtils.ajaxJsType(driver, TenderTitleBox, TenderName);
		ActionUtils.uploadFile(driver, TenderUploadFile, filePath);
		Thread.sleep(1000);
		ActionUtils.ajaxJsType(driver, TenderContentBox, TenderProfile);
		ActionUtils.ajaxJsClick(driver, SaveTender);
		a.assertTrue(ActionUtils.getElement(driver, By.xpath("(//div[contains(.,'×CloseSave succeed.')])[12]")).isDisplayed(), "Tender Not Saved");
		Reporter.log("Tender Saved",true);
		ActionUtils.ajaxJsClick(driver, TenderCloseBtn);
		Thread.sleep(1000);
		ActionUtils.ajaxJsType(driver, TenderSearchBox, TenderName);
		ActionUtils.ajaxJsClick(driver, TenderSearchBtn);
		a.assertTrue(ActionUtils.getElement(driver, By.xpath("//td[text()='"+TenderName+"']")).isDisplayed(), "Tender not saved");
		Reporter.log("Tender Saved",true);
		a.assertAll();
	}
	
	public void submit_SendRFQ_Tender(String TenderName, String CompanyName) {
		SoftAssert a = new SoftAssert();
		ActionUtils.ajaxJsType(driver, TenderSearchBox, TenderName);
		ActionUtils.ajaxJsClick(driver, TenderSearchBtn);
		ActionUtils.ajaxJsClick(driver, By.xpath("//td[text()='"+TenderName+"']"));
		ActionUtils.ajaxJsClick(driver, SubmitTender);
		String submitMsg = ActionUtils.readText(driver, By.xpath("//div[text()='Are you sure to submit it?']"));
		String expectedMsg = "Are you sure to submit it?";
		a.assertEquals(submitMsg, expectedMsg, "Submit confirmation message not displayed");
		Reporter.log("Submit confirmation message displayed",true);
		ActionUtils.ajaxJsClick(driver, TenderYes);
		// Check already supplier added or not
		a.assertTrue(ActionUtils.getElement(driver, By.xpath("//td[text()='No matching records found']")).isDisplayed(), "Supplier Added");
		Reporter.log("Supplier not added",true);
		ActionUtils.ajaxJsClick(driver, TenderSupplier);
		ActionUtils.ajaxJsType(driver, SupplierSearchBox, CompanyName);
		ActionUtils.ajaxJsClick(driver, SupplierSearch);
		ActionUtils.ajaxJsClick(driver, SupplierCheckBox);
		ActionUtils.ajaxJsClick(driver, SaveSupplier);
		ActionUtils.ajaxJsClick(driver, SendRFQ);
		ActionUtils.ajaxJsClick(driver, TenderYes);
		a.assertTrue(ActionUtils.getElement(driver, By.xpath("//td[text()='"+CompanyName+"']//following::i[@class='fa fa-check']")).isDisplayed(), "RFQ not Sent");
		Reporter.log("RFQ sent",true);
	}
	
	public void verify_RFQ_InTestUser1(String UserName, String NetworkName, String TenderName) throws Exception {
		ActionUtils.hoverToElement(driver, johnSmithAcc);
		ActionUtils.ajaxJsClick(driver, MyAccount);
		ActionUtils.ajaxJsClick(driver, LoginAs);
		ActionUtils.ajaxJsClick(driver, SearchEmailBox);
		SearchEmailBox.sendKeys(UserName);
		SearchEmailBox.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		ActionUtils.ajaxJsClick(driver, By.xpath("//td[text()='"+UserName+"']"));
		ActionUtils.ajaxJsClick(driver, ReLogin);
		Thread.sleep(1000);
		ActionUtils.ajaxJsClick(driver, LoginPage.menuBtn);
		ActionUtils.ajaxJsClick(driver, LoginPage.iQlusterApp);
		ActionUtils.hoverToElement(driver, By.xpath("//span[text()='TC User 1 ']"));
		ActionUtils.ajaxJsClick(driver, MyCompanies);
		ActionUtils.ajaxJsClick(driver, By.xpath("//span[text()='TC26 ']"));
		Thread.sleep(1000);
		ActionUtils.ajaxJsClick(driver, By.xpath("//h3[text()='"+NetworkName+"']"));
		ActionUtils.ajaxJsClick(driver, NetworkDashBoardPage.TenderLink);
		Assert.assertTrue(ActionUtils.getElement(driver, By.xpath("//td[text()='"+TenderName+"']")).isDisplayed(), "RFQ not recived in user account");
		Reporter.log("RFQ received",true);
	}
	
	public void acknowledge_RFQ(String UserName, String NetworkName, String TenderName, String filePath, String Value) throws Exception {
		ActionUtils.hoverToElement(driver, johnSmithAcc);
		ActionUtils.ajaxJsClick(driver, MyAccount);
		ActionUtils.ajaxJsClick(driver, LoginAs);
		ActionUtils.ajaxJsClick(driver, SearchEmailBox);
		SearchEmailBox.sendKeys(UserName);
		SearchEmailBox.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		ActionUtils.ajaxJsClick(driver, By.xpath("//td[text()='"+UserName+"']"));
		ActionUtils.ajaxJsClick(driver, ReLogin);
		Thread.sleep(1000);
		ActionUtils.ajaxJsClick(driver, LoginPage.menuBtn);
		ActionUtils.ajaxJsClick(driver, LoginPage.iQlusterApp);
		ActionUtils.hoverToElement(driver, By.xpath("//span[text()='TC User 1 ']"));
		ActionUtils.ajaxJsClick(driver, MyCompanies);
		ActionUtils.ajaxJsClick(driver, By.xpath("//span[text()='TC26 ']"));
		Thread.sleep(1000);
		ActionUtils.ajaxJsClick(driver, By.xpath("//h3[text()='"+NetworkName+"']"));
		ActionUtils.ajaxJsClick(driver, NetworkDashBoardPage.TenderLink);
		ActionUtils.ajaxJsClick(driver, By.xpath("//td[text()='"+TenderName+"']"));
		ActionUtils.ajaxJsClick(driver, TenderAcknowledge);
		ActionUtils.uploadFile(driver, AcknowledgeFile, filePath);
		ActionUtils.sendKeys(driver, Response, Value);
		ActionUtils.ajaxJsClick(driver, ResponseSubmit);
		ActionUtils.ajaxJsClick(driver, TenderYes);
	}
	
	public void verify_AckAndResponse(String TenderName, String CompanyName, String Value) {
		SoftAssert a = new SoftAssert();
		ActionUtils.ajaxJsType(driver, TenderSearchBox, TenderName);
		ActionUtils.ajaxJsClick(driver, TenderSearchBtn);
		ActionUtils.ajaxJsClick(driver, By.xpath("//td[text()='"+TenderName+"']"));
		a.assertTrue(ActionUtils.getElement(driver, By.xpath("(//td[text()='"+CompanyName+"']//following::i[@class='fa fa-check'])[2]")).isDisplayed(), "Acknowledge failed");
		Reporter.log("Tender Acknowledged",true);
		a.assertTrue(ActionUtils.getElement(driver, By.xpath("(//td[text()='"+CompanyName+"']//following::i[@class='fa fa-check'])[3]")).isDisplayed(), "Response not Received");
		Reporter.log("Response Received",true);
		ActionUtils.ajaxJsClick(driver, TenderView);
		a.assertTrue(ActionUtils.getElement(driver, By.xpath("//label[text()='Response:']//following::div[contains(.,'"+Value+"')]")).isDisplayed(), "Response not displayed");
		Reporter.log("Response displayed",true);
		a.assertAll();
	}
	
	public void selectTender(String TenderName) {
		ActionUtils.ajaxJsType(driver, TenderSearchBox, TenderName);
		ActionUtils.ajaxJsClick(driver, TenderSearchBtn);
		ActionUtils.ajaxJsClick(driver, By.xpath("//td[text()='"+TenderName+"']"));
		ActionUtils.ajaxJsClick(driver, TenderSelect);
		ActionUtils.ajaxJsClick(driver, TenderYes);
		Assert.assertTrue(ActionUtils.getElement(driver, By.xpath("//div[text()='Selected']")).isDisplayed(), "Tender not selected");
		Reporter.log("Tender Selected",true);
	}
	
	public void check_Status_Of_Selected_Tender(CharSequence UserName, String NetworkName, String TenderName) throws Exception {
		ActionUtils.hoverToElement(driver, johnSmithAcc);
		ActionUtils.ajaxJsClick(driver, MyAccount);
		ActionUtils.ajaxJsClick(driver, LoginAs);
		ActionUtils.ajaxJsClick(driver, SearchEmailBox);
		SearchEmailBox.sendKeys(UserName);
		SearchEmailBox.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		ActionUtils.ajaxJsClick(driver, By.xpath("//td[text()='"+UserName+"']"));
		ActionUtils.ajaxJsClick(driver, ReLogin);
		Thread.sleep(1000);
		ActionUtils.ajaxJsClick(driver, LoginPage.menuBtn);
		ActionUtils.ajaxJsClick(driver, LoginPage.iQlusterApp);
		ActionUtils.hoverToElement(driver, By.xpath("//span[text()='TC User 1 ']"));
		ActionUtils.ajaxJsClick(driver, MyCompanies);
		ActionUtils.ajaxJsClick(driver, By.xpath("//span[text()='TC26 ']"));
		Thread.sleep(1000);
		ActionUtils.ajaxJsClick(driver, By.xpath("//h3[text()='"+NetworkName+"']"));
		ActionUtils.ajaxJsClick(driver, NetworkDashBoardPage.TenderLink);
		ActionUtils.ajaxJsType(driver, TenderSearchBox, TenderName);
		ActionUtils.ajaxJsClick(driver, TenderSearchBtn);
		Assert.assertTrue(ActionUtils.getElement(driver, 
				By.xpath("//table[@id='tbTenderList']//tbody//tr//td//div[contains(.,'"+TenderName+"')]//following::div[text()='Won']")).isDisplayed(), "Tender not Selected");
		Reporter.log("Tender status is WON",true);
	}
	
	public void closeTender(String TenderName) {
		ActionUtils.ajaxJsClick(driver, CreateTender);
		ActionUtils.ajaxJsType(driver, TenderTitleBox, TenderName);
		ActionUtils.ajaxJsClick(driver, SaveTender);
		ActionUtils.ajaxJsClick(driver, CloseTender);
		ActionUtils.ajaxJsClick(driver, TenderYes);
		ActionUtils.ajaxJsClick(driver, TenderFilter);
		ActionUtils.selectElementByVisibleText(driver, TenderType, "Close");
		Assert.assertTrue(ActionUtils.getElement(driver, By.xpath("//td[text()='"+TenderName+"']")).isDisplayed(), "Tender not closed");
		Reporter.log("Tender Closed",true);
	}
	
	public void deleteTender(String TenderName) {
		ActionUtils.ajaxJsClick(driver, CreateTender);
		ActionUtils.ajaxJsType(driver, TenderTitleBox, TenderName);
		ActionUtils.ajaxJsClick(driver, SaveTender);
		ActionUtils.ajaxJsClick(driver, DeleteTender);
		ActionUtils.ajaxJsClick(driver, TenderYes);
		ActionUtils.ajaxJsClick(driver, TenderFilter);
		ActionUtils.selectElementByVisibleText(driver, TenderType, "Live");
		
		boolean tender = true;
		List<WebElement> list = ActionUtils.getElements(driver, By.xpath("//table[@id='tbTenderList']//tbody//tr//td"));
		for (int i = 0; i < list.size(); i++) {
			String text = list.get(i).getText();
			if (text.equalsIgnoreCase(TenderName)) {
				tender = false;
			}
		}

		Assert.assertTrue(tender, "Tender not deleted");
		Reporter.log("Tender deleted", true);
	}
	
	public void RejectTender(String TenderName, String CompanyName, CharSequence UserName, String NetworkName, String filePath, String Value) throws Exception {
		SoftAssert a = new SoftAssert();
		ActionUtils.ajaxJsClick(driver, CreateTender);
		ActionUtils.ajaxJsType(driver, TenderTitleBox, TenderName);
		Thread.sleep(1000);
		ActionUtils.ajaxJsClick(driver, SaveTender);
		ActionUtils.ajaxJsClick(driver, SubmitTender);
		ActionUtils.ajaxJsClick(driver, TenderYes);
		ActionUtils.ajaxJsClick(driver, TenderSupplier);
		ActionUtils.ajaxJsType(driver, SupplierSearchBox, CompanyName);
		ActionUtils.ajaxJsClick(driver, SupplierSearch);
		ActionUtils.ajaxJsClick(driver, SupplierCheckBox);
		ActionUtils.ajaxJsClick(driver, SaveSupplier);
		ActionUtils.ajaxJsClick(driver, SendRFQ);
		ActionUtils.ajaxJsClick(driver, TenderYes);
		ActionUtils.ajaxJsClick(driver, By.xpath("(//a[text()='Close'])[2]"));
		ActionUtils.hoverToElement(driver, johnSmithAcc);
		ActionUtils.ajaxJsClick(driver, MyAccount);
		ActionUtils.ajaxJsClick(driver, LoginAs);
		ActionUtils.ajaxJsClick(driver, SearchEmailBox);
		SearchEmailBox.sendKeys(UserName);
		SearchEmailBox.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		ActionUtils.ajaxJsClick(driver, By.xpath("//td[text()='"+UserName+"']"));
		ActionUtils.ajaxJsClick(driver, ReLogin);
		Thread.sleep(1000);
		ActionUtils.ajaxJsClick(driver, LoginPage.menuBtn);
		ActionUtils.ajaxJsClick(driver, LoginPage.iQlusterApp);
		ActionUtils.hoverToElement(driver, By.xpath("//span[text()='TC User 1 ']"));
		ActionUtils.ajaxJsClick(driver, MyCompanies);
		ActionUtils.ajaxJsClick(driver, By.xpath("//span[text()='TC26 ']"));
		Thread.sleep(1000);
		ActionUtils.ajaxJsClick(driver, By.xpath("//h3[text()='"+NetworkName+"']"));
		ActionUtils.ajaxJsClick(driver, NetworkDashBoardPage.TenderLink);
		ActionUtils.ajaxJsClick(driver, By.xpath("//td[text()='"+TenderName+"']"));
		ActionUtils.ajaxJsClick(driver, TenderReject);
		a.assertTrue(ActionUtils.getElement(driver, By.xpath("//span[@id='responseType']")).isDisplayed(), "Rejected page not displayed");
		Reporter.log("Rejected page displayed");
		ActionUtils.uploadFile(driver, RejectFile, filePath);
		ActionUtils.sendKeys(driver, Response, Value);
		ActionUtils.ajaxJsClick(driver, RejectSubmit);
		ActionUtils.ajaxJsClick(driver, TenderYes);
		a.assertAll();
	}
	
	public void verify_Rejected_tender(String TenderName) {
		ActionUtils.ajaxJsType(driver, TenderSearchBox, TenderName);
		ActionUtils.ajaxJsClick(driver, TenderSearchBtn);
		ActionUtils.ajaxJsClick(driver, By.xpath("//td[text()='"+TenderName+"']"));
		Assert.assertTrue(ActionUtils.getElement(driver, By.xpath("//i[@class='fa fa-close']")).isDisplayed(), "Tender not Rejected");
		Reporter.log("tender Rejected",true);
	}
	
	public void FilterSupplierByTag_DataCapture(String TenderName, String TagName) throws Exception {
		SoftAssert a = new SoftAssert();
		ActionUtils.ajaxJsClick(driver, CreateTender);
		ActionUtils.ajaxJsType(driver, TenderTitleBox, TenderName);
		Thread.sleep(1000);
		ActionUtils.ajaxJsClick(driver, SaveTender);
		ActionUtils.ajaxJsClick(driver, SubmitTender);
		ActionUtils.ajaxJsClick(driver, TenderYes);
		ActionUtils.ajaxJsClick(driver, TenderSupplier);
		ActionUtils.ajaxJsClick(driver, FilterSupplier);
		//ActionUtils.ajaxJsClick(driver, TagSelectBox1);
		ActionUtils.sendKeys(driver, TagselectBox2, TagName);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[contains(text(),'"+TagName+"')]/preceding::div[1]")).click();
		//ActionUtils.ajaxJsClick(driver, By.xpath("//div[contains(text(),'"+TagName+"')]/preceding::div[1]"));
		ActionUtils.waitForAjax(driver);
		Thread.sleep(4000);
		ActionUtils.ajaxJsClick(driver, FilterClose);
		a.assertTrue(ActionUtils.getElement(driver, By.xpath("//h3[contains(@title,'TC26')]")).isDisplayed(), "Supplier not filtered by Tag");
		Reporter.log("Supplier filtered by Tag",true);
		Thread.sleep(1000);
		ActionUtils.ajaxJsClick(driver, RemoveTag);
		ActionUtils.ajaxJsClick(driver, FilterSupplier);
		ActionUtils.ajaxJsClick(driver, By.xpath("//h3[text()='Q/MultiChoice-CheckBox/Adva... ']"));
		ActionUtils.ajaxJsClick(driver, By.xpath("(//div[@class='list-icon-container']/.)[1]"));
		ActionUtils.ajaxJsClick(driver, DataCaptureClose);
		ActionUtils.ajaxJsClick(driver, FilterClose);
		ActionUtils.ajaxJsClick(driver, DataCaptureEdit);
		ActionUtils.ajaxJsClick(driver, By.xpath("//input[@value='Medium']"));
		ActionUtils.ajaxJsClick(driver, QuestionDlgClose);
		a.assertTrue(ActionUtils.getElement(driver, By.xpath("//h3[contains(@title,'TC26')]")).isDisplayed(), "Supplier not filtered by Questionnaire");
		Reporter.log("Supplier filtered by Questionnaire",true);
		ActionUtils.ajaxJsClick(driver, QuestionRemove);
		a.assertAll();
	}
}

























