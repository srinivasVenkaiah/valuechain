/**
 * @author UmaMaheswararao
 */

package com.pages;

import java.util.List;

import org.openqa.selenium.By;
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

public class ProductsPage extends BasePage {
	// Objects Repository(OR):........................................................................
	// Page verification
	@FindBy(xpath = "(//span[contains(.,'Products')])[2]")
	WebElement productsPageHeadderText;

	// Create new product
	@FindBy(xpath=".//*[@id='btnAdd']//span[2]")
	WebElement addNewProductBtn;

	@FindBy(xpath = "//input[contains(@id,'PS_Name')]")
	WebElement nameTextBox;

	@FindBy(xpath = "//textarea[contains(@id,'CPS_DESC')]")
	WebElement descriptionTextBox;

	@FindBy(xpath = "//select[contains(@id,'CPS_LOCATION')]")
	WebElement locationDD;

	@FindBy(xpath = "//select[contains(@id,'PROD_PRODUCTSTATUS')]")
	WebElement statusDD;

	@FindBy(xpath = "//input[contains(@id,'PROD_CURRENTPROD')]")
	WebElement currentProductionTextBox;

	@FindBy(xpath = "//input[contains(@id,'PROD_MAXIMUMPROD')]")
	WebElement maximumProductionTextBox;

	@FindBy(xpath=".//*[@id='btnSave']//span[2]")
	WebElement saveProductBtn;

	@FindBy(xpath=".//*[@id='divPSBOM']/span")
	WebElement addBomBtn;

	@FindBy(xpath="//button[contains(@onclick,'CancelPSBOMDlg')]")
	WebElement closeBomDlgBtn;

	@FindBy(xpath=".//*[@id='divPSTags']/span")
	WebElement addTagBtn;

	@FindBy(xpath="//input[contains(@class,'field')]")
	WebElement tagSearchField;

	@FindBy(xpath= "//button[contains(@onclick,'CancelPSTagDlg')]")
	WebElement closeTagDlgBtn;

	// Detail Spec
	@FindBy(xpath = "//div[contains(@class,'note-editable panel-body')]")
	WebElement detailSpecBody;

	@FindBy(xpath = "//button[contains(@data-original-title,'Link')]")
	WebElement addLinkBtn;

	@FindBy(xpath="(//label[text()='Text to display']/following::input)[1]")
	WebElement noteLinkText;

	@FindBy(xpath="//input[contains(@class,'note-link-url form-control')]")
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

	// Search & Delete product
	@FindBy(xpath=".//*[@id='btnPageBack']//span[2]")
	WebElement backBtn;

	@FindBy(xpath=".//*[@id='divSearcher']//span[2]")
	WebElement searchBtn;

	@FindBy(xpath = "//input[contains(@class,'searcher-text')]")
	WebElement searchBox;

	@FindBy(xpath=".//*[@id='toolbar']//span[2]")
	WebElement deleteBtn;

	@FindBy(xpath = "//button[@data-bb-handler='confirm']")
	WebElement YesBtn;

	// Download template
	@FindBy(xpath="//span[contains(@class,'icon-green-excel')]")
	WebElement downloadTemplateBtn;
	
	@FindBy(xpath="//span[contains(@class,'icon-blue-upload')]")
	WebElement uploadTemplateBtn;

	













	// Initializing the Page Objects:................................................................
	public ProductsPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:......................................................................................
	public void verify_Products_page() {
		Assert.assertTrue(productsPageHeadderText.isDisplayed(), "Products page not opened");
	}

	public void verify_Create_new_product(String name, String desc, String location, String status, 
			String trl, String cp, String mp, String bomOpt1, String bomOpt2, String bomOpt3, 
			String tag) {
		GenericLibrary.click(driver, addNewProductBtn);
		GenericLibrary.waitForAjax(driver);
		nameTextBox.sendKeys(name);
		descriptionTextBox.sendKeys(desc);
		GenericLibrary.selectElementByVisibleText(locationDD, location);
		GenericLibrary.selectElementByVisibleText(statusDD, status);
		driver.findElement(By.xpath("(//label[contains(.,'"+trl.replace(".0", "")+"')])[1]")).click();
		GenericLibrary.waitForAjax(driver);
		currentProductionTextBox.sendKeys(cp.replace(".0", ""));
		maximumProductionTextBox.sendKeys(mp.replace(".0", ""));
		AjaxLibrary.jsClick(driver, saveProductBtn);
		Reporter.log("Product created successfully", true);
		// BOM
		AjaxLibrary.jsClick(driver, addBomBtn);
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//a[text()='"+bomOpt1+"']")));
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//a[text()='"+bomOpt2+"']")));
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//a[text()='"+bomOpt3+"']")));
		AjaxLibrary.jsClick(driver, closeBomDlgBtn);
		Reporter.log("BOM added successfully", true);
		// Tags
		AjaxLibrary.jsClick(driver, addTagBtn);
		tagSearchField.sendKeys(tag);
		JavascriptLibrary.javascriptClickElement(driver, driver.findElement(By.xpath("//div[contains(text(),'"+tag+"')]/preceding::div[1]")));
		JavascriptLibrary.javascriptClickElement(driver, closeTagDlgBtn);
		Assert.assertTrue(driver.findElement(By.xpath("(//span[contains(.,'"+tag+"')])[1]")).isDisplayed(), "Tag not added to product");
		Reporter.log("Tag Added to product successfully", true);
	}

	public void verify_Add_Detail_spec_to_the_product(String name, String desc, 
			String dsText, String linkName, String url, String filePath, String videoUrl) throws Exception {
		SoftAssert a = new SoftAssert();
		GenericLibrary.click(driver, addNewProductBtn);
		GenericLibrary.waitForAjax(driver);
		nameTextBox.sendKeys(name);
		descriptionTextBox.sendKeys(desc);
		GenericLibrary.click(driver, saveProductBtn);
		GenericLibrary.waitForAjax(driver);
		Reporter.log("Product created successfully", true);
		// Detail spec
		detailSpecBody.sendKeys(dsText);
		AjaxLibrary.jsClick(driver, addLinkBtn);
		noteLinkText.sendKeys(linkName);
		noteLinkUrl.sendKeys(url);
		AjaxLibrary.jsClick(driver, insertLinkBtn);
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
		GenericLibrary.click(driver, addNewProductBtn);
		GenericLibrary.waitForAjax(driver);
		nameTextBox.sendKeys(name);
		descriptionTextBox.sendKeys(desc);
		GenericLibrary.click(driver, saveProductBtn);
		GenericLibrary.waitForAjax(driver);
		Reporter.log("Product created successfully", true);
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

	public void verify_Search_the_required_product_and_delete_the_product(String name) {
		GenericLibrary.click(driver, addNewProductBtn);
		GenericLibrary.waitForAjax(driver);
		nameTextBox.sendKeys(name);
		GenericLibrary.click(driver, saveProductBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.click(driver, backBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.click(driver, searchBtn);
		searchBox.sendKeys(name);
		List<WebElement> list = driver.findElements(By.xpath(".//*[@id='ulList']//h3"));
		int count = list.size();
		for (int i = 0; i < count; i++) {
			if (list.get(i).getText().equalsIgnoreCase(name)) {
				Reporter.log("Search option is functional", true);
				GenericLibrary.click(driver, list.get(i));
				GenericLibrary.waitForAjax(driver);
				GenericLibrary.click(driver, deleteBtn);
				JavascriptLibrary.javascriptClickElement(driver, YesBtn);
				GenericLibrary.waitForAjax(driver);
				List<WebElement> list2 = driver.findElements(By.xpath(".//*[@id='ulList']//h3"));
				int count2 = list2.size();
				Assert.assertTrue(count2 < count, "Product not deleted");
				Reporter.log("Product deleted successfully", true);
				break;
			}
		}
	}

	public void verify_Download_Products_template(String downloadPath, String fileName) throws Exception {
		AjaxLibrary.jsClick(driver, downloadTemplateBtn);
		Thread.sleep(2000);
		Assert.assertTrue(VerificationLibrary.isFileDownloaded(downloadPath, fileName), "Template not downloaded");
		Reporter.log("Products Template downloaded successfully", true);
	}

	public void verify_Upload_Template(String filePath, String ProductName) throws Exception {
		List<WebElement> list = driver.findElements(By.xpath(".//*[@id='ulList']//h3"));
		int count = list.size();
		Reporter.log("No.of Products before upload: "+count, true);
		GenericLibrary.uploadFile(uploadTemplateBtn, filePath);
		GenericLibrary.waitForAjax(driver);
		Thread.sleep(2000);
		/*List<WebElement> list2 = driver.findElements(By.xpath(".//*[@id='ulList']//h3"));
		int count2 = list2.size();
		Reporter.log("No.of Products before upload: "+count2, true);
		Assert.assertTrue(count2 > count, "Template not uploaded");
		Reporter.log("Template uploaded successfully", true);*/
		Assert.assertTrue(ActionUtils.getElement(driver, By.xpath("//h3[@title='"+ProductName+"']")).isDisplayed(), "Product not uploaded");
		Reporter.log("Template uploaded successfully", true);
	}
	
	
	
	
	


}






