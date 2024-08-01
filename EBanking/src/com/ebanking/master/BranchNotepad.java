package com.ebanking.master;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BranchNotepad 
{

	public static void main(String[] args) throws IOException, InterruptedException 
	{

		Library l=new Library();
		l.LaunchApp("http://103.211.39.246/ranford2");
		l.AdminLogin("Admin", "Mindq@Sys");
		String fpath = "D:\\MindQBankingProject\\EBanking\\src\\com\\banking\\testdata\\BranchCreation.txt";
		String rpath = "D:\\MindQBankingProject\\EBanking\\src\\com\\ebanking\\results\\Branch_Results.txt";
		String sd;
		FileReader fr=new FileReader(fpath);
		BufferedReader br=new BufferedReader(fr);
		String sread = br.readLine();
		System.out.println(sread);
		FileWriter fw= new FileWriter(rpath);
		BufferedWriter bw= new BufferedWriter(fw);
		bw.write(sread);
		bw.newLine();
		while ((sd=br.readLine())!=null) 
		{
			System.out.println(sd);
			String sr[]=sd.split("###");
			String Brname = sr[0];
			String Braddress1 = sr[1];
			String Brzipcode = sr[2];
			String Brcountry = sr[3];
			String Brstate = sr[4];
			String Brcity = sr[5];

			String str = l.BrCreation(Brname, Braddress1, Brzipcode, Brcountry, Brstate, Brcity);
			System.out.println(str);
			bw.write(sd+"$#@%"+str);
			bw.newLine();
		}
		bw.close();
		br.close();
	}

}
