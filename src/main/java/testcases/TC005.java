package testcases;

import org.testng.annotations.Test;

import utils.DP005;
import wrappers.GenericWrappers;

public class TC005 extends GenericWrappers {
	@Test(dataProvider="eTicketingRegisteration",dataProviderClass=DP005.class)
	public void eTicketingRegisteration (String userName,String password,String confirmPassword,String country,String firstName,String lastname,String month,String year,String country1,String email,String mobileNumber,String country2,String houseNo,String street,String area, String pinCode,String state,String city,String post,String mobileNumber1,String offName,String offStreet,String offArea,String offpincode,String offState,String offCity,String offPost,String offNumber) {
		
		invokeApp("chrome", "https://www.irctc.co.in/nget/train-search");
		waitProperty(500);
		clickByXpath("html/body/app-root/app-home/div[1]/app-header/p-dialog[2]/div/div/div[2]/div/form/div[2]/button");
		clickByLink("REGISTER");
		waitProperty(500);
		enterById("userName", userName);
		enterById("usrPwd", password);
		enterById("cnfUsrPwd", confirmPassword);
		clickByXpath("//*[@id=\"ui-tabpanel-0\"]/div/div[5]/p-dropdown/div");
		waitProperty(500);
		clickByXpath("//*[@id=\"ui-tabpanel-0\"]/div/div[5]/p-dropdown/div/div[4]/div/ul/p-dropdownitem[1]/li");
		clickByXpath("//*[@id=\"ui-tabpanel-0\"]/div/div[6]/p-dropdown/div");
		clickByXpath("//*[@id=\"ui-tabpanel-0\"]/div/div[6]/p-dropdown/div/div[4]/div/ul/p-dropdownitem[5]/li/span");
		enterByXpath("//*[@id=\"ui-tabpanel-0\"]/div/div[7]/input", country);
		clickByXpath("//*[@id=\"divMain\"]/div/app-user-registration/div/div/form/div/div[2]/div[2]/div[2]/button");
		enterById("firstName", firstName);
		enterById("lastname", lastname);
		clickByXpath("//*[@id=\"ui-tabpanel-1\"]/div/div[5]/p-dropdown/div");
		clickByXpath("//*[@id=\"ui-tabpanel-1\"]/div/div[5]/p-dropdown/div/div[4]/div/ul/p-dropdownitem[3]/li/span");
		clickByXpath("//*[@id=\"ui-tabpanel-1\"]/div/div[6]/p-calendar/span/input");
		selectVisibileTextByXpath("//*[@id=\"ui-tabpanel-1\"]/div/div[6]/p-calendar/span/div/div/div[1]/div/select[1]", month);
		selectVisibileTextByXpath("//*[@id=\"ui-tabpanel-1\"]/div/div[6]/p-calendar/span/div/div/div[1]/div/select[2]", year);
		clickByXpath("//*[@id=\"ui-tabpanel-1\"]/div/div[6]/p-calendar/span/div/div/div[2]/table/tbody/tr[2]/td[2]/a");
		clickByXpath("//*[@id=\"unmarried\"]/div/div[2]/span");
		selectVisibileTextByXpath("//*[@id=\"ui-tabpanel-1\"]/div/div[8]/select", country1);
		clickByXpath("//*[@id=\"ui-tabpanel-1\"]/div/div[9]/p-selectbutton/div/div[1]/span");
		enterById("email", email);
		enterById("mobile", mobileNumber);
		selectVisibileTextByXpath("//*[@id=\"ui-tabpanel-1\"]/div/div[13]/select", country2);
		waitProperty(1000);
		clickByXpath("//*[@id=\"divMain\"]/div/app-user-registration/div/div/form/div/div[2]/div[2]/div[2]/button");
		waitProperty(1000);
		enterById("resAddress1", houseNo);
		enterById("resAddress2", street);
		enterById("resAddress3", area);
		enterByName("resPinCode", pinCode);
		enterByName("resState", state);
		waitProperty(500);
		selectVisibileTextByXpath("//*[@id=\"ui-tabpanel-2\"]/div/div[6]/select", city);
		waitProperty(500);
		selectVisibileTextByXpath("//*[@id=\"ui-tabpanel-2\"]/div/div[7]/select", post);
		enterById("resPhone", mobileNumber1);
		clickByXpath("//*[@id=\"no\"]/div/div[2]/span");
		enterById("offAddress1", offName);
		enterById("offAddress2", offStreet);
		enterById("offAddress3", offArea);
		clickByXpath("//*[@id=\"ui-tabpanel-2\"]/div/div[10]/div[4]/p-dropdown/div");
		clickByXpath("//*[@id=\"ui-tabpanel-2\"]/div/div[10]/div[4]/p-dropdown/div/div[4]/div/ul/p-dropdownitem[105]/li");
		enterById("offPinCode", offpincode);
		enterById("offState", offState);
		enterById("offCity", offCity);
		enterById("offPostOff", offPost);
		enterById("offPhone", offNumber);
		clickByXpath("//*[@id=\"ui-tabpanel-2\"]/div/div[13]/span[1]");
		
	}
}
