package com.selbot.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.selbot.testng.api.base.Annotations;

public class ViewLeadPage extends Annotations{
	public static String duplicateid;
	public ViewLeadPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.ID, using="viewLead_companyName_sp")  WebElement eleCompanyName;
	@FindBy(how = How.ID, using ="viewLead_companyName_sp") WebElement label_CompanyName;
	@FindBy(how = How.ID, using ="viewLead_firstName_sp") WebElement label_FirstName;
	@FindBy(how = How.ID, using ="viewLead_lastName_sp") WebElement label_LastName;
	@FindBy(how = How.LINK_TEXT, using ="Edit") WebElement link_Edit;
	@FindBy(how = How.LINK_TEXT, using ="Duplicate Lead") WebElement link_Duplicate;
	@FindBy(how = How.LINK_TEXT, using ="Delete") WebElement link_Delete;

	public ViewLeadPage verifyCompanyName(String data) {
		String companyName = getElementText(eleCompanyName);
		if (companyName.contains(data)) {
			System.out.println("The Company Name is Matching Successfully ");
		} else {
			System.out.println("The Company Name is not Matching ");
		}
		return this;
	}
	
	public ViewLeadPage verifyLead(String cname,String fname,String lname) {
		
		 String btitle = driver.getTitle();
		 String leadvalue = label_CompanyName.getText();
		 String[] split = leadvalue.split("\\(");
		 int length = split[1].length();
		 String leadid = split[1].substring(0, length-1);
		 System.out.println(btitle);
		 if(cname.equals(split[0].trim()) &&  fname.equals(label_FirstName.getText()) && lname.equals(label_LastName.getText()))
		 {
		 System.out.println("Company Name: " + split[0]);
		 System.out.println("First Name: " + label_FirstName.getText() );
		 System.out.println("Last Name: " + label_LastName.getText());
		 System.out.println("Lead id: " + leadid);
		 System.out.println("New Lead created Successfully");
		 }
		 else
			System.out.println("New Lead is not created");
		 
		return this; 
	}
	
	public ViewLeadPage verifyFirstName(String fname) {
		String text = label_FirstName.getText();
		if (text.contains(fname)) {
			System.out.println("Text matched: " + text);
		} else {
			System.out.println("Text not matched: " + text);
		}
		return this;
	}
	
	public ViewLeadPage verifyLastName(String lname) {
		String text = label_LastName.getText();
		if (text.contains(lname)) {
			System.out.println("Text matched: " + text);
		} else {
			System.out.println("Text not matched: " + text);
		}
		return this;
	}
	
	public MyLeadPage verifyLeadid() {
		String leadvalue = label_CompanyName.getText();
		 String[] split = leadvalue.split("\\(");
		 int length = split[1].length();
		 duplicateid = split[1].substring(0, length-1);
		 System.out.println("Duplicate Lead id:" + duplicateid);
		 return new MyLeadPage();
		 
	}
	
	public EditLeadPage navigateToEditLead() {
		link_Edit.click();
		return new EditLeadPage();
		
	}
	
	public MyLeadPage deleteLead() {
		link_Delete.click();
		return new MyLeadPage();
	}
	
	public DuplicateLeadPage navigateToDuplicateLead() {
		link_Duplicate.click();
		return new DuplicateLeadPage();
		
	}
}
