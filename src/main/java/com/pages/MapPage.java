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

import com.base.BasePage;
import com.util.AjaxLibrary;
import com.util.GenericLibrary;
import com.util.JavascriptLibrary;
import com.util.VerificationLibrary;
import com.util.Wrappers;

public class MapPage extends BasePage {

	// Objects Repository(OR):........................................................................
	// Navigate to company profile page
	@FindBy(xpath="//span[contains(@id,'lblCompanyName')]")
	WebElement companyNameField;

	// Add tags to company
	By addTagsToCompanyBtn = By.xpath("//i[@class='fa fa-tags']");

	@FindBy(xpath="//input[contains(@type,'search')]")
	WebElement tagSearchBox;

	@FindBy(xpath="//button[contains(@onclick,'CancelCompanyTagDlg')]")
	WebElement closeTagDlgBoxBtn;

	// Add new company
	@FindBy(xpath="//input[contains(@id,'txtCompanyName')]")
	WebElement companyNameTextBox;

	@FindBy(xpath = "//input[contains(@id,'txtFirstName')]")
	WebElement firstNameTextBox;

	@FindBy(xpath = "//input[contains(@id,'txtLastName')]")
	WebElement lastNameTextBox;

	@FindBy(xpath = "//input[contains(@id,'txtContactEmail')]")
	WebElement emailTextBox;

	@FindBy(xpath="//button[contains(.,'Add as new company')]")
	WebElement addAsNewCompanyBtn;

	@FindBy(xpath="(//div[contains(.,'Add successfully')])[4]")
	WebElement addSuccessfullyMsg;

	@FindBy(xpath="//button[contains(@onclick,'MapConnections.CloseNewCompanyDlg()')]")
	WebElement closeNewCompanyDlgBtn;

	@FindBy(xpath="//button[@data-bb-handler='confirm'][contains(.,'Yes')]")
	WebElement YesBtn;







	// Initializing the Page Objects:................................................................
	public MapPage() {
		PageFactory.initElements(driver, this);
	}


	// Actions:......................................................................................
	public void verify_Map_page() {
		List<WebElement> compList = driver.findElements(By.xpath("//*[contains(@id,'cvCompany')]"));
		Assert.assertTrue(compList.size() != 0, "Map page not opened");
	}

	public void verify_Navigate_to_company_profile_page_from_map(String compName) throws Exception {
		List<WebElement> compList = driver.findElements(By.xpath("//*[contains(@id,'cvCompany')]"));
		for (int i = 0; i < compList.size(); i++) {
			String name = compList.get(i).getAttribute("company");
			if (name.equalsIgnoreCase(compName)) {
				AjaxLibrary.jsClick(driver, compList.get(i));
				AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("(//a[contains(.,'Company profile')])["+(i+1)+"]")));
			}			
		}
		Thread.sleep(2000);
		GenericLibrary.switchToNewWindow(driver); 
		GenericLibrary.waitForAjax(driver);
		Thread.sleep(2000);
		Assert.assertTrue(companyNameField.getText().equalsIgnoreCase(compName), "Unable to navigate company profile page");
	}

	public void verify_Add_tag_to_the_company_from_map(String compName, String tag) throws Exception {
		List<WebElement> compList = driver.findElements(By.xpath("//*[contains(@id,'cvCompany')]"));
		for (int i = 0; i < compList.size(); i++) {
			String name = compList.get(i).getAttribute("company");
			if (name.equalsIgnoreCase(compName)) {
				AjaxLibrary.jsClick(driver, compList.get(i));
				AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("(//a[contains(.,'Company profile')])["+(i+1)+"]")));
			}			
		}
		GenericLibrary.switchToNewWindow_new(driver);
		GenericLibrary.click(driver, driver.findElement(addTagsToCompanyBtn));
		Thread.sleep(1000);
		try {
			tagSearchBox.sendKeys(tag);
			Thread.sleep(1000);
		} catch (NoSuchElementException e) {
			Wrappers.click(driver, addTagsToCompanyBtn);
		}
		JavascriptLibrary.javascriptClickElement(driver, driver.findElement(By.xpath("//div[contains(text(),'"+tag+"')]/preceding::div[1]")));
		JavascriptLibrary.javascriptClickElement(driver, closeTagDlgBoxBtn);
		Assert.assertTrue(driver.findElement(By.xpath("(//span[contains(.,'"+tag+"')])[1]")).isDisplayed(), "Tag not added to company");
	}

	public void verify_Add_new_company_from_map(String compName, String cName, String fName, String lName, String email) throws Exception {
		List<WebElement> compList = driver.findElements(By.xpath("//*[contains(@id,'cvCompany')]"));
		for (int i = 0; i < compList.size(); i++) {
			String name = compList.get(i).getAttribute("company");
			if (name.equalsIgnoreCase(compName)) {
				JavascriptLibrary.javascriptClickElement(driver, compList.get(i));
				GenericLibrary.waitForAjax(driver);
				GenericLibrary.click(driver, driver.findElement(By.xpath("(//a[contains(@id,'btnAddCompany')])["+(i+1)+"]")));
			}			
		}
		GenericLibrary.waitForAjax(driver);
		companyNameTextBox.sendKeys(cName);
		firstNameTextBox.sendKeys(fName);
		lastNameTextBox.sendKeys(lName);
		emailTextBox.sendKeys(email);
		GenericLibrary.click(driver, addAsNewCompanyBtn);
		GenericLibrary.waitForAjax(driver);
		Assert.assertTrue(addSuccessfullyMsg.isDisplayed(), "No confirmation message displayed on adding company");
		Reporter.log("'Add successfully' message displayed", true);
		JavascriptLibrary.javascriptClickElement(driver, closeNewCompanyDlgBtn);
		GenericLibrary.waitForAjax(driver);
	}

	public void verify_Download_template(String compName, String downloadPath, String fileName) throws Exception {
		List<WebElement> compList = driver.findElements(By.xpath("//*[contains(@id,'cvCompany')]"));
		for (int i = 0; i < compList.size(); i++) {
			String name = compList.get(i).getAttribute("company");
			if (name.equalsIgnoreCase(compName)) {
				JavascriptLibrary.javascriptClickElement(driver, compList.get(i));
				GenericLibrary.waitForAjax(driver);
				GenericLibrary.click(driver, driver.findElement(By.xpath("(//a[contains(@id,'btnDownloadTmp')])["+(i+1)+"]")));
			}			
		}
		GenericLibrary.waitForAjax(driver);
		Thread.sleep(2000);
		Assert.assertTrue(VerificationLibrary.isFileDownloaded(downloadPath, fileName), "Template not downloaded");
	}

	public void verify_Upload_template(String filePath) throws Exception {
		List<WebElement> compList = driver.findElements(By.xpath("//*[contains(@id,'cvCompany')]"));
		int count = compList.size();
		Reporter.log("No.of companies before upload: "+count, true);
		GenericLibrary.click(driver, compList.get(0));
		WebElement uploadBtn = driver.findElement(By.xpath("(//a[contains(@id,'btnUploadCompanies')])[1]"));
		AjaxLibrary.uploadFile(driver, uploadBtn, filePath);
		List<WebElement> compList2 = driver.findElements(By.xpath("//*[contains(@id,'cvCompany')]"));
		int count2 = compList2.size();
		Reporter.log("No.of companies after upload: "+count2, true);
		Assert.assertTrue(count2 > count, "Template not uploaded");
	}

	public void verify_Disconnect_the_company_from_map() throws Exception {
		List<WebElement> compList = driver.findElements(By.xpath("//span[contains(@title,'Disconnection')]"));
		int count = compList.size();
		Reporter.log("No.of companies before disconnection: "+count, true);
		if (count != 0) {
			GenericLibrary.click(driver, compList.get(0));
			GenericLibrary.waitForAjax(driver);
			GenericLibrary.waitForElementVisibility(driver, YesBtn);
			JavascriptLibrary.javascriptClickElement(driver, YesBtn);
			GenericLibrary.waitForAjax(driver);
			List<WebElement> compList2 = driver.findElements(By.xpath("//span[contains(@title,'Disconnection')]"));
			int count2 = compList2.size();
			Reporter.log("No.of companies after disconnection: "+count2, true);
			Assert.assertTrue(count2 < count, "Company not disconnected");
		} else {
			Reporter.log("No connected companies available", true);
		}
	}





























}















