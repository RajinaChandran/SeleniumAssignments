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
import org.openqa.selenium.interactions.Actions;

public class Myntra {

	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		option.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(option);
		driver.get(" https://www.myntra.com/ ");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		WebElement men = driver.findElement(By.xpath("(//a[@data-reactid=\"21\"])[1]"));
		Actions builder=new Actions(driver);
		builder.moveToElement(men).perform();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("(//a[text()='Jackets'])[1]")).click();
		driver.findElement(By.xpath("//a[@href=\"/men-jackets\"]")).click();
		
		String results = driver.findElement(By.xpath("//span[@class='title-count']")).getText();
		System.out.println(results);
		driver.findElement(By.xpath("(//label[@class='common-customCheckbox vertical-filters-label'])[1]")).click();
		driver.findElement(By.xpath("//div[@class='brand-more']")).click();
		driver.findElement(By.xpath("//input[@class='FilterDirectory-searchInput']")).sendKeys("Duke");
		driver.findElement(By.xpath("//label[@class=' common-customCheckbox']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']")).click();
		List<WebElement> dukeBrnd = driver.findElements(By.xpath("(//div[@class='filter-summary-filter'])[2]"));
		for (WebElement product:dukeBrnd) {
			System.out.println(product.getText());
		}
		driver.findElement(By.className("sort-sortBy")).click();
		driver.findElement(By.xpath("//label[text()='Better Discount']")).click();
		String text = driver.findElement(By.xpath("(//span[@class='product-discountedPrice'])[1]")).getText();
		System.out.println("Price of the first Product is: "+text);
		driver.findElement(By.xpath("//h4[text()='Puffer Jacket']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> listWindow=new ArrayList<String>(windowHandles);
		driver.switchTo().window(listWindow.get(1));
		System.out.println("Title of the new Window is: "+driver.getTitle());
		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
		File save=new File("./snap/img2.png");
		FileUtils.copyFile(screenshotAs, save);
		driver.findElement(By.xpath("//span[text()='Wishlist']")).click();
		Thread.sleep(3000);
		driver.close();
		driver.quit();
	}

}