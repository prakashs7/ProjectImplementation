package testcases;

import org.testng.annotations.Test;

import utils.DP003;
import wrappers.GenericWrappers;

public class TC003 extends GenericWrappers {
	@Test(dataProvider="panIndApplication", dataProviderClass=DP003.class)
	public void panIndApplication(String title,String firstName,String lastName,String fatherFirstName,String fatherLastName,String mobileNumber,String email,String incomeSource,String dob, String houseNo,String street,String city,String state,String pincode,String offName,String offStreet,String offArea,String offCity,String offState,String offPincode,String idProof,String addProof,String dobProof,String aadhaarProof,String offAddProof) {
		
		invokeApp("chrome", "https://panind.com/india/new_pan/");
		selectVisibileTextById("pan_title", title);
		enterById("pan_firstname", firstName);
		enterById("pan_lastname", lastName);
		enterById("pan_fatherfirstname", fatherFirstName);
		enterById("pan_fatherlastname", fatherLastName);
		enterById("pan_mobilenumber", mobileNumber);
		enterById("pan_email", email);
		selectVisibileTextById("pan_sourceofincome", incomeSource);
		clickById("office");
		enterById("pan_dob", dob);
		pageDown();
		enterByName("pan_addressline1", houseNo);
		enterByName("pan_addressline2", street);
		enterByName("pan_cityname", city);
		selectVisibileTextById("pan_state", state);
		enterById("pan_pincode", pincode);
		enterByName("pan_officename", offName);
		enterByName("pan_officeaddressline1", offStreet);
		enterByName("pan_officeaddressline2", offArea);
		enterByName("pan_officecityname", offCity);
		selectVisibileTextById("pan_officestate", offState);
		enterByName("pan_officepincode", offCity);
		selectVisibileTextById("pan_identityproof", idProof);
		selectVisibileTextById("pan_addressproof", addProof);
		selectVisibileTextById("pan_DOBproof", dobProof);
		selectVisibileTextById("pan_aadhaarproof", aadhaarProof);
		selectVisibileTextById("pan_officeaddressproof", offAddProof);
		pageDown();
		clickById("pan_source");
		
	}
}
