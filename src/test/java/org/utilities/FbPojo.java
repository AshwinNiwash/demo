package org.utilities;

import org.demo.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FbPojo extends BaseClass {
	
	public FbPojo() {
		PageFactory.initElements(driver, this);
		
	}
@FindBy(name="email")
private WebElement txtuser ;
@FindBy(name="pass")
private WebElement txtpass;
@FindBy(xpath="//button[text()=\"Log In\"]")
private WebElement Login;
public WebElement getTxtuser() {
	return txtuser;
}
public WebElement getTxtpass() {
	return txtpass;
}
public WebElement getLogin() {
	return Login;
}
}
