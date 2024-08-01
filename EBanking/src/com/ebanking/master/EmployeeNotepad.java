package com.ebanking.master;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class EmployeeNotepad
{

	public static void main(String[] args) throws IOException, InterruptedException
	{
		Library l=new Library();
		l.LaunchApp("http://103.211.39.246/ranford2");
		l.AdminLogin("Admin", "Mindq@Sys");
		String sd;
		FileReader fr=new FileReader("D:\\MindQBankingProject\\EBanking\\src\\com\\banking\\testdata\\Employee.txt");
		BufferedReader br=new BufferedReader(fr);
		String sread = br.readLine();
		System.out.println(sread);
		FileWriter fw=new FileWriter("D:\\MindQBankingProject\\EBanking\\src\\com\\ebanking\\results\\Employee_Results.txt");
		BufferedWriter bw=new BufferedWriter(fw);
		bw.write(sread);
		bw.newLine();
		while ((sd=br.readLine())!=null) 
		{
			System.out.println(sd);
			String sr[]=sd.split("###");
			String Ename = sr[0];
			String Epwd = sr[1];
			String Erole = sr[2];
			String Ebranch = sr[3];
			String str = l.EmpCreation(Ename, Epwd, Erole, Ebranch);
			l.Employee_Home();
			System.out.println(str);
			bw.write(sd+"@#$%"+str);
			bw.newLine();

		}
		bw.close();
		br.close();
	}

}
