package testcases;

import org.testng.annotations.Test;

import utils.DP010;

import wrappers.GenericWrappers;

public class TC010 extends GenericWrappers {
	
@Test(dataProvider="formC", dataProviderClass=DP010.class)
	public void formC(String userID,String password,String confirmPassword,String securityQuestion,String answer,String userName,String gender,String dob,String designation,String email,String mobile,String landline,String hotelName,String capacity,String address, String state,String district,String accomodation,String rating,String hotelEmail,String hotelconatct1,String hotelContact2,String ownerName,String ownerAddress,String ownerState,String ownerDistrict,String ownerEmail,String ownerContact1,String ownerContact2) {
		int secque = Integer.parseInt(securityQuestion);
		int gen = Integer.parseInt(gender);
		int dis = Integer.parseInt(district);
		int acc = Integer.parseInt(accomodation);
		int rat = Integer.parseInt(rating);
		invokeApp("chrome", "https://indianfrro.gov.in/frro/FormC/menuuserreg.jsp");
		waitProperty(500);
		clickByLink("Sign Up (Registration)");
		waitProperty(500);
		enterById("u_id", userID);
		enterById("u_pwd", password);
		enterByName("u_repwd", confirmPassword);
		selectIndexById("u_secques", secque);
		waitProperty(500);
		enterById("u_secans", answer);
		enterById("u_name", userName);
		selectIndexById("u_gender", gen);
		enterByXpath("//*[@id=\"u_dob\"]", dob);
		enterById("u_designation", designation);
		enterById("u_emailid", email);
		enterById("u_mobile", mobile);
		enterById("u_phone", landline);
		enterById("name", hotelName);
		enterById("capacity", capacity);
		enterById("address", address);
		waitProperty(1000);
		selectVisibileTextById("state", state);
		waitProperty(1000);
		selectIndexById("city_distr", dis);
		waitProperty(500);
		selectIndexById("acco_type", acc);
		waitProperty(500);
		selectIndexById("star_rat", rat);
		enterById("email", hotelEmail);
		enterById("mcontact", hotelconatct1);
		enterById("contact", hotelContact2);
		enterByName("name_o", ownerName);
		enterByName("address_o", ownerAddress);
		waitProperty(500);
		selectVisibileTextById("state_o", ownerState);
		waitProperty(500);
		selectVisibileTextById("citydistr_o", ownerDistrict);
		enterByName("emailid_o", ownerEmail);
		enterByName("phoneno_o", ownerContact1);
		enterByName("mobile_o", ownerContact2);
		
	}
}
