package com.selbot.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.selbot.testng.api.base.Annotations;

public class DuplicateLeadPage extends Annotations {
public DuplicateLeadPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.NAME, using ="submitButton") WebElement duplicateLead;
	@FindBy(how = How.ID, using ="createLeadForm_lastName") WebElement update_LastName;
	
	public DuplicateLeadPage verifyPageTitle() {
		
		 String pageTitle = "Duplicate Lead | opentaps CRM";
		 if(driver.getTitle().equals(pageTitle))
			 System.out.println(driver.getTitle());
		  return this;
	}
	
	public DuplicateLeadPage updateLastName(String lname) {
		clearAndType(update_LastName, lname);
		return this;
	}

	
	public ViewLeadPage createDuplicate()
	{
		click(duplicateLead);
		return new ViewLeadPage();
	}

}
