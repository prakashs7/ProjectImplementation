package testcases;

import org.testng.annotations.Test;

import utils.DP001;
import wrappers.GenericWrappers;

public class TC001 extends GenericWrappers {
	
	@Test(dataProvider="facebookSignup", dataProviderClass=DP001.class)
	public void facebookSignup(String firstName, String lastName, String email, String confirmEmail, String password, String date, String month, String year) {
		
		invokeApp("chrome","https://www.facebook.com");
		clickByLink("English (UK)");
		waitProperty(1000);
		clickByLink("Create New Account");
		waitProperty(2000);
		enterByName("firstname", firstName);
		enterByName("lastname", lastName);
		enterByName("reg_email__", email);
		enterByName("reg_email_confirmation__", confirmEmail);
		enterById("password_step_input", password);
		selectVisibileTextById("day", date);
		selectVisibileTextById("month", month);
		selectVisibileTextById("year", year);
		clickByXpath("//input[@value='2']");
		
	}

}
