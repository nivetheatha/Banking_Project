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

public class CreateAccount {

    public void Create_Account(char email, char password) throws IOException {

        String excelfile = ".\\Data Files\\Customer_Details.xlsx";
        FileInputStream inputstream = new FileInputStream(excelfile);
        XSSFWorkbook workbook = new XSSFWorkbook(inputstream);
        XSSFSheet customer_sheet = workbook.getSheetAt(0);
        int rows = customer_sheet.getLastRowNum();
        int cols = customer_sheet.getRow(1).getLastCellNum();

        for (int r = 1; r <= rows; r++) {
            XSSFRow row = customer_sheet.getRow(r);
            if ((String) row.getCell(5).getStringCellValue() == "email") {
                if ((String) row.getCell(6).getStringCellValue() == "password") {

                    {
                        for (int c = 0; c < cols; c++) {
                            XSSFCell cell = row.getCell(c);

                            switch (cell.getCellType()) {
                                case STRING:
                                    System.out.print(cell.getStringCellValue() + "   ");
                                    break;
                                case NUMERIC:
                                    System.out.print((int) cell.getNumericCellValue() + "   ");
                                    break;


                            }
                        }

                    }

                }


            }

        }
    }
}