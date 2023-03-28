package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LearnWindow {

	public static void main(String[] args) {
		ChromeOptions options= new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(options);
		driver.get(" https://www.irctc.co.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.xpath("(//label[ text()='FLIGHTS'])[2]")).click();
		System.out.println(driver.getTitle());
		Set<String> windowHandles = driver.getWindowHandles();
		List<String>list=new ArrayList<String>(windowHandles);
		driver.switchTo().window(list.get(1));
		System.out.println(driver.getTitle());
		driver.close();
		driver.switchTo().window(list.get(0));
		System.out.println(driver.getTitle());
		driver.quit();
		

	}

}

