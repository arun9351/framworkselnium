package utilities;



import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class readxlfile23 {

	
@DataProvider(name = "red_xcl")
	public String[][] getdata(Method m) throws EncryptedDocumentException, IOException   {
	String excellsheetname=m.getName();
	File f1 = new File(
				System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\logintestdataxclsheet.xlsx");
		FileInputStream fls = new FileInputStream(f1);
		Workbook wb = WorkbookFactory.create(fls);
		Sheet sheatname = wb.getSheet(excellsheetname);

		int totalrows = sheatname.getLastRowNum();
		System.out.println(totalrows);
		Row rowcelles = sheatname.getRow(0);
		int totalcoloum = rowcelles.getLastCellNum();
		System.out.println(totalcoloum);
		DataFormatter formate = new DataFormatter();

		String[][] testdata = new String[totalrows][totalcoloum];
		for (int i = 1; i <= totalrows; i++) {
			for (int j = 0; j < totalcoloum; j++) {
				testdata[i-1][j] = formate.formatCellValue(sheatname.getRow(i).getCell(j));
				System.out.println(testdata[i-1][j]);
			}
		}

		return testdata;

	}

}

