package testcase.testcase;

import java.io.IOException;

import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	public static String[][] leadDatas(String filename) throws IOException{
	XSSFWorkbook book = new XSSFWorkbook("./data/"+filename+".xlsx");
	XSSFSheet sheet = book.getSheetAt(0);
	int rowCount=sheet.getLastRowNum();
	int colCount=sheet.getRow(1).getLastCellNum();
	//to integrate excel with dataprovider
	String[][] data=new String[rowCount][colCount];
	for(int i=1;i<=rowCount;i++) {
	//	(1,0)
		for (int j=0;j<colCount;j++) {
			String stringCellValue= sheet.getRow(i).getCell(j).getStringCellValue();
					data[i-1][j]=stringCellValue;//store (1,0) value in [0][0] array index
		}
	}
	book.close();
	return data;

}
}
