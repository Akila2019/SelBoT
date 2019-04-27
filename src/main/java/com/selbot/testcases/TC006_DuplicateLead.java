package com.selbot.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.selbot.pages.LoginPage;
import com.selbot.pages.ViewLeadPage;
import com.selbot.testng.api.base.Annotations;

public class TC006_DuplicateLead extends Annotations{

	@BeforeTest
	public void fetchdata() {
		testcaseName = "TC006_DuplicateLead";
		testcaseDec = "Login, Duplicate Lead and Verify";
		author = "Akila";
		category = "smoke";
		excelFileName = "TC006";
		
	}
	
	@Test(dataProvider = "fetchData")
	public void DuplicateLead(String userName,String password,String phonenum, String lname) throws InterruptedException {
		
		new LoginPage()
		.enterUserName(userName)
		.enterPassWord(password)
		.clickLogin()
		.clickCRMSFA()
		.clickLeads()
		.navigateToFindLeads()
		.findByPhoneNumber(phonenum)
		.clickFindLeads()
		.getLeadId()
		.selectLead()
		.navigateToDuplicateLead()
		.verifyPageTitle()
		.updateLastName(lname)
		.createDuplicate()
		.verifyLeadid()
		.navigateToFindLeads()
		.findByLeadID(ViewLeadPage.duplicateid)
		.clickFindLeads()
		.selectLead()
		.verifyLastName(lname);
			
	}

}
