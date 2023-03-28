package week4.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HtmlRowColumnCount {

	public static void main(String[] args) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			options.addArguments("--disable-notifications");
			ChromeDriver driver = new ChromeDriver(options);
			driver.get("https://html.com/tags/table/");
			driver.manage().window().maximize();
			List<WebElement> rowcount = driver.findElements(By.xpath("//table[@class='attributes-list']//tr"));
			System.out.println("Row Count:" +rowcount.size());
			List<WebElement> columncount = driver.findElements(By.xpath("//table[@class='attributes-list']//th"));
			System.out.println("Column count:" +  columncount.size());
			driver.close();
			driver.quit();
	
	}

}
