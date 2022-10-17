package com.crm.Campagin;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.ObjectRepository.CampaignCreationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.Generic_Utility.*;
import com.crm.ObjectRepository.ValidationVarificationPage;
@Test
public class CreateCampaign extends BaseClass {
	  
	   @Test(groups="regressionTest")
	   public void CreateCampaigns() throws Throwable {
		WebDriverUtility wdUtil = new WebDriverUtility();
		JavaUtility javaUtil=new JavaUtility();
		ExcellUtility excellUtill = new ExcellUtility();
		wdUtil.waitForPageLoad(driver);
		// campaign
		HomePage homepage=new HomePage(driver);
		homepage.clickOnMoreLink(driver);
		homepage.clickOnCampaign();
		CampaignCreationPage campaign=new CampaignCreationPage(driver);
		campaign.clickOnCreateCampaign();
		int RanNum = javaUtil.getRandomNum();
		String data = excellUtill.getExcellKeyValue("Campaign", 0, 0)+ RanNum;
		campaign.enterCampaignName(data);
		campaign.clickOnSaveButton();
		SoftAssert soft=new SoftAssert();
		ValidationVarificationPage validate=new ValidationVarificationPage(driver);
		validate.campaignNameValidation(driver, data);
		soft.assertAll();
	}
}
