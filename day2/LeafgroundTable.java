package week4.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LeafgroundTable {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://leafground.com/table.xhtml ");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		List<WebElement> name = driver.findElements(By.xpath("(//table[@role='grid'])[2]//tr/td[1]"));
		System.out.println(name.size());
		for (int i = 0; i < name.size(); i++) {
			String text = name.get(i).getText();
			System.out.println("Customer names are:" +  text);
			
		}
		driver.close();
	}

}
