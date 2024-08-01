package com.ebanking.master;

import org.testng.annotations.Test;

public class RoleNG extends Base
{
	@Test
	public void Role() throws InterruptedException 
	{
		l.RoleCreation("banker", "E");
	}
}
