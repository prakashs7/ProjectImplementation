package testcases;

import org.testng.annotations.Test;
import utils.DP006;
import wrappers.GenericWrappers;

public class TC006 extends GenericWrappers {
	
	@Test(dataProvider="ftrService", dataProviderClass=DP006.class)
	public void ftrService ( String userID,String password,String confirmPassword,String securityQuestion,String answer,String year,String month,String date,String email,String occupation,String firstName,String lastName,String nationality,String houseNo,String street, String area,String country,String mobile,String pincode,String offName,String offStreet,String offArea,String offCountry,String offMobile,String offpincode,String offCity,String offState,String offPost) {
	
	int secque = Integer.parseInt(securityQuestion);
	int nty = Integer.parseInt(nationality);
	int cty = Integer.parseInt(country);
	int offC = Integer.parseInt(offCity);
	int offS = Integer.parseInt(offState);
	int offP = Integer.parseInt(offPost);
	
	invokeApp("chrome", "https://www.irctc.co.in/nget/train-search");
	waitProperty(1000);
	clickByXpath("html/body/app-root/app-home/div[1]/app-header/p-dialog[2]/div/div/div[2]/div/form/div[2]/button");
	clickByLink("HOLIDAYS");
	clickByXpath("/html/body/app-root/app-home/div[1]/app-header/div[2]/div[2]/div[2]/nav/ul/li[7]/ul/li[3]/a/span[1]");
	clickByXpath("/html/body/app-root/app-home/div[1]/app-header/div[2]/div[2]/div[2]/nav/ul/li[7]/ul/li[3]/ul/li[2]/a/span");
	switchToLastWindow();
	waitProperty(1000);
	clickByXpath("/html/body/app-root/homeheader/header/nav/div/div[2]/div/ul/li[3]");
	waitProperty(1000);
	clickByLink("Book Your Coach/Train");
	switchToLastWindow();
	waitProperty(1000);
	clickByLink("New User? Signup");
	enterById("userId", userID);
	enterById("password", password);
	enterById("cnfPassword", confirmPassword);
	selectIndexById("secQstn", secque);
	enterById("secAnswer", answer);
	clickById("dateOfBirth");
	selectVisibileTextByXpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[2]", year);
	selectVisibileTextByXpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[1]", month);
	clickByLink(date);
	clickById("gender0");
	clickById("maritalStatus1");
	enterById("email", email);
	selectVisibileTextById("occupation", occupation);
	enterById("fname", firstName);
	enterById("lname", lastName);
	selectIndexById("natinality", nty);
	enterById("flatNo", houseNo);
	enterById("street", street);
	enterById("area", area);
	selectIndexById("country", cty);
	enterById("mobile", mobile);
	enterById("pincode", pincode);
	clickById("sameAddresses1");
	enterById("flatNoOffice", offName);
	enterById("streetOffice", offStreet);
	enterById("areaOffice", offArea);
	selectIndexById("countryOffice", cty);
	enterById("mobileOffice", offMobile);
	enterById("pincodeOffice", offpincode);
	pageDown();
	selectIndexById("cityOffice", offC);
	selectIndexById("stateOffice", offS);
	selectIndexById("postOfficeOffice", offP);
	
	
}
}
