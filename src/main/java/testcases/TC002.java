package testcases;


import org.testng.annotations.Test;

import utils.DP002;
import wrappers.GenericWrappers;

public class TC002 extends GenericWrappers{
	@Test(dataProvider="onlineVisaApplication", dataProviderClass=DP002.class)
	public void onlineVisaApplication (String firstName,String lastName,String fullName,String email,String confirmEmail,String addEmail,String year,String month,String birthCity,String birthState,String birthCountry,String nationality,String street,String city,String state,String pincode, String phoneNumber,String otherNumber,String territory,String languagesKnown,String maritialStatus,String purpose, String interviewLanguage) {
		
		invokeApp("chrome", "https://www.onlineusvisa.com/basic-details/in?origin=home&country=in&type=N#");
		waitProperty(2000);
		enterById("app-given-names", firstName);
		enterById("app-surname", lastName);
		enterById("app-native-name", fullName);
		clickById("other-names-used-No");
		enterById("email", email);
		enterById("email-1", confirmEmail);
		pageDown();
		waitProperty(1000);
		clickById("additional-email-Yes");
		enterById("additional-email-detail", addEmail);
		clickById("gender-Male");
		clickById("date-of-birth");
		waitProperty(500);
		selectVisibileTextByClassName1("picker__select--year", year);
		waitProperty(500);
		selectVisibileTextByClassName1("picker__select--month", month);
		waitProperty(500);
		clickByXpath("//*[@id=\"date-of-birth_table\"]/tbody/tr[2]/td[2]/div");
		enterById("city-of-birth", birthCity);
		enterByName("state-of-birth", birthState);
		waitProperty(500);
		selectVisibileTextById("country-of-birth", birthCountry);
		waitProperty(500);
		selectVisibileTextById("nationality", nationality);
		waitProperty(500);
		clickById("datos-personales-button");
		enterById("contact-street", street);
		enterById("contact-city", city);
		enterById("contact-state", state);
		enterById("contact-zip", pincode);
		clickByXpath("//*[@id=\"phone-number\"]/div");
		waitProperty(1000);
		clickByXpath("//*[@id=\"phone-number\"]/ul/li[96]");
		waitProperty(500);
		enterByXpath("//*[@id=\"phone-number\"]/input[2]", phoneNumber);
		clickById("other-phonenumber-Yes");
		waitProperty(500);
		enterById("other-phonenumber-detail", otherNumber);
		TAB();
		selectVisibileTextById("india-region", territory);
		waitProperty(500);
		TAB();
		pageDown();
		waitProperty(500);
		clickById("datos-contacto-button");
		enterById("languages", languagesKnown);
		selectVisibileTextById("marital-status", maritialStatus);
		waitProperty(500);
		selectVisibileTextById("purpose-of-trip", purpose);
		waitProperty(500);
		selectVisibileTextById("application-location-india-language", interviewLanguage);
		waitProperty(500);
		clickById("accept-terms-");
		
		
	}

	}
