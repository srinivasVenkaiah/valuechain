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
import org.testng.asserts.SoftAssert;

import com.base.BasePage;
import com.util.AjaxLibrary;
import com.util.GenericLibrary;
import com.util.JavascriptLibrary;
import com.util.VerificationLibrary;

public class DataCapturePage extends BasePage {

	// Objects Repository(OR):........................................................................
	// Page verification
	@FindBy(xpath = "(//span[contains(.,'Data Capture')])[2]")
	WebElement DataCaptureHeaderText;

	// Create Questionnaire 
	@FindBy(css=".l-btn-icon.icon-add")
	WebElement addiQaptureBtn;

	@FindBy(css="#DS_NAME")
	WebElement questionnaireNametextBox;

	@FindBy(xpath=".//*[@id='btnSave']//span[2]")
	WebElement saveBtn;

	@FindBy(xpath=".//*[@id='btnPageBack']//span[2]")
	WebElement backBtn;

	@FindBy(xpath=".//*[@id='txtSearch']")
	WebElement searchBox;

	@FindBy(css=".l-btn-icon.icon-blue-search2-round-32")
	WebElement searchBtn;

	// Please enter questionnaire name error message 
	@FindBy(xpath=".//*[@id='divError_DS_NAME']")
	WebElement pleaseEnterQuationnaireName_ErrorMessage;

	// Upload image to questionnaire
	@FindBy(xpath=".//*[@id='imgDataset']")
	WebElement uploadImageBtn;

	// Create fields
	@FindBy(xpath="//div[@title='New Item']")
	WebElement addFieldBtn;

	@FindBy(xpath=".//*[@id='F_DESC']")
	WebElement descriptionTextBox;

	@FindBy(xpath=".//*[@id='divFieldMainType0']/span")
	WebElement text;

	@FindBy(xpath="//label[@title='Large box']")
	WebElement largeBox;

	@FindBy(xpath=".//*[@id='divFieldMainType2']/span")
	WebElement date;

	@FindBy(xpath=".//*[@id='divFieldMainType5']/span")
	WebElement uploadFile;

	@FindBy(xpath=".//*[@id='divFieldMainType9']/span")
	WebElement advanced;

	@FindBy(xpath=".//*[@id='divFieldMainType10']/span")
	WebElement section;

	@FindBy(xpath=".//*[@id='divFieldMainType3']/span")
	WebElement number;

	@FindBy(xpath=".//*[@id='divFieldMainType1']/span")
	WebElement multiChoice;

	@FindBy(xpath=".//*[@id='divFieldMainType11']/span")
	WebElement activity;

	// Text - Advanced settings
	@FindBy(xpath=".//*[@id='showFieldMore']")
	WebElement moreBtn;

	@FindBy(xpath=".//*[@id='rdLevel2']")
	WebElement level2Btn;

	@FindBy(xpath=".//*[@id='rdLevel3']")
	WebElement level3Btn;

	@FindBy(xpath=".//*[@id='rdLevel4']")
	WebElement level4Btn;

	@FindBy(xpath=".//*[@id='rdLevel5']")
	WebElement level5Btn;

	@FindBy(xpath=".//*[@id='trNumbering']/div[1]/label[2]")
	WebElement numberManual;

	@FindBy(xpath=".//*[@id='F_CUTMNUMBERING']")
	WebElement numberManualTextBox;

	@FindBy(xpath=".//*[@id='trNumbering']/div[1]/label[3]")
	WebElement numberNone;

	@FindBy(xpath=".//*[@id='trMandatory']/div[1]/div[1]/label[1]")
	WebElement mandatoryYes;

	@FindBy(xpath=".//*[@id='trFieldComment']/div/label[1]")
	WebElement commentYes;

	@FindBy(xpath=".//*[@id='trExtendAnswer']/div/label[1]")
	WebElement additionalAnswersYes;

	@FindBy(xpath=".//*[@id='F_HINT']")
	WebElement hintTextBox;

	@FindBy(xpath="//*[text()='ADVANCED']/following::button[1]")
	WebElement closeMore;

	// MultiChoice 
	@FindBy(xpath=".//*[@id='divFieldSubTypes']/label[2]")
	WebElement dropDowns;

	@FindBy(xpath=".//*[@id='divFieldSubTypes']/label[3]")
	WebElement checkBoxes;

	@FindBy(xpath=".//*[@id='DropdownDefault']/a")
	WebElement defaultDropDownBtn;

	@FindBy(xpath=".//*[@id='btnHML']")
	WebElement highMediumLowBtn;

	@FindBy(xpath=".//*[@id='btnYNN']")
	WebElement yesNoNaBtn;

	// MultiChoice Upload button 
	@FindBy(xpath = "//a[contains(.,'100')]")
	WebElement uploadedItem;

	// Date
	@FindBy(xpath=".//*[@id='divFieldSubTypes']/label[2]")
	WebElement dateAndTime;

	@FindBy(xpath=".//*[@id='divFieldSubTypes']/label[3]")
	WebElement time;

	@FindBy(xpath=".//*[@id='divFieldSubTypes']/label[4]")
	WebElement weekAndDate;

	// Date Advanced Settings
	@FindBy(xpath=".//*[@id='trDT_DefaultVal']/div/label[1]")
	WebElement defaultValueYes;

	// Number Questionnaire 
	@FindBy(xpath=".//*[@id='divFieldSubTypes']/label[1]")
	WebElement integerOption;

	@FindBy(xpath=".//*[@id='divFieldSubTypes']/label[2]")
	WebElement floatOption;

	@FindBy(xpath=".//*[@id='divFieldSubTypes']/label[3]")
	WebElement percentageOption;

	@FindBy(xpath=".//*[@id='divFieldSubTypes']/label[4]")
	WebElement currencyOption;

	@FindBy(xpath=".//*[@id='divFieldSubTypes']/label[5]")
	WebElement sliderOption;

	@FindBy(xpath=".//*[@id='F_MINVALUE']")
	WebElement sliderMinValue;

	@FindBy(xpath=".//*[@id='F_MAXVALUE']")
	WebElement sliderMaxValue;

	@FindBy(xpath=".//*[@id='F_STEPVALUE']")
	WebElement sliderStepValue;

	// Number - Advanced Settings
	@FindBy(xpath=".//*[@id='trScore']/div[1]/div/label[1]")
	WebElement scoreYesBtn;

	@FindBy(xpath=".//*[@id='trScoreSettings']/div[3]/label[1]")
	WebElement scoreShowIniQaptureYes;

	// Activity Questionnaire
	@FindBy(xpath=".//*[@id='FAI_DESC']")
	WebElement activityDecriptionTxtBox;

	@FindBy(xpath=".//*[@id='FAI_COMMENT']")
	WebElement activityCommentTxtBox;

	@FindBy(xpath=".//*[@id='btnActDate']/span/span")
	WebElement activityDate;

	// Advanced Questionnaire 
	// Table
	@FindBy(xpath=".//*[@id='divFieldSubTypes']/label[1]")
	WebElement tableOption;

	@FindBy(xpath="//a[@title='Create New Sub Field']")
	WebElement addSubFieldBtn;

	@FindBy(xpath="//span[text()='Type:']//following::input[1]")
	WebElement tableHeaderTxtBox;

	@FindBy(xpath="//span[text()='Type:']//following::textarea[1]")
	WebElement tableDescriptionTxtBox;

	@FindBy(xpath="//span[contains(.,'Advanced Table Question')]")
	WebElement tableQuestion;

	@FindBy(xpath="//span[contains(.,'Value Chain')]")
	WebElement tableHeaderQuestion;

	// Property
	@FindBy(xpath=".//*[@id='divFieldSubTypes']/label[2]")
	WebElement propertyOption;

	@FindBy(xpath=".//*[@id='ddlPropertiesAnswerType']")
	WebElement propertyDropDown;

	@FindBy(xpath="//span[contains(.,'Advanced Property Question')]")
	WebElement propertyQuestion;

	// Wizard
	@FindBy(xpath=".//*[@id='divFieldSubTypes']/label[3]")
	WebElement wizardBtn;

	@FindBy(xpath=".//*[@id='F_SUBFIELDSCOUNT']")
	WebElement noOfSubQuestionsTxtBox;

	@FindBy(xpath="//span[contains(.,'Advanced Wizard Question')]")
	WebElement wizardQuestion;

	// Section advanced settings 
	@FindBy(xpath=".//*[@id='trSection_Minimize']/div/label[1]")
	WebElement minimizeYes;

	@FindBy(xpath=".//*[@id='FSI_DESC']")
	WebElement moreDescriptionTextBox;

	// MultiChoice - Radio
	@FindBy(xpath=".//*[@id='trMilestone']/div[1]/label[1]")
	WebElement milestoneYesBtn;

	// MultiChoice - DropDown
	@FindBy(xpath=".//*[@id='trSearchable']/div/label[1]")
	WebElement searchableYesBtn;

	// MultiChoice - CheckBox
	@FindBy(xpath=".//*[@id='F_ANSWERSLIMITMIN']")
	WebElement minAnswersLimitTextBox;

	@FindBy(xpath=".//*[@id='F_ANSWERSLIMITMAX']")
	WebElement maxAnswersLimitTextBox;

	// Create Answers for MultiChoice 
	@FindBy(xpath="//a[contains(@onclick,'FieldEdit.NewRow()')]")
	WebElement createNewFieldBtn;

	// MultiChoice - Copy Questions 
	@FindBy(xpath="//a[@title='Copy Questions']")
	WebElement copyQuestionsBtn;

	@FindBy(xpath="//select[@id='ddlCopyChoice']")
	WebElement copyChoice;

	@FindBy(xpath=".//*[@id='ddlCopyQuestion']")
	WebElement copyQuestion;

	@FindBy(xpath="//a[contains(@onclick,'FieldEdit.ExecCopyMC')]")
	WebElement confirmCopy;

	// MultiCboice - Download Template
	@FindBy(xpath="//a[@title='Download Template']")
	WebElement downloadTemplate;

	// MultiCboice - Upload Template
	@FindBy(xpath="//a[@title='Upload Template']")
	WebElement uploadTemplate;

	// Rename Questionnaire 
	@FindBy(xpath=".//*[@id='divDS_NAME']")
	WebElement questionnaireOutField;

	@FindBy(xpath="//span[contains(@class,'icon-blue-edit')]")
	WebElement editBtn;

	@FindBy(xpath = "//span[contains(.,'Data Capture')]")
	WebElement DataCaptureLink;

	// Removing Questions from the Questionnaire
	@FindBy(xpath="//span[contains(.,'Radio')]")
	WebElement radioQuestion;

	@FindBy(xpath="//span[contains(.,'DropDown')]")
	WebElement dropDownQuestion;

	@FindBy(xpath="//a[@title='Delete']")
	WebElement deleteQuestionBtn;

	// Comment Adding/Updating/Deleting 
	@FindBy(xpath="//*[text()='Comment']")
	WebElement addedComment;

	// Delete Questionnaire
	@FindBy(xpath=".//*[@id='removedataset']//span[2]")
	WebElement deleteQuestionnaireBtn;

	@FindBy(xpath="//button[@data-bb-handler='confirm']")
	WebElement confirmDeleteBtn;

	// Settings
	@FindBy(xpath="//span[contains(@class,'icon-blue-settings')]")
	WebElement settingsBtn;

	@FindBy(xpath="//h5[text()='Display score total on record']//following::label[1]")
	WebElement displayScoreTotalOnRecord_Yes;

	@FindBy(xpath=".//*[@id='divMultiplyS']/div/label[1]")
	WebElement multiplyScores_Yes;

	@FindBy(xpath="//h5[text()='Change record order']//following::label[1]")
	WebElement changeRecordOrder_Yes;

	@FindBy(xpath="//h5[text()='Copy Records']//following::label[1]")
	WebElement copyRecords_Yes;

	@FindBy(xpath="//h5[text()='Show Log']//following::label[1]")
	WebElement showLogs_Yes;

	@FindBy(xpath="//h5[text()='Trash can action']//following::label[2]")
	WebElement trashCanAction_StrikeOut;

	@FindBy(xpath="//h5[text()='Trash can action']//following::label[3]")
	WebElement trashCanAction_Delete;

	@FindBy(css="//span[contains(@class,'icon-green-excel')]")
	WebElement uploadQuestionnaireTemplate;

	// Settings - email to
	@FindBy(xpath="//select[contains(@id,'EmailTo')]")
	WebElement emailToDD;

	@FindBy(xpath="//input[contains(@id,'SendEmail')]")
	WebElement sendEmailBtn;

	@FindBy(xpath="//div[text()='Email Send successfully']")
	WebElement emailSendSuccessfullyMessage;

	// Capture - Activity
	@FindBy(xpath="//span[contains(@class,'icon-back')]")
	WebElement backToCaptureBtn;

	@FindBy(xpath="//span[contains(@class,'icon-add')]")
	WebElement addRecordBtn;

	@FindBy(xpath=".//*[@id='btnSave']//span[2]")
	WebElement saveBtn_Capture;

	@FindBy(xpath=".//*[@id='btnComplete']//span[2]")
	WebElement completeBtn_Capture;

	@FindBy(xpath=".//*[@id='btnReopen']//span[2]")
	WebElement reopenBtn_Capture;

	@FindBy(xpath = "//button[@data-bb-handler='confirm'][contains(.,'OK')]")
	WebElement Ok_Btn;

	@FindBy(xpath="(//span[contains(@id,'lblCF')])[1]")
	WebElement actQIcon;

	@FindBy(xpath="//span[contains(@class,'fa fa-calendar')]")
	WebElement actQTargetDateCalenderBtn;

	@FindBy(xpath = "//span[contains(@title,'Next Month')]")
	WebElement nextMonthBtn;

	@FindBy(xpath="//textarea[contains(@id,'txtActDesc')]")
	WebElement actQDescTxtBox;

	@FindBy(xpath = "//textarea[contains(@id,'txtActComment')]")
	WebElement actQCommentTextBox;

	@FindBy(xpath=".//*[@id='btnAtcComplete']//span[2]")
	WebElement completeBtnCurrentAct;

	@FindBy(xpath="//span[contains(@id,'lblCFCount')]")
	WebElement actQCapCount;

	@FindBy(xpath="//div[@class='bootbox-body'][contains(.,'description is required.')]")
	WebElement activityDescriptionRequiredMessage;

	// Capture - Date
	@FindBy(xpath="//td[contains(@class,'day today')]")
	WebElement todayDateBtn;

	@FindBy(xpath = "//span[@title='Pick Hour']")
	WebElement hourPickBtn;

	@FindBy(xpath = "//span[contains(@title,'Pick Minute')]")
	WebElement minutePickBtn;

	@FindBy(xpath = "//button[contains(@title,'Toggle Period')]")
	WebElement amOrPmPickBtn;

	// Capture - Number
	@FindBy(xpath="//input[contains(@id,'txtInteger')]")
	WebElement integerTextBox;

	@FindBy(xpath="//input[contains(@id,'txtFloat')]")
	WebElement floatTextBox;

	@FindBy(xpath="//input[contains(@id,'txtPercent')]")
	WebElement percentageTextBox;

	@FindBy(xpath = "//input[contains(@id,'txtCurrency')]")
	WebElement currencyTextBox;

	// Capture - Upload
	@FindBy(xpath="//form[contains(@id,'fieldImgDropzone')]")
	WebElement uploadFileBrowseBtn;

	// Capture - Settings - Addition, Copy, Delete
	@FindBy(xpath="//div[contains(@id,'dashboard-report-range')]")
	WebElement scoreTotal;

	@FindBy(xpath=".//*[@id='deleteRecord']//span[2]")
	WebElement deleteRecordsBtn;

	@FindBy(xpath="//td[contains(.,'No matching records found')]")
	WebElement noMatchingRecordsFoundMessage;

	// Capture - Settings2
	@FindBy(xpath="//tr[1]/td[4]/div")
	WebElement strikedOutLine;

	// Download and upload template 
	@FindBy(xpath="//span[contains(@class,'icon-green-excel')]")
	WebElement downloadQuestionsTemplateBtn;

	@FindBy(xpath="//span[contains(@class,'icon-blue-upload')]")
	WebElement uploadAnswerssBtn;


	@FindBy(xpath="//span[text()='Please enter Description.']")
	WebElement actdescbox;








	// Initializing the Page Objects:................................................................
	public DataCapturePage() {
		PageFactory.initElements(driver, this);
	}


	// Actions:......................................................................................
	public void verify_DataCapture_page() {
		Assert.assertTrue(DataCaptureHeaderText.isDisplayed(), "Unable to open data captiure page");
	}

	public void verify_Create_Questionnaire(String questionnaireName) {
		GenericLibrary.waitForElementVisibility(driver, addiQaptureBtn);
		JavascriptLibrary.javascriptClickElement(driver, addiQaptureBtn);
		GenericLibrary.waitForElementVisibility(driver, questionnaireNametextBox);
		JavascriptLibrary.javascriptType(driver, questionnaireNametextBox, questionnaireName);
		JavascriptLibrary.javascriptClickElement(driver, saveBtn);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, backBtn);
		/*GenericLibrary.waitForElementVisibility(driver, searchBox);
		JavascriptLibrary.javascriptType(driver, searchBox, questionnaireName);
		JavascriptLibrary.javascriptClickElement(driver, searchBtn);*/
		WebElement ele = driver.findElement(By.xpath("//h3[text()='"+questionnaireName+"']"));
		GenericLibrary.waitForElementVisibility(driver, ele);
		Assert.assertTrue(ele.isDisplayed(), "Questionnaire Not Created");
	}

	public void verify_error_message_on_creating_questionnaire_without_entering_name() {
		GenericLibrary.waitForElementVisibility(driver, addiQaptureBtn);
		JavascriptLibrary.javascriptClickElement(driver, addiQaptureBtn);
		GenericLibrary.waitForElementVisibility(driver, questionnaireNametextBox);
		JavascriptLibrary.javascriptClickElement(driver, saveBtn);
		GenericLibrary.waitForAjax(driver);
		Assert.assertTrue(pleaseEnterQuationnaireName_ErrorMessage.isDisplayed(), "Error message not displayed");
	}

	public void verify_Upload_image_to_questionnaire(String questionnaireName, String filePath) throws Exception {
		GenericLibrary.waitForElementVisibility(driver, addiQaptureBtn);
		JavascriptLibrary.javascriptClickElement(driver, addiQaptureBtn);
		GenericLibrary.waitForElementVisibility(driver, questionnaireNametextBox);
		JavascriptLibrary.javascriptType(driver, questionnaireNametextBox, questionnaireName);
		JavascriptLibrary.javascriptClickElement(driver, saveBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.uploadFile(uploadImageBtn, filePath);
		GenericLibrary.waitForAjax(driver);
	}

	public void verify_Create_fields(String questionnaireName, String text_SmallBoxQuestion, String text_LargeBoxQuestion, String dateQuestion,
			String uploadFileQuestion, String advancedQuestion, String sectionQuestion, String numberQuestion, String multiChoiceQuestion, String activityQuestion) throws Exception {
		GenericLibrary.waitForElementVisibility(driver, addiQaptureBtn);
		JavascriptLibrary.javascriptClickElement(driver, addiQaptureBtn);
		GenericLibrary.waitForElementVisibility(driver, questionnaireNametextBox);
		JavascriptLibrary.javascriptType(driver, questionnaireNametextBox, questionnaireName);
		JavascriptLibrary.javascriptClickElement(driver, saveBtn);

		GenericLibrary.click(driver, addFieldBtn);
		GenericLibrary.sendKeys(driver, descriptionTextBox, 10, text_SmallBoxQuestion);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.click(driver, text);
		GenericLibrary.waitForAjax(driver);

		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(text_LargeBoxQuestion);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, text);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, largeBox);
		GenericLibrary.waitForAjax(driver);

		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(dateQuestion);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, date);
		GenericLibrary.waitForAjax(driver);

		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(uploadFileQuestion);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, uploadFile);
		GenericLibrary.waitForAjax(driver);

		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(advancedQuestion);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, advanced);
		GenericLibrary.waitForAjax(driver);

		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(sectionQuestion);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, section);
		GenericLibrary.waitForAjax(driver);

		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(numberQuestion);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, number);
		GenericLibrary.waitForAjax(driver);

		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(multiChoiceQuestion);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, multiChoice);
		GenericLibrary.waitForAjax(driver);

		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(activityQuestion);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, activity);
		GenericLibrary.waitForAjax(driver);
	}

	public void verify_Advanced_settings_for_Text(String questionnaireName, String Q1, String level1Hint, String Q2, String level2Hint,
			String Q3, String level3Hint, String Q4, String level4Hint, String Q5, String level5Hint, String Q6, String n, String hint6,
			String Q7, String hint7) throws Exception {
		GenericLibrary.waitForElementVisibility(driver, addiQaptureBtn);
		JavascriptLibrary.javascriptClickElement(driver, addiQaptureBtn);
		GenericLibrary.waitForElementVisibility(driver, questionnaireNametextBox);
		JavascriptLibrary.javascriptType(driver, questionnaireNametextBox, questionnaireName);
		JavascriptLibrary.javascriptClickElement(driver, saveBtn);
		// Level 1
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(Q1);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, text);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, moreBtn);
		JavascriptLibrary.javascriptClickElement(driver, mandatoryYes);
		JavascriptLibrary.javascriptClickElement(driver, commentYes);
		JavascriptLibrary.javascriptClickElement(driver, additionalAnswersYes);
		JavascriptLibrary.javascriptType(driver, hintTextBox, level1Hint);
		JavascriptLibrary.javascriptClickElement(driver, closeMore);
		// Level 2
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(Q2);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, text);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, moreBtn);
		JavascriptLibrary.javascriptClickElement(driver, level2Btn);
		JavascriptLibrary.javascriptClickElement(driver, mandatoryYes);
		JavascriptLibrary.javascriptClickElement(driver, commentYes);
		JavascriptLibrary.javascriptClickElement(driver, additionalAnswersYes);
		JavascriptLibrary.javascriptType(driver, hintTextBox, level2Hint);
		JavascriptLibrary.javascriptClickElement(driver, closeMore);
		// Level 3
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(Q3);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, text);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, moreBtn);
		JavascriptLibrary.javascriptClickElement(driver, level3Btn);
		JavascriptLibrary.javascriptClickElement(driver, mandatoryYes);
		JavascriptLibrary.javascriptClickElement(driver, commentYes);
		JavascriptLibrary.javascriptClickElement(driver, additionalAnswersYes);
		JavascriptLibrary.javascriptType(driver, hintTextBox, level3Hint);
		JavascriptLibrary.javascriptClickElement(driver, closeMore);
		// Level 4
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(Q4);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, text);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, moreBtn);
		JavascriptLibrary.javascriptClickElement(driver, level4Btn);
		JavascriptLibrary.javascriptClickElement(driver, mandatoryYes);
		JavascriptLibrary.javascriptClickElement(driver, commentYes);
		JavascriptLibrary.javascriptClickElement(driver, additionalAnswersYes);
		JavascriptLibrary.javascriptType(driver, hintTextBox, level4Hint);
		JavascriptLibrary.javascriptClickElement(driver, closeMore);
		// Level 5
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(Q5);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, text);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, moreBtn);
		JavascriptLibrary.javascriptClickElement(driver, level4Btn);
		JavascriptLibrary.javascriptClickElement(driver, mandatoryYes);
		JavascriptLibrary.javascriptClickElement(driver, commentYes);
		JavascriptLibrary.javascriptClickElement(driver, additionalAnswersYes);
		JavascriptLibrary.javascriptType(driver, hintTextBox, level5Hint);
		JavascriptLibrary.javascriptClickElement(driver, closeMore);
		// Number Manual
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(Q6);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, text);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, moreBtn);
		JavascriptLibrary.javascriptClickElement(driver, numberManual);
		JavascriptLibrary.javascriptType(driver, numberManualTextBox, n);
		JavascriptLibrary.javascriptClickElement(driver, mandatoryYes);
		JavascriptLibrary.javascriptClickElement(driver, commentYes);
		JavascriptLibrary.javascriptClickElement(driver, additionalAnswersYes);
		JavascriptLibrary.javascriptType(driver, hintTextBox, hint6);
		JavascriptLibrary.javascriptClickElement(driver, closeMore);
		// Number None
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(Q7);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, text);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, moreBtn);
		JavascriptLibrary.javascriptClickElement(driver, numberNone);
		JavascriptLibrary.javascriptClickElement(driver, mandatoryYes);
		JavascriptLibrary.javascriptClickElement(driver, commentYes);
		JavascriptLibrary.javascriptClickElement(driver, additionalAnswersYes);
		JavascriptLibrary.javascriptType(driver, hintTextBox, hint7);
		JavascriptLibrary.javascriptClickElement(driver, closeMore);
	}

	public void verify_MultiChoice_Questionnaire(String questionnaireName, String radioHML, String radioYesNoNa,
			String dropDownHML, String dropDownYesNoNa, String checkBoxHML, String checkBoxYesNoNa) throws Exception {
		GenericLibrary.waitForElementVisibility(driver, addiQaptureBtn);
		JavascriptLibrary.javascriptClickElement(driver, addiQaptureBtn);
		GenericLibrary.waitForElementVisibility(driver, questionnaireNametextBox);
		JavascriptLibrary.javascriptType(driver, questionnaireNametextBox, questionnaireName);
		JavascriptLibrary.javascriptClickElement(driver, saveBtn);
		GenericLibrary.waitForAjax(driver);
		// MultiChoice - Radio Buttons - High/Medium/Low priority
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(radioHML);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, multiChoice);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, defaultDropDownBtn);
		JavascriptLibrary.javascriptClickElement(driver, highMediumLowBtn);
		GenericLibrary.waitForAjax(driver);
		// MultiChoice - Radio Buttons - Yes/No/NA
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(radioYesNoNa);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, multiChoice);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, defaultDropDownBtn);
		JavascriptLibrary.javascriptClickElement(driver, yesNoNaBtn);
		GenericLibrary.waitForAjax(driver);
		// MultiChoice - DropDowns - High/Medium/Low priority
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(dropDownHML);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, multiChoice);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, dropDowns);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, defaultDropDownBtn);
		JavascriptLibrary.javascriptClickElement(driver, highMediumLowBtn);
		GenericLibrary.waitForAjax(driver);
		// MultiChoice - DropDowns - Yes/No/Na
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(dropDownYesNoNa);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, multiChoice);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, dropDowns);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, defaultDropDownBtn);
		JavascriptLibrary.javascriptClickElement(driver, yesNoNaBtn);
		GenericLibrary.waitForAjax(driver);
		// MultiChoice - CheckBoxes - High/Medium/Low priority
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(checkBoxHML);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, multiChoice);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, checkBoxes);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, defaultDropDownBtn);
		JavascriptLibrary.javascriptClickElement(driver, highMediumLowBtn);
		GenericLibrary.waitForAjax(driver);
		// MultiChoice - CheckBoxes - Yes/No/Na
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(checkBoxYesNoNa);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, multiChoice);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, checkBoxes);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, defaultDropDownBtn);
		JavascriptLibrary.javascriptClickElement(driver, yesNoNaBtn);
		GenericLibrary.waitForAjax(driver);
	}

	public void verify_MultiChoice_upload_button_functionality(String  QuestionnaireName, String Q1, String filePath) throws Exception {
		GenericLibrary.waitForElementVisibility(driver, addiQaptureBtn);
		JavascriptLibrary.javascriptClickElement(driver, addiQaptureBtn);
		GenericLibrary.waitForElementVisibility(driver, questionnaireNametextBox);
		JavascriptLibrary.javascriptType(driver, questionnaireNametextBox, QuestionnaireName);
		JavascriptLibrary.javascriptClickElement(driver, saveBtn);
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptType(driver, descriptionTextBox, Q1);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, multiChoice);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.uploadFile(uploadTemplate, filePath);
		GenericLibrary.waitForAjax(driver);
		Assert.assertTrue(uploadedItem.isDisplayed(), "Upload button not working");
		Reporter.log("Upload button is functional", true);
	}

	public void verify_Date_Questionnaire(String questionnaireName, String dateQuestion, 
			String dateAndTimeQuestion, String timeQuestion, String weekDateQuestion) throws Exception {
		GenericLibrary.waitForElementVisibility(driver, addiQaptureBtn);
		JavascriptLibrary.javascriptClickElement(driver, addiQaptureBtn);
		GenericLibrary.waitForElementVisibility(driver, questionnaireNametextBox);
		JavascriptLibrary.javascriptType(driver, questionnaireNametextBox, questionnaireName);
		JavascriptLibrary.javascriptClickElement(driver, saveBtn);
		// Date
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(dateQuestion);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, date);
		GenericLibrary.waitForAjax(driver);
		// Date and Time
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(dateAndTimeQuestion);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, date);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, dateAndTime);
		GenericLibrary.waitForAjax(driver);
		// Time
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(timeQuestion);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, date);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, time);
		GenericLibrary.waitForAjax(driver);
		// Week and Date
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(weekDateQuestion);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, date);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, weekAndDate);
		GenericLibrary.waitForAjax(driver);
	}

	public void verify_Advanced_Settings_for_Date(String questionnaireName, String Q1, String level1Hint,
			String Q2, String level2Hint, String Q3, String level3Hint, String Q4, String level4Hint, 
			String Q5, String level5Hint, String Q6, String n, String hint6, String Q7, String hint7) throws Exception {
		GenericLibrary.waitForElementVisibility(driver, addiQaptureBtn);
		JavascriptLibrary.javascriptClickElement(driver, addiQaptureBtn);
		GenericLibrary.waitForElementVisibility(driver, questionnaireNametextBox);
		JavascriptLibrary.javascriptType(driver, questionnaireNametextBox, questionnaireName);
		JavascriptLibrary.javascriptClickElement(driver, saveBtn);
		// Level 1
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(Q1);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, date);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, moreBtn);
		JavascriptLibrary.javascriptClickElement(driver, mandatoryYes);
		JavascriptLibrary.javascriptClickElement(driver, commentYes);
		JavascriptLibrary.javascriptClickElement(driver, defaultValueYes);
		JavascriptLibrary.javascriptClickElement(driver, additionalAnswersYes);
		JavascriptLibrary.javascriptType(driver, hintTextBox, level1Hint);
		Thread.sleep(1000);
		JavascriptLibrary.javascriptClickElement(driver, closeMore);
		GenericLibrary.waitForAjax(driver);
		// Level 2
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(Q2);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, date);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, moreBtn);
		JavascriptLibrary.javascriptClickElement(driver, level2Btn);
		JavascriptLibrary.javascriptClickElement(driver, mandatoryYes);
		JavascriptLibrary.javascriptClickElement(driver, commentYes);
		JavascriptLibrary.javascriptClickElement(driver, defaultValueYes);
		JavascriptLibrary.javascriptClickElement(driver, additionalAnswersYes);
		JavascriptLibrary.javascriptType(driver, hintTextBox, level2Hint);
		Thread.sleep(1000);
		JavascriptLibrary.javascriptClickElement(driver, closeMore);
		GenericLibrary.waitForAjax(driver);
		// Level 3
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(Q3);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, date);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, moreBtn);
		JavascriptLibrary.javascriptClickElement(driver, level3Btn);
		JavascriptLibrary.javascriptClickElement(driver, mandatoryYes);
		JavascriptLibrary.javascriptClickElement(driver, commentYes);
		JavascriptLibrary.javascriptClickElement(driver, defaultValueYes);
		JavascriptLibrary.javascriptClickElement(driver, additionalAnswersYes);
		JavascriptLibrary.javascriptType(driver, hintTextBox, level3Hint);
		Thread.sleep(1000);
		JavascriptLibrary.javascriptClickElement(driver, closeMore);
		GenericLibrary.waitForAjax(driver);
		// Level 4
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(Q4);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, date);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, moreBtn);
		JavascriptLibrary.javascriptClickElement(driver, level4Btn);
		JavascriptLibrary.javascriptClickElement(driver, mandatoryYes);
		JavascriptLibrary.javascriptClickElement(driver, commentYes);
		JavascriptLibrary.javascriptClickElement(driver, defaultValueYes);
		JavascriptLibrary.javascriptClickElement(driver, additionalAnswersYes);
		JavascriptLibrary.javascriptType(driver, hintTextBox, level4Hint);
		Thread.sleep(1000);
		JavascriptLibrary.javascriptClickElement(driver, closeMore);
		GenericLibrary.waitForAjax(driver);
		// Level 5
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(Q5);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, date);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, moreBtn);
		JavascriptLibrary.javascriptClickElement(driver, level4Btn);
		JavascriptLibrary.javascriptClickElement(driver, mandatoryYes);
		JavascriptLibrary.javascriptClickElement(driver, commentYes);
		JavascriptLibrary.javascriptClickElement(driver, defaultValueYes);
		JavascriptLibrary.javascriptClickElement(driver, additionalAnswersYes);
		JavascriptLibrary.javascriptType(driver, hintTextBox, level5Hint);
		Thread.sleep(1000);
		JavascriptLibrary.javascriptClickElement(driver, closeMore);
		GenericLibrary.waitForAjax(driver);
		// Number Manual
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(Q6);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, date);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, moreBtn);
		JavascriptLibrary.javascriptClickElement(driver, numberManual);
		JavascriptLibrary.javascriptType(driver, numberManualTextBox, n);
		JavascriptLibrary.javascriptClickElement(driver, mandatoryYes);
		JavascriptLibrary.javascriptClickElement(driver, commentYes);
		JavascriptLibrary.javascriptClickElement(driver, defaultValueYes);
		JavascriptLibrary.javascriptClickElement(driver, additionalAnswersYes);
		JavascriptLibrary.javascriptType(driver, hintTextBox, hint6);
		Thread.sleep(1000);
		JavascriptLibrary.javascriptClickElement(driver, closeMore);
		GenericLibrary.waitForAjax(driver);
		// Number None
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(Q7);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, date);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, moreBtn);
		JavascriptLibrary.javascriptClickElement(driver, numberNone);
		JavascriptLibrary.javascriptClickElement(driver, mandatoryYes);
		JavascriptLibrary.javascriptClickElement(driver, commentYes);
		JavascriptLibrary.javascriptClickElement(driver, defaultValueYes);
		JavascriptLibrary.javascriptClickElement(driver, additionalAnswersYes);
		JavascriptLibrary.javascriptType(driver, hintTextBox, hint7);
		Thread.sleep(1000);
		JavascriptLibrary.javascriptClickElement(driver, closeMore);
		GenericLibrary.waitForAjax(driver);
	}

	public void verify_Number_Questionnaire(String questionnaireName, String Q1, String Q2, String Q3,
			String Q4, String Q5, String min, String max, String step) throws Exception {
		GenericLibrary.waitForElementVisibility(driver, addiQaptureBtn);
		JavascriptLibrary.javascriptClickElement(driver, addiQaptureBtn);
		GenericLibrary.waitForElementVisibility(driver, questionnaireNametextBox);
		JavascriptLibrary.javascriptType(driver, questionnaireNametextBox, questionnaireName);
		JavascriptLibrary.javascriptClickElement(driver, saveBtn);
		// Number - Integer
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptType(driver, descriptionTextBox, Q1);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, number);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, integerOption);
		GenericLibrary.waitForAjax(driver);
		Reporter.log("Integer Question Added Successfully", true);
		// Number - Float
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptType(driver, descriptionTextBox, Q2);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, number);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, floatOption);
		GenericLibrary.waitForAjax(driver);
		Reporter.log("Float Question Added Successfully", true);
		// Number - Percentage
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptType(driver, descriptionTextBox, Q3);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, number);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, percentageOption);
		GenericLibrary.waitForAjax(driver);
		Reporter.log("Percentage Question Added Successfully", true);
		// Number - Currency
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptType(driver, descriptionTextBox, Q4);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, number);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, currencyOption);
		GenericLibrary.waitForAjax(driver);
		Reporter.log("Currency Question Added Successfully", true);
		// Number - Slider
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptType(driver, descriptionTextBox, Q5);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, number);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, sliderOption);
		GenericLibrary.waitForAjax(driver);
		sliderMinValue.sendKeys(min.replace(".0", ""));
		sliderMaxValue.sendKeys(max.replace(".0", ""));
		sliderStepValue.sendKeys(step.replace(".0", ""));
		sliderStepValue.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		Reporter.log("Currency Question Added Successfully", true);
	}

	public void verify_Advanced_settings_for_Number(String questionnaireName, String Q1, String level1Hint,
			String Q2, String level2Hint, String Q3, String level3Hint, String Q4, String level4Hint, 
			String Q5, String level5Hint, String Q6, String n, String hint6, String Q7, String hint7) throws Exception {
		GenericLibrary.waitForElementVisibility(driver, addiQaptureBtn);
		JavascriptLibrary.javascriptClickElement(driver, addiQaptureBtn);
		GenericLibrary.waitForElementVisibility(driver, questionnaireNametextBox);
		JavascriptLibrary.javascriptType(driver, questionnaireNametextBox, questionnaireName);
		JavascriptLibrary.javascriptClickElement(driver, saveBtn);
		// Level 1
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(Q1);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, number);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, moreBtn);
		JavascriptLibrary.javascriptClickElement(driver, mandatoryYes);
		JavascriptLibrary.javascriptClickElement(driver, commentYes);
		JavascriptLibrary.javascriptClickElement(driver, scoreYesBtn);
		JavascriptLibrary.javascriptClickElement(driver, scoreShowIniQaptureYes);
		JavascriptLibrary.javascriptClickElement(driver, additionalAnswersYes);
		JavascriptLibrary.javascriptType(driver, hintTextBox, level1Hint);
		JavascriptLibrary.javascriptClickElement(driver, closeMore);
		// Level 2
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(Q2);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, number);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, moreBtn);
		JavascriptLibrary.javascriptClickElement(driver, level2Btn);
		JavascriptLibrary.javascriptClickElement(driver, mandatoryYes);
		JavascriptLibrary.javascriptClickElement(driver, commentYes);
		JavascriptLibrary.javascriptClickElement(driver, scoreYesBtn);
		JavascriptLibrary.javascriptClickElement(driver, scoreShowIniQaptureYes);
		JavascriptLibrary.javascriptClickElement(driver, additionalAnswersYes);
		JavascriptLibrary.javascriptType(driver, hintTextBox, level2Hint);
		JavascriptLibrary.javascriptClickElement(driver, closeMore);
		// Level 3
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(Q3);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, number);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, moreBtn);
		JavascriptLibrary.javascriptClickElement(driver, level3Btn);
		JavascriptLibrary.javascriptClickElement(driver, mandatoryYes);
		JavascriptLibrary.javascriptClickElement(driver, commentYes);
		JavascriptLibrary.javascriptClickElement(driver, scoreYesBtn);
		JavascriptLibrary.javascriptClickElement(driver, scoreShowIniQaptureYes);
		JavascriptLibrary.javascriptClickElement(driver, additionalAnswersYes);
		JavascriptLibrary.javascriptType(driver, hintTextBox, level3Hint);
		JavascriptLibrary.javascriptClickElement(driver, closeMore);
		// Level 4
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(Q4);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, number);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, moreBtn);
		JavascriptLibrary.javascriptClickElement(driver, level4Btn);
		JavascriptLibrary.javascriptClickElement(driver, mandatoryYes);
		JavascriptLibrary.javascriptClickElement(driver, commentYes);
		JavascriptLibrary.javascriptClickElement(driver, scoreYesBtn);
		JavascriptLibrary.javascriptClickElement(driver, scoreShowIniQaptureYes);
		JavascriptLibrary.javascriptClickElement(driver, additionalAnswersYes);
		JavascriptLibrary.javascriptType(driver, hintTextBox, level4Hint);
		JavascriptLibrary.javascriptClickElement(driver, closeMore);
		// Level 5
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(Q5);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, number);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, moreBtn);
		JavascriptLibrary.javascriptClickElement(driver, level4Btn);
		JavascriptLibrary.javascriptClickElement(driver, mandatoryYes);
		JavascriptLibrary.javascriptClickElement(driver, commentYes);
		JavascriptLibrary.javascriptClickElement(driver, scoreYesBtn);
		JavascriptLibrary.javascriptClickElement(driver, scoreShowIniQaptureYes);
		JavascriptLibrary.javascriptClickElement(driver, additionalAnswersYes);
		JavascriptLibrary.javascriptType(driver, hintTextBox, level5Hint);
		JavascriptLibrary.javascriptClickElement(driver, closeMore);
		// Number Manual
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(Q6);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, number);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, moreBtn);
		JavascriptLibrary.javascriptClickElement(driver, numberManual);
		JavascriptLibrary.javascriptType(driver, numberManualTextBox, n);
		JavascriptLibrary.javascriptClickElement(driver, mandatoryYes);
		JavascriptLibrary.javascriptClickElement(driver, commentYes);
		JavascriptLibrary.javascriptClickElement(driver, scoreYesBtn);
		JavascriptLibrary.javascriptClickElement(driver, scoreShowIniQaptureYes);
		JavascriptLibrary.javascriptClickElement(driver, additionalAnswersYes);
		JavascriptLibrary.javascriptType(driver, hintTextBox, hint6);
		JavascriptLibrary.javascriptClickElement(driver, closeMore);
		// Number None
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(Q7);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, number);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, moreBtn);
		JavascriptLibrary.javascriptClickElement(driver, numberNone);
		JavascriptLibrary.javascriptClickElement(driver, mandatoryYes);
		JavascriptLibrary.javascriptClickElement(driver, commentYes);
		JavascriptLibrary.javascriptClickElement(driver, scoreYesBtn);
		JavascriptLibrary.javascriptClickElement(driver, scoreShowIniQaptureYes);
		JavascriptLibrary.javascriptClickElement(driver, additionalAnswersYes);
		JavascriptLibrary.javascriptType(driver, hintTextBox, hint7);
		JavascriptLibrary.javascriptClickElement(driver, closeMore);
	}

	public void verify_Upload_File_Questionnaire(String questionnaireName, String Q1) throws Exception {
		GenericLibrary.waitForElementVisibility(driver, addiQaptureBtn);
		JavascriptLibrary.javascriptClickElement(driver, addiQaptureBtn);
		GenericLibrary.waitForElementVisibility(driver, questionnaireNametextBox);
		JavascriptLibrary.javascriptType(driver, questionnaireNametextBox, questionnaireName);
		JavascriptLibrary.javascriptClickElement(driver, saveBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptType(driver, descriptionTextBox, Q1);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, uploadFile);
		GenericLibrary.waitForAjax(driver);
	}

	public void verify_Advanced_settings_for_Upload_File(String questionnaireName, String Q1, String level1Hint,
			String Q2, String level2Hint, String Q3, String level3Hint, String Q4, String level4Hint, 
			String Q5, String level5Hint, String Q6, String n, String hint6, String Q7, String hint7) throws Exception {
		GenericLibrary.waitForElementVisibility(driver, addiQaptureBtn);
		JavascriptLibrary.javascriptClickElement(driver, addiQaptureBtn);
		GenericLibrary.waitForElementVisibility(driver, questionnaireNametextBox);
		JavascriptLibrary.javascriptType(driver, questionnaireNametextBox, questionnaireName);
		JavascriptLibrary.javascriptClickElement(driver, saveBtn);
		// Level 1
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(Q1);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, uploadFile);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, moreBtn);
		JavascriptLibrary.javascriptClickElement(driver, mandatoryYes);
		JavascriptLibrary.javascriptClickElement(driver, commentYes);
		JavascriptLibrary.javascriptType(driver, hintTextBox, level1Hint);
		JavascriptLibrary.javascriptClickElement(driver, closeMore);
		// Level 2
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(Q2);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, uploadFile);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, moreBtn);
		JavascriptLibrary.javascriptClickElement(driver, level2Btn);
		JavascriptLibrary.javascriptClickElement(driver, mandatoryYes);
		JavascriptLibrary.javascriptClickElement(driver, commentYes);
		JavascriptLibrary.javascriptType(driver, hintTextBox, level2Hint);
		JavascriptLibrary.javascriptClickElement(driver, closeMore);
		// Level 3
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(Q3);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, uploadFile);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, moreBtn);
		JavascriptLibrary.javascriptClickElement(driver, level3Btn);
		JavascriptLibrary.javascriptClickElement(driver, mandatoryYes);
		JavascriptLibrary.javascriptClickElement(driver, commentYes);
		JavascriptLibrary.javascriptType(driver, hintTextBox, level3Hint);
		JavascriptLibrary.javascriptClickElement(driver, closeMore);
		// Level 4
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(Q4);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, uploadFile);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, moreBtn);
		JavascriptLibrary.javascriptClickElement(driver, level4Btn);
		JavascriptLibrary.javascriptClickElement(driver, mandatoryYes);
		JavascriptLibrary.javascriptClickElement(driver, commentYes);
		JavascriptLibrary.javascriptType(driver, hintTextBox, level4Hint);
		JavascriptLibrary.javascriptClickElement(driver, closeMore);
		// Level 5
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(Q5);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, uploadFile);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, moreBtn);
		JavascriptLibrary.javascriptClickElement(driver, level4Btn);
		JavascriptLibrary.javascriptClickElement(driver, mandatoryYes);
		JavascriptLibrary.javascriptClickElement(driver, commentYes);
		JavascriptLibrary.javascriptType(driver, hintTextBox, level5Hint);
		JavascriptLibrary.javascriptClickElement(driver, closeMore);
		// Number Manual
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(Q6);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, uploadFile);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, moreBtn);
		JavascriptLibrary.javascriptClickElement(driver, numberManual);
		JavascriptLibrary.javascriptType(driver, numberManualTextBox, n);
		JavascriptLibrary.javascriptClickElement(driver, mandatoryYes);
		JavascriptLibrary.javascriptClickElement(driver, commentYes);
		JavascriptLibrary.javascriptType(driver, hintTextBox, hint6);
		JavascriptLibrary.javascriptClickElement(driver, closeMore);
		// Number None
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(Q7);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, uploadFile);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, moreBtn);
		JavascriptLibrary.javascriptClickElement(driver, numberNone);
		JavascriptLibrary.javascriptClickElement(driver, mandatoryYes);
		JavascriptLibrary.javascriptClickElement(driver, commentYes);
		JavascriptLibrary.javascriptType(driver, hintTextBox, hint7);
		JavascriptLibrary.javascriptClickElement(driver, closeMore);
	}

	public void verify_Activity_Questionnaire(String questionnaireName, String activityDescription, String comment, String Q1) throws Exception {
		GenericLibrary.waitForElementVisibility(driver, addiQaptureBtn);
		JavascriptLibrary.javascriptClickElement(driver, addiQaptureBtn);
		GenericLibrary.waitForElementVisibility(driver, questionnaireNametextBox);
		JavascriptLibrary.javascriptType(driver, questionnaireNametextBox, questionnaireName);
		JavascriptLibrary.javascriptClickElement(driver, saveBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptType(driver, descriptionTextBox, Q1);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, activity);
		GenericLibrary.waitForAjax(driver);
		driver.findElement(By.cssSelector("#btnActPeople")).click();
		GenericLibrary.waitForAjax(driver);
		driver.findElement(By.cssSelector(".bs-checkbox>input")).click();
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, activityDate);
		GenericLibrary.waitForAjax(driver);
		List<WebElement> switchToYear = driver.findElements(By.cssSelector(".datepicker-switch"));
		for (WebElement ele : switchToYear) {
			String text = ele.getText();
			if(text.equalsIgnoreCase("2018")) {
				ele.click();
				break;
			}
		}
		List<WebElement> switchToYear2 = driver.findElements(By.cssSelector(".datepicker-switch"));
		for (WebElement ele : switchToYear2) {
			String text = ele.getText();
			if(text.equalsIgnoreCase("2018")) {
				ele.click();
				break;
			}
		}
		List<WebElement> yearsList = driver.findElements(By.cssSelector(".year"));
		for (WebElement ele : yearsList) {
			String text = ele.getText();
			if(text.equalsIgnoreCase("2009")) {
				ele.click();
				break;
			}
		}
		List<WebElement> monthsList = driver.findElements(By.cssSelector(".month"));
		for (WebElement ele : monthsList) {
			String text = ele.getText();
			if(text.equalsIgnoreCase("Jun")) {
				ele.click();
				break;
			}
		}
		List<WebElement> dayList = driver.findElements(By.cssSelector(".day"));
		for (WebElement ele : dayList) {
			String text = ele.getText();
			if(text.equalsIgnoreCase("20")) {
				ele.click();
				break;
			}
		}
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptType(driver, activityDecriptionTxtBox, activityDescription);
		JavascriptLibrary.javascriptType(driver, activityCommentTxtBox, comment);
		GenericLibrary.waitForAjax(driver);		
	}

	public void verify_Advanced_settings_for_Activity(String questionnaireName, String Q1, String level1Hint,
			String Q2, String level2Hint, String Q3, String level3Hint, String Q4, String level4Hint, 
			String Q5, String level5Hint, String Q6, String n, String hint6, String Q7, String hint7) throws Exception {
		GenericLibrary.waitForElementVisibility(driver, addiQaptureBtn);
		JavascriptLibrary.javascriptClickElement(driver, addiQaptureBtn);
		GenericLibrary.waitForElementVisibility(driver, questionnaireNametextBox);
		JavascriptLibrary.javascriptType(driver, questionnaireNametextBox, questionnaireName);
		JavascriptLibrary.javascriptClickElement(driver, saveBtn);
		GenericLibrary.waitForAjax(driver);
		// Level 1
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(Q1);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, activity);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, moreBtn);
		JavascriptLibrary.javascriptClickElement(driver, commentYes);
		JavascriptLibrary.javascriptType(driver, hintTextBox, level1Hint);
		JavascriptLibrary.javascriptClickElement(driver, closeMore);
		// Level 2
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(Q2);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, activity);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, moreBtn);
		JavascriptLibrary.javascriptClickElement(driver, level2Btn);
		JavascriptLibrary.javascriptClickElement(driver, commentYes);
		JavascriptLibrary.javascriptType(driver, hintTextBox, level2Hint);
		JavascriptLibrary.javascriptClickElement(driver, closeMore);
		// Level 3
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(Q3);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, activity);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, moreBtn);
		JavascriptLibrary.javascriptClickElement(driver, level3Btn);
		JavascriptLibrary.javascriptClickElement(driver, commentYes);
		JavascriptLibrary.javascriptType(driver, hintTextBox, level3Hint);
		JavascriptLibrary.javascriptClickElement(driver, closeMore);
		// Level 4
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(Q4);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, activity);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, moreBtn);
		JavascriptLibrary.javascriptClickElement(driver, level4Btn);
		JavascriptLibrary.javascriptClickElement(driver, commentYes);
		JavascriptLibrary.javascriptType(driver, hintTextBox, level4Hint);
		JavascriptLibrary.javascriptClickElement(driver, closeMore);
		// Level 5
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(Q5);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, activity);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, moreBtn);
		JavascriptLibrary.javascriptClickElement(driver, level4Btn);
		JavascriptLibrary.javascriptClickElement(driver, commentYes);
		JavascriptLibrary.javascriptType(driver, hintTextBox, level5Hint);
		JavascriptLibrary.javascriptClickElement(driver, closeMore);
		// Number Manual
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(Q6);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, activity);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, moreBtn);
		JavascriptLibrary.javascriptClickElement(driver, numberManual);
		JavascriptLibrary.javascriptType(driver, numberManualTextBox, n);
		JavascriptLibrary.javascriptClickElement(driver, commentYes);
		JavascriptLibrary.javascriptType(driver, hintTextBox, hint6);
		JavascriptLibrary.javascriptClickElement(driver, closeMore);
		// Number None
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(Q7);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, activity);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, moreBtn);
		JavascriptLibrary.javascriptClickElement(driver, numberNone);
		JavascriptLibrary.javascriptClickElement(driver, commentYes);
		JavascriptLibrary.javascriptType(driver, hintTextBox, hint7);
		JavascriptLibrary.javascriptClickElement(driver, closeMore);
	}

	public void verify_Advanced_Questionnaire(String questionnaireName, String header, String description, String Q1, String Q2, String Q3) throws Exception {
		GenericLibrary.waitForElementVisibility(driver, addiQaptureBtn);
		JavascriptLibrary.javascriptClickElement(driver, addiQaptureBtn);
		GenericLibrary.waitForElementVisibility(driver, questionnaireNametextBox);
		JavascriptLibrary.javascriptType(driver, questionnaireNametextBox, questionnaireName);
		JavascriptLibrary.javascriptClickElement(driver, saveBtn);
		GenericLibrary.waitForAjax(driver);
		// Table
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptType(driver, descriptionTextBox, Q1);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, advanced);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, tableOption);
		JavascriptLibrary.javascriptClickElement(driver, tableOption);
		GenericLibrary.waitForElementVisibility(driver, addSubFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addSubFieldBtn);
		tableHeaderTxtBox.click();
		JavascriptLibrary.javascriptType(driver, tableHeaderTxtBox, header);
		tableDescriptionTxtBox.click();
		JavascriptLibrary.javascriptType(driver, tableDescriptionTxtBox, description);
		tableDescriptionTxtBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, moreBtn);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, commentYes);
		JavascriptLibrary.javascriptClickElement(driver, additionalAnswersYes);
		JavascriptLibrary.javascriptClickElement(driver, closeMore);
		GenericLibrary.waitForAjax(driver);
		Reporter.log("Advanced Table Question Added Successfully", true);
		// Property
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptType(driver, descriptionTextBox, Q2);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, advanced);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, propertyOption);
		GenericLibrary.waitForAjax(driver);
		AjaxLibrary.selectElementByVisibleText(driver, propertyDropDown, "Last Modified By");
		JavascriptLibrary.javascriptClickElement(driver, moreBtn);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, commentYes);
		JavascriptLibrary.javascriptClickElement(driver, additionalAnswersYes);
		JavascriptLibrary.javascriptClickElement(driver, closeMore);
		GenericLibrary.waitForAjax(driver);
		Reporter.log("Advanced Property Question Added Successfully", true);
		// Wizard
		/*GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptType(driver, descriptionTextBox, Q3);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, advanced);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, wizardBtn);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptType(driver, noOfSubQuestionsTxtBox, "5");
		noOfSubQuestionsTxtBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, moreBtn);
		GenericLibrary.waitForAjax(driver);
		List<WebElement> listOfsubQuestions = driver.findElements(By.xpath("//div[@class='field_desc_txt']"));
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfAllElements(listOfsubQuestions));
		int count = listOfsubQuestions.size()-4;
		Reporter.log("No of Sub-Questions added: "+count, true);
		Reporter.log("Wizard Sub-Questions Created Successfully", true);*/
	}

	public void verify_Section_Questionnaire(String questionnaireName, String Q1) throws Exception {
		GenericLibrary.waitForElementVisibility(driver, addiQaptureBtn);
		JavascriptLibrary.javascriptClickElement(driver, addiQaptureBtn);
		GenericLibrary.waitForElementVisibility(driver, questionnaireNametextBox);
		JavascriptLibrary.javascriptType(driver, questionnaireNametextBox, questionnaireName);
		JavascriptLibrary.javascriptClickElement(driver, saveBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptType(driver, descriptionTextBox, Q1);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, section);
		GenericLibrary.waitForAjax(driver);
	}

	public void verify_Advanced_settings_for_Section(String questionnaireName, String Q1, String level1Desc, String level1Hint,
			String Q2, String level2Desc, String level2Hint, String Q3, String level3Desc, String level3Hint, String Q4, String level4Desc, String level4Hint, 
			String Q5, String level5Desc,String level5Hint, String Q6, String n, String numberManualDesc, String hint6, String Q7, String numberNoneDesc, String hint7) throws Exception {
		GenericLibrary.waitForElementVisibility(driver, addiQaptureBtn);
		JavascriptLibrary.javascriptClickElement(driver, addiQaptureBtn);
		GenericLibrary.waitForElementVisibility(driver, questionnaireNametextBox);
		JavascriptLibrary.javascriptType(driver, questionnaireNametextBox, questionnaireName);
		JavascriptLibrary.javascriptClickElement(driver, saveBtn);
		GenericLibrary.waitForAjax(driver);
		// Level 1
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(Q1);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, section);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, moreBtn);
		JavascriptLibrary.javascriptClickElement(driver, minimizeYes);
		JavascriptLibrary.javascriptType(driver, moreDescriptionTextBox, level1Desc);
		JavascriptLibrary.javascriptType(driver, hintTextBox, level1Hint);
		JavascriptLibrary.javascriptClickElement(driver, closeMore);
		GenericLibrary.waitForAjax(driver);
		// Level 2
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(Q2);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, section);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, moreBtn);
		JavascriptLibrary.javascriptClickElement(driver, level2Btn);
		JavascriptLibrary.javascriptClickElement(driver, minimizeYes);
		JavascriptLibrary.javascriptType(driver, moreDescriptionTextBox, level2Desc);
		JavascriptLibrary.javascriptType(driver, hintTextBox, level2Hint);
		JavascriptLibrary.javascriptClickElement(driver, closeMore);
		GenericLibrary.waitForAjax(driver);
		// Level 3
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(Q3);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, section);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, moreBtn);
		JavascriptLibrary.javascriptClickElement(driver, level3Btn);
		JavascriptLibrary.javascriptClickElement(driver, minimizeYes);
		JavascriptLibrary.javascriptType(driver, moreDescriptionTextBox, level3Desc);
		JavascriptLibrary.javascriptType(driver, hintTextBox, level3Hint);
		JavascriptLibrary.javascriptClickElement(driver, closeMore);
		GenericLibrary.waitForAjax(driver);
		// Level 4
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(Q4);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, section);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, moreBtn);
		JavascriptLibrary.javascriptClickElement(driver, level4Btn);
		JavascriptLibrary.javascriptClickElement(driver, minimizeYes);
		JavascriptLibrary.javascriptType(driver, moreDescriptionTextBox, level4Desc);
		JavascriptLibrary.javascriptType(driver, hintTextBox, level4Hint);
		JavascriptLibrary.javascriptClickElement(driver, closeMore);
		GenericLibrary.waitForAjax(driver);
		// Level 5
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(Q5);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, section);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, moreBtn);
		JavascriptLibrary.javascriptClickElement(driver, level4Btn);
		JavascriptLibrary.javascriptClickElement(driver, minimizeYes);
		JavascriptLibrary.javascriptType(driver, moreDescriptionTextBox, level5Desc);
		JavascriptLibrary.javascriptType(driver, hintTextBox, level5Hint);
		JavascriptLibrary.javascriptClickElement(driver, closeMore);
		GenericLibrary.waitForAjax(driver);
		// Number Manual
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(Q6);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, section);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, moreBtn);
		JavascriptLibrary.javascriptClickElement(driver, numberManual);
		JavascriptLibrary.javascriptType(driver, numberManualTextBox, n);
		JavascriptLibrary.javascriptClickElement(driver, minimizeYes);
		JavascriptLibrary.javascriptType(driver, moreDescriptionTextBox, numberManualDesc);
		JavascriptLibrary.javascriptType(driver, hintTextBox, hint6);
		JavascriptLibrary.javascriptClickElement(driver, closeMore);
		GenericLibrary.waitForAjax(driver);
		// Number None
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(Q7);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, section);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, moreBtn);
		JavascriptLibrary.javascriptClickElement(driver, numberNone);
		JavascriptLibrary.javascriptClickElement(driver, minimizeYes);
		JavascriptLibrary.javascriptType(driver, moreDescriptionTextBox, numberNoneDesc);
		JavascriptLibrary.javascriptType(driver, hintTextBox, hint7);
		JavascriptLibrary.javascriptClickElement(driver, closeMore);
		GenericLibrary.waitForAjax(driver);
	}

	public void verify_Advanced_settings_for_MiltiChoice_Radio(String questionnaireName, String Q1, String level1Hint,
			String Q2, String level2Hint, String Q3, String level3Hint, String Q4, String level4Hint, 
			String Q5, String level5Hint, String Q6, String n, String hint6, String Q7, String hint7) throws Exception {
		GenericLibrary.waitForElementVisibility(driver, addiQaptureBtn);
		JavascriptLibrary.javascriptClickElement(driver, addiQaptureBtn);
		GenericLibrary.waitForElementVisibility(driver, questionnaireNametextBox);
		JavascriptLibrary.javascriptType(driver, questionnaireNametextBox, questionnaireName);
		JavascriptLibrary.javascriptClickElement(driver, saveBtn);
		GenericLibrary.waitForAjax(driver);
		// Level 1
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(Q1);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, multiChoice);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, moreBtn);
		JavascriptLibrary.javascriptClickElement(driver, mandatoryYes);
		JavascriptLibrary.javascriptClickElement(driver, commentYes);
		JavascriptLibrary.javascriptClickElement(driver, scoreYesBtn);
		JavascriptLibrary.javascriptType(driver, hintTextBox, level1Hint);
		JavascriptLibrary.javascriptClickElement(driver, milestoneYesBtn);
		JavascriptLibrary.javascriptClickElement(driver, closeMore);
		GenericLibrary.waitForAjax(driver);
		// Level 2
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(Q2);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, multiChoice);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, moreBtn);
		JavascriptLibrary.javascriptClickElement(driver, level2Btn);
		JavascriptLibrary.javascriptClickElement(driver, mandatoryYes);
		JavascriptLibrary.javascriptClickElement(driver, commentYes);
		JavascriptLibrary.javascriptClickElement(driver, scoreYesBtn);
		JavascriptLibrary.javascriptType(driver, hintTextBox, level2Hint);
		JavascriptLibrary.javascriptClickElement(driver, milestoneYesBtn);
		JavascriptLibrary.javascriptClickElement(driver, closeMore);
		GenericLibrary.waitForAjax(driver);
		// Level 3
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(Q3);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, multiChoice);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, moreBtn);
		JavascriptLibrary.javascriptClickElement(driver, level3Btn);
		JavascriptLibrary.javascriptClickElement(driver, mandatoryYes);
		JavascriptLibrary.javascriptClickElement(driver, commentYes);
		JavascriptLibrary.javascriptClickElement(driver, scoreYesBtn);
		JavascriptLibrary.javascriptType(driver, hintTextBox, level3Hint);
		JavascriptLibrary.javascriptClickElement(driver, milestoneYesBtn);
		JavascriptLibrary.javascriptClickElement(driver, closeMore);
		GenericLibrary.waitForAjax(driver);
		// Level 4
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(Q4);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, multiChoice);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, moreBtn);
		JavascriptLibrary.javascriptClickElement(driver, level4Btn);
		JavascriptLibrary.javascriptClickElement(driver, mandatoryYes);
		JavascriptLibrary.javascriptClickElement(driver, commentYes);
		JavascriptLibrary.javascriptClickElement(driver, scoreYesBtn);
		JavascriptLibrary.javascriptType(driver, hintTextBox, level4Hint);
		JavascriptLibrary.javascriptClickElement(driver, milestoneYesBtn);
		JavascriptLibrary.javascriptClickElement(driver, closeMore);
		GenericLibrary.waitForAjax(driver);
		// Level 5
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(Q5);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, multiChoice);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, moreBtn);
		JavascriptLibrary.javascriptClickElement(driver, level4Btn);
		JavascriptLibrary.javascriptClickElement(driver, mandatoryYes);
		JavascriptLibrary.javascriptClickElement(driver, commentYes);
		JavascriptLibrary.javascriptClickElement(driver, scoreYesBtn);
		JavascriptLibrary.javascriptType(driver, hintTextBox, level5Hint);
		JavascriptLibrary.javascriptClickElement(driver, milestoneYesBtn);
		JavascriptLibrary.javascriptClickElement(driver, closeMore);
		GenericLibrary.waitForAjax(driver);
		// Number Manual
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(Q6);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, multiChoice);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, moreBtn);
		JavascriptLibrary.javascriptClickElement(driver, numberManual);
		JavascriptLibrary.javascriptType(driver, numberManualTextBox, n);
		JavascriptLibrary.javascriptClickElement(driver, mandatoryYes);
		JavascriptLibrary.javascriptClickElement(driver, commentYes);
		JavascriptLibrary.javascriptClickElement(driver, scoreYesBtn);
		JavascriptLibrary.javascriptType(driver, hintTextBox, hint6);
		JavascriptLibrary.javascriptClickElement(driver, milestoneYesBtn);
		JavascriptLibrary.javascriptClickElement(driver, closeMore);
		GenericLibrary.waitForAjax(driver);
		// Number None
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(Q7);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, multiChoice);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, moreBtn);
		JavascriptLibrary.javascriptClickElement(driver, numberNone);
		JavascriptLibrary.javascriptClickElement(driver, mandatoryYes);
		JavascriptLibrary.javascriptClickElement(driver, commentYes);
		JavascriptLibrary.javascriptClickElement(driver, scoreYesBtn);
		JavascriptLibrary.javascriptType(driver, hintTextBox, hint7);
		JavascriptLibrary.javascriptClickElement(driver, milestoneYesBtn);
		JavascriptLibrary.javascriptClickElement(driver, closeMore);
		GenericLibrary.waitForAjax(driver);
	}

	public void verify_Advanced_settings_for_MiltiChoice_DropDown(String questionnaireName, String Q1, String level1Hint,
			String Q2, String level2Hint, String Q3, String level3Hint, String Q4, String level4Hint, 
			String Q5, String level5Hint, String Q6, String n, String hint6, String Q7, String hint7) throws Exception {
		GenericLibrary.waitForElementVisibility(driver, addiQaptureBtn);
		JavascriptLibrary.javascriptClickElement(driver, addiQaptureBtn);
		GenericLibrary.waitForElementVisibility(driver, questionnaireNametextBox);
		JavascriptLibrary.javascriptType(driver, questionnaireNametextBox, questionnaireName);
		JavascriptLibrary.javascriptClickElement(driver, saveBtn);
		GenericLibrary.waitForAjax(driver);
		// Level 1
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(Q1);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, multiChoice);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, dropDowns);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, moreBtn);
		JavascriptLibrary.javascriptClickElement(driver, mandatoryYes);
		JavascriptLibrary.javascriptClickElement(driver, commentYes);
		JavascriptLibrary.javascriptClickElement(driver, scoreYesBtn);
		JavascriptLibrary.javascriptClickElement(driver, searchableYesBtn);
		JavascriptLibrary.javascriptType(driver, hintTextBox, level1Hint);
		JavascriptLibrary.javascriptClickElement(driver, closeMore);
		// Level 2
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(Q2);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, multiChoice);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, dropDowns);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, moreBtn);
		JavascriptLibrary.javascriptClickElement(driver, level2Btn);
		JavascriptLibrary.javascriptClickElement(driver, mandatoryYes);
		JavascriptLibrary.javascriptClickElement(driver, commentYes);
		JavascriptLibrary.javascriptClickElement(driver, scoreYesBtn);
		JavascriptLibrary.javascriptClickElement(driver, searchableYesBtn);
		JavascriptLibrary.javascriptType(driver, hintTextBox, level2Hint);
		JavascriptLibrary.javascriptClickElement(driver, closeMore);
		// Level 3
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(Q3);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, multiChoice);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, dropDowns);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, moreBtn);
		JavascriptLibrary.javascriptClickElement(driver, level3Btn);
		JavascriptLibrary.javascriptClickElement(driver, mandatoryYes);
		JavascriptLibrary.javascriptClickElement(driver, commentYes);
		JavascriptLibrary.javascriptClickElement(driver, scoreYesBtn);
		JavascriptLibrary.javascriptClickElement(driver, searchableYesBtn);
		JavascriptLibrary.javascriptType(driver, hintTextBox, level3Hint);
		JavascriptLibrary.javascriptClickElement(driver, closeMore);
		// Level 4
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(Q4);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, multiChoice);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, dropDowns);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, moreBtn);
		JavascriptLibrary.javascriptClickElement(driver, level4Btn);
		JavascriptLibrary.javascriptClickElement(driver, mandatoryYes);
		JavascriptLibrary.javascriptClickElement(driver, commentYes);
		JavascriptLibrary.javascriptClickElement(driver, scoreYesBtn);
		JavascriptLibrary.javascriptClickElement(driver, searchableYesBtn);
		JavascriptLibrary.javascriptType(driver, hintTextBox, level4Hint);
		JavascriptLibrary.javascriptClickElement(driver, closeMore);
		// Level 5
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(Q5);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, multiChoice);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, dropDowns);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, moreBtn);
		JavascriptLibrary.javascriptClickElement(driver, level4Btn);
		JavascriptLibrary.javascriptClickElement(driver, mandatoryYes);
		JavascriptLibrary.javascriptClickElement(driver, commentYes);
		JavascriptLibrary.javascriptClickElement(driver, scoreYesBtn);
		JavascriptLibrary.javascriptClickElement(driver, searchableYesBtn);
		JavascriptLibrary.javascriptType(driver, hintTextBox, level5Hint);
		JavascriptLibrary.javascriptClickElement(driver, closeMore);
		// Number Manual
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(Q6);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, multiChoice);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, dropDowns);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, moreBtn);
		JavascriptLibrary.javascriptClickElement(driver, numberManual);
		JavascriptLibrary.javascriptType(driver, numberManualTextBox, n);
		JavascriptLibrary.javascriptClickElement(driver, mandatoryYes);
		JavascriptLibrary.javascriptClickElement(driver, commentYes);
		JavascriptLibrary.javascriptClickElement(driver, scoreYesBtn);
		JavascriptLibrary.javascriptClickElement(driver, searchableYesBtn);
		JavascriptLibrary.javascriptType(driver, hintTextBox, hint6);
		JavascriptLibrary.javascriptClickElement(driver, closeMore);
		// Number None
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(Q7);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, multiChoice);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, dropDowns);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, moreBtn);
		JavascriptLibrary.javascriptClickElement(driver, numberNone);
		JavascriptLibrary.javascriptClickElement(driver, mandatoryYes);
		JavascriptLibrary.javascriptClickElement(driver, commentYes);
		JavascriptLibrary.javascriptClickElement(driver, scoreYesBtn);
		JavascriptLibrary.javascriptClickElement(driver, searchableYesBtn);
		JavascriptLibrary.javascriptType(driver, hintTextBox, hint7);
		JavascriptLibrary.javascriptClickElement(driver, closeMore);
	}

	public void verify_Advanced_settings_for_MiltiChoice_CheckBox(String questionnaireName, String Q1, String min1, String max1,
			String level1Hint, String Q2, String min2, String max2, String level2Hint, String Q3, String min3, String max3, String level3Hint, 
			String Q4, String min4, String max4, String level4Hint, String Q5, String min5, String max5, String level5Hint, 
			String Q6, String n, String min6, String max6, String hint6, String Q7, String min7, String max7, String hint7) throws Exception {
		GenericLibrary.waitForElementVisibility(driver, addiQaptureBtn);
		JavascriptLibrary.javascriptClickElement(driver, addiQaptureBtn);
		GenericLibrary.waitForElementVisibility(driver, questionnaireNametextBox);
		JavascriptLibrary.javascriptType(driver, questionnaireNametextBox, questionnaireName);
		JavascriptLibrary.javascriptClickElement(driver, saveBtn);
		GenericLibrary.waitForAjax(driver);
		// Level 1
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(Q1);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, multiChoice);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, checkBoxes);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, moreBtn);
		JavascriptLibrary.javascriptClickElement(driver, mandatoryYes);
		JavascriptLibrary.javascriptType(driver, minAnswersLimitTextBox, min1.replace(".0", ""));
		JavascriptLibrary.javascriptType(driver, maxAnswersLimitTextBox, max1.replace(".0", ""));
		JavascriptLibrary.javascriptClickElement(driver, commentYes);
		JavascriptLibrary.javascriptClickElement(driver, scoreYesBtn);
		JavascriptLibrary.javascriptType(driver, hintTextBox, level1Hint);
		JavascriptLibrary.javascriptClickElement(driver, closeMore);
		// Level 2
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(Q2);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, multiChoice);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, checkBoxes);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, moreBtn);
		JavascriptLibrary.javascriptClickElement(driver, level2Btn);
		JavascriptLibrary.javascriptClickElement(driver, mandatoryYes);
		JavascriptLibrary.javascriptType(driver, minAnswersLimitTextBox, min2.replace(".0", ""));
		JavascriptLibrary.javascriptType(driver, maxAnswersLimitTextBox, max2.replace(".0", ""));
		JavascriptLibrary.javascriptClickElement(driver, commentYes);
		JavascriptLibrary.javascriptClickElement(driver, scoreYesBtn);
		JavascriptLibrary.javascriptType(driver, hintTextBox, level2Hint);
		JavascriptLibrary.javascriptClickElement(driver, closeMore);
		// Level 3
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(Q3);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, multiChoice);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, checkBoxes);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, moreBtn);
		JavascriptLibrary.javascriptClickElement(driver, level3Btn);
		JavascriptLibrary.javascriptClickElement(driver, mandatoryYes);
		JavascriptLibrary.javascriptType(driver, minAnswersLimitTextBox, min3.replace(".0", ""));
		JavascriptLibrary.javascriptType(driver, maxAnswersLimitTextBox, max3.replace(".0", ""));
		JavascriptLibrary.javascriptClickElement(driver, commentYes);
		JavascriptLibrary.javascriptClickElement(driver, scoreYesBtn);
		JavascriptLibrary.javascriptType(driver, hintTextBox, level3Hint);
		JavascriptLibrary.javascriptClickElement(driver, closeMore);
		// Level 4
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(Q4);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, multiChoice);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, checkBoxes);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, moreBtn);
		JavascriptLibrary.javascriptClickElement(driver, level4Btn);
		JavascriptLibrary.javascriptClickElement(driver, mandatoryYes);
		JavascriptLibrary.javascriptType(driver, minAnswersLimitTextBox, min4.replace(".0", ""));
		JavascriptLibrary.javascriptType(driver, maxAnswersLimitTextBox, max4.replace(".0", ""));
		JavascriptLibrary.javascriptClickElement(driver, commentYes);
		JavascriptLibrary.javascriptClickElement(driver, scoreYesBtn);
		JavascriptLibrary.javascriptType(driver, hintTextBox, level4Hint);
		JavascriptLibrary.javascriptClickElement(driver, closeMore);
		// Level 5
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(Q5);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, multiChoice);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, checkBoxes);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, moreBtn);
		JavascriptLibrary.javascriptClickElement(driver, level4Btn);
		JavascriptLibrary.javascriptClickElement(driver, mandatoryYes);
		JavascriptLibrary.javascriptType(driver, minAnswersLimitTextBox, min5.replace(".0", ""));
		JavascriptLibrary.javascriptType(driver, maxAnswersLimitTextBox, max5.replace(".0", ""));
		JavascriptLibrary.javascriptClickElement(driver, commentYes);
		JavascriptLibrary.javascriptClickElement(driver, scoreYesBtn);
		JavascriptLibrary.javascriptType(driver, hintTextBox, level5Hint);
		JavascriptLibrary.javascriptClickElement(driver, closeMore);
		// Number Manual
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(Q6);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, multiChoice);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, checkBoxes);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, moreBtn);
		JavascriptLibrary.javascriptClickElement(driver, numberManual);
		JavascriptLibrary.javascriptType(driver, numberManualTextBox, n);
		JavascriptLibrary.javascriptClickElement(driver, mandatoryYes);
		JavascriptLibrary.javascriptType(driver, minAnswersLimitTextBox, min6.replace(".0", ""));
		JavascriptLibrary.javascriptType(driver, maxAnswersLimitTextBox, max6.replace(".0", ""));
		JavascriptLibrary.javascriptClickElement(driver, commentYes);
		JavascriptLibrary.javascriptClickElement(driver, scoreYesBtn);
		JavascriptLibrary.javascriptType(driver, hintTextBox, hint6);
		JavascriptLibrary.javascriptClickElement(driver, closeMore);
		// Number None
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(Q7);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, multiChoice);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, checkBoxes);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, moreBtn);
		JavascriptLibrary.javascriptClickElement(driver, numberNone);
		JavascriptLibrary.javascriptClickElement(driver, mandatoryYes);
		JavascriptLibrary.javascriptType(driver, minAnswersLimitTextBox, min7.replace(".0", ""));
		JavascriptLibrary.javascriptType(driver, maxAnswersLimitTextBox, max7.replace(".0", ""));
		JavascriptLibrary.javascriptClickElement(driver, commentYes);
		JavascriptLibrary.javascriptClickElement(driver, scoreYesBtn);
		JavascriptLibrary.javascriptType(driver, hintTextBox, hint7);
		JavascriptLibrary.javascriptClickElement(driver, closeMore);
	}

	public void verify_Create_Answers_for_MultiChoice(String questionnaireName, String Q1,
			String answer1, String hint1, String score1, String answer2, String hint2, String score2,
			String dropDownHML, String checkBoxYesNoNa) throws Exception {
		GenericLibrary.waitForElementVisibility(driver, addiQaptureBtn);
		JavascriptLibrary.javascriptClickElement(driver, addiQaptureBtn);
		GenericLibrary.waitForElementVisibility(driver, questionnaireNametextBox);
		JavascriptLibrary.javascriptType(driver, questionnaireNametextBox, questionnaireName);
		JavascriptLibrary.javascriptClickElement(driver, saveBtn);
		GenericLibrary.waitForAjax(driver);
		// MultiChoice - Radio - Answer, Hint and Score
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptType(driver, descriptionTextBox, Q1);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, multiChoice);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, createNewFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, createNewFieldBtn);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, createNewFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, moreBtn);
		JavascriptLibrary.javascriptClickElement(driver, mandatoryYes);
		JavascriptLibrary.javascriptClickElement(driver, scoreYesBtn);
		GenericLibrary.waitForElementVisibility(driver, scoreShowIniQaptureYes);
		JavascriptLibrary.javascriptClickElement(driver, scoreShowIniQaptureYes);
		JavascriptLibrary.javascriptClickElement(driver, closeMore);
		GenericLibrary.waitForAjax(driver);
		List<WebElement> ansTextBoxes = driver.findElements(By.xpath("//input[@placeholder='Answer']"));
		List<WebElement> hintTextBoxes = driver.findElements(By.xpath("//textarea[@placeholder='Enter hint for answer…']"));
		List<WebElement> scoreTextBox = driver.findElements(By.xpath("//input[@field='FI_SCORE' and @type='text']"));
		List<WebElement> eyelist = driver.findElements(By.xpath("//span[@class='desc hide-desc']"));

		WebElement a1 = ansTextBoxes.get(0);
		GenericLibrary.scrollIntoView(driver, a1);
		a1.sendKeys(answer1);
		GenericLibrary.waitForAjax(driver);
		WebElement h1 = hintTextBoxes.get(0);
		GenericLibrary.scrollIntoView(driver, h1);
		h1.sendKeys(hint1);
		GenericLibrary.waitForAjax(driver);
		eyelist.get(0).click();
		GenericLibrary.waitForAjax(driver);
		WebElement s1 = scoreTextBox.get(0);
		GenericLibrary.scrollIntoView(driver, s1);
		s1.sendKeys(score1.replace(".0", ""));
		GenericLibrary.waitForAjax(driver);

		WebElement a2 = ansTextBoxes.get(1);
		GenericLibrary.scrollIntoView(driver, s1);
		a2.sendKeys(answer2);
		GenericLibrary.waitForAjax(driver);
		WebElement h2 = hintTextBoxes.get(1);
		GenericLibrary.scrollIntoView(driver, h2);
		h2.sendKeys(hint2);
		GenericLibrary.waitForAjax(driver);
		eyelist.get(1).click();
		GenericLibrary.waitForAjax(driver);
		WebElement s2 = scoreTextBox.get(1);
		GenericLibrary.scrollIntoView(driver, s2);
		s2.sendKeys(score2.replace(".0", ""));
		s2.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		// MultiChoice - DropDowns - High/Medium/Low priority
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(dropDownHML);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, multiChoice);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, dropDowns);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, defaultDropDownBtn);
		JavascriptLibrary.javascriptClickElement(driver, highMediumLowBtn);
		GenericLibrary.waitForAjax(driver);
		// MultiChoice - CheckBoxes - Yes/No/Na
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(checkBoxYesNoNa);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, multiChoice);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, checkBoxes);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, defaultDropDownBtn);
		JavascriptLibrary.javascriptClickElement(driver, yesNoNaBtn);
		GenericLibrary.waitForAjax(driver);
	} 

	public void verify_MultiChoice_Copy_Questions_functionality(String questionnaireName, String radioHML, 
			String dropDownYesNoNa,	String choice, String question, String copiedQuestion) throws Exception {
		GenericLibrary.waitForElementVisibility(driver, addiQaptureBtn);
		JavascriptLibrary.javascriptClickElement(driver, addiQaptureBtn);
		GenericLibrary.waitForElementVisibility(driver, questionnaireNametextBox);
		JavascriptLibrary.javascriptType(driver, questionnaireNametextBox, questionnaireName);
		JavascriptLibrary.javascriptClickElement(driver, saveBtn);
		GenericLibrary.waitForAjax(driver);
		// MultiChoice - Radio Buttons - High/Medium/Low priority
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(radioHML);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, multiChoice);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, defaultDropDownBtn);
		JavascriptLibrary.javascriptClickElement(driver, highMediumLowBtn);
		GenericLibrary.waitForAjax(driver);
		// MultiChoice - DropDowns - Yes/No/Na
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(dropDownYesNoNa);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, multiChoice);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, dropDowns);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, defaultDropDownBtn);
		JavascriptLibrary.javascriptClickElement(driver, yesNoNaBtn);
		GenericLibrary.waitForAjax(driver);
		// Copy Question
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(copiedQuestion);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, multiChoice);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, copyQuestionsBtn);
		GenericLibrary.waitForElementVisibility(driver, copyChoice);
		GenericLibrary.selectElementByVisibleText(copyChoice, choice);
		GenericLibrary.selectElementByVisibleText(copyQuestion, question);
		JavascriptLibrary.javascriptClickElement(driver, confirmCopy);
		GenericLibrary.waitForAlertPresent(driver);
		driver.switchTo().alert().accept();
		GenericLibrary.waitForAjax(driver);
		Thread.sleep(1000);
	}

	public void verify_Download_Template_For_MultiChoice_Questionnaire(String questionnaireName, String checkBoxYesNoNa) throws Exception {
		GenericLibrary.waitForElementVisibility(driver, addiQaptureBtn);
		JavascriptLibrary.javascriptClickElement(driver, addiQaptureBtn);
		GenericLibrary.waitForElementVisibility(driver, questionnaireNametextBox);
		JavascriptLibrary.javascriptType(driver, questionnaireNametextBox, questionnaireName);
		JavascriptLibrary.javascriptClickElement(driver, saveBtn);
		GenericLibrary.waitForAjax(driver);
		// MultiChoice - CheckBoxes - Yes/No/Na
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(checkBoxYesNoNa);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, multiChoice);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, checkBoxes);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, defaultDropDownBtn);
		JavascriptLibrary.javascriptClickElement(driver, yesNoNaBtn);
		GenericLibrary.waitForAjax(driver);
		// Download Template
		GenericLibrary.waitForElementVisibility(driver, downloadTemplate);
		JavascriptLibrary.javascriptClickElement(driver, downloadTemplate);
		Thread.sleep(2000);
		Assert.assertTrue(VerificationLibrary.isFileDownloaded("C:\\Users\\Mahesh\\Downloads", "Dropdown List Items.xlsx"), "Template not downloaded");
		Reporter.log("Template downloaded for MultiChoice Questionnaire successfully", true);
	}

	public void verify_Rename_Questionnaire(String searchItem, String newName) throws Exception {
		/*GenericLibrary.waitForElementVisibility(driver, searchBox);
		JavascriptLibrary.javascriptType(driver, searchBox, searchItem);
		JavascriptLibrary.javascriptClickElement(driver, searchBtn);*/
		WebElement ele = driver.findElement(By.xpath("//h3[text()='"+searchItem+"']"));
		GenericLibrary.scrollIntoView(driver, ele);
		GenericLibrary.waitForElementVisibility(driver, ele);
		JavascriptLibrary.javascriptClickElement(driver, ele);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.click(driver, editBtn);
		GenericLibrary.waitForElementVisibility(driver, questionnaireOutField);
		questionnaireOutField.click();
		questionnaireNametextBox.clear();
		GenericLibrary.waitForAjax(driver);
		questionnaireNametextBox.sendKeys(newName);
		questionnaireNametextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.click(driver, DataCaptureLink);
		GenericLibrary.waitForAjax(driver);
		/*GenericLibrary.waitForElementVisibility(driver, searchBox);
		JavascriptLibrary.javascriptType(driver, searchBox, newName);
		JavascriptLibrary.javascriptClickElement(driver, searchBtn);*/
		WebElement newQ = driver.findElement(By.xpath("//h3[contains(text(),'"+newName+"')]"));
		GenericLibrary.scrollIntoView(driver, newQ);
		GenericLibrary.waitForElementVisibility(driver, newQ);
		Assert.assertTrue(newQ.isDisplayed(), "Questionnaire Not Renamed");
	}

	public void verify_Removing_Questions_From_Questionnaire(String questionnaireName, String radioHML, String dropDownYesNoNa) throws Exception {
		GenericLibrary.waitForElementVisibility(driver, addiQaptureBtn);
		JavascriptLibrary.javascriptClickElement(driver, addiQaptureBtn);
		GenericLibrary.waitForElementVisibility(driver, questionnaireNametextBox);
		JavascriptLibrary.javascriptType(driver, questionnaireNametextBox, questionnaireName);
		JavascriptLibrary.javascriptClickElement(driver, saveBtn);
		GenericLibrary.waitForAjax(driver);
		// MultiChoice - Radio Buttons - High/Medium/Low priority
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(radioHML);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, multiChoice);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, defaultDropDownBtn);
		JavascriptLibrary.javascriptClickElement(driver, highMediumLowBtn);
		GenericLibrary.waitForAjax(driver);
		// MultiChoice - DropDowns - Yes/No/Na
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(dropDownYesNoNa);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, multiChoice);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, dropDowns);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, defaultDropDownBtn);
		JavascriptLibrary.javascriptClickElement(driver, yesNoNaBtn);
		GenericLibrary.waitForAjax(driver);
		deleteQuestionBtn.click();
		GenericLibrary.waitForAlertPresent(driver);
		driver.switchTo().alert().accept();
		GenericLibrary.waitForAjax(driver);
		radioQuestion.click();
		GenericLibrary.waitForElementVisibility(driver, deleteQuestionBtn);
		deleteQuestionBtn.click();
		GenericLibrary.waitForAlertPresent(driver);
		driver.switchTo().alert().accept();
		GenericLibrary.waitForAjax(driver);
	}

	public void verify_Comment_Adding_Updating_Deleting(String questionnaireName, String Q1) throws Exception{
		GenericLibrary.waitForElementVisibility(driver, addiQaptureBtn);
		JavascriptLibrary.javascriptClickElement(driver, addiQaptureBtn);
		GenericLibrary.waitForElementVisibility(driver, questionnaireNametextBox);
		JavascriptLibrary.javascriptType(driver, questionnaireNametextBox, questionnaireName);
		JavascriptLibrary.javascriptClickElement(driver, saveBtn);
		GenericLibrary.waitForAjax(driver);
		// Comment adding
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(Q1);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, moreBtn);
		JavascriptLibrary.javascriptClickElement(driver, commentYes);
		JavascriptLibrary.javascriptClickElement(driver, closeMore);
		GenericLibrary.waitForElementVisibility(driver, addedComment);
		Assert.assertTrue(addedComment.isDisplayed(), "Comment Not Added");
		Reporter.log("Comment Added successfully", true);
		// Comment Deleting
		JavascriptLibrary.javascriptClickElement(driver, addedComment);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, deleteQuestionBtn);
		GenericLibrary.waitForAlertPresent(driver);
		driver.switchTo().alert().accept();
		GenericLibrary.waitForAjax(driver);
	}

	public void verify_Delete_Questionnaire (String searchItem) throws Exception {
		/*GenericLibrary.waitForElementVisibility(driver, searchBox);
		JavascriptLibrary.javascriptType(driver, searchBox, searchItem);
		JavascriptLibrary.javascriptClickElement(driver, searchBtn);*/
		WebElement ele = driver.findElement(By.xpath("//h3[contains(text(),'"+searchItem+"')]"));
		GenericLibrary.scrollIntoView(driver, ele);
		GenericLibrary.waitForElementVisibility(driver, ele);
		JavascriptLibrary.javascriptClickElement(driver, ele);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.click(driver, editBtn);
		GenericLibrary.waitForElementVisibility(driver, deleteQuestionnaireBtn);
		JavascriptLibrary.javascriptClickElement(driver, deleteQuestionnaireBtn);
		GenericLibrary.waitForElementVisibility(driver, confirmDeleteBtn);
		JavascriptLibrary.javascriptClickElement(driver, confirmDeleteBtn);
		GenericLibrary.waitForAjax(driver);
	}

	public void verify_Settings_Score_Addition_Delete_Copy_Questionnaire( 
			String QuestionnaireName, String Q1, String Q1value1, String Q1value2, String Q1value3, 
			String Q2, String Q3, String Q3value1, String Q3value2, String Q3value3,
			String Q4, String minValue, String maxValue, String stepValue, String Q5) throws Exception {
		JavascriptLibrary.javascriptClickElement(driver, addiQaptureBtn);
		GenericLibrary.waitForElementVisibility(driver, questionnaireNametextBox);
		JavascriptLibrary.javascriptType(driver, questionnaireNametextBox, QuestionnaireName);
		JavascriptLibrary.javascriptClickElement(driver, saveBtn);
		// MultiChoice Item - score
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptType(driver, descriptionTextBox, Q1);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, multiChoice);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, defaultDropDownBtn);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, highMediumLowBtn);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, moreBtn);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, scoreYesBtn);
		JavascriptLibrary.javascriptClickElement(driver, scoreShowIniQaptureYes);
		JavascriptLibrary.javascriptClickElement(driver, closeMore);
		Thread.sleep(1000);
		List<WebElement> textBoxList = driver.findElements(By.xpath("//input[@field='FI_SCORE' and @type='text']"));
		System.out.println(textBoxList.size());
		WebElement textBox1 = textBoxList.get(0);
		GenericLibrary.scrollIntoView(driver, textBox1);
		textBox1.sendKeys(Q1value1.replace(".0", ""));
		WebElement textBox2 = textBoxList.get(1);
		GenericLibrary.scrollIntoView(driver, textBox2);
		textBox2.sendKeys(Q1value2.replace(".0", ""));
		WebElement textBox3 = textBoxList.get(2);
		GenericLibrary.scrollIntoView(driver, textBox3);
		textBox3.sendKeys(Q1value3.replace(".0", ""));
		textBox3.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		// Text Item
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptType(driver, descriptionTextBox, Q2);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		// MultiChoice Item - score
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptType(driver, descriptionTextBox, Q3);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, multiChoice);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, defaultDropDownBtn);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, highMediumLowBtn);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, moreBtn);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, scoreYesBtn);
		JavascriptLibrary.javascriptClickElement(driver, scoreShowIniQaptureYes);
		JavascriptLibrary.javascriptClickElement(driver, closeMore);
		Thread.sleep(1000);
		List<WebElement> scList = driver.findElements(By.xpath("//input[@field='FI_SCORE' and @type='text']"));
		System.out.println(scList.size());
		WebElement scBox1 = scList.get(0);
		GenericLibrary.scrollIntoView(driver, scBox1);
		scBox1.sendKeys(Q3value1.replace(".0", ""));
		WebElement scBox2 = scList.get(1);
		GenericLibrary.scrollIntoView(driver, scBox2);
		scBox2.sendKeys(Q3value2.replace(".0", ""));
		WebElement scBox3 = scList.get(2);
		GenericLibrary.scrollIntoView(driver, scBox3);
		scBox3.sendKeys(Q3value3.replace(".0", ""));
		scBox3.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		// Date Item
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptType(driver, descriptionTextBox, Q4);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, date);
		GenericLibrary.waitForAjax(driver);
		// Number Item
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptType(driver, descriptionTextBox, Q5);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, number);
		JavascriptLibrary.javascriptClickElement(driver, sliderOption);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptType(driver, sliderMinValue, minValue.replace(".0", ""));
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptType(driver, sliderMaxValue, maxValue.replace(".0", ""));
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptType(driver, sliderStepValue, stepValue.replace(".0", ""));
		sliderStepValue.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		// Settings
		JavascriptLibrary.javascriptClickElement(driver, settingsBtn);
		GenericLibrary.waitForElementVisibility(driver,displayScoreTotalOnRecord_Yes);
		JavascriptLibrary.javascriptClickElement(driver, displayScoreTotalOnRecord_Yes);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, changeRecordOrder_Yes);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, copyRecords_Yes);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, showLogs_Yes);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, trashCanAction_Delete);
		GenericLibrary.waitForAjax(driver);
	}

	public void verify_Settings_Score_Multiply_and_strikeout_records_Questionnaire( 
			String QuestionnaireName, String Q1, String Q1value1, String Q1value2, String Q1value3, 
			String Q2, String Q3, String Q3value1, String Q3value2, String Q3value3,
			String Q4, String Q5, String minValue, String maxValue, String stepValue, String filePath) throws Exception {
		JavascriptLibrary.javascriptClickElement(driver, addiQaptureBtn);
		GenericLibrary.waitForElementVisibility(driver, questionnaireNametextBox);
		JavascriptLibrary.javascriptType(driver, questionnaireNametextBox, QuestionnaireName);
		JavascriptLibrary.javascriptClickElement(driver, saveBtn);
		GenericLibrary.waitForAjax(driver);
		// MultiChoice Item - score
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptType(driver, descriptionTextBox, Q1);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, multiChoice);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, defaultDropDownBtn);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, highMediumLowBtn);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, moreBtn);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, scoreYesBtn);
		JavascriptLibrary.javascriptClickElement(driver, scoreShowIniQaptureYes);
		JavascriptLibrary.javascriptClickElement(driver, closeMore);
		Thread.sleep(1000);
		List<WebElement> textBoxList = driver.findElements(By.xpath("//input[@field='FI_SCORE' and @type='text']"));
		System.out.println(textBoxList.size());
		WebElement textBox1 = textBoxList.get(0);
		GenericLibrary.scrollIntoView(driver, textBox1);
		textBox1.sendKeys(Q1value1.replace(".0", ""));
		WebElement textBox2 = textBoxList.get(1);
		GenericLibrary.scrollIntoView(driver, textBox2);
		textBox2.sendKeys(Q1value2.replace(".0", ""));
		WebElement textBox3 = textBoxList.get(2);
		GenericLibrary.scrollIntoView(driver, textBox3);
		textBox3.sendKeys(Q1value3.replace(".0", ""));
		textBox3.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		// Text Item
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptType(driver, descriptionTextBox, Q2);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		// MultiChoice Item - score
		JavascriptLibrary.javascriptClickElement(driver, multiChoice);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptType(driver, descriptionTextBox, Q3);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, defaultDropDownBtn);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, highMediumLowBtn);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, moreBtn);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, scoreYesBtn);
		JavascriptLibrary.javascriptClickElement(driver, scoreShowIniQaptureYes);
		JavascriptLibrary.javascriptClickElement(driver, closeMore);
		Thread.sleep(1000);
		List<WebElement> scList = driver.findElements(By.xpath("//input[@field='FI_SCORE' and @type='text']"));
		System.out.println(scList.size());
		WebElement scBox1 = scList.get(0);
		GenericLibrary.scrollIntoView(driver, scBox1);
		scBox1.sendKeys(Q3value1.replace(".0", ""));
		WebElement scBox2 = scList.get(1);
		GenericLibrary.scrollIntoView(driver, scBox2);
		scBox2.sendKeys(Q3value2.replace(".0", ""));
		WebElement scBox3 = scList.get(2);
		GenericLibrary.scrollIntoView(driver, scBox3);
		scBox3.sendKeys(Q3value3.replace(".0", ""));
		scBox3.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		// Date Item
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptType(driver, descriptionTextBox, Q4);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, date);
		GenericLibrary.waitForAjax(driver);
		// Number Item
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptType(driver, descriptionTextBox, Q5);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, number);
		JavascriptLibrary.javascriptClickElement(driver, sliderOption);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptType(driver, sliderMinValue, minValue.replace(".0", ""));
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptType(driver, sliderMaxValue, maxValue.replace(".0", ""));
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptType(driver, sliderStepValue, stepValue.replace(".0", ""));
		sliderStepValue.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		// Settings
		AjaxLibrary.jsClick(driver, settingsBtn);
		AjaxLibrary.jsClick(driver, displayScoreTotalOnRecord_Yes);
		AjaxLibrary.jsClick(driver, multiplyScores_Yes);
		AjaxLibrary.jsClick(driver, changeRecordOrder_Yes);
		AjaxLibrary.jsClick(driver, copyRecords_Yes);
		AjaxLibrary.jsClick(driver, showLogs_Yes);
		AjaxLibrary.jsClick(driver, trashCanAction_StrikeOut);
		// Upload Template
		GenericLibrary.uploadFile(uploadTemplate, filePath);
		GenericLibrary.waitForAjax(driver);
	}

	public void verify_Settings_send_email_to_all_companies_and_selected_companies(String questionnaireName, String Q1,String toSelectedOption, String company) throws Exception{
		SoftAssert a = new SoftAssert();
		GenericLibrary.waitForElementVisibility(driver, addiQaptureBtn);
		JavascriptLibrary.javascriptClickElement(driver, addiQaptureBtn);
		GenericLibrary.waitForElementVisibility(driver, questionnaireNametextBox);
		JavascriptLibrary.javascriptType(driver, questionnaireNametextBox, questionnaireName);
		JavascriptLibrary.javascriptClickElement(driver, saveBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(Q1);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		// Settings - email
		AjaxLibrary.jsClick(driver, settingsBtn);
		AjaxLibrary.selectElementByVisibleText(driver, emailToDD, toSelectedOption);
		AjaxLibrary.jsClick(driver, By.xpath("//label[contains(.,'"+company+"')]/span"));
		AjaxLibrary.click(driver, sendEmailBtn);
		a.assertTrue(emailSendSuccessfullyMessage.isDisplayed(), "Unable to send email to selected companies");
		Reporter.log("Email sent successfully to selected companies", true);
		a.assertAll();
	}

	//.............................. Capture ...............................................	

	public void verify_Capture_Activity_Questionnaire(String qName, String desc, String cmnt) throws Exception {
		SoftAssert a = new SoftAssert();
		WebElement q = driver.findElement(By.xpath("//h3[@title='"+qName+"']"));
		GenericLibrary.scrollIntoView(driver, q);
		Thread.sleep(1000);
		JavascriptLibrary.javascriptClickElement(driver, q);
		GenericLibrary.waitForAjax(driver);
		// Capture current activity with description and comment
		GenericLibrary.click(driver, driver.findElement(By.xpath("//table[@id='tbList']/tbody/tr[2]/td[1]")));
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.click(driver, actQIcon);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, actQTargetDateCalenderBtn);
		driver.findElement(By.xpath("//span[contains(@title,'Next Month')]"));
		//JavascriptLibrary.javascriptClickElement(driver, nextMonthBtn);
		List<WebElement> dateList = driver.findElements(By.cssSelector(".day"));
		for (WebElement ele : dateList) {
			if (ele.getText().equals("15")) {
				break;
			}
		}
		GenericLibrary.click(driver, completeBtnCurrentAct);
		a.assertTrue(actdescbox.isDisplayed(), "Mandatory message not displayed");
		Reporter.log("Mandatory message displayed",true);
		Thread.sleep(1000);
		actQDescTxtBox.sendKeys(desc);
		Thread.sleep(1000);
		actQCommentTextBox.sendKeys(cmnt);
		GenericLibrary.click(driver, completeBtnCurrentAct);
		GenericLibrary.waitForAjax(driver);
		a.assertTrue(actQCapCount.isDisplayed(), "Unable to complete current activity");
		Reporter.log("Current activity completed successfully", true);
		GenericLibrary.click(driver, saveBtn_Capture);
		/*GenericLibrary.waitForAjax(driver);
		// Verify Activity description required on completing activity without description
		GenericLibrary.click(driver, backToCaptureBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.click(driver, addRecordBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.click(driver, actQIcon);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.click(driver, completeBtnCurrentAct);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, actQTargetDateCalenderBtn);
		JavascriptLibrary.javascriptClickElement(driver, nextMonthBtn);
		List<WebElement> dateList2 = driver.findElements(By.cssSelector(".day"));
		for (WebElement ele : dateList2) {
			if (ele.getText().equals("20")) {
				break;
			}
		}
		try {
			a.assertTrue(activityDescriptionRequiredMessage.isDisplayed());
			Reporter.log("'Activity description required' alert present on trying to compete the activity without description", true);
		} catch (NoSuchElementException | AssertionError e) {
			a.assertTrue(false, "No alert on completing activity without description");
		}
		a.assertAll();*/
	}

	public void verify_Complete_and_reopen_the_Questionnaire(String qName, String ans) throws Exception{
		SoftAssert a = new SoftAssert();
		WebElement q = driver.findElement(By.xpath("//h3[@title='"+qName+"']"));
		GenericLibrary.scrollIntoView(driver, q);
		Thread.sleep(1000);
		JavascriptLibrary.javascriptClickElement(driver, q);
		GenericLibrary.waitForAjax(driver);
		// Capture
		GenericLibrary.click(driver, driver.findElement(By.xpath("//table[@id='tbList']/tbody/tr[1]/td[1]")));
		GenericLibrary.waitForAjax(driver);
		driver.findElement(By.xpath("(//span[contains(text(),'1.')])[1]/following::input[1]")).sendKeys(ans);
		JavascriptLibrary.javascriptClickElement(driver, saveBtn_Capture);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, completeBtn_Capture);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.click(driver, driver.findElement(By.xpath(".//*[@id='tbRecords']/tbody/tr/td[1]")));
		GenericLibrary.waitForAjax(driver);
		a.assertTrue(reopenBtn_Capture.isDisplayed(), "Questionnaire not completed");
		Reporter.log("Questionnaire completed successfully", true);
		JavascriptLibrary.javascriptClickElement(driver, reopenBtn_Capture);
		GenericLibrary.waitForElementVisibility(driver, Ok_Btn);
		JavascriptLibrary.javascriptClickElement(driver, Ok_Btn);
		GenericLibrary.waitForAjax(driver);
		a.assertTrue(completeBtn_Capture.isDisplayed(), "Questionnaire not reopened");
		Reporter.log("Questionnaire reopend successfully", true);
		a.assertAll();
	}

	public void verify_Capture_mutichoice_Questionnaire(String qName) throws Exception{
		WebElement q = driver.findElement(By.xpath("//h3[@title='"+qName+"']"));
		GenericLibrary.scrollIntoView(driver, q);
		Thread.sleep(1000);
		JavascriptLibrary.javascriptClickElement(driver, q);
		GenericLibrary.waitForAjax(driver);
		// Capture
		AjaxLibrary.click(driver, driver.findElement(By.xpath("//table[@id='tbList']/tbody/tr[1]/td[1]")));
		Thread.sleep(2000);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.click(driver, driver.findElement(By.xpath("(//span[contains(text(),'1.')])[1]/following::label[1]")));
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.click(driver, driver.findElement(By.xpath("(//span[contains(text(),'2.')])[1]/following::label[1]")));
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.click(driver, driver.findElement(By.xpath("(//span[contains(text(),'3.')])[1]/following::span[contains(@id,'select')][1]")));
		GenericLibrary.click(driver, driver.findElement(By.xpath("//ul[contains(@id,'ulList')]/following::li[contains(.,'High')][1]")));
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.click(driver, driver.findElement(By.xpath("(//span[contains(text(),'4.')])[1]/following::span[contains(@id,'select')][1]")));
		GenericLibrary.click(driver, driver.findElement(By.xpath("//ul[contains(@id,'ulList')]/following::li[contains(.,'Yes')][1]")));
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.click(driver, driver.findElement(By.xpath("(//span[contains(text(),'5.')])[1]/following::input[contains(@value,'High')][1]/following::span[1]")));
		GenericLibrary.click(driver, driver.findElement(By.xpath("(//span[contains(text(),'5.')])[1]/following::input[contains(@value,'Medium')][1]/following::span[1]")));
		GenericLibrary.click(driver, driver.findElement(By.xpath("(//span[contains(text(),'6.')])[1]/following::input[contains(@value,'Yes')][1]/following::span[1]")));
		GenericLibrary.click(driver, driver.findElement(By.xpath("(//span[contains(text(),'6.')])[1]/following::input[contains(@value,'No')][1]/following::span[1]")));
		GenericLibrary.scrollTop(driver);
		GenericLibrary.click(driver, saveBtn_Capture);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, backToCaptureBtn);
		GenericLibrary.waitForAjax(driver);
		Assert.assertTrue(driver.findElement(By.xpath(".//*[@id='tbRecords']/tbody/tr/td[1]")).isDisplayed(), "Questionnaire not captured");
		Reporter.log("Multichoice Questionnaire captured successfully", true);
	}

	public void verify_Capture_Date_Questionnaire(String qName) throws Exception {
		WebElement q = driver.findElement(By.xpath("//h3[@title='"+qName+"']"));
		GenericLibrary.scrollIntoView(driver, q);
		Thread.sleep(1000);
		JavascriptLibrary.javascriptClickElement(driver, q);
		GenericLibrary.waitForAjax(driver);
		// Capture
		GenericLibrary.click(driver, driver.findElement(By.xpath("//table[@id='tbList']/tbody/tr[1]/td[1]")));
		Thread.sleep(2000);
		GenericLibrary.waitForAjax(driver);
		// Date
		JavascriptLibrary.javascriptClickElement(driver, driver.findElement(By.xpath("(//span[contains(@class,'fa fa-calendar')])[1]")));
		JavascriptLibrary.javascriptClickElement(driver, todayDateBtn);
		// Date & Time
		JavascriptLibrary.javascriptClickElement(driver, driver.findElement(By.xpath("(//span[contains(@class,'fa fa-calendar')])[2]")));
		JavascriptLibrary.javascriptClickElement(driver, todayDateBtn);
		JavascriptLibrary.javascriptClickElement(driver, hourPickBtn);
		List<WebElement> hourList = driver.findElements(By.cssSelector(".hour"));
		for ( WebElement hr : hourList) {
			if(hr.getText().equals("10")) {
				hr.click();
				break;
			}
		}
		JavascriptLibrary.javascriptClickElement(driver, minutePickBtn);
		List<WebElement> minuteList = driver.findElements(By.cssSelector(".hour"));
		for ( WebElement mt : minuteList) {
			if(mt.getText().equals("50")) {
				mt.click();
				break;
			}
		}
		// Time
		JavascriptLibrary.javascriptClickElement(driver, driver.findElement(By.xpath("(//span[contains(@class,'fa fa-calendar')])[3]")));
		JavascriptLibrary.javascriptClickElement(driver, hourPickBtn);
		List<WebElement> hourList2 = driver.findElements(By.cssSelector(".hour"));
		for ( WebElement hr : hourList2) {
			if(hr.getText().equals("02")) {
				hr.click();
				break;
			}
		}
		JavascriptLibrary.javascriptClickElement(driver, minutePickBtn);
		List<WebElement> minuteList2 = driver.findElements(By.cssSelector(".hour"));
		for ( WebElement mt : minuteList2) {
			if(mt.getText().equals("30")) {
				mt.click();
				break;
			}
		}
		// Week and date
		JavascriptLibrary.javascriptClickElement(driver, driver.findElement(By.xpath("(//span[contains(@class,'fa fa-calendar')])[4]")));
		JavascriptLibrary.javascriptClickElement(driver, todayDateBtn);

		GenericLibrary.click(driver, saveBtn_Capture);
		GenericLibrary.waitForAjax(driver);
		Thread.sleep(1000);
		GenericLibrary.click(driver, backToCaptureBtn);
		GenericLibrary.waitForAjax(driver);
		Assert.assertTrue(driver.findElement(By.xpath(".//*[@id='tbRecords']/tbody/tr/td[1]")).isDisplayed(), "Questionnaire not captured");
		Reporter.log("Date Questionnaire captured successfully", true);
	}

	public void verify_Capture_Number_Questionnaire(String qName, String intValue, String floatValue, String percentValue, String currencyValue) throws Exception {
		WebElement q = driver.findElement(By.xpath("//h3[@title='"+qName+"']"));
		GenericLibrary.scrollIntoView(driver, q);
		Thread.sleep(1000);
		JavascriptLibrary.javascriptClickElement(driver, q);
		GenericLibrary.waitForAjax(driver);
		// Capture
		GenericLibrary.click(driver, driver.findElement(By.xpath("//table[@id='tbList']/tbody/tr[1]/td[1]")));
		Thread.sleep(2000);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.sendKeys(driver, integerTextBox, 20, intValue.replace(".0", ""));
		floatTextBox.sendKeys(floatValue.replace(".0", ""));
		percentageTextBox.sendKeys(percentValue.replace(".0", ""));
		currencyTextBox.sendKeys(currencyValue.replace(".0", ""));

		GenericLibrary.click(driver, saveBtn_Capture);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, backToCaptureBtn);
		//GenericLibrary.click(driver, backToCaptureBtn);
		GenericLibrary.waitForAjax(driver);
		Assert.assertTrue(driver.findElement(By.xpath(".//*[@id='tbRecords']/tbody/tr/td[1]")).isDisplayed(), "Questionnaire not captured");
		Reporter.log("Number Questionnaire captured successfully", true);
	}

	public void verify_Capture_Upload_Questionnaire(String qName, String filePath) throws Exception{
		WebElement q = driver.findElement(By.xpath("//h3[@title='"+qName+"']"));
		GenericLibrary.scrollIntoView(driver, q);
		Thread.sleep(1000);
		JavascriptLibrary.javascriptClickElement(driver, q);
		GenericLibrary.waitForAjax(driver);
		// Capture
		GenericLibrary.click(driver, driver.findElement(By.xpath("//table[@id='tbList']/tbody/tr[1]/td[1]")));
		Thread.sleep(2000);
		GenericLibrary.waitForAjax(driver);
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("(//span[contains(.,'1.')]/following::span[1])[1]")));
		AjaxLibrary.uploadFile(driver, uploadFileBrowseBtn, filePath);
		Thread.sleep(1000);
		AjaxLibrary.jsClick(driver, saveBtn_Capture);
		AjaxLibrary.jsClick(driver, backToCaptureBtn);
		Assert.assertTrue(driver.findElement(By.xpath(".//*[@id='tbRecords']/tbody/tr/td[1]")).isDisplayed(), "Questionnaire not captured");
		Reporter.log("Upload File Questionnaire captured successfully", true);
	}

	public void verify_Capture_Settings_Score_Addition_Copy_and_Delete_records_Questionnaire(String qName) throws Exception {
		WebElement q = driver.findElement(By.xpath("//h3[@title='"+qName+"']"));
		GenericLibrary.scrollIntoView(driver, q);
		Thread.sleep(1000);
		JavascriptLibrary.javascriptClickElement(driver, q);
		GenericLibrary.waitForAjax(driver);
		// Capture
		GenericLibrary.click(driver, driver.findElement(By.xpath("//table[@id='tbList']/tbody/tr[1]/td[1]")));
		Thread.sleep(2000);
		GenericLibrary.waitForAjax(driver);
		// Score addition
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("(//span[contains(text(),'1.')])[1]/following::label[1]")));
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("(//span[contains(text(),'2.')])[1]/following::label[2]")));
		String txt = scoreTotal.getText();
		int expTotal = Integer.parseInt(txt.replaceAll("['SCORE:' ' ']", ""));
		Reporter.log("Expected score total: "+expTotal, true);
		AjaxLibrary.jsClick(driver, saveBtn_Capture);
		AjaxLibrary.jsClick(driver, backToCaptureBtn);
		int actTotal = Integer.parseInt(driver.findElement(By.xpath("//tr/td[6]/span")).getText());
		Reporter.log("Actual score total: "+actTotal, true);
		Assert.assertEquals(actTotal, expTotal, "Score addition is not functional");
		Reporter.log("Score addition is functional", true);
		// Delete records
		AjaxLibrary.jsClick(driver, By.xpath(".//*[@id='tbRecords']/tbody/tr/td[4]"));
		GenericLibrary.click(driver, deleteRecordsBtn);
		AjaxLibrary.checkAlert_Accept(driver);
		Assert.assertTrue(noMatchingRecordsFoundMessage.isDisplayed(), "Record not deleted");
		Reporter.log("Record deleted successfully", true);
	}

	public void verify_Capture_Settings_Score_Multiply_and_strikeout_records_Questionnaire(String qName) throws Exception {
		WebElement q = driver.findElement(By.xpath("//h3[@title='"+qName+"']"));
		GenericLibrary.scrollIntoView(driver, q);
		Thread.sleep(1000);
		JavascriptLibrary.javascriptClickElement(driver, q);
		GenericLibrary.waitForAjax(driver);
		// Capture
		GenericLibrary.click(driver, driver.findElement(By.xpath("//table[@id='tbList']/tbody/tr[1]/td[1]")));
		Thread.sleep(2000);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, driver.findElement(By.xpath("(//label[contains(.,'High')])[1]")));
		JavascriptLibrary.javascriptClickElement(driver, driver.findElement(By.xpath("(//label[contains(.,'High')])[1]")));
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, driver.findElement(By.xpath("(//label[contains(.,'Medium')])[2]")));
		driver.findElement(By.xpath("//span[text()='5.']/following::input[1]")).sendKeys("Text Area");
		driver.findElement(By.xpath("//span[text()='5.1.1.']/following::input[1]")).sendKeys("Text Area");
		WebElement b = driver.findElement(By.xpath("//span[text()='b.']/following::input[1]"));
		GenericLibrary.scrollIntoView(driver, b);
		b.sendKeys("Text Area");

		GenericLibrary.scrollTop(driver);
		GenericLibrary.click(driver, saveBtn_Capture);
		GenericLibrary.waitForAjax(driver);
		Thread.sleep(1000);
		GenericLibrary.click(driver, backToCaptureBtn);
		GenericLibrary.waitForAjax(driver);

		// Multiply Scores
		List<WebElement> multipliedScoreList = driver.findElements(By.xpath("//span[@class='number-rebc-empty']"));
		String scoreResult = multipliedScoreList.get(0).getText();
		Reporter.log("Multiplied Scores for 100 and 75: "+scoreResult,true);
		Assert.assertEquals(scoreResult, "7500", "Scores Multiplication is Not Functional" );
		Reporter.log("Score Multiplications is Functional", true);		
		// StrikeOut Record 
		List<WebElement> recordList = driver.findElements(By.xpath(".//*[@id='tbRecords']/tbody/tr/td[2]"));
		JavascriptLibrary.javascriptClickElement(driver, recordList.get(0));
		JavascriptLibrary.javascriptClickElement(driver, deleteRecordsBtn);
		GenericLibrary.waitForAlertPresent(driver);
		driver.switchTo().alert().accept();
		GenericLibrary.waitForAjax(driver);
		Assert.assertTrue(strikedOutLine.isDisplayed(), "Strike out option not working");
		Reporter.log("Strike out option is functional", true);
	}

	public void verify_Download_questionnaire_template_and_Upload_answers(String qName, String Q1, String Q2, String downloadPath, String fileName, String upFile) throws Exception {
		// Adding Questionnaire
		SoftAssert a = new SoftAssert();
		JavascriptLibrary.javascriptClickElement(driver, addiQaptureBtn);
		GenericLibrary.waitForElementVisibility(driver, questionnaireNametextBox);
		JavascriptLibrary.javascriptType(driver, questionnaireNametextBox, qName);
		JavascriptLibrary.javascriptClickElement(driver, saveBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptType(driver, descriptionTextBox, Q1);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptType(driver, descriptionTextBox, Q2);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		// Download template
		AjaxLibrary.jsClick(driver, DataCaptureLink);
		//GenericLibrary.click(driver, DataCaptureLink);
		WebElement q = driver.findElement(By.xpath("//h3[@title='"+qName+"']"));
		GenericLibrary.scrollIntoView(driver, q);
		Thread.sleep(1000);
		JavascriptLibrary.javascriptClickElement(driver, q);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.click(driver, downloadQuestionsTemplateBtn);
		Thread.sleep(2000);
		a.assertTrue(VerificationLibrary.isFileDownloaded(downloadPath, fileName), "Template NOT downloaded");
		Reporter.log("Template downloaded", true);
		// Upload answers
		GenericLibrary.uploadFile(uploadAnswerssBtn, upFile);
		GenericLibrary.waitForAjax(driver);
		a.assertTrue(driver.findElement(By.xpath("(//div[@aria-valuenow='100'])[1]")).isDisplayed(), "Answers not uploaded");
		Reporter.log("Answers uploaded successfully", true);
	}

	public void verify_Create_and_capture_the_questionnaitre_for_analyse_section(String qName,
			String radioHML, String dropDownYesNoNa, String checkBoxYesNoNa, 
			String Q1, String Q2, String Q3, String Q4, String filePath) throws Exception {
		JavascriptLibrary.javascriptClickElement(driver, addiQaptureBtn);
		GenericLibrary.waitForElementVisibility(driver, questionnaireNametextBox);
		JavascriptLibrary.javascriptType(driver, questionnaireNametextBox, qName);
		JavascriptLibrary.javascriptClickElement(driver, saveBtn);
		GenericLibrary.waitForAjax(driver);
		// MultiChoice - Radio Buttons - High/Medium/Low priority
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(radioHML);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, multiChoice);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, defaultDropDownBtn);
		JavascriptLibrary.javascriptClickElement(driver, highMediumLowBtn);
		GenericLibrary.waitForAjax(driver);
		// MultiChoice - DropDowns - Yes/No/Na
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(dropDownYesNoNa);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, multiChoice);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, dropDowns);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, defaultDropDownBtn);
		JavascriptLibrary.javascriptClickElement(driver, yesNoNaBtn);
		GenericLibrary.waitForAjax(driver);
		// MultiChoice - CheckBoxes - Yes/No/Na
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		descriptionTextBox.sendKeys(checkBoxYesNoNa);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, multiChoice);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, checkBoxes);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, defaultDropDownBtn);
		JavascriptLibrary.javascriptClickElement(driver, yesNoNaBtn);
		GenericLibrary.waitForAjax(driver);
		// Number - Integer
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptType(driver, descriptionTextBox, Q1);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, number);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, integerOption);
		GenericLibrary.waitForAjax(driver);
		// Number - Float
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptType(driver, descriptionTextBox, Q2);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, number);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, floatOption);
		GenericLibrary.waitForAjax(driver);
		// Number - Percentage
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptType(driver, descriptionTextBox, Q3);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, number);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, percentageOption);
		GenericLibrary.waitForAjax(driver);
		// Number - Currency
		GenericLibrary.waitForElementVisibility(driver, addFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, addFieldBtn);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptType(driver, descriptionTextBox, Q4);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, number);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, currencyOption);
		GenericLibrary.waitForAjax(driver);
		// Capture the Questionnaire
		JavascriptLibrary.javascriptClickElement(driver, backBtn);
		GenericLibrary.waitForAjax(driver);
		WebElement questionnaire = driver.findElement(By.xpath("//h3[contains(@title,'"+qName+"')]"));
		Assert.assertTrue(questionnaire.isDisplayed(), "Questionnaire not created");
		Reporter.log("Questionnaire created for analyse", true);
		GenericLibrary.scrollIntoView(driver, questionnaire);
		JavascriptLibrary.javascriptClickElement(driver, questionnaire);
		GenericLibrary.waitForAjax(driver);
		// Create Records for companies 
		for (int i = 1; i <= 2; i++) {
			GenericLibrary.click(driver, driver.findElement(By.xpath(".//*[@id='tbList']/tbody/tr["+i+"]/td[1]")));
			GenericLibrary.waitForAjax(driver);
			JavascriptLibrary.javascriptClickElement(driver, backBtn);
			GenericLibrary.waitForAjax(driver);
			GenericLibrary.uploadFile(uploadAnswerssBtn, filePath);
			GenericLibrary.waitForAjax(driver);
			List<WebElement> records = driver.findElements(By.xpath(".//*[@id='tbRecords']/tbody/tr/td[3]"));
			Assert.assertTrue(records.size() > 0, "Records not created for the company"+i+"");
			Reporter.log("Records created for the company"+i+"", true);
			JavascriptLibrary.javascriptClickElement(driver, backBtn);
			GenericLibrary.waitForAjax(driver);
		}
		
	}










}















