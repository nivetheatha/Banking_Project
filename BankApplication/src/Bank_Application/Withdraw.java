package Bank_Application;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Withdraw {
	public void withdraw_amount(int a,int id) throws IOException {
	String excelfile=".\\DataFiles\\Customer_Details.xlsx";
	FileInputStream inputstream=new FileInputStream(excelfile);    
	XSSFWorkbook workbook=new XSSFWorkbook(inputstream);
	XSSFSheet customer_sheet=workbook.getSheetAt(0);
	int rows=customer_sheet.getLastRowNum();
	int cols=customer_sheet.getRow(1).getLastCellNum();
	
	
	for(int r=1;r<=rows;r++) {
		XSSFRow row= customer_sheet.getRow(r);	
		if((int)row.getCell(1).getNumericCellValue()==id)
		{
			XSSFCell cell=row.getCell(2);
			int balance=(int) cell.getNumericCellValue();
			if(balance>0)
			{
				if(balance>a)
				{
				 double newbalance=balance-a;
				cell.setCellValue(newbalance);
				System.out.println("Please collect the cash");
				System.out.println("Thanks for using our bank");
				}
				else
				{
					System.out.println("Amount you want to withdraw exceeds balance in your account");
				}
			}
			else
			{
				System.out.println("Balance is low");
			}
		}
		FileOutputStream outputstream=new FileOutputStream(excelfile);
		workbook.write(outputstream);
		outputstream.close();
	
	}
	
}

}
