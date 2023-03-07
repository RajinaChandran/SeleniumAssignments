package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class DuplicateLead {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Rajina");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Chandran");
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Raji");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Banking Sector");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Mortage Loan, Gold Loan and Startup Loan");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("rajinachandran@gmail.com");
		driver.findElement(By.name("submitButton")).click();
		Thread.sleep(2000);
		String title = driver.getTitle();
		System.out.println(title);
		System.out.println(driver.getTitle());
		driver.findElement(By.linkText("Duplicate Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).clear();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("CanaraBank");
		driver.findElement(By.id("createLeadForm_firstName")).clear();
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Raja");
		driver.findElement(By.name("submitButton")).click();
		System.out.println(driver.getTitle());
		driver.close();
		
		
	
	}

}
