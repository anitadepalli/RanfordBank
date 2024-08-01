package com.ebanking.master;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class BranchCreationpom 
{
	@FindBy(id="txtbName")
	WebElement branchname;

	@FindBy(id="txtAdd1")
	WebElement address;

	@FindBy(id="txtZip")
	WebElement zipcode;

	@FindBy(id="lst_counrtyU")
	WebElement country;

	@FindBy(id="lst_stateI")
	WebElement state;

	@FindBy(id="lst_cityI")
	WebElement city;

	@FindBy(id="btn_insert")
	WebElement submit;

	public void BCreation(String bname,String baddress,String bzipcode,String bcountry,String bstate,String bcity)
	{
		branchname.sendKeys(bname);
		address.sendKeys(baddress);
		zipcode.sendKeys(bzipcode);
		Select Bcountry= new Select(country);
		Bcountry.selectByVisibleText(bcountry);
		Select Bstate= new Select(state);
		Bstate.selectByVisibleText(bstate);
		Select Bcity= new Select(city);
		Bcity.selectByVisibleText(bcity);
		submit.click();
	}
}
