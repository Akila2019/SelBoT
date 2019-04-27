package com.selbot.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.selbot.testng.api.base.Annotations;

public class IndeedJob extends Annotations {
	@BeforeTest
	public void fetchdata() {
		testcaseName = "Indeed Job";
		testcaseDec = "Open links in new tab and Verify";
		author = "Akila";
		category = "smoke";
		excelFileName = "Job";
		
	}
	
	@Test(dataProvider = "fetchData")
	public void OpenLinks(String url,String xpathvalue) throws InterruptedException {
		
		startApp(url);
		switchToNewTab(xpathvalue);
			
	}

}



