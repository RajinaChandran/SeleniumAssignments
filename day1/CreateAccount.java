package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAccount {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Accounts")).click();
		driver.findElement(By.linkText("Create Account")).click();
		driver.findElement(By.xpath("//input[@id='accountName']")).sendKeys("Debit Limited Account");
		driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys("Selenium Automation Tester");
		driver.findElement(By.xpath("//input[@id='groupNameLocal']")).sendKeys("Raji");
		driver.findElement(By.xpath("//input[@id='officeSiteName']")).sendKeys("Testing");
		driver.findElement(By.xpath("//input[@id='annualRevenue']")).sendKeys("3,25,000");
		WebElement Industry = driver.findElement(By.name("industryEnumId"));
		Select drop1= new Select(Industry);
		drop1.selectByVisibleText("Computer Software");
		WebElement Ownership = driver.findElement(By.name("ownershipEnumId"));
		Select drop2= new Select(Ownership);
		drop2.selectByVisibleText("S-Corporation");
		WebElement source = driver.findElement(By.name("dataSourceId"));
		Select drop3= new Select(source);
		drop3.selectByValue("LEAD_EMPLOYEE");
		WebElement Marketingcompaign = driver.findElement(By.name("marketingCampaignId"));
		Select drop4=new Select(Marketingcompaign);
		drop4.selectByIndex(6);
		WebElement state_province = driver.findElement(By.id("generalStateProvinceGeoId"));
		Select drop5=new Select(state_province);
		drop5.selectByValue("TX");
		driver.findElement(By.xpath("//input[contains (@class,'smallSubmit')]")).click();
		driver.close();
	}
	

}
