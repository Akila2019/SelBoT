package com.selbot.pages;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.selbot.testng.api.base.Annotations;

public class MergeLeadPage extends Annotations{
	
	Set<String> allWindow;
	List<String> listOfWindows;
	public static String textid;
	
	public MergeLeadPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH,using = "(//img[@alt='Lookup'])[1]") WebElement fromLookup;
	@FindBy(how = How.XPATH, using = "(//img[@alt='Lookup'])[2]") WebElement toLookup;
	@FindBy(how = How.NAME, using = "firstName") WebElement firstname;
	@FindBy(how = How.XPATH , using = "//button[contains(text(),'Find Leads')]") WebElement button_FindLeads;
	@FindBy(how = How.XPATH, using = "(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a") WebElement gridElementFrom;
	@FindBy(how = How.XPATH, using = "(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[2]/a") WebElement gridElementTo;
	@FindBy(how = How.LINK_TEXT, using = "Merge") WebElement buttonMerge;
	
	
	
	public MergeLeadPage selectFromId(String fname) throws InterruptedException {
		
		click(fromLookup);
		switchToWindow(1);
		clearAndType(firstname,fname);
		click(button_FindLeads);
		Thread.sleep(2000);
		textid = gridElementFrom.getText();
		click(gridElementFrom);
		switchToWindow(0);
		return this;
	}

	public MergeLeadPage selectToId(String fname) throws InterruptedException {
		click(toLookup);
		switchToWindow(1);
		clearAndType(firstname,fname);
		click(button_FindLeads);
		Thread.sleep(2000);
		click(gridElementTo);
		switchToWindow(0);
		return this;
		
	}
	
	public MyLeadPage clickMergeLead() throws InterruptedException {
		click(buttonMerge);
		Thread.sleep(2000);
		acceptAlert();
		return new MyLeadPage();
	}
	
	
}
