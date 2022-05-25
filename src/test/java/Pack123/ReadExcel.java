package Pack123;

import java.io.IOException;

import org.testng.annotations.Test;

import ExcelLibrary.ExcelDataConfig;

public class ReadExcel {
	
	@Test
	public void getData() throws IOException
	{
		ExcelDataConfig edc=new ExcelDataConfig("F:\\Movies\\Telugu\\123.xlsx");
		String data=edc.getData(0, 0, 0);
				System.out.println(data);
	}

}
