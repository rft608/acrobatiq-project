package com.acrobatic.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acrobatic.utilities.Constants;
import com.acrobatic.utilities.ToolBox;

public class UnitListPage {

	WebDriver ldriver;

	public UnitListPage(WebDriver rDriver) {
		ldriver = rDriver;
		PageFactory.initElements(rDriver, this);
	}

	@FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div/div/ul/li/div/a")
	private List<WebElement> unitTitleList;

	public void clickUnitByTitle(String titleName) {
		ToolBox.waitUntilElementVisible(Constants.SMALL_WAITING_TIME, unitTitleList.get(0));
		String unitTitle = null;
		for (int i = 0; i < unitTitleList.size(); i++) {
			unitTitle = unitTitleList.get(i).getText();
			if (unitTitle.contains(titleName)) {
				unitTitleList.get(i).click();
				break;
			}
		}

	}

}
