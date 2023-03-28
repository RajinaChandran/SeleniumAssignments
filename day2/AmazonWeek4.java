package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AmazonWeek4 {

	private static String text;

	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.amazon.in/ ");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9pro");
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		WebElement firstprice = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]"));
		System.out.println("Price of first phone is:" + firstprice.getText());
		String Phone = driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]"))
				.getText();
		System.out.println("Phone Brand:" + Phone);

		driver.findElement(By.xpath("(//i[@class='a-icon a-icon-star-small a-star-small-4 aok-align-bottom'])[1]"))
				.click();
		Thread.sleep(2000);
		String fivestarcent = driver
				.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-beside-button a-text-bold']"))
				.getText();
		System.out.println(fivestarcent);
		driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();

		Set<String> windowHandles = driver.getWindowHandles();
		List<String> phone = new ArrayList<String>(windowHandles);
		driver.switchTo().window(phone.get(1));
		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);

		File target = new File("./Screenshot/img.png");
		FileUtils.copyFile(screenshotAs, target);
		System.out.println("Clicked Snapshot");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		Thread.sleep(5000);
		String subtotal = driver.findElement(By.xpath("//span[@id='attach-accessory-cart-subtotal']")).getText();

		System.out.println(subtotal);
		if (text != subtotal) {
			System.out.println("Verified the amount");
		} else {
			System.out.println("Mismatch Verify it again");
		}
driver.close();
driver.quit();
	}
}
