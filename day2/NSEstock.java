package week4.day2;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class NSEstock {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.chittorgarh.com/ ");
		driver.manage().window().maximize();
		driver.findElement(By.id("navbtn_stockmarket")).click();
		driver.findElement(By.xpath("(//a[text()='NSE Bulk Deals'])[1]")).click();
		List<WebElement> names = driver.findElements(
				By.xpath("//table[@class='table table-bordered table-striped table-hover w-auto']//tr/td[1]"));
		System.out.println(names.size());
		Set<String> nameSet = new HashSet<String>();
		for (int i = 0; i < names.size(); i++) {
			String text = names.get(i).getText();
			nameSet.add(text);
			System.out.println(text);
			
		}
		System.out.println(nameSet.size());
		for (Object object : nameSet) {
			
			System.out.println(object);
			
		}
		driver.close();
		driver.quit();
		
		
	}

}
