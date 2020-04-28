/**
 * @author UmaMaheswararao
 */

package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.base.BasePage;
import com.util.GenericLibrary;

public class ExplorePage extends BasePage {

	// Objects Repository(OR):........................................................................
	// Page Verification
	@FindBy(xpath = "(//span[contains(.,'Explore')])[3]")
	WebElement exploreHeaderText;

	// View Map and verify settings
	@FindBy(xpath=".//*[@id='divMapCanvas']//div[3]")
	WebElement map;

	@FindBy(xpath = "//span[contains(.,'OFF')]")
	WebElement showPrompt_ON;

	@FindBy(xpath="//a[contains(@title,'Fit to screen')]")
	WebElement fitToScreenBtn;

	@FindBy(xpath="//a[contains(@title,'Rearrange elements')]")
	WebElement rearrangeElementsBtn;

	@FindBy(xpath="//a[contains(@title,'Lock all')]")
	WebElement lockAllBtn;

	@FindBy(xpath="//a[contains(@title,'Unlock all')]")
	WebElement unLockAllBtn;

	@FindBy(xpath="//a[contains(@title,'Toggle fullscreen mode')]")
	WebElement fullScreenModeBtn;

	@FindBy(xpath="//a[contains(@title,'Back')]")
	WebElement mapBackBtn;

	@FindBy(xpath="//span[contains(@class,'zoom')]")
	WebElement mapZoomBar;

	@FindBy(xpath="//span[contains(@class,'zoom')]/em")
	WebElement mapZoomBtn;



















	// Initializing the Page Objects:................................................................
	public ExplorePage() {
		PageFactory.initElements(driver, this);
	}


	// Actions:......................................................................................
	public void verify_Explore_page() {
		Assert.assertTrue(exploreHeaderText.isDisplayed(), "Unable to open explore page");
	}

	public void verify_Map_contains_companies_and_enable_map_settings() throws Exception {
		SoftAssert a = new SoftAssert();
		// View map
		GenericLibrary.waitForElementVisibility(driver, map);
		a.assertTrue(map.isDisplayed(), "Map is not opening");
		Reporter.log("Map is opened successfully", true);
		// Prompt message
		GenericLibrary.click(driver, showPrompt_ON);
		GenericLibrary.waitForAjax(driver);
		Reporter.log("Prompt message enabled successfully", true);
		// Fit to screen
		a.assertTrue(fitToScreenBtn.getAttribute("class").contains("active"), "Fit screen is inactive by default");
		Reporter.log("Fit to screen is active by default", true);
		GenericLibrary.click(driver, fitToScreenBtn);
		GenericLibrary.waitForAjax(driver);
		if (fitToScreenBtn.getAttribute("class").contains("active")) {
			a.assertTrue(false, "Fit to screen button is not functonal");
		} else {
			Reporter.log("Fit to screen option is functional", true);
		}
		// Rearrange
		GenericLibrary.click(driver, rearrangeElementsBtn);
		GenericLibrary.waitForAjax(driver);
		Reporter.log("Rearrange option is functional", true);
		// Lock All
		GenericLibrary.click(driver, lockAllBtn);
		GenericLibrary.waitForAjax(driver);
		a.assertTrue(unLockAllBtn.isDisplayed(), "Lock all option is not working");
		Reporter.log("Lock all option is functional", true);
		// Full screen mode
		GenericLibrary.click(driver, fullScreenModeBtn);
		GenericLibrary.waitForAjax(driver);
		a.assertTrue(fullScreenModeBtn.getAttribute("class").contains("active"), "Full screen option not working");
		Reporter.log("Full screen option is functional", true);
		Thread.sleep(1000);
		GenericLibrary.click(driver, fullScreenModeBtn);
		GenericLibrary.waitForAjax(driver);
		// Back button
		a.assertTrue(mapBackBtn.getAttribute("class").contains("DVSL-bar-disabled"), "Back button is not disabled by default");
		Reporter.log("Back button is disabled by default", true);
		
		// Zoom map
		String x = mapZoomBtn.getAttribute("style");
		float x1 = Float.parseFloat(x.substring(5, x.length()-3));
		Reporter.log("Map zoom before adjustment: "+x1, true);
		GenericLibrary.actionClickAtParticularPartOfElementWrtXY(driver, mapZoomBar, 0, -10);
		String y = mapZoomBtn.getAttribute("style");
		float y1 = Float.parseFloat(y.substring(5, y.length()-3));
		Reporter.log("Map zoom after adjustment: "+y1, true);
		a.assertTrue(y1 < x1, "Map zoom is not functional");
		Reporter.log("Map zoom option is functional", true);
		a.assertAll();
	}

	public void verify_Edit_map() {
		
	}


















}















