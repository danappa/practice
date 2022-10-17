package com.crm.Product;

import org.testng.annotations.Test;
import com.crm.Generic_Utility.BaseClass;
import com.crm.Generic_Utility.ExcellUtility;
import com.crm.Generic_Utility.JavaUtility;
import com.crm.Generic_Utility.WebDriverUtility;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.ProductCreationPage;
@Test
public class CreateProductAndDeleteProduct extends BaseClass {

	@Test(groups = {"smokeTest","regressionTest"})
	public void CreateProducts() throws Throwable {
		WebDriverUtility wdUtil = new WebDriverUtility();
		JavaUtility javaUtil = new JavaUtility();
		ExcellUtility excellUtill = new ExcellUtility();

		wdUtil.waitForPageLoad(driver);
		// create product
		ProductCreationPage product = new ProductCreationPage(driver);
		HomePage homepage=new HomePage(driver);
		homepage.clickOnProductLink();		
		product.clickOnCreateProductLink();
		int RanNum = javaUtil.getRandomNum();
		String data = excellUtill.getExcellKeyValue("Product", 0, 0) + RanNum;
		product.productName(data);
		product.clickOnSaveProduct();
		// delete product
		product.clickOnProductSaveButton();
		wdUtil.switchToAlertAndAccept(driver);
	}
}
