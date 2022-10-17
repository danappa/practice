package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.Generic_Utility.WebDriverUtility;


public class HomePage {

	// Initilisation
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// declaration element of organisation link
	@FindBy(xpath = "(//td[@class='tabUnSelected' and @nowrap])[3]")
	private WebElement organisationsElement;

	public void clickOrganisationLink() {
		organisationsElement.click();
	}

	// utilisationof element product link
	@FindBy(xpath = "//a[text()='Products']")
	private WebElement productElement;

	public void clickOnProductLink() {
		productElement.click();
	}

	// more link
	@FindBy(xpath = "//a[text()='More']")
	private WebElement moreLink;

	public void clickOnMoreLink(WebDriver driver) {
		WebDriverUtility wdutil = new WebDriverUtility();
		wdutil.mouseOverOnElement(driver, moreLink);
	}

	// campaign link
	@FindBy(name = "Campaigns")
	private WebElement campaignLink;

	public void clickOnCampaign() {
		campaignLink.click();
	}

	// signout sign image link
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement signoutImg;
	public void signoutLinkImage() {
		signoutImg.click();
	}
	// signout link
	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement signoutLink;
	//click on signoutLink
	public void clickOnSignoutLink(WebDriver driver) {
		WebDriverUtility wdutil = new WebDriverUtility();
		wdutil.mouseOverOnElement(driver,signoutLink ); 
	}

}
