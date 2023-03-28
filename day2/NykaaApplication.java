package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class NykaaApplication {
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.nykaa.com/ ");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		WebElement brand = driver.findElement(By.xpath("//a[text()='brands']"));
		Actions builder = new Actions(driver);
		builder.moveToElement(brand).perform();
		driver.findElement(By.xpath("//*[@id=\"scroller-container\"]/div[7]/a")).click();
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//*[@id=\"filter-sort\"]/div/div/button/span")).click();
		driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
		driver.findElement(By.xpath("//div[@id='first-filter']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[text()='Hair Care'])[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"custom-scroll\"]/ul/li/ul/li/ul/li[2]/div/label")).click();
		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		driver.findElement(By.xpath("//span[text()='Color Protection']")).click();
		String text = driver.findElement(By.xpath("//div[@class='css-rtde4j']")).getText();
		System.out.println("Filter Applied: " + text);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='css-xrzmfa']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> listwindow = new ArrayList<String>(windowHandles);
		driver.switchTo().window(listwindow.get(1));
		driver.findElement(By.xpath("//span[text()='180ml']")).click();
		driver.findElement(By.xpath("(//span[@class='btn-text'])[1]")).click();
		driver.findElement(By.xpath("//button[@class='css-g4vs13']")).click();
		driver.switchTo().frame(0);
		 String text2 = driver.findElement(By.xpath("//span[@class='css-1um1mkq e171rb9k3']")).getText();
		System.out.println("Total Amount:" + text2);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[@class='css-1j2bj5f e8tshxd0'])[2]")).click();

	}

}
