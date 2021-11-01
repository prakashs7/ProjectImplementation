package testcases;

import org.testng.annotations.Test;

import utils.DP007;
import wrappers.GenericWrappers;

public class TC007 extends GenericWrappers{
	@Test(dataProvider="saloonCharter", dataProviderClass=DP007.class)
	public void saloonCharter(String name,String org,String address,String mobileNo,String email,String enquiry,String depature,String arrival,String duration,String coach,String passengers,String purpose,String addservices) {
		
		invokeApp("chrome", "https://www.irctc.co.in/nget/train-search");
		clickByXpath("html/body/app-root/app-home/div[1]/app-header/p-dialog[2]/div/div/div[2]/div/form/div[2]/button");
		clickByLink("HOLIDAYS");
		clickByXpath("/html/body/app-root/app-home/div[1]/app-header/div[2]/div[2]/div[2]/nav/ul/li[7]/ul/li[3]/a/span[1]");
		clickByXpath("/html/body/app-root/app-home/div[1]/app-header/div[2]/div[2]/div[2]/nav/ul/li[7]/ul/li[3]/ul/li[2]/a/span");
		switchToLastWindow();
		clickByXpath("/html/body/app-root/homeheader/header/nav/div/div[2]/div/ul/li[3]");
		waitProperty(1000);
		clickByLink("Charter");
		waitProperty(1000);
		clickById("enquiry-tab");
		waitProperty(1000);
		enterByName("name", name);
		enterByName("organization", org);
		enterByName("address", address);
		enterByName("mobile", mobileNo);
		enterByName("email", email);
		selectVisibileTextByXpath("//*[@id=\"enquiry\"]/div/form/div/div[6]/select", enquiry);
		enterByName("originStation", depature);
		enterByName("destnStation", arrival);
		clickByName("checkInDate");
		waitProperty(500);
		clickByXpath("//*[@id=\\\"enquiry\\\"]/div/form/div/div[9]/div/div/table/tbody/tr[4]/td[4]/span");
		waitProperty(500);
		clickByName("checkOutDate");
		waitProperty(500);
		clickByXpath("//*[@id=\\\"enquiry\\\"]/div/form/div/div[10]/div/div/table/tbody/tr[4]/td[7]");
		enterByName("durationPeriod", duration);
		enterByName("coachDetails", coach);
		enterByXpath("//*[@id=\"enquiry\"]/div/form/div/div[13]/input", passengers);
		enterByName("charterPurpose", purpose);
		enterByName("services", addservices);
		clickByXpath("//*[@id=\"enquiry\"]/div/form/div/div[17]/button");
		verifyTextByXpath("//*[@id=\"enquiry\"]/div/form/div/div[4]/span", "Mobile no. not valid");
		
	}
}
