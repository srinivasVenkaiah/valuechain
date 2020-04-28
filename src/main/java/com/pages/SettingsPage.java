/**
 * @author UmaMaheswararao
 */

package com.pages;

import java.sql.Driver;
import java.util.List;
import java.util.jar.Attributes.Name;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

public class SettingsPage extends BasePage {
	// Objects Repository(OR):........................................................................
	//Page verification
	@FindBy(xpath = "//span[contains(.,'General')]")
	WebElement generalHeaderText;

	// Create network specific tag
	@FindBy(xpath = "//a[contains(@id,'btnAddNetworkTag')]")
	WebElement createNewTagBtn;

	@FindBy(xpath = "//input[contains(@id,'txtNetworkNewTagName')]")
	WebElement tagNameField;

	@FindBy(xpath="//select[@id='ddlColorTags']")
	WebElement selectTagDropdown;

	@FindBy(xpath = "//button[contains(@class,'color-dropdown')]")
	WebElement colourDD;

	@FindBy(xpath="(//label[text()='Description'])[2]/following::textarea")
	WebElement descriptionField;

	@FindBy(id="btnSubmitByNewNetworkTag")
	WebElement submitBtn;

	@FindBy(xpath = "//a[contains(@title,'Delete tag')]")
	WebElement deleteTagBtn;

	@FindBy(xpath="//div[text()='Are you sure you want to delete this tag?']")
	WebElement tagDeleteConfirmationMsg;

	@FindBy(xpath = "//button[@data-bb-handler='confirm'][contains(.,'Yes')]")
	WebElement yesBtn;

	@FindBy(xpath = "//span[contains(@id,'divError_NetworkTag_Name')]")
	WebElement tagNameFieldErrorMsg;

	// Hide and Unhide menu
	@FindBy(xpath="//span[contains(@style,'color: #FFFFFF;')]")
	WebElement currentUserAcc;

	@FindBy(linkText="myAccount")
	WebElement myAccountLink;

	@FindBy(xpath="//span[text()='Log in as']")
	WebElement LoginAsBtn;

	@FindBy(id="txtUserSearch")
	WebElement logInEmailTextBox;

	@FindBy(xpath="//span[contains(text(),'Re Login')]")
	WebElement reLogInBtn;

	@FindBy(xpath="//button[@type='button']/span[contains(.,'GET STARTED')]")
	WebElement letsGetStartedBtn;

	@FindBy(xpath="(//span[text()='NEXT'])[1]")
	WebElement nextBtn_yourDetailsPage;

	@FindBy(xpath="//input[@id='UserPWD']")
	WebElement passwordField;



	@FindBy(xpath="//a[text()='valuechain.com']//following::div[2]")
	WebElement viosMenu;

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

	// Capability group creation
	By AddGroup = By.xpath("//a[@title='Create a group']");
	
	@FindBy(xpath="//input[@id='txtGroupName']")
	WebElement GroupName;
	
	//By GroupName = By.xpath("//input[@id='txtGroupName']");
	//By SaveGroup = By.xpath("//i[@class='fa fa-save']");
	@FindBy(xpath="//i[@class='fa fa-save']")
	WebElement SaveGroup;
	
	By EnterGrpName = By.xpath("//span[text()='Please enter Group Name.']");
	By DeleteGroup = By.xpath("//i[@class='fa fa-trash']");
	By DeleteYesMsg = By.xpath("//div[text()='Are you sure to delete it?']");
	By DeleteYes = By.xpath("//button[text()='Yes']");
	By GrpON = By.xpath("//span[text()='ON']");
	By ADS = By.xpath("//a[text()='ADS']");



	//Register iQluster
	By password = By.xpath("//input[@title='Password']");
	By confirmPwd = By.xpath("//input[@title='Confirm Password']");
	By DetailsPageNext = By.xpath("(//span[text()='NEXT'])[1]");
	By companyNext = By.xpath("(//span[text()='NEXT'])[2]");
	By capabilitiesNext = By.xpath("(//span[text()='NEXT'])[3]");
	By createUserNext = By.xpath("(//span[text()='NEXT'])[4]");
	By SetMeUp = By.xpath("//span[text()='SET ME UP']");

	By MyCompanies = By.xpath("//span[contains(.,'myCompanies')]");









	// Initializing the Page Objects:................................................................
	public SettingsPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:......................................................................................
	public void verify_Settings_page() {
		Assert.assertTrue(generalHeaderText.isDisplayed(), "Settings page not opened");
	}

	public void verify_Create_network_specific_tag_and_verify_it_in_Networkdashboard_and_Companies_page_select_tag_options(
			String tagName, String colour, String desc) throws Exception {
		SoftAssert a = new SoftAssert();
		AjaxLibrary.jsClick(driver, createNewTagBtn);
		GenericLibrary.waitForElementVisibility(driver, tagNameField);
		tagNameField.sendKeys(tagName);
		AjaxLibrary.jsClick(driver, colourDD);
		AjaxLibrary.jsClick(driver, By.xpath("//span[text()='"+colour.toLowerCase()+"']"));
		descriptionField.sendKeys(desc);
		AjaxLibrary.jsClick(driver, submitBtn);
		Assert.assertTrue(driver.findElement(By.xpath("//span[text()='"+tagName+"']")).isDisplayed(), "Network specific tag not created");
		Reporter.log("Network specific tag created", true);
		// Verify Created Network Tag in Network Dashboard -> On Location Map
		AjaxLibrary.jsClick(driver, MyNetworkListPage.networkDashboardLink);
		driver.switchTo().frame("_myDlgFrm_locationmap");
		List<WebElement> tagList = GenericLibrary.getAllOptionsFromTheDropdown(selectTagDropdown);
		boolean networkDashboardTag = false;
		for (WebElement ele : tagList) {
			if (ele.getText().equals(tagName)) {
				networkDashboardTag = true;
			}
		}
		a.assertTrue(networkDashboardTag, "Added tag not reflected in network dashboard home select tag options");
		Reporter.log("Added tag reflected in network dashboard home select tag options", true);
		// Verify Created Network Tag in Companies List page
		driver.switchTo().defaultContent();
		AjaxLibrary.jsClick(driver, NetworkDashBoardPage.CompaniesBoard);
		List<WebElement> tagList1 = GenericLibrary.getAllOptionsFromTheDropdown(selectTagDropdown);
		boolean companyTag = false;
		for (WebElement ele : tagList1) {
			if (ele.getText().equals(tagName)) {
				companyTag = true;
			}
		}
		a.assertTrue(companyTag, "Added tag not reflected in company board select tag options");
		Reporter.log("Added tag reflected in company board select tag options", true);
		// Created Network Tag in inside the company
		List<WebElement> companylist = driver.findElements(By.xpath("//div[@id='ulList']//h3"));
		AjaxLibrary.jsClick(driver, companylist.get(1));
		AjaxLibrary.jsClick(driver, NetworkDashBoardPage.companyTagsBtn);
		GenericLibrary.sendKeys(driver, NetworkDashBoardPage.companyTagsSearchBox, 20, tagName);
		a.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'"+tagName+"')]")).isDisplayed(), "Tag not displayed in company tag options");
		Reporter.log("Added tag reflected in company tag options", true);
		a.assertAll();
	}

	public void verify_Delete_network_specific_tag(String tagName, String colour, String desc, String tagMsg) throws Exception {
		SoftAssert a = new SoftAssert();
		AjaxLibrary.jsClick(driver, createNewTagBtn);
		GenericLibrary.waitForElementVisibility(driver, tagNameField);
		tagNameField.sendKeys(tagName);
		AjaxLibrary.jsClick(driver, colourDD);
		AjaxLibrary.jsClick(driver, By.xpath("//span[text()='"+colour.toLowerCase()+"']"));
		descriptionField.sendKeys(desc);
		AjaxLibrary.jsClick(driver, submitBtn);
		Assert.assertTrue(driver.findElement(By.xpath("//span[text()='"+tagName+"']")).isDisplayed(), "Network specific tag not created");
		Reporter.log("Network specific tag created", true);
		// Deletion
		AjaxLibrary.jsClick(driver, By.xpath("//span[text()='"+tagName+"']"));
		AjaxLibrary.jsClick(driver, deleteTagBtn);
		Thread.sleep(500);
		a.assertEquals(tagDeleteConfirmationMsg.getText(), tagMsg, "Tag delete confirmation message not displayed");
		Reporter.log("Tag delete confirmation message displayed", true);
		AjaxLibrary.jsClick(driver, yesBtn);
		try {
			Assert.assertTrue(driver.findElement(By.xpath("//span[text()='"+tagName+"']")).isDisplayed(), "Network specific tag not deleted");
			Assert.fail("Network specific tag not deleted");
		} catch (NoSuchElementException e) {
			Reporter.log("Network specific tag deleted", true);
		}

		a.assertAll();
	}

	public void verify_Add_network_tag_without_tag_name_and_verify_error_msg(String expMsg) throws Exception {
		AjaxLibrary.jsClick(driver, createNewTagBtn);
		GenericLibrary.waitForElementVisibility(driver, submitBtn);
		AjaxLibrary.jsClick(driver, submitBtn);
		Assert.assertEquals(tagNameFieldErrorMsg.getText(), expMsg, "No Error message displayed on adding tag without tag name");
		Reporter.log("Error message displayed on adding tag without tag name", true);
	}

	public void verify_Default_visibility_of_network_menu_for_the_network_connected_user(String user, String network) throws Exception {
		SoftAssert a = new SoftAssert();
		// Login as network connected user and verify all menu options should display
		AjaxLibrary.jsClick(driver, currentUserAcc);
		AjaxLibrary.jsClick(driver, myAccountLink);
		AjaxLibrary.jsClick(driver, LoginAsBtn);
		logInEmailTextBox.sendKeys(user);
		GenericLibrary.waitForAjax(driver);
		WebElement newLoginAcc = driver.findElement(By.xpath("//td[text()='"+user+"']"));
		AjaxLibrary.jsClick(driver, newLoginAcc);
		AjaxLibrary.jsClick(driver, reLogInBtn);
		ActionUtils.ajaxJsClick(driver, LoginPage.menuBtn);
		ActionUtils.ajaxJsClick(driver, LoginPage.iQlusterApp);
		ActionUtils.hoverToElement(driver, By.xpath("//span[text()='TC User 1 ']"));
		ActionUtils.ajaxJsClick(driver, MyCompanies);
		ActionUtils.ajaxJsClick(driver, By.xpath("//span[text()='TC26 ']"));
		// Register to valuechain 
		//AjaxLibrary.jsClick(driver, letsGetStartedBtn);
		/*ActionUtils.sendKeys(driver, password, "Test123");
		ActionUtils.sendKeys(driver, confirmPwd, "Test123");
		ActionUtils.ajaxJsClick(driver, DetailsPageNext);
		ActionUtils.ajaxJsClick(driver, companyNext);
		ActionUtils.ajaxJsClick(driver, capabilitiesNext);
		ActionUtils.ajaxJsClick(driver, createUserNext);
		ActionUtils.ajaxJsClick(driver, SetMeUp);*/
		Thread.sleep(2000);
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//h3[contains(@title,'"+network+"')]")));
		Reporter.log("***** Default results *****", true);
		a.assertTrue(NetworkDashBoardPage.networkDashBoardLink.isDisplayed(), "Network dashboard not displayed by default for the network connected user");
		Reporter.log("Network dashboard displayed by default for the network connected user", true);
		a.assertTrue(NetworkDashBoardPage.PersonalisedDashboardLink.isDisplayed(), "Personalised dashboard not displayed by default for the network connected user");
		Reporter.log("Personalised dashboard displayed by default for the network connected user", true);
		a.assertTrue(NetworkDashBoardPage.AdvancedSearchLink.isDisplayed(), "Advanced search not displayed by default for the network connected user");
		Reporter.log("Advanced search displayed by default for the network connected user", true);
		a.assertTrue(NetworkDashBoardPage.ExploreLink.isDisplayed(), "Explore not displayed by default for the network connected user");
		Reporter.log("Explore displayed by default for the network connected user", true);
		a.assertTrue(NetworkDashBoardPage.MapLink.isDisplayed(), "Map not displayed by default for the network connected user");
		Reporter.log("Map displayed by default for the network connected user", true);
		a.assertTrue(NetworkDashBoardPage.LocationMapLink.isDisplayed(), "Location map not displayed by default for the network connected user");
		Reporter.log("Location map displayed by default for the network connected user", true);
		a.assertTrue(NetworkDashBoardPage.DataCaptureLink.isDisplayed(), "Datacapture not displayed by default for the network connected user");
		Reporter.log("Datacapture displayed by default for the network connected user", true);
		a.assertFalse(NetworkDashBoardPage.AnalyseLink.isDisplayed(), "Analyse displayed by default for the network connected user");
		Reporter.log("Analyse not displayed by default for the network connected user", true);
		a.assertAll();
	}

	public void verify_Network_menu_invisibility_after_unckecking_options_for_the_network_connected_user(String user, String network) throws Exception {
		SoftAssert a = new SoftAssert();
		// Disable all menu options
		AjaxLibrary.checkbox_Unchecking(driver, cb_NetworkDashboard);
		AjaxLibrary.checkbox_Unchecking(driver, cb_PersonalisedDashboard);
		AjaxLibrary.checkbox_Unchecking(driver, cb_AdvancedSearch);
		AjaxLibrary.checkbox_Unchecking(driver, cb_Explore);
		AjaxLibrary.checkbox_Unchecking(driver, cb_Map);
		AjaxLibrary.checkbox_Unchecking(driver, cb_LocationMap);
		AjaxLibrary.checkbox_Unchecking(driver, cb_DataCapture);
		AjaxLibrary.checkbox_Unchecking(driver, cb_Analyse);
		// Login as network connected user and verify all menu options invisibility
		AjaxLibrary.jsClick(driver, currentUserAcc);
		AjaxLibrary.jsClick(driver, myAccountLink);
		AjaxLibrary.jsClick(driver, LoginAsBtn);
		logInEmailTextBox.sendKeys(user);
		GenericLibrary.waitForAjax(driver);
		WebElement newLoginAcc = driver.findElement(By.xpath("//td[text()='"+user+"']"));
		AjaxLibrary.jsClick(driver, newLoginAcc);
		AjaxLibrary.jsClick(driver, reLogInBtn);
		ActionUtils.ajaxJsClick(driver, LoginPage.menuBtn);
		ActionUtils.ajaxJsClick(driver, LoginPage.iQlusterApp);
		ActionUtils.hoverToElement(driver, By.xpath("//span[text()='TC User 1 ']"));
		ActionUtils.ajaxJsClick(driver, MyCompanies);
		ActionUtils.ajaxJsClick(driver, By.xpath("//span[text()='TC26 ']"));
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//h3[contains(@title,'"+network+"')]")));
		Reporter.log("***** Results after unchecking *****", true);
		// Network dashboard
		try {
			Assert.assertFalse(NetworkDashBoardPage.networkDashBoardLink.isDisplayed());
		} catch (NoSuchElementException e) {
			Reporter.log("Network dashboard not displayed after unchecking", true);
		} catch (AssertionError e) {
			a.fail("Network dashboard displayed after unchecking");
		}
		// Personalised Dashboard
		try {
			Assert.assertFalse(NetworkDashBoardPage.PersonalisedDashboardLink.isDisplayed());
		} catch (NoSuchElementException e) {
			Reporter.log("Personalised dashboard not displayed after unchecking", true);
		} catch (AssertionError e) {
			a.fail("Personalised dashboard displayed after unchecking");
		}
		// Advanced Search
		try {
			Assert.assertFalse(NetworkDashBoardPage.AdvancedSearchLink.isDisplayed());
		} catch (NoSuchElementException e) {
			Reporter.log("Advanced search not displayed after unchecking", true);
		} catch (AssertionError e) {
			a.fail("Advanced search displayed after unchecking");
		}
		// Explore
		try {
			Assert.assertFalse(NetworkDashBoardPage.ExploreLink.isDisplayed());
		} catch (NoSuchElementException e) {
			Reporter.log("Explore not displayed after unchecking", true);
		} catch (AssertionError e) {
			a.fail("Explore displayed after unchecking");
		}
		// Map
		try {
			Assert.assertFalse(NetworkDashBoardPage.MapLink.isDisplayed());
		} catch (NoSuchElementException e) {
			Reporter.log("Map not displayed after unchecking", true);
		} catch (AssertionError e) {
			a.fail("Map displayed after unchecking");
		}
		// Location map
		try {
			Assert.assertFalse(NetworkDashBoardPage.LocationMapLink.isDisplayed());
		} catch (NoSuchElementException e) {
			Reporter.log("Location map not displayed after unchecking", true);
		} catch (AssertionError e) {
			a.fail("Location map displayed after unchecking");
		}
		// Datacapture
		try {
			Assert.assertFalse(NetworkDashBoardPage.DataCaptureLink.isDisplayed());
		} catch (NoSuchElementException e) {
			Reporter.log("Datacapture not displayed after unchecking", true);
		} catch (AssertionError e) {
			a.fail("Datacapture displayed after unchecking");
		}
		// Analyse
		try {
			Assert.assertFalse(NetworkDashBoardPage.AnalyseLink.isDisplayed());
		} catch (NoSuchElementException e) {
			Reporter.log("Analyse not displayed after unchecking", true);
		} catch (AssertionError e) {
			a.fail("Analyse displayed after unchecking");
		}
		a.assertAll();
	}

	public void create_CapabilityGroup(String Name) throws Exception {
		ActionUtils.ajaxJsClick(driver, AddGroup);
		GenericLibrary.click(driver, GroupName);
		GroupName.sendKeys(Name);
		GroupName.sendKeys(Keys.ENTER);
		ActionUtils.ajaxClick(driver, SaveGroup);
		Thread.sleep(1000);
		Assert.assertTrue(ActionUtils.getElement(driver, By.xpath("//span[text()='"+Name+"']")).isDisplayed(), "Group not created");
		Reporter.log("Group created",true);
	}

	public void mandatory_Name_For_CapabilityGroup() {
		ActionUtils.ajaxJsClick(driver, AddGroup);
		ActionUtils.ajaxJsClick(driver, SaveGroup);
		Assert.assertTrue(ActionUtils.getElement(driver, EnterGrpName).isDisplayed(), "Please enter Group name not displayed");
		Reporter.log("Please enter Group name displayed",true);
	}

	public void verify_Already_ExistedGroup(String Name) throws Exception {
		ActionUtils.ajaxJsClick(driver, AddGroup);
		GenericLibrary.click(driver, GroupName);
		GroupName.sendKeys(Name);
		GroupName.sendKeys(Keys.ENTER);
		GenericLibrary.click(driver, SaveGroup);
		GenericLibrary.waitForAlertPresent(driver);
		AjaxLibrary.checkAlert_Accept(driver);
	}
	
	public void delete_Group(String Name) throws Exception {
		SoftAssert a = new SoftAssert();
		ActionUtils.ajaxJsClick(driver, AddGroup);
		GenericLibrary.click(driver, GroupName);
		GroupName.sendKeys(Name);
		Thread.sleep(2000);
		GroupName.sendKeys(Keys.ENTER);
		ActionUtils.ajaxClick(driver, SaveGroup);
		Thread.sleep(1000);
		ActionUtils.ajaxJsClick(driver, By.xpath("//span[text()='"+Name+"']//following::i[@class='fa fa-trash']"));
		a.assertTrue(ActionUtils.getElement(driver, DeleteYesMsg).isDisplayed(), "Delete message not displayed");
		Reporter.log("Delete message displayed",true);
		ActionUtils.ajaxJsClick(driver, DeleteYes);
		Thread.sleep(2000);
		boolean group = true;
		List<WebElement> list = ActionUtils.getElements(driver, By.xpath("//div[@id='divGroupsList']//div//div//div//div//span"));
		for (int i = 0; i < list.size(); i++) {
			String text = list.get(i).getText();
			if (text.equalsIgnoreCase(Name)) {
				group = false;
			}
		}

		a.assertTrue(group, "Group not deleted");
		Reporter.log("Group deleted", true);
		a.assertAll();
	}
	
	public void disable_Group(String Name) throws Exception {
		ActionUtils.ajaxJsClick(driver, AddGroup);
		GenericLibrary.click(driver, GroupName);
		GroupName.sendKeys(Name);
		Thread.sleep(2000);
		GroupName.sendKeys(Keys.ENTER);
		ActionUtils.ajaxJsClick(driver, GrpON);
		ActionUtils.ajaxJsClick(driver, SaveGroup);
		Thread.sleep(1000);
		Assert.assertTrue(ActionUtils.getElement(driver, By.xpath("//span[text()='"+Name+"']")).isDisplayed(), "Group not created");
		Reporter.log("Group created",true);
	}
	
	public void dropCapabilityGroups() {
		//ActionUtils.dragAndDrop_Method3(driver, ADS, toWebElementAttr);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
