package week4.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LearnWebTable {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://erail.in/ ");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.id("txtStationFrom")).clear();

		driver.findElement(By.id("txtStationFrom")).sendKeys("MAS");
		driver.findElement(By.id("txtStationTo")).clear();

		driver.findElement(By.id("txtStationTo")).sendKeys("MDU");
		driver.findElement(By.id("chkSelectDateOnly")).click();
		List<WebElement> trainnames = driver.findElements(
		By.xpath("//table[@class='DataTable TrainList TrainListHeader stickyTrainListHeader']//tr/td[2]"));
		System.out.println(trainnames.size());
		for (int i = 1; i < trainnames.size(); i++) {
			String text = trainnames.get(i).getText();
			System.out.println("Train Names Are:" + text);

		}
	}
}
