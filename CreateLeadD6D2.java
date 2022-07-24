package testcase.testcase;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateLeadD6D2 extends BaseClassday6day2 {
	@BeforeTest
	public void setExcelFile() {
		filename="CreateLead";	
	}	
	//@Test(priority=1, invocationCount=2)
	@Test(dataProvider="fetchValues")
	public void createleadmethod(String Cname, String fname, String lname, String phno) {
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(Cname);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fname);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lname);
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(phno);
		driver.findElement(By.name("submitButton")).click();

	}
	

}

//Under test
// provide filename and dataprovider=fetchValues
//This fecthValues is under BaseClass dataprovider
//This BaseClass dataprovider calls ReadExcel class



