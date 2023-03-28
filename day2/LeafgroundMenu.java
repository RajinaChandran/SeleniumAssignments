package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class LeafgroundMenu {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://www.leafground.com/menu.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		WebElement RightClick = driver.findElement(By.xpath("//button[@id='j_idt87:j_idt144_button']"));
		Actions builder = new Actions(driver);
		builder.contextClick(RightClick).perform();
		builder.contextClick(RightClick).perform();
		Thread.sleep(2000);
		builder.click(RightClick).perform();
		Thread.sleep(2000);
		WebElement ele = driver.findElement(By.xpath("//h5[text()='Context Menu']"));
		builder.contextClick(ele).perform();
		Thread.sleep(2000);
		builder.click(ele).perform();
		// driver.close();

	}

}
