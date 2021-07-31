package Assignments;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import utility.Base;
import utility.ElementControl;

public class AssignmentTest1 extends Base{
	
	ElementControl ec = new ElementControl();
	
	@Test
	public void assignement1() throws Throwable
	{
		String Post = "Hello World";
		
		driver.get(ec.getObjects("URL"));
		System.out.println("\n" + "Launched Facebook.com" + "\n");
		
		driver.findElement(By.xpath(ec.getObjects("login_ID_input"))).sendKeys(ec.getObjects("login_ID"));
		System.out.println("\n" + "Launched Facebook.com" + "\n");
		
		driver.findElement(By.xpath(ec.getObjects("login_Password_input"))).sendKeys(ec.getObjects("password"));
		System.out.println("\n" + "Entered Login ID" + "\n");
		
		driver.findElement(By.xpath(ec.getObjects("login_button"))).click();
		System.out.println("\n" + "Entered password" + "\n");
		
		driver.findElement(By.xpath(ec.getObjects("db_home"))).click();
		System.out.println("\n" + "Clicked on Login Button" + "\n");
		
		driver.findElement(By.xpath(ec.getObjects("woym_Home_input"))).click();
		System.out.println("\n" + "Clicked on 'What's on your mind" + "\n");
		
		driver.findElement(By.xpath(ec.getObjects("woym_post_input"))).sendKeys(Post);
		System.out.println("\n" + "Typed '" + Post + "'"  + "\n");
		
		driver.findElement(By.xpath(ec.getObjects("woym_post_button"))).click();
		System.out.println("\n" + "Clicked on Post button" + "\n");
		Thread.sleep(3000);
		
		assertTrue(driver.findElement(By.xpath(ec.getObjects("latestPost_Var1") + Post + ec.getObjects("latestPost_Var2"))).getText().equals(Post));
		
		System.out.println("\n" + "Posted " + Post + " on Facebook" + "\n");
		
		//Deleting the post as Facebook is not allowing to post the same message multiple times
		deletePost();
		
		driver.findElement(By.xpath(ec.getObjects("fb_account_btn"))).click();
		System.out.println("\n" + "Clicked on Profile" + "\n");
		
		driver.findElement(By.xpath(ec.getObjects("fb_Logout"))).click();
		System.out.println("\n" + "Clicked on Logout" + "\n");
	}
	
	public void deletePost()
	{
		driver.findElement(By.xpath(ec.getObjects("LatestPost_ellipis"))).click();
		driver.findElement(By.xpath(ec.getObjects("delete_Post"))).click();
		driver.findElement(By.xpath(ec.getObjects("delete_post_confirm_btn"))).click();
		
		System.out.println("\n" + "Deleted the Post" + "\n");
	}
	
}
