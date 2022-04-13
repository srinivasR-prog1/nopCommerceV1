package com.nopCommerceV1.testCases;
import java.awt.AWTException;
import java.io.IOException;
import org.testng.annotations.Test;
import com.nopCommerceV1.pageObjects.RegisterPage;

public class TC_RegisterTest_001 extends BaseClass {
	
	
	@Test
	public void RegisterTest() throws AWTException, IOException
	{
		RegisterPage rp= new RegisterPage(driver);
	//	AddtoCartPage acp= new AddtoCartPage(driver);
		rp.clickRegisterLnk();
		rp.clickRdMaleButton();
		rp.UsrFirstName("Subbu");
		rp.usrLastName("Ram");
		selectDropDown("DateOfBirthDay", "10");
		selectDropDown("DateOfBirthMonth", "February");
		selectDropDown("DateOfBirthYear", "2003");
		rp.usrEmail(RandomUtils()+"@gmail.com"); 
		screenShot("registerTest");
		rp.usrPassword("subbu123");
		rp.usrCnfPassword("subbu123");		
		rp.clickBtnRegister();
		if(rp.getRegisterText().equals("Your registration completed"))
		{
			
			System.out.println("Registration is created Successful");
			rp.clickLnkContinue();
			
			
		}
		else
		{
			
			screenShot("registerTest");
			
			System.out.println("Registration is not Successful");
			
		}
		
		
	}

}
