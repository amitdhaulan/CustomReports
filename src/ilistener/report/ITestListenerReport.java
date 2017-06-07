package ilistener.report;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ClassImplementingITestListener.class)
public class ITestListenerReport {

	@Test
	public void testRealReportOne(){
		Assert.assertTrue(true);
	}
	
	@Test
	public void testRealReportTwo(){
		Assert.assertTrue(false);
	}
	//Test case depends on failed testcase= testRealReportTwo
	@Test(dependsOnMethods="testRealReportTwo")
	public void testRealReportThree(){
		
	}
}
