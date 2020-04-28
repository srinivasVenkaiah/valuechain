/**
 * @author UmaMaheswararao
 */

package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
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

public class AdvancedSearchPage extends BasePage {

	// Objects Repository(OR):........................................................................
	// Page verification
	@FindBy(xpath="//label[contains(.,'Advanced Search')]")
	WebElement AdvancedSearchHeaderText;

	// Search by Companies, Products, Services and Projects
	@FindBy(xpath = "//input[contains(@id,'ItemName')]")
	WebElement advancedSearchBox;

	@FindBy(xpath = "//a[contains(@id,'btn_companies')]")
	WebElement companiesTab;

	@FindBy(xpath = "//a[contains(@id,'btn_products')]")
	WebElement productsTab;

	@FindBy(xpath = "//a[contains(@id,'btn_services')]")
	WebElement servicesTab;

	@FindBy(xpath = "//a[contains(@id,'btn_projects')]")
	WebElement projectsTab;

	@FindBy(xpath="//a[contains(@id,'btn_companySites')]")
	WebElement companySitesTab;

	@FindBy(xpath = "//div[contains(@id,'lblResultsCount')]")
	WebElement resultsCount;

	// Search by Tag
	@FindBy(xpath="//a[@title='Filter']")
	WebElement filterBtn;

	@FindBy(xpath="//input[contains(@class,'select2-search__field')]")
	WebElement tagSearchBox;

	@FindBy(id = "btnCloseFilterDlg")
	WebElement closeFilterDlg;

	@FindBy(id="divPROD_PRODUCTSTATUS")
	WebElement productStatusTextBox;

	@FindBy(id="PROD_PRODUCTSTATUS")
	WebElement productStatusDD;

	// Search by iQapture
	@FindBy(xpath="//div[text()='Data captures ']")
	WebElement dataCapturesHeaderText;

	// Filter by status
	@FindBy(xpath="(//span[contains(@class,'box')])[1]")
	WebElement active_status;

	@FindBy(xpath="(//span[contains(@class,'box')])[2]")
	WebElement notUsed_status;

	// Filter by current & maximum production
	@FindBy(xpath="//select[contains(@id,'ddlProdOpt_CurrentProduction')]")
	WebElement currentProductionDD;

	@FindBy(xpath="//select[contains(@id,'ddlProdOpt_MaxProduction')]")
	WebElement maximumProductionDD;

	@FindBy(xpath = "//input[contains(@id,'txtCurrentProduction')]")
	WebElement currentProductionTextBox;

	@FindBy(xpath = "//input[contains(@id,'txtMaxProduction')]")
	WebElement maximumProductionTextBox;

	@FindBy(id="divPROD_CURRENTPROD")
	WebElement result_CurrentProduction;

	@FindBy(id="PROD_CURRENTPROD")
	WebElement result_CurrentProduction_In;

	@FindBy(id="divPROD_MAXIMUMPROD")
	WebElement result_MaximumProduction;

	@FindBy(id="PROD_MAXIMUMPROD")
	WebElement result_MaximumProduction_In;

	// Filter by Type
	@FindBy(xpath="(//span[contains(@class,'box')])[3]")
	WebElement testing_type;

	@FindBy(xpath="(//span[contains(@class,'box')])[4]")
	WebElement inspection_type;

	@FindBy(id="divSVC_SERVICETYPE")
	WebElement servicesTypeTextBox;

	@FindBy(id="SVC_SERVICETYPE")
	WebElement servicesTypeDD;

	// Filter by current & maximum capacity
	@FindBy(xpath = "//select[contains(@id,'ddlSrvOpt_CurrCapacity')]")
	WebElement currentCapacityDD;

	@FindBy(xpath = "//select[contains(@id,'ddlSrvOpt_MaxCapacity')]")
	WebElement maximumCapacityDD;

	@FindBy(xpath = "//input[contains(@id,'txtCurrentCapacity')]")
	WebElement currentCapacityTextBox;

	@FindBy(xpath = "//input[contains(@id,'txtMaxCapacity')]")
	WebElement maximumCapacityTextBox;

	@FindBy(id="divSVC_CURRENTCAPACITY")
	WebElement result_CurrentCapacity;

	@FindBy(id="SVC_CURRENTCAPACITY")
	WebElement result_CurrentCapacity_In;

	@FindBy(id="divSVC_MAXIMUMCAPACITY")
	WebElement result_MaximumCapacity;

	@FindBy(id="SVC_MAXIMUMCAPACITY")
	WebElement result_MaximumCapacity_In;

	// Filter by Funding source
	@FindBy(xpath = "//input[contains(@id,'txtPro_FundingSource')]")
	WebElement fundingSourceTextBox;

	@FindBy(xpath="//div[@id='divCP_FUNDINGSOURCE']")
	WebElement result_FundingSource;

	// Filter by Project value
	@FindBy(xpath = "//select[contains(@id,'ddlProjOpt_MaxCapacity')]")
	WebElement projectValueDD;

	@FindBy(xpath = "//input[contains(@id,'txtProj_Value')]")
	WebElement projectValueTextBox;

	@FindBy(id="divCP_PROJECTVALUE")
	WebElement result_ProjectValue;

	@FindBy(id="CP_PROJECTVALUE")
	WebElement result_ProjectValue_In;

	// Save favorite search 
	@FindBy(xpath="//a[contains(.,'Save this search')]")
	WebElement saveThisSearchBtn;

	@FindBy(xpath = "//input[contains(@id,'NSV_NAME')]")
	WebElement searchNameTextBox;

	@FindBy(xpath = "//button[contains(@onclick,'NSearchEdit.SubmitSave()')]")
	WebElement submitBtn;

	@FindBy(xpath=".//*[@id='ddlSavedSearches']")
	WebElement savedSearchesDD;

	// Remove saved search
	@FindBy(id="btnStopSearch")
	WebElement stopSavingThisSearchBtn;

	// Error message on saving save search multiple times
	@FindBy(xpath = "(//span[contains(.,'Advanced Search')])[2]")
	WebElement AdvancedSeachLink;

	@FindBy(xpath="//div[contains(.,'Save failed')]")
	WebElement saveFailedMessage;

	// Error message on removing saved items without selecting any item
	@FindBy(xpath="//button[text()='Go']")
	WebElement GoBtn;

	@FindBy(xpath="//div[text()='Please select the saved search.']")
	WebElement pleaseSelectSavedSearchErrMsg;







	// Initializing the Page Objects:................................................................
	public AdvancedSearchPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:......................................................................................
	public void verify_Advanced_Search_Page() {
		Assert.assertTrue(AdvancedSearchHeaderText.isDisplayed(), "Unable to open Advanced Search");
	}

	public void verify_Search_by_Companies() throws Exception{
		JavascriptLibrary.javascriptClickElement(driver, companiesTab);
		List<WebElement> compList = driver.findElements(By.xpath("//div[contains(@id, 'Company')]//h3"));
		if (compList.size() != 0) {
			String compSearchItem = compList.get(1).getAttribute("title");
			advancedSearchBox.sendKeys(compSearchItem);
			Thread.sleep(2000);
			if (resultsCount.getText().equalsIgnoreCase("No match data found")) {
				Reporter.log("No match data found", true);
				Assert.fail();
			} else {
				Assert.assertTrue(driver.findElement(By.xpath("//h3[contains(@title,'"+compSearchItem+"')]")).isDisplayed(), "Search by company is not fucntional");
				Reporter.log("Search by company is functional", true);
			}
		} else {
			Reporter.log("No companies found", true);
		}
	}

	public void verify_Search_by_Products() throws Exception{
		JavascriptLibrary.javascriptClickElement(driver, productsTab);
		List<WebElement> prodList = driver.findElements(By.xpath(".//*[@id='ulList_products']//h3"));
		if (prodList.size() != 0) {
			String prodSearchItem = prodList.get(0).getText();
			advancedSearchBox.sendKeys(prodSearchItem);
			Thread.sleep(2000);
			if (resultsCount.getText().equalsIgnoreCase("No match data found")) {
				Reporter.log("No match data found", true);
				Assert.fail();
			} else {
				Assert.assertTrue(driver.findElement(By.xpath("//h3[contains(@title,'"+prodSearchItem+"')]")).isDisplayed(), "Search by product is not fucntional");
				Reporter.log("Search by product is functional", true);
			}
		} else {
			Reporter.log("No products found", true);
		}
	}

	public void verify_Search_by_Services() throws Exception{
		JavascriptLibrary.javascriptClickElement(driver, servicesTab);
		List<WebElement> servList = driver.findElements(By.xpath(".//*[@id='ulList_services']//h3"));
		if (servList.size() != 0) {
			String servSearchItem = servList.get(0).getText();
			advancedSearchBox.sendKeys(servSearchItem);
			Thread.sleep(2000);
			if (resultsCount.getText().equalsIgnoreCase("No match data found")) {
				Reporter.log("No match data found", true);
				Assert.fail();
			} else {
				Assert.assertTrue(driver.findElement(By.xpath("//h3[contains(@title,'"+servSearchItem+"')]")).isDisplayed(), "Search by product is not fucntional");
				Reporter.log("Search by services is functional", true);
			}
		} else {
			Reporter.log("No services found", true);
		}
	}

	public void verify_Search_by_Projects() throws Exception{
		JavascriptLibrary.javascriptClickElement(driver, projectsTab);
		List<WebElement> projList = driver.findElements(By.xpath(".//*[@id='ulList_projects']//h3"));
		if (projList.size() != 0) {
			String projSearchItem = projList.get(0).getText();
			advancedSearchBox.sendKeys(projSearchItem);
			Thread.sleep(2000);
			if (resultsCount.getText().equalsIgnoreCase("No match data found")) {
				Reporter.log("No match data found", true);
				Assert.fail();
			} else {
				Assert.assertTrue(driver.findElement(By.xpath("//h3[contains(@title,'"+projSearchItem+"')]")).isDisplayed(), "Search by product is not fucntional");
				Reporter.log("Search by projects is functional", true);
			}
		} else {
			Reporter.log("No projects found", true);
		}
	}

	public void verify_Search_by_Company_sites() throws Exception{
		JavascriptLibrary.javascriptClickElement(driver, companySitesTab);
		List<WebElement> sitesList = driver.findElements(By.xpath(".//*[@id='ulList_companySites']//h3"));
		if (sitesList.size() != 0) {
			String siteSearchItem = sitesList.get(0).getText();
			advancedSearchBox.sendKeys(siteSearchItem);
			Thread.sleep(2000);
			if (resultsCount.getText().equalsIgnoreCase("No match data found")) {
				Reporter.log("No match data found", true);
				Assert.fail();
			} else {
				Assert.assertTrue(driver.findElement(By.xpath("//h3[contains(@title,'"+siteSearchItem+"')]")).isDisplayed(), "Search by company sites is not fucntional");
				Reporter.log("Search by company sites is functional", true);
			}
		} else {
			Reporter.log("No company sites found", true);
		}
	}

	public void verify_Filter_by_Tag_option(String tag) throws Exception {
		SoftAssert a = new SoftAssert();
		String winHandleBefore = driver.getWindowHandle(); // Storing the original window  
		GenericLibrary.click(driver, filterBtn);
		Thread.sleep(1000);
		tagSearchBox.sendKeys(tag);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[contains(text(),'"+tag+"')]/preceding::div[1]")).click();
		AjaxLibrary.jsClick(driver, closeFilterDlg);
		// Companies  
		if (resultsCount.getText().equalsIgnoreCase("No match data found")) {
			Reporter.log("'No match data found' for the given tag in companies", true);
		} else {
			List<WebElement> compList = driver.findElements(By.xpath(".//*[@id='divTabContent']//h3"));
			AjaxLibrary.jsClick(driver, compList.get(0));
			GenericLibrary.switchToNewWindow_new(driver);
			GenericLibrary.click(driver, productStatusTextBox);
			Assert.assertEquals(GenericLibrary.getFirstSelectedOption(productStatusDD).toUpperCase(), tag.toUpperCase(), "Given tag not found");
			/*Assert.assertTrue(ActionUtils.getElement(driver, By.xpath("//h4[text()='Company details']")).isDisplayed(), "Given tag not found");
			Reporter.log("Given tag found for the search results", true);
			Assert.assertTrue(ActionUtils.getElement(driver, By.xpath("//span[text()='ACTIVE']")).isDisplayed(), "Given tag not found");*/
			Reporter.log("Given tag found for the search results", true);
			driver.close();
			driver.switchTo().window(winHandleBefore); // Switching to original window
		}
		// Products
		JavascriptLibrary.javascriptClickElement(driver, productsTab);
		Thread.sleep(2000);
		if (resultsCount.getText().equalsIgnoreCase("No match data found")) {
			Reporter.log("'No match data found' for the given tag in products", true);
		} 
		else {
			List<WebElement> prodList = driver.findElements(By.xpath(".//*[@id='divTabContent']//h3"));
			GenericLibrary.click(driver, prodList.get(0));
			GenericLibrary.switchToNewWindow_new(driver);
			Thread.sleep(2000);
			AjaxLibrary.click(driver, productStatusTextBox);
			Assert.assertEquals(GenericLibrary.getFirstSelectedOption(productStatusDD).toUpperCase(), tag.toUpperCase(), "Given tag not found for products");
			Reporter.log("Given tag found for the products results", true);
			driver.close();
			driver.switchTo().window(winHandleBefore); // Switching to original window
		}
		// Services
		JavascriptLibrary.javascriptClickElement(driver, servicesTab);
		Thread.sleep(2000);
		GenericLibrary.waitForElementVisibility(driver, resultsCount);
		if (resultsCount.getText().equalsIgnoreCase("No match data found")) {
			Reporter.log("'No match data found' for the given tag in services", true);
		} else {
			List<WebElement> servList = driver.findElements(By.xpath(".//*[@id='divTabContent']//h3"));
			GenericLibrary.click(driver, servList.get(0));
			GenericLibrary.switchToNewWindow_new(driver);
			Thread.sleep(2000);
			AjaxLibrary.click(driver, productStatusTextBox);
			Assert.assertEquals(GenericLibrary.getFirstSelectedOption(productStatusDD).toUpperCase(), tag.toUpperCase(), "Given tag not found for services");
			Reporter.log("Given tag found for the services results", true);
			driver.close();
			driver.switchTo().window(winHandleBefore); // Switching to original window
		}
		// Projects
		JavascriptLibrary.javascriptClickElement(driver, projectsTab);
		Thread.sleep(2000);
		if (resultsCount.getText().equalsIgnoreCase("No match data found")) {
			Reporter.log("'No match data found' for the given tag in projects", true);
		} else {
			List<WebElement> projList = driver.findElements(By.xpath(".//*[@id='divTabContent']//h3"));
			GenericLibrary.click(driver, projList.get(0));
			GenericLibrary.switchToNewWindow_new(driver);
			Thread.sleep(2000);
			WebElement addedTagToProject = driver.findElement(By.xpath(".//*[@id='divProjectTags']/span[1]"));
			Assert.assertTrue(addedTagToProject.getText().equalsIgnoreCase(tag), "Given tag not found for projects");
			Reporter.log("Given tag found for the projects results", true);
			driver.close();
			driver.switchTo().window(winHandleBefore); // Switching to original window
		}
		a.assertAll();
	}

	public void verify_Filter_by_iQapture_option() {
		AjaxLibrary.jsClick(driver, filterBtn);
		Assert.assertTrue(dataCapturesHeaderText.isDisplayed(), "Filter by iQapture is not functional");
		Reporter.log("Filter by iQapture is functional", true);

		AjaxLibrary.jsClick(driver, closeFilterDlg);
	}

	public void verify_Filter_by_status() throws Exception {
		SoftAssert a = new SoftAssert();
		String winHandleBefore = driver.getWindowHandle(); // Storing the original window  
		// Active 
		AjaxLibrary.jsClick(driver, productsTab);
		//JavascriptLibrary.javascriptClickElement(driver, productsTab);
		try {
			List<WebElement> prodList = driver.findElements(By.xpath("//*[@id='ulList_products']//h3"));
			GenericLibrary.waitForListOfElementsVisibility(driver, prodList);
			if (prodList.size() != 0) {
				AjaxLibrary.jsClick(driver, filterBtn);
				AjaxLibrary.jsClick(driver, closeFilterDlg);

				GenericLibrary.check(active_status);
				List<WebElement> activeProdList = driver.findElements(By.xpath("//*[@id='ulList_products']//h3"));
				GenericLibrary.waitForListOfElementsVisibility(driver, activeProdList);
				AjaxLibrary.jsClick(driver, activeProdList.get(0));
				GenericLibrary.switchToNewWindow_new(driver);
				GenericLibrary.click(driver, productStatusTextBox);
				a.assertEquals(GenericLibrary.getFirstSelectedOption(productStatusDD), "Active", "Filter by Active status is not functional");
				Reporter.log("Filter by 'Active' status is functional", true);
				driver.close();
				driver.switchTo().window(winHandleBefore); // Switching to original window
			} else {
				a.assertTrue(resultsCount.getText().equalsIgnoreCase("No match data found"), "'No match data found' message is not displaying for zero results");
				Reporter.log("'No match data found' for the Active status", true);
			}
		} catch (NoSuchElementException | TimeoutException e) {
			a.assertTrue(resultsCount.getText().equalsIgnoreCase("No match data found"), "'No match data found' message is not displaying for zero results");
			Reporter.log("'No match data found' for the Active status", true);
		}
		// Not used
		GenericLibrary.check(notUsed_status);
		try {
			List<WebElement> notUsedProdList = driver.findElements(By.xpath("//*[@id='ulList_products']//h3"));
			GenericLibrary.waitForListOfElementsVisibility(driver, notUsedProdList);
			if (notUsedProdList.size() != 0) {
				GenericLibrary.click(driver, notUsedProdList.get(0));
				GenericLibrary.switchToNewWindow_new(driver);
				Thread.sleep(2000);
				AjaxLibrary.click(driver, productStatusTextBox);
				a.assertEquals(GenericLibrary.getFirstSelectedOption(productStatusDD), "Not used", "Filter by Not used status is not functional");
				Reporter.log("Filter by 'Not used' status is functional", true);
				driver.close();
				driver.switchTo().window(winHandleBefore); // Switching to original window
			} else {
				a.assertTrue(resultsCount.getText().equalsIgnoreCase("No match data found"), "'No match data found' message is not displaying for zero results");
				Reporter.log("'No match data found' for the Not used status", true);
			}
		} catch (NoSuchElementException | TimeoutException e) {
			a.assertTrue(resultsCount.getText().equalsIgnoreCase("No match data found"), "'No match data found' message is not displaying for zero results");
			Reporter.log("'No match data found' for the Not used status", true);
		}
		a.assertAll();
	}

	public void verify_Filter_by_Current_production_and_Maximum_production(String cpOption, String c, String mpOption, String m) throws Exception {
		SoftAssert a = new SoftAssert();
		int cp = Integer.parseInt(c.replace(".0", ""));
		int mp = Integer.parseInt(m.replace(".0", ""));
		String winHandleBefore = driver.getWindowHandle(); // Storing the original window  
		JavascriptLibrary.javascriptClickElement(driver, productsTab);
		try {
			List<WebElement> prodList = driver.findElements(By.xpath(".//*[@id='ulList_products']//h3"));
			GenericLibrary.waitForListOfElementsVisibility(driver, prodList);
			if (prodList.size() != 0) {
				AjaxLibrary.jsClick(driver, filterBtn);
				AjaxLibrary.jsClick(driver, closeFilterDlg);

				GenericLibrary.selectElementByVisibleText(currentProductionDD, cpOption);
				currentProductionTextBox.sendKeys(String.valueOf(cp));
				GenericLibrary.selectElementByVisibleText(maximumProductionDD, mpOption);
				maximumProductionTextBox.sendKeys(String.valueOf(mp));
				GenericLibrary.waitForAjax(driver);
				try {
					List<WebElement> sortList = driver.findElements(By.xpath(".//*[@id='ulList_products']//h3"));
					GenericLibrary.waitForListOfElementsVisibility(driver, sortList);
					for (WebElement ele : sortList) {
						AjaxLibrary.jsClick(driver, ele);
						GenericLibrary.switchToNewWindow_new(driver);
						GenericLibrary.click(driver, result_CurrentProduction);
						int cpv = Integer.parseInt(result_CurrentProduction_In.getAttribute("value"));
						AjaxLibrary.jsClick(driver, result_MaximumProduction);
						int mpv = Integer.parseInt(result_MaximumProduction_In.getAttribute("value"));

						if ((cpOption.equals("=") && mpOption.equals("="))){
							a.assertTrue(((cpv == cp) && (mpv == mp)), "Filter by production values is Not functional");
						} else if((cpOption.equals("=") && mpOption.equals(">"))){
							a.assertTrue(((cpv == cp) && (mpv > mp)), "Filter by production values is Not functional");
						} else if((cpOption.equals("=") && mpOption.equals(">="))){
							a.assertTrue(((cpv == cp) && (mpv >= mp)), "Filter by production values is Not functional");
						} else if((cpOption.equals("=") && mpOption.equals("<"))){
							a.assertTrue(((cpv == cp) && (mpv < mp)), "Filter by production values is Not functional");
						} else if((cpOption.equals("=") && mpOption.equals("<="))){
							a.assertTrue(((cpv == cp) && (mpv <= mp)), "Filter by production values is Not functional");
						} else if((cpOption.equals(">") && mpOption.equals("="))){
							a.assertTrue(((cpv > cp) && (mpv == mp)), "Filter by production values is Not functional");
						} else if((cpOption.equals(">") && mpOption.equals(">"))){
							a.assertTrue(((cpv > cp) && (mpv > mp)), "Filter by production values is Not functional");
						} else if((cpOption.equals(">") && mpOption.equals(">="))){
							a.assertTrue(((cpv > cp) && (mpv >= mp)), "Filter by production values is Not functional");
						} else if((cpOption.equals(">") && mpOption.equals("<"))){
							a.assertTrue(((cpv > cp) && (mpv < mp)), "Filter by production values is Not functional");
						} else if((cpOption.equals(">") && mpOption.equals("<="))){
							a.assertTrue(((cpv > cp) && (mpv <= mp)), "Filter by production values is Not functional");
						} else if((cpOption.equals(">=") && mpOption.equals("="))){
							a.assertTrue(((cpv >= cp) && (mpv == mp)), "Filter by production values is Not functional");
						} else if((cpOption.equals(">=") && mpOption.equals(">"))){
							a.assertTrue(((cpv >= cp) && (mpv > mp)), "Filter by production values is Not functional");
						} else if((cpOption.equals(">=") && mpOption.equals(">="))){
							a.assertTrue(((cpv >= cp) && (mpv >= mp)), "Filter by production values is Not functional");
						} else if((cpOption.equals(">=") && mpOption.equals("<"))){
							a.assertTrue(((cpv >= cp) && (mpv < mp)), "Filter by production values is Not functional");
						} else if((cpOption.equals(">=") && mpOption.equals("<="))){
							a.assertTrue(((cpv >= cp) && (mpv <= mp)), "Filter by production values is Not functional");
						} else if((cpOption.equals("<") && mpOption.equals("="))){
							a.assertTrue(((cpv < cp) && (mpv == mp)), "Filter by production values is Not functional");
						} else if((cpOption.equals("<") && mpOption.equals(">"))){
							a.assertTrue(((cpv < cp) && (mpv > mp)), "Filter by production values is Not functional");
						} else if((cpOption.equals("<") && mpOption.equals(">="))){
							a.assertTrue(((cpv < cp) && (mpv >= mp)), "Filter by production values is Not functional");
						} else if((cpOption.equals("<") && mpOption.equals("<"))){
							a.assertTrue(((cpv < cp) && (mpv < mp)), "Filter by production values is Not functional");
						} else if((cpOption.equals("<") && mpOption.equals("<="))){
							a.assertTrue(((cpv < cp) && (mpv <= mp)), "Filter by production values is Not functional");
						} else if((cpOption.equals("<=") && mpOption.equals("="))){
							a.assertTrue(((cpv <= cp) && (mpv == mp)), "Filter by production values is Not functional");
						} else if((cpOption.equals("<=") && mpOption.equals(">"))){
							a.assertTrue(((cpv <= cp) && (mpv > mp)), "Filter by production values is Not functional");
						} else if((cpOption.equals("<=") && mpOption.equals(">="))){
							a.assertTrue(((cpv <= cp) && (mpv >= mp)), "Filter by production values is Not functional");
						} else if((cpOption.equals("<=") && mpOption.equals("<"))){
							a.assertTrue(((cpv <= cp) && (mpv < mp)), "Filter by production values is Not functional");
						} else if((cpOption.equals("<=") && mpOption.equals("<="))){
							a.assertTrue(((cpv <= cp) && (mpv <= mp)), "Filter by production values is Not functional");
						} else {
							System.out.println("Invalid option");
						} 

						Reporter.log("Given current produnction value: "+cp+" Maximum production value: "+mp, true);
						Reporter.log(""+cpv+" is "+cpOption+" "+cp+" and "+mpv+" is "+mpOption+" "+mp, true);
						driver.close();
						driver.switchTo().window(winHandleBefore); // Switching to original window
					}
				} catch (NoSuchElementException | TimeoutException e) {
					a.assertTrue(resultsCount.getText().equalsIgnoreCase("No match data found"), "'No match data found' message is not displaying for zero results");
					Reporter.log("'No match data found' for filter by production", true);
				}
			} else {
				a.assertTrue(resultsCount.getText().equalsIgnoreCase("No match data found"), "'No match data found' message is not displaying for zero results");
				Reporter.log("'No match data found' for filter by production", true);
			}
		} catch (NoSuchElementException | TimeoutException e) {
			a.assertTrue(resultsCount.getText().equalsIgnoreCase("No match data found"), "'No match data found' message is not displaying for zero results");
			Reporter.log("'No match data found' for filter by production", true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		a.assertAll();
	}

	public void verify_Filter_by_Type() throws Exception {
		SoftAssert a = new SoftAssert();
		String winHandleBefore = driver.getWindowHandle(); // Storing the original window  
		// Testing
		AjaxLibrary.jsClick(driver, servicesTab);
		try {
			List<WebElement> prodList = driver.findElements(By.xpath("//*[@id='ulList_services']//h3"));
			GenericLibrary.waitForListOfElementsVisibility(driver, prodList);
			if (prodList.size() != 0) {
				AjaxLibrary.jsClick(driver, filterBtn);
				AjaxLibrary.jsClick(driver, closeFilterDlg);

				GenericLibrary.check(testing_type);
				List<WebElement> activeProdList = driver.findElements(By.xpath("//*[@id='ulList_services']//h3"));
				GenericLibrary.waitForListOfElementsVisibility(driver, activeProdList);
				AjaxLibrary.jsClick(driver, activeProdList.get(0));
				GenericLibrary.switchToNewWindow_new(driver);
				GenericLibrary.click(driver, servicesTypeTextBox);
				a.assertEquals(GenericLibrary.getFirstSelectedOption(servicesTypeDD), "Testing", "Filter by Testing type is not functional");
				Reporter.log("Filter by 'Testing' type is functional", true);
				driver.close();
				driver.switchTo().window(winHandleBefore); // Switching to original window
			} else {
				a.assertTrue(resultsCount.getText().equalsIgnoreCase("No match data found"), "'No match data found' message is not displaying for zero results");
				Reporter.log("'No match data found' for the Testing type", true);
			}
		} catch (NoSuchElementException | TimeoutException e) {
			a.assertTrue(resultsCount.getText().equalsIgnoreCase("No match data found"), "'No match data found' message is not displaying for zero results");
			Reporter.log("'No match data found' for the Testing type", true);
		}
		// Inspection
		GenericLibrary.check(inspection_type);
		try {
			List<WebElement> notUsedProdList = driver.findElements(By.xpath("//*[@id='ulList_services']//h3"));
			GenericLibrary.waitForListOfElementsVisibility(driver, notUsedProdList);
			if (notUsedProdList.size() != 0) {
				GenericLibrary.click(driver, notUsedProdList.get(0));
				GenericLibrary.switchToNewWindow_new(driver);
				Thread.sleep(2000);
				AjaxLibrary.click(driver, servicesTypeTextBox);
				a.assertEquals(GenericLibrary.getFirstSelectedOption(servicesTypeDD), "Inspection", "Filter by Inspection type is not functional");
				Reporter.log("Filter by 'Inspection' type is functional", true);
				driver.close();
				driver.switchTo().window(winHandleBefore); // Switching to original window
			} else {
				a.assertTrue(resultsCount.getText().equalsIgnoreCase("No match data found"), "'No match data found' message is not displaying for zero results");
				Reporter.log("'No match data found' for the Inspection type", true);
			}
		} catch (NoSuchElementException | TimeoutException e) {
			a.assertTrue(resultsCount.getText().equalsIgnoreCase("No match data found"), "'No match data found' message is not displaying for zero results");
			Reporter.log("'No match data found' for the Inspection type", true);
		}
		a.assertAll();
	}

	public void verify_Filter_by_Current_capacity_and_Maximum_capacity(String ccOption, String c, String mcOption, String m) throws Exception {
		int cc = Integer.parseInt(c.replace(".0", ""));
		int mc = Integer.parseInt(m.replace(".0", ""));
		String winHandleBefore = driver.getWindowHandle(); // Storing the original window  
		AjaxLibrary.jsClick(driver, servicesTab);
		try {
			List<WebElement> servList = driver.findElements(By.xpath("//*[@id='ulList_services']//h3"));
			GenericLibrary.waitForListOfElementsVisibility(driver, servList);
			if (servList.size() != 0) {
				AjaxLibrary.jsClick(driver, filterBtn);
				AjaxLibrary.jsClick(driver, closeFilterDlg);				

				GenericLibrary.selectElementByVisibleText(currentCapacityDD, ccOption);
				currentCapacityTextBox.sendKeys(String.valueOf(cc));
				GenericLibrary.selectElementByVisibleText(maximumCapacityDD, mcOption);
				maximumCapacityTextBox.sendKeys(String.valueOf(mc));
				GenericLibrary.waitForAjax(driver);
				try {
					List<WebElement> sortList = driver.findElements(By.xpath("//*[@id='ulList_services']//h3"));
					GenericLibrary.waitForListOfElementsVisibility(driver, sortList);
					for (WebElement ele : sortList) {
						AjaxLibrary.jsClick(driver, ele);
						GenericLibrary.switchToNewWindow_new(driver);
						GenericLibrary.click(driver, result_CurrentCapacity);
						int ccv = Integer.parseInt(result_CurrentCapacity_In.getAttribute("value"));
						GenericLibrary.click(driver, result_MaximumCapacity);
						int mcv = Integer.parseInt(result_MaximumCapacity_In.getAttribute("value"));

						if ((ccOption.equals("=") && mcOption.equals("="))){
							Assert.assertTrue(((ccv == cc) && (mcv == mc)), "Filter by capacity values is Not functional");
						} else if((ccOption.equals("=") && mcOption.equals(">"))){
							Assert.assertTrue(((ccv == cc) && (mcv > mc)), "Filter by capacity values is Not functional");
						} else if((ccOption.equals("=") && mcOption.equals(">="))){
							Assert.assertTrue(((ccv == cc) && (mcv >= mc)), "Filter by capacity values is Not functional");
						} else if((ccOption.equals("=") && mcOption.equals("<"))){
							Assert.assertTrue(((ccv == cc) && (mcv < mc)), "Filter by capacity values is Not functional");
						} else if((ccOption.equals("=") && mcOption.equals("<="))){
							Assert.assertTrue(((ccv == cc) && (mcv <= mc)), "Filter by capacity values is Not functional");
						} else if((ccOption.equals(">") && mcOption.equals("="))){
							Assert.assertTrue(((ccv > cc) && (mcv == mc)), "Filter by capacity values is Not functional");
						} else if((ccOption.equals(">") && mcOption.equals(">"))){
							Assert.assertTrue(((ccv > cc) && (mcv > mc)), "Filter by capacity values is Not functional");
						} else if((ccOption.equals(">") && mcOption.equals(">="))){
							Assert.assertTrue(((ccv > cc) && (mcv >= mc)), "Filter by capacity values is Not functional");
						} else if((ccOption.equals(">") && mcOption.equals("<"))){
							Assert.assertTrue(((ccv > cc) && (mcv < mc)), "Filter by capacity values is Not functional");
						} else if((ccOption.equals(">") && mcOption.equals("<="))){
							Assert.assertTrue(((ccv > cc) && (mcv <= mc)), "Filter by capacity values is Not functional");
						} else if((ccOption.equals(">=") && mcOption.equals("="))){
							Assert.assertTrue(((ccv >= cc) && (mcv == mc)), "Filter by capacity values is Not functional");
						} else if((ccOption.equals(">=") && mcOption.equals(">"))){
							Assert.assertTrue(((ccv >= cc) && (mcv > mc)), "Filter by capacity values is Not functional");
						} else if((ccOption.equals(">=") && mcOption.equals(">="))){
							Assert.assertTrue(((ccv >= cc) && (mcv >= mc)), "Filter by capacity values is Not functional");
						} else if((ccOption.equals(">=") && mcOption.equals("<"))){
							Assert.assertTrue(((ccv >= cc) && (mcv < mc)), "Filter by capacity values is Not functional");
						} else if((ccOption.equals(">=") && mcOption.equals("<="))){
							Assert.assertTrue(((ccv >= cc) && (mcv <= mc)), "Filter by capacity values is Not functional");
						} else if((ccOption.equals("<") && mcOption.equals("="))){
							Assert.assertTrue(((ccv < cc) && (mcv == mc)), "Filter by capacity values is Not functional");
						} else if((ccOption.equals("<") && mcOption.equals(">"))){
							Assert.assertTrue(((ccv < cc) && (mcv > mc)), "Filter by capacity values is Not functional");
						} else if((ccOption.equals("<") && mcOption.equals(">="))){
							Assert.assertTrue(((ccv < cc) && (mcv >= mc)), "Filter by capacity values is Not functional");
						} else if((ccOption.equals("<") && mcOption.equals("<"))){
							Assert.assertTrue(((ccv < cc) && (mcv < mc)), "Filter by capacity values is Not functional");
						} else if((ccOption.equals("<") && mcOption.equals("<="))){
							Assert.assertTrue(((ccv < cc) && (mcv <= mc)), "Filter by capacity values is Not functional");
						} else if((ccOption.equals("<=") && mcOption.equals("="))){
							Assert.assertTrue(((ccv <= cc) && (mcv == mc)), "Filter by capacity values is Not functional");
						} else if((ccOption.equals("<=") && mcOption.equals(">"))){
							Assert.assertTrue(((ccv <= cc) && (mcv > mc)), "Filter by capacity values is Not functional");
						} else if((ccOption.equals("<=") && mcOption.equals(">="))){
							Assert.assertTrue(((ccv <= cc) && (mcv >= mc)), "Filter by capacity values is Not functional");
						} else if((ccOption.equals("<=") && mcOption.equals("<"))){
							Assert.assertTrue(((ccv <= cc) && (mcv < mc)), "Filter by capacity values is Not functional");
						} else if((ccOption.equals("<=") && mcOption.equals("<="))){
							Assert.assertTrue(((ccv <= cc) && (mcv <= mc)), "Filter by capacity values is Not functional");
						} else {
							System.out.println("Invalid option");
						} 

						Reporter.log("Given current capacity value: "+cc+" Maximum capacity value: "+mc, true);
						Reporter.log(""+ccv+" is "+ccOption+" "+cc+" and "+mcv+" is "+mcOption+" "+mc, true);
						driver.close();
						driver.switchTo().window(winHandleBefore); // Switching to original window
					}
				} catch (NoSuchElementException | TimeoutException e) {
					Assert.assertTrue(resultsCount.getText().equalsIgnoreCase("No match data found"), "'No match data found' message is not displaying for zero results");
					Reporter.log("'No match data found' for filter by capacity", true);
				}
			} else {
				Assert.assertTrue(resultsCount.getText().equalsIgnoreCase("No match data found"), "'No match data found' message is not displaying for zero results");
				Reporter.log("'No match data found' for filter by capacity", true);
			}
		} catch (NoSuchElementException | TimeoutException e) {
			Assert.assertTrue(resultsCount.getText().equalsIgnoreCase("No match data found"), "'No match data found' message is not displaying for zero results");
			Reporter.log("'No match data found' for filter by capacity", true);
		}
	}

	public void verify_Filter_by_Funding_Source(String fs) throws Exception {
		String winHandleBefore = driver.getWindowHandle(); // Storing the original window  
		// Funding Source
		AjaxLibrary.jsClick(driver, projectsTab);
		try {
			List<WebElement> prodList = driver.findElements(By.xpath("//*[@id='ulList_projects']//h3"));
			GenericLibrary.waitForListOfElementsVisibility(driver, prodList);
			if (prodList.size() != 0) {
				AjaxLibrary.jsClick(driver, filterBtn);
				AjaxLibrary.jsClick(driver, closeFilterDlg);

				fundingSourceTextBox.sendKeys(fs);
				GenericLibrary.waitForAjax(driver);
				List<WebElement> fsList = driver.findElements(By.xpath("//*[@id='ulList_projects']//h3"));
				GenericLibrary.waitForListOfElementsVisibility(driver, fsList);
				GenericLibrary.click(driver, fsList.get(0));
				GenericLibrary.switchToNewWindow_new(driver);
				GenericLibrary.waitForElementVisibility(driver, result_FundingSource);
				Assert.assertTrue(result_FundingSource.getText().equalsIgnoreCase(fs), "Filter by Funding source is not functional");
				Reporter.log("Filter by 'Funding source' is functional", true);
				driver.close();
				driver.switchTo().window(winHandleBefore); // Switching to original window
			} else {
				Assert.assertTrue(resultsCount.getText().equalsIgnoreCase("No match data found"), "'No match data found' message is not displaying for zero results");
				Reporter.log("'No match data found' for the Funding source", true);
			}
		} catch (NoSuchElementException | TimeoutException e) {
			Assert.assertTrue(resultsCount.getText().equalsIgnoreCase("No match data found"), "'No match data found' message is not displaying for zero results");
			Reporter.log("'No match data found' for the Funding source", true);
		}
	}

	public void verify_Filter_by_Project_value(String pvOption, String p) throws Exception {
		int pv = Integer.parseInt(p.replace(".0", ""));
		String winHandleBefore = driver.getWindowHandle(); // Storing the original window  
		AjaxLibrary.jsClick(driver, projectsTab);
		try {
			List<WebElement> projList = driver.findElements(By.xpath("//*[@id='ulList_projects']//h3"));
			GenericLibrary.waitForListOfElementsVisibility(driver, projList);
			if (projList.size() != 0) {
				AjaxLibrary.jsClick(driver, filterBtn);
				AjaxLibrary.jsClick(driver, closeFilterDlg);

				GenericLibrary.selectElementByVisibleText(projectValueDD, pvOption);
				projectValueTextBox.sendKeys(String.valueOf(pv));
				GenericLibrary.waitForAjax(driver);
				try {
					List<WebElement> sortList = driver.findElements(By.xpath("//*[@id='ulList_projects']//h3"));
					GenericLibrary.waitForListOfElementsVisibility(driver, sortList);
					for (WebElement ele : sortList) {
						AjaxLibrary.jsClick(driver, ele);
						GenericLibrary.switchToNewWindow_new(driver);
						Thread.sleep(2000);
						GenericLibrary.click(driver, result_ProjectValue);
						int rpv = Integer.parseInt(result_ProjectValue_In.getAttribute("value"));

						if (pvOption.equals("=")){
							Assert.assertTrue(rpv == pv, "Filter by project value is Not functional");
						} else if(pvOption.equals(">")){
							Assert.assertTrue(rpv > pv, "Filter by project value is Not functional");
						} else if(pvOption.equals(">=")){
							Assert.assertTrue(rpv >= pv, "Filter by project value is Not functional");
						} else if(pvOption.equals("<")){
							Assert.assertTrue(rpv < pv, "Filter by project value is Not functional");
						} else if(pvOption.equals("<=")){
							Assert.assertTrue(rpv <= pv, "Filter by project value is Not functional");
						} else {
							System.out.println("Invalid option");
						} 

						Reporter.log("Given Project value: "+pv+" and selected condition: "+pvOption, true);
						Reporter.log(rpv+" is "+pvOption+" "+pv, true);
						driver.close();
						driver.switchTo().window(winHandleBefore); // Switching to original window
					}
				} catch (NoSuchElementException | TimeoutException e) {
					Assert.assertTrue(resultsCount.getText().equalsIgnoreCase("No match data found"), "'No match data found' message is not displaying for zero results");
					Reporter.log("'No match data found' for filter by Project value", true);
				}
			} else {
				Assert.assertTrue(resultsCount.getText().equalsIgnoreCase("No match data found"), "'No match data found' message is not displaying for zero results");
				Reporter.log("'No match data found' for filter by Project value", true);
			}
		} catch (NoSuchElementException | TimeoutException e) {
			Assert.assertTrue(resultsCount.getText().equalsIgnoreCase("No match data found"), "'No match data found' message is not displaying for zero results");
			Reporter.log("'No match data found' for filter by Project value", true);
		}
	}

	public void verify_Save_favorite_search(String cpOption, String c, String mpOption, String m, String favName) throws InterruptedException {
		int cp = Integer.parseInt(c.replace(".0", ""));
		int mp = Integer.parseInt(m.replace(".0", ""));
		JavascriptLibrary.javascriptClickElement(driver, productsTab);
		AjaxLibrary.jsClick(driver, filterBtn);
		AjaxLibrary.jsClick(driver, closeFilterDlg);

		GenericLibrary.check(active_status);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.selectElementByVisibleText(currentProductionDD, cpOption);
		currentProductionTextBox.sendKeys(String.valueOf(cp));
		GenericLibrary.selectElementByVisibleText(maximumProductionDD, mpOption);
		maximumProductionTextBox.sendKeys(String.valueOf(mp));
		GenericLibrary.waitForAjax(driver);
		AjaxLibrary.jsClick(driver, saveThisSearchBtn);
		//GenericLibrary.click(driver, saveThisSearchBtn);
		//Thread.sleep(1000);
		GenericLibrary.sendKeys(driver, searchNameTextBox, 20, favName);
		JavascriptLibrary.javascriptClickElement(driver, submitBtn);
		GenericLibrary.waitForAjax(driver);
		Assert.assertTrue(VerificationLibrary.isOptionPresentInTheDropdown(savedSearchesDD, favName), "Search not saved");
		Reporter.log("Search saved successfully", true);
	}

	public void verify_Remove_favorite_search(String favName) throws Exception {
		AjaxLibrary.selectElementByVisibleText(driver, savedSearchesDD, favName);
		AjaxLibrary.jsClick(driver, GoBtn);
		AjaxLibrary.jsClick(driver, stopSavingThisSearchBtn);
		List<WebElement> options = GenericLibrary.getAllOptionsFromTheDropdown(savedSearchesDD);
		for (WebElement ele : options) {
			Assert.assertNotEquals(ele.getText(), favName, "Favorite search not removed");
		}
	}

	public void verify_Error_message_on_saving_same_search_multiple_times(String favName) {
		// Attempt 1
		AjaxLibrary.jsClick(driver, productsTab);
		AjaxLibrary.jsClick(driver, filterBtn);
		AjaxLibrary.jsClick(driver, closeFilterDlg);

		GenericLibrary.check(active_status);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.click(driver, saveThisSearchBtn);
		GenericLibrary.waitForElementVisibility(driver, searchNameTextBox);
		searchNameTextBox.sendKeys(favName);
		JavascriptLibrary.javascriptClickElement(driver, submitBtn);
		GenericLibrary.waitForAjax(driver);
		// Attempt 2
		AjaxLibrary.jsClick(driver, AdvancedSeachLink);
		AjaxLibrary.jsClick(driver, productsTab);
		AjaxLibrary.jsClick(driver, active_status);
		AjaxLibrary.jsClick(driver, saveThisSearchBtn);
		GenericLibrary.waitForElementVisibility(driver, searchNameTextBox);
		searchNameTextBox.sendKeys(favName);
		JavascriptLibrary.javascriptClickElement(driver, submitBtn);
		GenericLibrary.waitForAjax(driver);
		Assert.assertTrue(saveFailedMessage.isDisplayed(), "'Save failed' message Not displaying for duplicate entries");
		Reporter.log("'Save failed' message is displaying successfully for duplicate entries", true);
	}

	public void verify_Error_message_on_removing_saved_item_without_selecting_any_saved_item() {
		AjaxLibrary.jsClick(driver, GoBtn);
		Assert.assertTrue(pleaseSelectSavedSearchErrMsg.isDisplayed(), "No warning message on removing saved items without selecting saved item");
		Reporter.log("Warning message on removing saved items without selecting any saved item is displayed successfully", true);
	}

	public void verify_filter_by_BOM(String bomOption) throws Exception {
		AjaxLibrary.jsClick(driver, productsTab);
		AjaxLibrary.jsClick(driver, filterBtn);
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//a[contains(.,'"+bomOption+"')]")));
		AjaxLibrary.jsClick(driver, closeFilterDlg);
		Assert.assertTrue(driver.findElement(By.xpath("//span[contains(.,'"+bomOption+"')]")).isDisplayed());
		Reporter.log("BOM option selected: "+bomOption, true);
		try {
			List<WebElement> projList = driver.findElements(By.xpath(".//*[@id='ulList_products']//h3"));
			GenericLibrary.waitForListOfElementsVisibility(driver, projList);
			if (projList.size() != 0) {
				List<WebElement> sortList = driver.findElements(By.xpath(".//*[@id='ulList_products']//h3"));
				GenericLibrary.waitForListOfElementsVisibility(driver, sortList);
				AjaxLibrary.jsClick(driver, sortList.get(0));
				GenericLibrary.switchToNewWindow_new(driver);
				Thread.sleep(2000);
				Assert.assertTrue(driver.findElement(By.xpath("//span[contains(.,'"+bomOption+"')]")).isDisplayed(), "Filter by BOM option is not functional");
				Reporter.log("Filter by BOM option is functional", true);
			} else {
				Assert.assertTrue(resultsCount.getText().equalsIgnoreCase("No match data found"), "'No match data found' message is not displaying for zero results");
				Reporter.log("'No match data found' for filter by Project value", true);
			}
		} catch (NoSuchElementException | TimeoutException e) {
			Assert.assertTrue(resultsCount.getText().equalsIgnoreCase("No match data found"), "'No match data found' message is not displaying for zero results");
			Reporter.log("'No match data found' for filter by Project value", true);
		}


	}







}
