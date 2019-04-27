package com.selbot.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.selbot.selenium.api.base.SeleniumBase;
import com.selbot.testng.api.base.Annotations;

public class Erail extends Annotations{
	
	
	@BeforeTest
	public void fetchdata() {
		testcaseName = "erail";
		testcaseDec = "Verify Seat Availability";
		author = "Akila";
		category = "smoke";
		excelFileName = "ERAIL";
		
	}
	
	@Test(dataProvider = "fetchData")
	public void OpenLinks(String url,String From,String To, String trainName) throws InterruptedException {
		
		startApp(url);
		sendkeys(locateElement("ID","txtStationFrom"), From);
		sendkeys(locateElement("ID","txtStationTo"), To);
		if(locateElement("ID","chkSelectDateOnly").isSelected())
			click(locateElement("ID","chkSelectDateOnly"));
		Thread.sleep(2000);
		getSeatsAvailable(trainName);
		
			
	}

}
