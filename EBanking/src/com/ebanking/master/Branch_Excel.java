package com.ebanking.master;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Branch_Excel 
{

	public static void main(String[] args) throws IOException, InterruptedException 
	{
		Library l=new Library();
		l.LaunchApp("http://103.211.39.246/ranford2");
		l.AdminLogin("Admin", "Mindq@Sys");
		FileInputStream f=new FileInputStream("D:\\MindQBankingProject\\EBanking\\src\\com\\banking\\testdata\\ExcelBranch.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(f);
		XSSFSheet ws = wb.getSheet("BrData");
		int Rcount = ws.getLastRowNum();
		System.out.println("Number of rows is: "+Rcount);
		for (int i = 1; i <=Rcount; i++) 
		{
			XSSFRow wr = ws.getRow(i);
			XSSFCell wc = wr.getCell(0);
			XSSFCell wc1 = wr.getCell(1);
			XSSFCell wc2 = wr.getCell(2);
			XSSFCell wc3 = wr.getCell(3);
			XSSFCell wc4 = wr.getCell(4);
			XSSFCell wc5 = wr.getCell(5);
			XSSFCell wc6 = wr.createCell(6);
			String Bname = wc.getStringCellValue();
			String Baddress = wc1.getStringCellValue();
			String Bzipcode = wc2.getStringCellValue();
			String Bcountry = wc3.getStringCellValue();
			String Bstate = wc4.getStringCellValue();
			String Bcity = wc5.getStringCellValue();
			String str = l.BrCreation(Bname, Baddress, Bzipcode, Bcountry, Bstate, Bcity);
			System.out.println(str);
			// Result column
			wc6.setCellValue(str);
		}
		// Results excel file
		FileOutputStream f1=new FileOutputStream("D:\\MindQBankingProject\\EBanking\\src\\com\\ebanking\\results\\Branch_Results.xlsx");
		wb.write(f1);
		wb.close();
	}

}
