/**
 * @author UmaMaheswararao
 */

package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.base.BasePage;

public class LocationMapPage extends BasePage {

	// Objects Repository(OR):........................................................................
	@FindBy(xpath="(//span[contains(.,'Location Map')])[2]")
	WebElement locationMapHeadderText;
	
	// Search company
	@FindBy(xpath="//i[@class='fa fa-search']")
	WebElement searchBtn;
	
	@FindBy(xpath="//input[contains(@class,'form-control searcher-text')]")
	WebElement searchBox;
	
	
	
	
	
	
	
	
	
	
	
	
	
	






	// Initializing the Page Objects:................................................................
	public LocationMapPage() {
		PageFactory.initElements(driver, this);
	}


	// Actions:......................................................................................
	public void verify_Loaction_map_page() {
		Assert.assertTrue(locationMapHeadderText.isDisplayed(), "Location Map Page not opened");
	}
	
	
	
	
	
	
	















}















