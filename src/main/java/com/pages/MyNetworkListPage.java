/**
 * @author UmaMaheswararao
 */

package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.base.BasePage;
import com.util.AjaxLibrary;
import com.util.GenericLibrary;
import com.util.JavascriptLibrary;

public class MyNetworkListPage extends BasePage {
	// Objects Repository(OR):........................................................................

	// Search a Network
	@FindBy(xpath=".//*[@id='divSearcher']/div/span/a")
	WebElement searchNetworkBtn;

	@FindBy(xpath=".//*[@id='divSearcher']/div/div/input")
	WebElement searchNetworkBox;

	// Prompt message for unknown network search
	@FindBy(xpath="//td[contains(.,'No matching records found')]")
	WebElement noMatchingRecordsFoundMessage;

	// Add a Network
	// Industry Alliance Network
	@FindBy(css=".l-btn-icon.icon-add")
	WebElement addNetworkBtn;

	@FindBy(xpath = "//a[contains(@id,'btnNext')]")
	WebElement nextBtn;

	@FindBy(xpath = "//span[contains(.,'Please enter Name.')]")
	WebElement pleaseEnterNetworkNameMessage;

	@FindBy(xpath = "//input[contains(@id,'N_NAME')]")
	WebElement networkNameTextBox;

	@FindBy(xpath = "//textarea[contains(@id,'N_DESC')]")
	WebElement networkDescTextBox;	

	@FindBy(xpath = "//textarea[contains(@id,'N_INVITEMSG')]")
	WebElement inviteMessageTextBox;

	@FindBy(xpath = "//textarea[contains(@id,'N_IQINVITEMSG')]")
	WebElement iQaptureInviteMessageTextBox;

	@FindBy(xpath = "//a[contains(@id,'btnInfo_Advanced')]")
	WebElement advancedTab;

	@FindBy(xpath = "//select[contains(@id,'ddlNetworkType')]")
	WebElement networkTypeDropDown;

	@FindBy(xpath = "//select[contains(@id,'ddlNetworkInviteType')]")
	WebElement networkInviteTypeDropDown;

	@FindBy(xpath = "//select[contains(@id,'ddlNetworkVisibility')]")
	WebElement networkVisibilityDropDown;

	@FindBy(xpath = "//select[contains(@id,'ddlNetworkRankingType')]")
	WebElement networkRankingTypeDropDown;

	@FindBy(xpath = "//span[contains(.,'Yes')]")
	WebElement brandedView_Yes;

	@FindBy(xpath = "//span[contains(.,'No')]")
	WebElement brandedView_No;

	@FindBy(xpath = "//form[contains(@id,'fieldImgDropzone')]")
	WebElement networkImageUplaodBtn;

	@FindBy(xpath="//button[contains(.,'Download Companies Template')]")
	WebElement downloadCompaniesTemplateBtn;

	@FindBy(xpath = "//button[contains(.,'Download data template')]")
	WebElement downloadDataTemplateBtn;

	@FindBy(xpath=".//*[@id='btnUploadCompaniesTmp']//span[2]")
	WebElement uploadCompaniesTemplateBtn;

	@FindBy(xpath=".//*[@id='btnUploadCompanyDataTmp']//span[2]")
	WebElement uploadCompanyDataBtn;

	@FindBy(xpath = "//input[contains(@id,'txtNewIQName')]")
	WebElement iQaptureNameTextBox;

	@FindBy(xpath = "//span[contains(.,'Company data list')]")
	WebElement CompanyDataListText;

	@FindBy(xpath=".//*[@id='divUploadDataType']/div[2]//div[2]/img")
	WebElement uploadDataType_No;

	@FindBy(xpath = "//a[contains(.,'Go to dashboard')]")
	WebElement goToDashboardBtn;

	// OEM(Original Equipments Manufacturing)
	@FindBy(xpath = "//h3[contains(.,'OEM')]")
	WebElement OEM_Network;

	@FindBy(xpath = "//h3[contains(.,'Subcontractor')]")
	WebElement Subcontractor_Network;

	@FindBy(xpath = "//a[contains(@id,'btnPrev')]")
	WebElement prevBtn;

	// Network leader field editable or not
	@FindBy(xpath="//input[@id='txtNetworkLeader']")
	WebElement networkLeaderField;

	// Open Given network
	@FindBy(xpath = "//span[contains(.,'Network Dashboard')]")
	static WebElement networkDashboardLink;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	






	// Initializing the Page Objects:................................................................
	public MyNetworkListPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:......................................................................................

	// Navigation to Network Dashboard
	public NetworkDashBoardPage Open_Network_Dashboard_Page(String networkName) throws Exception {
		GenericLibrary.waitForElementVisibility(driver, searchNetworkBtn);
		JavascriptLibrary.javascriptClickElement(driver, searchNetworkBtn);
		AjaxLibrary.clickClearAndType(driver, searchNetworkBox, networkName);
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//h3[@title='"+networkName+"']")));
		return new NetworkDashBoardPage();
	}

	public void verify_Search_newtwork_option() throws Exception {
		GenericLibrary.waitForElementVisibility(driver, searchNetworkBtn);
		Thread.sleep(3000);
		List<WebElement> networkList = driver.findElements(By.xpath(".//*[@id='ulList']//h3"));
		int count = networkList.size();
		for (int i = 0; i < count; i++) {
			Reporter.log("Available networks "+i+":"+networkList.get(i).getText(), true);
		}
		String networkToSearch = networkList.get(0).getText();
		JavascriptLibrary.javascriptClickElement(driver, searchNetworkBtn);
		searchNetworkBox.sendKeys(networkToSearch);
		GenericLibrary.waitForAjax(driver);
		String actResult = driver.findElement(By.xpath("//h3[@title='"+networkToSearch+"']")).getText();
		Assert.assertEquals(actResult, networkToSearch, "Search option is not working");
		Reporter.log("Search option is working", true);
	}

	public void verify_Prompt_message_for_unknown_network_search(String networkToSearch) {
		GenericLibrary.waitForElementVisibility(driver, searchNetworkBtn);
		JavascriptLibrary.javascriptClickElement(driver, searchNetworkBtn);
		searchNetworkBox.sendKeys(networkToSearch);
		GenericLibrary.waitForAjax(driver);
		try {
			Assert.assertTrue(noMatchingRecordsFoundMessage.isDisplayed());
			Reporter.log("Prompt message is displaying for unknown network search", true);
		} catch (AssertionError | NoSuchElementException e) {
			Reporter.log("No prompt message is displaying for unknown network search", true);
			Assert.fail();
		}
	}

	public void verify_Error_message_on_clicking_next_button_without_entering_network_name() {
		AjaxLibrary.jsClick(driver, addNetworkBtn);
		AjaxLibrary.jsClick(driver, nextBtn);
		AjaxLibrary.jsClick(driver, nextBtn);
		try {
			Assert.assertTrue(pleaseEnterNetworkNameMessage.isDisplayed());
			Reporter.log("'Please enter name' message displyed on clicking next without entering network name", true);
		} catch (Exception e) {
			Reporter.log("No error message displyed on clicking next without entering network name", true);
			Assert.fail();
		}
	}

	public void verify_Create_Industry_Alliance_Network_without_uploading_companies_data(String nName, String nDesc,
			String nInvite, String iQInvite, String typeOption, String invType, String visibleType, String rankType, 
			String nwImg) throws Exception {
		AjaxLibrary.jsClick(driver, addNetworkBtn);
		AjaxLibrary.jsClick(driver, nextBtn);
		GenericLibrary.sendKeys(driver, networkNameTextBox, 20, nName);
		GenericLibrary.sendKeys(driver, networkDescTextBox, 20, nDesc);
		GenericLibrary.sendKeys(driver, inviteMessageTextBox, 20, nInvite);
		GenericLibrary.sendKeys(driver, iQaptureInviteMessageTextBox, 20, iQInvite);
		JavascriptLibrary.javascriptClickElement(driver, advancedTab);
		GenericLibrary.selectElementByVisibleText(networkTypeDropDown, typeOption);
		GenericLibrary.selectElementByVisibleText(networkInviteTypeDropDown, invType);
		GenericLibrary.selectElementByVisibleText(networkVisibilityDropDown, visibleType);
		GenericLibrary.selectElementByVisibleText(networkRankingTypeDropDown, rankType);
		AjaxLibrary.jsClick(driver, brandedView_Yes);
		AjaxLibrary.uploadFile(driver, networkImageUplaodBtn, nwImg);
		AjaxLibrary.jsClick(driver, nextBtn);
		GenericLibrary.click(driver, downloadCompaniesTemplateBtn);
		for (int i = 0; i < 3; i++) {
			AjaxLibrary.jsClick(driver, nextBtn);
		}
		try {
			Assert.assertTrue(downloadDataTemplateBtn.isDisplayed());
			Reporter.log("Redirecting to download data template page", true);
			GenericLibrary.click(driver, downloadDataTemplateBtn);
			GenericLibrary.waitForAjax(driver);
		} catch (AssertionError | NoSuchElementException e) {
			Reporter.log("Not redirecting to download data template page", true);
			Assert.fail();
		}
		for (int i = 0; i < 2; i++) {
			AjaxLibrary.jsClick(driver, nextBtn);
		}
		AjaxLibrary.jsClick(driver, goToDashboardBtn);
		try {
			Assert.assertTrue(driver.findElement(By.xpath("//span[contains(.,'"+nName+"')]")).isDisplayed());
			Reporter.log("Industry Alliance network created successfully without data", true);
		} catch (AssertionError | NoSuchElementException e) {
			Reporter.log("Industry Alliance network Not created without data", true);
			Assert.fail();
		}
	}

	public void verify_Create_Industry_Alliance_Network(String nName, String nDesc,
			String nInvite, String iQInvite, String typeOption, String invType, String visibleType, String rankType, 
			String nwImg, String compTemp, String iQName, String dataTemp) throws Exception {
		AjaxLibrary.jsClick(driver, addNetworkBtn);
		AjaxLibrary.jsClick(driver, nextBtn);
		networkNameTextBox.sendKeys(nName);
		networkDescTextBox.sendKeys(nDesc);
		inviteMessageTextBox.sendKeys(nInvite);
		iQaptureInviteMessageTextBox.sendKeys(iQInvite);
		AjaxLibrary.jsClick(driver, advancedTab);
		GenericLibrary.selectElementByVisibleText(networkTypeDropDown, typeOption);
		GenericLibrary.selectElementByVisibleText(networkInviteTypeDropDown, invType);
		GenericLibrary.selectElementByVisibleText(networkVisibilityDropDown, visibleType);
		GenericLibrary.selectElementByVisibleText(networkRankingTypeDropDown, rankType);
		AjaxLibrary.uploadFile(driver, networkImageUplaodBtn, nwImg);
		AjaxLibrary.jsClick(driver, nextBtn);
		AjaxLibrary.jsClick(driver, nextBtn);
		AjaxLibrary.uploadFile(driver, uploadCompaniesTemplateBtn, compTemp);
		Thread.sleep(2000);
		AjaxLibrary.jsClick(driver, nextBtn);
		AjaxLibrary.jsClick(driver, nextBtn);
		AjaxLibrary.jsClick(driver, nextBtn);
		iQaptureNameTextBox.sendKeys(iQName);
		Thread.sleep(1000);
		AjaxLibrary.uploadFile(driver, uploadCompanyDataBtn, dataTemp);
		GenericLibrary.waitForElementVisibility(driver, CompanyDataListText);
		Assert.assertTrue(CompanyDataListText.isDisplayed(), "Company data Template not uploaded");
		Reporter.log("Compnay data template uploaded successfully", true);
		AjaxLibrary.jsClick(driver, goToDashboardBtn);
		Assert.assertTrue(driver.findElement(By.xpath("//span[contains(.,'"+nName+"')]")).isDisplayed(), "Industry Alliance network Not created");
		Reporter.log("Industry Alliance network created successfully", true);
	}

	public void verify_OEM_and_Subcontractor_networks_selection() {
		// OEM
		AjaxLibrary.jsClick(driver, addNetworkBtn);
		AjaxLibrary.jsClick(driver, OEM_Network);
		AjaxLibrary.jsClick(driver, nextBtn);
		Assert.assertTrue(networkNameTextBox.isDisplayed(), "Unable to select OEM network");
		Reporter.log("OEM network selection is functional");
		// Sub-contractor 
		AjaxLibrary.jsClick(driver, prevBtn);
		AjaxLibrary.jsClick(driver, Subcontractor_Network);
		AjaxLibrary.jsClick(driver, nextBtn);
		Assert.assertTrue(networkNameTextBox.isDisplayed(), "Unable to select Subcontractor network");
		Reporter.log("Subcontractor network selection is functional");
	}

	public void verify_Network_leader_field_is_editable_or_not() {
		// Industry Alliance
		GenericLibrary.waitForElementVisibility(driver, addNetworkBtn);
		GenericLibrary.click(driver, addNetworkBtn);
		GenericLibrary.waitForElementToBeClickable(driver, nextBtn);
		GenericLibrary.click(driver, nextBtn);
		Assert.assertTrue(networkLeaderField.getAttribute("disabled").equals("true"), "Network leader field is editable");
		Reporter.log("Network leader field for Industry Alliance network is disabled by default", true);
		GenericLibrary.waitForElementToBeClickable(driver, prevBtn);
		GenericLibrary.click(driver, prevBtn);
		// OEM
		GenericLibrary.click(driver, OEM_Network);
		GenericLibrary.waitForElementToBeClickable(driver, nextBtn);
		GenericLibrary.click(driver, nextBtn);
		Assert.assertTrue(networkLeaderField.getAttribute("disabled").equals("true"), "Network leader field is editable");
		Reporter.log("Network leader field for Industry OEM network is disabled by default", true);
		GenericLibrary.waitForElementToBeClickable(driver, prevBtn);
		GenericLibrary.click(driver, prevBtn);
		// Sub-contractor 
		GenericLibrary.click(driver, OEM_Network);
		GenericLibrary.waitForElementToBeClickable(driver, nextBtn);
		GenericLibrary.click(driver, nextBtn);
		Assert.assertTrue(networkLeaderField.getAttribute("disabled").equals("true"), "Network leader field is editable");
		Reporter.log("Network leader field for Industry Subcontractor network is disabled by default", true);
	}

	public void verify_Open_created_network(String networkName) {
		GenericLibrary.waitForElementVisibility(driver, searchNetworkBtn);
		JavascriptLibrary.javascriptClickElement(driver, searchNetworkBtn);
		searchNetworkBox.sendKeys(networkName);
		GenericLibrary.waitForAjax(driver);
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//h3[@title='"+networkName+"']")));
		WebElement searchedNetwork = driver.findElement(By.xpath("//span[contains(.,'"+networkName+"')]"));
		Assert.assertTrue(searchedNetwork.isDisplayed(), "Unable to open Given network");
		Reporter.log("Given network opened successfully", true);
		Reporter.log("Opened network is: "+searchedNetwork.getText(), true);
		Assert.assertTrue(networkDashboardLink.isDisplayed(), "Unable to open network Dashbaord");
		Reporter.log("Network Dashboard page for the given network opened successfully", true);
	}

	public void verify_Create_Network_with_old_and_new_companies(String nName, String nDesc,
			String nInvite, String iQInvite, String typeOption, String invType, String visibleType, String rankType, 
			String nwImg, String compTemp, String iQName, String dataTemp) throws Exception {
		AjaxLibrary.jsClick(driver, addNetworkBtn);
		AjaxLibrary.jsClick(driver, nextBtn);
		networkNameTextBox.sendKeys(nName);
		networkDescTextBox.sendKeys(nDesc);
		inviteMessageTextBox.sendKeys(nInvite);
		iQaptureInviteMessageTextBox.sendKeys(iQInvite);
		AjaxLibrary.jsClick(driver, advancedTab);
		GenericLibrary.selectElementByVisibleText(networkTypeDropDown, typeOption);
		GenericLibrary.selectElementByVisibleText(networkInviteTypeDropDown, invType);
		GenericLibrary.selectElementByVisibleText(networkVisibilityDropDown, visibleType);
		GenericLibrary.selectElementByVisibleText(networkRankingTypeDropDown, rankType);
		AjaxLibrary.uploadFile(driver, networkImageUplaodBtn, nwImg);
		AjaxLibrary.jsClick(driver, nextBtn);
		AjaxLibrary.jsClick(driver, nextBtn);
		AjaxLibrary.uploadFile(driver, uploadCompaniesTemplateBtn, compTemp);
		AjaxLibrary.jsClick(driver, nextBtn);
		AjaxLibrary.jsClick(driver, nextBtn);
		AjaxLibrary.jsClick(driver, nextBtn);
		iQaptureNameTextBox.sendKeys(iQName);
		Thread.sleep(1000);
		AjaxLibrary.uploadFile(driver, uploadCompanyDataBtn, dataTemp);
		Assert.assertTrue(CompanyDataListText.isDisplayed(), "Company data Template not uploaded");
		Reporter.log("Compnay data template uploaded successfully", true);
		AjaxLibrary.jsClick(driver, goToDashboardBtn);
		Assert.assertTrue(driver.findElement(By.xpath("//span[contains(.,'"+nName+"')]")).isDisplayed(), "Industry Alliance network Not created");
		Reporter.log("Network created successfully with old and new companies", true);
	}

	




}
