package com.crm.Product;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.Generic_Utility.BaseClass;
import com.crm.Generic_Utility.ExcellUtility;
import com.crm.Generic_Utility.JavaUtility;
import com.crm.Generic_Utility.WebDriverUtility;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.ProductCreationPage;
import com.crm.ObjectRepository.ValidationVarificationPage;
@Test
public class CreateProduct extends BaseClass {
	@Test(groups = "regressionTest")
	public void CreateProducts() throws Throwable {
		WebDriverUtility wdUtil = new WebDriverUtility();
		JavaUtility javaUtil = new JavaUtility();
		ExcellUtility excellUtill = new ExcellUtility();
		wdUtil.waitForPageLoad(driver);
		int RanNum = javaUtil.getRandomNum();
		String data = excellUtill.getExcellKeyValue("Product", 0, 0) + RanNum;
		ProductCreationPage product = new ProductCreationPage(driver);	// product creation
		HomePage homepage=new HomePage(driver);
		homepage.clickOnProductLink();
		product.clickOnCreateProductLink();
		product.productName(data);
		product.clickOnSaveProduct();
		SoftAssert soft = new SoftAssert();
		ValidationVarificationPage validate=new ValidationVarificationPage(driver);
		validate.productNameValidation(driver, data);
		soft.assertAll();
		
	}
}
