package org.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BrowserLaunch extends BaseClass {
	
	public static void main (String []args) {
		launchChrome();
		loadUrl("https://www.facebook.com/");
		winMax();
		PrintCurrentUrl();
		
		WebElement txtuser = driver.findElement(By.id("email"));
		fill(txtuser,"greens");
		WebElement txtpass = driver.findElement(By.id("pass"));
		fill(txtpass,"greens@123");
		WebElement btnlogin = driver.findElement(By.xpath("//button[@name='login']"));
		btnClick(btnlogin);
		

}
}