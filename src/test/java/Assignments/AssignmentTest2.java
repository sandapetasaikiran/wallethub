package Assignments;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import utility.Base;
import utility.ElementControl;

public class AssignmentTest2 extends Base{

	ElementControl ec = new ElementControl();
	
	Actions action = new Actions(driver);
	
	@Test
	public void assignement2() throws Throwable
	{
		//go to http://wallethub.com/profile/test_insurance_company/
		driver.get(ec.getObjects("URL"));
		System.out.println("\n" + "Opened Application");
		
		//Click on Account login
		driver.findElement(By.xpath(ec.getObjects("Login"))).click();
		System.out.println("\n" + "Clicked on Profile Login");
		
		//Enter email
		driver.findElement(By.xpath(ec.getObjects("email_input"))).sendKeys(ec.getObjects("Wallethub_login_ID"));
		System.out.println("\n" + "Entered Login Email");
		
		//enter password
		driver.findElement(By.xpath(ec.getObjects("password_input"))).sendKeys(ec.getObjects("password"));
		System.out.println("\n" + "Entered Password");
		
		//click Login button
		driver.findElement(By.xpath(ec.getObjects("login_button"))).click();
		System.out.println("\n" + "Clicked Login button");
		
		//Click on review section
		driver.findElement(By.xpath(ec.getObjects("reviewSection")));
		System.out.println("\n" + "Clicked Review section");
		
		// mouse over on 4star
		action.moveToElement(driver.findElement(By.xpath(ec.getObjects("4Star")))).build().perform();
		Thread.sleep(2000);
		System.out.println("\n" + "Mouse hovered on Fourth Star");
		
		//click 4 star
		driver.findElement(By.xpath(ec.getObjects("4Star"))).click();
		System.out.println("\n" + "Clicked on 4th Star");
		
		//click on Policy dropdown
		driver.findElement(By.xpath(ec.getObjects("policydropdwn"))).click();
		System.out.println("\n" + "Clicked on Policy dropdown");
		
		//Select health insurance from dropdown
		driver.findElement(By.xpath(ec.getObjects("healthInsurance_option"))).click();
		System.out.println("\n" + "Selected health Insurance");
		
		//Click on  “Write a review” and write some random text
		driver.findElement(By.xpath(ec.getObjects("reviewTextArea_input"))).click();
		System.out.println("\n" + "Clicked on input text field");
		
		String input = RandomStringUtils.random(200);
		driver.findElement(By.xpath(ec.getObjects("reviewTextArea_input"))).sendKeys(input);
		System.out.println("\n" + "Entered the review");
		
		//press submit
		driver.findElement(By.xpath(ec.getObjects("reviewSubmit_button"))).click();
		System.out.println("\n" + "Clicked on Submit button");
		
		//verify your review
		assertTrue(driver.findElement(By.xpath(ec.getObjects("Myreview"))).isDisplayed());
		System.out.println("\n" + "Verified that review updated successfully");
		
		//mouse over to account
		action.moveToElement(driver.findElement(By.xpath(ec.getObjects("Account_btn")))).build().perform();
		Thread.sleep(2000);
		System.out.println("\n" + "Mouse hovered on Account");
		
		// click on profile
		driver.findElement(By.xpath(ec.getObjects("AccountProfile"))).click();
		System.out.println("\n" + "Clicked on Profile");
		
		//Verify text "I RECOMMEND"
		assertEquals(driver.findElement(By.xpath(ec.getObjects("Irecommend_label"))), "I RECOMMEND");
		System.out.println("\n" + "Verified the Review in My profile");
		
		//go to https://wallethub.com/profile/
		driver.get(ec.getObjects("URL_profile"));
		Thread.sleep(2000);
		System.out.println("\n" + "Opened https://wallethub.com/profile/");
		
		//assert your review
		assertTrue(driver.findElement(By.xpath(ec.getObjects("myRating"))).isDisplayed());
		System.out.println("\n" + "Verified My rating is updated in Profile");
	}
}
