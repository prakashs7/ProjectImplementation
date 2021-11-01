package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DP004 {

@DataProvider(name="phpTravelsRegister")

	public static String[][] getData() {
	
	String [][] testData = null;
	
	try {
		FileInputStream fis = new FileInputStream("./testData/TC004.xlsx");
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		XSSFSheet sheet = wb.getSheetAt(0);
		
		int rowCount = sheet.getLastRowNum();
		
		int columnCount = sheet.getRow(0).getLastCellNum();
		
		System.out.println("Row count :" +rowCount+ " and Column count :" +columnCount);
		
		testData = new String[rowCount][columnCount];
		
		for (int i=1;i<=rowCount;i++) {
			
			XSSFRow row = sheet.getRow(i);
			
			for (int j=0;j<columnCount;j++) {
				
				String cellData = row.getCell(j).getStringCellValue();
				
				System.out.println("The value of row "+i+" and column "+j+" is "+cellData);
				
				testData[i-1][j] = cellData;
				
				
			}
		}
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return testData;
	
}




}
