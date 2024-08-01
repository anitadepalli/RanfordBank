package com.ebanking.master;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class RoleNotepad 
{

	public static void main(String[] args) throws IOException, InterruptedException 
	{
		Library l=new Library();
		l.LaunchApp("http://103.211.39.246/ranford2");
		l.AdminLogin("Admin", "Mindq@Sys");

		//To get test data file path
		String fpath = "D:\\MindQBankingProject\\EBanking\\src\\com\\banking\\testdata\\Role.txt";
		// To get results file path
		String rpath = "D:\\MindQBankingProject\\EBanking\\src\\com\\ebanking\\results\\Role_Results.txt";
		String sd;
		//To read test data file
		FileReader fr=new FileReader(fpath);
		BufferedReader br=new BufferedReader(fr);
		String sread = br.readLine();
		System.out.println(sread);
		// To write header into results file
		FileWriter fw=new FileWriter(rpath);
		BufferedWriter bw=new BufferedWriter(fw);
		bw.write(sread);
		bw.newLine();
		//Multiple iterations.....while loop
		while ((sd=br.readLine())!=null) 
		{
			System.out.println(sd);
			// Split data
			String sr[]=sd.split("###");
			String rname = sr[0];
			String rtype = sr[1];
			String str = l.RoleCreation(rname, rtype);
			System.out.println(str);
			//results
			bw.write(sd+"@#%$"+str);
			bw.newLine();
		}
			bw.close();
			br.close(); 

	}

}
