package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ClassLead {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
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
		WebElement source = driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select drop1 = new Select(source);
		drop1.selectByVisibleText("Employee");
		WebElement marketingCampaign = driver.findElement(By.id("createLeadForm_marketingCampaignId"));
		Select drop2 = new Select(marketingCampaign);
		drop2.selectByValue("9001");
		WebElement Ownership = driver.findElement(By.id("createLeadForm_ownershipEnumId"));
		Select drop3 = new Select(Ownership);
		drop3.selectByIndex(5);
		WebElement Country = driver.findElement(By.id("createLeadForm_generalCountryGeoId"));
		Select drop4 = new Select(Country);
		drop4.selectByVisibleText("India");
		driver.findElement(By.name("submitButton")).click();
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
		driver.close();

	}
}
