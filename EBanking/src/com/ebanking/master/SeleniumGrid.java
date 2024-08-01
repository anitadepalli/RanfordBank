package com.ebanking.master;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class SeleniumGrid
{
	DesiredCapabilities cap;
	@Test
	public void grid() throws MalformedURLException
	{
		cap=new DesiredCapabilities();
		cap.setBrowserName("firefox");
		cap.setPlatform(Platform.WINDOWS);

		RemoteWebDriver driver=new RemoteWebDriver(new URL("http://192.168.1.12:4444/wd/hub"), cap);

		driver.manage().window().maximize();
		driver.get("https://www.google.com/");

	}
}
