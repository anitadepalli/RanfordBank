package com.ebanking.master;

import java.io.IOException;

public class ExeLibrary 
{

	public static void main(String[] args) throws InterruptedException, IOException 
	{

		Library l=new Library();
		String rlaunch = l.LaunchApp("http://103.211.39.246/ranford2");
		System.out.println(rlaunch);
		System.out.println("-----------------------------------------------------");
		String radmin = l.AdminLogin("Admin","Mindq@Sys");
		System.out.println(radmin);
		System.out.println("-----------------------------------------------------");
		String rbranch = l.BrCreation("DC431Alfa","Bradford Rd","32714","USA","Washington","Olympia");
		System.out.println(rbranch);
		System.out.println("-----------------------------------------------------");
		String rrole = l.RoleCreation("Cashier","E");
		System.out.println(rrole);
		System.out.println("-----------------------------------------------------");
		String remployee = l.EmpCreation("JamieGibbons","manager","banker","DutchBank");
		System.out.println(remployee);
		System.out.println("-----------------------------------------------------");
		String rlogout =l.Logout();
		System.out.println(rlogout);
		System.out.println("-----------------------------------------------------");
		String rbanker = l.BLogin("DutchBank","JamieGibbons","manager");
		System.out.println(rbanker);
		System.out.println("-----------------------------------------------------");
		String rclose = l.CloseApp();
		System.out.println(rclose);

	}

}
