package testcases;

import org.testng.annotations.Test;

import utils.DP009;

import wrappers.GenericWrappers;

public class TC009 extends GenericWrappers{

	@Test(dataProvider="bookHotelsWithGST",dataProviderClass=DP009.class)
	public void bookHotelsWithGST(String email, String mobileNo,String city,String rooms,String person,String title,String firstName,String lastName,String state,String gstRequired,String gstNo,String offName,String offAddress) {
		
		invokeApp("chrome", "https://www.irctc.co.in");
		clickByXpath("html/body/app-root/app-home/div[1]/app-header/p-dialog[2]/div/div/div[2]/div/form/div[2]/button");
		clickByLink("HOLIDAYS");
		clickByXpath("/html/body/app-root/app-home/div[1]/app-header/div[2]/div[2]/div[2]/nav/ul/li[7]/ul/li[3]/a/span[1]");
		clickByXpath("/html/body/app-root/app-home/div[1]/app-header/div[2]/div[2]/div[2]/nav/ul/li[7]/ul/li[3]/ul/li[2]/a/span");
		switchToLastWindow();
		waitProperty(1000);
		clickByXpath("/html/body/app-root/accommodation/div[2]/div[1]/ul/li[2]/a/div");
		switchToLastWindow();
		waitProperty(1000);
		clickByLink("Login");
		waitProperty(1000);
		clickByXpath("//*[@id=\"LoginFormPopup\"]/app-loginmodal/div/div/div/ul/li[2]/a");
		waitProperty(1000);
		enterById("modalLRInput12", email);
		enterById("modalLRInput13", mobileNo);
		clickByXpath("//*[@id=\"panel8\"]/div[1]/form/div[3]/button");
		waitProperty(2000);
		clickByXpath("//*[@id=\"TravellerEconomydropdown\"]/div[1]/searchbox/input");
		waitProperty(3000);
		enterByXpath("//*[@id=\"TravellerEconomydropdown\"]/div[1]/searchbox/input", city);
		waitProperty(2000);
		clickByXpath("//*[@id=\"TravellerEconomydropdown\"]/div[1]/searchbox/div/ul/li[1]/a/div[2]/strong");
		waitProperty(500);
		clickByName("dt12");
		waitProperty(500);
		clickByXpath("//*[@id=\\\"owl-dt-picker-0\\\"]/div[2]/owl-date-time-calendar/div[2]/owl-date-time-month-view/table/tbody/tr[4]/td[4]/span");
		waitProperty(500);
		clickByName("dt13");
		waitProperty(1000);
		clickByXpath("//*[@id=\\\"owl-dt-picker-1\\\"]/div[2]/owl-date-time-calendar/div[2]/owl-date-time-month-view/table/tbody/tr[4]/td[5]/span");
		waitProperty(500);
		clickById("user-data-wrapper-id");
		selectVisibileTextByName("hotelRoom", rooms);
		waitProperty(500);
		selectVisibileTextByName("hotelAdult", person);
		waitProperty(500);
		clickByXpath("//*[@id=\"user-data-wrapper\"]/div[2]/button");
		waitProperty(500);
		clickByXpath("//*[@id=\"TravellerEconomydropdown\"]/div[5]/button");
		waitProperty(3000);
		clickByXpath("/html/body/app-root/app-fulllayout/div/app-hotellist/main/div/div[2]/div/div[2]/div/div/div[3]/button");
		waitProperty(1000);
		getTextByXpath("/html/body/app-root/app-fulllayout/div/app-hoteldetail/main/div/div/div[2]/h3/a");
		getTextByXpath("//*[@id=\"hotel-dtl-sticky-rooms\"]/div[2]/div[2]/div[1]/div");
		clickByXpath("//*[@id=\"hotel-dtl-sticky-photo\"]/div[1]/div[1]/div[2]/div/div/div[4]/button");
		waitProperty(2000);
		selectVisibileTextByXpath("/html/body/app-root/app-fulllayout/div/app-paxdetail/main/div/div[1]/form/div/div[1]/div/select", title);
		waitProperty(500);
		enterByName("firstName", firstName);
		enterByName("lastName", lastName);
		selectVisibileTextByName("state", state);
		waitProperty(500);
		selectVisibileTextByXpath("/html/body/app-root/app-fulllayout/div/app-paxdetail/main/div/div[1]/form/div/div[8]/div/select", gstRequired);
		waitProperty(500);
		enterByName("gstNumber", gstNo);
		enterByName("companyName", offName);
		enterByName("companyAddress", offAddress);
		waitProperty(500);
		clickByXpath("/html/body/app-root/app-fulllayout/div/app-paxdetail/main/div/div[1]/form/div/div[12]/button[2]");
		waitProperty(500);
		verifyTextByXpath("/html/body/app-root/app-fulllayout/div/app-paxdetail/main/div/div[1]/form/div/div[9]/div/span", "Please Enter Valid GSt number");
		
		
		}
}
