package week4.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HtmlPrintValues {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://html.com/tags/table/");
		driver.manage().window().maximize();
		List<WebElement> list = driver.findElements(By.xpath("(//table)[1]//td"));
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			String print = list.get(i).getText();
			System.out.println(print);
		}
		driver.close();
		driver.quit();
	}


}
