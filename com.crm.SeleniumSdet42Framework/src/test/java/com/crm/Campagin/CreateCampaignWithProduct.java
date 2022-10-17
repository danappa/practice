package com.crm.Campagin;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.crm.Generic_Utility.BaseClass;
import com.crm.Generic_Utility.ExcellUtility;
import com.crm.Generic_Utility.JavaUtility;
import com.crm.Generic_Utility.WebDriverUtility;
import com.crm.ObjectRepository.CampaignCreationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.ProductCreationPage;

@Test
public class CreateCampaignWithProduct extends BaseClass {
	   @Test(groups={"smokeTest","regressionTest"})
	   public void CreateCampaignWithProducts() throws Throwable {
		WebDriverUtility wdUtil = new WebDriverUtility();
		JavaUtility javaUtil = new JavaUtility();
		ExcellUtility excellUtill = new ExcellUtility();
		
		wdUtil.waitForPageLoad(driver);
		int RanNum = javaUtil.getRandomNum();
		// create product
		String datap = excellUtill.getExcellKeyValue("Product", 0, 0) + RanNum;
		ProductCreationPage product=new ProductCreationPage(driver);
		HomePage homepage=new HomePage(driver);
		homepage.clickOnProductLink();
		product.clickOnCreateProductLink();
		product.productName(datap);
		product.clickOnSaveProduct();
		// create campaigns
		homepage.clickOnMoreLink(driver);	
		wdUtil.explicitWaitTitleContains(driver, 10, "Administrator - Products");
		homepage.clickOnCampaign();
		CampaignCreationPage campaign=new CampaignCreationPage(driver);
		campaign.clickOnCreateCampaign();
		String data = excellUtill.getExcellKeyValue("Campaign", 0, 0) + RanNum;
		campaign.enterCampaignName(data);
		//campaign.clickOnSaveButton();
		campaign.clickOnAddProductInCampaign();
		String title_contains = "Products&action";
		wdUtil.switchToWindow(driver, title_contains); 
		campaign.searchProduct(datap);
		campaign.clickOnSearchProduct();
		driver.findElement(By.xpath("//a[text()='" + datap + "']")).click();
		String title_contns_parent = "Products&action";
		wdUtil.switchToWindow(driver, title_contns_parent);
		campaign.clickOnSaveCampaign();
		//Verify CampaignName
		String act_cmp_name =campaign.campaignNameText();
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(act_cmp_name, data);
		soft.assertAll();
	}
}
