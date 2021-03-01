package com.acrobatic.pageObjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acrobatic.utilities.Constants;
import com.acrobatic.utilities.ToolBox;

public class AssignmentListPage {

	WebDriver ldriver;

	public AssignmentListPage(WebDriver rDriver) {
		ldriver = rDriver;
		PageFactory.initElements(rDriver, this);
	}

	@FindBy(xpath = "//*[starts-with(@id,'collapse-module')]/ul/li/a")
	private List<WebElement> assignmintTitleList;

	public void clickAssignmentByTitle(String titleName) {
		String assignmintTitle = null;
		ToolBox.waitUntilElementVisible(Constants.SMALL_WAITING_TIME, assignmintTitleList.get(0));
		ToolBox.scrollPageByPixel("250");
		for (int i = 0; i < assignmintTitleList.size(); i++) {
			assignmintTitle = assignmintTitleList.get(i).getText();
			if (assignmintTitle.contains(titleName)) {
				assignmintTitleList.get(i).click();
				break;
			}
		}

	}

}
