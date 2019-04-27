package com.selbot.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.selbot.pages.LoginPage;
import com.selbot.pages.MergeLeadPage;
import com.selbot.testng.api.base.Annotations;


public class TC003_MergeLead extends Annotations {
	
	@BeforeTest
	public void setData() {
		testcaseName = "TC003_MergeLead";
		testcaseDec = "Login, Merge Lead and Verify";
		author = "Akila";
		category = "Smoke";
		excelFileName = "TC003";
	}
	
	@Test(dataProvider = "fetchData")
	public void MergeLead(String userName,String password,String fname) throws InterruptedException {
		
		new LoginPage()
		.enterUserName(userName)
		.enterPassWord(password)
		.clickLogin()
		.clickCRMSFA()
		.clickLeads()
		.navigateToMergeLead()
		.selectFromId(fname)
		.selectToId(fname)
		.clickMergeLead()
		.navigateToFindLeads()
		.findByLeadID(MergeLeadPage.textid)
		.clickFindLeads()
		.afterMergeFindLead();
		
	}


}
