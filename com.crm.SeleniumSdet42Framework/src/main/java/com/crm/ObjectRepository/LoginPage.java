package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
     
	//Initilisation
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//declaration
	@FindBy(name="user_name")
	private WebElement userNameTextField;
	
	@FindBy(name="user_password")
	private WebElement passwordTextField;
	
	@FindBy(id="submitButton")
	private WebElement submitButtom;

	public WebElement getUserNameTextField() {
		return userNameTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getSubmitButtom() {
		return submitButtom;
	}
	
	//Business Logic
	/**
	 * This method is used to login app
	 * @param userName
	 * @param password
	 */
	public void login(String userName,String password)
	{
		userNameTextField.sendKeys(userName);
		passwordTextField.sendKeys(password);
		submitButtom.click();
	}
	
	
	
	
	
	
	
	
	
}
