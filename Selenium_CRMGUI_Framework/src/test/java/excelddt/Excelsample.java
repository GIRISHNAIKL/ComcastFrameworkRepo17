package excelddt;

import java.io.FileInputStream;



import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excelsample {

	public static void main(String[] args) throws Throwable 
	{
		//Step-1:get the location of the of the excel sheet
     FileInputStream fis=new FileInputStream("C:\\Users\\Girish Naik L\\Desktop\\DDTpractice.xlsx");
        //Step-2: Open workbook in read mode
     Workbook wb = WorkbookFactory.create(fis);
     //Step3: Get the control of the sheet
 org.apache.poi.ss.usermodel.Sheet sh = wb.getSheet("org");
 Row row = sh.getRow(1);
  Cell cell = row.getCell(2);
 String data = cell.getStringCellValue();
    System.out.println(data);
    wb.close();
	}

}
