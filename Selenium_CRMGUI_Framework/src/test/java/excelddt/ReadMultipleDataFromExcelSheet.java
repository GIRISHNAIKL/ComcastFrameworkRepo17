package excelddt;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleDataFromExcelSheet {

	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
    FileInputStream fis=new FileInputStream("C:\\Users\\Girish Naik L\\Desktop\\DDTpractice.xlsx");
	Workbook wb=WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet("org");
int rowcount = sh.getLastRowNum();
for(int i=0;i<=rowcount;i++)
{
	Row row = sh.getRow(i);
	String column1data = row.getCell(0).toString();
	String column2data = row.getCell(1).toString();
	System.out.println(column1data+"\t"+column2data);
	//System.out.println(column1data);
	
}
wb.close();
	}

}
