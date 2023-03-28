package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LeaftapWindow {

	public static void main(String[] args) {
		ChromeOptions options= new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(options);
		driver.get(" https://www.leafground.com/window.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[1]")).click();
		driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[2]")).click();
		driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[3]")).click();
		driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[4]")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String>list=new ArrayList<String>(windowHandles);
		driver.switchTo().window(list.get(1));
		System.out.println(driver.getTitle());
		driver.close();
		driver.switchTo().window(list.get(0));
		
		driver.switchTo().window(list.get(2));
		System.out.println(driver.getTitle());
		driver.close();
		driver.switchTo().window(list.get(0));
		
		driver.switchTo().window(list.get(3));
		System.out.println(driver.getTitle());
		driver.close();
		driver.switchTo().window(list.get(0));
		
		driver.switchTo().window(list.get(4));
		System.out.println(driver.getTitle());
		driver.close();
		driver.switchTo().window(list.get(0));
		driver.close();
		

		
	}

}
