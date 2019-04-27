package com.selbot.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.selbot.testng.api.base.Annotations;

public class FindLeadsPage extends Annotations {
	
public static String Leadid;
	
public FindLeadsPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using ="//span[text()='Phone']") WebElement tab_PhoneNumber;
	@FindBy(how = How.NAME, using ="id") WebElement field_Leadid;
	@FindBy(how = How.XPATH, using ="//input[@name='phoneNumber']") WebElement field_PhoneNumber;
	@FindBy(how = How.NAME, using ="lastName") WebElement field_LastName;
	@FindBy(how = How.XPATH, using = "//button[text()='Find Leads']" ) WebElement button_FindLeads;
	@FindBy(how = How.XPATH, using = "//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a" ) WebElement selectLead;
	@FindBy(how = How.XPATH, using = "//div[text () = 'No records to display']") WebElement gridMessage;
	
		
public FindLeadsPage findByPhoneNumber(String phonenum) {
	click(tab_PhoneNumber);
	clearAndType(field_PhoneNumber,phonenum);
	return this;
}

public FindLeadsPage findByLeadID(String text) {
	clearAndType(field_Leadid, text);
	return this;
}

public FindLeadsPage findByLastName(String text) {
	clearAndType(field_LastName, text);
	return this;
}


public FindLeadsPage clickFindLeads() throws InterruptedException {
	
	click(button_FindLeads);
	Thread.sleep(2000);
	return this;
}

public FindLeadsPage afterMergeFindLead() {
	
	String gridtext = gridMessage.getText();
	 if (gridtext.equalsIgnoreCase("No records to display"))
			 System.out.println("After merge:" + gridtext);
	 else
		 System.out.println("Lead Id exists");
	 return this;
}

public ViewLeadPage selectLead() {
	
	click(selectLead);
	return new ViewLeadPage();
}

public FindLeadsPage getLeadId() {
	Leadid = selectLead.getText();
	return this;
	
}

}
