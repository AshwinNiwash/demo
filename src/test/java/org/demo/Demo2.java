package org.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Demo2 {
	public static void main(String[] args) throws IOException {
		File f = new File("C:\\Users\\pc\\eclipse-workspace\\demo\\EXCEL\\REPORT.xlsx");
		FileInputStream fin = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fin);
		Sheet s = w.getSheet("DATA");
		
		
			Row r = s.getRow(0);
			Cell c = r.getCell(2);
			int cellType = c.getCellType();
			if(cellType==1) {
				String value = c.getStringCellValue();
				System.out.println(value);
			}
			else if(cellType==0){
				if (DateUtil.isCellDateFormatted(c)) {
					Date d = c.getDateCellValue();
					SimpleDateFormat sim = new SimpleDateFormat("dd,mmmm,yyyy");
					String value = sim.format(d);
					System.out.println(value);
				}
				else {
					double d = c.getNumericCellValue();
					long l = (long)d;
					String value = String.valueOf(l);
					System.out.println(value);
				}
			}
			
			}
			
		
		
		
		
	

}



