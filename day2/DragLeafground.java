package week4.day2;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class DragLeafground {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.leafground.com/drag.xhtml ");
		driver.manage().window().maximize();
		WebElement ele = driver.findElement(By.xpath("//div[@id='form:drop_header']"));
		WebElement drop = driver.findElement(By.xpath("//div[@id='form:drag_content']"));
		Actions builder=new Actions(driver);
		builder.dragAndDrop(drop, ele).perform();
		WebElement dragXY = driver.findElement(By.xpath("//div[@id='form:conpnl']"));
		builder.dragAndDropBy(dragXY, 150, 80).perform();
		driver.close();
		
		
	}

}
