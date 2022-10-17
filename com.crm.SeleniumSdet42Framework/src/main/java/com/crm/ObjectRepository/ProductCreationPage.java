package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCreationPage {


	// Initilisation
	public ProductCreationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//img[@title='Create Product...']")
	private WebElement CreateProductLink;
	
	public void clickOnCreateProductLink() {
		CreateProductLink.click();
	}  
	
	@FindBy(xpath="//input[@name='productname']")
	private WebElement ProductName;
	
	public void productName(String name) {
		ProductName.sendKeys(name);
	}
	
	@FindBy(xpath="//input[@class='crmbutton small save']")
	private WebElement saveProduct;
	
	public void clickOnSaveProduct() {
		saveProduct.click();
	}

	@FindBy(id="dtlview_Product Name")
	private WebElement productName;
	
	public String getProductName() {
		String name = productName.getText();
		return name;
	}
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement signoutImgSign;
	
	public WebElement getProductLink() {
		return getCreateProductLink();
	}

	public WebElement getCreateProductLink() {
		return CreateProductLink;
	}

	public WebElement getSaveProduct() {
		return saveProduct;
	}

	public WebElement getSignoutImgSign() {
		return signoutImgSign;
	}

	public WebElement getSignoutLink() {
		return signoutLink;
	}

	public WebElement moveToSignoutImgSign() {
		WebElement logoutSign = signoutImgSign;
		return logoutSign;
	}
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signoutLink;
	
	public void clickOnSignoutLink() {
		signoutLink.click();
	}
	
	@FindBy(xpath="//input[@title='Delete [Alt+D]']")
	private WebElement productSaveButton;
	
	public void clickOnProductSaveButton() {
		productSaveButton.click();
	}
}
