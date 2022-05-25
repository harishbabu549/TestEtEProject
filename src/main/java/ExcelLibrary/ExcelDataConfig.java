package ExcelLibrary;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataConfig {

	XSSFWorkbook wb;
	XSSFSheet sheet;

	public ExcelDataConfig(String excelPath) throws IOException {
		try {
			File file = new File(excelPath);
			FileInputStream fis = new FileInputStream(file);
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}

	public String getData(int sheetNo, int row, int column) {
		sheet = wb.getSheetAt(sheetNo);
		String data = sheet.getRow(row).getCell(column).getStringCellValue();
		return data;
	}

}
