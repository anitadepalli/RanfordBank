package com.ebanking.master;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class KeywordFramework
{

	public static void main(String[] args) throws IOException, InterruptedException 
	{
		Library l=new Library();
		String Res=null;
		String Kpath = "D:\\MindQBankingProject\\EBanking\\src\\com\\banking\\testdata\\keyword_data.xlsx";
		String Kresult = "D:\\MindQBankingProject\\EBanking\\src\\com\\ebanking\\results\\Keyword_Result.xlsx";
		FileInputStream f=new FileInputStream(Kpath);
		//Workbook
		XSSFWorkbook wb=new XSSFWorkbook(f);
		//Sheet
		XSSFSheet ws = wb.getSheet("TestCase");
		XSSFSheet ws1 = wb.getSheet("TestSteps");
		//Rowcount
		int TcRc = ws.getLastRowNum();
		System.out.println(TcRc);
		int TsRc = ws1.getLastRowNum();
		System.out.println(TsRc);
		//Test cases
		for (int i = 1; i <= TcRc; i++) 
		{
			String str = ws.getRow(i).getCell(2).getStringCellValue();
			if (str.equalsIgnoreCase("Y")) 
			{
				String TcId = ws.getRow(i).getCell(0).getStringCellValue();
				System.out.println(TcId);
				// Test steps
				for (int j = 1; j <=TsRc ; j++) 
				{
					String str1 = ws1.getRow(j).getCell(0).getStringCellValue();
					System.out.println(str1);
					if (TcId.equalsIgnoreCase(str1)) 
					{
						String key = ws1.getRow(j).getCell(3).getStringCellValue();
						System.out.println(key);
						//Thread.sleep(5000);
						switch (key)
						{
						case "RLaunch":
							Res=l.LaunchApp("http://103.211.39.246/ranford2");
							break;
						case "RLogin":
							Res=l.AdminLogin("Admin","Mindq@Sys");
							break;
						case "RLogout":
							l.Logout();
							break;
						case "RBranch":
							Res=l.BrCreation("DC431Alfa","Bradford Rd","32714","USA","Washington","Olympia");
							break;
						case "RRole":
							Res=l.RoleCreation("Cashier","E");
							break;
						case "REmR":
							Res=l.EmpCreation("JamieGibbons","manager","banker","DutchBank");
							break;
						case "RClose":
							l.CloseApp();
							break;

						default:
							System.out.println("Pass a valid keyword: ");
							break;
						}
						// Updating result in Test Step sheet
						ws1.getRow(j).createCell(4).setCellValue(Res);
						//Updating result in Test Case sheet
						if (ws1.getRow(j).createCell(4).getStringCellValue().equalsIgnoreCase("Pass"))
						{
							ws.getRow(i).createCell(3).setCellValue(Res);
						}
						else
						{
							ws.getRow(i).createCell(3).setCellValue("Fail");
						}

					}
				}

			}
			else
			{
				ws.getRow(i).createCell(3).setCellValue("BLOCKED");

			}
		}
		FileOutputStream f1= new FileOutputStream(Kresult);
		wb.write(f1);
		wb.close();

	}

}
