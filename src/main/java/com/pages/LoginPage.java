package com.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.base.BasePage;
import com.util.GenericLibrary;
import com.util.JavascriptLibrary;

public class LoginPage extends BasePage {

	// Objects Repository(OR):........................................................................
	@FindBy(id="txtLoginName")
	WebElement username;

	@FindBy(name="password")
	WebElement password;

	@FindBy(id="btnLogin")
	WebElement loginBtn;

	//@FindBy(xpath=".//*[@id='lblMainMenuHint']") // Alpha 
	//@FindBy(xpath=".//*[@id='btnMainMenuTitle']//preceding::a[20]") // Local
	@FindBy(xpath="(//i[contains(@style,'color: #FFFFFF;')])[1]") // Test
	static WebElement menuBtn;

	@FindBy(xpath="//span[text()='iQluster']")
	static WebElement iQlusterApp;

	@FindBy(xpath="(//div[contains(.,'My Network List')])[6]")
	WebElement MyNetworkListLink;

	// Verify login form
	@FindBy(xpath=".//*[@id='info']/span")
	WebElement errorMsg;






	// Initializing the Page Objects:................................................................
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}

	// Actions:......................................................................................
	public String verify_LoginPage_Title(){
		return driver.getTitle();
	}

	public MyNetworkListPage verify_login_functionality(String un, String pwd){
		GenericLibrary.waitForElementVisibility(driver, username);
		username.sendKeys(un);
		password.sendKeys(pwd);
		JavascriptLibrary.javascriptClickElement(driver, loginBtn);
		GenericLibrary.waitForElementVisibility(driver, menuBtn);
		JavascriptLibrary.javascriptClickElement(driver, menuBtn);
		JavascriptLibrary.javascriptClickElement(driver, iQlusterApp);

		GenericLibrary.waitForElementVisibility(driver, MyNetworkListLink);
		Assert.assertTrue(MyNetworkListLink.isDisplayed());
		return new MyNetworkListPage();
	}

	public void verify_Login_form(String un, String pwd) {
		try {
			GenericLibrary.waitForElementVisibility(driver, username);
			Assert.assertTrue(username.isDisplayed(), "Login NOT opened");
			Reporter.log("Login page opened successfully", true);
			username.sendKeys(un);
			password.sendKeys(pwd);
			JavascriptLibrary.javascriptClickElement(driver, loginBtn);

			JavascriptLibrary.javascriptClickElement(driver, menuBtn);
			JavascriptLibrary.javascriptClickElement(driver, MyNetworkListLink);
			Assert.assertTrue(MyNetworkListLink.isDisplayed(), "Login FAIL");
			Reporter.log("Login PASS & DashBoard page opened successfully");
		} catch (NoSuchElementException e) {
			String msg = errorMsg.getText();
			if (msg.equalsIgnoreCase("Please fill email.")) {
				Reporter.log("Invalid EMAIL", true);
				Assert.fail();
			} else if(msg.equalsIgnoreCase("Please fill password.")){
				Reporter.log("Invalid PASSWORD", true);
				Assert.fail();
			} else {
				Reporter.log("Sorry, the username or password is incorrect. Please try again.", true);
				Assert.fail();
			}
		}
	}

	



















}
