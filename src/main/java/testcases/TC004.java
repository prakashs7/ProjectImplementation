package testcases;

import org.testng.annotations.Test;

import utils.DP004;
import wrappers.GenericWrappers;

public class TC004 extends GenericWrappers{
	@Test(dataProvider="phpTravelsRegister", dataProviderClass=DP004.class)
	public void phpTravelsRegister(String firstName,String lastName,String email,String mobileNumber,String companyName,String street,String area,String city,String state,String pincode,String country,String source,String mobileNumber1,String password,String confirmpassword) {
		
	invokeApp("chrome", "https://www.phptravels.org/register.php");	
	enterById("inputFirstName", firstName);
	enterById("inputLastName", lastName);
	enterById("inputEmail", email);
	clickByXpath("//*[@id=\"containerNewUserSignup\"]/div[2]/div[4]/div/div/div/div/div[2]");
	waitProperty(500);
	clickByXpath("//*[@id=\"containerNewUserSignup\"]/div[2]/div[4]/div/div/div/ul/li[102]/span[1]");
	enterById("inputPhone", mobileNumber);
	enterById("inputCompanyName", companyName);
	enterById("inputAddress1", street);
	enterById("inputAddress2", area);
	enterById("inputCity", city);
	enterById("stateinput", state);
	enterById("inputPostcode", pincode);
	selectVisibileTextById("inputCountry",country);
	selectVisibileTextById("customfield1", source);
	enterById("customfield2", mobileNumber1);
	pageDown();
	enterById("inputNewPassword1", password);
	enterById("inputNewPassword2", confirmpassword);
	clickByXpath("//*[@id=\"containerPassword\"]/div[4]/div/button");
	waitProperty(500);
	getTextById("inputGeneratePasswordOutput");
	clickById("btnGeneratePasswordInsert");
	waitProperty(500);
	clickByXpath("//*[@id=\"frmCheckout\"]/div[3]/div/div/span[3]");
	}

}
