package com.acrobatic.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acrobatic.utilities.Constants;
import com.acrobatic.utilities.ToolBox;

public class SignInPage {

	WebDriver ldriver;
    
	public SignInPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "username")
	private WebElement txtUserName;

	@FindBy(id = "password")
	private WebElement txtPassword;

	@FindBy(xpath = "//div[contains(text(),'Sign In')]")
	private WebElement btnSignIn;

	public void setUserName(String UserName) {
		ToolBox.waitUntilElementVisible(Constants.SMALL_WAITING_TIME, txtUserName);
		txtUserName.clear();
		txtUserName.sendKeys(UserName);
	}

	public void setPassword(String pwd) {
		ToolBox.waitUntilElementVisible(Constants.SMALL_WAITING_TIME, txtPassword);
		txtPassword.clear();
		txtPassword.sendKeys(pwd);
	}

	public void clickSubmit() {
		ToolBox.waitUntilElementVisible(Constants.SMALL_WAITING_TIME, btnSignIn);
		btnSignIn.click();
	}

	public void userLogin(String userName, String password) {
		setUserName(userName);
		setPassword(password);
		clickSubmit();
	}
}
