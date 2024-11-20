package genericutility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.beust.jcommander.Parameter;

import objectrespository.HomePage;
import objectrespository.LoginPage;
import objectrespository.WelcomePage;

public class BaseClass {
	public static ExtentReports extReport;
	public static ExtentTest test;
	public WebDriver driver;
	static WebDriver sdriver;
	public JavaUtility jUtil=new JavaUtility();
	public WebDriverUtility wUtil=new WebDriverUtility();
	public FileUtility fUtil=new FileUtility();
	public ExcelUtility eUtil=new ExcelUtility();
	
	public WelcomePage wp;
	public LoginPage lp;
	public HomePage hp;
	

	@BeforeSuite
	public void reportConfig() {
		ExtentSparkReporter spark=new ExtentSparkReporter("./HTML_reports/ExtentReport_"+jUtil.getSystemTime()+".html");
		extReport=new ExtentReports();
		extReport.attachReporter(spark);
	}
	
	@Parameters("Browser")
	@BeforeClass
	public void launchBrowser(@Optional("chrome") String browserName) throws IOException {
		if(browserName.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}
		sdriver=driver;
		wUtil.maximizeWindow(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(fUtil.getDatsFromProperty("url"));
		
		
	}
	
	@BeforeMethod
	public void login() throws IOException {
		wp=new WelcomePage(driver);
		wp.getLoginLink().click();
		
		lp=new LoginPage(driver);
		lp.getEmailTextField().sendKeys(fUtil.getDatsFromProperty("email"));
		lp.getPasswordTextField().sendKeys(fUtil.getDatsFromProperty("password"));
		lp.getLoginButton().click();
		
		}
	
	@AfterMethod
	public void logout() {
		hp=new HomePage(driver);
		hp.getLogoutLink().click();
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
	
	@AfterSuite
	public void reportBackup() {
		extReport.flush();
	}
}