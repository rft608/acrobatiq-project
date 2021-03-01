package com.acrobatic.pageObjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acrobatic.utilities.Constants;
import com.acrobatic.utilities.ToolBox;

public class CourseListPage {

	WebDriver ldriver;

	public CourseListPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//div[@class='card-title']")
	private List<WebElement> coursesTitleList;

	public void clickCourseByTitle(String titleName) {
		ToolBox.waitUntilElementVisible(Constants.SMALL_WAITING_TIME, coursesTitleList.get(0));
		String courseTitle = null;
		for (int i = 0; i < coursesTitleList.size(); i++) {
			courseTitle = coursesTitleList.get(i).getText();
			if (courseTitle.equals(titleName)) {
				coursesTitleList.get(i).click();
				break;
			}
		}

	}

}
