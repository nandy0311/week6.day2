package testcase.testcase;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EditLeadD6D2 extends BaseClassday6day2 {
	
	@BeforeTest
	public void setExcelFile() {
		filename="EditLead";	
	}
//@Test(priority=2)
	@Test(dataProvider="fetchValues")
	public  void editleadmethod(String editPhno, String editCname) throws InterruptedException {
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(editPhno);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(editCname);
		driver.findElement(By.name("submitButton")).click();
}
}






