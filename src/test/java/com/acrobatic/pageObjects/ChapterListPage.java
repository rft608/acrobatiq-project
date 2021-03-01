package com.acrobatic.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acrobatic.utilities.Constants;
import com.acrobatic.utilities.ToolBox;

public class ChapterListPage {
	WebDriver ldriver;
	
	public ChapterListPage(WebDriver rDriver) {
		ldriver = rDriver;
		PageFactory.initElements(rDriver, this);
	}

	@FindBy(xpath = "//*[starts-with(@id,'collapse-unit')]/ul/li/div[1]/a")
	private List<WebElement> chapterTitleList;

	public void clickChapterByTitle(String titleName) {
		ToolBox.waitUntilElementVisible(Constants.SMALL_WAITING_TIME, chapterTitleList.get(0));
		String chapterTitle = null;
		for (int i = 0; i < chapterTitleList.size(); i++) {

			chapterTitle = chapterTitleList.get(i).getText();

			if (chapterTitle.contains(titleName)) {
				chapterTitleList.get(i).click();
				break;
			}
		}

	}
}
