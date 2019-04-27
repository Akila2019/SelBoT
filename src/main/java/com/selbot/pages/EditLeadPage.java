package com.selbot.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.selbot.testng.api.base.Annotations;

public class EditLeadPage extends Annotations {
	
	public EditLeadPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.ID,using = "updateLeadForm_firstName") WebElement edit_FirstName;
	@FindBy(how = How.CLASS_NAME, using = "smallSubmit") WebElement button_Submit;
	
	public EditLeadPage editLeadFirstName(String ufname)
	{
		
		clearAndType(edit_FirstName, ufname);
		return this;
		
	}

	public ViewLeadPage clickUpdate() {
		click(button_Submit);
		return new ViewLeadPage();
	}
}
