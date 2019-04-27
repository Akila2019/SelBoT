package com.selbot.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.selbot.testng.api.base.Annotations;

public class TC002_EditLead extends Annotations{
	
	@BeforeTest
	public void fetchdata() {
		testcaseName = "TC002_EditLead";
		testcaseDec = "Login, Edit Lead and Verify";
		author = "Akila";
		category = "smoke";
		excelFileName = "TC002";
		
	}

	@Test(dataProvider = "fetchData")
	public void CreateLead(String userName,String password,String ufname,String phonenum) throws InterruptedException {
		
		new com.selbot.pages.LoginPage()
		.enterUserName(userName)
		.enterPassWord(password)
		.clickLogin()
		.clickCRMSFA()
		.clickLeads()
		.navigateToFindLeads()
		.findByPhoneNumber(phonenum)
		.clickFindLeads()
		.selectLead()
		.navigateToEditLead()
		.editLeadFirstName(ufname)
		.clickUpdate()
		.verifyFirstName(ufname);
		
		
	}

}
