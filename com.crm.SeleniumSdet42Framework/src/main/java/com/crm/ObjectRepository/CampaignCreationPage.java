package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.Generic_Utility.ExcellUtility;
import com.crm.Generic_Utility.JavaUtility;

public class CampaignCreationPage {

	// Initilisation
	public CampaignCreationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// click on create organization page
	@FindBy(xpath = "//img[@title='Create Campaign...']")
	private WebElement CreateCampaign;

	public WebElement getCreateCampaign() {
		return CreateCampaign;
	}

	public void clickOnCreateCampaign() {
		CreateCampaign.click();
	}

	@FindBy(xpath = "//input[@name='campaignname']")
	private WebElement campaignNameText;

	public void enterCampaignName(String text) {
		campaignNameText.sendKeys(text);
	}

	public WebElement getCampaignNameText() {
		return campaignNameText;
	}

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	public void clickOnSaveButton() {
		saveButton.click();
	}

	@FindBy(xpath = "//span[@id='dtlview_Campaign Name']")
	private WebElement campaignName;

	public String campaignNameText() {
		String text = campaignName.getText();
		return text;
	}

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement logoutImgsign;

	public void clickOnLogoutImgSign() {
		logoutImgsign.click();
	}

	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement logoutSign;

	public void clickOnLogoutSign() {
		logoutImgsign.click();
	}

	@FindBy(xpath = "//img[@src='themes/softed/images/select.gif']")
	private WebElement addProduct;

	public void clickOnAddProductInCampaign() {
		addProduct.click();
	}

	@FindBy(xpath = "//input[@class='txtBox']")
	private WebElement searchProduct;

	public void searchProduct(String text) {
		searchProduct.sendKeys(text);
	}

	@FindBy(xpath = "//input[@name='search']")
	private WebElement clickOnSearch;

	public void clickOnSearchProduct() {
		clickOnSearch.click();
	}

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveCampaign;
	
	public void clickOnSaveCampaign() {
		saveCampaign.click();
	}

   @FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
   private WebElement signoutImgSign;
   
   public void clickonSignoutImg() {
	   signoutImgSign.click();
   }
   @FindBy(xpath="//a[text()='Sign Out']")
   private WebElement signout;
   
   public void clickOnSignout() {
	   signout.click();
   }
	
	
}
