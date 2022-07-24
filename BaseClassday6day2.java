package testcase.testcase;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import LearnAttributes.ReadExcel;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassday6day2 {
	public RemoteWebDriver driver;
	public String filename;
	@Parameters({"browser","url","username","password"})
	@BeforeMethod
	//should be same order as Parameters
	public void precondition(String browser, String url,String username,String password) {
	if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();}
		else if(browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();}
		driver.manage().window().maximize();
		//driver.get("http://leaftaps.com/opentaps/");
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
	}
	@AfterMethod
	public void postcondition() {
		driver.close();
	}
	@DataProvider(name="fetchValues")
	public String[][] testData() throws IOException {

		ReadExcel obj=new ReadExcel();
	    String[][] leadDatas = obj.leadDatas(filename);
		return leadDatas; // since non void method, I have to return hence declared the above step as String[][] leadDatas
		/*
		 * String[][] values = new String[2][4]; values[0][0]="Testleaf";
		 * values[0][1]="Nan"; values[0][2]="A"; values[0][3]="99";
		 * 
		 * values[1][0]="Testleaf"; values[1][1]="Nand"; values[1][2]="B";
		 * values[1][3]="9669"; return values;
		 */

	}
}

