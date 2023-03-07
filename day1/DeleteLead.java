package week2.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.name("phoneNumber")).sendKeys("9010203040");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		String title = driver.getTitle();
		System.out.println(title);
		// System.out.println(title);
		driver.findElement(By.xpath("//a[text()='15853']")).click();
		String text = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		// System.out.println("Text =>>>>>>>>>>>>>>>>>> " + text);
		String recordNo = text.substring(text.indexOf("(") + 1, text.indexOf(")"));
		// System.out.println("companyNo =>>>>>>>>>>>>>>>>>> " + recordNo);

		driver.findElement(By.className("subMenuButtonDangerous")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(recordNo);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);

		String message = driver.findElement(By.className("x-paging-info")).getText();
		System.out.println("Message : " + message);

		if (message.equalsIgnoreCase("No records to display")) {
			System.out.println("text matched");
		} else {
			System.out.println("text not matched");
		}

	}

}
