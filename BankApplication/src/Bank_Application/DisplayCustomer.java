package Bank_Application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DisplayCustomer {
	
	public void customerdetails(int cst_id) throws IOException {
	
	String excelfile=".\\DataFiles\\Customer_Details.xlsx";
	FileInputStream inputstream=new FileInputStream(excelfile);    
	XSSFWorkbook workbook=new XSSFWorkbook(inputstream);
	XSSFSheet customer_sheet=workbook.getSheetAt(0);
	int rows=customer_sheet.getLastRowNum();
	int cols=customer_sheet.getRow(1).getLastCellNum();
	System.out.println("Name   CustomerId    Balance   Date_of_joining   Intrest");
	System.out.println("---------------------------------------------------------");
	
	for(int r=1;r<=rows;r++) {
		XSSFRow row= customer_sheet.getRow(r);	
		if((int)row.getCell(1).getNumericCellValue()==cst_id)
		{
		for(int c=0;c<cols;c++)
		{ 
			XSSFCell cell=row.getCell(c);
			
			switch(cell.getCellType())
			{
			case STRING:
				System.out.print(cell.getStringCellValue()+"   ");
				break;
			case NUMERIC:
				System.out.print((int)cell.getNumericCellValue()+"   ");
				break;
				
			
		}
		}
	
	}
		
	}
	
	
	}

}
