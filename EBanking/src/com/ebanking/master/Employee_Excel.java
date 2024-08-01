package com.ebanking.master;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Employee_Excel 
{

	public static void main(String[] args) throws IOException, InterruptedException 
	{
		Library l=new Library();
		l.LaunchApp("http://103.211.39.246/ranford2");
		l.AdminLogin("Admin", "Mindq@Sys");
		FileInputStream f=new FileInputStream("D:\\MindQBankingProject\\EBanking\\src\\com\\banking\\testdata\\ExcelEmployee.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(f);
		XSSFSheet ws = wb.getSheet("EmpData");
		int Rcount = ws.getLastRowNum();
		System.out.println("The number of rows is "+Rcount);
		for (int i = 1; i <=Rcount; i++) 
		{
			XSSFRow wr = ws.getRow(i);
			XSSFCell wc = wr.getCell(0);
			XSSFCell wc1 = wr.getCell(1);
			XSSFCell wc2 = wr.getCell(2);
			XSSFCell wc3 = wr.getCell(3);
			XSSFCell wc4 = wr.createCell(4);
			String Ename = wc.getStringCellValue();
			String Epwd = wc1.getStringCellValue();
			String Erole = wc2.getStringCellValue();
			String Ebranch = wc3.getStringCellValue();
			String str = l.EmpCreation(Ename, Epwd, Erole, Ebranch);
			System.out.println(str);
			l.Employee_Home();

			//Result column
			wc4.setCellValue(str);
		}
		// Results excel file
		FileOutputStream f1=new FileOutputStream("D:\\MindQBankingProject\\EBanking\\src\\com\\ebanking\\results\\Employee_Results.xlsx");
		wb.write(f1);
		wb.close();
	}

}
