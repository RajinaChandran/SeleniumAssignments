package week4.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LeaftapAlert {

	public static void main(String[] args) {
		ChromeOptions options= new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver=new ChromeDriver(options);
		driver.get("https://www.leafground.com/alert.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[1]")).click();
		Alert alert1 = driver.switchTo().alert();
		String text = alert1.getText();
		System.out.println(text);
		alert1.accept();
		
		driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[2]")).click();
		Alert comfirmalert = driver.switchTo().alert();
		String text1 = comfirmalert.getText();
		System.out.println(text1);
		comfirmalert.accept();
		
		driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[3]")).click();
		String text2 = driver.findElement(By.xpath("//p[contains(text(), 'You have clicked ')]")).getText();
		System.out.println(text2);
		driver.findElement(By.xpath("//span[text()='Dismiss']")).click();
			
		driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[5]")).click();
		String text4 = driver.findElement(By.xpath("(//p[@class='m-0'])[1]")).getText();
		System.out.println(text4);
		driver.findElement(By.xpath("(//span[@class='ui-icon ui-icon-closethick'])[2]")).click();
		
		driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[6]")).click();
		Alert promptalert = driver.switchTo().alert();
		String text3 = promptalert.getText();
		System.out.println(text3);
		promptalert.accept();
		
		driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[7]")).click();
		String text5 = driver.findElement(By.xpath("//span[@class='ui-confirm-dialog-message']")).getText();
		System.out.println(text5);
		driver.findElement(By.xpath("//span[text()='Yes']")).click();
		
		driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[8]")).click();
		String text6 = driver.findElement(By.xpath("(//p[@class='m-0'])[2]")).getText();
		System.out.println(text6);
		driver.findElement(By.xpath("(//span[@class='ui-icon ui-icon-closethick'])[3]")).click();
		driver.close();
	}
	

}
