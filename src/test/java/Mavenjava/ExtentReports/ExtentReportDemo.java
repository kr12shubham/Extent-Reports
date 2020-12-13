package Mavenjava.ExtentReports;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportDemo {
	ExtentReports extent;

	@BeforeTest

	public void config() {
		// ExtentReports //ExtentSparkRoporter
		String path = System.getProperty("user.dir") + "\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Automation report");
		System.out.println(reporter.config().getDocumentTitle());

		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Shubham Kumar");
	}

	@Test
	public void initial() {
		extent.createTest("My Report");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\kumar\\Downloads\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://google.co.in/");
		System.out.println(driver.getTitle());
		extent.flush();
	}

}
