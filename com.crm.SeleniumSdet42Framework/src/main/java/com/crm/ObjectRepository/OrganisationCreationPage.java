package com.crm.ObjectRepository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.Generic_Utility.ExcellUtility;

public class OrganisationCreationPage {

	// Initilisation
	public OrganisationCreationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//click on create organization page
	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement CreateOrganizations;

	public void clickOnCreateOrganisation() {
		CreateOrganizations.click();
	}

	// Organization name enter
	@FindBy(xpath = "//input[@name='accountname']")
	private WebElement OrganisationName;

	public void enterOrganisationName(int ranNum) throws Throwable {
		ExcellUtility exutill = new ExcellUtility();
		String data = exutill.getExcellKeyValue("Sheet1", 0, 0) + ranNum;
		OrganisationName.sendKeys(data);
	}

	// click on save button
	@FindBy(xpath = ("//input[@class='crmbutton small save']"))
	private WebElement saveButton;

	public void clickOnSaveButton() {
		saveButton.click();
	}

	// verification organisation name
	@FindBy(xpath = ("//span[@id='dtlview_Organization Name']"))
	private WebElement organizationNameText;

	public String orgNameText() {
		String orgNameText = organizationNameText.getText();
		return orgNameText;
	}

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement logoutImgsign;

	public void clickOnLogoutImgSign() {
		logoutImgsign.click();
	}

}
