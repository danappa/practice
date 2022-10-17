package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.Generic_Utility.ExcellUtility;
import com.crm.Generic_Utility.JavaUtility;

public class ValidationVarificationPage {

	public ValidationVarificationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// verification organisation name
	@FindBy(xpath = ("//span[@id='dtlview_Organization Name']"))
	private WebElement organizationNameText;

	public WebElement getOrganizationNameText() {
		return organizationNameText;
	}

	public void organisationValidation(WebDriver driver, String data) {
		String orgNameText = organizationNameText.getText();
		if (orgNameText.contains(data)) {
			System.out.println("organisation pass");
		} else {
			System.out.println("organisation is fail");
		}
	}

	// product name
	@FindBy(xpath = "//span[@id='dtlview_Campaign Name']")
	private WebElement campaignName;

	public WebElement campaignNameText() {
		// String text = campaignName.getText();
		return campaignName;
	}

	public void campaignNameValidation(WebDriver driver, String data) {
		String campaignNameText = campaignName.getText();
		if (campaignNameText.contains(data)) {
			System.out.println("campaignName pass");
		} else {
			System.out.println("campaignName is fail");
		}
	}

	// campaign name
	@FindBy(id="dtlview_Product Name")
	private WebElement productName;

	public WebElement ProductNameText() {
		// String text = productName.getText();
		return productName;
	}

	public void productNameValidation(WebDriver driver, String data) {
		String productNameText = productName.getText();
		if (productNameText.contains(data)) {
			System.out.println("productName pass");
		} else {
			System.out.println("productName is fail");
		}
	}
}
