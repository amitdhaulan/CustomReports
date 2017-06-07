package extent.report;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

//Add listener to listen report and write it when testcas finished
public class ExtentReport {
	ExtentReports extent;
	ExtentTest extentTest;
	String extentReportFile = System.getProperty("user.dir") + "\\extentReportFile.html";

	WebDriver driver;

	@Test(priority = 0)
	public void verifySeleniumBlog() {
		String extentReportImage = System.getProperty("user.dir") + "\\screenshot\\screenshottest.png";
		extentTest = extent.startTest("Good! My Extent Report is working fine!", "This report verifies WebSite Title");
		extentTest.log(LogStatus.INFO, "----->Browser Launched");
		driver.get("http://www.google.com");
		extentTest.log(LogStatus.INFO, "----->Navigated to www.google.com");

		String title = driver.getTitle();
		extentTest.log(LogStatus.INFO, "----->Get the WebSite title");

		Assert.assertTrue(title.contains("Google"));
		extentTest.log(LogStatus.PASS, "----->Title verified");

		extentTest.log(LogStatus.INFO, "----->Error Snapshot : " + extentTest.addScreenCapture(extentReportImage));

		extentTest.log(LogStatus.INFO, "----->Browser closed");

		// close report.
		extent.endTest(extentTest);
		// write everything to document.

	}

	@Test(priority = 1)
	public void secondTest() {

		extentTest = extent.startTest("This is my second test of suite", "Working fine!");
		extentTest.log(LogStatus.INFO, "----->Browser Launched");
		driver.get("https://news.google.co.in/nwshp?hl=en&tab=wn&ei=ra4dWfKSNofQvgTFz5LQCw&ved=0EKkuCAYoBQ");
		extentTest.log(LogStatus.INFO, "----->Navigated to google news!");

		String title = driver.getTitle();
		extentTest.log(LogStatus.INFO, "----->Get the WebSite title");

		Assert.assertTrue(title.contains("Google News"));
		extentTest.log(LogStatus.PASS, "----->Title verified");

		// close report.
		extent.endTest(extentTest);
		// write everything to document.
		extent.flush();

	}

	@BeforeTest
	public void startUp() {
		System.setProperty("webdriver.gecko.driver",
				"D:\\amit\\testing_git\\soft\\selenium_accessories\\geckodriver-v0.16.1-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		extent = new ExtentReports(extentReportFile, false);
		driver.manage().window().maximize();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
		extentTest.log(LogStatus.INFO, "----->Browser closed");
	}
}
