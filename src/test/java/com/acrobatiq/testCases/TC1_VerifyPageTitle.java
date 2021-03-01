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

public class TC1_VerifyPageTitle extends BaseClass {

	SignInPage signInPage;
	CourseListPage courseListPage;
	UnitListPage unitListPage;
	ChapterListPage chapterListPage;
	AssignmentListPage assignmentListPage;
	AssignmentPage assignmentPage;
	
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
	public void pageTitleValidation(){

		driver.get(Constants.URL);
		signInPage.userLogin(Constants.USERNAME, Constants.PASSWORD);		
		courseListPage.clickCourseByTitle(TARGET_COURSE);
		unitListPage.clickUnitByTitle(TARGET_UNIT);
		chapterListPage.clickChapterByTitle(TARGET_CHAPTER);
		assignmentListPage.clickAssignmentByTitle(TARGET_ASSIGNMENT);
		
		//verify target bar title
		assertTrue(assignmentPage.isBarTitleDisplay("The Self-Concept Defined"));
	}

}
