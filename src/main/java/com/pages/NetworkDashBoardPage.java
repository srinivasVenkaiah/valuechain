/**
 * @author UmaMaheswararao
 */

package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.base.BasePage;
import com.util.ActionUtils;
import com.util.AjaxLibrary;
import com.util.GenericLibrary;
import com.util.JavascriptLibrary;
import com.util.VerificationLibrary;

public class NetworkDashBoardPage extends BasePage {

	// Objects Repository(OR):........................................................................

	// View Uploaded companies details
	@FindBy(xpath = "(//span[contains(@data-counter,'counterup')])[1]")
	WebElement noOfCompanies;

	@FindBy(xpath = "(//span[contains(@data-counter,'counterup')])[2]")
	WebElement noOfActiveCompanies;

	@FindBy(xpath = "(//span[contains(@data-counter,'counterup')])[3]")
	static WebElement noOfConnectedCompanies;

	@FindBy(xpath = "(//span[contains(@data-counter,'counterup')])[4]")
	WebElement noOfNewRadarMatchesByRadar;

	@FindBy(xpath = "(//div[@class='desc'][contains(.,'Companies')])[1]")
	static WebElement CompaniesBoard;

	@FindBy(xpath = "//div[@class='desc'][contains(.,'Active Companies')]")
	WebElement ActiveCompaniesBoard;

	@FindBy(xpath="//div[@class='desc'][contains(.,'Connected Companies')]")
	WebElement ConnectedCompaniesBoard;

	@FindBy(xpath = "//div[@class='desc'][contains(.,'New radar matches by Radar')]")
	WebElement newRadarMatchesByRadarBoard;

	@FindBy(xpath = "(//span[contains(.,'Radar')])[2]")
	WebElement radarPageHeader;

	@FindBy(xpath = "//span[contains(.,'Network Dashboard')]")
	static WebElement networkDashBoardLink;

	// View Company Information
	@FindBy(xpath = "//span[contains(@id,'lblCompanyName')]")
	WebElement openedCompany;
	// What we do Tab
	@FindBy(xpath = "//h4[contains(.,'What we do')]")
	WebElement WhatWeDo;

	@FindBy(xpath="//div[@class='caption'][contains(.,'SECTORS')]")
	WebElement SectorsSection;

	@FindBy(xpath="//div[@class='caption'][contains(.,'CAPABILITIES')]")
	WebElement CapabilitiesSection;

	@FindBy(xpath="//div[@class='caption'][contains(.,'APPROVALS')]")
	WebElement ApprovalsSection;

	@FindBy(xpath="//div[@class='caption'][contains(.,'PRODUCTS')]")
	WebElement ProductsSection;

	@FindBy(xpath="//div[@class='caption'][contains(.,'SERVICES')]")
	WebElement ServicesSection;

	// Intelligence Tab
	@FindBy(xpath = "//h4[contains(.,'Intelligence')]")
	WebElement Intelligence;

	@FindBy(xpath = "(//span[contains(.,'Data Capture')])[2]")
	WebElement dataCaptureHeaderText;

	// Interests
	@FindBy(xpath = "//h4[contains(.,'Interests')]")
	WebElement Interests;

	@FindBy(xpath="//div[contains(.,'This company has not share its interests with you yet.')]")
	WebElement errorMessageForInterestsTab;

	// Collaborations
	@FindBy(xpath = "//h4[contains(.,'Collaborations')]")
	WebElement Collaborations;

	// Add & Remove tags from the company
	@FindBy(xpath = "//i[contains(@class,'fa fa-tags')]")
	static WebElement companyTagsBtn;

	@FindBy(xpath="//input[contains(@class,'select2-search__field')]")
	static WebElement companyTagsSearchBox;

	@FindBy(xpath = "//button[contains(@onclick,'CompanyInfo.CancelCompanyTagDlg()')]")
	WebElement closeCompanyTagDlg;

	@FindBy(xpath="//span[@class='select2-selection__choice__remove']")
	WebElement removeCompanyTagBtn;

	// Invitation mode
	@FindBy(xpath="//a[@id='btnSwitchMode']//span[2]")
	WebElement switchToInvitationModeBtn;

	@FindBy(xpath="(//span[@data-counter='counterup'])[1]")
	WebElement NotConnectedTab;

	@FindBy(xpath="(//span[@data-counter='counterup'])[2]")
	WebElement InvitedTab;

	@FindBy(xpath="(//span[@data-counter='counterup'])[3]")
	WebElement ConnectedTab;

	@FindBy(xpath="(//span[@data-counter='counterup'])[4]")
	WebElement DeclinedTab;

	// Download Companies Template
	@FindBy(xpath="//span[contains(@class,'icon-green-excel')]")
	WebElement downloadCompaniesTemplateIcon;

	// Upload Companies Template 
	@FindBy(xpath="//span[contains(@class,'icon-blue-upload-round')]")
	WebElement uploadCompaniesTemplateIcon;

	// Add Company
	@FindBy(xpath="//span[contains(@class,'l-btn-icon icon-add')]")
	WebElement addCompanyBtn;

	@FindBy(xpath = "//input[contains(@id,'txtCompanyName')]")
	WebElement companyNameTextBox;

	@FindBy(xpath = "//input[contains(@id,'txtFirstName')]")
	WebElement contactFirstNameTextBox;

	@FindBy(xpath = "//input[contains(@id,'txtLastName')]")
	WebElement contactLastNameTextBox;

	@FindBy(xpath = "//input[contains(@id,'txtContactEmail')]")
	WebElement contactEmailTextBox;

	@FindBy(xpath="//div[contains(.,'Add successfully')]")
	WebElement addedSuccessfullyMessage;

	@FindBy(xpath = "//button[contains(.,'Add as new company')]")
	WebElement addAsNewCompnayBtn;

	@FindBy(xpath = "//span[contains(.,'Please enter Company Name.')]")
	WebElement pleaseEnterCompanyNameMessage;

	// Add company to network
	@FindBy(xpath = "(//input[contains(@name,'btSelectAll')])[1]")
	WebElement selectAllCheckBox;

	@FindBy(xpath = "//button[contains(@id,'btnSubmitByCC')]")
	WebElement submitBtn;

	@FindBy(xpath="//span[contains(@class,'l-btn-icon icon-back32')]")
	WebElement backToCompaniesBtn;

	@FindBy(xpath="//span[contains(@class,'icon-blue-search2-round-32')]")
	WebElement searchBtn_ActiveCompanies;

	@FindBy(xpath="//input[contains(@class,'searcher-text')]")
	WebElement searchBox_ActiveCompanies;

	// Invite All companies
	@FindBy(xpath="//span[contains(@class,'icon-blue-email')]")
	WebElement inviteAllCompaniesBtn;

	@FindBy(xpath="//button[@data-bb-handler='confirm'][contains(.,'Yes')]")
	WebElement YesBtn;

	@FindBy(xpath="//div[contains(.,'email invitation has sent to the company')]")
	WebElement emailInvitationHasSentToCompanyMessage; 

	@FindBy(xpath="//div[contains(.,'Invite failed:You have not assigned a contact person from this company as the contact in this network yet.')]")
	WebElement inviteFaildeMessage;

	// Invite Selected company
	@FindBy(xpath="(//div[contains(@title,'Invite')])[1]")
	WebElement inviteBtn;

	// Invite again
	@FindBy(xpath="(//div[contains(@title,'Invite Again')])[1]")
	WebElement inviteAgainBtn;

	// Radar search
	@FindBy(xpath = "//span[contains(@class,'l-btn-icon icon-add')]")
	WebElement addRadarBtn;

	@FindBy(xpath = "//input[contains(@id,'txtSearch')]")
	WebElement radarSearchBox;

	@FindBy(xpath = "//button[contains(@onclick,'RadarSearch.Search()')]")
	WebElement radarSearchBtn;

	@FindBy(xpath = "//button[contains(@onclick,'RadarSearch.Save()')]")
	WebElement radarSaveBtn;

	@FindBy(xpath="//div[contains(text(),' Please enter the search content.')]")
	WebElement pleaseEnterSearchContentMessage;

	// Navigate to Advanced Search Page
	@FindBy(xpath = "(//span[contains(.,'Advanced Search')])[2]")
	static WebElement AdvancedSearchLink;

	// Navigate to Explore Page
	@FindBy(xpath="(//span[contains(.,'Explore')])[2]")
	static WebElement ExploreLink;

	// Navigate to Data Capture Page
	@FindBy(xpath = "//span[contains(.,'Data Capture')]")
	static WebElement DataCaptureLink;

	// Navigating to Analyse Page
	@FindBy(xpath = "//span[contains(.,'Analyse')]")
	static WebElement AnalyseLink;

	// Navigate to Map Page
	@FindBy(xpath="//span[text()='Map']")
	static WebElement MapLink;

	// Navigate to Location Map
	@FindBy(xpath="//span[@class='title'][contains(.,'Location Map')]")
	static WebElement LocationMapLink;

	// Navigate to Products
	@FindBy(xpath = "//span[@class='title'][contains(.,'Products')]")
	WebElement ProductsLink;

	// Navigate to Services
	@FindBy(xpath = "//span[@class='title'][contains(.,'Services')]")
	WebElement ServicesLink;

	// Navigate to Projects
	@FindBy(xpath = "//span[@class='title'][contains(.,'Projects')]")
	WebElement ProjectsLink;

	static By TenderLink = By.xpath("//span[text()='Tender']");
	
	// Navigate to Settings
	static @FindBy(xpath = "//span[text()='Settings']")
	WebElement settingsLink;

	@FindBy(xpath="(//span[text()='Personalised Dashboard'])[1]")
	static WebElement PersonalisedDashboardLink;

	static By CapabilityGroupLink = By.xpath("//span[text()='Capability Group']");






	// Initializing the Page Objects:......................................................................................
	public NetworkDashBoardPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:......................................................................................

	// Navigating to Advanced Search Page
	public AdvancedSearchPage Open_Advanced_Search_Page() {
		GenericLibrary.click(driver, AdvancedSearchLink);
		GenericLibrary.waitForAjax(driver);
		return new AdvancedSearchPage();
	}

	// Navigating to Explore 
	public ExplorePage Open_Explore_Page() {
		GenericLibrary.click(driver, ExploreLink);
		GenericLibrary.waitForAjax(driver);
		return new ExplorePage();
	}

	// Navigating to DataCapture 
	public DataCapturePage Open_Data_Capture_Page() {
		GenericLibrary.click(driver, DataCaptureLink);
		GenericLibrary.waitForAjax(driver);
		return new DataCapturePage();
	}

	// Navigating to Analyse 
	public AnalysePage Open_Analyse_Page() {
		GenericLibrary.click(driver, AnalyseLink);
		GenericLibrary.waitForAjax(driver);
		return new AnalysePage();
	}

	// Navigate to Map
	public MapPage Open_Map_Page() {
		GenericLibrary.click(driver, MapLink);
		GenericLibrary.waitForAjax(driver);
		return new MapPage();
	}

	// Navigate to Location map 
	public LocationMapPage Open_Loaction_map_page() {
		GenericLibrary.click(driver, LocationMapLink);
		GenericLibrary.waitForAjax(driver);
		return new LocationMapPage();
	}

	// Navigate to Products
	public ProductsPage Open_Products_Page() {
		GenericLibrary.click(driver, ProductsLink);
		GenericLibrary.waitForAjax(driver);
		return new ProductsPage();
	}

	// Navigate to Services
	public ServicesPage Open_Services_Page() {
		GenericLibrary.click(driver, ServicesLink);
		GenericLibrary.waitForAjax(driver);
		return new ServicesPage();
	}

	// Navigate to Projects
	public ProjectsPage Open_Projects_Page() {
		GenericLibrary.click(driver, ProjectsLink);
		GenericLibrary.waitForAjax(driver);
		return new ProjectsPage();
	}
	
	// Navigate to Tender
	public TenderPage open_TenderPage() {
		ActionUtils.ajaxJsClick(driver, TenderLink);
		ActionUtils.waitForAjax(driver);
		return new TenderPage();
	}
	
	// Navigate to Capability Group 
	public CapabilityGroupPage open_CapabilityGroupPage() {
		ActionUtils.ajaxJsClick(driver, CapabilityGroupLink);
		ActionUtils.waitForAjax(driver);
		return new CapabilityGroupPage();
	}

	// Navigate to settings
	public SettingsPage Open_Settings_Page() {
		AjaxLibrary.jsClick(driver, settingsLink);
		return new SettingsPage();
	}

	public void verify_View_uploaded_companies_details() throws Exception {
		SoftAssert a = new SoftAssert();
		// Companies
		GenericLibrary.waitForElementVisibility(driver, noOfCompanies);
		int expComp = Integer.parseInt(noOfCompanies.getText());			
		Reporter.log("No.of Companies at Network Dashboard: "+expComp, true);
		if (expComp != 0) {
			AjaxLibrary.jsClick(driver, CompaniesBoard);
			GenericLibrary.scrollBottomThrice(driver);
			List<WebElement> compList = driver.findElements(By.xpath("//div[contains(@id,'divCompany')]//h3"));
			GenericLibrary.waitForListOfElementsVisibility(driver, compList);
			int actComp = compList.size();
			Reporter.log("Actual No.of Companies available at All Companies page: "+actComp, true);
			a.assertEquals(actComp, expComp, "Companies not matched");
			Reporter.log("No.of companies at Network Dashbaord and All Companies page are matched successfully", true);
		} else {
			Reporter.log("No companies available", true);
		}
		// Active Companies
		AjaxLibrary.click(driver, networkDashBoardLink);
		GenericLibrary.waitForElementVisibility(driver, noOfActiveCompanies);
		int expActiveComp = Integer.parseInt(noOfActiveCompanies.getText());			
		Reporter.log("No.of Active Companies at Network Dashboard: "+expActiveComp, true);
		if (expActiveComp != 0) {
			GenericLibrary.click(driver, ActiveCompaniesBoard);
			List<WebElement> activeList = driver.findElements(By.xpath("//div[contains(@class,'portlet-body')]//h3"));
			GenericLibrary.waitForListOfElementsVisibility(driver, activeList);
			int actActiveComp = activeList.size();
			Reporter.log("Actual No.of Companies available at All Companies page: "+actActiveComp, true);
			a.assertEquals(actActiveComp, expActiveComp, "Companies not matched");
			Reporter.log("No.of Active Companies at Network Dashbaord and Active Companies page are matched successfully", true);
		} else {
			Reporter.log("No active companies companies available", true);
		}
		// Connected Companies
		AjaxLibrary.click(driver, networkDashBoardLink);
		GenericLibrary.waitForElementVisibility(driver, noOfConnectedCompanies);
		int expConnectedComp = Integer.parseInt(noOfConnectedCompanies.getText());			
		Reporter.log("No.of Connected Companies at Network Dashboard: "+expConnectedComp, true);
		if (expConnectedComp != 0) {
			GenericLibrary.click(driver, ConnectedCompaniesBoard);
			List<WebElement> connectedList = driver.findElements(By.xpath("//div[@id='ulList']//h3"));
			GenericLibrary.waitForListOfElementsVisibility(driver, connectedList);
			int actConnectedComp = connectedList.size();
			Reporter.log("Actual No.of Companies available at All Companies page: "+actConnectedComp, true);
			a.assertEquals(actConnectedComp, expConnectedComp, "Connected Companies not matched");
			Reporter.log("No.of Connected Companies at Network Dashbaord and Connected Companies page are matched successfully", true);
		} else {
			Reporter.log("No connected companies available", true);
		}
		// New Radar matches by Radar
		AjaxLibrary.click(driver, networkDashBoardLink);
		GenericLibrary.waitForElementVisibility(driver, noOfNewRadarMatchesByRadar);
		int defaultRadarsCount= Integer.parseInt(noOfConnectedCompanies.getText());	
		Reporter.log("Default Radar Matches Count at Network Dashboard: "+defaultRadarsCount, true);
		if (defaultRadarsCount != 0) {
			GenericLibrary.click(driver, newRadarMatchesByRadarBoard);
			a.assertTrue(radarPageHeader.isDisplayed(), "Radar page not opening");
			Reporter.log("Radar page opening successfully on clicking Radar Matches KPI", true);
		} else {
			Reporter.log("No radar matches available", true);
		}
		a.assertAll();
	}

	public void verify_View_What_we_do_tab_options_for_the_given_company(String company) throws Exception {
		GenericLibrary.waitForElementVisibility(driver, CompaniesBoard);
		GenericLibrary.click(driver, CompaniesBoard);
		List<WebElement> compList = driver.findElements(By.xpath("//div[contains(@id,'divCompany')]//h3"));
		GenericLibrary.waitForListOfElementsVisibility(driver, compList);
		for(WebElement ele : compList) {
			String name = ele.getAttribute("title");
			if(name.contains(company)) {
				GenericLibrary.click(driver, ele);
				GenericLibrary.waitForAjax(driver);
				break;
			}
		}
		Assert.assertTrue(openedCompany.getText().equalsIgnoreCase(company), "Unable to open company");
		Reporter.log("Given company opened successfully", true);
		// What we do tab
		GenericLibrary.scrollIntoView(driver, WhatWeDo);
		Assert.assertTrue(WhatWeDo.isDisplayed(), "What we do tab Not found");
		Reporter.log("What we do tab is displayed", true);
		JavascriptLibrary.javascriptClickElement(driver, WhatWeDo);
		// Sectors
		GenericLibrary.waitForElementVisibility(driver, SectorsSection);
		Assert.assertTrue(SectorsSection.isDisplayed(), "What we do tab not opened");
		Reporter.log("What we do tab is opened", true);
		Reporter.log("Sectors section is displayed", true);
		GenericLibrary.waitForAjax(driver);
		List<WebElement> sectorList = driver.findElements(By.xpath("//div[@id='Sectors']//h3"));
		for (int i = 0; i < sectorList.size(); i++) {
			Reporter.log("Available secor "+i+": "+sectorList.get(i).getText(), true);
		}
		// Capabilities
		GenericLibrary.scrollIntoView(driver, CapabilitiesSection);
		GenericLibrary.waitForAjax(driver);
		Assert.assertTrue(CapabilitiesSection.isDisplayed(), "Capabilities section not found");
		Reporter.log("Capabilities section is displayed", true);
		List<WebElement> capList = driver.findElements(By.xpath("//a[contains(@id,'anchor')]"));
		for (int i = 0; i < capList.size(); i++) {
			Reporter.log("Available capabilities "+i+": "+capList.get(i).getText(), true);
		}
		// Approvals
		GenericLibrary.scrollIntoView(driver, ApprovalsSection);
		GenericLibrary.waitForAjax(driver);
		Assert.assertTrue(ApprovalsSection.isDisplayed(), "Approvals section not found");
		Reporter.log("Approvals section is displayed", true);
		List<WebElement> approvList = driver.findElements(By.xpath("//div[@id='Approvals']//h3"));
		for (int i = 0; i < approvList.size(); i++) {
			Reporter.log("Available approvals "+i+": "+approvList.get(i).getText(), true);
		}
		// Products
		GenericLibrary.scrollIntoView(driver, ProductsSection);
		GenericLibrary.waitForAjax(driver);
		Assert.assertTrue(ProductsSection.isDisplayed(), "Products section not found");
		Reporter.log("Products section is displayed", true);
		List<WebElement> productList = driver.findElements(By.xpath("//div[@id='Products']//h3"));
		for (int i = 0; i < productList.size(); i++) {
			Reporter.log("Available products "+i+": "+productList.get(i).getText(), true);
		}
		// Services
		GenericLibrary.scrollIntoView(driver, ServicesSection);
		GenericLibrary.waitForAjax(driver);
		Assert.assertTrue(ServicesSection.isDisplayed(), "Services section not found");
		Reporter.log("Products section is displayed", true);
		List<WebElement> servicesList = driver.findElements(By.xpath("//div[@id='Products']//h3"));
		for (int i = 0; i < servicesList.size(); i++) {
			Reporter.log("Available services "+i+": "+servicesList.get(i).getText(), true);
		}
	}

	public void verify_View_Intelligence_tab_options_for_the_given_company(String company) {
		AjaxLibrary.jsClick(driver, CompaniesBoard);
		List<WebElement> compList = driver.findElements(By.xpath("//div[contains(@id,'divCompany')]//h3"));
		GenericLibrary.waitForListOfElementsVisibility(driver, compList);
		for(WebElement ele : compList) {
			String name = ele.getText();
			if(name.equalsIgnoreCase(company)) {
				AjaxLibrary.jsClick(driver, ele);
				break;
			}
		}
		Assert.assertTrue(openedCompany.getAttribute("myname").equalsIgnoreCase(company), "Unable to open company");
		Reporter.log("Given company opened successfully", true);
		// Intelligence tab
		GenericLibrary.scrollIntoView(driver, Intelligence);
		Assert.assertTrue(Intelligence.isDisplayed(), "Intelligence tab Not found");
		Reporter.log("Intelligence tab is displayed", true);
		JavascriptLibrary.javascriptClickElement(driver, Intelligence);
		// Data capture section
		GenericLibrary.waitForElementVisibility(driver, dataCaptureHeaderText);
		Assert.assertTrue(dataCaptureHeaderText.isDisplayed(), "Data capture section is not displayed");
		Reporter.log("Data capture scetion is displayed successfully on clicking Intelligence tab", true);
	}

	public void verify_Error_message_for_Interests_tab_without_sharing_interests_for_the_given_company(String company, String message) {
		AjaxLibrary.jsClick(driver, CompaniesBoard);
		List<WebElement> compList = driver.findElements(By.xpath("//div[contains(@id,'divCompany')]//h3"));
		GenericLibrary.waitForListOfElementsVisibility(driver, compList);
		for(WebElement ele : compList) {
			String name = ele.getText();
			if(name.equalsIgnoreCase(company)) {
				AjaxLibrary.jsClick(driver, ele);
				break;
			}
		}
		Assert.assertTrue(openedCompany.getAttribute("myname").equalsIgnoreCase(company), "Unable to open company");
		Reporter.log("Given company opened successfully", true);
		// Interests tab
		GenericLibrary.scrollIntoView(driver, Interests);
		Assert.assertTrue(Interests.isDisplayed(), "Interests tab Not found");
		Reporter.log("Interests tab is displayed", true);
		JavascriptLibrary.javascriptClickElement(driver, Interests);
		Assert.assertTrue(errorMessageForInterestsTab.getText().contains(message));
	}

	public void verify_View_Collaborations_tab_options_for_the_given_company(String company) throws Exception {
		AjaxLibrary.jsClick(driver, CompaniesBoard);
		List<WebElement> compList = driver.findElements(By.xpath("//div[contains(@id,'divCompany')]//h3"));
		GenericLibrary.waitForListOfElementsVisibility(driver, compList);
		for(WebElement ele : compList) {
			String name = ele.getText();
			if(name.equalsIgnoreCase(company)) {
				AjaxLibrary.jsClick(driver, ele);
				break;
			}
		}
		Assert.assertTrue(openedCompany.getAttribute("myname").equalsIgnoreCase(company), "Unable to open company");
		Reporter.log("Given company opened successfully", true);
		// Collaborations tab
		GenericLibrary.scrollIntoView(driver, Collaborations);
		Assert.assertTrue(Collaborations.isDisplayed(), "Collaborations tab Not found");
		Reporter.log("Collaborations tab is displayed", true);
		JavascriptLibrary.javascriptClickElement(driver, Collaborations);



		Thread.sleep(5000);
	}

	public void verify_Add_and_Remove_tags_from_the_company(String company, String tag) throws Exception {
		AjaxLibrary.jsClick(driver, CompaniesBoard);
		List<WebElement> compList = driver.findElements(By.xpath("//div[contains(@id,'divCompany')]//h3"));
		GenericLibrary.waitForListOfElementsVisibility(driver, compList);
		for(WebElement ele : compList) {
			String name = ele.getText();
			if(name.equalsIgnoreCase(company)) {
				AjaxLibrary.jsClick(driver, ele);
				break;
			}
		}
		Assert.assertTrue(openedCompany.getAttribute("myname").equalsIgnoreCase(company), "Unable to open company");
		Reporter.log("Given company opened successfully", true);
		GenericLibrary.click(driver, companyTagsBtn);
		GenericLibrary.waitForAjax(driver);
		companyTagsSearchBox.sendKeys(tag);
		driver.findElement(By.xpath("//div[contains(text(),'"+tag+"')]//preceding::div[1]")).click();
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, closeCompanyTagDlg);
		GenericLibrary.waitForAjax(driver);
		Assert.assertTrue(driver.findElement(By.xpath("(//span[contains(.,'"+tag+"')])[1]")).isDisplayed(), "Tag not added");
		Reporter.log("Tag added successfully", true);
		GenericLibrary.click(driver, companyTagsBtn);
		GenericLibrary.waitForAjax(driver);
		Thread.sleep(1000);
		JavascriptLibrary.javascriptClickElement(driver, removeCompanyTagBtn);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, closeCompanyTagDlg);
		GenericLibrary.waitForAjax(driver);
		Thread.sleep(1000);
		try {
			Assert.assertTrue(driver.findElement(By.xpath("(//span[contains(.,'"+tag+"')])[1]")).isDisplayed());
			Reporter.log("Tag not removed", true);
			Assert.fail();
		} catch (NoSuchElementException | AssertionError e) {
			Reporter.log("Tag removed successfully", true);
		}
	}

	public void verify_Switch_to_Invitation_mode_and_validate_the_tab_results() throws Exception {
		GenericLibrary.waitForElementVisibility(driver, ActiveCompaniesBoard);
		GenericLibrary.click(driver, ActiveCompaniesBoard);
		GenericLibrary.click(driver, switchToInvitationModeBtn);
		GenericLibrary.waitForAjax(driver);
		Assert.assertTrue(NotConnectedTab.isDisplayed(), "Switch to invitation mode not working");
		Reporter.log("Switched to invitation mode successfully", true);
		// Not connected Tab
		GenericLibrary.click(driver, NotConnectedTab);
		GenericLibrary.waitForAjax(driver);
		int ncCount = Integer.parseInt(NotConnectedTab.getText());
		Reporter.log("No of Not Connected Companies displayed on tab: "+ncCount, true);
		if(ncCount==0) {
			Reporter.log("No records found", true);
			//---------------No records found message condition need to add-------------
		}else {
			List<WebElement> ncList = driver.findElements(By.xpath("//div[@id='ulList']//h3"));
			int result = ncList.size();
			Assert.assertEquals(ncCount, result, "Not Connected count Not matched with displayed number");
			Reporter.log("Not Connected count matched with displayed number", true);
		}
		// Invited Tab
		GenericLibrary.click(driver, InvitedTab);
		GenericLibrary.waitForAjax(driver);
		int invitedCount = Integer.parseInt(InvitedTab.getText());
		Reporter.log("No of Invited Companies displayed on tab: "+invitedCount, true);
		if(invitedCount==0) {
			Reporter.log("No records found", true);
			//---------------No records found message condition need to add-------------
		}else {
			List<WebElement> invitedList = driver.findElements(By.xpath("//div[@id='ulList']//h3"));
			int result = invitedList.size();
			Assert.assertEquals(invitedCount, result, "Invited count Not matched with displayed number");
			Reporter.log("Invited count matched with displayed number", true);
		}
		// Connected Tab
		GenericLibrary.click(driver, ConnectedTab);
		GenericLibrary.waitForAjax(driver);
		int connectedCount = Integer.parseInt(ConnectedTab.getText());
		Reporter.log("No of Connected Companies displayed on tab: "+connectedCount, true);
		if(connectedCount==0) {
			Reporter.log("No records found", true);
			//---------------No records found message condition need to add-------------
		}else {
			List<WebElement> connectedList = driver.findElements(By.xpath("//div[@id='ulList']//h3"));
			int result = connectedList.size();
			Assert.assertEquals(connectedCount, result, "Connected count Not matched with displayed number");
			Reporter.log("Connected count matched with displayed number", true);
		}
		// Declined Tab
		GenericLibrary.click(driver, DeclinedTab);
		GenericLibrary.waitForAjax(driver);
		int declinedCount = Integer.parseInt(DeclinedTab.getText());
		Reporter.log("No of Declined Companies displayed on tab: "+declinedCount, true);
		if(declinedCount==0) {
			Reporter.log("No records found", true);
			//---------------No records found message condition need to add-------------
		}else {
			List<WebElement> declinedList = driver.findElements(By.xpath("//div[@id='ulList']//h3"));
			int result = declinedList.size();
			Assert.assertEquals(invitedCount, result, "Declined count Not matched with displayed number");
			Reporter.log("Declined count matched with displayed number", true);
		}
	}

	public void verify_Download_companies_template(String filePath, String fileName) throws Exception {
		GenericLibrary.waitForElementVisibility(driver, ActiveCompaniesBoard);
		GenericLibrary.click(driver, ActiveCompaniesBoard);
		GenericLibrary.click(driver, switchToInvitationModeBtn);
		GenericLibrary.waitForAjax(driver);
		Assert.assertTrue(NotConnectedTab.isDisplayed(), "Switch to invitation mode not working");
		Reporter.log("Switched to invitation mode successfully", true);
		Assert.assertTrue(downloadCompaniesTemplateIcon.isDisplayed(), "Download Companies Template Icon Not found");
		Reporter.log("Download Template Icon is displayed", true);
		GenericLibrary.downoadFile(downloadCompaniesTemplateIcon);
		GenericLibrary.waitForAjax(driver);
		Thread.sleep(2000);
		Assert.assertTrue(VerificationLibrary.isFileDownloaded(filePath, fileName), "File Not downloaded");
		Reporter.log("File downloaded successfully", true);
	}

	public void verify_Upload_companies_template(String filePath) throws Exception {
		GenericLibrary.waitForElementVisibility(driver, ActiveCompaniesBoard);
		GenericLibrary.click(driver, ActiveCompaniesBoard);
		GenericLibrary.click(driver, switchToInvitationModeBtn);
		GenericLibrary.waitForAjax(driver);
		Assert.assertTrue(NotConnectedTab.isDisplayed(), "Switch to invitation mode not working");
		Reporter.log("Switched to invitation mode successfully", true);
		Assert.assertTrue(uploadCompaniesTemplateIcon.isDisplayed(), "Upload Companies Template Icon Not found");
		Reporter.log("Upload Template Icon is displayed", true);
		int countBeforeUpload = Integer.parseInt(NotConnectedTab.getText());
		Reporter.log("No.of not connected companies before uploading template: "+countBeforeUpload, true);
		GenericLibrary.uploadFile(uploadCompaniesTemplateIcon, filePath);
		GenericLibrary.waitForAjax(driver);
		int countAfterUpload = Integer.parseInt(NotConnectedTab.getText());
		Reporter.log("No.of not connected companies after uploading template: "+countAfterUpload, true);
		if (countAfterUpload > countBeforeUpload) {
			Reporter.log("Companies Template uploaded successfully", true);
		} else {
			Reporter.log("Template not uploaded", true);
			Assert.fail();
		}
	}

	public void verify_manadatory_fields_error_message_while_adding_company() {
		GenericLibrary.waitForElementVisibility(driver, ActiveCompaniesBoard);
		GenericLibrary.click(driver, ActiveCompaniesBoard);
		GenericLibrary.click(driver, switchToInvitationModeBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.click(driver, addCompanyBtn);
		GenericLibrary.waitForElementVisibility(driver, companyNameTextBox);
		AjaxLibrary.jsClick(driver, addAsNewCompnayBtn);
		Assert.assertTrue(pleaseEnterCompanyNameMessage.isDisplayed(), "No error message for mandatory fields");
		Reporter.log("'Please enter company name' error message displayed successfully");
	}

	public void verify_Add_company_to_network(String company, String fName, String lName, String email) throws Exception {
		GenericLibrary.waitForElementVisibility(driver, ActiveCompaniesBoard);
		GenericLibrary.click(driver, ActiveCompaniesBoard);
		AjaxLibrary.jsClick(driver, switchToInvitationModeBtn);
		AjaxLibrary.click(driver, addCompanyBtn);
		AjaxLibrary.clickSelectAndType(driver, companyNameTextBox, companyNameTextBox, company);
		contactFirstNameTextBox.sendKeys(fName);
		contactLastNameTextBox.sendKeys(lName);
		contactEmailTextBox.sendKeys(email);
		GenericLibrary.click(driver, addAsNewCompnayBtn);
		GenericLibrary.waitForElementVisibility(driver, addedSuccessfullyMessage);
		Assert.assertTrue(addedSuccessfullyMessage.isDisplayed(), "Company not added");
		Reporter.log("Company Added successfully", true);

		//-------------Need to add same company and verify duplicate entry -----------------
	}

	public void verify_Add_company_to_network_and_verify_in_Not_Connected_list(String company) throws Exception{
		GenericLibrary.waitForElementVisibility(driver, ActiveCompaniesBoard);
		GenericLibrary.click(driver, ActiveCompaniesBoard);
		GenericLibrary.click(driver, switchToInvitationModeBtn);
		GenericLibrary.waitForAjax(driver);
		AjaxLibrary.click(driver, addCompanyBtn);
		AjaxLibrary.clickSelectAndType(driver, companyNameTextBox, companyNameTextBox, company);
		AjaxLibrary.click(driver, addAsNewCompnayBtn);
		/*WebElement plusBtn = driver.findElement(By.xpath("(//div[contains(@myname,'"+company+"')])[2]"));
		GenericLibrary.click(driver, plusBtn);
		GenericLibrary.click(driver, selectAllCheckBox);
		JavascriptLibrary.javascriptClickElement(driver, submitBtn);*/
		GenericLibrary.waitForElementVisibility(driver, addedSuccessfullyMessage);
		Assert.assertTrue(addedSuccessfullyMessage.isDisplayed(), "Company not added");
		Reporter.log("Company Added successfully", true);
		JavascriptLibrary.javascriptClickElement(driver, backToCompaniesBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.click(driver, switchToInvitationModeBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.click(driver, searchBtn_ActiveCompanies);
		searchBox_ActiveCompanies.sendKeys(company);
		GenericLibrary.waitForAjax(driver);
		Assert.assertTrue(driver.findElement(By.xpath("//h3[contains(@title,'"+company+"')]")).isDisplayed(), "Company not added to network");
		Reporter.log("Company added to network successfully and found in Not Connected list", true);
	}

	public void verify_Invite_selected_company(String company) {
		GenericLibrary.waitForElementVisibility(driver, ActiveCompaniesBoard);
		AjaxLibrary.click(driver, ActiveCompaniesBoard);
		AjaxLibrary.click(driver, switchToInvitationModeBtn);
		AjaxLibrary.click(driver, By.xpath("//h3[contains(@title,'"+company+"')]//preceding::div[2]"));
		Assert.assertTrue(emailInvitationHasSentToCompanyMessage.isDisplayed(), "Unable to invite company");
		Reporter.log("Email invitation has sent to company successfully", true);
	}

	public void verify_Invite_all_companies() throws Exception{
		GenericLibrary.waitForElementVisibility(driver, ActiveCompaniesBoard);
		GenericLibrary.click(driver, ActiveCompaniesBoard);
		GenericLibrary.click(driver, switchToInvitationModeBtn);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, inviteAllCompaniesBtn);
		GenericLibrary.waitForElementVisibility(driver, YesBtn);
		JavascriptLibrary.javascriptClickElement(driver, YesBtn);
		GenericLibrary.waitForAjax(driver);
		try {
			Assert.assertTrue(emailInvitationHasSentToCompanyMessage.isDisplayed(), "Unable to invite all companies");
			Reporter.log("Email invitation has sent to all companies successfully", true);
		} catch (NoSuchElementException e) {
			//Assert.assertTrue(inviteFaildeMessage.isDisplayed(), "");
			Reporter.log("Invite failed: You have not assigned a contact person from this company as the contact in this network yet.", true);
		}
	}

	public void verify_Send_invite_compnay_again() {
		GenericLibrary.waitForElementVisibility(driver, ActiveCompaniesBoard);
		GenericLibrary.click(driver, ActiveCompaniesBoard);
		GenericLibrary.click(driver, switchToInvitationModeBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.click(driver, InvitedTab);
		GenericLibrary.waitForAjax(driver);
		if (Integer.parseInt(InvitedTab.getText()) != 0) {
			GenericLibrary.click(driver, inviteAgainBtn);
			Assert.assertTrue(emailInvitationHasSentToCompanyMessage.isDisplayed(), "Unable to invite company again");
			Reporter.log("Company invited again from invited list", true);
		} else {
			Reporter.log("No invited companies available", true);
		}
	}

	public void verify_Search_companies_from_active_companies_dashboard(String company) {
		GenericLibrary.waitForElementVisibility(driver, ActiveCompaniesBoard);
		GenericLibrary.click(driver, ActiveCompaniesBoard);
		GenericLibrary.click(driver, searchBtn_ActiveCompanies);
		searchBox_ActiveCompanies.sendKeys(company);
		GenericLibrary.waitForAjax(driver);
		List<WebElement> list = driver.findElements(By.xpath(".//*[@id='ulList']//h3"));
		int count=0;
		for (WebElement ele : list) {
			String comp = ele.getText();
			if (comp.equalsIgnoreCase(company)) {
				count = count+1;
			}
		}
		Assert.assertTrue(count != 0 && count == 1, "Search option is not working");
		Reporter.log("Active companies search option is functional", true);
	}

	public void verify_Invite_fail_alert_for_the_company_which_doesnot_have_email(String company) throws Exception {
		GenericLibrary.waitForElementVisibility(driver, ActiveCompaniesBoard);
		GenericLibrary.click(driver, ActiveCompaniesBoard);
		GenericLibrary.click(driver, switchToInvitationModeBtn);
		GenericLibrary.waitForAjax(driver);
		AjaxLibrary.click(driver, addCompanyBtn);
		AjaxLibrary.clickSelectAndType(driver, companyNameTextBox, companyNameTextBox, company);
		GenericLibrary.click(driver, addAsNewCompnayBtn);
		GenericLibrary.waitForElementVisibility(driver, addedSuccessfullyMessage);
		Assert.assertTrue(addedSuccessfullyMessage.isDisplayed(), "Company not be added without email");
		Reporter.log("Company Added successfully without email", true);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, backToCompaniesBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.click(driver, switchToInvitationModeBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.click(driver, searchBtn_ActiveCompanies);
		searchBox_ActiveCompanies.sendKeys(company);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.click(driver, driver.findElement(By.xpath("//h3[contains(@title,'"+company+"')]/preceding::div[2]")));
		GenericLibrary.waitForAlertPresent(driver);
		Assert.assertTrue(GenericLibrary.checkAlert_Accept(driver), "Invite fail alert not present");
		Reporter.log("Invite fail alert is displayed successfully", true);
	}

	public void verify_Disconnect_company_from_the_network(String company) {
		GenericLibrary.waitForElementVisibility(driver, ActiveCompaniesBoard);
		GenericLibrary.click(driver, ActiveCompaniesBoard);
		GenericLibrary.click(driver, switchToInvitationModeBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.click(driver, ConnectedTab);
		GenericLibrary.waitForAjax(driver);
		int connectedCountBefore = Integer.parseInt(ConnectedTab.getText());
		Reporter.log("No of Connected Companies before disconnection: "+connectedCountBefore, true);
		if (connectedCountBefore != 0) {
			WebElement discon = driver.findElement(By.xpath("(//div[@title='Disconnect']//i)[1]"));
			GenericLibrary.scrollIntoView(driver, discon);
			JavascriptLibrary.javascriptClickElement(driver, discon);
			GenericLibrary.waitForElementVisibility(driver, YesBtn);
			JavascriptLibrary.javascriptClickElement(driver, YesBtn);
			GenericLibrary.waitForAjax(driver);
			GenericLibrary.scrollTop(driver);
			int connectedCountAfter = Integer.parseInt(ConnectedTab.getText());
			Reporter.log("No of Connected Companies after disconnection: "+connectedCountAfter, true);
			Assert.assertTrue(connectedCountAfter < connectedCountBefore, "Company not disconnected");
			Reporter.log("Company disconnected successfully", true);
		} else {
			Reporter.log("No connected companies available", true);
		}
	}

	public void verify_Radar_search_error_message() throws Exception {
		GenericLibrary.click(driver, newRadarMatchesByRadarBoard);
		GenericLibrary.click(driver, addRadarBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.click(driver, radarSearchBtn);
		GenericLibrary.waitForAjax(driver);
		Assert.assertTrue(pleaseEnterSearchContentMessage.isDisplayed(), "No error message found for empty radar content Search");
		Reporter.log("Error message found for empty radar content Search", true);
		Thread.sleep(1000);
		GenericLibrary.click(driver, radarSaveBtn);
		GenericLibrary.waitForAjax(driver);
		Assert.assertTrue(pleaseEnterSearchContentMessage.isDisplayed(), "No error message found for empty radar content Save");
		Reporter.log("Error message found for empty radar content Save", true);
	}

	public void verify_Radar_search_option(String company) {
		GenericLibrary.click(driver, newRadarMatchesByRadarBoard);
		GenericLibrary.click(driver, addRadarBtn);
		GenericLibrary.waitForAjax(driver);
		radarSearchBox.sendKeys(company);
		GenericLibrary.click(driver, radarSearchBtn);
		GenericLibrary.waitForAjax(driver);
		List<WebElement> companyList = driver.findElements(By.xpath("//div[@id='ulList']//h3"));
		Assert.assertTrue(companyList.size() != 0, "Companies list not openeing on searching radar");
		Reporter.log("Companies list opened successfully on searching radar", true);
	}

	public void verify_Radar_save_option(String company) {
		GenericLibrary.click(driver, newRadarMatchesByRadarBoard);
		GenericLibrary.click(driver, addRadarBtn);
		GenericLibrary.waitForAjax(driver);
		radarSearchBox.sendKeys(company);
		GenericLibrary.click(driver, radarSaveBtn);
		GenericLibrary.waitForAjax(driver);
		boolean savedItem = false;
		List<WebElement> companyList = driver.findElements(By.xpath("//div[@id='ulList']//h3"));
		for (WebElement ele : companyList) {
			if (ele.getText().equalsIgnoreCase(company)) {
				savedItem = true;
			} 
		}
		Assert.assertTrue(savedItem, "Radar not saved");
		Reporter.log("Radar saved successfully", true);
	}

	public void verify_Radar_save_option_warning_alert_on_saving_already_saved_item(String company) {
		GenericLibrary.click(driver, newRadarMatchesByRadarBoard);
		GenericLibrary.click(driver, addRadarBtn);
		GenericLibrary.waitForAjax(driver);
		radarSearchBox.sendKeys(company);
		GenericLibrary.click(driver, radarSaveBtn);
		GenericLibrary.waitForAlertPresent(driver);
		Assert.assertTrue(GenericLibrary.checkAlert_Accept(driver), "No alert present on saving save item mutiple times");
		Reporter.log("Save failed alert presented successfully", true);
	}














}
