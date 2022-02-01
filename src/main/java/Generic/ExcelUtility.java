package Generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	/**
	 * its used read the data from excel base don below arguments 
	 * @param SheetName
	 * @param rownum
	 * @param cellnum
	 * @return
	 * @throws Throwable
	 */
	
	public String getDataFromExcel(String SheetName,int rownum,int cellnum) throws Throwable
	{
		FileInputStream fis=new FileInputStream("./data/nothing.xlsx");
		Workbook work=new WorkbookFactory().create(fis);
		Sheet sh = work.getSheet(SheetName);
		Row row = sh.getRow(rownum);
		Cell cll = row.getCell(cellnum);
		String data = cll.getStringCellValue();
		work.close();
		return data;

	}
	/**
	 * used to get the last used row number on specified Sheet
	 * @param SheetName
	 * @return
	 * @throws Throwable
	 * @throws IOException
	 */
	public int getRownCount(String SheetName) throws Throwable, IOException
	{
		FileInputStream fis=new FileInputStream("./data/nothing.xlsx");
		Workbook work=new WorkbookFactory().create(fis);
		Sheet sh = work.getSheet(SheetName);
	    work.close();
	    return sh.getLastRowNum();
	    }
  /**
   * 
   * @param SheetName
   * @param rownum
   * @param cellnum
   * @param data
   * @return
   * @throws Throwable
   */
	public void setDataExcel(String SheetName,int rownum,int cellnum,String data) throws Throwable
	{
		FileInputStream fis=new FileInputStream("./data/nothing.xlsx");
		Workbook work=new WorkbookFactory().create(fis);
		Sheet sh = work.getSheet(SheetName);
		Row row = sh.getRow(rownum);
	   Cell cll = row.createCell(cellnum);
	   cll.setCellValue(data);
	   
	   FileOutputStream fos=new FileOutputStream("./data/nothing.xlsx");
	   work.write(fos);
	   work.close();
	}

}
	   
	   
	   

