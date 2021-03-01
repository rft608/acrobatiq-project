package com.acrobatiq.testCases;

import static org.testng.Assert.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.acrobatic.pageObjects.AssignmentListPage;
import com.acrobatic.pageObjects.AssignmentPage;
import com.acrobatic.pageObjects.BaseClass;
import com.acrobatic.pageObjects.ChapterListPage;
import com.acrobatic.pageObjects.CourseListPage;
import com.acrobatic.pageObjects.SignInPage;
import com.acrobatic.pageObjects.UnitListPage;
import com.acrobatic.utilities.Constants;
import com.acrobatic.utilities.ToolBox;

public class TC2_VerifyTargetSection extends BaseClass {

	SignInPage signInPage;
	CourseListPage courseListPage;
	UnitListPage unitListPage;
	ChapterListPage chapterListPage;
	AssignmentListPage assignmentListPage;
	AssignmentPage assignmentPage;

	public static final String HINT_MESSAGE = "This includes our conception of what is unique about us and "
			+ "what makes us both similar to and different from others.";
	public static final String[] DROPDOWN1 = { "preconceptions", "prophecies", "attributions", "perceptions" };
	public static final String CORRECT_MESSAGE = "Correct. Self-concept is based on relatively enduring and personal perceptions.";
	public static final String INCORRECT_MESSAGE = "Incorrect. Self-concept is based on relatively enduring and personal perceptions.";
	public static final String CORRECT_ANSWER = "perceptions";
	public static final String INCORRECT_ANSWER = "prophecies";
	public static final String TARGET_COURSE = "Essential Communication 2e (2020)";
	public static final String TARGET_UNIT = "Communication: What and Why";
	public static final String TARGET_CHAPTER = "The Self, Perception, and Communication";
	public static final String TARGET_ASSIGNMENT = "The Self-Concept Defined";

	@BeforeClass
	public void testClassInitiation() {
		signInPage = new SignInPage(driver);
		courseListPage = new CourseListPage(driver);
		unitListPage = new UnitListPage(driver);
		chapterListPage = new ChapterListPage(driver);
		assignmentListPage = new AssignmentListPage(driver);
		assignmentPage = new AssignmentPage(driver);
	}

	@Test
	public void selfStudySectionValidation(){

		driver.get(Constants.URL);
		signInPage.userLogin(Constants.USERNAME, Constants.PASSWORD);
		courseListPage.clickCourseByTitle(TARGET_COURSE);
		unitListPage.clickUnitByTitle(TARGET_UNIT);		
		chapterListPage.clickChapterByTitle(TARGET_CHAPTER);		
		assignmentListPage.clickAssignmentByTitle(TARGET_ASSIGNMENT);
		assignmentPage.waitLoadingIconInvisible();
		ToolBox.scrollPageByPixel("1800");		
		assignmentPage.switchIframe();

		//verify self study section
		assertTrue(assignmentPage.isSectionTitleDisplay("Self-Study"));
		
		//verify hint icon and hint message
		assertEquals(assignmentPage.getHintMessage(HINT_MESSAGE), HINT_MESSAGE);

		//verify target drop down
		assertEquals(assignmentPage.verifyTargetDropDownList(0, DROPDOWN1), 4);
		
		//verify correct message
		assignmentPage.selectOption(0, CORRECT_ANSWER);
		assertTrue(assignmentPage.isCorrectFeedbackMessageDisplay(0, CORRECT_MESSAGE));
	
		//verify incorrect message
		assignmentPage.selectOption(0, INCORRECT_ANSWER);
		assertTrue(assignmentPage.isIncorrectFeedbackMessageDisplay(0, INCORRECT_MESSAGE));
	
	}

}
