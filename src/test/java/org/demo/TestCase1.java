package org.demo;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.utilities.FbPojo;

public class TestCase1 extends BaseClass    {
	@BeforeClass
	private void launchBrowser() {
		launchChrome(); }
		@AfterClass
		private void quitbr() {
			close();
			}
		@BeforeMethod
		private void url() {
			loadUrl("https://www.facebook.com/");
		}
		
		
		@Test(dataProvider ="LoginData" )
		private void tc1(String s1,String s2) throws IOException, InterruptedException {
	    FbPojo f = new FbPojo();
	    fill(f.getTxtuser(),s1);
	    fill(f.getTxtpass(),s2);
	    btnClick(f.getLogin());
	    Thread.sleep(2000);
	    
			
		}
		@Test(enabled=false)
		private void tc2() throws IOException, InterruptedException {
	    FbPojo f = new FbPojo();
	    fill(f.getTxtuser(),Excel(0,2));
	    fill(f.getTxtpass(),Excel(0,3));
	    btnClick(f.getLogin());
	    Thread.sleep(2000);
}
		@Test(enabled=false)
		private void tc3() throws IOException, InterruptedException {
	    FbPojo f = new FbPojo();
	    fill(f.getTxtuser(),Excel(2,0));
	    fill(f.getTxtpass(),Excel(2,1));
	    btnClick(f.getLogin());
	    Thread.sleep(2000);
}
		@DataProvider(name="LoginData")
		private Object [][] Excel() {
			return new Object[][] {
				{"greens","greens@123"},
				{"sql","sql@123"},
				{"java","java@123"},
				{"python","python@123"}
			
			};
			
			
		
		}
}
		

	
	

