package com.ebanking.master;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Role_Excel 
{

	public static void main(String[] args) throws IOException, InterruptedException 
	{
		Library l=new Library();
		l.LaunchApp("http://103.211.39.246/ranford2");
		l.AdminLogin("Admin", "Mindq@Sys");
		// To get the test data file
		FileInputStream f=new FileInputStream("D:\\MindQBankingProject\\EBanking\\src\\com\\banking\\testdata\\ExcelRole.xlsx");
		//Workbook
		XSSFWorkbook wb=new XSSFWorkbook(f);
		//Sheet
		XSSFSheet ws = wb.getSheet("RData");
		//Row Count
		int Rcount = ws.getLastRowNum();
		System.out.println("The number of rows is: "+Rcount);
		//Multiple iterations-----for loop
		for (int i = 1; i <= Rcount; i++) 
		{
			//Row
			XSSFRow wr = ws.getRow(i);
			//Cell
			XSSFCell wc = wr.getCell(0);
			XSSFCell wc1 = wr.getCell(1);

			XSSFCell wc2 = wr.createCell(2);
			// Get cell values
			String Rname = wc.getStringCellValue();
			String Rtype = wc1.getStringCellValue();
			
			String Res = l.RoleCreation(Rname, Rtype);
			System.out.println(Res);

			// Result Column
			wc2.setCellValue(Res);				
		}
		//Results excel file
		FileOutputStream f1=new FileOutputStream("D:\\MindQBankingProject\\EBanking\\src\\com\\ebanking\\results\\Role_Results.xlsx");
		wb.write(f1);
		wb.close();

	}

}
