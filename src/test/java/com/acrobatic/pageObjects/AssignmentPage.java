package com.acrobatic.pageObjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.acrobatic.utilities.Constants;
import com.acrobatic.utilities.ToolBox;


public class AssignmentPage {
	WebDriver ldriver;

	public AssignmentPage(WebDriver rDriver) {
		ldriver = rDriver;
		PageFactory.initElements(rDriver, this);
	}

	@FindBy(css = ".workbook-page-iframe")
	private WebElement iframe;

	@FindBy(css = "button.hint.btn.inline-hint-btn")
	private List<WebElement> hintIcon;

	@FindBy(css = "li.breadcrumb-item:nth-child(3)")
	private WebElement pageLocationBarTitle;

	@FindBy(css = "div.caption")
	private List<WebElement> targetSection;

	@FindBy(css = ".hint-body")
	private List<WebElement> hintMessage;

	@FindBy(css = "div.alert.alert-warning.hint > button")
	private List<WebElement> closeIcon;

	@FindBy(css = ".select2-hidden-accessible")
	private List<WebElement> dropDown;

	@FindBy(css = ".select2-selection__arrow")
	private List<WebElement> dropDownArrow;
	
	@FindBy(css = "div > div.feedback.note.note-success")
	private List<WebElement> correctFeedbackMessage;

	@FindBy(css = "div > div.feedback.note.note-danger")
	private List<WebElement> incorrectFeedbackMessage;
	
	@FindBy(css = "svg.vst-spinner__svg")
	private WebElement loadingIcon ;
	
	public void switchIframe() {
		ToolBox.waitUntilElementVisible(Constants.MEDIUM_WAITING_TIME, iframe);
		ToolBox.switchIframe(iframe);
	}

	public boolean isBarTitleDisplay(String title) {
		ToolBox.waitUntilElementVisible(Constants.SMALL_WAITING_TIME, pageLocationBarTitle);
		String barTitle = pageLocationBarTitle.getText();
		if (barTitle.equals(title)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isSectionTitleDisplay(String sectionTitle) {
		ToolBox.waitUntilElementVisible(Constants.SMALL_WAITING_TIME,targetSection.get(0));
		for (WebElement section : targetSection) {
			String titleName = section.getText();
			if (titleName.equals(sectionTitle)) {
				return true;
			}
		}
		return false;
	}

	public void clickHintIcon(int index) {
		ToolBox.waitUntilElementVisible(Constants.SMALL_WAITING_TIME,hintIcon.get(0));
		hintIcon.get(index).click();
	}

	public void clickCloseHintIcon(int index) {
		ToolBox.waitUntilElementVisible(Constants.SMALL_WAITING_TIME,closeIcon.get(0));
		closeIcon.get(index).click();
	}

	public String getHintMessage(String targetMessage){
		ToolBox.waitUntilElementVisible(Constants.SMALL_WAITING_TIME,hintIcon.get(0));
		for (int i = 0; i < hintIcon.size(); i++) {
			clickHintIcon(i);
			String messageContent = hintMessage.get(i).getText();
			if (messageContent.equals(targetMessage)) {
				clickCloseHintIcon(i);
				return messageContent;
			}
		}
		return null;
	}

	public int verifyTargetDropDownList(int index, String[] dropDownOption) {
		ToolBox.waitUntilElementVisible(Constants.SMALL_WAITING_TIME,dropDown.get(0));
		int count = 0;
		Select select = new Select(dropDown.get(index));
		List<WebElement> options = select.getOptions();
		for (int i = 1; i < options.size(); i++) {
			System.out.println(options.get(i).getText());
			for (int j = 0; j < dropDownOption.length; j++) {
				if (options.get(i).getText().equals(dropDownOption[j])) {
					count++;
				}
			}
		}

		if (count == dropDownOption.length) {
			return count;
		}
		return 0;
	}

	public void selectOption(int index, String optionText) {
		ToolBox.waitUntilElementVisible(Constants.SMALL_WAITING_TIME,dropDown.get(0));
		Select select = new Select(dropDown.get(index));
		dropDownArrow.get(index).click();
		select.selectByVisibleText(optionText);
		dropDownArrow.get(index).click();
	}

	public boolean isCorrectFeedbackMessageDisplay(int index, String message) {
		ToolBox.waitUntilElementVisible(Constants.SMALL_WAITING_TIME,correctFeedbackMessage.get(0));
        if (correctFeedbackMessage.get(index).getText().equals(message)) {
			return true;
		}
		return false;
	}
	
	public boolean isIncorrectFeedbackMessageDisplay(int index, String message) {
		ToolBox.waitUntilElementVisible(Constants.SMALL_WAITING_TIME,incorrectFeedbackMessage.get(0));
        if (incorrectFeedbackMessage.get(index).getText().equals(message)) {
			return true;
		}
		return false;
	}
	
	public void waitLoadingIconInvisible(){
		ToolBox.waitUntilElementInvisible(Constants.MEDIUM_WAITING_TIME,loadingIcon);
	}
	

}
