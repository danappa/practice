package com.crm.Organisation;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.Generic_Utility.BaseClass;
import com.crm.Generic_Utility.ExcellUtility;
import com.crm.Generic_Utility.JavaUtility;
import com.crm.Generic_Utility.WebDriverUtility;
import com.crm.ObjectRepository.OrganisationCreationPage;
import com.crm.ObjectRepository.ValidationVarificationPage;
import com.crm.ObjectRepository.HomePage;

//@Listeners(com.crm.Generic_Utilities.Listener.class)
@Test
public class CreateOrganisation extends BaseClass {

	@Test(groups = { "regressionTest", "smokeTest" })
	public void CreateOrganisations() throws Throwable {
		WebDriverUtility wdUtil = new WebDriverUtility();
		JavaUtility javaUtil = new JavaUtility();
		ExcellUtility excellUtill = new ExcellUtility();
       
		wdUtil.waitForPageLoad(driver);
		int RanNum = javaUtil.getRandomNum();
		HomePage homepage = new HomePage(driver);
//		Assert.assertEquals(false, true);
		homepage.clickOrganisationLink();
		OrganisationCreationPage op = new OrganisationCreationPage(driver);
		op.clickOnCreateOrganisation();
		OrganisationCreationPage cop = new OrganisationCreationPage(driver);
		cop.enterOrganisationName(RanNum);
		cop.clickOnSaveButton();
		String data = excellUtill.getExcellKeyValue("Sheet1", 0, 0) + RanNum;
		SoftAssert soft = new SoftAssert();
//		soft.assertEquals(orgNameText, data);
//		Assert.assertEquals(orgNameText, data);
		ValidationVarificationPage validate = new ValidationVarificationPage(driver);
		validate.organisationValidation(driver, data);
		soft.assertAll();
	}

	

}