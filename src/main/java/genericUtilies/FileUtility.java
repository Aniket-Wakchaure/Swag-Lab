package genericUtilies;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtility {
	
	public String readDataFromPropertyFile(String key) throws IOException {
	
	FileInputStream fis= new FileInputStream("C:\\Users\\User\\eclipse-workspace\\SwagLabs.CRM.FireFlink\\src\\test\\resources\\CommenData.properties");
	Properties p=new Properties();
	p.load(fis);
	String property = p.getProperty(key);
	return property;
}
	
	public String readDataFromExel(String sheet,int Row,int Col) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis=new FileInputStream("C:\\Users\\User\\eclipse-workspace\\SwagLabs.CRM.FireFlink\\src\\test\\resources\\SwagLabExel.xlsx");
		Workbook wb =WorkbookFactory.create(fis);
		
		String data = wb.getSheet(sheet).getRow(Row).getCell(Col).getStringCellValue();
		return data;
		
	}
	
}
