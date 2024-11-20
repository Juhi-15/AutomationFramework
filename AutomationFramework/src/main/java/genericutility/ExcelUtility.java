package genericutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * @author juhis
 */

public class ExcelUtility {
	/**
	 * This method is used to read string data from excel
	 * User must pass sheetName, rowIndex, column Index
	 * @param sheetName
	 * @param rowIndex
	 * @param colIndex
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public String getStringDataFromExcel(String sheetName,int rowIndex,int colIndex) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/TestData/TestscriptData.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		return workbook.getSheet(sheetName).getRow(rowIndex).getCell(colIndex).getStringCellValue();
		
	}
	/**
	 * This method is used to read Boolean data from excel
	 * @param sheetName
	 * @param rowIndex
	 * @param colIndex
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public boolean getBooleanDataFromExcel(String sheetName,int rowIndex,int colIndex) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./src/test/java/TestData/TestscriptData.xlsx");
		Workbook Workbook=WorkbookFactory.create(fis);
		return Workbook.getSheet(sheetName).getRow(rowIndex).getCell(colIndex).getBooleanCellValue();
		
	}
	/**
	 * This method is used to read Numeric data from excel
	 * @param sheetName
	 * @param rowIndex
	 * @param colIndex
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public double getNumericDataFromExcel(String sheetName,int rowIndex,int colIndex) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./src/test/java/TestData/TestscriptData.xlsx");
		Workbook Workbook=WorkbookFactory.create(fis);
		return Workbook.getSheet(sheetName).getRow(rowIndex).getCell(colIndex).getNumericCellValue();
		
	}
	/**
	 * This method is used to read LocalDateTime 
	 * @param sheetName
	 * @param rowIndex
	 * @param colIndex
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public LocalDateTime getLocalDateTimeDataFromExcel(String sheetName,int rowIndex,int colIndex) throws EncryptedDocumentException, IOException{
		FileInputStream fis=new FileInputStream("./src/test/java/TestData/TestscriptData.xlsx");
		Workbook Workbook=WorkbookFactory.create(fis);
		return Workbook.getSheet(sheetName).getRow(rowIndex).getCell(colIndex).getLocalDateTimeCellValue();
		
	}
}
	




