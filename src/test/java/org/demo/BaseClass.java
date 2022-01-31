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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public static void launchChrome() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
	}
	public static void loadUrl(String url){
		driver.get(url);
	}
	public static void winMax() {
		driver.manage().window().maximize();
		
	}
public static void PrintCurrentUrl() {
	System.out.println(driver.getCurrentUrl());
}

public static void fill(WebElement ele,String value) {
	ele.sendKeys(value);	
}
public static void btnClick(WebElement ele) {
	ele.click();	
}
public static void close() {
	driver.quit();
}
public static String Excel(int s1, int s2) throws IOException {
	File f = new File("C:\\Users\\pc\\eclipse-workspace\\demo\\EXCEL\\REPORT.xlsx");
	FileInputStream fin = new FileInputStream(f);
	Workbook w = new XSSFWorkbook(fin);
	Sheet s = w.getSheet("DATA");
	Row r = s.getRow(s1);
	Cell c = r.getCell(s2);
		int cellType = c.getCellType();
		String value = "";
		if(cellType==1) {
			value = c.getStringCellValue();
			
		}
		else if(cellType==0){
			if (DateUtil.isCellDateFormatted(c)) {
				Date d = c.getDateCellValue();
				SimpleDateFormat sim = new SimpleDateFormat("dd,mmmm,yyyy");
				value = sim.format(d);
				
			}
			else {
				double d = c.getNumericCellValue();
				long l = (long)d;
				 value = String.valueOf(l);
				return value;
			}
		}
		return value;
			}
	


}


