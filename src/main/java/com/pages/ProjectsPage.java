/**
 * @author UmaMaheswararao
 */

package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.base.BasePage;
import com.util.AjaxLibrary;
import com.util.GenericLibrary;
import com.util.JavascriptLibrary;

public class ProjectsPage extends BasePage {
	// Objects Repository(OR):........................................................................
	// Page verification'
	@FindBy(xpath = "(//span[contains(.,'Projects')])[2]")
	WebElement productsPageHeadderText;

	// Create new Service
	@FindBy(xpath=".//*[@id='btnAdd']//span[2]")
	WebElement addNewServiceBtn;

	@FindBy(xpath = "//input[contains(@id,'CP_NAME')]")
	WebElement nameTextBox;

	@FindBy(xpath = "//textarea[contains(@id,'CP_DESC')]")
	WebElement descriptionTextBox;

	@FindBy(xpath = "//select[contains(@id,'CP_PROJECTTYPE')]")
	WebElement typeDD;

	@FindBy(xpath = "//input[contains(@id,'CP_FUNDINGSOURCE')]")
	WebElement fundingSourceTextBox;

	@FindBy(xpath = "//input[contains(@id,'CP_PROJECTVALUE')]")
	WebElement projectValueTextBox;

	@FindBy(xpath=".//*[@id='saveField']//span[2]")
	WebElement saveProjectBtn;

	@FindBy(xpath="//select[contains(@id,'CP_LOCATION')]")
	WebElement locationDD;

	@FindBy(xpath = "//input[contains(@id,'CP_FUNDED')]")
	WebElement fundedTextBox;

	@FindBy(xpath=".//*[@id='divProjectBOM']/span")
	WebElement addBomBtn;

	@FindBy(xpath="//button[contains(@onclick,'CancelProjectBOMDlg')]")
	WebElement closeBomDlgBtn;

	@FindBy(xpath=".//*[@id='divProjectTags']/span")
	WebElement addTagBtn;

	@FindBy(xpath="//input[contains(@class,'field')]")
	WebElement tagSearchField;

	@FindBy(xpath= "//button[contains(@onclick,'CancelProjectTagDlg')]")
	WebElement closeTagDlgBtn;

	// Detail Spec
	@FindBy(xpath = "//div[contains(@class,'note-editable panel-body')]")
	WebElement detailSpecBody;

	@FindBy(xpath = "//button[contains(@data-original-title,'Link')]")
	WebElement addLinkBtn;

	@FindBy(xpath="//input[contains(@class,'note-link-text')]")
	WebElement noteLinkText;

	@FindBy(xpath="//input[contains(@class,'note-link-url')]")
	WebElement noteLinkUrl;

	@FindBy(xpath="//button[contains(.,'Insert Link')]")
	WebElement insertLinkBtn;

	@FindBy(xpath = "//button[contains(@data-original-title,'Picture')]")
	WebElement pictureBtn;

	@FindBy(xpath="//input[contains(@name,'files')]")
	WebElement browsePictureBtn;

	@FindBy(xpath = "//button[contains(@data-original-title,'Video')]")
	WebElement videoBtn;

	@FindBy(xpath="//input[contains(@class,'note-video-url')]")
	WebElement videoUrlField;

	@FindBy(xpath="//button[contains(.,'Insert Video')]")
	WebElement insertVideoBtn;

	// Documents tab
	@FindBy(xpath = "//h2[contains(.,'DOCUMENTS')]")
	WebElement documentsTab;

	@FindBy(xpath = "//form[contains(@id,'docsDropzone')]")
	WebElement uploadFileOrPictureBtn;

























	// Initializing the Page Objects:................................................................
	public ProjectsPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:......................................................................................
	public void verify_Projects_page() {
		Assert.assertTrue(productsPageHeadderText.isDisplayed(), "Projects page not opened");
	}

	public void verify_Create_new_project(String name, String desc, String type, String trl, 
			String fs, String pv, String fund, String bomOpt1, String bomOpt2, 
			String bomOpt3, String tag) throws Exception {
		GenericLibrary.click(driver, addNewServiceBtn);
		GenericLibrary.waitForAjax(driver);
		nameTextBox.sendKeys(name);
		descriptionTextBox.sendKeys(desc);
		GenericLibrary.selectElementByVisibleText(typeDD, type);
		driver.findElement(By.xpath("(//label[contains(.,'"+trl.replace(".0", "")+"')])[1]")).click();
		GenericLibrary.waitForAjax(driver);
		fundingSourceTextBox.sendKeys(fs.replace(".0", ""));
		projectValueTextBox.sendKeys(pv.replace(".0", ""));
		fundedTextBox.sendKeys(fund.replace(".0", ""));
		GenericLibrary.click(driver, saveProjectBtn);
		GenericLibrary.waitForAjax(driver);
		Reporter.log("Peoject created successfully", true);
		// BOM
		GenericLibrary.click(driver, addBomBtn);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, driver.findElement(By.xpath("//a[text()='"+bomOpt1+"']")));
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, driver.findElement(By.xpath("//a[text()='"+bomOpt2+"']")));
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, driver.findElement(By.xpath("//a[text()='"+bomOpt3+"']")));
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, closeBomDlgBtn);
		GenericLibrary.waitForAjax(driver);
		Reporter.log("BOM added successfully", true);
		// Tags
		/*GenericLibrary.click(driver, addTagBtn);
		GenericLibrary.waitForAjax(driver);
		tagSearchField.sendKeys(tag);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, driver.findElement(By.xpath("//div[contains(text(),'"+tag+"')]/preceding::div[1]")));
		JavascriptLibrary.javascriptClickElement(driver, closeTagDlgBtn);
		Assert.assertTrue(driver.findElement(By.xpath("(//span[contains(.,'"+tag+"')])[1]")).isDisplayed(), "Tag not added to project");
		Reporter.log("Tag Added to project successfully", true);*/
	}

	public void verify_Add_Detail_spec_to_the_project(String name, String desc, 
			String dsText, String linkName, String url, String filePath, String videoUrl) throws Exception {
		SoftAssert a = new SoftAssert();
		GenericLibrary.click(driver, addNewServiceBtn);
		GenericLibrary.waitForAjax(driver);
		nameTextBox.sendKeys(name);
		descriptionTextBox.sendKeys(desc);
		GenericLibrary.click(driver, saveProjectBtn);
		GenericLibrary.waitForAjax(driver);
		Reporter.log("Service created successfully", true);
		// Detail spec
		detailSpecBody.sendKeys(dsText);
		GenericLibrary.click(driver, addLinkBtn);
		GenericLibrary.waitForAjax(driver);
		noteLinkText.sendKeys(linkName);
		noteLinkUrl.sendKeys(url);
		JavascriptLibrary.javascriptClickElement(driver, insertLinkBtn);
		a.assertTrue(driver.findElement(By.xpath("//a[text()='"+linkName+"']")).isDisplayed(), "Link not added");
		Reporter.log("Link added successfully", true);
		// Picture
		AjaxLibrary.jsClick(driver, pictureBtn);
		AjaxLibrary.uploadFile2(driver, browsePictureBtn, filePath);
		Reporter.log("Image added to the detail spec", true);
		// video
		GenericLibrary.click(driver, videoBtn);
		GenericLibrary.waitForAjax(driver);
		videoUrlField.sendKeys(videoUrl);
		JavascriptLibrary.javascriptClickElement(driver, insertVideoBtn);
		Reporter.log("Video clip inserted successfully", true);
	}

	public void verify_Documents_tab_and_Upload_file_or_picture(String name, String desc, 
			String filePath1, String filePath2, String defStatus, String modStatus, String filePath3) throws Exception {
		SoftAssert a = new SoftAssert();
		GenericLibrary.click(driver, addNewServiceBtn);
		GenericLibrary.waitForAjax(driver);
		nameTextBox.sendKeys(name);
		descriptionTextBox.sendKeys(desc);
		GenericLibrary.click(driver, saveProjectBtn);
		GenericLibrary.waitForAjax(driver);
		Reporter.log("Service created successfully", true);
		// Image
		JavascriptLibrary.javascriptClickElement(driver, documentsTab);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.uploadFile(uploadFileOrPictureBtn, filePath1);
		GenericLibrary.waitForAjax(driver);
		a.assertTrue(driver.findElement(By.xpath("(//i[contains(@title,'Remove')]/following::img)[1]")).isDisplayed(), "Image 1 not uploaded");
		Reporter.log("Image 1 uploaded successfully", true);
		GenericLibrary.uploadFile(uploadFileOrPictureBtn, filePath2);
		GenericLibrary.waitForAjax(driver);
		a.assertTrue(driver.findElement(By.xpath("(//i[contains(@title,'Remove')]/following::img)[2]")).isDisplayed(), "Image 2 not uploaded");
		Reporter.log("Image 2 uploaded successfully", true);
		// Set as main image and Cancel main image
		String defaultStatus = driver.findElement(By.xpath("(//h3/img)[2]/preceding::button[1]")).getAttribute("title");
		a.assertEquals(defaultStatus, defStatus, "First uploaded image not set as main image");
		Reporter.log("First uploaded image set as main image by default", true);
		GenericLibrary.click(driver, driver.findElement(By.xpath("(//h3/img)[2]/preceding::button[1]")));
		GenericLibrary.waitForAjax(driver);
		String changedStatus = driver.findElement(By.xpath("(//h3/img)[2]/preceding::button[1]")).getAttribute("title");
		a.assertEquals(changedStatus, modStatus, "First uploaded image not set as main image");
		Reporter.log("Default image Cancelled as main image successfully", true);
		// File
		GenericLibrary.uploadFile(uploadFileOrPictureBtn, filePath3);
		GenericLibrary.waitForAjax(driver);
		a.assertTrue(driver.findElement(By.xpath("(//i[contains(@title,'Remove')]/following::a)[1]")).isDisplayed(), "Image 2 not uploaded");
		Reporter.log("File uploaded successfully", true);
	}








}






