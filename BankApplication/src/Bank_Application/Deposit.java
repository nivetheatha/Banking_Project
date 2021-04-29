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

public class Deposit {
    public void Deposit_amount(int a, int id) throws IOException {
        String excelfile = ".\\Data Files\\Customer_Details.xlsx";
        FileInputStream inputstream = new FileInputStream(excelfile);
        XSSFWorkbook workbook = new XSSFWorkbook(inputstream);
        XSSFSheet customer_sheet = workbook.getSheetAt(0);
        int rows = customer_sheet.getLastRowNum();
        int cols = customer_sheet.getRow(1).getLastCellNum();

        for (int r = 1; r <= rows; r++) {
            XSSFRow row = customer_sheet.getRow(r);
            if ((int) row.getCell(1).getNumericCellValue() == id) {
                XSSFCell cell = row.getCell(2);
                int balance = (int) cell.getNumericCellValue();
                if (balance > 0)
                {
                    double newbalance = balance + a;
                    cell.setCellValue(newbalance);
                    System.out.println("Cash Deposited");
                    System.out.println("Balance in your account is:" +newbalance);
                    System.out.println("Thanks for using our bank");
                }
                else
                {
                    System.out.println("Amount you want to deposit is less than minimum amount");
                }
            }
            FileOutputStream outputstream = new FileOutputStream(excelfile);
            workbook.write(outputstream);
            outputstream.close();

        }

    }
}
