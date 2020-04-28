/**
 * @author UmaMaheswararao
 */

package com.testcases;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.BasePage;
import com.pages.LoginPage;
import com.pages.MyNetworkListPage;
import com.util.Container;

public class LoginPageTest extends BasePage {
	
	LoginPage loginPage;
	MyNetworkListPage myNetworkListPage;
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void verify_LoginPage_Title_Test(){
		String title = loginPage.verify_LoginPage_Title();
		Assert.assertEquals(title, "login");
		Reporter.log("LoginPage Title Verified", true);
	}
	
	@Test(dependsOnMethods="verify_LoginPage_Title_Test")
	public void verify_login_functionality_Test() throws Exception{
		myNetworkListPage = loginPage.verify_login_functionality(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User Loggedin & Network List Page Opened Successfully ", true);
	}
	
	
	@DataProvider
	public Iterator<Object[]> getLogInTestData() {
		ArrayList<Object[]> testData = Container.getLoginDataFromExcel();
		return testData.iterator();
	}
	
	@Test(dataProvider="getLogInTestData", enabled=false)
	public void verify_Login_form(String userName, String password) throws Exception{
		loginPage.verify_Login_form(userName, password);
		Reporter.log("User Loggedin Successfully & DashBoard Page Opened", true);
	}
	
	
	
}
