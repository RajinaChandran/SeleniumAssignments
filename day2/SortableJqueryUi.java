package week4.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class SortableJqueryUi {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://jqueryui.com/sortable/ ");
		driver.manage().window().maximize();
		driver.switchTo().frame(0);
		WebElement item2 = driver.findElement(By.xpath("//li[text()='Item 2']"));
		WebElement item4 = driver.findElement(By.xpath("//li[text()='Item 4']"));
		WebElement item5 = driver.findElement(By.xpath("//li[text()='Item 5']"));
		WebElement item3 = driver.findElement(By.xpath("//li[text()='Item 3']"));
		Actions builder=new Actions(driver);
		builder.dragAndDrop(item4, item2).perform();	
		builder.dragAndDrop(item5, item3).perform();
		driver.switchTo().defaultContent();
		driver.close();
		
	}

}
